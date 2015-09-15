package nju.software.fyrs.web.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.BzbhVO;
import nju.software.fyrs.biz.vo.BzjgVO;
import nju.software.fyrs.biz.vo.HdbzWjVO;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.HdbzService;
import nju.software.fyrs.service.RyjbxxService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.model.UserContext;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/main/cxtj")
public class CxtjBzglController {
	private RoleMenuService roleMenuService;
	private DmService dmService;
	private RyjbxxService ryjbxxService;
	private HdbzService hdbzService;

	@RequestMapping(value = "/bzgl.do", method = RequestMethod.GET)
	public String showHbkDefault(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		MenuShowUtils.headerMenu(request, model, roleMenuService, "查询统计");
		MenuShowUtils.leftMenu(request, model, roleMenuService, "cxtj");
		model.addAttribute("currentSelectLeftMenu", "编制管理");
		return "bzgl/show";
	}
	
	@RequestMapping(value="/bzbh.do",method = RequestMethod.GET)
	public String bzbh(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		List<BzbhVO> zy_zfzx=null, zy_sy=null, sheng_zfzx=null, sheng_syqe=null, sheng_syce=null, 
				sheng_syzczz=null, sheng_fs=null, shi_zfzx=null, shi_syqe=null, shi_syce=null, 
				shi_syzczz=null, shi_fs=null;
		int sum=0;
		String fy=null;
		if(user!=null){
			int fydm = user.getFydm();
			fy= dmService.findFymc(fydm);
			zy_zfzx=hdbzService.getBzbhList(fydm, "ZyZfzxbz");
			zy_sy=hdbzService.getBzbhList(fydm, "ZySy");
			sheng_zfzx=hdbzService.getBzbhList(fydm, "ShengZfzxbz");
			sheng_syqe=hdbzService.getBzbhList(fydm, "ShengQe");
			sheng_syce=hdbzService.getBzbhList(fydm, "ShengCe");
			sheng_syzczz=hdbzService.getBzbhList(fydm, "ShengZczz");
			sheng_fs=hdbzService.getBzbhList(fydm, "ShengFs");
			shi_zfzx=hdbzService.getBzbhList(fydm, "ShiZfzxbz");
			shi_syqe=hdbzService.getBzbhList(fydm, "ShiQe");
			shi_syce=hdbzService.getBzbhList(fydm, "ShiCe");
			shi_syzczz=hdbzService.getBzbhList(fydm, "ShiZczz");
			shi_fs=hdbzService.getBzbhList(fydm, "ShiFs");
			if(zy_zfzx.size()>0)sum+=zy_zfzx.get(zy_zfzx.size()-1).getNKbs();
			if(zy_sy.size()>0)sum+=zy_sy.get(zy_sy.size()-1).getNKbs();
			if(sheng_zfzx.size()>0)sum+=sheng_zfzx.get(sheng_zfzx.size()-1).getNKbs();
			if(sheng_syqe.size()>0)sum+=sheng_syqe.get(sheng_syqe.size()-1).getNKbs();
			if(sheng_syce.size()>0)sum+=sheng_syce.get(sheng_syce.size()-1).getNKbs();
			if(sheng_syzczz.size()>0)sum+=sheng_syzczz.get(sheng_syzczz.size()-1).getNKbs();
			if(sheng_fs.size()>0)sum+=sheng_fs.get(sheng_fs.size()-1).getNKbs();
			if(shi_zfzx.size()>0)sum+=shi_zfzx.get(shi_zfzx.size()-1).getNKbs();
			if(shi_syqe.size()>0)sum+=shi_syqe.get(shi_syqe.size()-1).getNKbs();
			if(shi_syce.size()>0)sum+=shi_syce.get(shi_syce.size()-1).getNKbs();
			if(shi_syzczz.size()>0)sum+=shi_syzczz.get(shi_syzczz.size()-1).getNKbs();
			if(shi_fs.size()>0)sum+=shi_fs.get(shi_fs.size()-1).getNKbs();
		}
		model.addAttribute("zy_zfzx", zy_zfzx);
		model.addAttribute("zy_sy", zy_sy);
		model.addAttribute("sheng_zfzx", sheng_zfzx);
		model.addAttribute("sheng_syqe", sheng_syqe);
		model.addAttribute("sheng_syce", sheng_syce);
		model.addAttribute("sheng_syzczz", sheng_syzczz);
		model.addAttribute("sheng_fs", sheng_fs);
		model.addAttribute("shi_zfzx", shi_zfzx);
		model.addAttribute("shi_syqe", shi_syqe);
		model.addAttribute("shi_syce", shi_syce);
		model.addAttribute("shi_syzczz", shi_syzczz);
		model.addAttribute("shi_fs", shi_fs);
		model.addAttribute("sum", sum);
		model.addAttribute("fy", fy);
		return "bzgl/bzbhdjb";
	}
	
