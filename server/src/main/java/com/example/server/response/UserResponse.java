package com.example.server.response;

import com.example.server.entity.UserEntity;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserResponse extends BaseResponse {
        public UserResponse(boolean success, String message, UserEntity user){
            super(success,message);
            this.user=user;
        }
        public UserResponse(UserEntity user){
            super(true, "User data");}
    private UserEntity user;
}
