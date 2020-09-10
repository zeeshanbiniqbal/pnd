package com.digicl.pnd.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="pd_service_provider")
public class ServiceProvider extends BaseEntity implements Serializable{ 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    @Column(name="sp_id")
    private Long spId;
    
    @Column(name="sp_name")
    private String spName;
    
    @Column(name="sp_contact_person")
    private String spContactPerson;
    
    @Column(name="sp_contact_number")
    private String spContactNumber;
    
    @Column(name="sp_other_number")
    private String spOtherNumber;
    
    @Column(name="sp_email")
    private String spEmail;
    
    @Column(name="sp_other_email")
    private String spOtherEmail;
    
    @JsonIgnore
    @Column(name="sp_password")
    private String spPassword;
    
    @Column(name="sp_otp")
    private String spOtp;
    
    @Column(name="sp_pass_change_due")
    private String spPassChangeDue;
    
    @Column(name="sp_status")
    private String spStatus;
    
    @Column(name="sp_address")
    private String spAddress;
    
    @Column(name="sp_package_expiry")
    @Temporal(TemporalType.TIMESTAMP)
    private Date spPackageExpiry;
    
    @Column(name="sp_type")
    private String spType;
    
    @Column(name="approval_status")
    private String approvalStatus;
    
    @JsonIgnore
    @Lob
    @Column(name="old_value")
    private String oldValue;
    
    @JsonIgnore
    @Lob
    @Column(name="new_value")
    private String newValue;
    
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="package_id", referencedColumnName="package_id")
    private PdPackage packageId;
    
}