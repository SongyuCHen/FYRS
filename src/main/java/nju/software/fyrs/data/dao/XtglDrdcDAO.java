package nju.software.fyrs.data.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.connection.ConnectionProvider;
import org.hibernate.impl.SessionFactoryImpl;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import nju.software.fyrs.data.dataobject.TableField;
import nju.software.fyrs.util.RolesUtil;

public class XtglDrdcDAO extends HibernateDaoSupport {

	// 更新或插入数据
	@SuppressWarnings("unchecked")
	public void insertOrUpdate(List<List<Object>> contentList,
			List<TableField> colNames, String tableName, String fieldFullContent) {

		List<Object> objectList = new ArrayList<Object>();
		
		List<String> sqlList = new ArrayList<String>();
		for (int i = 0; i < contentList.size(); i++) {
			objectList = contentList.get(i);
			String sql_begin = "insert into " + tableName + "(";
			sql_begin += fieldFullContent + " ) values (";

			String sql_end = "";
			for (int j = 0; j < colNames.size(); j++) {
				if (j == colNames.size() - 1) {
					if (colNames.get(j).getNdatatype() == 1
							|| colNames.get(j).getNdatatype() == 3
							|| colNames.get(j).getNdatatype() == 7) {
						if (objectList.get(j) == null) {
							sql_end += objectList.get(j) + ")";
						} else {
							sql_end += "'" + changeString(objectList.get(j))
									+ "')";
						}
					} else {
						sql_end += objectList.get(j) + ")";
					}
				} else {
					if (colNames.get(j).getNdatatype() == 1
							|| colNames.get(j).getNdatatype() == 3
							|| colNames.get(j).getNdatatype() == 7) {
						if (objectList.get(j) == null) {
							sql_end += objectList.get(j) + ",";
						} else {
							sql_end += "'" + changeString(objectList.get(j))
									+ "',";
						}
					} else {
						sql_end += objectList.get(j) + ",";
					}
				}
			}

			String sql_insert = sql_begin + sql_end;

			// 更新sql语句
			List<TableField> cols = new ArrayList<TableField>();
			for (int j = 0; j < colNames.size(); j++) {
				cols.add(colNames.get(j));
			}
			List<Object> listObj = new ArrayList<Object>();
			for (int j = 0; j < objectList.size(); j++) {
				listObj.add(objectList.get(j));
			}
			int i_id = 0;
			int i_fy = 0;
			int i_rybh = 0;
			long id_num = 0;
			long fy_num = 0;
			long rybh_num = 0;
			// 查找N_ID字段
			for (int j = 0; j < cols.size(); j++) {
				if (("N_ID").equals(cols.get(j).getCfieldname())) {
					i_id = j;
				}
			}
			if (!tableName.equals("T_RYJBXX")) {
				id_num = (Long) listObj.get(i_id);
				listObj.remove((int) i_id);
				cols.remove((int) i_id);
			}

			// 查找N_FY字段
			for (int j = 0; j < cols.size(); j++) {
				if (("N_FY").equals(cols.get(j).getCfieldname())) {
					i_fy = j;
				}
			}
			fy_num = (Long) listObj.get(i_fy);
			listObj.remove((int) i_fy);
			cols.remove((int) i_fy);

			// 查找N_RYBH字段
			for (int j = 0; j < cols.size(); j++) {
				if (("N_RYBH").equals(cols.get(j).getCfieldname())) {
					i_rybh = j;
				}
			}
			rybh_num = (Long) listObj.get(i_rybh);
			listObj.remove((int) i_rybh);
			cols.remove((int) i_rybh);

			String sql_update_begin = "update " + tableName;
			String sql_update_end = " set";
			for (int j = 0; j < cols.size(); j++) {
				if (cols.get(j).getNdatatype() == 1
						|| cols.get(j).getNdatatype() == 3
						|| cols.get(j).getNdatatype() == 7) {
					if (j == cols.size() - 1) {
						if (listObj.get(j) == null) {
							sql_update_end += " " + cols.get(j).getCfieldname()
									+ "=" + listObj.get(j);
						} else {
							sql_update_end += " " + cols.get(j).getCfieldname()
									+ "=" + "'" + changeString(listObj.get(j))
									+ "'";
						}
					} else {
						if (listObj.get(j) == null) {
							sql_update_end += " " + cols.get(j).getCfieldname()
									+ "=" + listObj.get(j) + ",";
						} else {
							sql_update_end += " " + cols.get(j).getCfieldname()
									+ "=" + "'" + changeString(listObj.get(j))
									+ "',";
						}
					}
				} else {
					if (j == cols.size() - 1) {
						sql_update_end += " " + cols.get(j).getCfieldname()
								+ "=" + listObj.get(j);
					} else {
						sql_update_end += " " + cols.get(j).getCfieldname()
								+ "=" + listObj.get(j) + ",";
					}
				}
			}
			String sql_update = "";
			if (tableName.equals("T_RYJBXX")) {
				sql_update = sql_update_begin + sql_update_end + " where N_FY="
						+ fy_num + " and N_RYBH=" + rybh_num;
			} else {
				sql_update = sql_update_begin + sql_update_end + " where N_ID="
						+ id_num + " and N_FY=" + fy_num + " and N_RYBH="
						+ rybh_num;
			}

			// 检查是否存在记录
			String sql = "";
			if (tableName.equals("T_RYJBXX")) {
				sql = "select N_RYBH from " + tableName + " where N_FY="
						+ fy_num + " and N_RYBH=" + rybh_num;
			} else {
				sql = "select N_RYBH from " + tableName + " where N_ID="
						+ id_num + " and N_FY=" + fy_num + " and N_RYBH="
						+ rybh_num;
			}
			List<Object> list = new ArrayList<Object>();
			list = getSession().createSQLQuery(sql).list();
			if (list.size() == 0) {
				sqlList.add(sql_insert);
			} else {
				sqlList.add(sql_update);
			}
			sql_begin = null;
			sql_end = null;
			sql_insert = null;
			sql_update_begin = null;
			sql_update_end = null;
			sql_update = null;
			sql = null;
			list = null;
			objectList = null;
			cols = null;
			listObj = null;
		}
		
		batchExcuteSql(sqlList);
		
		sqlList = null;
	}

