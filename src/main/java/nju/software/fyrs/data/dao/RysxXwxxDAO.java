package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxXwxx;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxXwxx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxXwxx
  * @author MyEclipse Persistence Tools 
 */
public class RysxXwxxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxXwxxDAO.class);
		//property constants
	public static final String _NXW = "NXw";
	public static final String _NSXZY = "NSxzy";
	public static final String _CSXZY = "CSxzy";
	public static final String _CXXMC = "CXxmc";
	public static final String _NJYXS = "NJyxs";
	public static final String _NXXLB = "NXxlb";
	public static final String _NXXXS = "NXxxs";
	public static final String _NXZ = "NXz";
	public static final String _NSYGJ = "NSygj";
	public static final String _NDQXX = "NDqxx";
	public static final String _NTBJL = "NTbjl";
	public static final String _CJLID = "CJlid";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxXwxx transientInstance) {
        log.debug("saving RysxXwxx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxXwxx persistentInstance) {
        log.debug("deleting RysxXwxx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxXwxx findById( nju.software.fyrs.data.dataobject.RysxXwxxId id) {
        log.debug("getting RysxXwxx instance with id: " + id);
        try {
            RysxXwxx instance = (RysxXwxx) getHibernateTemplate()
                    .get("software.fyrs.data.RysxXwxx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxXwxx> findByExample(RysxXwxx instance) {
        log.debug("finding RysxXwxx instance by example");
        try {
            List<RysxXwxx> results = (List<RysxXwxx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxXwxx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxXwxx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxXwxx> findByNXw(Object NXw
	) {
		return findByProperty(_NXW, NXw
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXwxx> findByNSxzy(Object NSxzy
	) {
		return findByProperty(_NSXZY, NSxzy
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXwxx> findByCSxzy(Object CSxzy
	) {
		return findByProperty(_CSXZY, CSxzy
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXwxx> findByCXxmc(Object CXxmc
	) {
		return findByProperty(_CXXMC, CXxmc
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXwxx> findByNJyxs(Object NJyxs
	) {
		return findByProperty(_NJYXS, NJyxs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXwxx> findByNXxlb(Object NXxlb
	) {
		return findByProperty(_NXXLB, NXxlb
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXwxx> findByNXxxs(Object NXxxs
	) {
		return findByProperty(_NXXXS, NXxxs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXwxx> findByNXz(Object NXz
	) {
		return findByProperty(_NXZ, NXz
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXwxx> findByNSygj(Object NSygj
	) {
		return findByProperty(_NSYGJ, NSygj
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXwxx> findByNDqxx(Object NDqxx
	) {
		return findByProperty(_NDQXX, NDqxx
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXwxx> findByNTbjl(Object NTbjl
	) {
		return findByProperty(_NTBJL, NTbjl
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXwxx> findByCJlid(Object CJlid
	) {
		return findByProperty(_CJLID, CJlid
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXwxx> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxXwxx instances");
		try {
			String queryString = "from RysxXwxx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxXwxx merge(RysxXwxx detachedInstance) {
        log.debug("merging RysxXwxx instance");
        try {
            RysxXwxx result = (RysxXwxx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxXwxx instance) {
        log.debug("attaching dirty RysxXwxx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxXwxx instance) {
        log.debug("attaching clean RysxXwxx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxXwxxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxXwxxDAO) ctx.getBean("RysxXwxxDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxXwxx> getXwxxByRybh(String rybh){
		String hql = "from RysxXwxx where NRybh=?";
		int nrybh = Integer.parseInt(rybh);
		List<RysxXwxx> listRysxXwxx = getHibernateTemplate().find(hql,nrybh);
		return listRysxXwxx;
	}
	
	public RysxXwxx getRsXwxxById(String id,String fydm,String rybh){
		String hql = "from RysxXwxx where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxXwxx)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	public boolean delRsXwxxById(String rybh,String bh){
		String hql="from RysxXwxx where NRybh=? and NId=?";
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd1 = new BigDecimal(bh);
		@SuppressWarnings("unchecked")
		List<RysxXwxx> RsXwxxList = getHibernateTemplate().find(hql,nrybh,bd1);
		if(RsXwxxList==null||RsXwxxList.size()==0){
			return false;
		}
		else {
			RysxXwxx rsXwxx=RsXwxxList.get(0);
			getHibernateTemplate().delete(rsXwxx);
			return true;
		}
	}
	
	public boolean updateRsXwxx(RysxXwxx rysxXwxx){
		if(rysxXwxx==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxXwxx);
			return true;
		}
	}

	
	//À¹½Ø
	public boolean interceptAddXwxx(RysxXwxx rysxXwxx){
		try
		{
			getSession().save(rysxXwxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateXwxx(RysxXwxx rysxXwxx){
		try
		{
			getSession().update(rysxXwxx);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsXwxxById(RysxXwxx rysxXwxx){
		try
		{
			getSession().delete(rysxXwxx);
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
	public List<RysxXwxx> getXwxxByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxXwxx rx where rx.NFy=? and rx.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxXwxx findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxXwxx)getSession().createQuery("from RysxXwxx rx where rx.NFy = ? and rx.NRybh = ? and rx.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_XWXX";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}

}