package com.digicl.pnd.model;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="pd_parents")
public class Parent implements Serializable{ 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name="parent_id")
    private Long parentId;
    
    @Column(name="parent_name")
    private String parentName;
    
    @Column(name="parent_cnic")
    private String parentCnic;
    
    @Column(name="parent_email")
    private String parentEmail;
    
    @Column(name="parent_gender")
    private String parentGender;
    
    @Column(name="parent_age")
    private String parentAge;
    
    @Column(name="parent_contact")
    private String parentContact;
    
    @Column(name="parent_other_contact")
    private String parentOtherContact;
    
    @Column(name="parent_payment_status")
    private String parentPaymentStatus;
    
    @Column(name="parent_wallet_amount")
    private BigDecimal parentWalletAmount;
    
    @Column(name="parent_status")
    private String parentStatus;
    
    @Column(name="parent_address")
    private String parentAddress;
    
    @Column(name="parent_rating")
    private String parentRating;
    
    @Column(name="parent_device_os")
    private String parentDeviceOs;
    
    @Column(name="parent_device_uuid")
    private String parentDeviceUuid;
    
    @Column(name="parent_device_token")
    private String parentDeviceToken;
    
    @ManyToOne
    @JoinColumn(name="package_id", referencedColumnName="package_id")
    private PdPackage packageId;
    
}