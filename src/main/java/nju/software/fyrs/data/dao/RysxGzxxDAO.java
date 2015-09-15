package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxGzxx;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxGzxx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxGzxx
  * @author MyEclipse Persistence Tools 
 */
public class RysxGzxxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxGzxxDAO.class);
		//property constants
	public static final String _CZWGZDC = "CZwgzdc";
	public static final String _MZWGZE = "MZwgze";
	public static final String _CXJB = "CXjb";
	public static final String _MJBGZE = "MJbgze";
	public static final String _MJCGZ = "MJcgz";
	public static final String _MGLGZ = "MGlgz";
	public static final String _MZWGWBT = "MZwgwbt";
	public static final String _MJT = "MJt";
	public static final String _MJHLJT = "MJhljt";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxGzxx transientInstance) {
        log.debug("saving RysxGzxx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxGzxx persistentInstance) {
        log.debug("deleting RysxGzxx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxGzxx findById( nju.software.fyrs.data.dataobject.RysxGzxxId id) {
        log.debug("getting RysxGzxx instance with id: " + id);
        try {
            RysxGzxx instance = (RysxGzxx) getHibernateTemplate()
                    .get("software.fyrs.data.RysxGzxx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxGzxx> findByExample(RysxGzxx instance) {
        log.debug("finding RysxGzxx instance by example");
        try {
            List<RysxGzxx> results = (List<RysxGzxx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxGzxx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxGzxx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxGzxx> findByCZwgzdc(Object CZwgzdc
	) {
		return findByProperty(_CZWGZDC, CZwgzdc
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxGzxx> findByMZwgze(Object MZwgze
	) {
		return findByProperty(_MZWGZE, MZwgze
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxGzxx> findByCXjb(Object CXjb
	) {
		return findByProperty(_CXJB, CXjb
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxGzxx> findByMJbgze(Object MJbgze
	) {
		return findByProperty(_MJBGZE, MJbgze
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxGzxx> findByMJcgz(Object MJcgz
	) {
		return findByProperty(_MJCGZ, MJcgz
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxGzxx> findByMGlgz(Object MGlgz
	) {
		return findByProperty(_MGLGZ, MGlgz
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxGzxx> findByMZwgwbt(Object MZwgwbt
	) {
		return findByProperty(_MZWGWBT, MZwgwbt
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxGzxx> findByMJt(Object MJt
	) {
		return findByProperty(_MJT, MJt
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxGzxx> findByMJhljt(Object MJhljt
	) {
		return findByProperty(_MJHLJT, MJhljt
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxGzxx> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxGzxx instances");
		try {
			String queryString = "from RysxGzxx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxGzxx merge(RysxGzxx detachedInstance) {
        log.debug("merging RysxGzxx instance");
        try {
            RysxGzxx result = (RysxGzxx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxGzxx instance) {
        log.debug("attaching dirty RysxGzxx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxGzxx instance) {
        log.debug("attaching clean RysxGzxx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxGzxxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxGzxxDAO) ctx.getBean("RysxGzxxDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxGzxx> getGzxxByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxGzxx where NRybh=?";
		List<RysxGzxx> listRysxGzxx = getHibernateTemplate().find(hql,nrybh);
		return listRysxGzxx;
	}
	
	public RysxGzxx getRsGzxxById(String id,String fydm,String rybh){
		String hql = "from RysxGzxx where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxGzxx)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsGzxxById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxGzxx where NRybh=? and NId=?";
		List<RysxGzxx> listRysxGzxx = getHibernateTemplate().find(hql,nrybh,bd);
		if(listRysxGzxx==null||listRysxGzxx.size()==0){
			return false;
		}else{
			RysxGzxx rysxGzxx = listRysxGzxx.get(0);
			getHibernateTemplate().delete(rysxGzxx);
			return true;
		}
	}
	
	public boolean updateRsGzxx(RysxGzxx rysxGzxx){
		if(rysxGzxx==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxGzxx);
			return true;
		}
	}
	
	public boolean interceptAddGzxx(RysxGzxx rysxGzxx){
		try
		{
			getSession().save(rysxGzxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateGzxx(RysxGzxx rysxGzxx){
		try
		{
			getSession().update(rysxGzxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsGzxxById(RysxGzxx rysxGzxx){
		try
		{
			getSession().delete(rysxGzxx);
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
	public List<RysxGzxx> getGzxxByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxGzxx rk where rk.NFy=? and rk.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxGzxx findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxGzxx)getSession().createQuery("from RysxGzxx rk where rk.NFy = ? and rk.NRybh = ? and rk.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_GZXX";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}


}