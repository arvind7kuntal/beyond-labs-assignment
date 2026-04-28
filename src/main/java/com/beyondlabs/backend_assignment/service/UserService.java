package com.beyondlabs.backend_assignment.service;

import com.beyondlabs.backend_assignment.dto.UserRequestDto;
import com.beyondlabs.backend_assignment.dto.UserResponseDto;


import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto getUserById(Long id);
     List<UserResponseDto> getAllUsers();
    UserResponseDto updateUser(Long id, UserRequestDto userRequestDto);
     void deleteUser(Long id);

}
