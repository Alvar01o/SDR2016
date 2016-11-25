package com.uni.sd.subastadora.dao.typeBid;

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
import com.uni.sd.subastadora.domain.auction.AuctionDomain;


@Repository
public class TypeBidDaoImp extends BaseDaoImpl<AuctionDomain> implements ITypeBidDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public AuctionDomain save(AuctionDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public AuctionDomain getById(Integer domainId) {
		return (AuctionDomain) sessionFactory.getCurrentSession().get(AuctionDomain.class, domainId);
	}

	@Override
	public List<AuctionDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AuctionDomain.class);
		return criteria.list();
	}

	
	public List<AuctionDomain> find(String textToFind) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(AuctionDomain.class);
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
		List<AuctionDomain> countries = criteria.list();
		return countries;
	}

	public List<AuctionDomain> find2(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from AuctionDomain where _name like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}

}
