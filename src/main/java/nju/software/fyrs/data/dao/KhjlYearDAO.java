package nju.software.fyrs.data.dao;

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

import nju.software.fyrs.biz.vo.NdkhjtxxVO;
import nju.software.fyrs.data.dataobject.DzrsRsNdkhb;
import nju.software.fyrs.data.dataobject.KhjlYear;
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
 * KhjlYear entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see nju.software.fyrs.data.dataobject.KhjlYear
 * @author MyEclipse Persistence Tools
 */

public class KhjlYearDAO extends HibernateDaoSupport {
	
	DzrsRsNdkhbDAO dzrsRsNdkhbDAO;
	
	public void setDzrsRsNdkhbDAO(DzrsRsNdkhbDAO dzrsRsNdkhbDAO) {
		this.dzrsRsNdkhbDAO = dzrsRsNdkhbDAO;
	}
	
	private static final Logger log = LoggerFactory
			.getLogger(KhjlYearDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(KhjlYear transientInstance) {
		log.debug("saving KhjlYear instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(KhjlYear persistentInstance) {
		log.debug("deleting KhjlYear instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(KhjlYear persistentInstance){
		log.debug("update KhjlYear instance");
		try {
			getHibernateTemplate().update(persistentInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed",re);
			throw re;
		}
	}

	public KhjlYear findById(java.lang.Integer id) {
		log.debug("getting KhjlYear instance with id: " + id);
		try {
			KhjlYear instance = (KhjlYear) getHibernateTemplate().get(
					"nju.software.fyrs.data.dataobject.KhjlYear", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<KhjlYear> findByExample(KhjlYear instance) {
		log.debug("finding KhjlYear instance by example");
		try {
			List<KhjlYear> results = (List<KhjlYear>) getHibernateTemplate()
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
		log.debug("finding KhjlYear instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from KhjlYear as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all KhjlYear instances");
		try {
			String queryString = "from KhjlYear";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public KhjlYear merge(KhjlYear detachedInstance) {
		log.debug("merging KhjlYear instance");
		try {
			KhjlYear result = (KhjlYear) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(KhjlYear instance) {
		log.debug("attaching dirty KhjlYear instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(KhjlYear instance) {
		log.debug("attaching clean KhjlYear instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static KhjlYearDAO getFromApplicationContext(ApplicationContext ctx) {
		return (KhjlYearDAO) ctx.getBean("KhjlYearDAO");
	}
	
	public List<List<String>> convertFromSql(String sql) {
		System.out.println(sql);
		List<List<String>> tmpList = new ArrayList<List<String>>();
		SessionFactoryImpl impl = (SessionFactoryImpl) getSessionFactory();
		ConnectionProvider provider = impl.getConnectionProvider();
		try {
			Connection conn = provider.getConnection();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				List<String> tList = new ArrayList<String>();
				tList.add(rs.getString(1));
				tList.add(rs.getString(2));
				tList.add(rs.getString(3));
				tList.add(rs.getString(4));
				tList.add(rs.getString(5));
				tList.add(rs.getString(6));
				tList.add(rs.getString(7));
				tList.add(rs.getString(8));
				tList.add(rs.getString(9));
				tList.add(rs.getString(10));
				tmpList.add(tList);
			}
			rs.close();
			sta.close();
			conn.close();
			provider.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return tmpList;
	}
	
	public NdkhjtxxVO getKhjlYear(String yhmc){
		KhjlYear khjlYear = new KhjlYear();
		//根据用户名称到基本信息表中找到需要的信息
		String sql = "select XM,XB,JBXXJ_ZZMM,JBXXJ_XL,JBXXJ_ZW,CSSJ,RXZXWSJ,XRZBM,DWMC,JBXXJ_CODE FROM DZRS_RS_JBXXJ where XM = '"+yhmc+"'";
		List<List<String>> listgrxx = convertFromSql(sql);
		khjlYear.setXm(listgrxx.get(0).get(0));
		khjlYear.setXb(listgrxx.get(0).get(1));
		khjlYear.setZzmm(listgrxx.get(0).get(2));
		khjlYear.setXl(listgrxx.get(0).get(3));
		khjlYear.setZw(execsql(listgrxx.get(0).get(4).trim(),"USER200-212"));
		khjlYear.setCssj(DateUtil.parse(listgrxx.get(0).get(5),DateUtil.webFormat));
		khjlYear.setZwsj(DateUtil.parse(listgrxx.get(0).get(6), DateUtil.webFormat));
		khjlYear.setBm(listgrxx.get(0).get(7));
		khjlYear.setDwmc(execsql(listgrxx.get(0).get(8),"FBZ0001-97"));
		khjlYear.setJbxxjCode(listgrxx.get(0).get(9));
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		khjlYear.setKhnd(year);
		
		//转换实体
		NdkhjtxxVO ndkhjtxxVO = new NdkhjtxxVO();
		ndkhjtxxVO.setXm(khjlYear.getXm());
		ndkhjtxxVO.setXb(execsql(khjlYear.getXb(),"GB2261-80"));
		ndkhjtxxVO.setZzmm(execsql(khjlYear.getZzmm(),"GB4762-84"));
		ndkhjtxxVO.setXl(execsql(khjlYear.getXl(),"USER200-218"));
		ndkhjtxxVO.setZw(khjlYear.getZw());
		ndkhjtxxVO.setCsny(DateUtil.format(khjlYear.getCssj(),DateUtil.webFormat));
		ndkhjtxxVO.setRxzsj(DateUtil.format(khjlYear.getZwsj(), DateUtil.webFormat));
		ndkhjtxxVO.setBm(execsql(khjlYear.getBm(),"USER200-223"));
		ndkhjtxxVO.setDw(khjlYear.getDwmc());
		ndkhjtxxVO.setNd(khjlYear.getKhnd().toString());
		ndkhjtxxVO.setRybh(khjlYear.getJbxxjCode());
		return ndkhjtxxVO;
		
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
		String hql = "select max(checkCode) from KhjlYear";
		List<Integer> s = getHibernateTemplate().find(hql);
		return s.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public NdkhjtxxVO getKhjlYear(String yhmc,String khnd){
		int nd = Integer.parseInt(khnd);
		String hql = "from KhjlYear where xm=? and khnd=?";
		List<KhjlYear> listKhjlYear = getHibernateTemplate().find(hql,yhmc,nd);
		KhjlYear khjlYear = listKhjlYear.get(0);
		NdkhjtxxVO ndkhjtxxVO = new NdkhjtxxVO();
		ndkhjtxxVO.setXm(khjlYear.getXm());
		ndkhjtxxVO.setRybh(khjlYear.getJbxxjCode());
		ndkhjtxxVO.setNd(khnd);
		ndkhjtxxVO.setXb(execsql(khjlYear.getXb(),"GB2261-80"));
		ndkhjtxxVO.setCsny(DateUtil.format(khjlYear.getCssj(),
				DateUtil.webFormat));
		ndkhjtxxVO.setZzmm(execsql(khjlYear.getZzmm(),"GB4762-84"));
		ndkhjtxxVO.setRxzsj(DateUtil.format(khjlYear.getZwsj(),
				DateUtil.webFormat));
		ndkhjtxxVO.setBm(execsql(khjlYear.getBm(),"USER200-223"));
		ndkhjtxxVO.setDw(khjlYear.getDwmc());
		ndkhjtxxVO.setZw(khjlYear.getZw());
		String grzj2 = khjlYear.getGrzj2();
		if (grzj2 == null) {
			grzj2 = "";
		}
		ndkhjtxxVO.setGrzj(khjlYear.getGrzj() + grzj2);
		ndkhjtxxVO.setZgldpyhkhdcjy(khjlYear.getBmldyj());
		ndkhjtxxVO.setCshfggz(khjlYear.getFggz());
		ndkhjtxxVO.setZgldpyhkhdcjy(khjlYear.getBmldyj());
		ndkhjtxxVO.setJieg(khjlYear.getJieg());
		ndkhjtxxVO.setJgfzrkh(khjlYear.getFgyldyj());
		ndkhjtxxVO.setGrqmimg(khjlYear.getGrqmimg());
		ndkhjtxxVO.setBmldqmimg(khjlYear.getBmldqmimg());
		ndkhjtxxVO.setYldqmimg(khjlYear.getYldqmimg());
		ndkhjtxxVO.setGryjqmimg(khjlYear.getGryjqmimg());
		return ndkhjtxxVO;
	}
	
	@SuppressWarnings("unchecked")
	public NdkhjtxxVO getNdkhjtxxByRybhAndKhnd(String rybh,String khnd){
		int nd = Integer.parseInt(khnd);
		String hql = "from KhjlYear where jbxxjCode=? and khnd=?";
		List<KhjlYear> listKhjlYear = getHibernateTemplate().find(hql,rybh,nd);
		NdkhjtxxVO ndkhjtxxVO = new NdkhjtxxVO();
		if(listKhjlYear.size()!=0){
			KhjlYear khjlYear = listKhjlYear.get(0);
			ndkhjtxxVO.setXm(khjlYear.getXm());
			ndkhjtxxVO.setRybh(khjlYear.getJbxxjCode());
			ndkhjtxxVO.setNd(khnd);
			ndkhjtxxVO.setXb(execsql(khjlYear.getXb(),"GB2261-80"));
			ndkhjtxxVO.setCsny(DateUtil.format(khjlYear.getCssj(),
					DateUtil.webFormat));
			ndkhjtxxVO.setZzmm(execsql(khjlYear.getZzmm(),"GB4762-84"));
			ndkhjtxxVO.setRxzsj(DateUtil.format(khjlYear.getZwsj(),
					DateUtil.webFormat));
			ndkhjtxxVO.setBm(execsql(khjlYear.getBm(),"USER200-223"));
			ndkhjtxxVO.setDw(khjlYear.getDwmc());
			ndkhjtxxVO.setZw(khjlYear.getZw());
			String grzj2 = khjlYear.getGrzj2();
			if (grzj2 == null) {
				grzj2 = "";
			}
			ndkhjtxxVO.setGrzj(khjlYear.getGrzj() + grzj2);
			ndkhjtxxVO.setZgldpyhkhdcjy(khjlYear.getBmldyj());
			ndkhjtxxVO.setCshfggz(khjlYear.getFggz());
			ndkhjtxxVO.setZgldpyhkhdcjy(khjlYear.getBmldyj());
			ndkhjtxxVO.setJieg(khjlYear.getJieg());
			ndkhjtxxVO.setJgfzrkh(khjlYear.getFgyldyj());
			ndkhjtxxVO.setGrqmimg(khjlYear.getGrqmimg());
			ndkhjtxxVO.setBmldqmimg(khjlYear.getBmldqmimg());
			ndkhjtxxVO.setYldqmimg(khjlYear.getYldqmimg());
			ndkhjtxxVO.setGryjqmimg(khjlYear.getGryjqmimg());
		}
		return ndkhjtxxVO;
	}
	
	//通过姓名获得实体
	@SuppressWarnings("unchecked")
	public KhjlYear getKhjlYearByYhmc(String yhmc){
		String hql = "from KhjlYear where xm = ?";
		List<KhjlYear> listKhjlYear = getHibernateTemplate().find(hql,yhmc);
		if(listKhjlYear.size()!=0){
			return listKhjlYear.get(0);
		}else{
			return null;
		}
	}
	
	public void save(NdkhjtxxVO vo){
		KhjlYear khjlYear = new KhjlYear();
		String s = vo.getNd();
		String nd = s.substring(1, 5);
		khjlYear.setKhnd(Integer.parseInt(nd));
		khjlYear.setXm(vo.getXm());
		int n = getMaxCode() + 1;
		khjlYear.setCheckCode(n);
		khjlYear.setJbxxjCode(vo.getRybh());
		
		khjlYear.setXb(selectDmFromDmmc(vo.getXb(),"GB2261-80"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String cssj = vo.getCsny();
		String zwsj = vo.getRxzsj();
		Date date = new Date();
		try {
			khjlYear.setCssj(sdf.parse(cssj));
			khjlYear.setZwsj(sdf.parse(zwsj));
			khjlYear.setTbsj(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		khjlYear.setZzmm(selectDmFromDmmc(vo.getZzmm(),"GB4762-84"));
		String dwjzw = vo.getDwjzw();
		String[] ss = dwjzw.split("-");
		khjlYear.setDwmc(ss[0]);
		if(ss.length>1){
			khjlYear.setBm(selectDmFromDmmc(ss[1],"USER200-223"));
			khjlYear.setZw(ss[2]);
			khjlYear.setSpzw(selectDmFromDmmc(ss[2],"USER200-212"));
		}
		khjlYear.setFggz(vo.getCshfggz());
		khjlYear.setGrzj(vo.getGrzj());
		khjlYear.setSfbp(1);
		save(khjlYear);
	}
	
	//通过代码名称获得代码编号
	public String selectDmFromDmmc(String bmmc,String lbbh){
		SessionFactoryImpl impl = (SessionFactoryImpl) getSessionFactory();
		ConnectionProvider provider = impl.getConnectionProvider();
		String sql = "select DMBH from PUB_DMB where LBBH = '"+lbbh+"' and DMMS ='"+bmmc+"'";
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
	
	public byte[] getSignPic(String yhmc){
		byte[] b = new byte[1000];
		String sql = "SELECT DZQM_IMG FROM PUB_XTGL_YHB WHERE YHMC='"+yhmc+"'";
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
	
	@SuppressWarnings("unchecked")
	public void spNdkhjtxx(String rybh, String nd, String zgldpy,
			String select_jieguo){
		String khnd = nd.substring(1, 5);
		String hql = "from KhjlYear where jbxxjCode=? and khnd=?";
		List<KhjlYear> listKhjlYear = getHibernateTemplate().find(hql,rybh,Integer.parseInt(khnd));
		if(listKhjlYear.size()!=0){
			KhjlYear khjlYear = listKhjlYear.get(0);
			khjlYear.setBmldyj(zgldpy);
			khjlYear.setJieg(select_jieguo);
			Date date = new Date();
			khjlYear.setBmldqmsj(date);
			update(khjlYear);
			DzrsRsNdkhb ndkhb = new DzrsRsNdkhb();
			ndkhb.setJbxxjCode(rybh);
			ndkhb.setNd(Integer.parseInt(khnd));
			ndkhb.setJieg(select_jieguo);
			List<DzrsRsNdkhb> listDzrsRsNdkhb = dzrsRsNdkhbDAO.getNdkhbByRybhAndKhnd(rybh, khnd);
			if(listDzrsRsNdkhb.size()==0){
				dzrsRsNdkhbDAO.save(ndkhb);
			}else{
				dzrsRsNdkhbDAO.update(ndkhb);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void yldspNdkhjtxx(String rybh, String nd, String jgfzrhkhwyhyj){
		String khnd = nd.substring(1, 5);
		String hql = "from KhjlYear where jbxxjCode=? and khnd=?";
		List<KhjlYear> listKhjlYear = getHibernateTemplate().find(hql,rybh,Integer.parseInt(khnd));
		if(listKhjlYear.size()!=0){
			KhjlYear khjlYear = listKhjlYear.get(0);
			khjlYear.setFgyldyj(jgfzrhkhwyhyj);
			Date date = new Date();
			khjlYear.setFgyldqmsj(date);
			update(khjlYear);
		}
	}
	
	
}