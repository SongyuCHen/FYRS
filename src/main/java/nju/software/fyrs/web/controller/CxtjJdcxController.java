package nju.software.fyrs.web.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.JdcxExportVO;
import nju.software.fyrs.biz.vo.RyjbxxJdcxVO;
import nju.software.fyrs.data.dataobject.Ryjbxx;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.RyjbxxService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.model.UserContext;
import nju.software.fyrs.util.ConstantsFyrs;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.util.DmCommonList;
import nju.software.fyrs.util.DmMcCommon;
import nju.software.fyrs.util.ExcelUtil;
import nju.software.fyrs.util.NFyRybhCodeUtils;
import nju.software.fyrs.util.RolesUtil;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main/cxtj")
public class CxtjJdcxController {
	    private RoleMenuService roleMenuService;
	    private DmService dmService;
	    private RyjbxxService ryjbxxService;
	    private Map<String,String> mapNames = new HashMap<String,String>();
	    @RequestMapping(value="/jdcx.do",method = RequestMethod.GET)
	    public String showJdcx(Model model,HttpServletResponse response,HttpServletRequest request)
	    {
	       MenuShowUtils.headerMenu(request,model, roleMenuService,"查询统计");
		   MenuShowUtils.leftMenu(request,model, roleMenuService, "cxtj");
	       model.addAttribute("currentSelectLeftMenu","简单查询");
	       int[] types = {ConstantsFyrs.NBXH_GJCXTJ_FLZW,ConstantsFyrs.NBXH_GJCXTJ_BM,ConstantsFyrs.NBXH_ZWLB,ConstantsFyrs.NBXH_GJCXTJ_ZY,ConstantsFyrs.NBXH_GJCXTJ_ZJ,ConstantsFyrs.NBXH_GJCXTJ_DJ,ConstantsFyrs.NBXH_GJCXTJ_XL,ConstantsFyrs.NBXH_GJCXTJ_RYK};
	       // 法律职务、部门、职务类别、专业、职级、等级、学历、人员库
           String[] names = {"flzws","bms","zwlbs","zys","zjs","djs","xls","ryks"};	
           DmCommonList.listAllCommon(model, types, names,dmService);
	       return "jdcx/show";
	    }
	    @RequestMapping(value="/jdcxFind.aj",method = RequestMethod.POST)
	    public void jdcxFind(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
	    	String zy = request.getParameter("zy");
	    	String xl = request.getParameter("xl");
	    	String bm = request.getParameter("bm");
	    	String dj = request.getParameter("dj");
	    	String ryk = request.getParameter("ryk");
	    	String flzw = request.getParameter("flzw");
	    	String zj = request.getParameter("zj");
	    	
	    	String zwlb = request.getParameter("zwlb");
	    	List<Ryjbxx> lists = ryjbxxService.listByFlzwBmZwlbZyZjDjXlRyk(flzw, bm, zwlb, zy, zj, dj, xl, ryk);
	    	
	    	List<Integer> canEdit = new ArrayList<Integer>();
	    	List<Integer> canLook = new ArrayList<Integer>();
	    	roleMenuService.findCanLookAndEditListFy(canLook, canEdit, RolesUtil.userGetRoleIds(request),RolesUtil.getUserContext(request).getFydm());
	    	List<RyjbxxJdcxVO> vos = new ArrayList<RyjbxxJdcxVO>();
	    	boolean isExist = false;
	    	for(Ryjbxx rj : lists)
	    	{
	    		isExist = false;
	    		for(Integer edit :canEdit)
	    		{
	    			if((int)rj.getNFy() == (int)edit)
	    			{
	    				commonRjToVo(rj, vos, false);
	    				isExist = true;
	    				break;
	    			}
	    			
	    		}
	    		if(isExist)
	    		{
	    			continue;
	    		}
	    		for(Integer look :canLook)
	    		{
	    			if((int)rj.getNFy() == (int)look)
	    			{
	    				commonRjToVo(rj, vos, true);
	    				isExist = true;
	    				break;
	    			}
	    			
	    		}	
	    	}
	      
	      ResponseBuilder rb = new ResponseBuilder();
	      rb.writeJsonResponse(response, vos);
	    }
	    
