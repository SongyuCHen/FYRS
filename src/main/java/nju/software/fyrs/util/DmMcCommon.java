package nju.software.fyrs.util;

import java.util.Map;

import nju.software.fyrs.data.dao.DmDAO;
import nju.software.fyrs.data.dataobject.Dm;
import nju.software.fyrs.service.DmService;

public class DmMcCommon {
	public  static String dmMc(Integer ndm,Integer nbxh,Map<String,String> mapNames,DmService dmService)
	{
		if(null == ndm || null == nbxh)
		{
			return "";
		}
		String mc = mapNames.get(ndm+"-"+nbxh);
		if(null == mc)
		{
			Dm dm = dmService.dmByDmBxh(ndm, nbxh);
			if(null != dm)
			{
				mc = dm.getCMc();
				mapNames.put(ndm+"-"+nbxh, mc);
				return mc;
			}
			return "";
		}		
		return mc;
	}
	public  static String dmMc(Integer ndm,Integer nbxh,Map<String,String> mapNames,DmDAO dmDAO)
	{
		if(null == ndm || null == nbxh)
		{
			return "";
		}
		String mc = mapNames.get(ndm+"-"+nbxh);
		if(null == mc)
		{
			Dm dm = dmDAO.dmByDmBxh(ndm, nbxh);
			if(null != dm)
			{
				mc = dm.getCMc();
				mapNames.put(ndm+"-"+nbxh, mc);
				return mc;
			}
			return "";
		}		
		return mc;
	}
}
