package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.SysBackup;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * SysBackup entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.SysBackup
 * @author MyEclipse Persistence Tools
 */

public class SysBackupDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory
			.getLogger(SysBackupDAO.class);
	// property constants
	public static final String _NBACKTYPE = "NBacktype";
	public static final String _CFILENAME = "CFilename";
	public static final String _CPATH = "CPath";

	protected void initDao()
	{
		// do nothing
	}

	public void save(SysBackup transientInstance)
	{
		log.debug("saving SysBackup instance");
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

	public void delete(SysBackup persistentInstance)
	{
		log.debug("deleting SysBackup instance");
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

	public SysBackup findById(BigDecimal id)
	{
		log.debug("getting SysBackup instance with id: " + id);
		try
		{
			SysBackup instance = (SysBackup) getHibernateTemplate().get(
					"nju.software.fyrs.data.dataobject.SysBackup", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SysBackup> findByExample(SysBackup instance)
	{
		log.debug("finding SysBackup instance by example");
		try
		{
			List<SysBackup> results = (List<SysBackup>) getHibernateTemplate()
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
		log.debug("finding SysBackup instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from SysBackup as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SysBackup> findByNBacktype(Object NBacktype)
	{
		return findByProperty(_NBACKTYPE, NBacktype);
	}

	@SuppressWarnings("unchecked")
	public List<SysBackup> findByCFilename(Object CFilename)
	{
		return findByProperty(_CFILENAME, CFilename);
	}

	@SuppressWarnings("unchecked")
	public List<SysBackup> findByCPath(Object CPath)
	{
		return findByProperty(_CPATH, CPath);
	}

	@SuppressWarnings("rawtypes")
	public List findAll()
	{
		log.debug("finding all SysBackup instances");
		try
		{
			String queryString = "from SysBackup";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public SysBackup merge(SysBackup detachedInstance)
	{
		log.debug("merging SysBackup instance");
		try
		{
			SysBackup result = (SysBackup) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SysBackup instance)
	{
		log.debug("attaching dirty SysBackup instance");
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

	public void attachClean(SysBackup instance)
	{
		log.debug("attaching clean SysBackup instance");
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

	public static SysBackupDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (SysBackupDAO) ctx.getBean("SysBackupDAO");
	}
	// myCode
	@SuppressWarnings("unchecked")
	public List<SysBackup> listSysBackup()
	{
		return getSession().createQuery("from SysBackup order by  DBacktime desc ").list();
	}
	public BigDecimal getMaxId()
	{
		Object obj = getSession().createSQLQuery(" select max(N_ID) FROM T_SYSBACKUP").uniqueResult();
		BigDecimal maxId = new BigDecimal("5100000000000");
		if(null != obj)
		{
			maxId = (BigDecimal)obj;
		}
		return maxId.add(BigDecimal.valueOf(1));
	}
	public SysBackup getTheNewSysBackup()
	{
		SysBackup sysBackup = (SysBackup) getSession().createQuery(" FROM SysBackup where DBacktime = (select MAX(DBacktime) FROM SysBackup) ").uniqueResult();
	    return sysBackup;
	}
	// myCode

	public SysBackup findById(String nid)
	{
		return (SysBackup) getSession().createQuery(" from  SysBackup where NId = ?").setParameter(0, new BigDecimal(nid)).uniqueResult();
	}
}