	@RequestMapping(value="/saveHdbzBg.aj",method = RequestMethod.POST)
	public void saveHdbzBg(@RequestParam("file") MultipartFile file,Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		boolean success=false;
		try{
			if(user!=null){
				int fydm = user.getFydm();
				String pzwh=request.getParameter("pzwh");
				
				String hdrq=request.getParameter("hdrq");
				
				String temp=request.getParameter("zy_zfzxbz_bmld_zz");
				Integer zy_zfzxbz_bmld_zz=temp.equals("")?null:Integer.parseInt(temp);
				
				temp=request.getParameter("zy_zfzxbz_bmld_fz");
				Integer zy_zfzxbz_bmld_fz=temp.equals("")?null:Integer.parseInt(temp);
				
				temp=request.getParameter("zy_zfzxbz_bmld_qt");
				Integer zy_zfzxbz_bmld_qt=temp.equals("")?null:Integer.parseInt(temp);
				
				String zy_zfzxbz_bmld_qt_mx=request.getParameter("zy_zfzxbz_bmld_qt_mx");
				
				temp=request.getParameter("zy_zfzxbz_nsjgld_zz_fc");
				Integer zy_zfzxbz_nsjgld_zz_fc=temp.equals("")?null:Integer.parseInt(temp);
				
				temp=request.getParameter("zy_zfzxbz_nsjgld_zz_zk");
				Integer zy_zfzxbz_nsjgld_zz_zk=temp.equals("")?null:Integer.parseInt(temp);
				
				temp=request.getParameter("zy_zfzxbz_nsjgld_fz_zk");
				Integer zy_zfzxbz_nsjgld_fz_zk=temp.equals("")?null:Integer.parseInt(temp);
				
				temp=request.getParameter("zy_zfzxbz_nsjgld_fz_fk");
				Integer zy_zfzxbz_nsjgld_fz_fk=temp.equals("")?null:Integer.parseInt(temp);
				
				temp=request.getParameter("zy_zfzxbz_nsjgld_qt");
				Integer zy_zfzxbz_nsjgld_qt=temp.equals("")?null:Integer.parseInt(temp);
				
				String zy_zfzxbz_nsjgld_qt_mx=request.getParameter("zy_zfzxbz_nsjgld_qt_mx");
				
				temp=request.getParameter("zy_zfzxbz_dyy");
				Integer zy_zfzxbz_dyy=temp.equals("")?null:Integer.parseInt(temp);
				
				temp=request.getParameter("zy_zfzxbz_fdyy");
				Integer zy_zfzxbz_fdyy=temp.equals("")?null:Integer.parseInt(temp);
				
				temp=request.getParameter("zy_zfzxbz_zrky");
				Integer zy_zfzxbz_zrky=temp.equals("")?null:Integer.parseInt(temp);
				
				temp=request.getParameter("zy_zfzxbz_fzrky");
				Integer zy_zfzxbz_fzrky=temp.equals("")?null:Integer.parseInt(temp);
				
				temp=request.getParameter("zy_zfzxbz_kybsy");
				Integer zy_zfzxbz_kybsy=temp.equals("")?null:Integer.parseInt(temp);
				
				String zy_zfzxbz_bhyy=request.getParameter("zy_zfzxbz_bhyy");
				
				String zy_zfzxbz_bz=request.getParameter("zy_zfzxbz_bz");
				
				temp=request.getParameter("zy_sy_kbs");
				Integer zy_sy_kbs=temp.equals("")?null:Integer.parseInt(temp);
				
				String zy_sy_bhyy=request.getParameter("zy_sy_bhyy");
				
				String zy_sy_bz=request.getParameter("zy_sy_bz");
				
				temp=request.getParameter("sheng_zfzxbz_kbs");
				Integer sheng_zfzxbz_kbs=temp.equals("")?null:Integer.parseInt(temp);
				
				String sheng_zfzxbz_bhyy=request.getParameter("sheng_zfzxbz_bhyy");
				
				String sheng_zfzxbz_bz=request.getParameter("sheng_zfzxbz_bz");
				
				temp=request.getParameter("sheng_qe_kbs");
				Integer sheng_qe_kbs=temp.equals("")?null:Integer.parseInt(temp);
				
				String sheng_qe_bhyy=request.getParameter("sheng_qe_bhyy");
				
				String sheng_qe_bz=request.getParameter("sheng_qe_bz");
				
				temp=request.getParameter("sheng_ce_kbs");
				Integer sheng_ce_kbs=temp.equals("")?null:Integer.parseInt(temp);
				
				String sheng_ce_bhyy=request.getParameter("sheng_ce_bhyy");
				
				String sheng_ce_bz=request.getParameter("sheng_ce_bz");
				
				temp=request.getParameter("sheng_zczz_kbs");
				Integer sheng_zczz_kbs=temp.equals("")?null:Integer.parseInt(temp);
				
				String sheng_zczz_bhyy=request.getParameter("sheng_zczz_bhyy");
				
				String sheng_zczz_bz=request.getParameter("sheng_zczz_bz");
				
				temp=request.getParameter("sheng_fs_kbs");
				Integer sheng_fs_kbs=temp.equals("")?null:Integer.parseInt(temp);
				
				String sheng_fs_bhyy=request.getParameter("sheng_fs_bhyy");
				
				String sheng_fs_bz=request.getParameter("sheng_fs_bz");
				
				temp=request.getParameter("shi_zfzxbz_kbs");
				Integer shi_zfzxbz_kbs=temp.equals("")?null:Integer.parseInt(temp);
				
				String shi_zfzxbz_bhyy=request.getParameter("shi_zfzxbz_bhyy");
				
				String shi_zfzxbz_bz=request.getParameter("shi_zfzxbz_bz");
				
				temp=request.getParameter("shi_qe_kbs");
				Integer shi_qe_kbs=temp.equals("")?null:Integer.parseInt(temp);
				
				String shi_qe_bhyy=request.getParameter("shi_qe_bhyy");
				
				String shi_qe_bz=request.getParameter("shi_qe_bz");
				
				temp=request.getParameter("shi_ce_kbs");
				Integer shi_ce_kbs=temp.equals("")?null:Integer.parseInt(temp);
				
				String shi_ce_bhyy=request.getParameter("shi_ce_bhyy");
				
				String shi_ce_bz=request.getParameter("shi_ce_bz");
				
				temp=request.getParameter("shi_zczz_kbs");
				Integer shi_zczz_kbs=temp.equals("")?null:Integer.parseInt(temp);
				
				String shi_zczz_bhyy=request.getParameter("shi_zczz_bhyy");
				
				String shi_zczz_bz=request.getParameter("shi_zczz_bz");
				
				temp=request.getParameter("shi_fs_kbs");
				Integer shi_fs_kbs=temp.equals("")?null:Integer.parseInt(temp);
				
				String shi_fs_bhyy=request.getParameter("shi_fs_bhyy");
				
				String shi_fs_bz=request.getParameter("shi_fs_bz");
				
				byte[]wj=null;
				String wjm=null;
				if(!file.isEmpty()){
					wj=file.getBytes();
					wjm=file.getOriginalFilename();
				}
				
				success = hdbzService.save(fydm, pzwh, hdrq, 
						zy_zfzxbz_bmld_zz, zy_zfzxbz_bmld_fz, zy_zfzxbz_bmld_qt, zy_zfzxbz_bmld_qt_mx, zy_zfzxbz_nsjgld_zz_fc, 
						zy_zfzxbz_nsjgld_zz_zk, zy_zfzxbz_nsjgld_fz_zk, zy_zfzxbz_nsjgld_fz_fk, zy_zfzxbz_nsjgld_qt, 
						zy_zfzxbz_nsjgld_qt_mx, zy_zfzxbz_dyy, zy_zfzxbz_fdyy, zy_zfzxbz_zrky, zy_zfzxbz_fzrky, 
						zy_zfzxbz_kybsy, zy_zfzxbz_bhyy, zy_zfzxbz_bz, 
						zy_sy_kbs, zy_sy_bhyy, zy_sy_bz, 
						sheng_zfzxbz_kbs, sheng_zfzxbz_bhyy, sheng_zfzxbz_bz, 
						sheng_qe_kbs, sheng_qe_bhyy, sheng_qe_bz, 
						sheng_ce_kbs, sheng_ce_bhyy, sheng_ce_bz, 
						sheng_zczz_kbs, sheng_zczz_bhyy, sheng_zczz_bz,
						sheng_fs_kbs, sheng_fs_bhyy, sheng_fs_bz,
						shi_zfzxbz_kbs, shi_zfzxbz_bhyy, shi_zfzxbz_bz,
						shi_qe_kbs, shi_qe_bhyy, shi_qe_bz, 
						shi_ce_kbs, shi_ce_bhyy, shi_ce_bz, 
						shi_zczz_kbs, shi_zczz_bhyy, shi_zczz_bz, 
						shi_fs_kbs, shi_fs_bhyy, shi_fs_bz, wj, wjm);
			}
		}catch(Exception e){
			e.printStackTrace();
			success=false;
		}
		
		ResponseBuilder rb = new ResponseBuilder();
		try {
			rb.writeJsonResponse(response, success);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/downloadWj.aj",method = RequestMethod.GET)
	public void downloadWj(Model model,HttpServletResponse response,HttpServletRequest request){
		String id = request.getParameter("id");
		HdbzWjVO vo=hdbzService.getWjbyId(Integer.parseInt(id));
		if(vo.getImWj()!=null){
			BufferedOutputStream bos=null;
			String filename="核定文件";
			if(vo.getCWjm()!=null&&!vo.getCWjm().equals(""))filename=vo.getCWjm();
			else if(vo.getCPzwh()!=null&&!vo.getCPzwh().equals(""))filename=vo.getCPzwh();
			try {
				filename=new String(filename.getBytes("utf-8"),"iso-8859-1");//文件名转码，不转中文无法显示
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			response.setHeader("Content-Disposition","attachment;filename="+filename);
			try {
				bos = new BufferedOutputStream(response.getOutputStream());
				bos.write(vo.getImWj());//将byte[]数据写入缓存
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				if(bos!=null){
					try {
						bos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
	}
	
	@RequestMapping(value="/bzsq.do",method = RequestMethod.GET)
	public String bzsq(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		String fy=null;
		long[]syry={0,0,0,0,0,0,0,0,0};
		if(user!=null){
			int fydm = user.getFydm();
			fy = dmService.findFymc(fydm);
			syry[0]=ryjbxxService.countByXzzw(fydm, "1");
			syry[1]=ryjbxxService.countByXzzw(fydm, "2");
			syry[2]=ryjbxxService.countByXzzw(fydm, "0");
			syry[3]=ryjbxxService.countByXzzw(fydm, "0");
			syry[4]=ryjbxxService.countByXzzw(fydm, "0");
			syry[5]=ryjbxxService.countByXzzw(fydm, "0");
			syry[6]=ryjbxxService.countByXzzw(fydm, "0");
			syry[7]=ryjbxxService.countByXzzw(fydm, "0");
			syry[8]=ryjbxxService.countByXzzw(fydm, "0");
		}
		model.addAttribute("fy", fy);
		model.addAttribute("syry", syry);
		return "bzgl/bzsq";
	}
	
	@RequestMapping(value="/bzjg.do",method = RequestMethod.GET)
	public String bzjg(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		List<BzjgVO>vos=new ArrayList<BzjgVO>();;
		if(user!=null){
			int fydm = user.getFydm();
			vos = hdbzService.getBzjgList(fydm);
		}
		model.addAttribute("bzjg",vos);
		return "bzgl/bzjg";
	}
	
	@RequestMapping(value="/bzbgjl1.do",method = RequestMethod.GET)
	public String bzbgjl1(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		return "bzgl/bzbgjl1";
	}
	
	@RequestMapping(value="/bzbgjl2.do",method = RequestMethod.GET)
	public String bzbgjl2(Model model,HttpServletResponse response,HttpServletRequest request){
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		return "bzgl/bzbgjl2";
	}
	
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}

	public void setRyjbxxService(RyjbxxService ryjbxxService) {
		this.ryjbxxService = ryjbxxService;
	}

	public void setHdbzService(HdbzService hdbzService) {
		this.hdbzService = hdbzService;
	}
}
