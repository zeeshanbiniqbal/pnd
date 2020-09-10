package com.digicl.pnd.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name="pd_leaves")
public class Leave extends BaseEntity implements Serializable{ 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    @Column(name="leave_id")
    private Long leaveId;
    
    @Column(name="date_from")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFrom;
    
    @Column(name="date_to")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTo;
    
    @Column(name="remarks")
    private String remarks;
    
    @Column(name="message")
    private String message;
    
    @Column(name="approval_status")
    private String approvalStatus;
    @Lob
    
    @Column(name="old_value")
    private String oldValue;
    @Lob
    
    @Column(name="new_value")
    private String newValue;
    
    @ManyToOne
    @JoinColumn(name="dependent_id", referencedColumnName="dependent_id")
    private Dependent dependentId;

    @ManyToOne
    @JoinColumn(name="vehicle_id", referencedColumnName="vehicle_id")
    private Vehicle vehicleId;

}