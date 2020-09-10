package com.digicl.pnd.model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name="pd_bid")
public class Bid implements Serializable{ 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    @Column(name="bid_id")
    private Long bidId;
    
    @Column(name="bid_pickup_location")
    private String bidPickupLocation;
    
    @Column(name="bid_pickup_latlng")
    private String bidPickupLatlng;
    
    @Column(name="bid_pickup_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bidPickupTime;
    
    @Column(name="bid_drop_location")
    private String bidDropLocation;
    
    @Column(name="bid_drop_latlng")
    private String bidDropLatlng;
    
    @Column(name="bid_drop_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bidDropTime;
    
    @Column(name="bid_status")
    private String bidStatus;
    
    @Column(name="message")
    private String message;
    
    @Column(name="bid_amount")
    private BigDecimal bidAmount;
    @Lob
    
    @Column(name="message_history")
    private String messageHistory;
    
    @Column(name="num_passenger")
    private BigInteger numPassenger;
    
    @Column(name="return_trip")
    private String returnTrip;
    
    @ManyToOne
    @JoinColumn(name="parent_id", referencedColumnName="parent_id")
    private Parent parentId;
    
    @ManyToOne
    @JoinColumn(name="sp_id", referencedColumnName="sp_id")
    private ServiceProvider spId;

}