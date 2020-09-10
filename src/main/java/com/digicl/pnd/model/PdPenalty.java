package com.digicl.pnd.model;
import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="pd_penalties")
public class PdPenalty extends BaseEntity implements Serializable{ 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    @Column(name="penalty_id")
    private Long penaltyId;
	
    @Column(name="penalty_name")
    private String penaltyName;
    
    @Column(name="penalty_reason")
    private String penaltyReason;
    
    @Column(name="penalty_deduction")
    private Double penaltyDeduction;
    
}