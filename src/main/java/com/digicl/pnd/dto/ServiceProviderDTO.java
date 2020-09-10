package com.digicl.pnd.dto;

import java.util.Date;

import com.digicl.pnd.model.PdPackage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ServiceProviderDTO {
	
	public ServiceProviderDTO(Long id) {
		super();
		this.spId = id;
	}

	private Long spId;
	private String spName;
	private String spContactPerson;
	private String spContactNumber;
	private String spOtherNumber;
	private String spEmail;
	private String spPassword;
	private String spOtherEmail;
	private String spStatus;
	private String spAddress;
	private Date spPackageExpiry;
	private String spType;
	private String approvalStatus;
	private PdPackage packageId;

}
