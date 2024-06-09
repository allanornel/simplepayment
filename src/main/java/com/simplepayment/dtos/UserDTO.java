package com.simplepayment.dtos;

import com.simplepayment.domain.user.EUserType;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document, BigDecimal balance, String email,
                      String password, EUserType userType) {
}
