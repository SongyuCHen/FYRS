package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import nju.software.fyrs.data.dataobject.RywhLog;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.util.LoginUserInfoThreadLocal;
import nju.software.fyrs.util.StringUtil;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * RywhLog entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.RywhLog
 * @author MyEclipse Persistence Tools
 */

public class RywhLogDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(RywhLogDAO.class);
	// property constants
	public static final String _CCZYH = "CCzyh";
	public static final String _NDWID = "NDwid";
	public static final String _CIP = "CIp";
	public static final String _CCZNR = "CCznr";
	public static final String _NUSQLTYPE = "NUsqltype";

	protected void initDao() {
		// do nothing
	}

	@SuppressWarnings("deprecation")
	public void save(RywhLog transientInstance) {
		try {
			System.out
					.println(getSession().connection().getMetaData().getURL());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		log.debug("saving RywhLog instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RywhLog persistentInstance) {
		log.debug("deleting RywhLog instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RywhLog findById(java.math.BigDecimal id) {
		log.debug("getting RywhLog instance with id: " + id);
		try {
			RywhLog instance = (RywhLog) getHibernateTemplate().get(
					"nju.software.fyrs.data.dataobject.RywhLog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RywhLog> findByExample(RywhLog instance) {
		log.debug("finding RywhLog instance by example");
		try {
			List<RywhLog> results = (List<RywhLog>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding RywhLog instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RywhLog as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RywhLog> findByCCzyh(Object CCzyh) {
		return findByProperty(_CCZYH, CCzyh);
	}

	@SuppressWarnings("unchecked")
	public List<RywhLog> findByNDwid(Object NDwid) {
		return findByProperty(_NDWID, NDwid);
	}

	@SuppressWarnings("unchecked")
	public List<RywhLog> findByCIp(Object CIp) {
		return findByProperty(_CIP, CIp);
	}

	@SuppressWarnings("unchecked")
	public List<RywhLog> findByCCznr(Object CCznr) {
		return findByProperty(_CCZNR, CCznr);
	}

	@SuppressWarnings("unchecked")
	public List<RywhLog> findByNUsqltype(Object NUsqltype) {
		return findByProperty(_NUSQLTYPE, NUsqltype);
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RywhLog instances");
		try {
			String queryString = "from RywhLog";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RywhLog merge(RywhLog detachedInstance) {
		log.debug("merging RywhLog instance");
		try {
			RywhLog result = (RywhLog) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RywhLog instance) {
		log.debug("attaching dirty RywhLog instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RywhLog instance) {
		log.debug("attaching clean RywhLog instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RywhLogDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RywhLogDAO) ctx.getBean("RywhLogDAO");
	}

	// myCode
	@SuppressWarnings("unchecked")
	public List<RywhLog> listByTimeOperUser(String operUser,
			String operBeginTime, String operEndTime, String operType) {
		List<RywhLog> rywhLogs = null;
		Object[] strArray = { null, null, null, null, null, null };
		String before = "from RywhLog rl where ";
		String hql = "";
		boolean isWhere = false;
		if (!StringUtil.isEmpty(operUser)) {
			hql += "and rl.CCzyh = ? ";
			strArray[0] = operUser;
			isWhere = true;
		}
		// 两个时间值都有
		if (!StringUtil.isEmpty(operBeginTime)
				&& !StringUtil.isEmpty(operEndTime)) {
			hql += "and rl.DCzsj >= ? and rl.DCzsj <= ?";
			strArray[1] = DateUtil.parse(operBeginTime, "yyyy-MM-dd");
			strArray[2] = DateUtil
					.add(DateUtil.parse(operEndTime, "yyyy-MM-dd"),
							Calendar.DATE, 1);
			isWhere = true;
		}
		// 说明只有后面时间是空的
		if (!StringUtil.isEmpty(operBeginTime)
				&& StringUtil.isEmpty(operEndTime)) {
			hql += "and rl.DCzsj >= ? ";
			strArray[3] = DateUtil.parse(operBeginTime, "yyyy-MM-dd");
			isWhere = true;
		}
		// 说明是前面时间是空的
		if (!StringUtil.isEmpty(operEndTime)
				&& StringUtil.isEmpty(operBeginTime)) {
			hql += "and rl.DCzsj <= ? ";
			strArray[4] = DateUtil
					.add(DateUtil.parse(operEndTime, "yyyy-MM-dd"),
							Calendar.DATE, 1);
			isWhere = true;
		}
		if (!StringUtil.isEmpty(operType)) {
			// "增加" --- 1 ,"删除" --- 2 ,"修改" --- 3
			String[] types = { "增加", "删除", "修改" };
			hql += "and rl.CCznr like ? ";
			strArray[5] = types[Integer.valueOf(operType) - 1] + "%";
			isWhere = true;
		}
		if (!isWhere) {
			rywhLogs = getSession().createQuery(
					"from RywhLog rl order by rl.DCzsj desc ").list();
		} else {
			hql = hql.substring(3, hql.length());
			Query query = getSession().createQuery(
					before + hql + " order by rl.DCzsj desc ");
			int i = 0;
			for (Object obj : strArray) {
				if (null != obj) {
					query.setParameter(i, obj);
					i++;
				}
			}
			rywhLogs = query.list();
		}

		return rywhLogs;
	}

	public BigDecimal getMaxNid(int fydm) {
		String hql = "select max(N_ID) from T_RYWH_LOG";
		return DaoUtils.getMaxIdRyjbxx(getSession(), fydm, hql);
	}

	public RywhLog getMaxNidWithRywhLog(int fydm) {
		synchronized (RywhLogDAO.class) {
			RywhLog rywhLog = null;
			String hql = "select max(N_ID) from T_RYWH_LOG";
			Query query = getSession().createSQLQuery(hql);
			Object object = query.uniqueResult();
			BigDecimal maxBh = BigDecimal.valueOf(fydm, -10).add(
					BigDecimal.valueOf(1));
			if (null != object) {
				maxBh = (BigDecimal) object;
				maxBh = maxBh.add(BigDecimal.valueOf(1));
			}
			rywhLog = new RywhLog();
			rywhLog.setNId(maxBh);
			rywhLog.setNDwid(fydm);
			rywhLog.setCCzyh(LoginUserInfoThreadLocal.getUsername());
			getSession().save(rywhLog);
			return rywhLog;
		}

	}

	public void mSaveOrUpdate(RywhLog rywhLog) {
		getSession().saveOrUpdate(rywhLog);
		getSession().flush();
	}

	@SuppressWarnings("unchecked")
	public List<RywhLog> listAll(String time) {
		String hql = "from RywhLog rl where rl.DCzsj > ? order by rl.DCzsj desc ";
		return getSession().createQuery(hql)
				.setParameter(0, DateUtil.parse(time, DateUtil.webFormat))
				.list();
	}

	// 查询记录中时间的最大值与最小值
	public Date[] findMaxAndMinDate() {
		String hql = "select max(DCzsj),min(DCzsj) from RywhLog";
		@SuppressWarnings("unchecked")
		List<Object[]> lists = (List<Object[]>) getSession().createQuery(hql)
				.list();
		if (lists.size() == 0) {
			return null;
		}
		Date[] date = new Date[2];
		Object[] objs = lists.get(0);
		date[0] = (Date) objs[0];
		date[1] = (Date) objs[1];
		return date;
	}

	public synchronized void recoverSystemAdd(Object obj) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(obj);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	public synchronized void recoverSystemUpdate(Object obj) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			// session.saveOrUpdate(obj);
			session.update(obj);
			tx.commit();
			session.flush();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	public synchronized void recoverSystemDelete(Object obj) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(obj);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

}