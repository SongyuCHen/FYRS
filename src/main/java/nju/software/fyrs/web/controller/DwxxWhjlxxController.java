package nju.software.fyrs.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.DmCommonVO;
import nju.software.fyrs.biz.vo.JgxxVO;
import nju.software.fyrs.biz.vo.JlwhVO;
import nju.software.fyrs.data.dataobject.Jgxx;
import nju.software.fyrs.data.dataobject.Jlwh;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.JgxxService;
import nju.software.fyrs.service.JlwhService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.util.ConstantsFyrs;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.util.DmCommonList;
import nju.software.fyrs.util.DmMcCommon;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/main/dwxx")
public class DwxxWhjlxxController {
	  private RoleMenuService roleMenuService;
	  private DmService dmService;
	  private JlwhService jlwhService;
	  private JgxxService jgxxService;
	  
	 @RequestMapping(value="/whjlxx.do",method = RequestMethod.GET)
	    public String showWhnsjg(Model model,HttpServletResponse response,HttpServletRequest request)
	    {
	      
	       MenuShowUtils.headerMenu(request,model, roleMenuService,"单位信息");
	       MenuShowUtils.leftMenu(request,model, roleMenuService, "dwxx");
	       // 当调用这个方法时，显然是显示它这个标签，所以
	       model.addAttribute("currentSelectLeftMenu","维护奖励信息");	    
	       return "whjlxx/show";
	    }
	 
