package com.digicl.pnd.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.digicl.pnd.security.customuserdetails.CustomUserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Basic(optional=false)
    @Column(name="created_time", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    
    @Basic(optional=false)
    @Column(name="modified_time", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedTime;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="created_by", referencedColumnName="id")
    private AdminUser createdBy;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="modified_by", referencedColumnName="id")
    private AdminUser modifiedBy;
    
	@PrePersist
	public void setCreationDate() {
		this.createdTime = new Date();
		this.modifiedTime = new Date();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if(auth != null) {
			CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
			AdminUser admin = (AdminUser)user.getloggedInUser();
			this.setCreatedBy(admin);
			this.setModifiedBy(admin);
		}
		
	}

	@PreUpdate
	public void setChangeDate() {
		this.modifiedTime = new Date();
	}
}
