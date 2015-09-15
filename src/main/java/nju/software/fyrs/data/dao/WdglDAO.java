package nju.software.fyrs.data.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import nju.software.fyrs.data.dataobject.Wdgl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class WdglDAO extends HibernateDaoSupport{
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(WdglDAO.class);
	
	 public void save(Wdgl transientInstance) {
        try {
            getHibernateTemplate().save(transientInstance);
        } catch (RuntimeException re) {
            throw re;
        }
    }
	    
	public void delete(Wdgl persistentInstance) {
        try {
            getHibernateTemplate().delete(persistentInstance);
        } catch (RuntimeException re) {
            throw re;
        }
    }
	    
    public Wdgl findById(Integer id) {
        try {
            Wdgl instance = (Wdgl) getHibernateTemplate()
                    .get(Wdgl.class, id);
            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }
    
    @SuppressWarnings("rawtypes")
	public List findAll() {
		try {
			String queryString = "from Wdgl w order by w.fwsj desc, w.wdbh desc";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void update(Wdgl persistentInstance) {
		try {
            getHibernateTemplate().update(persistentInstance);
        } catch (RuntimeException re) {
            throw re;
        }
	}
	
	@SuppressWarnings("unchecked")
	public List<Wdgl> getWdByQueryMap(Map<String, Object> queryMap) {
		String fwh = (String) queryMap.get("fwh");
		
		String bt = (String) queryMap.get("bt");
		
		Date fwsjStart = (Date) queryMap.get("fwsjStart");
		Date fwsjEnd = (Date) queryMap.get("fwsjEnd");
		
		Criteria criteria = this.getSession().createCriteria(Wdgl.class);
		if(fwh!=null){
			criteria.add(Restrictions.like("fwh", "%"+fwh+"%"));
		}
		if(bt!=null){
			criteria.add(Restrictions.like("bt", "%"+bt+"%"));
		}
		if(fwsjEnd != null)
			criteria.add(Restrictions.le("fwsj", fwsjEnd));
		if(fwsjStart != null)
			criteria.add(Restrictions.ge("fwsj", fwsjStart));
		
		return criteria.list();
	}
}
