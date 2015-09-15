package nju.software.fyrs.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.DwxxVO;
import nju.software.fyrs.data.dataobject.Dwxx;
import nju.software.fyrs.service.DwxxService;
import nju.software.fyrs.service.JgxxService;
import nju.software.fyrs.service.RyjbxxService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.util.RolesUtil;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/main/dwxx")
public class DwxxWhdwxxController {
	  private RoleMenuService roleMenuService;
	  private RyjbxxService ryjbxxService;
	  private DwxxService dwxxService;
	  private JgxxService jgxxService;
	 @RequestMapping(value="/whdwxx.do",method = RequestMethod.GET)
	    public String showZzkDefault(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
	         
	       MenuShowUtils.headerMenu(request,model, roleMenuService,"单位信息");
	       MenuShowUtils.leftMenu(request,model, roleMenuService, "dwxx");
	       // 当调用这个方法时，显然是显示它这个标签，所以
	       model.addAttribute("currentSelectLeftMenu","维护单位信息");
	       int fydm = RolesUtil.getUserContext(request).getFydm();
	       DwxxVO dwxxVo = new DwxxVO();
	       showDwxxCommon(dwxxVo,fydm);
	       model.addAttribute("dwxx",dwxxVo);
	       return "whdwxx/show";
	    }
	 
	 @RequestMapping(value="/whdwxxPop.aj",method = RequestMethod.POST)
	    public String whdwxxPop(Model model,HttpServletResponse response,HttpServletRequest request)
	    {		 
	       String fydm = request.getParameter("fydm");
	       DwxxVO dwxxVo = new DwxxVO();
	       showDwxxCommon(dwxxVo,Integer.valueOf(fydm));
	       model.addAttribute("dwxx",dwxxVo);
	       return "dwxx/pop/whdwxxPop";
	    }
	 @RequestMapping(value="/updateDwxx.aj",method = RequestMethod.POST)
	    public void updatedwxx(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
		  Dwxx dwxx = new Dwxx();
		  dwxx.setNFy(Integer.valueOf(request.getParameter("NFy")));		  
		  dwxx.setCYzbm(request.getParameter("CYzbm"));
		  dwxx.setCDwdz(request.getParameter("CDwdz"));
		  dwxx.setCLldh(request.getParameter("CLldh"));
		  dwxx.setCDwczh(request.getParameter("CDwczh"));
		  dwxx.setCRsfzr(request.getParameter("CRsfzr"));
		  String time = request.getParameter("DCjsj");
		  if(!time.trim().equals(""))
		  {
			  dwxx.setDCjsj(DateUtil.parse(time, DateUtil.webFormat2));
		  }
		  dwxx.setNZyxzbzs(Short.valueOf(request.getParameter("NZyxzbzs")));
		  dwxx.setNZysybzs(Short.valueOf(request.getParameter("NZysybzs")));
		  dwxx.setNDfxzbzs(Short.valueOf(request.getParameter("NDfxzbzs")));
		  dwxx.setNXzfsbzs(Short.valueOf(request.getParameter("NXzfsbzs")));
		  dwxx.setNDfqesybzs(Short.valueOf(request.getParameter("NDfqesybzs")));
		  dwxx.setNDfcesybzs(Short.valueOf(request.getParameter("NDfcesybzs")));
		  dwxx.setNDfzczzsybzs(Short.valueOf(request.getParameter("NDfzczzsybzs")));
		  dwxx.setNQybzs(Short.valueOf(request.getParameter("NQybzs")));
		  dwxx.setCBgqk(request.getParameter("CBgqk"));
		  dwxx.setNFkdq(Integer.valueOf(request.getParameter("NFkdq")));
		  dwxxService.updateDwxxByFy(dwxx);
	      ResponseBuilder rb = new ResponseBuilder();
	      rb.writeJsonResponse(response, "1");
	    }
	private void showDwxxCommon(DwxxVO dwxxVo,int fydm)
	{
		   Dwxx dwxx = dwxxService.findDwxxByFy(fydm);
	       org.springframework.beans.BeanUtils.copyProperties(dwxx, dwxxVo);
//		   dwxxVo.setNFy(dwxx.getNFy());
//		   dwxxVo.setCYzbm(dwxx.getCYzbm());
//		   dwxxVo.setCDwdz(dwxx.getCDwdz());
//		   dwxxVo.setCLldh(dwxx.getCLldh());
//		   dwxxVo.setCDwczh(dwxx.getCDwczh());
//		   dwxxVo.setCRsfzr(dwxx.getCRsfzr());
//		   dwxxVo.setDCjsj(dwxx.getDCjsj());
	       int[] bzs = ryjbxxService.findBzCount(fydm);
	       // 注意数组顺序不能乱
	       dwxxVo.setNZyxzbzsCount((short) bzs[0]);
	       dwxxVo.setNZysybzsCount((short) bzs[1]);
	       dwxxVo.setNDfxzbzsCount((short) bzs[2]);
	       dwxxVo.setNXzfsbzsCount((short) bzs[5]);
	       dwxxVo.setNDfqesybzsCount((short) bzs[3]);
	       dwxxVo.setNDfcesybzsCount((short) bzs[4]);
	       dwxxVo.setNDfzczzsybzsCount((short) bzs[7]);
	       dwxxVo.setNQybzsCount((short) bzs[6]);
	       //  这个是计算整个部门数
	       dwxxVo.setNNsjgzsCount((short) jgxxService.countJg(fydm));
	       // 这个还不知道怎么计算,其它人员实有人数
	       dwxxVo.setNQtyrsyrsCount((short) 0);
	       
	       
	}
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}
	public void setDwxxService(DwxxService dwxxService) {
		this.dwxxService = dwxxService;
	}

	public void setRyjbxxService(RyjbxxService ryjbxxService) {
		this.ryjbxxService = ryjbxxService;
	}

	public void setJgxxService(JgxxService jgxxService) {
		this.jgxxService = jgxxService;
	}
	
	
	
}
