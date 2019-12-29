package com.biz.esp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class UserDTO {

	private String u_id;
	private String u_password;
	private String u_name;
	private String u_email;
	private String u_addr;
	private String u_tel;
}
