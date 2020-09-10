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
@Table(name="pd_role_func_map")
public class RoleFuncMap implements Serializable{ 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name="role_func_map_id")
    private Long roleFuncMapId;
    
    @ManyToOne
    @JoinColumn(name="function_id", referencedColumnName="function_id")
    private Functions functionId;
    
    @ManyToOne
    @JoinColumn(name="role_id", referencedColumnName="role_id")
    private AdminRole roleId;

}