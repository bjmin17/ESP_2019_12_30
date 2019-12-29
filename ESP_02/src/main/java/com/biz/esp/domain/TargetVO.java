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
public class TargetVO {
	
	
	
	private String pt_tcode;//	varchar2(5 byte)
	private String pt_title;//	nvarchar2(50 char)
	private String pt_bpurpose;//	nvarchar2(1000 char)
	private String pt_btarget;//	nvarchar2(1000 char)
	private String pt_binfo;//	nvarchar2(1000 char)
	private String pt_parti;//	nvarchar2(125 char)
	private String pt_contact;//	nvarchar2(125 char)
	
	

}
