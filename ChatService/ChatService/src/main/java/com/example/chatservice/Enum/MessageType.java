package com.example.chatservice.Enum;

public enum MessageType {
    Message, File, Image;
    public static MessageType fromString(String type) {
        for (MessageType messageType : MessageType.values()) {
            if (messageType.name().equalsIgnoreCase(type)) { // Ignore case if needed
                return messageType;
            }
        }
        throw new IllegalArgumentException("Invalid MessageType: " + type);
    }
}
