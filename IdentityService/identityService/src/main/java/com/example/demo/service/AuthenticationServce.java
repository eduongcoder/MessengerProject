package com.example.demo.service;

import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.IntrospectRequest;
import com.example.demo.dto.request.LogoutRequest;
import com.example.demo.dto.respone.IntrospectRespone;
import com.example.demo.entity.InvalidatedToken;
import com.example.demo.exception.AppException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.repository.InvalidateTokenRepository;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.SignedJWT;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AuthenticationServce {
	
	InvalidateTokenRepository invalidateTokenRepository;
	
	@NonFinal
	@Value("${app.security.signer-key}")
	private String signerKey;
	
	@NonFinal
	@Value("${app.security.valid-duration}")
	private long VALID_DURATION;

	@NonFinal
	@Value("${app.security.refreshable-duration}")
	private long REFRESHABLE_DURATION;
	
	public IntrospectRespone introspectRespone(IntrospectRequest request) throws JOSEException, ParseException {
		var token = request.getToken();

		boolean isValid = true;
		try {
			verifyToken(token, false);

		} catch (AppException e) {
			isValid = false;
		}

		return IntrospectRespone.builder().Valid(isValid).build();

	}
	
	private SignedJWT verifyToken(String token, boolean isRefresh) throws JOSEException, ParseException {

		JWSVerifier verifier = new MACVerifier(signerKey.getBytes());

		SignedJWT signedJWT = SignedJWT.parse(token);

		Date expiryTime = (isRefresh)
				? new Date(signedJWT.getJWTClaimsSet().getIssueTime().toInstant()
						.plus(REFRESHABLE_DURATION, ChronoUnit.SECONDS).toEpochMilli())
				: signedJWT.getJWTClaimsSet().getExpirationTime();

		var verified = signedJWT.verify(verifier);

		if (!verified && expiryTime.after(new Date())) {
			throw new AppException(ErrorCode.UNAUTHENTICATED);
		}

		if (invalidateTokenRepository.existsById(signedJWT.getJWTClaimsSet().getJWTID())) {
			throw new AppException(ErrorCode.UNAUTHENTICATED);
		}

		return signedJWT;
	}
	
	public void logout(LogoutRequest request) throws JOSEException, ParseException {
		try {
			var signToken = verifyToken(request.getToken(), false);

			String jit = signToken.getJWTClaimsSet().getJWTID();
			Date expiryTime = signToken.getJWTClaimsSet().getExpirationTime();

			InvalidatedToken invalidatedToken = InvalidatedToken.builder().id(jit).expiryTime(expiryTime).build();

			invalidateTokenRepository.save(invalidatedToken);
		} catch (AppException e) {
			log.info("Token already expired");
		}
	}

}
