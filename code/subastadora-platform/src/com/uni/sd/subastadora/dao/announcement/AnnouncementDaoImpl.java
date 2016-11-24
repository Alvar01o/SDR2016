package com.uni.sd.subastadora.dao.announcement;

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
import com.uni.sd.subastadora.domain.announcement.AnnouncementDomain;

@Repository
public class AnnouncementDaoImpl extends BaseDaoImpl<AnnouncementDomain> implements IAnnouncementDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public AnnouncementDomain save(AnnouncementDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public AnnouncementDomain getById(Integer domainId) {
		return (AnnouncementDomain) sessionFactory.getCurrentSession().get(AnnouncementDomain.class, domainId);
	}

	@Override
	public List<AnnouncementDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AnnouncementDomain.class);
		return criteria.list();
	}

	
	public List<AnnouncementDomain> find(String textToFind) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(AnnouncementDomain.class);
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
		List<AnnouncementDomain> announcements = criteria.list();
		return announcements;
	}

	public List<AnnouncementDomain> find2(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from AnnouncementDomain where _name like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}

}
