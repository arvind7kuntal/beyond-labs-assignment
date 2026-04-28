package com.beyondlabs.backend_assignment.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    @NotBlank(message ="name must not be blank")
    private String name;
    @NotBlank(message = "email must not be blank")
    @Email(message = "Invalid email format")
    private String email;
   @NotBlank(message = "phone number must not be blank")
    private String phone;
}
