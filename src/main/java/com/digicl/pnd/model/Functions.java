package com.digicl.pnd.model;
import java.io.Serializable;
import java.math.BigInteger;

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
@Table(name="pd_functions")
public class Functions implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name="function_id")
    private Long functionId;
    
    @Column(name="function_name")
    private String functionName;
    
    @Column(name="function_link")
    private String functionLink;
    
    @Column(name="priority")
    private BigInteger priority;
    
    @Column(name="menu_level")
    private BigInteger menuLevel;

}