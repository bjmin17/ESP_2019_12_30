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
public class NewsDTO {

	private long n_seq;//	number	not null	pk
	private String n_title;//	nvarchar2(125)	not null	
	private String n_content;//	nvarchar2(1000)	not null	
	private String n_writer;//	nvarchar2(25)	not null	
	private String n_date;//	nvarchar2(10)	not null	
	private String n_file;//	nvarchar2(255)		
	private String n_division;//	nVARCHAR2(125)	NOT NULL	

}
