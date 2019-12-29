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
public class OpinionDTO {
	private long o_seq;//	number
	private String o_title;//	nvarchar2(125 char)
	private String o_email;//	nvarchar2(50 char)
	private String o_content;//	nvarchar2(1000 char)
	private String o_date;//	nvarchar2(10 char)
	private String o_file;//	nvarchar2(255 char)
	private String o_division;//	nvarchar2(125 char)
}
