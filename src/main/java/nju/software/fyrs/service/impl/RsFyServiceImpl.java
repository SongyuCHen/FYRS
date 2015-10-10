package nju.software.fyrs.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.googlecode.ehcache.annotations.Cacheable;

import nju.software.fyrs.biz.vo.FyTreeDataObject;
import nju.software.fyrs.data.dao.DmDAO;
import nju.software.fyrs.data.dataobject.Dm;

public class RsFyServiceImpl {
	private DmDAO dmDAO;
	
	/*
	 * 为了缓存
	 */
	@Cacheable(cacheName="rsfyCache")
	public FyTreeDataObject FyTreeForCache(String fyfjm){
		return FyTree(fyfjm);
	}
	
	
	/**
	 * 这个方法最顶的树，只能是一级或二级
	 * @param fyFjm 2% 表示查找天津所有法院，21% 表示查询一中院及下属法院 
	 * @return
	 */

	public FyTreeDataObject FyTree(String fyfjm) {
		List<Dm> fyDms = dmDAO.listDmByFyfjm(fyfjm);
		if(fyDms.size() == 0)
		{
			return null;
		}
		Map<String,FyTreeDataObject> maps = new HashMap<String, FyTreeDataObject>();
		// 第一个应该是根节点
		Dm first = fyDms.get(0);
		String rootCBz = first.getCBz();
		String rootKey = rootCBz.substring(rootCBz.length() - 2,rootCBz.length());
		for(Dm dm : fyDms)
		{
		  String cbzAll = dm.getCBz();
		  String cbz = cbzAll.substring(cbzAll.length() - 2,cbzAll.length());
		  // 这里是一级树
		  if(cbz.equals("00"))
		  {
			  if(maps.get(cbz) == null)
			  {
				 putFyTreeDataObjectToMap(dm, maps, cbz);
			  }
			  continue;
		  }
		  // 这里是二级树，可以没有一级树
		  if(!cbz.equals("00") && cbz.endsWith("0"))
		  {
			  if(maps.get(cbz) == null)
			  {
				  putFyTreeDataObjectToMap(dm, maps, cbz);
			  }
			  // 如果没有一级就不用添加,如果有直接添加二级树
			  if(maps.get("00") != null)
			  {
				  maps.get("00").getChildren().add(maps.get(cbz));
			  }
			  continue;
		  }
		  // 能到这里说明都是子树，而且是三级的,可以这么写是保证，父节点一定比子节点出现早（排序决定的）
		  fyTreeDataObjectAddChildren(maps.get(cbz.substring(0,cbz.length() - 1)+"0"), dm);
		}
		return maps.get(rootKey);
	}
	
	 public String fjmByFydm(int fydm)
		{
			 Dm dm = dmDAO.dmByFydm(fydm);
			 String fjm = dm.getCBz();
		    	// 表示一级法院
		    	if(fjm.endsWith("00"))
		    	{
		    		return fjm.substring(0,1)+"%";
		    	}
		    	// 表示二级法院
		    	if(!fjm.endsWith("00") && fjm.endsWith("0"))
		    	{
		    	    return fjm.substring(0,2)+"%";
		    	}
		    	// 表示最底层法院
		    	return "-1";
		}
	 /**
	  * 根据法院来构造一个节点
	  * @param fydm
	  * @return
	  */
	 public FyTreeDataObject fyTreeOnlyOne(int fydm)
	    {
	    	Dm dm = dmDAO.dmByFydm(fydm);
	    	FyTreeDataObject fyTreeDataObject = new FyTreeDataObject();
	    	fyTreeDataObject.setFydm(fydm);
	    	fyTreeDataObject.setFymc(dm.getCMc());
	    	return fyTreeDataObject;
	    }
	private void putFyTreeDataObjectToMap(Dm dm,Map<String,FyTreeDataObject> maps,String mapKey)
	{
		 FyTreeDataObject fdo = new FyTreeDataObject();
		  dmToFyTreeDataObject(fdo, dm);
		  maps.put(mapKey,fdo);
	}
	private void dmToFyTreeDataObject(FyTreeDataObject fdo,Dm dm)
	{
		fdo.setFymc(dm.getCMc());
		fdo.setFydm(dm.getNDm());
	}
	private void fyTreeDataObjectAddChildren(FyTreeDataObject parent,Dm dm)
	{
		FyTreeDataObject fdo = new FyTreeDataObject();
		dmToFyTreeDataObject(fdo, dm);
		parent.getChildren().add(fdo);
	}
	public List<Dm> listDmByFyfjm(String fyfjm)
	{
		return dmDAO.listDmByFyfjm(fyfjm);
	}
	
	public void setDmDAO(DmDAO dmDAO) {
		this.dmDAO = dmDAO;
	}
	
}
