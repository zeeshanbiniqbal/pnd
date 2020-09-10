package com.digicl.pnd.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="pd_admin_users")
public class AdminUser extends BaseEntity implements Serializable{ 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="email")
    private String email;
    
    @JsonIgnore
    @Column(name="password")
    private String password;
    
    @Column(name="status")
    private String status;
        
    @ManyToOne
    @JoinColumn(name="role_id", referencedColumnName="role_id")
    private AdminRole roleId;
 
}