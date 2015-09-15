package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import nju.software.fyrs.biz.vo.JgbgVO;
import nju.software.fyrs.data.dataobject.Jgbg;
import nju.software.fyrs.util.DateUtil;

import org.hibernate.LockMode;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.impl.SessionFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Jgbg entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.Jgbg
 * @author MyEclipse Persistence Tools
 */

public class JgbgDAO extends HibernateDaoSupport {
	

	
	private static final Logger log = LoggerFactory
			.getLogger(JgbgDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Jgbg transientInstance) {
		log.debug("saving Jgbg instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Jgbg persistentInstance) {
		log.debug("deleting Jgbg instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(Jgbg persistentInstance){
		log.debug("update Jgbg instance");
		try {
			getHibernateTemplate().update(persistentInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed",re);
			throw re;
		}
	}

	public Jgbg findById(java.lang.Integer id) {
		log.debug("getting Jgbg instance with id: " + id);
		try {
			Jgbg instance = (Jgbg) getHibernateTemplate().get(
					"nju.software.fyrs.data.dataobject.Jgbg", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Jgbg> findByExample(Jgbg instance) {
		log.debug("finding Jgbg instance by example");
		try {
			List<Jgbg> results = (List<Jgbg>) getHibernateTemplate()
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
		log.debug("finding Jgbg instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Jgbg as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all Jgbg instances");
		try {
			String queryString = "from Jgbg";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Jgbg merge(Jgbg detachedInstance) {
		log.debug("merging Jgbg instance");
		try {
			Jgbg result = (Jgbg) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Jgbg instance) {
		log.debug("attaching dirty Jgbg instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Jgbg instance) {
		log.debug("attaching clean Jgbg instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static JgbgDAO getFromApplicationContext(ApplicationContext ctx) {
		return (JgbgDAO) ctx.getBean("JgbgDAO");
	}
	
	
	

	
	public String execsql(String bmdm,String lbbh){
		SessionFactoryImpl impl = (SessionFactoryImpl) getSessionFactory();
		ConnectionProvider provider = impl.getConnectionProvider();
		String sql = "select DMMS from PUB_DMB where LBBH = '"+lbbh+"' and DMBH ='"+bmdm+"'";
		String s = "";
		try {
			Connection conn = provider.getConnection();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				s = rs.getString(1);

			}
			rs.close();
			sta.close();
			conn.close();
			provider.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return s;
	}
	
	@SuppressWarnings("unchecked")
	public int getMaxCode(){
		String hql = "select max(checkCode) from Jgbg";
		List<Integer> s = getHibernateTemplate().find(hql);
		return s.get(0);
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Jgbg> getJgbgByRybh(String fybh){
		int nrybh = Integer.parseInt(fybh);
		String hql = "from Jgbg where NFybh=?";
		List<Jgbg> listJgbg = getHibernateTemplate().find(hql,fybh);		
		return listJgbg;
	}
	
	@SuppressWarnings("unchecked")
	public Jgbg getJgbgByRybhHtbh(String fybh,String id){
		int nrybh = Integer.parseInt(fybh);
		String hql = "from Jgbg where NFybh=? and NId=?";
		List<Jgbg> listJgbg = getHibernateTemplate().find(hql,fybh,id);		
		return listJgbg.size()>0?listJgbg.get(0):null;
	}
	
	@SuppressWarnings("unchecked")
	public Jgbg getJgbgById(String fybh,String id){
		int nrybh = Integer.parseInt(fybh);
		String hql = "from Jgbg where NFybh=? and NId=?";
		List<Jgbg> listJgbg = getHibernateTemplate().find(hql,fybh,id);		
		return listJgbg.size()>0?listJgbg.get(0):null;
	}
	
	public boolean delJgbgById(String fybh,String id){
		int nrybh = Integer.parseInt(fybh);
		BigDecimal bd = new BigDecimal(id);
		String hql = "from Jgbg where NFybh=? and NId=?";
		List<Jgbg> listJgbg = getHibernateTemplate().find(hql,fybh,id);	
		if(listJgbg==null || listJgbg.size()==0){
			return false;
		}else{
			Jgbg rysxHt = listJgbg.get(0);
			getHibernateTemplate().delete(rysxHt);
			return true;
		}
	}
	
	
	
	
	
}