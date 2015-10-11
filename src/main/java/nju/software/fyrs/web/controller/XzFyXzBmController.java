package nju.software.fyrs.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.FyTreeDataObject;
import nju.software.fyrs.biz.vo.JgxxVO;
import nju.software.fyrs.biz.vo.TianJingFyVO;
import nju.software.fyrs.data.dataobject.Jgxx;
import nju.software.fyrs.service.impl.JgxxServiceImpl;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.impl.RsFyServiceImpl;
import nju.software.fyrs.util.RolesUtil;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class XzFyXzBmController {
	 private RsFyServiceImpl rsFyService;
	 private JgxxServiceImpl jgxxService;
	 private RoleMenuService roleMenuService;
	 
	    @RequestMapping(value="/xzfyShow.aj",method = RequestMethod.POST)
	    public String showFy(HttpServletResponse response) throws IOException
	    {
	    	return "login/pop/xzfyPop";
	    }
	    
	    
	    @RequestMapping(value="/xzfy.aj",method = RequestMethod.POST)
	    public void xzFy(HttpServletResponse response,HttpServletRequest request) throws IOException
	    {
	    	// Ĭ�ϵ�¼ֻ���������Ŀ⣬����ѡ��Ժ���������
	    	String isOnlyXzFy = request.getParameter("isOnlyXzFy");
	    	FyTreeDataObject fdo = null;
	    	// ��ʾ�ǵ�¼�������������ʾ�������Ժ
	    	if(isOnlyXzFy.endsWith("1"))
	    	{
	    		fdo = rsFyService.FyTree("2%");
	    	}
	    	// ����Ȩ�޾����Ƿ���ʾ�¼���Ժ
	    	if(isOnlyXzFy.endsWith("0"))
	    	{
	    		// ֻ�зŵ������Ϊ�����ʾ�Ѿ���¼
	    		int fydm = RolesUtil.getUserContext(request).getFydm();
	    		// ��÷�Ժ�ּ���
	    		String fjm = rsFyService.fjmByFydm(fydm);
	    		// ��ʾ��ײ�ѧԺ��ֱ�ӻ�÷�Ժ
	    		if(fjm.equals("-1"))
	    		{
	    		   fdo = rsFyService.fyTreeOnlyOne(fydm);
	    		}
	    		else
	    		{
	    			// 
	    			Boolean isXjfy = roleMenuService.findIsCkxjfy(RolesUtil.userGetRoleIds(request));
	    			if(isXjfy)
	    			{
	    				fdo = rsFyService.FyTree(fjm);
	    			}
	    			// ��ʾ��Ȼ������ײ㣬����û�в鿴�¼���Ժ��Ȩ��
	    			else
	    			{
	    				fdo = rsFyService.fyTreeOnlyOne(fydm);
	    			}
	    			
	    		}
	    		
	    	}
	    	ResponseBuilder rb = new ResponseBuilder();
	    	// Ҳ���ǻ���������Ժ����
	    	TianJingFyVO tjfvo = new TianJingFyVO(fdo);
	    	rb.writeJsonResponse(response, tjfvo);
	    }
	    @RequestMapping(value="/xzfyBmShow.aj",method = RequestMethod.POST)
	    public String showFyBm(HttpServletResponse response) throws IOException
	    {
	    	return "login/pop/xzfyBmPop";
	    }
	    @RequestMapping(value="/xzfyBm.aj",method = RequestMethod.POST)
	    public void xzFyBm(HttpServletResponse response,HttpServletRequest request) throws IOException
	    {
	    	String isOnlyXzFy = request.getParameter("isOnlyXzFy");
	    	System.out.println("-->"+isOnlyXzFy);
	    	FyTreeDataObject fdo = null;
	    	// ��ʾ�ǵ�¼�������������ʾ�������Ժ
	    	if(isOnlyXzFy.endsWith("1"))
	    	{
	    		fdo = rsFyService.FyTree("2%");
	    	}
	    	// ����Ȩ�޾����Ƿ���ʾ�¼���Ժ
	    	if(isOnlyXzFy.endsWith("0"))
	    	{
	    		// ֻ�зŵ������Ϊ�����ʾ�Ѿ���¼
	    		int fydm = RolesUtil.getUserContext(request).getFydm();
	    		// ��÷�Ժ�ּ���
	    		String fjm = rsFyService.fjmByFydm(fydm);
	    		// ��ʾ��ײ�ѧԺ��ֱ�ӻ�÷�Ժ
	    		if(fjm.equals("-1"))
	    		{
	    		   fdo = rsFyService.fyTreeOnlyOne(fydm);
	    		}
	    		else
	    		{
	    			// 
	    			Boolean isXjfy = roleMenuService.findIsCkxjfy(RolesUtil.userGetRoleIds(request));
	    			if(isXjfy)
	    			{
	    				fdo = rsFyService.FyTreeForCache(fjm);
	    			}
	    			// ��ʾ��Ȼ������ײ㣬����û�в鿴�¼���Ժ��Ȩ��
	    			else
	    			{
	    				fdo = rsFyService.fyTreeOnlyOne(fydm);
	    			}
	    			
	    		}
	    		
	    	}
	    	ResponseBuilder rb = new ResponseBuilder();
	    	//
	    	TianJingFyVO.jgxxService = jgxxService;
	    	// Ҳ���ǻ���������Ժ����
	    	TianJingFyVO tjfvo = new TianJingFyVO(fdo,true);
	    	rb.writeJsonResponse(response, tjfvo);
	    }
	    @RequestMapping(value="/xzbm.aj",method = RequestMethod.POST)
	    public void xzBm(HttpServletResponse response,HttpServletRequest request) throws IOException
	    {
	    	String fyDm = request.getParameter("id");
	    	List<Jgxx> jgxxs = jgxxService.bmByFyId(Integer.valueOf(fyDm));
	    	List<JgxxVO> vos = new ArrayList<JgxxVO>();
	    	for(Jgxx jgxx : jgxxs)
	    	{
	    		JgxxVO jgxxVo = new JgxxVO();
	    		jgxxVo.setNCode(jgxx.getNCode());
	    		jgxxVo.setCName(jgxx.getCName());
	    		vos.add(jgxxVo);
	    	}
	    	ResponseBuilder rb = new ResponseBuilder();
	    	rb.writeJsonResponse(response,vos);
	    }

	public void setRsFyService(RsFyServiceImpl rsFyService) {
		this.rsFyService = rsFyService;
	}

	public void setJgxxService(JgxxServiceImpl jgxxService) {
		this.jgxxService = jgxxService;
	}

	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}
	
	@RequestMapping(value="/xzfyyrShow.aj",method = RequestMethod.POST)
    public String showYrfy(HttpServletResponse response) throws IOException
    {
    	return "login/pop/xzfyyrPop";
    }
}
