package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxDjxx;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxDjxx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxDjxx
  * @author MyEclipse Persistence Tools 
 */
public class RysxDjxxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxDjxxDAO.class);
		//property constants
	public static final String _NDJLB = "NDjlb";
	public static final String _NDJMC = "NDjmc";
	public static final String _CPZWH = "CPzwh";
	public static final String _NBDLB = "NBdlb";
	public static final String _NBDYY = "NBdyy";
	public static final String _CPZDW = "CPzdw";
	public static final String _CZSBH = "CZsbh";
	public static final String _NDQXX = "NDqxx";
	public static final String _CBDYJ = "CBdyj";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxDjxx transientInstance) {
        log.debug("saving RysxDjxx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxDjxx persistentInstance) {
        log.debug("deleting RysxDjxx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxDjxx findById( nju.software.fyrs.data.dataobject.RysxDjxxId id) {
        log.debug("getting RysxDjxx instance with id: " + id);
        try {
            RysxDjxx instance = (RysxDjxx) getHibernateTemplate()
                    .get("software.fyrs.data.RysxDjxx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxDjxx> findByExample(RysxDjxx instance) {
        log.debug("finding RysxDjxx instance by example");
        try {
            List<RysxDjxx> results = (List<RysxDjxx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxDjxx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxDjxx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxDjxx> findByNDjlb(Object NDjlb
	) {
		return findByProperty(_NDJLB, NDjlb
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxDjxx> findByNDjmc(Object NDjmc
	) {
		return findByProperty(_NDJMC, NDjmc
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxDjxx> findByCPzwh(Object CPzwh
	) {
		return findByProperty(_CPZWH, CPzwh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxDjxx> findByNBdlb(Object NBdlb
	) {
		return findByProperty(_NBDLB, NBdlb
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxDjxx> findByNBdyy(Object NBdyy
	) {
		return findByProperty(_NBDYY, NBdyy
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxDjxx> findByCPzdw(Object CPzdw
	) {
		return findByProperty(_CPZDW, CPzdw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxDjxx> findByCZsbh(Object CZsbh
	) {
		return findByProperty(_CZSBH, CZsbh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxDjxx> findByNDqxx(Object NDqxx
	) {
		return findByProperty(_NDQXX, NDqxx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxDjxx> findByCBdyj(Object CBdyj
	) {
		return findByProperty(_CBDYJ, CBdyj
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxDjxx> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxDjxx instances");
		try {
			String queryString = "from RysxDjxx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxDjxx merge(RysxDjxx detachedInstance) {
        log.debug("merging RysxDjxx instance");
        try {
            RysxDjxx result = (RysxDjxx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxDjxx instance) {
        log.debug("attaching dirty RysxDjxx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxDjxx instance) {
        log.debug("attaching clean RysxDjxx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxDjxxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxDjxxDAO) ctx.getBean("RysxDjxxDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxDjxx> getDjxxByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxDjxx where NRybh=?";
		List<RysxDjxx> listRysxDjxx = getHibernateTemplate().find(hql,nrybh);
		return listRysxDjxx;
		
	}
	
	public RysxDjxx getRsDjxxById(String id,String fydm,String rybh){
		String hql = "from RysxDjxx where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxDjxx)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsDjxxById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxDjxx where NRybh=? and NId=?";
		List<RysxDjxx> listRysxDjxx = getHibernateTemplate().find(hql,nrybh,bd);
		if(listRysxDjxx==null||listRysxDjxx.size()==0){
			return false;
		}else{
			RysxDjxx rysxDjxx = listRysxDjxx.get(0);
			getHibernateTemplate().delete(rysxDjxx);
			return true;
		}
	}
	
	public boolean updateRsDjxx(RysxDjxx rysxDjxx){
		if(rysxDjxx==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxDjxx);
			return true;
		}
	}
	
	public boolean interceptAddDjxx(RysxDjxx rysxDjxx){
		try
		{
			getSession().save(rysxDjxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateDjxx(RysxDjxx rysxDjxx){
		try
		{
			getSession().update(rysxDjxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsDjxxById(RysxDjxx rysxDjxx){
		try
		{
			getSession().delete(rysxDjxx);
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

	public List<RysxDjxx> getDjxxByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxDjxx rd where rd.NFy=? and rd.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxDjxx findByFyRybhId(int fy,int rybh,BigDecimal id)

	{
	   return (RysxDjxx)getSession().createQuery("from RysxDjxx rd where rd.NFy = ? and rd.NRybh = ? and rd.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_DJXX";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}

}