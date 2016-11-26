package com.uni.sd.subastadora.domain.typeBid;


import java.util.HashSet;
import java.util.Set;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import com.uni.sd.subastadora.domain.base.BaseDomain;
import com.uni.sd.subastadora.domain.bid.BidDomain;

@Entity
@Table(name = "typeBid")
public class TypeBidDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "name", nullable = false, unique = true)
	private String _name;
	
	@OneToMany(mappedBy = "_typeBid")
	private Set<BidDomain> _bids = new HashSet<>();
	
	
		
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}
	
	public Set<BidDomain> getBids() {
		return _bids;
	}

	public void setBids(Set<BidDomain> bids) {
		this._bids = bids;
	}

}
