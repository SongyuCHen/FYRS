package nju.software.fyrs.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.data.dataobject.Wdgl;
import nju.software.fyrs.service.WdglService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.model.UserContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/main/wdgl")
public class WdglController {
	public static String UPLOAD_DIR = "upload";
	private static Logger logger = Logger.getLogger(WdglController.class);
	private RoleMenuService roleMenuService;
	private WdglService wdglService;
	
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	public void setWdglService(WdglService wdglService) {
		this.wdglService = wdglService;
	}
	
	@RequestMapping(value="/wdgl.do",method = RequestMethod.GET)
	public String showWdgl(Model model,HttpServletResponse response,HttpServletRequest request)
	{
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		Integer yhbh = user.getYhbh();
		
		MenuShowUtils.headerMenu(request,model, roleMenuService,"文档管理");
		MenuShowUtils.leftMenu(request,model, roleMenuService, "wdgl");
		model.addAttribute("currentSelectLeftMenu","文档管理");
		
		model.addAttribute("currentUserId", yhbh);
		model.addAttribute("wdList",wdglService.getAllWd());
		return "wdgl/show";
	}
	
	/**
	 * 添加文档
	 * @param model
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addWd.do",method = RequestMethod.POST)
	public String addWd(@RequestParam MultipartFile[] myfiles, Model model,HttpServletResponse response,HttpServletRequest request)
	{
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		Integer yhbh = user.getYhbh();
		
		String fwh = request.getParameter("fwh").trim();
		String bt = request.getParameter("bt").trim();
		String wdms = request.getParameter("wdms").trim();
		String wdnr = request.getParameter("wdnr").trim();
		String wdlj = null;
		String wdywjm = null;
		Date currentDate = new Date();
		
		String baseURL = request.getSession().getServletContext().getRealPath("/");
		for(MultipartFile myfile : myfiles){
	        if(myfile.isEmpty()){  
	        	logger.debug("未上传文档");
	        }else{
	        	try {
	        		wdywjm = myfile.getOriginalFilename();
	        		File uploadDir = new File(baseURL+UPLOAD_DIR);
	        		if(!uploadDir.exists() && !uploadDir.isDirectory()){
	        			uploadDir.mkdirs();
	        		}
	        		wdlj = baseURL+UPLOAD_DIR + File.separatorChar + yhbh + currentDate.getTime();
	        		OutputStream outputStream = new FileOutputStream(wdlj);
					InputStream inputStream = myfile.getInputStream();
					byte[] bytes = new byte[1024];
					while ((inputStream.read(bytes)) != -1){
						outputStream.write(bytes);
					}
					inputStream.close();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
        }
		
		Wdgl wdgl = new Wdgl();
		wdgl.setBt(bt);
		wdgl.setFwh(fwh);
		wdgl.setFwsj(currentDate);
		wdgl.setUserid(yhbh);
		wdgl.setWdlj(wdlj);
		wdgl.setWdywjm(wdywjm);
		wdgl.setWdms(wdms);
		wdgl.setWdnr(wdnr);
		wdgl.setZjxgsj(currentDate);
		wdglService.addWd(wdgl);
		
		return "redirect: wdgl.do";
	}
	
	/**
	 * 文档查询
	 * @param model
	 * @param response
	 * @param request
	 * @return
	 * @throws ParseException 
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/queryWd.do",method = RequestMethod.POST)
	public String queryWd(Model model,HttpServletResponse response,HttpServletRequest request) throws ParseException, UnsupportedEncodingException
	{
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		Integer yhbh = user.getYhbh();
		
		String fwhQueryStr = request.getParameter("fwh").trim();
		String btQueryStr = request.getParameter("bt").trim();
		String fwsjStartQueryStr = request.getParameter("fwsj-start").trim();
		String fwsjEndQueryStr = request.getParameter("fwsj-end").trim();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fwsjStart = null;
		Date fwsjEnd = null;
		
		if(!fwsjStartQueryStr.isEmpty())
			fwsjStart = sdf.parse(fwsjStartQueryStr);
		if(!fwsjEndQueryStr.isEmpty())
			fwsjEnd = sdf.parse(fwsjEndQueryStr);
		
		Map<String,Object> queryMap = new HashMap<String,Object>();
		queryMap.put("fwh", fwhQueryStr);
		queryMap.put("bt", btQueryStr);
		queryMap.put("fwsjStart", fwsjStart);
		queryMap.put("fwsjEnd", fwsjEnd);
		
		MenuShowUtils.headerMenu(request,model, roleMenuService,"文档管理");
		MenuShowUtils.leftMenu(request,model, roleMenuService, "wdgl");
		model.addAttribute("currentSelectLeftMenu","文档管理");
		
		model.addAttribute("currentUserId", yhbh);
		
		model.addAttribute("queryFwh", fwhQueryStr);
		model.addAttribute("queryBt", btQueryStr);
		model.addAttribute("queryFwsjStart", fwsjStartQueryStr);
		model.addAttribute("queryFwsjEnd", fwsjEndQueryStr);
		model.addAttribute("wdList",wdglService.getWdByQueryMap(queryMap));
		return "wdgl/show";
	}
	
	/**
	 * 文档下载
	 * @param model
	 * @param response
	 * @param request
	 * @return
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@RequestMapping(value="/downloadWd.do",method = RequestMethod.GET)
	public void downloadWd(Model model,HttpServletResponse response,HttpServletRequest request) throws ParseException, IOException
	{
		String wdbhStr = request.getParameter("wdbh");
		Integer wdbh = null;
		if(wdbhStr!=null){
			wdbh = Integer.parseInt(wdbhStr);
			Wdgl wd = wdglService.getWdById(wdbh);
			if(wd!=null){
				if(!wd.getWdlj().isEmpty()){
					File file = new File(wd.getWdlj());
					if(file.exists()){
						BufferedInputStream bis = null;
						BufferedOutputStream bos = null;				
				
						response.reset();
						response.setHeader("Content-Disposition", "attachment;filename="+new String(wd.getWdywjm().getBytes("utf-8"),"iso-8859-1"));
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
					}else{
						logger.error("该文件不存在！文档编号是："+wd.getWdbh());
					}
				}else{
					logger.error("该文档没有上传的文件");
				}
			}else{
				logger.error("该文档不存在！");
			}
		}else{
			logger.error("文档编号不能为空！");
		}
	}
	
	/**
	 * 删除文档
	 * @param model
	 * @param response
	 * @param request
	 * @return
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@RequestMapping(value="/deleteWd.do",method = RequestMethod.GET)
	public String deleteWd(Model model,HttpServletResponse response,HttpServletRequest request) throws ParseException, IOException
	{
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		Integer yhbh = user.getYhbh();
		
		String wdbhStr = request.getParameter("wdbh");
		Integer wdbh = null;
		if(wdbhStr!=null){
			wdbh = Integer.parseInt(wdbhStr);
			Wdgl wd = wdglService.getWdById(wdbh);
			if(wd!=null){
				if(yhbh.equals(wd.getUserid())){
					String wdlj = wd.getWdlj();
					if(wdlj!=null && !wdlj.isEmpty()){
						File fileToDelete = new File(wdlj);
						if(fileToDelete.exists()){
							fileToDelete.delete();
						}else{
							logger.error("上传的文件不存在，可能已经被删除");
						}
					}else{
						logger.error("该文档没有上传的文件");
					}
					wdglService.deleteWd(wd);
				}else{
					logger.error("你不是文档的上传者，无权修改或删除");
				}
			}else{
				logger.error("该文档在数据库中不存在");
			}
		}else{
			logger.error("文档编号不能为空！");
		}
		return "redirect: wdgl.do";
	}
	
	/**
	 * 编辑文档
	 * @param model
	 * @param response
	 * @param request
	 * @return
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@RequestMapping(value="/editWd.do",method = RequestMethod.POST)
	public String editWd(@RequestParam MultipartFile[] myfiles, Model model,HttpServletResponse response,HttpServletRequest request) throws ParseException, IOException
	{
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		Integer yhbh = user.getYhbh();
		
		String fwh = request.getParameter("fwh").trim();
		String bt = request.getParameter("bt").trim();
		String wdms = request.getParameter("wdms").trim();
		String wdnr = request.getParameter("wdnr").trim();
		String wdlj = "";
		String wdywjm = "";
		String baseURL = request.getSession().getServletContext().getRealPath("/");
		Date currentDate = new Date();
		
		String wdbhStr = request.getParameter("wdbh");
		Integer wdbh = null;
		if(wdbhStr!=null){
			wdbh = Integer.parseInt(wdbhStr);
			Wdgl wd = wdglService.getWdById(wdbh);
			if(yhbh.equals(wd.getUserid())){
				for(MultipartFile myfile : myfiles){
			        if(myfile.isEmpty()){
			        	logger.debug("未上传文档");
			        }else{
			        	if(!wd.getWdlj().isEmpty()){//删除原来上传的文件
			        		File fileToDelete = new File(wd.getWdlj());
							if(fileToDelete.exists()){
								fileToDelete.delete();
							}else{
								logger.error("上传的文件不存在，可能已经被删除");
							}
			        	}
			        	try {
			        		wdywjm = myfile.getOriginalFilename();
			        		File uploadDir = new File(baseURL+UPLOAD_DIR);
			        		if(!uploadDir.exists() && !uploadDir.isDirectory()){
			        			uploadDir.mkdirs();
			        		}
			        		wdlj = baseURL+UPLOAD_DIR + File.separatorChar + yhbh + currentDate.getTime();
			        		OutputStream outputStream = new FileOutputStream(wdlj);
							InputStream inputStream = myfile.getInputStream();
							byte[] bytes = new byte[1024];
							while ((inputStream.read(bytes)) != -1){
								outputStream.write(bytes);
							}
							inputStream.close();
							outputStream.close();
							
							wd.setWdlj(wdlj);
							wd.setWdywjm(wdywjm);
						} catch (IOException e) {
							e.printStackTrace();
						}
			        }
		        }
				
				wd.setBt(bt);
				wd.setFwh(fwh);
				wd.setWdms(wdms);
				wd.setWdnr(wdnr);
				wd.setZjxgsj(currentDate);
				wdglService.updateWd(wd);
			}else{
				logger.error("你不是文档的上传者，无权修改或删除");
			}
		}else{
			logger.error("文档编号不能为空！");
		}
		return "redirect: wdgl.do";
	}
}
