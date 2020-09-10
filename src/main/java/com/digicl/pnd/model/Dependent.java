package com.digicl.pnd.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="pd_dependents")
public class Dependent implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name="dependent_id")
    private Long dependentId;
    
    @Column(name="dependent_name")
    private String dependentName;
    
    @Column(name="dependent_cnic")
    private String dependentCnic;
    
    @Column(name="dependent_email")
    private String dependentEmail;
    
    @Column(name="dependent_gender")
    private String dependentGender;
    
    @Column(name="dependent_age")
    private String dependentAge;
    
    @Column(name="dependent_contact")
    private String dependentContact;
    
    @Column(name="dependent_other_contact")
    private String dependentOtherContact;
    
    @Column(name="dependent_pickup_location")
    private String dependentPickupLocation;
    
    @Column(name="dependent_pickup_latlng")
    private String dependentPickupLatlng;
    
    @Column(name="dependent_pickup_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dependentPickupTime;
    
    @Column(name="dependent_drop_location")
    private String dependentDropLocation;
    
    @Column(name="dependent_drop_latlng")
    private String dependentDropLatlng;
    
    @Column(name="dependent_drop_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dependentDropTime;
    
    @Column(name="dependent_status")
    private String dependentStatus;
    
    @Column(name="remarks")
    private String remarks;
    
    @ManyToOne
    @JoinColumn(name="vehicle_id", referencedColumnName="vehicle_id")
    private Vehicle vehicleId;
    
}