	public String changeString(Object x) {
		String s = x.toString();
		s = s.replace('[', '{');
		s = s.replace(']', '}');
		return s;
	}
	
	public void batchExcuteSql(List<String> sqlList){
		SessionFactoryImpl impl =(SessionFactoryImpl)getSessionFactory();
		ConnectionProvider provider = impl.getConnectionProvider();
		try {
			Connection conn = provider.getConnection();
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			conn.setAutoCommit(false);
			int tj_num = sqlList.size()/10000;
			int num_all = sqlList.size();
			for(int i=0;i<tj_num+1;i++){
				for(int j=10000*i;j<(i+1)*10000;j++){
                  if(j<num_all){
						stmt.addBatch(sqlList.get(j));
					}else{
						break;
                  }
				}
				stmt.executeBatch();
				conn.commit();
			}
			stmt.close();
			conn.close();
			provider.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void exportinsertOrUpdate(List<List<Object>> contentList,
			List<TableField> colNames, String tableName, String fieldFullContent) {
		
		List<Object> objectList = new ArrayList<Object>();
		
		List<String> sqlList = new ArrayList<String>();
		for (int i = 0; i < contentList.size(); i++) {
			objectList = contentList.get(i);
			String sql_begin = "insert into " + tableName + "(";
			sql_begin += fieldFullContent + " ) values (";

			String sql_end = "";
			for (int j = 0; j < colNames.size(); j++) {
				if (j == colNames.size() - 1) {
					if (colNames.get(j).getNdatatype() == 1
							|| colNames.get(j).getNdatatype() == 3
							|| colNames.get(j).getNdatatype() == 7) {
						if (objectList.get(j) == null) {
							sql_end += objectList.get(j) + ")";
						} else {
							sql_end += "'" + changeString(objectList.get(j))
									+ "')";
						}
					} else {
						sql_end += objectList.get(j) + ")";
					}
				} else {
					if (colNames.get(j).getNdatatype() == 1
							|| colNames.get(j).getNdatatype() == 3
							|| colNames.get(j).getNdatatype() == 7) {
						if (objectList.get(j) == null) {
							sql_end += objectList.get(j) + ",";
						} else {
							sql_end += "'" + changeString(objectList.get(j))
									+ "',";
						}
					} else {
						sql_end += objectList.get(j) + ",";
					}
				}
			}

			String sql_insert = sql_begin + sql_end;

			// 更新sql语句
			List<TableField> cols = new ArrayList<TableField>();
			for (int j = 0; j < colNames.size(); j++) {
				cols.add(colNames.get(j));
			}
			List<Object> listObj = new ArrayList<Object>();
			for (int j = 0; j < objectList.size(); j++) {
				listObj.add(objectList.get(j));
			}
			int i_id = 0;
			int i_fy = 0;
			int i_rybh = 0;
			long id_num = 0;
			long fy_num = 0;
			long rybh_num = 0;
			// 查找N_ID字段
			for (int j = 0; j < cols.size(); j++) {
				if (("N_ID").equals(cols.get(j).getCfieldname())) {
					i_id = j;
				}
			}
			if (!tableName.equals("T_RYJBXX")) {
				id_num = (Long) listObj.get(i_id);
				listObj.remove((int) i_id);
				cols.remove((int) i_id);
			}

			// 查找N_FY字段
			for (int j = 0; j < cols.size(); j++) {
				if (("N_FY").equals(cols.get(j).getCfieldname())) {
					i_fy = j;
				}
			}
			fy_num = (Long) listObj.get(i_fy);
			listObj.remove((int) i_fy);
			cols.remove((int) i_fy);

			// 查找N_RYBH字段
			for (int j = 0; j < cols.size(); j++) {
				if (("N_RYBH").equals(cols.get(j).getCfieldname())) {
					i_rybh = j;
				}
			}
			rybh_num = (Long) listObj.get(i_rybh);
			listObj.remove((int) i_rybh);
			cols.remove((int) i_rybh);

			String sql_update_begin = "update " + tableName;
			String sql_update_end = " set";
			for (int j = 0; j < cols.size(); j++) {
				if (cols.get(j).getNdatatype() == 1
						|| cols.get(j).getNdatatype() == 3
						|| cols.get(j).getNdatatype() == 7) {
					if (j == cols.size() - 1) {
						if (listObj.get(j) == null) {
							sql_update_end += " " + cols.get(j).getCfieldname()
									+ "=" + listObj.get(j);
						} else {
							sql_update_end += " " + cols.get(j).getCfieldname()
									+ "=" + "'" + changeString(listObj.get(j))
									+ "'";
						}
					} else {
						if (listObj.get(j) == null) {
							sql_update_end += " " + cols.get(j).getCfieldname()
									+ "=" + listObj.get(j) + ",";
						} else {
							sql_update_end += " " + cols.get(j).getCfieldname()
									+ "=" + "'" + changeString(listObj.get(j))
									+ "',";
						}
					}
				} else {
					if (j == cols.size() - 1) {
						sql_update_end += " " + cols.get(j).getCfieldname()
								+ "=" + listObj.get(j);
					} else {
						sql_update_end += " " + cols.get(j).getCfieldname()
								+ "=" + listObj.get(j) + ",";
					}
				}
			}
			String sql_update = "";
			if (tableName.equals("T_RYJBXX")) {
				sql_update = sql_update_begin + sql_update_end + " where N_FY="
						+ fy_num + " and N_RYBH=" + rybh_num;
			} else {
				sql_update = sql_update_begin + sql_update_end + " where N_ID="
						+ id_num + " and N_FY=" + fy_num + " and N_RYBH="
						+ rybh_num;
			}

			// 检查是否存在记录
			String sql = "";
			if (tableName.equals("T_RYJBXX")) {
				sql = "select N_RYBH from " + tableName + " where N_FY="
						+ fy_num + " and N_RYBH=" + rybh_num;
			} else {
				sql = "select N_RYBH from " + tableName + " where N_ID="
						+ id_num + " and N_FY=" + fy_num + " and N_RYBH="
						+ rybh_num;
			}
			List<Object> list = new ArrayList<Object>();
			list = getSession().createSQLQuery(sql).list();
			if (list.size() == 0) {
				sqlList.add(sql_insert);
			} else {
				sqlList.add(sql_update);
			}
			sql_begin = null;
			sql_end = null;
			sql_insert = null;
			sql_update_begin = null;
			sql_update_end = null;
			sql_update = null;
			sql = null;
			list = null;
			objectList = null;
			cols = null;
			listObj = null;
		}
		exportbatchExcuteSql(sqlList);
		sqlList = null;
	}
	
	public void exportbatchExcuteSql(List<String> sqlList){
		SessionFactoryImpl impl =(SessionFactoryImpl)getSessionFactory();
		ConnectionProvider provider = impl.getConnectionProvider();
		try {
			Connection conn = provider.getConnection();
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			conn.setAutoCommit(false);
			int tj_num = sqlList.size()/10000;
			int num_all = sqlList.size();
			for(int i=0;i<tj_num+1;i++){
				for(int j=10000*i;j<(i+1)*10000;j++){
                  if(j<num_all){
						stmt.addBatch(sqlList.get(j));
					}else{
						break;
                  }
				}
				stmt.executeBatch();
				conn.commit();
			}
			stmt.close();
			conn.close();
			provider.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
