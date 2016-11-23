package com.uni.sd.subastadora.dao.valuation;


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
import com.uni.sd.subastadora.domain.valuation.ValuationDomain;

@Repository
public class ValuationDaoImpl extends BaseDaoImpl<ValuationDomain> implements IValuationDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ValuationDomain save(ValuationDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public ValuationDomain getById(Integer domainId) {
		return (ValuationDomain) sessionFactory.getCurrentSession().get(ValuationDomain.class, domainId);
	}

	@Override
	public List<ValuationDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ValuationDomain.class);
		return criteria.list();
	}

	
	public List<ValuationDomain> find(String textToFind) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ValuationDomain.class);
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
		List<ValuationDomain> valuations = criteria.list();
		return valuations;
	}

	public List<ValuationDomain> find2(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from ValuationDomain where _name like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}

}


