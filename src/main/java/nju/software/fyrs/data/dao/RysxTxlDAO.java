package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxTxl;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for RysxTxl entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.RysxTxl
  * @author MyEclipse Persistence Tools 
 */
public class RysxTxlDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RysxTxlDAO.class);
		//property constants
	public static final String _CQH = "CQh";
	public static final String _CBGDH = "CBgdh";
	public static final String _CJTDH = "CJtdh";
	public static final String _CYDDH = "CYddh";
	public static final String _CYZBM = "CYzbm";
	public static final String _CTXDZ = "CTxdz";
	public static final String _NXSSX = "NXssx";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RysxTxl transientInstance) {
        log.debug("saving RysxTxl instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RysxTxl persistentInstance) {
        log.debug("deleting RysxTxl instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RysxTxl findById( nju.software.fyrs.data.dataobject.RysxTxlId id) {
        log.debug("getting RysxTxl instance with id: " + id);
        try {
            RysxTxl instance = (RysxTxl) getHibernateTemplate()
                    .get("software.fyrs.data.RysxTxl", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<RysxTxl> findByExample(RysxTxl instance) {
        log.debug("finding RysxTxl instance by example");
        try {
            List<RysxTxl> results = (List<RysxTxl>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding RysxTxl instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RysxTxl as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<RysxTxl> findByCQh(Object CQh
	) {
		return findByProperty(_CQH, CQh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxTxl> findByCBgdh(Object CBgdh
	) {
		return findByProperty(_CBGDH, CBgdh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxTxl> findByCJtdh(Object CJtdh
	) {
		return findByProperty(_CJTDH, CJtdh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxTxl> findByCYddh(Object CYddh
	) {
		return findByProperty(_CYDDH, CYddh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxTxl> findByCYzbm(Object CYzbm
	) {
		return findByProperty(_CYZBM, CYzbm
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxTxl> findByCTxdz(Object CTxdz
	) {
		return findByProperty(_CTXDZ, CTxdz
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxTxl> findByNXssx(Object NXssx
	) {
		return findByProperty(_NXSSX, NXssx
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxTxl instances");
		try {
			String queryString = "from RysxTxl";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RysxTxl merge(RysxTxl detachedInstance) {
        log.debug("merging RysxTxl instance");
        try {
            RysxTxl result = (RysxTxl) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RysxTxl instance) {
        log.debug("attaching dirty RysxTxl instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RysxTxl instance) {
        log.debug("attaching clean RysxTxl instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RysxTxlDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RysxTxlDAO) ctx.getBean("RysxTxlDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxTxl> getTxlByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxTxl where NRybh=?";
		List<RysxTxl> listRysxTxl = getHibernateTemplate().find(hql,nrybh);
		return listRysxTxl;
	}
	
	public RysxTxl getRsTxlById(String id,String fydm,String rybh){
		String hql = "from RysxTxl where NId=? and NFy=? and NRybh=?";
		BigDecimal bigDecimal = new BigDecimal(id);
		return (RysxTxl)getSession().createQuery(hql).setParameter(0,bigDecimal).setParameter(1,Integer.valueOf(fydm)).setParameter(2, Integer.valueOf(rybh)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRsTxlById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxTxl where NRybh=? and NId=?";
		List<RysxTxl> listRysxTxl = getHibernateTemplate().find(hql,nrybh,bd);
		if(listRysxTxl==null||listRysxTxl.size()==0){
			return false;
		}else{
			RysxTxl rysxTxl = listRysxTxl.get(0);
			getHibernateTemplate().delete(rysxTxl);
			return true;
		}
	}
	
	public boolean updateRsTxl(RysxTxl rysxTxl){
		if(rysxTxl==null){
			return false;
		}else{
			getHibernateTemplate().update(rysxTxl);
			return true;
		}
	}
	
	public boolean interceptAddTxl(RysxTxl rysxTxl){
		try
		{
			getSession().save(rysxTxl);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateTxl(RysxTxl rysxTxl){
		try
		{
			getSession().update(rysxTxl);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsTxlById(RysxTxl rysxTxl){
		try
		{
			getSession().delete(rysxTxl);
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
	public List<RysxTxl> getTxlByRybhFy(int rybh,int fydm){
		return getSession().createQuery("from RysxTxl rk where rk.NFy=? and rk.NRybh=?").setParameter(0,Integer.valueOf(fydm)).setParameter(1,Integer.valueOf(rybh)).list();
	}
	
	public RysxTxl findByFyRybhId(int fy,int rybh,BigDecimal id)
	{
	   return (RysxTxl)getSession().createQuery("from RysxTxl rk where rk.NFy = ? and rk.NRybh = ? and rk.NId = ? ").setParameter(0,fy).setParameter(1, rybh).setParameter(2,id).uniqueResult();	
	}
	public BigDecimal getMaxNid(int fydm)
	{
		String hql = "select max(N_ID) from T_RYSX_TXL";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
		
	}

}