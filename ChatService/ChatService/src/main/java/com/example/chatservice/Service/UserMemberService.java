package com.example.chatservice.Service;

import com.example.chatservice.Dto.Request.UserMemberRequest;
import com.example.chatservice.Dto.Response.UserMemberResponse;
import com.example.chatservice.Entity.Room;
import com.example.chatservice.Entity.UserMember;
import com.example.chatservice.Exception.AppException;
import com.example.chatservice.Exception.ErrorCode;
import com.example.chatservice.Form.UserMemberUpdate;
import com.example.chatservice.Mapper.UserMemberMapper;
import com.example.chatservice.Repository.RoomRepository;
import com.example.chatservice.Repository.UserMemberRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserMemberService {
    RoomRepository roomRepository;
    UserMemberMapper userMemberMapper;
     UserMemberRepository userMemberRepository;

    public List<UserMemberResponse> getUsersInRoom(String roomId){
        return userMemberRepository.findByRoom_IdRoom(roomId).stream()
                .map(userMemberMapper::toUserMemberResponse).collect(Collectors.toList());
    }
    public UserMemberResponse createUserMember(UserMemberRequest request){
        UserMember userMember =userMemberMapper.toUserMember(request);
        Room room=roomRepository.findById(request.getRoom())
                .orElseThrow(()->new AppException(ErrorCode.NOTFOUND_ROOM));
        userMember.setRoom(room);
        userMember.setCreateAt(LocalDateTime.now());
        userMember=userMemberRepository.save(userMember);
        return userMemberMapper.toUserMemberResponse(userMember);
    }
    public UserMemberResponse changeUserMemberName(UserMemberUpdate request, String userMemberid){
        UserMember userMember=userMemberRepository.findById(userMemberid)
               .orElseThrow(() -> new AppException(ErrorCode.NOTFOUND_USER_MEMBER));
        userMember.setNameUser(request.getNameUser());
        userMember.setUpdateAt(LocalDateTime.now());
        userMember=userMemberRepository.save(userMember);
        return userMemberMapper.toUserMemberResponse(userMember);
    }
}
