package nju.software.fyrs.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.DmCommonVO;
import nju.software.fyrs.biz.vo.DwxxWhnsjgVO;
import nju.software.fyrs.data.dataobject.Jgxx;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.JgxxService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.util.ConstantsFyrs;
import nju.software.fyrs.util.DmCommonList;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/main/dwxx")
public class DwxxWhnsjgController {
	  private RoleMenuService roleMenuService;
	  private JgxxService jgxxService; 
	  private DmService dmService;
	  
	 @RequestMapping(value="/whnsjg.do",method = RequestMethod.GET)
	    public String showWhnsjg(Model model,HttpServletResponse response,HttpServletRequest request)
	    {
	      
	       MenuShowUtils.headerMenu(request,model, roleMenuService,"��λ��Ϣ");
	       MenuShowUtils.leftMenu(request,model, roleMenuService, "dwxx");
	       // �������������ʱ����Ȼ����ʾ�������ǩ������
	       model.addAttribute("currentSelectLeftMenu","ά���������");
	       return "whnsjg/show";
	    }
	 @RequestMapping(value="/whnsjgDetail.aj",method = RequestMethod.POST)
	    public void whnsjgDetail(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
		  String fydm = request.getParameter("fydm");
		  String bmbh = request.getParameter("bmbh");
		  List<Jgxx> jgxxs = null;
		  if(!bmbh.trim().equals(""))
		  {
			  jgxxs = new ArrayList<Jgxx>();
			  jgxxs.add(jgxxService.bmByFyIdAndNcode(Integer.valueOf(fydm),Integer.valueOf(bmbh)));
		  }
		  else
		  {
			  jgxxs = jgxxService.bmByFyIdXssx(Integer.valueOf(fydm));
		  }
	      String fyMc = dmService.findFymc(Integer.valueOf(fydm));
	      List<DwxxWhnsjgVO> vos = new ArrayList<DwxxWhnsjgVO>();
	      for(Jgxx jg : jgxxs)
	      {
	    	  DwxxWhnsjgVO vo = new DwxxWhnsjgVO();
	    	  vo.setFydm(Integer.valueOf(fydm));
	    	  vo.setNFy(fyMc);
	    	  vo.setNCode(jg.getNCode());
	    	  if(jg.getCStname() == null)
	    	  {
	    		  vo.setCStname("");
	    	  }
	    	  else
	    	  {
	    		  vo.setCStname(jg.getCStname());
	    	  }	    	 
	    	  vo.setCName(jg.getCName());
	    	  vo.setNLevel(jg.getNLevel());
	    	  vo.setNZgldzw("");
	    	  // ����ְ�������� 15 �����Ը���������ñ�����������
	    	  if(null != jg.getNZgldzw())
	    	  {
	    		  vo.setNZgldzw(dmService.findDmByNBxhNdm(ConstantsFyrs.NBXH_XZZW+"", jg.getNZgldzw()).getCMc());
	    	  }
	    	  vo.setNBmxz("");
	    	  if(null !=jg.getNBmxz()){
	    		  vo.setNBmxz(dmService.findDmByNBxhNdm(ConstantsFyrs.BMXZ+"", jg.getNBmxz()).getCMc());
	    	  }
	    	  
	    	  vos.add(vo);
	    	  // �������쵼ְ��
	      }
	      ResponseBuilder rb = new ResponseBuilder();
	      rb.writeJsonResponse(response,vos);
	    }
	 @RequestMapping(value="/whnsjgBmPop.aj",method = RequestMethod.POST)
	    public String  whnsjgBmPop(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
		
		 String fydm = request.getParameter("fydm");
		 String bmbh = request.getParameter("bmbh");
		 String lvlevel = request.getParameter("lvlevel");
		 String btnType = request.getParameter("btnType");
		 String nlevel = request.getParameter("nlevel");
		 String isOnlyBm = request.getParameter("isOnlyBm");
		 
         // ��ʾ�޸�
		 if(btnType.equals("2"))
		 {
			 Jgxx jgxx = jgxxService.bmByFyIdAndNcode(Integer.valueOf(fydm),Integer.valueOf(bmbh));
			 model.addAttribute("jgxx",jgxx);
			 nlevel = jgxx.getNLevel()+"";
		 }
		 model.addAttribute("fydm",fydm);
		 model.addAttribute("bmbh",bmbh);
		 model.addAttribute("lvlevel",lvlevel);
		 model.addAttribute("btnType",btnType);
		 model.addAttribute("nlevel",nlevel);
		 model.addAttribute("isOnlyBm",isOnlyBm);
		 
		 List<DmCommonVO> zgldzw = DmCommonList.listDmCommonVOHidden(dmService, ConstantsFyrs.NBXH_ZGLDZW+"");
		 model.addAttribute("zgldzws", zgldzw);
		 List<DmCommonVO> bmbn = DmCommonList.listDmCommonVOHidden(dmService,ConstantsFyrs.NBXH_BMJC_NSJG+"");
		 model.addAttribute("bmbns", bmbn);
		 List<DmCommonVO> bmxz = DmCommonList.listDmCommonVO(dmService,ConstantsFyrs.BMXZ+"");
		 model.addAttribute("bmxz",bmxz);
		  return "/dwxx/pop/whnsjgBmPop";
	    }
	 