	    private void commonRjToVo(Ryjbxx rj,List<RyjbxxJdcxVO> vos,boolean isOnlyLook)
	    {
	    	RyjbxxJdcxVO vo = new RyjbxxJdcxVO();
	    	vo.setIsOnlyLook(isOnlyLook);
	    	vo.setIsOnlyLookEncode(NFyRybhCodeUtils.encodeIsOnlyLook(rj.getNFy(), rj.getNRybh(), isOnlyLook));
	    	vo.setNFy(rj.getNFy());
    		vo.setNRybh(rj.getNRybh());
    		vo.setDwmc(DmMcCommon.dmMc(rj.getNFy(),ConstantsFyrs.NBXH_DWMC,mapNames,dmService));
    		vo.setBmMc(DmMcCommon.dmMc(rj.getNBm(),ConstantsFyrs.NBXH_NSJG,mapNames,dmService));
    		vo.setCXm(rj.getCXm());
    		vo.setXzzwMc(DmMcCommon.dmMc(rj.getNXzzw(),ConstantsFyrs.NBXH_XZZW,mapNames,dmService));
    		vo.setXb(DmMcCommon.dmMc(rj.getNXb(),ConstantsFyrs.NBXH_XB,mapNames,dmService));
    		vo.setShowKey(NFyRybhCodeUtils.encode(rj.getNFy(),rj.getNRybh()));
    		vos.add(vo);
	    }
	    @RequestMapping(value="/jdcxDelete.aj",method = RequestMethod.POST)
	    public void jdcxDelete(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
	       String fydm = request.getParameter("fydm");
	       String rybh = request.getParameter("rybh");
	       UserContext userContext = RolesUtil.getUserContext(request);
	       ResponseBuilder rb = new ResponseBuilder();
	       if( fydm.trim().equals(String.valueOf(userContext.getFydm())) && rybh.trim().equals(String.valueOf(userContext.getYhbh())))
	       {
	    	   rb.writeJsonResponse(response, "deleteSelf");
	       }
	       boolean isSuccess = ryjbxxService.deleteRyjbxxAndAllSubTable(Integer.valueOf(fydm),Integer.valueOf(rybh));
	      
	       if(isSuccess)
	       {
	    	   rb.writeJsonResponse(response, "success");
	       }
	       else
	       {
	    	   rb.writeJsonResponse(response, "fail");
	       }
	       
	    }
	    @SuppressWarnings("deprecation")
		@RequestMapping(value="/jdcxExport.aj",method = RequestMethod.GET)
	    public void jdcxExport(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
	       String inString = request.getParameter("inString");
	       Map<String,String> mapNames = new HashMap<String,String>();
	       List<Ryjbxx> lists = ryjbxxService.listByFydmRybhIn(inString);
	       List<JdcxExportVO> vos = new ArrayList<JdcxExportVO>();
	    	for(Ryjbxx rj : lists)
	    	{
	    		JdcxExportVO vo = new JdcxExportVO();
	    		vo.setDwmc(DmMcCommon.dmMc(rj.getNFy(),ConstantsFyrs.NBXH_DWMC,mapNames,dmService));
	    		vo.setBmMc(DmMcCommon.dmMc(rj.getNBm(),ConstantsFyrs.NBXH_NSJG,mapNames,dmService));
	    		vo.setCXm(rj.getCXm());
	    		vo.setXzzwMc(DmMcCommon.dmMc(rj.getNXzzw(),ConstantsFyrs.NBXH_XZZW,mapNames,dmService));
	    		vo.setFlzwMc(DmMcCommon.dmMc(rj.getNFlzw(),ConstantsFyrs.NBXH_FLZW,mapNames,dmService));
	    		if(rj.getDCsrq()!=null){
	    			vo.setAge(String.valueOf(DateUtil.today().getYear()-rj.getDCsrq().getYear()));
	    		}
	    		vo.setZjMc(DmMcCommon.dmMc(rj.getNZj(),ConstantsFyrs.NBXH_ZJ,mapNames,dmService));
	    		vo.setXlMc(DmMcCommon.dmMc(rj.getNXl(),ConstantsFyrs.NBXH_WHCD,mapNames,dmService));
	    		vo.setXb(DmMcCommon.dmMc(rj.getNXb(),ConstantsFyrs.NBXH_XB,mapNames,dmService));
	    	    vos.add(vo);
	    	}
	       String headers[] = {"姓名", "性别" , "工作单位", "部门", "行政职务","法律职务","年龄","职级","学历"};
	       ExcelUtil<JdcxExportVO> excelUtil = new ExcelUtil<JdcxExportVO>();
			String filename = "人员信息表.xls";
			filename = this.encodeFilename(filename, request);
			response.reset();
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "inline; filename=\"" + filename+"\";");
			
			OutputStream out = null;
			try { 
				out = response.getOutputStream();
			} catch (IOException e) {
			   e.printStackTrace();
			}
			if(out != null){
				excelUtil.exportExcel("天津市法院案件信息管理系统案件列表导出文档",headers, vos, out,"");
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	      
	    }
	    /**
		 * 设置下载文件文件的名称
		 * 
		 * @param fileName
		 *            :the original file name
		 * @param request
		 *            :request object from the client
		 * @return new File name
		 */
		private String encodeFilename(String fileName, HttpServletRequest request) {
			// String agent = request.getHeader("USER-AGENT");
			String newFileName = "";
			try {
				newFileName = URLEncoder.encode(fileName, "UTF-8");
				newFileName = StringUtils.replace(newFileName, "+", "%20");
				newFileName = StringUtils.replace(newFileName, " ", "%20");
				newFileName = StringUtils.replace(newFileName, "%28", "(");
				newFileName = StringUtils.replace(newFileName, "%29", ")");
			} catch (Exception ex) {
				newFileName = "Default";
			}
			return newFileName;
		}
	    
		public void setRoleMenuService(RoleMenuService roleMenuService) {
			this.roleMenuService = roleMenuService;
		}
		public void setRyjbxxService(RyjbxxService ryjbxxService) {
			this.ryjbxxService = ryjbxxService;
		}
		public void setDmService(DmService dmService) {
			this.dmService = dmService;
		}
		
		
}
