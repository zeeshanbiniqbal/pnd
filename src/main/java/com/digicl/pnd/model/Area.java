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
@Table(name="pd_area")
public class Area extends BaseEntity implements Serializable{ 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name="area_id")
    private Long areaId;
    
    @Column(name="area_name")
    private String areaName;
    
    @Column(name="city_id")
    private BigInteger cityId;
    
    @Column(name="school_area")
    private String schoolArea;
    
    @Column(name="address")
    private String address;
    
    @Column(name="lat_long")
    private String latLong;

}