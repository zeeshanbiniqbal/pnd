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
@Table(name="pd_complaints")
public class Complaint implements Serializable{ 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name="complaints_id")
    private Long complaintsId;
    
    @Column(name="remarks")
    private String remarks;
    @Lob
    
    @Column(name="remarks_history")
    private String remarksHistory;
    
    @Column(name="complaint_from")
    private String complaintFrom;
    
    @Column(name="complaint_status")
    private String complaintStatus;
    
    @ManyToOne
    @JoinColumn(name="parent_id", referencedColumnName="parent_id")
    private Parent parentId;
    
    @ManyToOne
    @JoinColumn(name="sp_id", referencedColumnName="sp_id")
    private ServiceProvider spId;

}