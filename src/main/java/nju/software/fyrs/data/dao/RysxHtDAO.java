package nju.software.fyrs.data.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import nju.software.fyrs.data.dataobject.RysxHt;
import org.hibernate.LockMode;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.impl.SessionFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * RysxHt entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.RysxHt
 * @author MyEclipse Persistence Tools
 */

public class RysxHtDAO extends HibernateDaoSupport {
	

	
	private static final Logger log = LoggerFactory
			.getLogger(RysxHtDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(RysxHt transientInstance) {
		log.debug("saving RysxHt instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RysxHt persistentInstance) {
		log.debug("deleting RysxHt instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(RysxHt persistentInstance){
		log.debug("update RysxHt instance");
		try {
			getHibernateTemplate().update(persistentInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed",re);
			throw re;
		}
	}

	public RysxHt findById(java.lang.Integer id) {
		log.debug("getting RysxHt instance with id: " + id);
		try {
			RysxHt instance = (RysxHt) getHibernateTemplate().get(
					"nju.software.fyrs.data.dataobject.RysxHt", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RysxHt> findByExample(RysxHt instance) {
		log.debug("finding RysxHt instance by example");
		try {
			List<RysxHt> results = (List<RysxHt>) getHibernateTemplate()
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
		log.debug("finding RysxHt instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RysxHt as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all RysxHt instances");
		try {
			String queryString = "from RysxHt";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RysxHt merge(RysxHt detachedInstance) {
		log.debug("merging RysxHt instance");
		try {
			RysxHt result = (RysxHt) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RysxHt instance) {
		log.debug("attaching dirty RysxHt instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RysxHt instance) {
		log.debug("attaching clean RysxHt instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RysxHtDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RysxHtDAO) ctx.getBean("RysxHtDAO");
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
		String hql = "select max(checkCode) from RysxHt";
		List<Integer> s = getHibernateTemplate().find(hql);
		return s.get(0);
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<RysxHt> getRysxHtByRybh(int rybh,int fydm){
		String hql = "from RysxHt where NRybh=? and NFy=?";
		List<RysxHt> listRysxHt = getHibernateTemplate().find(hql,rybh,fydm);		
		return listRysxHt;
	}
	
	@SuppressWarnings("unchecked")
	public List<RysxHt> getRysxHtByFy(int fydm){
		String hql = "from RysxHt where NFy=?";
		List<RysxHt> listRysxHt = getHibernateTemplate().find(hql,fydm);		
		return listRysxHt;
	}
	
	@SuppressWarnings("unchecked")
	public RysxHt getRysxHtById(String id,String fydm,String rybh){
		int nrybh = Integer.parseInt(rybh);
		BigDecimal bid = new BigDecimal(id);
		String hql = "from RysxHt where NId=? and NRybh=? and NFy=?";
		List<RysxHt> listRysxHt = getHibernateTemplate().find(hql,bid,nrybh,Integer.valueOf(fydm));		
		return listRysxHt.size()>0?listRysxHt.get(0):null;
	}
	
	@SuppressWarnings("unchecked")
	public RysxHt getRysxHtByRybhHtbh(String rybh,String htbh){
		int nrybh = Integer.parseInt(rybh);
		String hql = "from RysxHt where NRybh=? and CHtbh=?";
		List<RysxHt> listRysxHt = getHibernateTemplate().find(hql,nrybh,htbh);		
		return listRysxHt.size()>0?listRysxHt.get(0):null;
	}
	
	@SuppressWarnings("unchecked")
	public boolean delRysxHtById(String rybh,String fydm,String bh){
		int nrybh = Integer.parseInt(rybh);
		int nfy = Integer.parseInt(fydm);
		BigDecimal bd = new BigDecimal(bh);
		String hql = "from RysxHt where NRybh=? and Nfy=? and NId=?";
		List<RysxHt> listRysxHt = getHibernateTemplate().find(hql,nrybh,nfy,bd);	
		if(listRysxHt==null || listRysxHt.size()==0){
			return false;
		}else{
			RysxHt rysxHt = listRysxHt.get(0);
			getHibernateTemplate().delete(rysxHt);
			return true;
		}
	}
	public byte[] getHtnr(String rybh,String htbh){
		byte[] b = new byte[1000];
		int nrybh = Integer.parseInt(rybh);
		String sql = "SELECT I_HTNR FROM T_RYSX_HT WHERE N_RYBH="+nrybh+" AND C_HTBH = '"+htbh+"'";
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
	
	public boolean interceptAddHt(RysxHt rysxHt){
		try
		{
			getSession().save(rysxHt);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptUpdateXlxx(RysxHt rysxHt){
		try
		{
			getSession().update(rysxHt);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public boolean interceptDeleteRsXlxxById(RysxHt rysxHt){
		try
		{
			getSession().delete(rysxHt);
			getSession().flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	
	
	
	
}