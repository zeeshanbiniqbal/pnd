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
@Table(name="pd_push_notify_detail")
public class PushNotifyDetail implements Serializable{ 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    @Column(name="push_detail_id")
    private Long pushDetailId;
    
    @Column(name="sent_status")
    private String sentStatus;
    
    @ManyToOne
    @JoinColumn(name="parent_id", referencedColumnName="parent_id")
    private Parent parentId;
    
    @ManyToOne
    @JoinColumn(name="push_id", referencedColumnName="push_id")
    private PushNotify pushId;
    
    @ManyToOne
    @JoinColumn(name="sp_id", referencedColumnName="sp_id")
    private ServiceProvider spId;

}