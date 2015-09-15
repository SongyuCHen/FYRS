package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxLdbz;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxLdbz entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxLdbz
  * @author MyEclipse Persistence Tools 
 */
public class RysxLdbzDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxLdbzDAO.class);
		//property constants
	public static final String _CQGZDW = "CQgzdw";
	public static final String _CQGZBM = "CQgzbm";
	public static final String _NZW = "NZw";
	public static final String _NZQDZYJ = "NZqdzyj";
	public static final String _NCJKC = "NCjkc";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxLdbz transientInstance) {
        log.debug("saving RysxLdbz instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxLdbz persistentInstance) {
        log.debug("deleting RysxLdbz instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxLdbz findById( nju.software.fyrs.data.dataobject.RysxLdbzId id) {
        log.debug("getting RysxLdbz instance with id: " + id);
        try {
            RysxLdbz instance = (RysxLdbz) getHibernateTemplate()
                    .get("software.fyrs.data.RysxLdbz", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxLdbz> findByExample(RysxLdbz instance) {
        log.debug("finding RysxLdbz instance by example");
        try {
            List<RysxLdbz> results = (List<RysxLdbz>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxLdbz instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxLdbz as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxLdbz> findByCQgzdw(Object CQgzdw
	) {
		return findByProperty(_CQGZDW, CQgzdw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxLdbz> findByCQgzbm(Object CQgzbm
	) {
		return findByProperty(_CQGZBM, CQgzbm
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxLdbz> findByNZw(Object NZw
	) {
		return findByProperty(_NZW, NZw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxLdbz> findByNZqdzyj(Object NZqdzyj
	) {
		return findByProperty(_NZQDZYJ, NZqdzyj
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxLdbz> findByNCjkc(Object NCjkc
	) {
		return findByProperty(_NCJKC, NCjkc
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxLdbz> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxLdbz instances");
		try {
			String queryString = "from RysxLdbz";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxLdbz merge(RysxLdbz detachedInstance) {
        log.debug("merging RysxLdbz instance");
        try {
            RysxLdbz result = (RysxLdbz) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxLdbz instance) {
        log.debug("attaching dirty RysxLdbz instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxLdbz instance) {
        log.debug("attaching clean RysxLdbz instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxLdbzDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxLdbzDAO) ctx.getBean("RysxLdbzDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxLdbz> getLdbzByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxLdbz where NRybh=?";
		List<RysxLdbz> listRysxLdbz = getHibernateTemplate().find(hql,nrybh);
		return listRysxLdbz;
	}
	
	public RysxLdbz getRsLdbzById(String id,String fydm,String rybh){
		String hql = "from RysxLdbz where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxLdbz)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsLdbzById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql ="from RysxLdbz where NRybh=? and NId=?";
		List<RysxLdbz> listRysxLdbz = getHibernateTemplate().find(hql,nrybh,bd);
		if(listRysxLdbz==null||listRysxLdbz.size()==0){
			return false;
		}else{
			RysxLdbz rysxLdbz = listRysxLdbz.get(0);
			getHibernateTemplate().delete(rysxLdbz);
			return true;
		}
	}
	
	public boolean updateRsLdbz(RysxLdbz rysxLdbz){
		if(rysxLdbz==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxLdbz);
			return true;
		}
	}
	
	public boolean interceptAddLdbz(RysxLdbz rysxLdbz){
		try
		{
			getSession().save(rysxLdbz);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateLdbz(RysxLdbz rysxLdbz){
		try
		{
			getSession().update(rysxLdbz);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsLdbzById(RysxLdbz rysxLdbz){
		try
		{
			getSession().delete(rysxLdbz);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxLdbz> getLdbzByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxLdbz rj where rj.NFy=? and rj.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxLdbz findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxLdbz)getSession().createQuery("from RysxLdbz rj where rj.NFy = ? and rj.NRybh = ? and rj.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_LDBZ";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}
}