	 @RequestMapping(value="/whjlxxDetail.aj",method = RequestMethod.POST)
	    public void whjlxxDetail(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
		  
		 String fydm = request.getParameter("fydm");
		 String bmbh = request.getParameter("bmbh");
		 
		 Map<String,String> mapNames = new HashMap<String,String>();
		 
		 List<Jlwh> jhs = null;
		 if(bmbh.trim().equals("-1"))
		 {
			 jhs = jlwhService.listJlwhByFy(Integer.valueOf(fydm));
		 }
		 else
		 {
			 jhs = jlwhService.listJlwhByFyBm(Integer.valueOf(fydm),Integer.valueOf(bmbh));
		 }
		 List<JlwhVO> vos = new ArrayList<JlwhVO>();
		 for(Jlwh jh : jhs)
		 {
			 JlwhVO vo = new JlwhVO();
			 vo.setNId(jh.getNId()+"");
			 vo.setNFy(jh.getNFy());
			 vo.setNFyMc(DmMcCommon.dmMc(jh.getNFy(),ConstantsFyrs.NBXH_DWMC,mapNames,dmService));
			 vo.setNQyjl(DmMcCommon.dmMc(jh.getNQyjl(),ConstantsFyrs.NBXH_SF,mapNames,dmService));
			 vo.setNJlbm(jh.getNJlbm());
			 if(jh.getNJlbm() > 1000)
			 {
				 if(mapNames.get(jh.getNJlbm()) == null)
				 {
					 Jgxx jgxx = jgxxService.bmByFyIdAndNunicode(jh.getNFy(),jh.getNJlbm());
					 if(jgxx != null)
					 {
						 mapNames.put(jh.getNJlbm().toString(), jgxx.getCName());
						 vo.setNJlbmMc(jgxx.getCName()); 
					 }
					 else
					 {
						 vo.setNJlbmMc(""); 
					 }
					 
				 }
				 else
				 {
					 vo.setNJlbmMc(mapNames.get(jh.getNJlbm().toString())); 
				 }
				 
			 }
			 else
			 {
				 vo.setNJlbmMc(DmMcCommon.dmMc(jh.getNJlbm(),ConstantsFyrs.NBXH_NSJG,mapNames,dmService));
			 }
			 
			 vo.setNJtjllbMc(DmMcCommon.dmMc(jh.getNJtjllb(),ConstantsFyrs.NBXH_JTJLLB,mapNames,dmService));
			 vo.setNJlyyMc(DmMcCommon.dmMc(jh.getNJlyy(),ConstantsFyrs.NBXH_JLYY,mapNames,dmService));
			 vo.setNJljbMc(DmMcCommon.dmMc(jh.getNJljb(),ConstantsFyrs.NBXH_JLJB,mapNames,dmService));
			 vo.setDJlsjMc(DateUtil.format(jh.getDJlsj(), DateUtil.webFormat));
			 vo.setCJlmc(jh.getCJlmc());
			 vos.add(vo);
		 }
	      ResponseBuilder rb = new ResponseBuilder();
	      rb.writeJsonResponse(response,vos);
	    }
	 @RequestMapping(value="/addJlxxPop.aj",method = RequestMethod.POST)
	    public String addJlxxPop(Model model,HttpServletResponse response,HttpServletRequest request)
	    {
		    String btnType = request.getParameter("btnType");
		    String fydm = request.getParameter("fydm");
		    String bmbh = request.getParameter("bmbh");
		    String nid = request.getParameter("nid");
		    /**
		     * 表示添加
		     */
		    if(btnType.trim().equals("0"))
		    {
		    	
		    }
		    /**
		     * 表示修改
		     */
		    if(btnType.trim().equals("2"))
		    {
		    	Jlwh jlwh = jlwhService.getJlwh(Integer.valueOf(fydm), nid);
		    	Integer unicode = jlwh.getNJlbm();
		    	/**
		    	 * 如果当前的奖励信息的部门使用的是 unicode 来记录，特别处理，改成 ncode
		    	 */
		    	if(unicode != null && unicode.toString().length() == 7)
		    	{
		    		Jgxx jgxx_u = jgxxService.bmByFyIdAndNunicode(Integer.valueOf(fydm),unicode);
		    		model.addAttribute("unicode", unicode);
		    		jlwh.setNJlbm(jgxx_u.getNCode());
		    	}
		    	model.addAttribute("jlwh", jlwh);
		    }
		   List<DmCommonVO> shqyjls = DmCommonList.listDmCommonVO(dmService, ConstantsFyrs.NBXH_SF+"");
		   List<DmCommonVO> jtjllbs = DmCommonList.listDmCommonVO(dmService, ConstantsFyrs.NBXH_JTJLLB+"");
		   List<DmCommonVO> jlyys = DmCommonList.listDmCommonVO(dmService, ConstantsFyrs.NBXH_JLYY+"");
		   List<DmCommonVO> jljbs = DmCommonList.listDmCommonVO(dmService, ConstantsFyrs.NBXH_JLJB+"");
		   model.addAttribute("shqyjls", shqyjls);
		   model.addAttribute("jtjllbs", jtjllbs);
		   model.addAttribute("jlyys", jlyys);
		   model.addAttribute("jljbs", jljbs);		   
		   model.addAttribute("btnType",btnType);
		    List<JgxxVO> vos = new ArrayList<JgxxVO>();
		    if(bmbh.trim().equals("0"))
		    {
		    	List<Jgxx> jgxxs = jgxxService.bmByFyId(Integer.valueOf(fydm));
		    	
		    	for(Jgxx jgxx : jgxxs)
		    	{
		    		JgxxVO jgxxVo = new JgxxVO();
		    	    commonBeanToVo(jgxx, jgxxVo);
		    		vos.add(jgxxVo);
		    	}
		    	
		    }
		    else
		    {
		    	Jgxx jgxx = jgxxService.bmByFyIdAndNcode(Integer.valueOf(fydm),Integer.valueOf(bmbh));
		    	if(jgxx == null)
		    	{
		    		jgxx = jgxxService.bmByFyIdAndNunicode(Integer.valueOf(fydm),Integer.valueOf(bmbh));
		    	}
		    	JgxxVO jgxxVo = new JgxxVO();
	    	    commonBeanToVo(jgxx, jgxxVo);
	    	    vos.add(jgxxVo);
		    }
		   model.addAttribute("jgxxs",vos);	    	
	       return "dwxx/pop/whnsjgJlPop";
	    }
	 @RequestMapping(value="/saveJlxx.aj",method = RequestMethod.POST)
	    public void saveJlxx(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
		  // TempUtils.requestParameter(request);
		 String jlbz = request.getParameter("jlbz");
		 String pzdw = request.getParameter("pzdw");
		 String fydm = request.getParameter("fydm");
		 String jlyy = request.getParameter("jlyy");
		 String jlbm = request.getParameter("jlbm");
		 String pzwh = request.getParameter("pzwh");
		 String jlsj = request.getParameter("jlsj");
		 String qyjl = request.getParameter("qyjl");
		 String jtjllb = request.getParameter("jtjllb");
		 String jljb = request.getParameter("jljb");
		 String jlmc = request.getParameter("jlmc");
		 String nid = request.getParameter("nid");
		 String btnType = request.getParameter("btnType");
		 ResponseBuilder rb = new ResponseBuilder();
		 Jlwh jlwh = null;
		 if(btnType.trim().equals("0"))
		 {
			jlwh = new Jlwh();
			jlwh.setNFy(Integer.valueOf(fydm));
		 }	
		 if(btnType.trim().equals("2"))
		 {
			 jlwh = jlwhService.getJlwh(Integer.valueOf(fydm), nid);
		 }
		 // 1 表示非全院奖励，那么有一个部门属性
		 if(!qyjl.trim().equals("1"))
		 {			 
			 jlwh.setNJlbm(Integer.valueOf(jlbm));			 
		 }
		 // 如果全院奖励就给部门一个 0
		 else
		 {
			 jlwh.setNJlbm(0);		
		 }
		 jlwh.setCBz(jlbz);
		 jlwh.setCJlmc(jlmc);
		 jlwh.setCPzdw(pzdw);
		 jlwh.setCPzwh(pzwh);
		 jlwh.setDJlsj(DateUtil.parse(jlsj,DateUtil.webFormat));		 
		 jlwh.setNJtjllb(Integer.valueOf(jtjllb));	
		 jlwh.setNJlyy(Integer.valueOf(jlyy));							
		 jlwh.setNJljb(Integer.valueOf(jljb));		 
		 jlwh.setNQyjl(Integer.valueOf(qyjl));	
		
		 if(btnType.trim().equals("0"))
		 {
			 Jlwh re = jlwhService.addJlwh(jlwh);
			 rb.writeJsonResponse(response,"success-"+re.getNId());
		 }
		 if(btnType.trim().equals("2"))
		 {
			jlwhService.updateJlwh(jlwh);
			rb.writeJsonResponse(response,"success");
		 }		 	     
	     rb.writeJsonResponse(response,"-1");
	    }
	    @RequestMapping(value="/deleteJlxx.aj",method = RequestMethod.POST)
	    public void deleteJlxx(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
		 // TempUtils.requestParameter(request);
	    	String fydm = request.getParameter("fydm");
	    	String nid = request.getParameter("nid");
	    	jlwhService.deleteJlwh(Integer.valueOf(fydm), nid);
		 ResponseBuilder rb = new ResponseBuilder();		 
	     rb.writeJsonResponse(response,"success");
	    }
	 
	 
	private void commonBeanToVo(Jgxx jgxx,JgxxVO jgxxVo)
	{
		jgxxVo.setNCode(jgxx.getNCode());
		jgxxVo.setCName(jgxx.getCName());
	}
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}

	public void setJlwhService(JlwhService jlwhService) {
		this.jlwhService = jlwhService;
	}

	public void setJgxxService(JgxxService jgxxService) {
		this.jgxxService = jgxxService;
	}
    
	
}
