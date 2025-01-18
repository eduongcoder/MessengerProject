package com.example.demo.configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.Map;
public class CustomAuthenticationConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    private final String REALM="scope";
    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {
        String realm=source.getClaim("scope");

        
        return List.of();
    }
    
    public String getScope(Jwt source) {
    	String realm=source.getClaim("scope");
    	return realm;
    }
}
