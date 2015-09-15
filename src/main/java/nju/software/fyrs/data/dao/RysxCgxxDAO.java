package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxCgxx;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxCgxx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxCgxx
  * @author MyEclipse Persistence Tools 
 */
public class RysxCgxxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxCgxxDAO.class);
		//property constants
	public static final String _NGB = "NGb";
	public static final String _NCGXZ = "NCgxz";
	public static final String _NCGSF = "NCgsf";
	public static final String _CJFLY = "CJfly";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxCgxx transientInstance) {
        log.debug("saving RysxCgxx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxCgxx persistentInstance) {
        log.debug("deleting RysxCgxx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxCgxx findById( nju.software.fyrs.data.dataobject.RysxCgxxId id) {
        log.debug("getting RysxCgxx instance with id: " + id);
        try {
            RysxCgxx instance = (RysxCgxx) getHibernateTemplate()
                    .get("software.fyrs.data.RysxCgxx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxCgxx> findByExample(RysxCgxx instance) {
        log.debug("finding RysxCgxx instance by example");
        try {
            List<RysxCgxx> results = (List<RysxCgxx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxCgxx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxCgxx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

    @SuppressWarnings("unchecked")
	public List<RysxCgxx> findByNGb(Object NGb
	) {
		return findByProperty(_NGB, NGb
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxCgxx> findByNCgxz(Object NCgxz
	) {
		return findByProperty(_NCGXZ, NCgxz
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxCgxx> findByNCgsf(Object NCgsf
	) {
		return findByProperty(_NCGSF, NCgsf
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxCgxx> findByCJfly(Object CJfly
	) {
		return findByProperty(_CJFLY, CJfly
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxCgxx> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxCgxx instances");
		try {
			String queryString = "from RysxCgxx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxCgxx merge(RysxCgxx detachedInstance) {
        log.debug("merging RysxCgxx instance");
        try {
            RysxCgxx result = (RysxCgxx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxCgxx instance) {
        log.debug("attaching dirty RysxCgxx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxCgxx instance) {
        log.debug("attaching clean RysxCgxx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxCgxxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxCgxxDAO) ctx.getBean("RysxCgxxDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxCgxx> getCgxxByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxCgxx where NRybh=?";
		List<RysxCgxx> listRysxCgxx = getHibernateTemplate().find(hql,nrybh);
		return listRysxCgxx;
	}
	
	public RysxCgxx getRsCgxxById(String id,String fydm,String rybh){
		String hql = "from RysxCgxx where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxCgxx)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsCgxxById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxCgxx where NRybh=? and NId=?";
		List<RysxCgxx> listRysxCgxx = getHibernateTemplate().find(hql,nrybh,bd);
		if(listRysxCgxx==null||listRysxCgxx.size()==0){
			return false;
		}else{
			RysxCgxx rysxCgxx = listRysxCgxx.get(0);
			getHibernateTemplate().delete(rysxCgxx);
			return true;
		}
	}
	
	public boolean updateRsCgxx(RysxCgxx rysxCgxx){
		if(rysxCgxx==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxCgxx);
			return true;
		}
	}
	
	// myCode
	@SuppressWarnings("unchecked")
	public List<RysxCgxx> getCgxxByRybhFy(int rybh,int fydm)
	{
	return getSession().createQuery("from RysxCgxx rz where rz.NFy = ? and rz.NRybh = ? order by DKssj").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	// myCode
	public boolean interceptAddCgxx(RysxCgxx rysxCgxx){
		try
		{
			getSession().save(rysxCgxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateCgxx(RysxCgxx rysxCgxx){
		try
		{
			getSession().update(rysxCgxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsCgxxById(RysxCgxx rysxCgxx){
		try
		{
			getSession().delete(rysxCgxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public RysxCgxx findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxCgxx)getSession().createQuery("from RysxCgxx rk where rk.NFy = ? and rk.NRybh = ? and rk.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_CGXX";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}


	
}