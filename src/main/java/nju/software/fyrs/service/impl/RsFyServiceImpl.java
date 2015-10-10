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
	 * Ϊ�˻���
	 */
	@Cacheable(cacheName="rsfyCache")
	public FyTreeDataObject FyTreeForCache(String fyfjm){
		return FyTree(fyfjm);
	}
	
	
	/**
	 * ��������������ֻ����һ�������
	 * @param fyFjm 2% ��ʾ����������з�Ժ��21% ��ʾ��ѯһ��Ժ��������Ժ 
	 * @return
	 */

	public FyTreeDataObject FyTree(String fyfjm) {
		List<Dm> fyDms = dmDAO.listDmByFyfjm(fyfjm);
		if(fyDms.size() == 0)
		{
			return null;
		}
		Map<String,FyTreeDataObject> maps = new HashMap<String, FyTreeDataObject>();
		// ��һ��Ӧ���Ǹ��ڵ�
		Dm first = fyDms.get(0);
		String rootCBz = first.getCBz();
		String rootKey = rootCBz.substring(rootCBz.length() - 2,rootCBz.length());
		for(Dm dm : fyDms)
		{
		  String cbzAll = dm.getCBz();
		  String cbz = cbzAll.substring(cbzAll.length() - 2,cbzAll.length());
		  // ������һ����
		  if(cbz.equals("00"))
		  {
			  if(maps.get(cbz) == null)
			  {
				 putFyTreeDataObjectToMap(dm, maps, cbz);
			  }
			  continue;
		  }
		  // �����Ƕ�����������û��һ����
		  if(!cbz.equals("00") && cbz.endsWith("0"))
		  {
			  if(maps.get(cbz) == null)
			  {
				  putFyTreeDataObjectToMap(dm, maps, cbz);
			  }
			  // ���û��һ���Ͳ������,�����ֱ����Ӷ�����
			  if(maps.get("00") != null)
			  {
				  maps.get("00").getChildren().add(maps.get(cbz));
			  }
			  continue;
		  }
		  // �ܵ�����˵������������������������,������ôд�Ǳ�֤�����ڵ�һ�����ӽڵ�����磨��������ģ�
		  fyTreeDataObjectAddChildren(maps.get(cbz.substring(0,cbz.length() - 1)+"0"), dm);
		}
		return maps.get(rootKey);
	}
	
	 public String fjmByFydm(int fydm)
		{
			 Dm dm = dmDAO.dmByFydm(fydm);
			 String fjm = dm.getCBz();
		    	// ��ʾһ����Ժ
		    	if(fjm.endsWith("00"))
		    	{
		    		return fjm.substring(0,1)+"%";
		    	}
		    	// ��ʾ������Ժ
		    	if(!fjm.endsWith("00") && fjm.endsWith("0"))
		    	{
		    	    return fjm.substring(0,2)+"%";
		    	}
		    	// ��ʾ��ײ㷨Ժ
		    	return "-1";
		}
	 /**
	  * ���ݷ�Ժ������һ���ڵ�
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
