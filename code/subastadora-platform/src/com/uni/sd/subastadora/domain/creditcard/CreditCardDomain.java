package com.uni.sd.subastadora.domain.creditcard;


import java.util.Date;
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

import com.uni.sd.subastadora.domain.base.BaseDomain;
import com.uni.sd.subastadora.domain.user.UserDomain;

@Entity
@Table(name = "creditCard")
public class CreditCardDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "cardNumber", nullable = false, unique = false)
	private String _cardNumber;
	
	@Column(name = "expiration")
	private Date _expiration;

	@ManyToOne
	private UserDomain _user;
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public String getCardNumber() {
		return _cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		_cardNumber = cardNumber;
	}

	
	public UserDomain getUser() {
		return _user;
	}

	public void setUser(UserDomain user) {
		_user = user;
	}
	
	public Date getExpiration() {
		return _expiration;
	}

	public void setExpiration(Date expiration) {
		_expiration = expiration;
	}

}

