package com.digicl.pnd.model;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="pd_sp_driver")
public class Driver extends BaseEntity implements Serializable{ 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    @Column(name="driver_id")
    private Long driverId;
    
    @Column(name="driver_name")
    private String driverName;
    
    @Column(name="driver_cnic")
    private String driverCnic;
    
    @Column(name="driver_license_num")
    private String driverLicenseNum;
    
    @Column(name="driver_contact_number")
    private String driverContactNumber;
    
    @Column(name="driver_other_number")
    private String driverOtherNumber;
    
    @Column(name="driver_age")
    private String driverAge;
    
    @Column(name="driver_gender")
    private String driverGender;
    
    @Column(name="driver_email")
    private String driverEmail;
    
    @Column(name="driver_address")
    private String driverAddress;
    
    @Column(name="driver_avg_rating")
    private BigDecimal driverAvgRating;
    
    @Column(name="approval_status")
    private String approvalStatus;
    @Lob
    
    @Column(name="old_value")
    private String oldValue;
    @Lob
    
    @Column(name="new_value")
    private String newValue;
    
    @ManyToOne
    @JoinColumn(name="sp_id", referencedColumnName="sp_id")
    private ServiceProvider spId;
    
}