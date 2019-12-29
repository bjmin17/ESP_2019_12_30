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

public class ReferenceDTO {

	private long d_seq;//	number
	private String d_title;//	nvarchar2(125 char)
	private String d_content;//	nvarchar2(1000 char)
	private String d_writer;//	nvarchar2(25 char)
	private String d_date;//	nvarchar2(10 char)
	private String d_file;//	nvarchar2(255 char)
	
	
	
}
