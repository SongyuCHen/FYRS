package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dataobject.Jlwh;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Jlwh
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.Jlwh
 * @author MyEclipse Persistence Tools
 */

public class JlwhDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory.getLogger(JlwhDAO.class);
	// property constants
	public static final String _NQYJL = "NQyjl";
	public static final String _NJLBM = "NJlbm";
	public static final String _NJTJLLB = "NJtjllb";
	public static final String _CJLMC = "CJlmc";
	public static final String _NJLYY = "NJlyy";
	public static final String _NJLJB = "NJljb";
	public static final String _CPZDW = "CPzdw";
	public static final String _CPZWH = "CPzwh";
	public static final String _CBZ = "CBz";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Jlwh transientInstance)
	{
		log.debug("saving Jlwh instance");
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

	public void delete(Jlwh persistentInstance)
	{
		log.debug("deleting Jlwh instance");
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

	public Jlwh findById(nju.software.fyrs.data.dataobject.JlwhId id)
	{
		log.debug("getting Jlwh instance with id: " + id);
		try
		{
			Jlwh instance = (Jlwh) getHibernateTemplate().get(
					"nju.software.fyrs.data.dataobject.Jlwh", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Jlwh> findByExample(Jlwh instance)
	{
		log.debug("finding Jlwh instance by example");
		try
		{
			List<Jlwh> results = (List<Jlwh>) getHibernateTemplate()
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
		log.debug("finding Jlwh instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Jlwh as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Jlwh> findByNQyjl(Object NQyjl)
	{
		return findByProperty(_NQYJL, NQyjl);
	}

	@SuppressWarnings("unchecked")
	public List<Jlwh> findByNJlbm(Object NJlbm)
	{
		return findByProperty(_NJLBM, NJlbm);
	}

	@SuppressWarnings("unchecked")
	public List<Jlwh> findByNJtjllb(Object NJtjllb)
	{
		return findByProperty(_NJTJLLB, NJtjllb);
	}

	@SuppressWarnings("unchecked")
	public List<Jlwh> findByCJlmc(Object CJlmc)
	{
		return findByProperty(_CJLMC, CJlmc);
	}

	@SuppressWarnings("unchecked")
	public List<Jlwh> findByNJlyy(Object NJlyy)
	{
		return findByProperty(_NJLYY, NJlyy);
	}

	@SuppressWarnings("unchecked")
	public List<Jlwh> findByNJljb(Object NJljb)
	{
		return findByProperty(_NJLJB, NJljb);
	}

	@SuppressWarnings("unchecked")
	public List<Jlwh> findByCPzdw(Object CPzdw)
	{
		return findByProperty(_CPZDW, CPzdw);
	}

	@SuppressWarnings("unchecked")
	public List<Jlwh> findByCPzwh(Object CPzwh)
	{
		return findByProperty(_CPZWH, CPzwh);
	}

	@SuppressWarnings("unchecked")
	public List<Jlwh> findByCBz(Object CBz)
	{
		return findByProperty(_CBZ, CBz);
	}

	@SuppressWarnings("rawtypes")
	public List findAll()
	{
		log.debug("finding all Jlwh instances");
		try
		{
			String queryString = "from Jlwh";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Jlwh merge(Jlwh detachedInstance)
	{
		log.debug("merging Jlwh instance");
		try
		{
			Jlwh result = (Jlwh) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Jlwh instance)
	{
		log.debug("attaching dirty Jlwh instance");
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

	public void attachClean(Jlwh instance)
	{
		log.debug("attaching clean Jlwh instance");
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

	public static JlwhDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (JlwhDAO) ctx.getBean("JlwhDAO");
	}
   // myCode
	@SuppressWarnings("unchecked")
	public List<Jlwh> listJlwhByFyBm(int fydm, int bmbh) {
		return getSession().createQuery("from Jlwh jh where jh.NFy = ? and jh.NJlbm = ? order by jh.DJlsj desc ").setParameter(0,fydm).setParameter(1,bmbh).list();
	}

	@SuppressWarnings("unchecked")
	public List<Jlwh> listJlwhByFy(int fydm) {
		return getSession().createQuery("from Jlwh jh where jh.NFy = ? order by jh.DJlsj desc ").setParameter(0,fydm).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Jlwh> listJlwhByFyAsc(int fydm) {
		return getSession().createQuery("from Jlwh jh where jh.NFy = ? order by jh.DJlsj asc ").setParameter(0,fydm).list();
	}
	
	public BigDecimal getMaxId(int fydm)
	{
		BigDecimal maxId = DaoUtils.getMaxIdBeginFydmBigDecimal(getSession(), fydm, " select max(n_id) from T_JLWH where n_fy = ? ",new Object[]{fydm});
		return maxId;
	}
	public Jlwh getJlwh(int fydm, String nid)
	{
		return (Jlwh) getSession().createQuery("from Jlwh jh where jh.NFy = ? and jh.NId = ? ").setParameter(0, fydm).setParameter(1,new BigDecimal(nid)).uniqueResult();
	}
	public void updateJlwh(Jlwh jlwh)
	{
		getSession().update(jlwh);
	}

  // myCode

	
	
}