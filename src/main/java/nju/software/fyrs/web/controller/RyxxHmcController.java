package nju.software.fyrs.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.SdcxShowColumnsVO;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.RyjbxxService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.util.ConstantsFyrs;
import nju.software.fyrs.util.DmCommonList;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
@RequestMapping("/main/ryxx")
public class RyxxHmcController {
	    private RoleMenuService roleMenuService;
	    private RyjbxxService ryjbxxService;
	    private DmService dmService;
	    @RequestMapping(value="/hmc.do",method = RequestMethod.GET)
	    public String showZzkDefault(Model model,HttpServletResponse response,HttpServletRequest request)
	    {
	       MenuShowUtils.headerMenu(request,model, roleMenuService,"人员信息");
		   MenuShowUtils.leftMenu(request,model, roleMenuService, "ryxx");
	       model.addAttribute("currentSelectLeftMenu","花名册");
	       model.addAttribute("kus",DmCommonList.listDmCommonVO(dmService,ConstantsFyrs.NBXH_GJCXTJ_RYK+""));
	       return "hmc/show";
	    }
	    @RequestMapping(value="/hmcresult.do",method = RequestMethod.GET)
	    public String hmcresult(Model model,HttpServletResponse response,HttpServletRequest request)
	    {	      
	       return "ryxx/hresult";
	    }
	    
	    @RequestMapping(value="/getHmcList.aj",method = RequestMethod.POST)
	    public void getHmcList(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
	    	String bmDm = request.getParameter("bmDm");
	    	String ku = request.getParameter("ku");
	    	String fyDm = request.getParameter("fyDm");	    	
	    	 String showData = request.getParameter("showColumns");
	    	JsonParser jsonParser = new JsonParser();
	    	JsonArray jsonArr = (JsonArray) jsonParser.parse(showData);
	    	Map<String,List<SdcxShowColumnsVO>> showTableAndColumns = new HashMap<String,List<SdcxShowColumnsVO>>();
	           
	           for(int j = 0; j < jsonArr.size(); j++)
	           {
	        	   JsonObject obj = jsonArr.get(j).getAsJsonObject();
	        	   String key = subString(obj.get("tableName").toString());
	        	   if(showTableAndColumns.get(key) == null)
	        	   {
	        		   List<SdcxShowColumnsVO> show = new ArrayList<SdcxShowColumnsVO>();
	        		   showTableAndColumns.put(key, show);
	        	   }
	        	   SdcxShowColumnsVO col = new SdcxShowColumnsVO();
	        	   col.setColumnName(subString(obj.get("columnName").toString()));
	        	   col.setnMainCode(subString(obj.get("nmaincode").toString()));
	        	   showTableAndColumns.get(key).add(col);
	           }
	           
	        List<List<String>> vos = ryjbxxService.listDynamicShowByKuFydmBm(showTableAndColumns, ku, fyDm,bmDm);
	    	ResponseBuilder rb = new ResponseBuilder();
		    rb.writeJsonResponse(response,vos);
	    }
	    private String subString(String src)
	    {
	    	return src.substring(1,src.length() - 1);
	    }
		public void setRoleMenuService(RoleMenuService roleMenuService) {
			this.roleMenuService = roleMenuService;
		}

		public void setDmService(DmService dmService)
		{
			this.dmService = dmService;
		}
		public void setRyjbxxService(RyjbxxService ryjbxxService)
		{
			this.ryjbxxService = ryjbxxService;
		}
		
		
}
