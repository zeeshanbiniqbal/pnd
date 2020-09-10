package com.digicl.pnd.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name="pd_push_notify")
public class PushNotify extends BaseEntity implements Serializable{ 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name="push_id")
    private Long pushId;
    
    @Column(name="push_title")
    private String pushTitle;
    
    @Column(name="push_message")
    private String pushMessage;
    
    @Column(name="push_os")
    private String pushOs;
    
    @Column(name="push_user_type")
    private String pushUserType;
    
    @Column(name="push_date", table="pd_push_notify")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pushDate;
    
    @Column(name="push_status")
    private String pushStatus;
    
}