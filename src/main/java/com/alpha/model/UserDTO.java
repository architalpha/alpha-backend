package com.alpha.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public @Data class UserDTO {

	private String username;
	private String email;
}
