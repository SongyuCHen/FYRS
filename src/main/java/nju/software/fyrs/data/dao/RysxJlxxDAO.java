package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;
import nju.software.fyrs.data.dataobject.RysxJlxx;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxJlxx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxJlxx
  * @author MyEclipse Persistence Tools 
 */
public class RysxJlxxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxJlxxDAO.class);
		//property constants
	public static final String _CSZDW = "CSzdw";
	public static final String _CSZBM = "CSzbm";
	public static final String _CZW = "CZw";
	public static final String _CZJ = "CZj";
	public static final String _CZMR = "CZmr";
	public static final String _CGLXX = "CGlxx";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxJlxx transientInstance) {
        log.debug("saving RysxJlxx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxJlxx persistentInstance) {
        log.debug("deleting RysxJlxx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxJlxx findById( nju.software.fyrs.data.dataobject.RysxJlxxId id) {
        log.debug("getting RysxJlxx instance with id: " + id);
        try {
            RysxJlxx instance = (RysxJlxx) getHibernateTemplate()
                    .get("software.fyrs.data.RysxJlxx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxJlxx> findByExample(RysxJlxx instance) {
        log.debug("finding RysxJlxx instance by example");
        try {
            List<RysxJlxx> results = (List<RysxJlxx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxJlxx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxJlxx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxJlxx> findByCSzdw(Object CSzdw
	) {
		return findByProperty(_CSZDW, CSzdw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJlxx> findByCSzbm(Object CSzbm
	) {
		return findByProperty(_CSZBM, CSzbm
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJlxx> findByCZw(Object CZw
	) {
		return findByProperty(_CZW, CZw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJlxx> findByCZj(Object CZj
	) {
		return findByProperty(_CZJ, CZj
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJlxx> findByCZmr(Object CZmr
	) {
		return findByProperty(_CZMR, CZmr
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJlxx> findByCGlxx(Object CGlxx
	) {
		return findByProperty(_CGLXX, CGlxx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJlxx> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxJlxx instances");
		try {
			String queryString = "from RysxJlxx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxJlxx merge(RysxJlxx detachedInstance) {
        log.debug("merging RysxJlxx instance");
        try {
            RysxJlxx result = (RysxJlxx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxJlxx instance) {
        log.debug("attaching dirty RysxJlxx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxJlxx instance) {
        log.debug("attaching clean RysxJlxx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxJlxxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxJlxxDAO) ctx.getBean("RysxJlxxDAO");
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<RysxJlxx> getJlxxByRybh(String rybh){
		int nrybh=Integer.parseInt(rybh);
		String hql = "from RysxJlxx where NRybh="+nrybh;
		List<RysxJlxx> listRysxJlxx = getHibernateTemplate().find(hql);
		return listRysxJlxx;
	}
	
	
	public RysxJlxx getRsJlxxById(String id,String fydm,String rybh){
		String hql = "from RysxJlxx where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxJlxx)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean delRsJlxxById(String rybh,String bh){
		String hql = "from RysxJlxx where NRybh=? and NId=?";
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		List<RysxJlxx> RsJlxxList = getHibernateTemplate().find(hql,nrybh,bd);
		if(RsJlxxList==null||RsJlxxList.size()==0){
			return false;
		}else{
			RysxJlxx rsJlxx = RsJlxxList.get(0);
			getHibernateTemplate().delete(rsJlxx);
			return true;
		}
	}
	
	public boolean updateRsJlxx(RysxJlxx rysxJlxx){
		if(rysxJlxx==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxJlxx);
			return true;
		}
	}
	
	
	public boolean interceptAddJlxx(RysxJlxx rysxJlxx){
		try
		{
			getSession().save(rysxJlxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateJlxx(RysxJlxx rysxJlxx){
		try
		{
			getSession().update(rysxJlxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsJlxxById(RysxJlxx rysxJlxx){
		try
		{
			getSession().delete(rysxJlxx);
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
	public List<RysxJlxx> getJlxxByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxJlxx rj where rj.NFy=? and rj.NRybh=? order by DQsrq").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxJlxx findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxJlxx)getSession().createQuery("from RysxJlxx rj where rj.NFy = ? and rj.NRybh = ? and rj.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_JLXX";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}
}