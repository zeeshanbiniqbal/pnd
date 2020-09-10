package com.digicl.pnd.model;
import java.io.Serializable;

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
@Table(name="pd_sp_vehicle")
public class Vehicle extends BaseEntity implements Serializable{ 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    @Column(name="vehicle_id")
    private Long vehicleId;
    
    @Column(name="vehicle_make")
    private String vehicleMake;
    
    @Column(name="vehicle_model")
    private String vehicleModel;
    
    @Column(name="vehicle_color")
    private String vehicleColor;
    
    @Column(name="vehicle_facilities")
    private String vehicleFacilities;
    
    @Column(name="vehicle_type")
    private String vehicleType;
    
    @Column(name="vehicle_seats")
    private String vehicleSeats;
    
    @Column(name="vehicle_reg_number")
    private String vehicleRegNumber;
    
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
    
    @ManyToOne
    @JoinColumn(name="driver_id", referencedColumnName="driver_id")
    private Driver driverId;

}