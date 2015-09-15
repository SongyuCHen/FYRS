package nju.software.fyrs.data.dao;

import java.util.List;

import nju.software.fyrs.data.dataobject.Field;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for Field entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see nju.software.fyrs.data.dataobject.Field
  * @author MyEclipse Persistence Tools 
 */
public class FieldDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(FieldDAO.class);
		//property constants
	public static final String _NORDER = "NOrder";
	public static final String _CCNNAME = "CCnname";
	public static final String _CVALUEDESC = "CValuedesc";
	public static final String _CCONSTRANINTSDESC = "CConstranintsdesc";
	public static final String _CTYPE = "CType";
	public static final String _NISTRANS = "NIstrans";
	public static final String _NVALIDATE = "NValidate";
	public static final String _NSFXS = "NSfxs";
	public static final String _NSFBT = "NSfbt";



	protected void initDao() {
		//do nothing
	}
    
    public void save(Field transientInstance) {
        log.debug("saving Field instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Field persistentInstance) {
        log.debug("deleting Field instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Field findById( nju.software.fyrs.data.dataobject.FieldId id) {
        log.debug("getting Field instance with id: " + id);
        try {
            Field instance = (Field) getHibernateTemplate()
                    .get("software.fyrs.data.Field", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<Field> findByExample(Field instance) {
        log.debug("finding Field instance by example");
        try {
            List<Field> results = (List<Field>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    @SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding Field instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Field as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	@SuppressWarnings("unchecked")
	public List<Field> findByNOrder(Object NOrder
	) {
		return findByProperty(_NORDER, NOrder
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Field> findByCCnname(Object CCnname
	) {
		return findByProperty(_CCNNAME, CCnname
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Field> findByCValuedesc(Object CValuedesc
	) {
		return findByProperty(_CVALUEDESC, CValuedesc
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Field> findByCConstranintsdesc(Object CConstranintsdesc
	) {
		return findByProperty(_CCONSTRANINTSDESC, CConstranintsdesc
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Field> findByCType(Object CType
	) {
		return findByProperty(_CTYPE, CType
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Field> findByNIstrans(Object NIstrans
	) {
		return findByProperty(_NISTRANS, NIstrans
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Field> findByNValidate(Object NValidate
	) {
		return findByProperty(_NVALIDATE, NValidate
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Field> findByNSfxs(Object NSfxs
	) {
		return findByProperty(_NSFXS, NSfxs
		);
	}
	
	@SuppressWarnings("unchecked")
	public List<Field> findByNSfbt(Object NSfbt
	) {
		return findByProperty(_NSFBT, NSfbt
		);
	}
	

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all Field instances");
		try {
			String queryString = "from Field";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Field merge(Field detachedInstance) {
        log.debug("merging Field instance");
        try {
            Field result = (Field) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Field instance) {
        log.debug("attaching dirty Field instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Field instance) {
        log.debug("attaching clean Field instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static FieldDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (FieldDAO) ctx.getBean("FieldDAO");
	}
}