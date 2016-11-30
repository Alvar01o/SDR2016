package com.uni.sd.subastadora.dao.creditCard;

import java.util.List;





import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uni.sd.subastadora.dao.base.BaseDaoImpl;
import com.uni.sd.subastadora.domain.creditCard.CreditCardDomain;

@Repository
public class CreditCardDaoImpl extends BaseDaoImpl<CreditCardDomain> implements ICreditCardDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CreditCardDomain save(CreditCardDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public CreditCardDomain getById(Integer domainId) {
		return (CreditCardDomain) sessionFactory.getCurrentSession().get(CreditCardDomain.class, domainId);
	}

	@Override
	public List<CreditCardDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CreditCardDomain.class);
		return criteria.list();
	}

	
	public List<CreditCardDomain> find(String textToFind) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(CreditCardDomain.class);
		Criterion nameCriterion =Restrictions.ilike("_name", textToFind);
		Criterion idCriterion = null;
		if (StringUtils.isNumeric(textToFind)) {
			idCriterion=Restrictions.eq("_id", Integer.valueOf(textToFind));
		}
		
		if(idCriterion!=null){
			criteria.add(Restrictions.or(nameCriterion, idCriterion));
		}else{
			criteria.add(nameCriterion);
		}
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<CreditCardDomain> creditCards = criteria.list();
		return creditCards;
	}

	public List<CreditCardDomain> find2(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from CreditCardDomain where _cardNumber like :parameter or _user like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}

}
