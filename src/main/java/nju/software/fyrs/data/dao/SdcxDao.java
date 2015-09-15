package nju.software.fyrs.data.dao;

import java.util.ArrayList;
import java.util.List;

import nju.software.fyrs.biz.vo.PrimaryKeyFyRybhVO;
import nju.software.fyrs.util.SdcxUtil;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class SdcxDao extends HibernateDaoSupport{
@SuppressWarnings("unchecked")
public List<PrimaryKeyFyRybhVO> listFyRybh(String sql)
   {
	   List<Object[]> listObjs = getSession().createSQLQuery(sql).list();
	   List<PrimaryKeyFyRybhVO> lists = new ArrayList<PrimaryKeyFyRybhVO>();
	   if(listObjs != null)
		 {
			 for(Object[] obj : listObjs)
			 {
				 PrimaryKeyFyRybhVO vo = new PrimaryKeyFyRybhVO();
				 vo.setNFy((Integer)obj[0]);
				 vo.setNRybh((Integer)obj[1]);
				 lists.add(vo);
			 }
		 }
	   return lists;
   }
public Object getRybjxx(String tableName,int fydm,int rybh,String ryk)
{
	return getSession().createQuery(" from " +SdcxUtil.fyrsTableToObjectName(tableName)+" where NFy = " + fydm + " and NRybh = "+rybh +" and NBiaozhi = "+Integer.valueOf(ryk)).uniqueResult();
}
@SuppressWarnings("unchecked")
public List<Object> listObjects(String tableName,int fydm,int rybh)
{
	return getSession().createQuery(" from " +SdcxUtil.fyrsTableToObjectName(tableName)+" where NFy = " + fydm + " and NRybh = "+rybh).list();
}
}
