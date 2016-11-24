package com.uni.sd.subastadora.domain.announcement;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.uni.sd.subastadora.domain.base.BaseDomain;
import com.uni.sd.subastadora.domain.announcement.AnnouncementDomain;
import com.uni.sd.subastadora.domain.product.ProductDomain;
import com.uni.sd.subastadora.domain.user.UserDomain;


@Entity
@Table(name = "announcement")
public class AnnouncementDomain extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@ManyToOne
	private UserDomain _user;
	
	@ManyToOne
	private ProductDomain _product;


	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

}