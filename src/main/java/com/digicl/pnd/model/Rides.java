package com.digicl.pnd.model;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="pd_rides")
public class Rides implements Serializable{ 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    @Column(name="ride_id")
    private Long rideId;
    
    @Column(name="pickup_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pickupTime;
    
    @Column(name="drop_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dropTime;
    
    @Column(name="pick_status")
    private String pickStatus;
    
    @Column(name="drop_status")
    private String dropStatus;
    
    @Column(name="ride_status")
    private String rideStatus;
    
    @Column(name="ride_type")
    private String rideType;
    
    @Column(name="feedback")
    private String feedback;
    
    @Column(name="rating")
    private BigDecimal rating;
    
    @ManyToOne
    @JoinColumn(name="dependent_id", referencedColumnName="dependent_id")
    private Dependent dependentId;
    
    @ManyToOne
    @JoinColumn(name="vehicle_id", referencedColumnName="vehicle_id")
    private Vehicle vehicleId;

}