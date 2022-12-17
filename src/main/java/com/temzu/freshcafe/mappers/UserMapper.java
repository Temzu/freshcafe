package com.temzu.freshcafe.mappers;

import com.temzu.freshcafe.dtos.SignUpRequestDto;
import com.temzu.freshcafe.dtos.UserDto;
import com.temzu.freshcafe.entities.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

  private final ModelMapper mapper;

  public User toUser(SignUpRequestDto signUpRequestDto) {
    return mapper.map(signUpRequestDto, User.class);
  }

  public User toUser(UserDto userDto) {
    return mapper.map(userDto, User.class);
  }

  public UserDto toUserDto(User user) {
    return mapper.map(user, UserDto.class);
  }
}
