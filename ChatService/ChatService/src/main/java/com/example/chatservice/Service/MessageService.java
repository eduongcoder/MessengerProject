package com.example.chatservice.Service;

import com.example.chatservice.Dto.Request.MessageRequest;
import com.example.chatservice.Dto.Response.MessageResponse;
import com.example.chatservice.Entity.Message;
import com.example.chatservice.Entity.Room;
import com.example.chatservice.Entity.UserMember;
import com.example.chatservice.Enum.MessageStatus;
import com.example.chatservice.Enum.MessageType;
import com.example.chatservice.Exception.AppException;
import com.example.chatservice.Exception.ErrorCode;
import com.example.chatservice.Form.MessageUpdate;
import com.example.chatservice.Mapper.MessageMapper;
import com.example.chatservice.Mapper.UserMemberMapper;
import com.example.chatservice.Repository.MessageRepository;
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
public class MessageService {
    RoomRepository roomRepository;
    UserMemberMapper userMemberMapper;
     UserMemberRepository userMemberRepository;
    MessageMapper messageMapper;
    MessageRepository messageRepository;

    public List<MessageResponse> getMessagesInRoom(String roomId){
        return messageRepository.findByRoom_IdRoom(roomId).stream()
                .map(messageMapper::toMessageResponse).collect(Collectors.toList());
    }
    public MessageResponse createMessage(MessageRequest request){
        Message message =messageMapper.toMessage(request);
        Room room=roomRepository.findById(request.getRoom())
                .orElseThrow(()->new AppException(ErrorCode.NOTFOUND_ROOM));
        UserMember userMember=userMemberRepository.findById(request.getSender())
                .orElseThrow(()->new AppException(ErrorCode.NOTFOUND_USER_MEMBER));
        message.setRoom(room);
        message.setType(MessageType.fromString(request.getType()).toString());
        message.setStatus(MessageStatus.Pending.toString());
        message.setSender(userMember);
        message.setSentAt(LocalDateTime.now());
        message=messageRepository.save(message);
        return messageMapper.toMessageResponse(message);
    }

    public MessageResponse UpdateMessage(MessageUpdate request, String messageId){
        Message message=messageRepository.findById(messageId)
               .orElseThrow(() -> new AppException(ErrorCode.NOTFOUND_MESSAGE));
        message.setMessage(request.getMessage());
        message.setUpdateAt(LocalDateTime.now());
        message=messageRepository.save(message);
        return messageMapper.toMessageResponse(message);
    }
    public String deletedMessage(String messageId){
        messageRepository.findById(messageId)
                .orElseThrow(()->new AppException(ErrorCode.NOTFOUND_MESSAGE));
         messageRepository.deleteById(messageId);
        return messageId;
    }
}
