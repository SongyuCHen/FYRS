package nju.software.fyrs.web.controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.data.dao.XtglDrdcDAO;
import nju.software.fyrs.data.dataobject.TableField;
import nju.software.fyrs.data.dataobject.TddTable;
import nju.software.fyrs.service.impl.RoleMenuService;

import org.apache.log4j.Logger;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.impl.SessionFactoryImpl;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ice.jni.registry.RegStringValue;
import com.ice.jni.registry.Registry;
import com.ice.jni.registry.RegistryKey;

@Controller
@RequestMapping("/main/xtgl")
public class XtglDrdcController extends HibernateDaoSupport{
	private RoleMenuService roleMenuService;
	private XtglDrdcDAO xtglDrdcDAO;
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(XtglDrdcController.class);
	
	
	public void setXtglDrdcDAO(XtglDrdcDAO xtglDrdcDAO) {
		this.xtglDrdcDAO = xtglDrdcDAO;
	}
	
	@RequestMapping(value = "/drdc.do", method = RequestMethod.GET)
	public String showDmwh(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		MenuShowUtils.headerMenu(request, model, roleMenuService, "系统管理");
		MenuShowUtils.leftMenu(request, model, roleMenuService, "xtgl");
		// 当调用这个方法时，显然是显示它这个标签，所以
		model.addAttribute("currentSelectLeftMenu", "导入导出");
		return "drdc/show";
	}

	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	@RequestMapping(value = "/importFile.do", method = RequestMethod.POST)
	public void importFile(Model model, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		// 获取db文件的路径
		String path = request.getParameter("fileName");
		
		// 修改ODBC的注册表使其指向选择的db文件
		try {
			RegistryKey child = Registry.HKEY_CURRENT_USER
					.openSubKey("Software").openSubKey("ODBC")
					.openSubKey("ODBC.INI")
					.openSubKey("fyrs", RegistryKey.ACCESS_ALL);
			String de = path;
			child.setValue(new RegStringValue(child, "DatabaseFile", de));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 使用jdbc-odbc连接到数据源
		java.sql.Connection conn = null;
		java.sql.PreparedStatement pt = null;
		java.sql.ResultSet rs = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 对其进行操作
		try {
			// 访问建立的数据源
			conn = DriverManager.getConnection("jdbc:odbc:fyrs", "dba", "sql");
			pt = conn.prepareStatement("select * from t_dd_table");
			List<TddTable> tddtableList = new ArrayList<TddTable>();
			rs = pt.executeQuery();
			while (rs.next()) {
				TddTable tdd = new TddTable();
				tdd.setCid(rs.getString(1));
				tdd.setCtablename(rs.getString(2));
				tdd.setCcnname(rs.getString(3));
				tdd.setBroottable(rs.getInt(4));
				tdd.setBuserdefined(rs.getInt(5));
				tdd.setNorder(rs.getInt(6));
				tddtableList.add(tdd);
			}
			rs.close();
			pt.close();
			for (int i = tddtableList.size()-1; i >= 0; i--) {
				TddTable td = new TddTable();
				List<TableField> colNames = new ArrayList<TableField>();
				td = tddtableList.get(i);
				String tableName = td.getCtablename();
				String sql = "select c_fieldname,n_datatype from t_dd_field where c_tableid = '"
						+ tableName + "'";
				pt = conn.prepareStatement(sql);
				rs = pt.executeQuery();
				while (rs.next()) {
					TableField tableField = new TableField();
					String ctabname = rs.getString(1);
					if (!ctabname.equals("N_PJNL")
							&& !ctabname.equals("N_SFFG")) {
						tableField.setCfieldname(ctabname);
						tableField.setNdatatype(rs.getInt(2));
						colNames.add(tableField);
					}
				}
				rs.close();
				pt.close();
				LeadinDataFromDBFile(colNames, tableName);
				colNames = null;
			}
			conn.close();
			tddtableList=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@RequestMapping(value = "/ExportFile.do", method = RequestMethod.POST)
	public void ExportFile(Model model, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		// 使用jdbc-odbc连接到数据源
		java.sql.Connection conn = null;
		java.sql.PreparedStatement pt = null;
		java.sql.ResultSet rs = null;
		SessionFactoryImpl impl =(SessionFactoryImpl)getSessionFactory();
		ConnectionProvider provider = impl.getConnectionProvider();
		// 对其进行操作
		try {
			// 访问建立的数据源
			conn = provider.getConnection();
			pt = conn.prepareStatement("select * from t_dd_table");
			List<TddTable> tddtableList = new ArrayList<TddTable>();
			rs = pt.executeQuery();
			while (rs.next()) {
				TddTable tdd = new TddTable();
				tdd.setCid(rs.getString(1));
				tdd.setCtablename(rs.getString(2));
				tdd.setCcnname(rs.getString(3));
				tdd.setBroottable(rs.getInt(4));
				tdd.setBuserdefined(rs.getInt(5));
				tdd.setNorder(rs.getInt(6));
				tddtableList.add(tdd);
			}
			rs.close();
			pt.close();
			for (int i = tddtableList.size()-1; i >= 0; i--) {
				TddTable td = new TddTable();
				List<TableField> colNames = new ArrayList<TableField>();
				td = tddtableList.get(i);
				String tableName = td.getCtablename();
				String sql = "select c_fieldname,n_datatype from t_dd_field where c_tableid = '"
						+ tableName + "'";
				pt = conn.prepareStatement(sql);
				rs = pt.executeQuery();
				while (rs.next()) {
					TableField tableField = new TableField();
					String ctabname = rs.getString(1);
					if (!ctabname.equals("N_PJNL")
							&& !ctabname.equals("N_SFFG")) {
						tableField.setCfieldname(ctabname);
						tableField.setNdatatype(rs.getInt(2));
						colNames.add(tableField);
					}
				}
				rs.close();
				pt.close();
				exportData(colNames, tableName);
				colNames = null;
			}
			conn.close();
			tddtableList=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void LeadinDataFromDBFile(List<TableField> colNames,
			String tableName) {
		java.sql.Connection conn = null;
		java.sql.PreparedStatement pt = null;
		java.sql.ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:odbc:fyrs","dba","sql");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String FieldContent = "";
		for (int i = 0; i < colNames.size(); i++) {
			if (i == colNames.size() - 1) {
				FieldContent += colNames.get(i).getCfieldname();
			} else {
				FieldContent += colNames.get(i).getCfieldname() + ",";
			}
		}
		String sql = "select " + FieldContent + " from " + tableName;
		try {
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();
			List<List<Object>> contentList = new ArrayList<List<Object>>();
			while(rs.next()){
				List<Object> objectList = new ArrayList<Object>();
				objectList = convertData(rs, colNames);
				contentList.add(objectList);
				objectList = null;
			}
			transformData(contentList,colNames,tableName,FieldContent);
			rs.close();
			pt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
	}

	
	public void exportData(List<TableField> colNames,
			String tableName) {
		java.sql.Connection conn = null;
		java.sql.PreparedStatement pt = null;
		java.sql.ResultSet rs = null;
		SessionFactoryImpl impl =(SessionFactoryImpl)getSessionFactory();
		ConnectionProvider provider = impl.getConnectionProvider();
		try {
			conn = provider.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String FieldContent = "";
		for (int i = 0; i < colNames.size(); i++) {
			if (i == colNames.size() - 1) {
				FieldContent += colNames.get(i).getCfieldname();
			} else {
				FieldContent += colNames.get(i).getCfieldname() + ",";
			}
		}
		String sql = "select " + FieldContent + " from " + tableName;
		try {
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();
			List<List<Object>> contentList = new ArrayList<List<Object>>();
			while(rs.next()){
				List<Object> objectList = new ArrayList<Object>();
				objectList = convertData(rs, colNames);
				contentList.add(objectList);
				objectList = null;
			}
			expData(contentList,colNames,tableName,FieldContent);
			rs.close();
			pt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
	}
	
	public List<Object> convertData(ResultSet rs, List<TableField> colNames) {
		List<Object> objectList = new ArrayList<Object>();
		try {
			for (int i = 0; i < colNames.size(); i++) {
				TableField tabField = new TableField();
				tabField = colNames.get(i);
				if (tabField.getNdatatype() == 1) {
					objectList.add(rs.getString(i + 1));
				} else if (tabField.getNdatatype() == 2) {
					long g = rs.getLong(i+1);
					objectList.add(g==0?null:g);
				} else if (tabField.getNdatatype() == 3) {
					objectList.add(rs.getDate(i + 1));
				} else if (tabField.getNdatatype() == 4) {
					float f = rs.getFloat(i+1);
					objectList.add(f==0?null:f);
				} else if (tabField.getNdatatype() == 5) {
					int r = rs.getInt(i+1);
					objectList.add(r==0?null:r);
				} else if (tabField.getNdatatype() == 7) {
					objectList.add(rs.getString(i + 1));
				} else {
					int r = rs.getInt(i+1);
					objectList.add(r==0?null:r);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objectList;
	}
	
	public void transformData(List<List<Object>> contentList,List<TableField> colNames,String tableName,String fieldFullContent){
		xtglDrdcDAO.insertOrUpdate(contentList,colNames,tableName,fieldFullContent);
	}
	
	public void expData(List<List<Object>> contentList,List<TableField> colNames,String tableName,String fieldFullContent){
		xtglDrdcDAO.exportinsertOrUpdate(contentList,colNames,tableName,fieldFullContent);
	}
}
