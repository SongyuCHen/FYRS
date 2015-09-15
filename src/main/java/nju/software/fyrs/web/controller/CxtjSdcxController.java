package nju.software.fyrs.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.DdFieldCondtionVO;
import nju.software.fyrs.biz.vo.DdFieldVO;
import nju.software.fyrs.biz.vo.DdTableVO;
import nju.software.fyrs.biz.vo.DmCommonVO;
import nju.software.fyrs.biz.vo.SdcxConditionVO;
import nju.software.fyrs.biz.vo.SdcxQueryVO;
import nju.software.fyrs.biz.vo.SdcxShowColumnsVO;
import nju.software.fyrs.data.dataobject.Dm;
import nju.software.fyrs.service.DdFieldService;
import nju.software.fyrs.service.DdTableService;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.RyjbxxService;
import nju.software.fyrs.service.SdcxConditionService;
import nju.software.fyrs.service.SdcxService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.impl.RsFyServiceImpl;
import nju.software.fyrs.service.model.UserContext;
import nju.software.fyrs.util.ConstantsFyrs;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.util.DmCommonList;
import nju.software.fyrs.util.NFyRybhCodeUtils;
import nju.software.fyrs.util.RolesUtil;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
@RequestMapping("/main/cxtj")
public class CxtjSdcxController {
	    private RoleMenuService roleMenuService;
	    private DdTableService ddTableService;
	    private DdFieldService ddFieldService;
	    private DmService dmService;
	    private RsFyServiceImpl rsFyService;
	    private SdcxService sdcxService;
	    private SdcxConditionService sdcxConditionService;
	    private RyjbxxService ryjbxxService;
	    
	    
	    @RequestMapping(value="/sdcx.do",method = RequestMethod.GET)
	    public String showSdcx(Model model,HttpServletResponse response,HttpServletRequest request)
	    {
	       MenuShowUtils.headerMenu(request,model, roleMenuService,"查询统计");
		   MenuShowUtils.leftMenu(request,model, roleMenuService, "cxtj");
	       model.addAttribute("currentSelectLeftMenu","深度查询");
	       DmCommonList.listAllCommon(model,new int[]{ConstantsFyrs.NBXH_GJCXTJ_RYK},new String[]{"ryks"},dmService);
	       return "sdcx/show";
	    }
	    @RequestMapping(value="/getTable.aj",method = RequestMethod.GET)
	    public void sdcxTable(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException
	    {
	    	List<DdTableVO> vos = ddTableService.listAllTable();
	    	 ResponseBuilder rb = new ResponseBuilder();
		     rb.writeJsonResponse(response,vos);
	    }
	    @RequestMapping(value="/getColumsShow.aj",method = RequestMethod.POST)
	    public void sdcxColumsShow(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException
	    {
	    	 String tableName = request.getParameter("tableName");
	    	 List<DdFieldVO> vos = ddFieldService.listByTableName(tableName);
	    	 ResponseBuilder rb = new ResponseBuilder();
		     rb.writeJsonResponse(response,vos);
	    }
	    @RequestMapping(value="/getColumsCondtion.aj",method = RequestMethod.POST)
	    public void sdcxColumsCondtion(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException
	    {
	    	
	    	 String tableName = request.getParameter("tableName");
	    	 List<DdFieldCondtionVO> vos = ddFieldService.listByTableNameCondition(tableName);
	    	 ResponseBuilder rb = new ResponseBuilder();
		     rb.writeJsonResponse(response,vos);
	    }
	    @RequestMapping(value="/findCondition.aj",method = RequestMethod.POST)
	    public String findCondition(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException
	    {
	    	String columnNameMc = request.getParameter("columnNameMc");
	    	String tableNameMc = request.getParameter("tableNameMc");
	    	String logicType = request.getParameter("logicType");
	    	String mainCode = request.getParameter("mainCode");
	    	
	    	model.addAttribute("mainCode",mainCode);
	    	model.addAttribute("columnNameMc",columnNameMc);
	    	model.addAttribute("tableNameMc",tableNameMc);
	    	model.addAttribute("logicType",logicType);
	    	List<DmCommonVO> vos = null;
	    	if(logicType.equals("101") || logicType.equals("104") || logicType.equals("210"))
	    	{
	    		List<Dm> dms = dmService.listDmByNBxh(mainCode);
	    	    vos = new ArrayList<DmCommonVO>();
	    		commonList(dms, vos, model);
	    	}
	    	// 表示选择法院
	    	if(logicType.equals("103"))
	    	{
	    	    vos = new ArrayList<DmCommonVO>();
	    		int fydm = RolesUtil.getUserContext(request).getFydm();
	    		// 获得法院分级码
	    		String fjm = rsFyService.fjmByFydm(fydm);
	    		if(fjm.equals("-1"))
	    		{
	    			Dm dm = dmService.dmByDmBxh(fydm, ConstantsFyrs.NBXH_DWMC);
	    			commonVo(dm, vos, model);
	    		}
	    		else
	    		{
	    			// 
	    			Boolean isXjfy = roleMenuService.findIsCkxjfy(RolesUtil.userGetRoleIds(request));
	    			if(isXjfy)
	    			{
	    				List<Dm> dms = rsFyService.listDmByFyfjm(fjm);
	    				commonList(dms, vos, model);
	    			}
	    			// 表示虽然不是最底层，但是没有查看下级法院的权限
	    			else
	    			{
	    				Dm dm = dmService.dmByDmBxh(fydm, ConstantsFyrs.NBXH_DWMC);
		    			commonVo(dm, vos, model);
	    			}
	    		}
	    		roleMenuService.findIsCkxjfy(RolesUtil.userGetRoleIds(request));
	    	}
	    	return "cxtj/pop/findCondition";
	    }
	    @RequestMapping(value="/findConditionResult.aj",method = RequestMethod.POST)
	    public void findConditionResult(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException
	    {
	      String queryData = request.getParameter("queryData");

          JsonParser jsonParser = new JsonParser();
          JsonArray queryDataArr = (JsonArray) jsonParser.parse(queryData);
          // 传递过来的JsonArray 是有顺序的，所以可以顺序来处理，其实它也必有一个元素,也是最后一个元素
          SdcxQueryVO root =  jsonObjToSdcxQueryVO(queryDataArr.get(queryDataArr.size() - 1).getAsJsonObject());
          Map<String,SdcxQueryVO> temp = new HashMap<String,SdcxQueryVO>();
          temp.put(root.getId(),root);
          for(int i = 0; i < queryDataArr.size() - 1; i++)
          {
        	  JsonObject obj = queryDataArr.get(i).getAsJsonObject();
        	  SdcxQueryVO tempVo = jsonObjToSdcxQueryVO(obj);
        	  if(tempVo.getAndOr().trim().equals("and"))
        	  {
        		  temp.get(tempVo.getTopId()).getChildrenAnd().add(tempVo); 
        	  }
        	  if(tempVo.getAndOr().trim().equals("or"))
        	  {
        		  temp.get(tempVo.getTopId()).getChildrenOr().add(tempVo);
        	  }
        	  temp.put(tempVo.getId(), tempVo);
          }
          temp = null;
           // 需要显示的数据
           
           String showData = request.getParameter("showData");
           String ryk = request.getParameter("ryk");
           
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
           List<List<String>> showColumnLists = sdcxService.listSdcx(root,showTableAndColumns,ryk,RolesUtil.userGetRoleIds(request),RolesUtil.getUserContext(request).getFydm());
           ResponseBuilder rb = new ResponseBuilder();
           if(null == showColumnLists)
	       {
        	   Map<String,String> map = new HashMap<String,String>();
        	   map.put("result","dataTooLong");
        	   rb.writeJsonResponse(response,map);
	       }
           else
           {
        	   rb.writeJsonResponse(response,showColumnLists);
           }
           	       
	       
	    }
	    @RequestMapping(value="/saveSdcxCondition.aj",method = RequestMethod.POST)
	    public void saveSdcxCondition(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException
	    {
	    	String sdcxConditionHtml = request.getParameter("sdcxConditionHtml");
	    	String conditionName = request.getParameter("conditionName");
	    	String ryk = request.getParameter("ryk");
	    	SdcxConditionVO vo = new SdcxConditionVO();
	    	vo.setCTjmc(conditionName);
	    	vo.setTConditon(sdcxConditionHtml);
	    	vo.setDBcsj(DateUtil.format(new Date(), DateUtil.webFormat));
	    	UserContext uc = RolesUtil.getUserContext(request);
	    	vo.setNFy(uc.getFydm()+"");
	    	vo.setNRybh(uc.getYhbh()+"");
	    	vo.setNRyk(ryk);
	        sdcxConditionService.add(vo);
	        ResponseBuilder rb = new ResponseBuilder();
	        rb.writeJsonResponse(response,"1");
	    }
	    @RequestMapping(value="/oldSdcxCondition.aj",method = RequestMethod.POST)
	    public String oldSdcxCondition(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException
	    {
	    	UserContext uc = RolesUtil.getUserContext(request);
	    	List<SdcxConditionVO> vos = sdcxConditionService.listAll(uc.getFydm(),uc.getYhbh());
	    	model.addAttribute("vos",vos);
	    	return "cxtj/pop/oldCondition";
	    }
	    
	    
	    @RequestMapping(value="/deleteOldCondition.aj",method = RequestMethod.POST)
	    public void deleteOldCondition(HttpServletResponse response,HttpServletRequest request) throws IOException
	    {
	    	String id = request.getParameter("id");
	    	String fydm = request.getParameter("fydm");
	    	String rybh = request.getParameter("rybh");
	    	sdcxConditionService.delete(id, fydm, rybh);
	        ResponseBuilder rb = new ResponseBuilder();
	        rb.writeJsonResponse(response,"1");
	    }
	    @RequestMapping(value="/deleteOldConditionAll.aj",method = RequestMethod.POST)
	    public void deleteOldConditionAll(HttpServletResponse response,HttpServletRequest request) throws IOException
	    {
	    	String fydm = request.getParameter("fydm");
	    	String rybh = request.getParameter("rybh");
	    	sdcxConditionService.deleteAll(fydm, rybh);
	        ResponseBuilder rb = new ResponseBuilder();
	        rb.writeJsonResponse(response,"1");
	    }
	    @RequestMapping(value="/oldConditionHtml.aj",method = RequestMethod.POST)
	    public void oldConditionHtml(HttpServletResponse response,HttpServletRequest request) throws IOException
	    {
	    	String id = request.getParameter("id");
	    	String fydm = request.getParameter("fydm");
	    	String rybh = request.getParameter("rybh");
	    	Map<String,String> htmlAndRyk = new HashMap<String,String>();
	    	SdcxConditionVO vo = sdcxConditionService.findByIdFydmRybh(id, fydm, rybh);
	    	htmlAndRyk.put("html", vo.getTConditon());
	    	htmlAndRyk.put("ryk",vo.getNRyk());
	        ResponseBuilder rb = new ResponseBuilder();
	        rb.writeJsonResponse(response,htmlAndRyk);
	    }
	    @RequestMapping(value="/sdcxDelete.aj",method = RequestMethod.POST)
	    public void sdcxDelete(HttpServletResponse response,HttpServletRequest request) throws IOException
	    {
	    	   String ShowKey = request.getParameter("showKey");
	    	   String[] fydmRybh = NFyRybhCodeUtils.decode(ShowKey.trim());
	    	   String fydm = fydmRybh[0];
		       String rybh = fydmRybh[1];
		       UserContext userContext = RolesUtil.getUserContext(request);
		       ResponseBuilder rb = new ResponseBuilder();
		       if( fydm.trim().equals(String.valueOf(userContext.getFydm())) && rybh.trim().equals(String.valueOf(userContext.getYhbh())))
		       {
		    	   rb.writeJsonResponse(response, "deleteSelf");
		       }
		       boolean isSuccess =  ryjbxxService.deleteRyjbxxAndAllSubTable(Integer.valueOf(fydm),Integer.valueOf(rybh));
		      
		       if(isSuccess)
		       {
		    	   rb.writeJsonResponse(response, "success");
		       }
		       else
		       {
		    	   rb.writeJsonResponse(response, "fail");
		       }
	    }
	    
	    
	    private SdcxQueryVO jsonObjToSdcxQueryVO(JsonObject obj)
	    {
	    	SdcxQueryVO vo = new SdcxQueryVO();
	    	vo.setAndOr(subString(obj.get("andOr").toString()));
	    	vo.setId(subString(obj.get("id").toString()));
	    	vo.setTopId(subString(obj.get("topId").toString()));
	    	vo.setParentId(subString(obj.get("parentId").toString()));
	    	vo.setExcuteSql(" SELECT N_FY,N_RYBH FROM " + subString(obj.get("tableName").toString()) + " WHERE " + subString(obj.get("sql").toString()));
	    	return vo;
	    }
	    private String subString(String src)
	    {
	    	return src.substring(1,src.length() - 1);
	    }
	    private void commonList(List<Dm> dms,List<DmCommonVO> vos,Model model)
	    {
	    	for(Dm dm : dms)
    		{
    			DmCommonVO vo = new DmCommonVO();
    			vo.setCMc(dm.getCMc());
    			vo.setNDm(dm.getNDm());
    			vos.add(vo);
    		}
    		model.addAttribute("dms",vos);
	    }
	    private void commonVo(Dm dm,List<DmCommonVO> vos,Model model)
	    {
	    	DmCommonVO vo = new DmCommonVO();
			vo.setCMc(dm.getCMc());
			vo.setNDm(dm.getNDm());
			vos.add(vo);
			model.addAttribute("dms",vos);
	    }
		public void setRoleMenuService(RoleMenuService roleMenuService) {
			this.roleMenuService = roleMenuService;
		}
		public void setDdTableService(DdTableService ddTableService)
		{
			this.ddTableService = ddTableService;
		}
		public void setDdFieldService(DdFieldService ddFieldService)
		{
			this.ddFieldService = ddFieldService;
		}
		public void setDmService(DmService dmService)
		{
			this.dmService = dmService;
		}
		public void setRsFyService(RsFyServiceImpl rsFyService)
		{
			this.rsFyService = rsFyService;
		}
		public void setSdcxService(SdcxService sdcxService)
		{
			this.sdcxService = sdcxService;
		}
		public void setSdcxConditionService(SdcxConditionService sdcxConditionService)
		{
			this.sdcxConditionService = sdcxConditionService;
		}
		public void setRyjbxxService(RyjbxxService ryjbxxService)
		{
			this.ryjbxxService = ryjbxxService;
		}
		
}
