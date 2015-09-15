package nju.software.fyrs.data.dao;

import java.util.List;

import nju.software.fyrs.data.dataobject.DdTable;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * DdTable entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.DdTable
 * @author MyEclipse Persistence Tools
 */

public class DdTableDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory.getLogger(DdTableDAO.class);
	// property constants
	public static final String _CTABLENAME = "CTablename";
	public static final String _CCNNAME = "CCnname";
	public static final String _BROOTTABLE = "BRoottable";
	public static final String _BUSERDEFINED = "BUserdefined";
	public static final String _NORDER = "NOrder";

	protected void initDao()
	{
		// do nothing
	}

	public void save(DdTable transientInstance)
	{
		log.debug("saving DdTable instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DdTable persistentInstance)
	{
		log.debug("deleting DdTable instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public DdTable findById(java.lang.String id)
	{
		log.debug("getting DdTable instance with id: " + id);
		try
		{
			DdTable instance = (DdTable) getHibernateTemplate().get(
					"nju.software.fyrs.data.dataobject.DdTable", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DdTable> findByExample(DdTable instance)
	{
		log.debug("finding DdTable instance by example");
		try
		{
			List<DdTable> results = (List<DdTable>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding DdTable instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from DdTable as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DdTable> findByCTablename(Object CTablename)
	{
		return findByProperty(_CTABLENAME, CTablename);
	}

	@SuppressWarnings("unchecked")
	public List<DdTable> findByCCnname(Object CCnname)
	{
		return findByProperty(_CCNNAME, CCnname);
	}

	@SuppressWarnings("unchecked")
	public List<DdTable> findByBRoottable(Object BRoottable)
	{
		return findByProperty(_BROOTTABLE, BRoottable);
	}

	@SuppressWarnings("unchecked")
	public List<DdTable> findByBUserdefined(Object BUserdefined)
	{
		return findByProperty(_BUSERDEFINED, BUserdefined);
	}

	@SuppressWarnings("unchecked")
	public List<DdTable> findByNOrder(Object NOrder)
	{
		return findByProperty(_NORDER, NOrder);
	}

	@SuppressWarnings("rawtypes")
	public List findAll()
	{
		log.debug("finding all DdTable instances");
		try
		{
			String queryString = "from DdTable";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public DdTable merge(DdTable detachedInstance)
	{
		log.debug("merging DdTable instance");
		try
		{
			DdTable result = (DdTable) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DdTable instance)
	{
		log.debug("attaching dirty DdTable instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DdTable instance)
	{
		log.debug("attaching clean DdTable instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DdTableDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (DdTableDAO) ctx.getBean("DdTableDAO");
	}
	// myCode 
	public DdTable findByCTablename(String tableName)
	{
		return (DdTable)getSession().createQuery("from DdTable where CTablename = ?").setParameter(0,tableName).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<DdTable> findAllTable()
	{
		return getSession().createQuery("from DdTable order by NOrder ").list();
	}
	// myCode 
	
}