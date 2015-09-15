package nju.software.fyrs.data.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nju.software.fyrs.util.DateUtil;

import org.hibernate.connection.ConnectionProvider;
import org.hibernate.impl.SessionFactoryImpl;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class NdkhDAO extends HibernateDaoSupport {
	@SuppressWarnings("unchecked")
	private String sqlText(String sql) {
		List<String> lists = (List<String>) getSession().createSQLQuery(sql)
				.list();
		if (lists.size() == 0) {
			return "";
		}
		return lists.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<String> getYhQxByYhmc(String yhmc) {
		List<String> tmpList = new ArrayList<String>();
		List<Integer> list = (List<Integer>) getSession().createSQLQuery(
				"select YHBH from PUB_XTGL_YHB where YHMC='" + yhmc + "'")
				.list();
		Integer yhbh = (Integer) list.get(0);
		int bh = yhbh.intValue();
		List<String> yhqx_one = (List<String>) getSession().createSQLQuery(
				"select YHQX FROM PUB_XTGL_YHXTGXB WHERE YHBH = " + bh
						+ " AND XTBH = 'YJ601'").list();
		List<String> yhqx_two = (List<String>) getSession().createSQLQuery(
				"select YHQX FROM PUB_XTGL_YHXTGXB WHERE YHBH = " + bh
						+ " AND XTBH = 'YJ611'").list();
		@SuppressWarnings("unused")
		List<String> yhqx_three = (List<String>) getSession().createSQLQuery(
				"select YHQX FROM PUB_XTGL_YHXTGXB WHERE YHBH = " + bh
						+ " AND XTBH = 'YJ901'").list();
		String yhqx_four = (String) sqlText("SELECT DZRS_RS_JBXXJ.XRZBM FROM DZRS_RS_JBXXJ WHERE ( DZRS_RS_JBXXJ.XM ='"
				+ yhmc + "' ) AND  ( DZRS_RS_JBXXJ.RYLB = '1' )");
		String xtqx = yhqx_four.trim();
		String bmmc = sqlText("SELECT PUB_DMB.DMMS FROM PUB_DMB WHERE ( PUB_DMB.DMBH ='"
				+ xtqx + "') and (PUB_DMB.LBBH ='USER200-223')");
		// 确定管理员身份
		if (yhmc.equals("admin")) {
			tmpList.add("1");
		} else {
			tmpList.add("0");
		}
		// 确定院领导身份
		if (("院领导").equals(bmmc)) {
			tmpList.add("1");
		} else {
			tmpList.add("0");
		}
		// 确定政治部干部身份
		if (yhqx_two.size() != 0) {
			tmpList.add("1");
		} else {
			tmpList.add("0");
		}
		// 确定中层领导身份
		if (yhqx_one.size() != 0) {
			tmpList.add("1");
		} else {
			tmpList.add("0");
		}
		return tmpList;
	}

	public List<List<String>> getBmTjBg(String yhmc, String year) {
		List<List<String>> listBmTjBg = new ArrayList<List<String>>();
		String yhqx_four = (String) sqlText("SELECT DZRS_RS_JBXXJ.XRZBM FROM DZRS_RS_JBXXJ WHERE ( DZRS_RS_JBXXJ.XM ='"
				+ yhmc + "' ) AND  ( DZRS_RS_JBXXJ.RYLB = '1' )");
		String bmbh = yhqx_four.trim();
		String sql = "SELECT KHJL_YEAR.BM,KHJL_YEAR.XM,KHJL_YEAR.XB,KHJL_YEAR.ZZMM,KHJL_YEAR.SPZW,KHJL_YEAR.XL,KHJL_YEAR.FGGZ,KHJL_YEAR.TBSJ,KHJL_YEAR.JBXXJ_CODE,KHJL_YEAR.KHND,KHJL_YEAR.BMLDQMSJ,KHJL_YEAR.FGYLDQMSJ,KHJL_YEAR.SFBP FROM KHJL_YEAR WHERE ( KHJL_YEAR.BM ='"
				+ bmbh
				+ "') AND ( KHJL_YEAR.SFBP = 1) AND ( KHJL_YEAR.XM NOT IN (SELECT KHJL_ZCWH.YHMC FROM KHJL_ZCWH WHERE KHJL_ZCWH.YHBM ='"
				+ bmbh + "')) AND KHJL_YEAR.KHND=" + year;
		List<List<String>> list = convertFromSql(sql);
		for (int i = 0; i < list.size(); i++) {
			List<String> tmpList = new ArrayList<String>();
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "USER200-223"));
				} else if (j == 2) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "GB2261-80"));
				} else if (j == 3) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "GB4762-84"));
				} else if (j == 4) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "USER200-222"));
				} else if (j == 5) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "USER200-218"));
				} else if (j == 6) {
					if (list.get(i).get(j) == null) {
						tmpList.add("");
					} else {
						tmpList.add(list.get(i).get(j));
					}
				} else if (j == 7) {
					tmpList.add(DateUtil.format(DateUtil.parse(
							list.get(i).get(j), DateUtil.webFormat),
							DateUtil.webFormat));
				} else {
					tmpList.add(list.get(i).get(j));
				}
			}
			listBmTjBg.add(tmpList);
		}
		return listBmTjBg;
	}

	public String getDmmcByDmBh(String dmbh, String lbbh) {
		String bmmc = (String) sqlText("SELECT PUB_DMB.DMMS FROM PUB_DMB WHERE ( PUB_DMB.DMBH ='"
				+ dmbh + "') and (PUB_DMB.LBBH ='" + lbbh + "')");
		return bmmc;
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
				tList.add(rs.getString(11));
				tList.add(rs.getString(12));
				tList.add(rs.getString(13));
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

	public List<List<String>> getGbccx(String year) {
		List<List<String>> listTjBg = new ArrayList<List<String>>();
		String sql = "SELECT KHJL_YEAR.BM,KHJL_YEAR.XM,KHJL_YEAR.XB,KHJL_YEAR.ZZMM,KHJL_YEAR.SPZW,KHJL_YEAR.XL,KHJL_YEAR.FGGZ,KHJL_YEAR.TBSJ,KHJL_YEAR.JBXXJ_CODE,KHJL_YEAR.KHND,KHJL_YEAR.BMLDQMSJ,KHJL_YEAR.FGYLDQMSJ,KHJL_YEAR.SFBP FROM KHJL_YEAR WHERE ( KHJL_YEAR.BMLDQMSJ > '1990-01-01' ) and ( KHJL_YEAR.XM IN (SELECT YHMC FROM  KHJL_ZCWH )) AND KHJL_YEAR.KHND="
				+ year;

		List<List<String>> list = convertFromSql(sql);
		for (int i = 0; i < list.size(); i++) {
			List<String> tmpList = new ArrayList<String>();
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "USER200-223"));
				} else if (j == 2) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "GB2261-80"));
				} else if (j == 3) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "GB4762-84"));
				} else if (j == 4) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "USER200-222"));
				} else if (j == 5) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "USER200-218"));
				} else if (j == 6) {
					if (list.get(i).get(j) == null) {
						tmpList.add("");
					} else {
						tmpList.add(list.get(i).get(j));
					}
				} else if (j == 7) {
					tmpList.add(DateUtil.format(DateUtil.parse(
							list.get(i).get(j), DateUtil.webFormat),
							DateUtil.webFormat));
				} else {
					tmpList.add(list.get(i).get(j));
				}
			}
			listTjBg.add(tmpList);
		}
		return listTjBg;
	}

	public List<List<String>> getTjsc(String yhmc, String year) {
		List<List<String>> listTjsc = new ArrayList<List<String>>();
		String yhqx_four = (String) sqlText("SELECT DZRS_RS_JBXXJ.XRZBM FROM DZRS_RS_JBXXJ WHERE ( DZRS_RS_JBXXJ.XM ='"
				+ yhmc + "' ) AND  ( DZRS_RS_JBXXJ.RYLB = '1' )");
		String bmbh = yhqx_four.trim();
		String sql = "SELECT KHJL_YEAR.BM,KHJL_YEAR.XM,KHJL_YEAR.SPZW,KHJL_YEAR.JIEG,KHJL_YEAR.BZ,KHJL_YEAR.KHND,KHJL_YEAR.CHECK_CODE,KHJL_YEAR.JBXXJ_CODE FROM KHJL_YEAR WHERE (BM ='"+bmbh+"') AND (KHND = "+year+") AND XM not in (select YHMC from KHJL_ZCWH)"; 
		List<List<String>> list = convertFromSqlToTjsc(sql);
		for (int i = 0; i < list.size(); i++) {
			List<String> tmpList = new ArrayList<String>();
			for (int j = 0; j < 5; j++) {
				if (j == 0) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "USER200-223"));
				} else if (j == 2) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "USER200-222"));
				} else if(j == 3){
					tmpList.add(getDmmcByDmBh(list.get(i).get(j),"FBX0021-97"));
				}else if(j == 4){
					if(list.get(i).get(j)==null){
						tmpList.add("");
					}else{
						tmpList.add(list.get(i).get(j));
					}
				}else{
					tmpList.add(list.get(i).get(j));
				}
			}
			listTjsc.add(tmpList);
		}
		return listTjsc;
	}
	
	public List<List<String>> convertFromSqlToTjsc(String sql) {
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
	
	@SuppressWarnings("unchecked")
	public List<List<String>> getLdspZc(String yhmc,String year){
		List<List<String>> listBmTjBg = new ArrayList<List<String>>();
		List<Integer> listyhbh = (List<Integer>) getSession().createSQLQuery(
				"select YHBH from PUB_XTGL_YHB where YHMC='" + yhmc + "'")
				.list();
		Integer yhbh = (Integer) listyhbh.get(0);
		int bh = yhbh.intValue();
		String sql = "SELECT KHJL_YEAR.BM,KHJL_YEAR.XM,KHJL_YEAR.XB,KHJL_YEAR.ZZMM,KHJL_YEAR.SPZW,KHJL_YEAR.XL,KHJL_YEAR.FGGZ,KHJL_YEAR.TBSJ,KHJL_YEAR.JBXXJ_CODE,KHJL_YEAR.KHND,KHJL_YEAR.BMLDQMSJ,KHJL_YEAR.FGYLDQMSJ,KHJL_YEAR.SFBP FROM KHJL_YEAR  where ( KHJL_YEAR.SFBP = 1) AND ( KHJL_YEAR.XM IN (SELECT YHMC FROM  KHJL_ZCWH WHERE FGYZBH ="+bh+")) AND KHJL_YEAR.KHND="+ year;
		List<List<String>> list = convertFromSql(sql);
		for (int i = 0; i < list.size(); i++) {
			List<String> tmpList = new ArrayList<String>();
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "USER200-223"));
				} else if (j == 2) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "GB2261-80"));
				} else if (j == 3) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "GB4762-84"));
				} else if (j == 4) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "USER200-222"));
				} else if (j == 5) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "USER200-218"));
				} else if (j == 6) {
					if (list.get(i).get(j) == null) {
						tmpList.add("");
					} else {
						tmpList.add(list.get(i).get(j));
					}
				} else if (j == 7) {
					tmpList.add(DateUtil.format(DateUtil.parse(
							list.get(i).get(j), DateUtil.webFormat),
							DateUtil.webFormat));
				} else {
					tmpList.add(list.get(i).get(j));
				}
			}
			listBmTjBg.add(tmpList);
		}
		return listBmTjBg;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getYhglBm(String yhmc){
		List<String> bmList = new ArrayList<String>();
		List<Integer> listyhbh = (List<Integer>) getSession().createSQLQuery(
				"select YHBH from PUB_XTGL_YHB where YHMC='" + yhmc + "'")
				.list();
		Integer yhbh = (Integer) listyhbh.get(0);
		int bh = yhbh.intValue();
		
		String sql = "select distinct YHBM from KHJL_ZCWH where FGYZBH ="+bh;
		List<String> tmpbmdmList = convertSql(sql);
		List<String> bmmcList = new ArrayList<String>();
		for(int i=0;i<tmpbmdmList.size();i++){
			bmmcList.add(execsql(tmpbmdmList.get(i)));
		}
		List<String> zhdmbhList = new ArrayList<String>();
		for(int i=0;i<bmmcList.size();i++){
			zhdmbhList.add(zhdmbhSql(bmmcList.get(i)));
		}
		for(int i=0;i<bmmcList.size();i++){
			bmList.add(zhdmbhList.get(i));
			bmList.add(bmmcList.get(i));
		}
		return bmList;
	}
	
	public String zhdmbhSql(String dmmc){
		SessionFactoryImpl impl = (SessionFactoryImpl) getSessionFactory();
		ConnectionProvider provider = impl.getConnectionProvider();
		String sql = "SELECT PUB_DMB.DMBH  FROM PUB_DMB WHERE ( rtrim(PUB_DMB.LBBH) ='USER200-223') AND (rtrim(PUB_DMB.DMMS) = '"+dmmc+"')";
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
	
	public String execsql(String bmdm){
		SessionFactoryImpl impl = (SessionFactoryImpl) getSessionFactory();
		ConnectionProvider provider = impl.getConnectionProvider();
		String sql = "select DMMS from PUB_DMB where LBBH = 'USR206-99' and DMBH ='"+bmdm+"'";
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
	
	public List<String> convertSql(String sql){
		List<String> tmpList = new ArrayList<String>();
		SessionFactoryImpl impl = (SessionFactoryImpl) getSessionFactory();
		ConnectionProvider provider = impl.getConnectionProvider();
		try {
			Connection conn = provider.getConnection();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				tmpList.add(rs.getString(1));

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
	
	public List<List<String>> getLdspZcyx(String bmbh,String year){
		List<List<String>> listBmZcyx = new ArrayList<List<String>>();
		String sql = "SELECT KHJL_YEAR.BM,KHJL_YEAR.XM,KHJL_YEAR.XB,KHJL_YEAR.ZZMM,KHJL_YEAR.SPZW,KHJL_YEAR.XL,KHJL_YEAR.FGGZ,KHJL_YEAR.TBSJ,KHJL_YEAR.JBXXJ_CODE,KHJL_YEAR.KHND,KHJL_YEAR.BMLDQMSJ,KHJL_YEAR.FGYLDQMSJ,KHJL_YEAR.SFBP FROM KHJL_YEAR   WHERE ( KHJL_YEAR.BM ='"+bmbh+"') AND ( KHJL_YEAR.BMLDQMSJ <> null ) AND ( KHJL_YEAR.XM NOT IN (SELECT KHJL_ZCWH.YHMC FROM KHJL_ZCWH)) AND KHJL_YEAR.KHND="+ year;
		List<List<String>> list = convertFromSql(sql);
		for (int i = 0; i < list.size(); i++) {
			List<String> tmpList = new ArrayList<String>();
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "USER200-223"));
				} else if (j == 2) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "GB2261-80"));
				} else if (j == 3) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "GB4762-84"));
				} else if (j == 4) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "USER200-222"));
				} else if (j == 5) {
					tmpList.add(getDmmcByDmBh(list.get(i).get(j), "USER200-218"));
				} else if (j == 6) {
					if (list.get(i).get(j) == null) {
						tmpList.add("");
					} else {
						tmpList.add(list.get(i).get(j));
					}
				} else if (j == 7) {
					tmpList.add(DateUtil.format(DateUtil.parse(
							list.get(i).get(j), DateUtil.webFormat),
							DateUtil.webFormat));
				} else {
					tmpList.add(list.get(i).get(j));
				}
			}
			listBmZcyx.add(tmpList);
		}
		return listBmZcyx;
	}
}
