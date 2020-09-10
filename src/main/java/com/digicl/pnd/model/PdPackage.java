package com.digicl.pnd.model;
import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="pd_package")
public class PdPackage extends BaseEntity implements Serializable{ 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name="package_id")
    private Long packageId;
    
    @Column(name="package_name")
    private String packageName;
    
    @Column(name="package_audience")
    private String packageAudience;
    
    @Column(name="package_duration")
    private String packageDuration;
    
    @Column(name="num_of_passenger")
    private BigInteger numOfPassenger;
    
    @Column(name="num_of_vehicle")
    private BigInteger numOfVehicle;
    
    @Column(name="num_of_driver")
    private BigInteger numOfDriver;
    
    @Column(name="num_of_notification")
    private BigInteger numOfNotification;
    
    @Column(name="package_price")
    private Double packagePrice;
    
}