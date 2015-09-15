package nju.software.fyrs.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.googlecode.ehcache.annotations.Cacheable;

import nju.software.fyrs.biz.vo.PrimaryKeyFyRybhVO;
import nju.software.fyrs.biz.vo.SdcxQueryVO;
import nju.software.fyrs.biz.vo.SdcxShowColumnsVO;
import nju.software.fyrs.data.dao.DmDAO;
import nju.software.fyrs.data.dao.SdcxDao;
import nju.software.fyrs.service.SdcxService;
import nju.software.fyrs.util.CommonObjectsInList;
import nju.software.fyrs.util.ConstantsFyrs;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.util.DmMcCommon;
import nju.software.fyrs.util.NFyRybhCodeUtils;
import nju.software.fyrs.util.SdcxUtil;

public class SdcxServiceImpl implements SdcxService {
    private SdcxDao sdcxDao;
    private DmDAO dmDAO;
    private RoleMenuService roleMenuService;
    private CommonObjectsInList<PrimaryKeyFyRybhVO> comTool = new CommonObjectsInList<PrimaryKeyFyRybhVO>();
    private Map<String,String> mapNames = new HashMap<String,String>();
	@Override
	@Cacheable(cacheName="sdcxCache")
	public List<List<String>> listSdcx(SdcxQueryVO root,Map<String,List<SdcxShowColumnsVO>> showTableAndColumns,String ryk,int[] roleIds,int loginFydm)
	{
		
		List<PrimaryKeyFyRybhVO> result = new ArrayList<PrimaryKeyFyRybhVO>();
		List<Integer> canEdit = new ArrayList<Integer>();
		List<Integer> canLook = new ArrayList<Integer>();
		roleMenuService.findCanLookAndEditListFy(canLook,canEdit, roleIds, loginFydm);
	    result = listFyRybhByTree(root);
	    return common(result, showTableAndColumns,ryk,canEdit,canLook);	
	}
	@Cacheable(cacheName="sdcxCache")
	private List<PrimaryKeyFyRybhVO> listFyRybhByTree(SdcxQueryVO vo)
	{
		List<PrimaryKeyFyRybhVO> parent = sdcxDao.listFyRybh(vo.getExcuteSql());
		List<PrimaryKeyFyRybhVO> and = null;
		List<PrimaryKeyFyRybhVO> or = null;
		if(vo.getChildrenAnd().size() > 0)
		{
			and = listFyRybhByTree(vo.getChildrenAnd().get(0));
			for(int i = 1; i < vo.getChildrenAnd().size(); i++)
			{
				and = comTool.commonObjects(and,listFyRybhByTree(vo.getChildrenAnd().get(i)));
			}
		}
		if(vo.getChildrenOr().size() > 0)
		{
			or = listFyRybhByTree(vo.getChildrenOr().get(0));
			for(int i = 0; i < vo.getChildrenOr().size(); i++)
			{
				or.addAll(listFyRybhByTree(vo.getChildrenOr().get(i)));
			}
		}
		if(and != null)
		{
			parent = comTool.commonObjects(parent, and);
		}
		if(or != null)
		{
		  parent.addAll(or);	
		}
		return parent;
	}
	@Cacheable(cacheName="sdcxCache")
	private List<List<String>> common(List<PrimaryKeyFyRybhVO> result,Map<String,List<SdcxShowColumnsVO>> showTableAndColumns,String ryk,List<Integer> canEdit,List<Integer> canLook)
	{
		List<List<String>> resultVos = new ArrayList<List<String>>();
		Set<String> iter = showTableAndColumns.keySet();
		boolean isExist = false;
		int resultCount = 0;
		int fybh;
		Object obj;
		List<String> oneColumn;
		for(PrimaryKeyFyRybhVO vo : result)
		{

			String isOnlyLook = "1";
			fybh = vo.getNFy();
			if(canEdit.contains(fybh)){
				resultCount++;
				for(String str : iter)
				{
					isOnlyLook = "0";
					obj = sdcxDao.getRybjxx(str, vo.getNFy(), vo.getNRybh(),ryk);
					if(null == obj)
					{
						continue;
					}
					oneColumn = listPropertyValueInObj(obj,showTableAndColumns.get(str));
					oneColumn.add(isOnlyLook);
					oneColumn.add(NFyRybhCodeUtils.encode(vo.getNFy(), vo.getNRybh()));
					oneColumn.add(NFyRybhCodeUtils.encodeIsOnlyLook(vo.getNFy(), vo.getNRybh(),false));
					resultVos.add(oneColumn);	
				}
			}else if(canLook.contains(fybh)){
				resultCount++;
				for(String str : iter)
				{
					obj = sdcxDao.getRybjxx(str, vo.getNFy(), vo.getNRybh(),ryk);
					if(null == obj)
					{
						continue;
					}
					oneColumn = listPropertyValueInObj(obj,showTableAndColumns.get(str));
					oneColumn.add(isOnlyLook);
					oneColumn.add(NFyRybhCodeUtils.encode(vo.getNFy(), vo.getNRybh()));
					oneColumn.add(NFyRybhCodeUtils.encodeIsOnlyLook(vo.getNFy(), vo.getNRybh(),true));
					resultVos.add(oneColumn);	
				}
			}	
		}
		return resultVos;
	}
	/**
	 * 根据要获得的属性值，从对象中获取并添加到一个 List<String> 当中，因为只有 Ryjbxx 这个表所以返回的就是一个表的列
	 * @param obj
	 * @param properties
	 * @return
	 */
	@Cacheable(cacheName="sdcxCache")
	private List<String> listPropertyValueInObj(Object obj,List<SdcxShowColumnsVO> properties)
	{
		List<String> propertieValue = new ArrayList<String>();
		for(SdcxShowColumnsVO vo : properties)
		{
			Object value = SdcxUtil.getFieldValue(obj, SdcxUtil.fyrsColumnNameToFiledName(vo.getColumnName()));
			if(null == value)
			  {
				  propertieValue.add("");
				  continue;
			  }
		  if(vo.getColumnName().toCharArray()[0] == 'D')
		  {
			  propertieValue.add(DateUtil.format((Date)value, DateUtil.webFormat));  
		  }
		  else if(!vo.getnMainCode().equals("0") && vo.getColumnName().toCharArray()[0] == 'N')
		  {
			  propertieValue.add(DmMcCommon.dmMc(Integer.valueOf(value.toString()),Integer.valueOf(vo.getnMainCode()), mapNames, dmDAO));
		  }
		  else if((vo.getnMainCode().equals("0") && vo.getColumnName().trim().equals("N_FY")))
		  {
			  propertieValue.add(DmMcCommon.dmMc(Integer.valueOf(value.toString()),ConstantsFyrs.NBXH_DWMC, mapNames, dmDAO));
		  }
		  else
		  {
			  propertieValue.add(value.toString());
		  }
		  
		}
		return propertieValue;
	}
	public void setSdcxDao(SdcxDao sdcxDao)
	{
		this.sdcxDao = sdcxDao;
	}
	public void setDmDAO(DmDAO dmDAO)
	{
		this.dmDAO = dmDAO;
	}
	public void setRoleMenuService(RoleMenuService roleMenuService)
	{
		this.roleMenuService = roleMenuService;
	}
	
	
  
}
