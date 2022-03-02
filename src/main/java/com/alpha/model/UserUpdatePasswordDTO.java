package com.alpha.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public @Data class UserUpdatePasswordDTO {

	private String currentpassword;
	private String newpassword;
	private String retypenewpassword;
}
