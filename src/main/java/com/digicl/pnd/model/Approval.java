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
@Table(name="pd_approval")
public class Approval implements Serializable{ 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name="approval_id")
    private Long approvalId;   
    
    @Column(name="first_approval_status")
    private String firstApprovalStatus;
      
    @Column(name="first_approval_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstApprovalTime;
        
    @Column(name="second_approval_status")
    private String secondApprovalStatus;
      
    @Column(name="second_approval_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date secondApprovalTime;
       
    @Column(name="approval_status")
    private String approvalStatus;
       
    @Column(name="approval_remarks")
    private String approvalRemarks;
       
    @Column(name="request_date")
    private String requestDate;
    
    @Column(name="functionality")
    private String functionality;
    
    @ManyToOne
    @JoinColumn(name="driver_id", referencedColumnName="driver_id")
    private Driver driverId;
    
    @ManyToOne
    @JoinColumn(name="leaves_id", referencedColumnName="leave_id")
    private Leave leavesId;
    
    @ManyToOne
    @JoinColumn(name="sp_id", referencedColumnName="sp_id")
    private ServiceProvider spId;
    
    @ManyToOne
    @JoinColumn(name="vehicle_id", referencedColumnName="vehicle_id")
    private Vehicle vehicleId;

}