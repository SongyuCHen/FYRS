package nju.software.fyrs.data.dao;

import java.util.List;

import nju.software.fyrs.data.dataobject.DdField;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * DdField entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.DdField
 * @author MyEclipse Persistence Tools
 */

public class DdFieldDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory.getLogger(DdFieldDAO.class);
	// property constants
	public static final String _CTABLEID = "CTableid";
	public static final String _CFIELDNAME = "CFieldname";
	public static final String _CCNNAME = "CCnname";
	public static final String _NDATATYPE = "NDatatype";
	public static final String _BKEY = "BKey";
	public static final String _NLENGTH = "NLength";
	public static final String _CPRECISION = "CPrecision";
	public static final String _BCANNULL = "BCannull";
	public static final String _NLOGICTYPE = "NLogictype";
	public static final String _NMAINCODE = "NMaincode";
	public static final String _BQCONDITION = "BQcondition";
	public static final String _BQRESULT = "BQresult";
	public static final String _BUSERDEFINED = "BUserdefined";
	public static final String _NORDER = "NOrder";

	protected void initDao()
	{
		// do nothing
	}

	public void save(DdField transientInstance)
	{
		log.debug("saving DdField instance");
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

	public void delete(DdField persistentInstance)
	{
		log.debug("deleting DdField instance");
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

	public DdField findById(java.lang.String id)
	{
		log.debug("getting DdField instance with id: " + id);
		try
		{
			DdField instance = (DdField) getHibernateTemplate().get(
					"nju.software.fyrs.data.dataobject.DdField", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DdField> findByExample(DdField instance)
	{
		log.debug("finding DdField instance by example");
		try
		{
			List<DdField> results = (List<DdField>) getHibernateTemplate()
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
		log.debug("finding DdField instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from DdField as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DdField> findByCTableid(Object CTableid)
	{
		return findByProperty(_CTABLEID, CTableid);
	}

	@SuppressWarnings("unchecked")
	public List<DdField> findByCFieldname(Object CFieldname)
	{
		return findByProperty(_CFIELDNAME, CFieldname);
	}

	@SuppressWarnings("unchecked")
	public List<DdField> findByCCnname(Object CCnname)
	{
		return findByProperty(_CCNNAME, CCnname);
	}

	@SuppressWarnings("unchecked")
	public List<DdField> findByNDatatype(Object NDatatype)
	{
		return findByProperty(_NDATATYPE, NDatatype);
	}

	@SuppressWarnings("unchecked")
	public List<DdField> findByBKey(Object BKey)
	{
		return findByProperty(_BKEY, BKey);
	}

	@SuppressWarnings("unchecked")
	public List<DdField> findByNLength(Object NLength)
	{
		return findByProperty(_NLENGTH, NLength);
	}

	@SuppressWarnings("unchecked")
	public List<DdField> findByCPrecision(Object CPrecision)
	{
		return findByProperty(_CPRECISION, CPrecision);
	}

	@SuppressWarnings("unchecked")
	public List<DdField> findByBCannull(Object BCannull)
	{
		return findByProperty(_BCANNULL, BCannull);
	}

	@SuppressWarnings("unchecked")
	public List<DdField> findByNLogictype(Object NLogictype)
	{
		return findByProperty(_NLOGICTYPE, NLogictype);
	}

	@SuppressWarnings("unchecked")
	public List<DdField> findByNMaincode(Object NMaincode)
	{
		return findByProperty(_NMAINCODE, NMaincode);
	}

	@SuppressWarnings("unchecked")
	public List<DdField> findByBQcondition(Object BQcondition)
	{
		return findByProperty(_BQCONDITION, BQcondition);
	}

	@SuppressWarnings("unchecked")
	public List<DdField> findByBQresult(Object BQresult)
	{
		return findByProperty(_BQRESULT, BQresult);
	}

	@SuppressWarnings("unchecked")
	public List<DdField> findByBUserdefined(Object BUserdefined)
	{
		return findByProperty(_BUSERDEFINED, BUserdefined);
	}

	@SuppressWarnings("unchecked")
	public List<DdField> findByNOrder(Object NOrder)
	{
		return findByProperty(_NORDER, NOrder);
	}

	@SuppressWarnings("rawtypes")
	public List findAll()
	{
		log.debug("finding all DdField instances");
		try
		{
			String queryString = "from DdField";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public DdField merge(DdField detachedInstance)
	{
		log.debug("merging DdField instance");
		try
		{
			DdField result = (DdField) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DdField instance)
	{
		log.debug("attaching dirty DdField instance");
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

	public void attachClean(DdField instance)
	{
		log.debug("attaching clean DdField instance");
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

	public static DdFieldDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (DdFieldDAO) ctx.getBean("DdFieldDAO");
	}
	// myCode
	@SuppressWarnings("unchecked")
	public List<DdField> listByTableNameShow(String tableName)
	{
		return getSession().createQuery("from DdField where CTableid = ? and BQresult = 1 order by NOrder ").setParameter(0,tableName).list();
	}
	@SuppressWarnings("unchecked")
	public List<DdField> listByTableNameCondtion(String tableName)
	{
		return getSession().createQuery("from DdField where CTableid = ? and BQcondition = 1 order by NOrder ").setParameter(0,tableName).list();
	}
	// myCode

	public Short getMaincodeByTableIdAndFieldName(String tableId,
			String fieldName) {
		return (Short) getSession().createQuery("select NMaincode from DdField where CTableid = ? and CFieldname = ? order by NOrder ")
				.setParameter(0,tableId).setParameter(1, fieldName).uniqueResult();
	}

	public String getCnnameByTableIdAndFieldName(String tableId,
			String fieldName) {
		return (String) getSession().createQuery("select CCnname from DdField where CTableid = ? and CFieldname = ? order by NOrder ")
				.setParameter(0,tableId).setParameter(1, fieldName).uniqueResult();
	}
}