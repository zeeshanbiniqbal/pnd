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
@Table(name="pd_documents")
public class Document extends BaseEntity implements Serializable{ 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    @Column(name="doc_id")
    private Long docId;
    
    @Column(name="doc_address")
    private String docAddress;
    
    @Column(name="doc_type")
    private String docType;
    
    @Column(name="upload_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadTime;
    
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
    @JoinColumn(name="driver_id", referencedColumnName="driver_id")
    private Driver driverId;
    
    @ManyToOne
    @JoinColumn(name="vehicle_id", referencedColumnName="vehicle_id")
    private Vehicle vehicleId;

}