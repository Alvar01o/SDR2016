package com.uni.sd.subastadora.domain.user;

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

import com.uni.sd.subastadora.domain.announcement.AnnouncementDomain;
import com.uni.sd.subastadora.domain.auction.AuctionDomain;
import com.uni.sd.subastadora.domain.base.BaseDomain;
import com.uni.sd.subastadora.domain.bid.BidDomain;
import com.uni.sd.subastadora.domain.creditcard.CreditCardDomain;
import com.uni.sd.subastadora.domain.location.state.StateDomain;
import com.uni.sd.subastadora.domain.product.ProductDomain;
import com.uni.sd.subastadora.domain.role.RoleDomain;
import com.uni.sd.subastadora.domain.valuation.ValuationDomain;

@Entity
@Table(name = "user")
public class UserDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "name")
	private String _name;

	@Column(name = "username")
	private String _username;
	@Column(name = "lastname")
	private String _lastname;	
	
	@Column(name = "email")
	private String _email;
	
	@Column(name = "address")
	private String _address;
	
	@Column(name = "password")
	private String _password;

	@ManyToOne
	private RoleDomain _role;
	
	
	@OneToMany(mappedBy = "_user")
	private Set<ProductDomain> _products = new HashSet<>();
	
	@OneToMany(mappedBy = "_auctioneer")
	private Set<ValuationDomain> _valuationAuctioneers = new HashSet<>();
	
	@OneToMany(mappedBy = "_voter")
	private Set<ValuationDomain> _valuationVoters = new HashSet<>();

	@OneToMany(mappedBy = "_user")
	private Set<CreditCardDomain> _creditCards = new HashSet<>();
	
	@OneToMany(mappedBy = "_user")
	private Set<AnnouncementDomain> _announcements = new HashSet<>();
	
	@OneToMany(mappedBy = "_winnerId")
	private Set<AuctionDomain> _auctions = new HashSet<>();
	
	@OneToMany(mappedBy = "_user")
	private Set<BidDomain> _bids = new HashSet<>();
	
	public RoleDomain getRole() {
			return _role;
 	}
		 
 	public void setRole(RoleDomain role) {
 		_role = role;
	}	

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

	public String getLastName() {
		return _lastname;
	}

	public void setLastName(String name) {
		_lastname = name;
	}
	
	public String getUserName() {
		return _username;
	}

	public void setUserName(String name) {
		_username = name;
	}
	
	public String getEmail() {
		return _email;
	}

	public void setEmail(String name) {
		_email = name;
	}	
	

	public String getaddress() {
		return _address;
	}

	public void setAddress(String name) {
		_address = name;
	}
	
	
	public Set<AnnouncementDomain> getAnnouncements() {
		return _announcements;
	}

	public void setAnnouncements(Set<AnnouncementDomain> announcements) {
		this._announcements = announcements;
	}

	public Set<AuctionDomain> getAuctions() {
		return _auctions;
	}

	public void setAuctions(Set<AuctionDomain> auctions) {
		this._auctions = auctions;
	}
	

	public Set<ValuationDomain> getValuationVoters() {
		return _valuationVoters;
	}

	public void setValuationVoters(Set<ValuationDomain> valuationVoters) {
		this._valuationVoters = valuationVoters;
	}
	
	
	public Set<ValuationDomain> getValuationAuctioneers() {
		return _valuationAuctioneers;
	}

	public void setValuationAuctioneers(Set<ValuationDomain> valuationAuctioneers) {
		this._valuationAuctioneers = valuationAuctioneers;
	}
	

	public Set<ProductDomain> getProducts1() {
		return _products;
	}

	public void setProducts(Set<ProductDomain> products) {
		this._products = products;
	}
	
	
	public Set<CreditCardDomain> getCreditCards() {
		return _creditCards;
	}

	public void setCreditCards(Set<CreditCardDomain> creditCards) {
		this._creditCards = creditCards;
	}
	
	
	public Set<BidDomain> getBids() {
		return _bids;
	}

	public void setBids(Set<BidDomain> bids) {
		this._bids = bids;
	}
	
	
	

}
