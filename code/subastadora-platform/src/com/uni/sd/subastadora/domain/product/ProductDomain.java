package com.uni.sd.subastadora.domain.product;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.uni.sd.subastadora.domain.base.BaseDomain;
import com.uni.sd.subastadora.domain.product.ProductDomain;
import com.uni.sd.subastadora.domain.user.UserDomain;
import com.uni.sd.subastadora.domain.auction.AuctionDomain;
import com.uni.sd.subastadora.util.CategoryEnum;

@Entity
@Table(name = "product")
public class ProductDomain extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "name")
	private String _name;
	
	@Column(name = "description")
	private String _description;
	
	@Column(name = "price")
	private int _price;
	
	@Column(name = "shippingInfor")
	private String _shippingInfor;
	
	@Enumerated(EnumType.STRING)
	private CategoryEnum _category;
	
	@ManyToOne
	private UserDomain _user;
	
	//@OneToMany(mappedBy="_product")
	//private Set<AuctionDomain>_auction= new HashSet<AuctionDomain>();
	
	//@OneToMany(mappedBy="_advertisements")
	//private Set<AdvertisementsDomain>_advertisements= new HashSet<AdvertisementsDomain>();


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
		
	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}
	
	public int getPrice() {
		return _price;
	}

	public void setPrice(int price) {
		_price = price;
	}
	
	public String getShippingInfor() {
		return _shippingInfor;
	}
	
	public void setShippingInfor(String shippingInfor) {
			_shippingInfor = shippingInfor;
	}

	public void setCategory(CategoryEnum category) {
		_category = category;
	}
		public CategoryEnum getCategory() {
		return _category;
	}


}