	 @RequestMapping(value="/whnsjgBmSave.aj",method = RequestMethod.POST)
	    public void whnsjgBmSave(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
		 String bzmcDm = request.getParameter("bzmcDm");
		 String fydm = request.getParameter("fydm");
		 String bmbh = request.getParameter("bmbh");
		 String lvlevel = request.getParameter("lvlevel");
		 String bzmc = request.getParameter("bzmc");
		 String zgldzw = request.getParameter("zgldzw");
		 String bmxz = request.getParameter("bmxz");
		 String bmmc = request.getParameter("bmmc");
		 String btnType = request.getParameter("btnType");
		 String isOnlyBm = request.getParameter("isOnlyBm");
		 ResponseBuilder rb = new ResponseBuilder();
		 boolean isExist = false;
		 		
		 Jgxx jgxx = null;
		 //TempUtils.requestParameter(request);
		 // ��ʾ���,���֮ǰ�ж��Ƿ�����������
         if(btnType.trim().equals("0"))
         {
        	 // ��ʾ�ڷ�Ժ������Ӳ��ţ����Ի������׼����
    		 if(isOnlyBm.equals("0"))
    		 {
    			 // ��ʾ�ñ�׼�����Ѿ�����
    			 isExist = jgxxService.isExistBzbm(Integer.valueOf(fydm),Integer.valueOf(bzmcDm));
    			 if(isExist)
    			 {
    				 // ��׼���ƴ���
    				 rb.writeJsonResponse(response, "3");
    				 return;
    			 }
    			 isExist = jgxxService.isExistBm(Integer.valueOf(fydm), lvlevel, bmmc,1,Integer.valueOf(bmxz));
    			 if(isExist)
    			 {
    				 // �������ƴ���
    				 rb.writeJsonResponse(response, "4");
    				 return;
    			 }
    		 }
    		 // ֻ�����һ����������
    		 else
    		 {
    			 int level = -1;
    			 if(lvlevel.trim().substring(4).equals("00000000"))
    			 {
    				 level = 2;
    			 }
    			 if(!lvlevel.trim().substring(4).equals("00000000") && lvlevel.trim().substring(4).equals("0000"))
    			 {
    				 level = 3;
    			 }
    			 isExist = jgxxService.isExistBm(Integer.valueOf(fydm), lvlevel, bmmc,level,Integer.valueOf(bmxz));
    			 if(isExist)
    			 {
    				 // �������ƴ���
    				 rb.writeJsonResponse(response, "4");
    				 return;
    			 }
    		 }
        	 jgxx =  new Jgxx();
        	 // �ڷ�Ժ�����һ������
        	if(isOnlyBm.equals("0"))
        	{
        		jgxx.setNFy(Integer.valueOf(fydm));
        		jgxx.setNCode(Integer.valueOf(bzmcDm));
        		jgxx.setNLevel((short)1);
        		jgxx.setCName(bmmc);
        		jgxx.setCStname(bzmc);
        		jgxx.setCLvlcode((DmCommonList.addNum[bzmcDm.trim().length()])+bzmcDm.trim()+"00000000");        		
        		jgxx.setNZgldzw(Integer.valueOf(zgldzw));
        		jgxx.setNBmxz(Integer.valueOf(bmxz));
        		// ��ʾ������ŵ�����
        		jgxx.setNRysl(0);
        		jgxx.setNYx(1);
        		Jgxx re = jgxxService.addJgxxBzbm(jgxx);
        		rb.writeJsonResponse(response, "success"+"-"+re.getNCode()+"-"+re.getCLvlcode());
        	}
        	// �ڵ�ǰ�������һ���Ӳ���
        	else
        	{
        		jgxx.setNFy(Integer.valueOf(fydm));
        		jgxx.setCName(bmmc);
        		// ˵���Ƕ����ڵ�
        		if(lvlevel.substring(4,8).equals("0000"))
        		{
        			jgxx.setNLevel((short)2);
        		}
        		// ˵�������һ���ڵ�
        		else
        		{
        			jgxx.setNLevel((short)3);
        		}
        		jgxx.setCLvlcode(lvlevel);
        		Jgxx re = jgxxService.addJgxxOnlyBm(jgxx);
        		rb.writeJsonResponse(response, "success"+"-"+re.getNCode()+"-"+re.getCLvlcode());
        	}
         }
         // ��ʾ�޸�
		 if(btnType.trim().equals("2")) 
		 {
			Jgxx jgxxUpdate = jgxxService.bmByFyIdAndNcode(Integer.valueOf(fydm),Integer.valueOf(bmbh)); 
			
			// ֻ�Ǹ��²�������
			if(isOnlyBm.equals("1"))
			{
				if(jgxxUpdate.getNLevel() == 2)
				{
					lvlevel = lvlevel.substring(0,4)+"00000000";
				}
				if(jgxxUpdate.getNLevel() == 3)
				{
					lvlevel = lvlevel.substring(0,8)+"0000";
				}
				isExist = jgxxService.isExistBm(Integer.valueOf(fydm), lvlevel, bmmc,jgxxUpdate.getNLevel(),Integer.valueOf(bmxz));
	   			 if(isExist)
	   			  {
	   				 // �������ƴ���
	   				 rb.writeJsonResponse(response, "4");
	   				 return;
	   			  }
				jgxxUpdate.setCName(bmmc);
			}
			// ��ʾ���·�Ժ���沿�ŵ�����
			else
			{
			 isExist = jgxxService.isExistBm(Integer.valueOf(fydm), lvlevel, bmmc,1,Integer.valueOf(bmxz));
   			  if(isExist)
   			  {
   				 // �������ƴ���
   				 rb.writeJsonResponse(response, "4");
   				 return;
   			   }
				jgxxUpdate.setCName(bmmc);
				jgxxUpdate.setCStname(bzmc);
				jgxxUpdate.setNZgldzw(Integer.valueOf(zgldzw));
				jgxxUpdate.setNBmxz(Integer.valueOf(bmxz));
			}
			jgxxService.updateJgxx(jgxxUpdate);
		 }		  
		  rb.writeJsonResponse(response, "success");
	    }
	 
	 
	 @RequestMapping(value="/whnsjgDeleteBm.aj",method = RequestMethod.POST)
	    public void  whnsjgDeleteBm(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
		 String fydm = request.getParameter("fydm");
		 String bmbh = request.getParameter("bmbh");
		 String result = "1";
		 boolean canDelete =  jgxxService.deleteByFyIdAndNcode(Integer.valueOf(fydm),Integer.valueOf(bmbh));
		 if(!canDelete)
		 {
			 result = "-1";
		 }
		 ResponseBuilder rb = new ResponseBuilder();
		 rb.writeJsonResponse(response, result);
	    }
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}
	public void setJgxxService(JgxxService jgxxService) {
		this.jgxxService = jgxxService;
	}
	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}
	
	
	
}
