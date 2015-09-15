package nju.software.fyrs.data.dao;

import java.util.List;

import nju.software.fyrs.data.dataobject.RykRc;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 
 	* A data access object (DAO) providing persistence and search support for RykRc entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RykRc
  * @author MyEclipse Persistence Tools 
 */

public class RykRcDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RykRcDAO.class);
		//property constants
	public static final String _NFY = "NFy";
	public static final String _NRYBH = "NRybh";
	public static final String _NBM = "NBm";
	public static final String _NRCLX = "NRclx";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RykRc transientInstance) {
        log.debug("saving RykRc instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
            getSession().flush();
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RykRc persistentInstance) {
        log.debug("deleting RykRc instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RykRc findById( java.lang.Integer id) {
        log.debug("getting RykRc instance with id: " + id);
        try {
            RykRc instance = (RykRc) getHibernateTemplate()
                    .get("nju.software.fyrs.data.RykRc", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RykRc> findByExample(RykRc instance) {
        log.debug("finding RykRc instance by example");
        try {
            List<RykRc> results = (List<RykRc>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RykRc instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RykRc as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RykRc> findByNFy(Object NFy
	) {
		return findByProperty(_NFY, NFy
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RykRc> findByNRybh(Object NRybh
	) {
		return findByProperty(_NRYBH, NRybh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RykRc> findByNBm(Object NBm
	) {
		return findByProperty(_NBM, NBm
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RykRc> findByNRclx(Object NRclx
	) {
		return findByProperty(_NRCLX, NRclx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RykRc> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RykRc instances");
		try {
			String queryString = "from RykRc";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RykRc merge(RykRc detachedInstance) {
        log.debug("merging RykRc instance");
        try {
            RykRc result = (RykRc) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RykRc instance) {
        log.debug("attaching dirty RykRc instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RykRc instance) {
        log.debug("attaching clean RykRc instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RykRcDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RykRcDAO) ctx.getBean("RykRcDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RykRc> getRcxxByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RykRc where NRybh=?";
		List<RykRc> listRykRc = getHibernateTemplate().find(hql,nrybh);
		return listRykRc;
	}
	
	public RykRc getRsRcxxById(String id,String fydm,String rybh){
		String hql = "from RykRc where NId=? and NFy=? and NRybh=?";
		int n = Integer.valueOf(id);
		return (RykRc)getSession().createQuery(hql).setParameter(0,n).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsRcxxById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		int nbh = Integer.parseInt(bh);
		String hql = "from RykRc where NRybh=? and NId=?";
		List<RykRc> listRykRc = getHibernateTemplate().find(hql,nrybh,nbh);
		if(listRykRc==null||listRykRc.size()==0){
			return false;
		}else{
			RykRc rykRc = listRykRc.get(0);
			getHibernateTemplate().delete(rykRc);
			return true;
		}
	}
	
	public boolean updateRsRcxx(RykRc rykRc){
		if(rykRc==null){
			return false;
		}else{
			getHibernateTemplate().update(rykRc);
			return true;
		}
	}
	
	public boolean interceptAddRcxx(RykRc rykRc){
		getSession().save(rykRc);
		return true;
	}
	
	public boolean interceptUpdateRcxx(RykRc rykRc){
		getSession().update(rykRc);
		return true;
	}
	
	public boolean interceptDeleteRsRcxxById(RykRc rykRc){
		getSession().delete(rykRc);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<RykRc> getRcxxByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RykRc rj where rj.NFy=? and rj.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RykRc findByFyRybhId(int fy,int rybh,int id)
	{
	   return (RykRc)getSession().createQuery("from RykRc rj where rj.NFy = ? and rj.NRybh = ? and rj.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public Integer getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYK_RC";
		Query query = getSession().createSQLQuery(hql);
		Object object = query.uniqueResult();
		int maxBh = 1;
		if(null != object)
		{
			maxBh = (Integer)object + 1;
		}return maxBh;
	}

	@SuppressWarnings("unchecked")
	public List<RykRc> getRcListByFyAndBm(int fydm, int bmdm, int rcklx, int sfls) {
		if(bmdm < 0){
			return getRcListByFy(fydm, rcklx, sfls);
		}
		return getSession().createQuery("from RykRc rj where rj.NFy=? and rj.NBm=? and rj.NRclx=? and rj.NSfls = ? order by rj.NXssx asc").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(bmdm)).setParameter(2, Integer.valueOf(rcklx)).setParameter(3, Integer.valueOf(sfls)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<RykRc> getRcListByFy(int fydm, int rcklx, int sfls) {
		return getSession().createQuery("from RykRc rj where rj.NFy=? and rj.NRclx=? and rj.NSfls = ? order by rj.NXssx asc").setParameter(0,Integer.valueOf(fydm)).setParameter(1, Integer.valueOf(rcklx)).setParameter(2, Integer.valueOf(sfls)).list();
	}

	public RykRc getRcxxByRybhFyRcklx(Integer rybh1, Integer fydm, Integer rcklx) {
		
		return (RykRc)getSession().createQuery("from RykRc rj where rj.NFy = ? and rj.NRybh = ? and rj.NRclx = ?").setParameter(0,fydm).setParameter(1, rybh1).setParameter(2,rcklx).uniqueResult();
	}

	public void saveOrUpdate(RykRc detachedInstance) {
		log.debug("saveOrUpdate RykRc instance");
        try {
           getHibernateTemplate()
                    .saveOrUpdate(detachedInstance);
           getSession().flush();
            log.debug("saveOrUpdate successful");
           
        } catch (RuntimeException re) {
            log.error("saveOrUpdate failed", re);
            throw re;
        }
	}

	public int getMaxNXssx(int fydm) {
		String hql = "select max(N_XSSX) from T_RYK_RC where N_FY = " + fydm;
		Query query = getSession().createSQLQuery(hql);
		Object object = query.uniqueResult();
		int maxBh = 1;
		if(null != object)
		{
			maxBh = (Integer)object + 1;
		}
		return maxBh;
	}
}