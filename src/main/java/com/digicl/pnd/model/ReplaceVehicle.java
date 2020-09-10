package com.digicl.pnd.model;
import java.io.Serializable;

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
@Table(name="pd_sp_replace_vehicle")
public class ReplaceVehicle extends BaseEntity implements Serializable{ 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name="replace_id")
    private Long replaceId;
    
    @Column(name="remarks")
    private String remarks;
    
    @Column(name="approval_status")
    private String approvalStatus;
    
    @ManyToOne
    @JoinColumn(name="vehicle_from", referencedColumnName="vehicle_id")
    private Vehicle vehicleFrom;
    
    @ManyToOne
    @JoinColumn(name="vehicle_to", referencedColumnName="vehicle_id")
    private Vehicle vehicleTo;

}