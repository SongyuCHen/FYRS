package nju.software.fyrs.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.SysBackupVO;
import nju.software.fyrs.data.dataobject.SysBackPlan;
import nju.software.fyrs.data.dataobject.SysBackup;
import nju.software.fyrs.database.SetTheDatabasePath;
import nju.software.fyrs.service.SysBackPlanService;
import nju.software.fyrs.service.SysBackupService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.util.BackupDatabase;
import nju.software.fyrs.util.ConstantsFyrs;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/main/xtgl")
public class XtglBfhfController {
	  public static String UPLOAD_DIR = "dataBase";
	  private static Logger logger = Logger.getLogger(XtglBfhfController.class);
	  private RoleMenuService roleMenuService;	
	  private SysBackPlanService sysBackPlanService;
	  private SysBackupService sysBackupService;
	  @RequestMapping(value="/bfhf.do",method = RequestMethod.GET)
	    public String showDmwh(Model model,HttpServletResponse response,HttpServletRequest request)
	    {
		  MenuShowUtils.headerMenu(request,model, roleMenuService,"系统管理");
	      MenuShowUtils.leftMenu(request,model, roleMenuService, "xtgl");
	       // 当调用这个方法时，显然是显示它这个标签，所以
	       model.addAttribute("currentSelectLeftMenu","备份恢复");
	       SysBackPlan plan = sysBackPlanService.listSysBackPlans().get(0);
	       List<SysBackupVO> vos = sysBackupService.listSysBackup();
	       model.addAttribute("plan",plan);
	       model.addAttribute("vos",vos);
	       return "bfhf/show";
	    }
	  @RequestMapping(value="/bfConfiguration.aj",method = RequestMethod.POST)
	    public void bfConfiguration(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    { 		   
		   String backupNum = request.getParameter("backupNum");
		   String nid = request.getParameter("nid");
		   String frequency = request.getParameter("frequency");
		   SysBackPlan sysBackPlan = new SysBackPlan();
		   sysBackPlan.setNBlfs(Short.valueOf(backupNum));
		   sysBackPlan.setNId(Long.valueOf(nid));
		   sysBackPlan.setNFrequency(Short.valueOf(frequency));
		   sysBackPlanService.updateSysBackPlan(sysBackPlan);
		   ResponseBuilder rb = new ResponseBuilder();
		   rb.writeJsonResponse(response, "success");
	    }
	  
	  
	  @RequestMapping(value="/backuphand.aj",method = RequestMethod.POST)
	    public void  backuphand(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    { 	
		   // 存储在服务器的路 
		   Date currentDate = new Date();	
		   long timeStamp = currentDate.getTime();
		   String dataBaseUpPath = SetTheDatabasePath.getPath()+"\\fyrs2014-"+timeStamp+".db";
		   String baseURL = request.getSession().getServletContext().getRealPath("/");
		   BackupDatabase backupDatabase = new BackupDatabase();
		   boolean isBackupSuccess = backupDatabase.dataBaseUp(baseURL,dataBaseUpPath,timeStamp,"FYRS");
		   ResponseBuilder rb = new ResponseBuilder();
		   if(isBackupSuccess)
		   {
			   SysBackup sysBackup = new SysBackup();
			   sysBackup.setCFilename("fyrs2014-"+timeStamp+".db");
			   sysBackup.setCPath(dataBaseUpPath);
			   sysBackup.setDBacktime(currentDate);
			   sysBackup.setNBacktype(ConstantsFyrs.DATABASE_BACKUP_HANDER);
			   sysBackupService.addSysBackup(sysBackup);
			   rb.writeJsonResponse(response, "success");
		   }else
		   {
			   rb.writeJsonResponse(response, "fail");
		   }
		   
		   
	    }
	  @RequestMapping(value="/deleteBackup.aj",method = RequestMethod.POST)
	    public void  deleteBackup(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    { 		   
		   String nid = request.getParameter("nid");
		   sysBackupService.deleteSysBackup(nid);
		   ResponseBuilder rb = new ResponseBuilder();
		   rb.writeJsonResponse(response, "success");
	    }
	  
	  @RequestMapping(value="/dataBaseUpLoad.do",method = RequestMethod.POST)
		public String dataBaseUpLoad(@RequestParam MultipartFile fileName, Model model,HttpServletResponse response,HttpServletRequest request) throws IOException
		{
		    Date currentDate = new Date();
		    String dateBaseSavePath = "";
		    String fileNameSave = "";
		    String original = fileName.getOriginalFilename();
		    if(!original.endsWith(".db"))
		    {
		    	return "redirect: bfhf.do";
		    }
		    if(fileName.isEmpty())
		    {
		    	logger.debug("未上传文档");
		    }
		    else
		    {		  
		    	
		    	
		    	OutputStream outputStream = null;
		    	InputStream inputStream = null;
		    	 try
		    	 {
		    		    fileNameSave = "fyrs2014-"+currentDate.getTime()+".db";
				    	dateBaseSavePath = SetTheDatabasePath.getPath()+"\\"+fileNameSave;
				    	outputStream = new FileOutputStream(dateBaseSavePath);
						inputStream = fileName.getInputStream();
						byte[] bytes = new byte[1024];
						while ((inputStream.read(bytes)) != -1){
							outputStream.write(bytes);
						}	
						SysBackup sysBackup = new SysBackup();
				    	sysBackup.setCFilename(fileNameSave);
				    	sysBackup.setCPath(dateBaseSavePath);
				    	sysBackup.setDBacktime(currentDate);
				    	sysBackup.setNBacktype(ConstantsFyrs.DATABASE_BACKUP_HANDER);
						sysBackupService.addSysBackup(sysBackup);
		    	 }
		    	 finally
		    	 {
		    		 if(inputStream != null)
		    		 {
		    			 inputStream.close();
		    		 }
		    		 if(null != outputStream)
		    		 {
		    			 outputStream.close();	
		    		 }				     
		    	 }		    								        
		    }
			return "redirect: bfhf.do";
		}
	  @RequestMapping(value="/dataBaseDownload.do",method = RequestMethod.GET)
		public void dataBaseDownload(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException
		{
		  String nid = request.getParameter("nid");
		  SysBackup sys = sysBackupService.getSysBackup(nid);
		  File file = new File(sys.getCPath());
		  if(file.exists())
		  {
			    BufferedInputStream bis = null;
				BufferedOutputStream bos = null;				
		
				response.reset();
				response.setHeader("Content-Disposition", "attachment;filename="+new String(sys.getCFilename().getBytes("utf-8"),"iso-8859-1"));
				response.setHeader("Content-Length", String.valueOf(file.length()));

				bis = new BufferedInputStream(new FileInputStream(file));
				bos = new BufferedOutputStream(response.getOutputStream());
				byte[] buff = new byte[2048];
				int bytesRead;
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
					bos.write(buff, 0, bytesRead);
				}
				bis.close();
				bos.close();
		  }
		  else
		  {
			  logger.error("该文档不存在！");
		  }		 
 }
	  @RequestMapping(value="/usedatabaseupOnline.aj",method = RequestMethod.POST)
	    public void usedatabaseupOnline(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
		  String backType = request.getParameter("backType");
		  String nid = request.getParameter("nid");
		  String baseURL = request.getSession().getServletContext().getRealPath("/");
		  boolean result = false;
		  
		  //  Thread.sleep(2000);
		  // 表示恢复备份库
		  if(backType.trim().equals("backup"))
		  {
			 result = sysBackupService.isGeneratorOnline(baseURL,"FYRS_BACKUP",nid);
			 // result = true;
		  }
		  if(backType.trim().equals("normal"))
		  {
			 //  result = sysBackupService.isGeneratorOnline(baseURL,"FYRS",nid);
		  }
		  ResponseBuilder rb = new ResponseBuilder();
		  if(result)
		  {
			  rb.writeJsonResponse(response, "success");
		  }
		  else
		  {
			  rb.writeJsonResponse(response, "fail");
		  }   	
	   }
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}
	public void setSysBackPlanService(SysBackPlanService sysBackPlanService)
	{
		this.sysBackPlanService = sysBackPlanService;
	}
	public void setSysBackupService(SysBackupService sysBackupService)
	{
		this.sysBackupService = sysBackupService;
	}
	
	
	
	  
}
