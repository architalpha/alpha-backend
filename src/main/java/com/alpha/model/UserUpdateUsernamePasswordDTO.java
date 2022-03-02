package com.alpha.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public @Data class UserUpdateUsernamePasswordDTO {

	private String username;
	private String password;
}
