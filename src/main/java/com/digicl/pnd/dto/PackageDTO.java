package com.digicl.pnd.dto;

import java.math.BigInteger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PackageDTO {
	
	public PackageDTO(Long id) {
		super();
		this.packageId = id;
	}

    private Long packageId;
    private String packageName;
    private String packageAudience;
    private String packageDuration;
    private BigInteger numOfPassenger;
    private BigInteger numOfVehicle;
    private BigInteger numOfDriver;
    private BigInteger numOfNotification;
    private Double packagePrice;

}
