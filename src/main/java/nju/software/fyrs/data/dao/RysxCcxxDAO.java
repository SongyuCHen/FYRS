package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxCcxx;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxCcxx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxCcxx
  * @author MyEclipse Persistence Tools 
 */
public class RysxCcxxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxCcxxDAO.class);
		//property constants
	public static final String _NCCLB = "NCclb";
	public static final String _NCCYY = "NCcyy";
	public static final String _CPZDW = "CPzdw";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxCcxx transientInstance) {
        log.debug("saving RysxCcxx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxCcxx persistentInstance) {
        log.debug("deleting RysxCcxx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxCcxx findById( nju.software.fyrs.data.dataobject.RysxCcxxId id) {
        log.debug("getting RysxCcxx instance with id: " + id);
        try {
            RysxCcxx instance = (RysxCcxx) getHibernateTemplate()
                    .get("software.fyrs.data.RysxCcxx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxCcxx> findByExample(RysxCcxx instance) {
        log.debug("finding RysxCcxx instance by example");
        try {
            List<RysxCcxx> results = (List<RysxCcxx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxCcxx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxCcxx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxCcxx> findByNCclb(Object NCclb
	) {
		return findByProperty(_NCCLB, NCclb
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxCcxx> findByNCcyy(Object NCcyy
	) {
		return findByProperty(_NCCYY, NCcyy
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxCcxx> findByCPzdw(Object CPzdw
	) {
		return findByProperty(_CPZDW, CPzdw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxCcxx> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxCcxx instances");
		try {
			String queryString = "from RysxCcxx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxCcxx merge(RysxCcxx detachedInstance) {
        log.debug("merging RysxCcxx instance");
        try {
            RysxCcxx result = (RysxCcxx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxCcxx instance) {
        log.debug("attaching dirty RysxCcxx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxCcxx instance) {
        log.debug("attaching clean RysxCcxx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxCcxxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxCcxxDAO) ctx.getBean("RysxCcxxDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxCcxx> getCcxxByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxCcxx where NRybh=?";
		List<RysxCcxx> listRysxCcxx = getHibernateTemplate().find(hql,nrybh);
		return listRysxCcxx;
	}
	
	public RysxCcxx getRsCcxxById(String id,String fydm,String rybh){
		String hql = "from RysxCcxx where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxCcxx)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsCcxxById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxCcxx where NRybh=? and NId=?";
		List<RysxCcxx> listRysxCcxx = getHibernateTemplate().find(hql,nrybh,bd);
		if(listRysxCcxx==null||listRysxCcxx.size()==0){
			return false;
		}else{
			RysxCcxx rysxCcxx = listRysxCcxx.get(0);
			getHibernateTemplate().delete(rysxCcxx);
			return true;
		}
	}
	
	public boolean updateRsCcxx(RysxCcxx rysxCcxx){
		if(rysxCcxx==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxCcxx);
			return true;
		}
	}
	
	public boolean interceptAddCcxx(RysxCcxx rysxCcxx){
		try
		{
			getSession().save(rysxCcxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateCcxx(RysxCcxx rysxCcxx){
		try
		{
			getSession().update(rysxCcxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsCcxxById(RysxCcxx rysxCcxx){
		try
		{
			getSession().delete(rysxCcxx);
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
	public List<RysxCcxx> getCcxxByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxCcxx rj where rj.NFy=? and rj.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxCcxx findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxCcxx)getSession().createQuery("from RysxCcxx rj where rj.NFy = ? and rj.NRybh = ? and rj.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_CCXX";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}
}