package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxYujing;
import org.hibernate.LockMode;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.impl.SessionFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * RysxYujing entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.RysxYujing
 * @author MyEclipse Persistence Tools
 */

public class YujingDAO extends HibernateDaoSupport {
	

	
	private static final Logger log = LoggerFactory
			.getLogger(YujingDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(RysxYujing transientInstance) {
		log.debug("saving RysxYujing instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RysxYujing persistentInstance) {
		log.debug("deleting RysxYujing instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(RysxYujing persistentInstance){
		log.debug("update RysxYujing instance");
		try {
			getHibernateTemplate().update(persistentInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed",re);
			throw re;
		}
	}

	public RysxYujing findById(java.lang.Integer id) {
		log.debug("getting RysxYujing instance with id: " + id);
		try {
			RysxYujing instance = (RysxYujing) getHibernateTemplate().get(
					"nju.software.fyrs.data.dataobject.RysxYujing", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RysxYujing> findByExample(RysxYujing instance) {
		log.debug("finding RysxYujing instance by example");
		try {
			List<RysxYujing> results = (List<RysxYujing>) getHibernateTemplate()
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
		log.debug("finding RysxYujing instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RysxYujing as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxYujing instances");
		try {
			String queryString = "from RysxYujing";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RysxYujing merge(RysxYujing detachedInstance) {
		log.debug("merging RysxYujing instance");
		try {
			RysxYujing result = (RysxYujing) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RysxYujing instance) {
		log.debug("attaching dirty RysxYujing instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RysxYujing instance) {
		log.debug("attaching clean RysxYujing instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static YujingDAO getFromApplicationContext(ApplicationContext ctx) {
		return (YujingDAO) ctx.getBean("RysxYujingDAO");
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
		String hql = "select max(checkCode) from RysxYujing";
		List<Integer> s = getHibernateTemplate().find(hql);
		return s.get(0);
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<RysxYujing> getRysxYujingByRybh(String rybh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxYujing where NRybh=?";
		List<RysxYujing> listRysxYujing = getHibernateTemplate().find(hql,nrybh);		
		return listRysxYujing;
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxYujing> getRysxYujingByFy(String fy){
		int nfy = Integer.parseInt(fy);
		String hql = "from RysxYujing where NFy=?";
		List<RysxYujing> listRysxYujing = getHibernateTemplate().find(hql,nfy);		
		return listRysxYujing;
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxYujing> getRysxYujingByFyAndDate(String fy,Date begin, Date end){
		int nfy = Integer.parseInt(fy);
		String hql = "from RysxYujing where NFy=? and DYjsj>= ? and DYjsj <= ?";
		List<RysxYujing> listRysxYujing = getHibernateTemplate().find(hql,nfy,begin,end);		
		return listRysxYujing;
	}
	
	@SuppressWarnings("unchecked")
	public RysxYujing getRysxYujingByRybhHtbh(String rybh,String htbh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxYujing where NRybh=? and CHtbh=?";
		List<RysxYujing> listRysxYujing = getHibernateTemplate().find(hql,nrybh,htbh);		
		return listRysxYujing.size()>0?listRysxYujing.get(0):null;
	}
	
	@SuppressWarnings("unchecked")
	public RysxYujing getRysxYujingById(String id, String fydm, String rybh){
		int nrybh = Integer.parseInt(rybh);
		int nfy = Integer.parseInt(fydm);
		BigDecimal bd = new BigDecimal(id);
		String hql = "from RysxYujing where NId=? and NFy=? and NRybh=?";
		List<RysxYujing> listRysxYujing = getHibernateTemplate().find(hql,bd,nfy,nrybh);		
		return listRysxYujing.size()>0?listRysxYujing.get(0):null;
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean delRysxYujingById(String rybh,String bh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxYujing where NRybh=? and NId=?";
		List<RysxYujing> listRysxYujing = getHibernateTemplate().find(hql,nrybh,bd);	
		if(listRysxYujing==null || listRysxYujing.size()==0){
			return false;
		}else{
			RysxYujing rysxHt = listRysxYujing.get(0);
			getHibernateTemplate().delete(rysxHt);
			return true;
		}
	}
	public byte[] getHtnr(String rybh,String htbh){
		byte[] b = new byte[1000];
		String sql = "SELECT I_HTNR FROM T_RYSX_HT WHERE N_RYBH="+rybh+" AND C_HTBH = '"+htbh+"'";
		SessionFactoryImpl impl = (SessionFactoryImpl) getSessionFactory();
		ConnectionProvider provider = impl.getConnectionProvider();
		try {
			Connection conn = provider.getConnection();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				b = rs.getBytes(1);
				
			}
			rs.close();
			sta.close();
			conn.close();
			provider.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return b;
	}
	
	public byte[] getSign(String rybh,String nd,String pic){
		byte[] b = new byte[10000];
		if(pic.equals("grzjimg")){
			b=selectPic(rybh,nd,"GRQM_IMG");
		}else if(pic.equals("zgldimg")){
			b=selectPic(rybh,nd,"BMLDQM_IMG");
		}else if(pic.equals("jgfzrimg")){
			b=selectPic(rybh,nd,"YLDQM_IMG");
		}
		return b;
	}
	
	public byte[] selectPic(String rybh,String nd,String bz){
		byte[] b = new byte[10000];
		int khnd = Integer.parseInt(nd);
		String sql = "SELECT "+bz+" FROM KHJL_YEAR WHERE JBXXJ_CODE='"+rybh+"'and KHND = "+khnd;
		System.out.println(sql);
		SessionFactoryImpl impl = (SessionFactoryImpl) getSessionFactory();
		ConnectionProvider provider = impl.getConnectionProvider();
		try {
			Connection conn = provider.getConnection();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				b = rs.getBytes(1);
				
			}
			rs.close();
			sta.close();
			conn.close();
			provider.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return b;
	}
	
	
	
	
}