package com.biz.esp.domain;

import com.biz.esp.domain.PaginationDTO.PaginationDTOBuilder;

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
public class AreaDTO {
	
	private long pa_seq;//	number
	private String pa_acode;//	varchar2(7 byte)
	private String pa_title;//	nvarchar2(125 char)
	private String pa_bpurpose;//	nvarchar2(1000 char)
	private String pa_btarget;//	nvarchar2(1000 char)
	private String pa_binfo;//	nvarchar2(1000 char)
	private String pa_parti;//	nvarchar2(500 char)
	private String pa_contact;//	nvarchar2(500 char)
	
}
