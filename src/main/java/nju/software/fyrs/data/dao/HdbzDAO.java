package nju.software.fyrs.data.dao;

import java.util.Date;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxHdbz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HdbzDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(HdbzDAO.class);

	public boolean save(RysxHdbz hdbz) {
		log.debug("saving RysxHdbz instance");
        try {
            getHibernateTemplate().save(hdbz);
            log.debug("save successful");
            return true;
        } catch (Exception e) {
            log.error("save failed", e);
            return false;
        }
	}

	@SuppressWarnings("unchecked")
	public List<RysxHdbz> getHdbzList(int fydm, String col) {
		String hql = "from RysxHdbz where NFy = " + fydm + " and " + col + " <> null order by DRq asc";
		return getHibernateTemplate().find(hql);
	}
	
	@SuppressWarnings("unchecked")
	public RysxHdbz getLastHdbzByBzlx(int fydm, String col){
		String hql = "from RysxHdbz where NFy = " + fydm + " and " + col + " <> null order by DRq desc";
		List<RysxHdbz>hdbzs = getHibernateTemplate().find(hql);
		if(hdbzs.size()==0)return null;
		return hdbzs.get(0);
	}

	@SuppressWarnings("unchecked")
	public int getSdbzKbsByDate(int fydm, Date date) {
		String hql="from RysxHdbz where NFy = " + fydm + " and NShengZfzxbzKbs<>null and DRq<='"+date+"' order by DRq desc";
		List<RysxHdbz>hdbzs=getHibernateTemplate().find(hql);
		if(hdbzs.size()==0)return 0;
		else return hdbzs.get(0).getNShengZfzxbzKbs();
	}

	public RysxHdbz findById(int id) {
		log.debug("getting RysxHdbz instance with id: " + id);
		try {
			return (RysxHdbz) getHibernateTemplate().get("nju.software.fyrs.data.dataobject.RysxHdbz", id);
		}catch(RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}
