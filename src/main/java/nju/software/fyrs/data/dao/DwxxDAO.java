package nju.software.fyrs.data.dao;

import java.util.List;

import nju.software.fyrs.data.dataobject.Dwxx;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for Dwxx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.Dwxx
  * @author MyEclipse Persistence Tools 
 */
public class DwxxDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(DwxxDAO.class);
		//property constants
	public static final String _CYZBM = "CYzbm";
	public static final String _CDWDZ = "CDwdz";
	public static final String _CLLDH = "CLldh";
	public static final String _CDWCZH = "CDwczh";
	public static final String _CRSFZR = "CRsfzr";
	public static final String _NZYXZBZS = "NZyxzbzs";
	public static final String _NZYSYBZS = "NZysybzs";
	public static final String _NDFXZBZS = "NDfxzbzs";
	public static final String _NXZFSBZS = "NXzfsbzs";
	public static final String _NDFQESYBZS = "NDfqesybzs";
	public static final String _NDFCESYBZS = "NDfcesybzs";
	public static final String _NDFZCZZSYBZS = "NDfzczzsybzs";
	public static final String _NQYBZS = "NQybzs";
	public static final String _CBGQK = "CBgqk";
	public static final String _NDQFY = "NDqfy";
	public static final String _NFKDQ = "NFkdq";



	protected void initDao() {
		//do nothing
	}
    
    public void save(Dwxx transientInstance) {
        log.debug("saving Dwxx instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Dwxx persistentInstance) {
        log.debug("deleting Dwxx instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Dwxx findById( java.lang.Integer id) {
        log.debug("getting Dwxx instance with id: " + id);
        try {
            Dwxx instance = (Dwxx) getHibernateTemplate()
                    .get("nju.software.fyrs.data.dataobject.Dwxx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<Dwxx> findByExample(Dwxx instance) {
        log.debug("finding Dwxx instance by example");
        try {
            List<Dwxx> results = (List<Dwxx>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding Dwxx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Dwxx as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<Dwxx> findByCYzbm(Object CYzbm
	) {
		return findByProperty(_CYZBM, CYzbm
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dwxx> findByCDwdz(Object CDwdz
	) {
		return findByProperty(_CDWDZ, CDwdz
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dwxx> findByCLldh(Object CLldh
	) {
		return findByProperty(_CLLDH, CLldh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dwxx> findByCDwczh(Object CDwczh
	) {
		return findByProperty(_CDWCZH, CDwczh
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dwxx> findByCRsfzr(Object CRsfzr
	) {
		return findByProperty(_CRSFZR, CRsfzr
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dwxx> findByNZyxzbzs(Object NZyxzbzs
	) {
		return findByProperty(_NZYXZBZS, NZyxzbzs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dwxx> findByNZysybzs(Object NZysybzs
	) {
		return findByProperty(_NZYSYBZS, NZysybzs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dwxx> findByNDfxzbzs(Object NDfxzbzs
	) {
		return findByProperty(_NDFXZBZS, NDfxzbzs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dwxx> findByNXzfsbzs(Object NXzfsbzs
	) {
		return findByProperty(_NXZFSBZS, NXzfsbzs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dwxx> findByNDfqesybzs(Object NDfqesybzs
	) {
		return findByProperty(_NDFQESYBZS, NDfqesybzs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dwxx> findByNDfcesybzs(Object NDfcesybzs
	) {
		return findByProperty(_NDFCESYBZS, NDfcesybzs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dwxx> findByNDfzczzsybzs(Object NDfzczzsybzs
	) {
		return findByProperty(_NDFZCZZSYBZS, NDfzczzsybzs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dwxx> findByNQybzs(Object NQybzs
	) {
		return findByProperty(_NQYBZS, NQybzs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dwxx> findByCBgqk(Object CBgqk
	) {
		return findByProperty(_CBGQK, CBgqk
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dwxx> findByNDqfy(Object NDqfy
	) {
		return findByProperty(_NDQFY, NDqfy
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dwxx> findByNFkdq(Object NFkdq
	) {
		return findByProperty(_NFKDQ, NFkdq
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all Dwxx instances");
		try {
			String queryString = "from Dwxx";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Dwxx merge(Dwxx detachedInstance) {
        log.debug("merging Dwxx instance");
        try {
            Dwxx result = (Dwxx) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Dwxx instance) {
        log.debug("attaching dirty Dwxx instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Dwxx instance) {
        log.debug("attaching clean Dwxx instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static DwxxDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (DwxxDAO) ctx.getBean("DwxxDAO");
	}
	
	
	// myCode
	public Dwxx findDwxxByFy(int fydm)
	{
		String hql = "from nju.software.fyrs.data.dataobject.Dwxx dw where wd.NFy = ?";
		return (Dwxx) getSession().createQuery(hql).setParameter(0,fydm).uniqueResult();
	}
	public void updateDwxxByFy(Dwxx dwxx)
	{
		getSession().update(dwxx);
	}
}