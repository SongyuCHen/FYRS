package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxJiaoliuxx;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxJialliuxx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxJiaoliuxx
  * @author MyEclipse Persistence Tools 
 */
public class RysxJialliuxxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxJialliuxxDAO.class);
		//property constants
	public static final String _NJLLB = "NJllb";
	public static final String _NJLFS = "NJlfs";
	public static final String _NJLZWXZ = "NJlzwxz";
	public static final String _CJLZWMC = "CJlzwmc";
	public static final String _CJLGZDW = "CJlgzdw";
	public static final String _CJLGZBM = "CJlgzbm";
	public static final String _NTBJL = "NTbjl";
	public static final String _CJLID = "CJlid";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxJiaoliuxx transientInstance) {
        log.debug("saving RysxJialliuxx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxJiaoliuxx persistentInstance) {
        log.debug("deleting RysxJialliuxx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxJiaoliuxx findById( nju.software.fyrs.data.dataobject.RysxJiaoliuxxId id) {
        log.debug("getting RysxJialliuxx instance with id: " + id);
        try {
            RysxJiaoliuxx instance = (RysxJiaoliuxx) getHibernateTemplate()
                    .get("software.fyrs.data.RysxJialliuxx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxJiaoliuxx> findByExample(RysxJiaoliuxx instance) {
        log.debug("finding RysxJialliuxx instance by example");
        try {
            List<RysxJiaoliuxx> results = (List<RysxJiaoliuxx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxJialliuxx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxJialliuxx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxJiaoliuxx> findByNJllb(Object NJllb
	) {
		return findByProperty(_NJLLB, NJllb
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJiaoliuxx> findByNJlfs(Object NJlfs
	) {
		return findByProperty(_NJLFS, NJlfs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJiaoliuxx> findByNJlzwxz(Object NJlzwxz
	) {
		return findByProperty(_NJLZWXZ, NJlzwxz
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJiaoliuxx> findByCJlzwmc(Object CJlzwmc
	) {
		return findByProperty(_CJLZWMC, CJlzwmc
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJiaoliuxx> findByCJlgzdw(Object CJlgzdw
	) {
		return findByProperty(_CJLGZDW, CJlgzdw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJiaoliuxx> findByCJlgzbm(Object CJlgzbm
	) {
		return findByProperty(_CJLGZBM, CJlgzbm
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJiaoliuxx> findByNTbjl(Object NTbjl
	) {
		return findByProperty(_NTBJL, NTbjl
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJiaoliuxx> findByCJlid(Object CJlid
	) {
		return findByProperty(_CJLID, CJlid
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJiaoliuxx> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxJialliuxx instances");
		try {
			String queryString = "from RysxJialliuxx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxJiaoliuxx merge(RysxJiaoliuxx detachedInstance) {
        log.debug("merging RysxJialliuxx instance");
        try {
            RysxJiaoliuxx result = (RysxJiaoliuxx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxJiaoliuxx instance) {
        log.debug("attaching dirty RysxJialliuxx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxJiaoliuxx instance) {
        log.debug("attaching clean RysxJialliuxx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxJialliuxxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxJialliuxxDAO) ctx.getBean("RysxJialliuxxDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxJiaoliuxx> getJliuxxByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxJialliuxx where NRybh=?";
		List<RysxJiaoliuxx> listJiaoliuxx = getHibernateTemplate().find(hql,nrybh);
		return listJiaoliuxx;
		
	}
	
	public RysxJiaoliuxx getRsJliuxxById(String id,String fydm,String rybh){
		String hql = "from RysxJiaoliuxx where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxJiaoliuxx)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsJliuxxById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxJialliuxx where NRybh=? and NId=?";
		List<RysxJiaoliuxx> listJiaoliuxx = getHibernateTemplate().find(hql,nrybh,bd);
		if(listJiaoliuxx==null||listJiaoliuxx.size()==0){
			return false;
		}else{
			RysxJiaoliuxx rysxJiaoliuxx = listJiaoliuxx.get(0);
			getHibernateTemplate().delete(rysxJiaoliuxx);
			return true;
		}
	}
	
	public boolean updateRsJliuxx(RysxJiaoliuxx rysxJiaoliuxx){
		if(rysxJiaoliuxx==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxJiaoliuxx);
			return true;
		}
	}
	
	public boolean interceptAddRsJiaoliuxx(RysxJiaoliuxx rysxJliuxx){
		try
		{
			getSession().save(rysxJliuxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateRsJiaoliuxx(RysxJiaoliuxx rysxJliuxx){
		try
		{
			getSession().update(rysxJliuxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsJiaoliuxxById(RysxJiaoliuxx rysxJliuxx){
		try
		{
			getSession().delete(rysxJliuxx);
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
	public List<RysxJiaoliuxx> getJiaoliuxxByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxJiaoliuxx rj where rj.NFy=? and rj.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxJiaoliuxx findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxJiaoliuxx)getSession().createQuery("from RysxJiaoliuxx rj where rj.NFy = ? and rj.NRybh = ? and rj.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_JIALLIUXX";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}
}