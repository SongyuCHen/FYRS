package nju.software.fyrs.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.manager.RyjbxxManager;
import nju.software.fyrs.biz.vo.JlxxVO;
import nju.software.fyrs.biz.vo.RyjbxxFzbVO;
import nju.software.fyrs.data.dao.FzbPhotoDAO;
import nju.software.fyrs.data.dao.RyjbxxFzbDAO;
import nju.software.fyrs.data.dataobject.Dm;
import nju.software.fyrs.data.dataobject.FzbPhoto;
import nju.software.fyrs.data.dataobject.RyjbxxFzb;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.FzbJlxxService;
import nju.software.fyrs.service.convertor.RyviewConvertor;
import nju.software.fyrs.service.model.UserContext;
import nju.software.fyrs.util.BeanUtilsEx;
import nju.software.fyrs.util.ConstantsFyrs;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.util.NFyRybhCodeUtils;
import nju.software.fyrs.util.RolesUtil;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

@Controller
public class FzbjbxxController {
	private RyjbxxManager ryjbxxManager;
	private RyviewConvertor ryviewConvertor;
	private DmService dmService;
	private RyjbxxFzbDAO ryjbxxFzbDAO;
	private FzbJlxxService fzbJlxxService;
	private FzbPhotoDAO fzbPhotoDAO;
	public void setRyjbxxManager(RyjbxxManager ryjbxxManager) {
		this.ryjbxxManager = ryjbxxManager;
	}

	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}

	public void setRyjbxxFzbDAO(RyjbxxFzbDAO ryjbxxFzbDAO) {
		this.ryjbxxFzbDAO = ryjbxxFzbDAO;
	}
	

	public void setFzbJlxxService(FzbJlxxService fzbJlxxService) {
		this.fzbJlxxService = fzbJlxxService;
	}

	public void setFzbPhotoDAO(FzbPhotoDAO fzbPhotoDAO) {
		this.fzbPhotoDAO = fzbPhotoDAO;
	}
	public void setRyviewConvertor(RyviewConvertor ryviewConvertor) {
		this.ryviewConvertor = ryviewConvertor;
	}

	@RequestMapping(value = "/ryjbxxfzb.do", method = RequestMethod.POST)
	public String showRyjbxxFzb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String isOnlyLook = request.getParameter("isOnlyLook");
		// 如果 isOnlyLook 为 true 表示只能查看
		if (isOnlyLook != null) {
			RolesUtil.getUserContext(request).setHidden(
					Boolean.valueOf(NFyRybhCodeUtils.decode(isOnlyLook)[2]));
		}

		String[] code = NFyRybhCodeUtils.decode(showKey);
		RyjbxxFzb ryxx1 = ryjbxxFzbDAO.getRyjbxxFzbByRybhFyDm(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		if (ryxx1 == null) {
			String errmsg = "未找到该人员，请联系管理员！";
			model.addAttribute(errmsg,"errmsg");
			return "error";
		} else {
//			List<Dm> listDmBm = ryjbxxManager.getDmListByName("内设机构");
//			List<Dm> listDmXb = ryjbxxManager.getDmListByName("性别");
//			List<Dm> listDmMz = ryjbxxManager.getDmListByName("民族");
//			List<Dm> listDmHyzk = ryjbxxManager.getDmListByName("婚姻状况");
//			List<Dm> listDmJkzk = ryjbxxManager.getDmListByName("健康状况");
//			List<Dm> listDmZwlb = ryjbxxManager.getDmListByName("职务类别");
//			List<Dm> listDmDzzw = ryjbxxManager.getDmListByName("党组职务");
//			List<Dm> listDmBz = ryjbxxManager.getDmListByName("编制");
//			List<Dm> listDmZyzs = ryjbxxManager.getDmListByName("专业证书");
//			List<Dm> listDmQdfgzgzs = ryjbxxManager.getDmListByName("法官资格证书");
//			List<Dm> listDmJtj = ryjbxxManager.getDmListByName("进入途径");
//			List<Dm> listDmJly = ryjbxxManager.getDmListByName("进入来源");
//			List<Dm> listDmYzw = ryjbxxManager.getDmListByName("职务");
//			List<Dm> listDmYzj = ryjbxxManager.getDmListByName("职级");
//			List<Dm> listDmCyy = ryjbxxManager.getDmListByName("调离原因");
//			List<Dm> listDmQx = ryjbxxManager.getDmListByName("调离去向");
//			List<Dm> listDmZzmm = ryjbxxManager.getDmListByName("政治面貌");
//			List<Dm> listDmGz = ryjbxxManager.getDmListByName("工种");
//			List<Dm> listDmXw = ryjbxxManager.getDmListByName("学位");
//			List<Dm> listDmXl = ryjbxxManager.getDmListByName("文化程度");
//			List<Dm> listDmZy = ryjbxxManager.getDmListByName("专业");
			String nl = String.valueOf(DateUtil.getAge(ryxx1.getDCsrq()));
//			model.addAttribute("listDmXw", listDmXw);
//			model.addAttribute("listDmZy", listDmZy);
//			model.addAttribute("listDmXl", listDmXl);
//			model.addAttribute("listDmZzmm", listDmZzmm);
//			model.addAttribute("listDmGz", listDmGz);
//			model.addAttribute("listDmQx", listDmQx);
//			model.addAttribute("listDmCyy", listDmCyy);
//			model.addAttribute("listDmYzj", listDmYzj);
//			model.addAttribute("listDmYzw", listDmYzw);
//			model.addAttribute("listDmJly", listDmJly);
//			model.addAttribute("listDmJtj", listDmJtj);
//			model.addAttribute("listDmQdfgzgzs", listDmQdfgzgzs);
//			model.addAttribute("listDmZyzs", listDmZyzs);
//			model.addAttribute("listDmBz", listDmBz);
//			model.addAttribute("listDmDzzw", listDmDzzw);
//			model.addAttribute("listDmZwlb", listDmZwlb);
//			model.addAttribute("listDmJkzk", listDmJkzk);
//			model.addAttribute("listDmHyzk", listDmHyzk);
//			model.addAttribute("listDmMz", listDmMz);
//			model.addAttribute("listDmXb", listDmXb);
//			model.addAttribute("listDmBm", listDmBm);
			model.addAttribute("ryxx1", ryviewConvertor.getfzbByDO(ryxx1));
			model.addAttribute("type", "fzbryjbxx");
			model.addAttribute("index", "fzbryjbxx");
			model.addAttribute("nl", nl);
			model.addAttribute("showKey", showKey);
			return "fzbryjbxx/fzbryjbxx";
		}
	}

	@RequestMapping(value = "/addryjbxxfzb.do", method = RequestMethod.GET)
	public String addRyjbxxFzb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		int fydm = Integer.valueOf(request.getParameter("fydm"));
		int rybh = ryjbxxFzbDAO.getMaxRybhByFydm(fydm);
		String showKey = NFyRybhCodeUtils.encode(fydm, rybh);

		List<Dm> listDmBm = ryjbxxManager.getDmListByName("内设机构");
		List<Dm> listDmXb = ryjbxxManager.getDmListByName("性别");
		List<Dm> listDmMz = ryjbxxManager.getDmListByName("民族");
		List<Dm> listDmHyzk = ryjbxxManager.getDmListByName("婚姻状况");
		List<Dm> listDmJkzk = ryjbxxManager.getDmListByName("健康状况");
		List<Dm> listDmZwlb = ryjbxxManager.getDmListByName("职务类别");
		List<Dm> listDmDzzw = ryjbxxManager.getDmListByName("党组职务");
		List<Dm> listDmBz = ryjbxxManager.getDmListByName("编制");
		List<Dm> listDmZyzs = ryjbxxManager.getDmListByName("专业证书");
		List<Dm> listDmQdfgzgzs = ryjbxxManager.getDmListByName("法官资格证书");
		List<Dm> listDmJtj = ryjbxxManager.getDmListByName("进入途径");
		List<Dm> listDmJly = ryjbxxManager.getDmListByName("进入来源");
		List<Dm> listDmYzw = ryjbxxManager.getDmListByName("职务");
		List<Dm> listDmYzj = ryjbxxManager.getDmListByName("职级");
		List<Dm> listDmCyy = ryjbxxManager.getDmListByName("调离原因");
		List<Dm> listDmQx = ryjbxxManager.getDmListByName("调离去向");
		List<Dm> listDmZzmm = ryjbxxManager.getDmListByName("政治面貌");
		List<Dm> listDmGz = ryjbxxManager.getDmListByName("工种");
		List<Dm> listDmXw = ryjbxxManager.getDmListByName("学位");
		List<Dm> listDmXl = ryjbxxManager.getDmListByName("文化程度");
		List<Dm> listDmZy = ryjbxxManager.getDmListByName("专业");
		model.addAttribute("listDmXw", listDmXw);
		model.addAttribute("listDmZy", listDmZy);
		model.addAttribute("listDmXl", listDmXl);
		model.addAttribute("listDmZzmm", listDmZzmm);
		model.addAttribute("listDmGz", listDmGz);
		model.addAttribute("listDmQx", listDmQx);
		model.addAttribute("listDmCyy", listDmCyy);
		model.addAttribute("listDmYzj", listDmYzj);
		model.addAttribute("listDmYzw", listDmYzw);
		model.addAttribute("listDmJly", listDmJly);
		model.addAttribute("listDmJtj", listDmJtj);
		model.addAttribute("listDmQdfgzgzs", listDmQdfgzgzs);
		model.addAttribute("listDmZyzs", listDmZyzs);
		model.addAttribute("listDmBz", listDmBz);
		model.addAttribute("listDmDzzw", listDmDzzw);
		model.addAttribute("listDmZwlb", listDmZwlb);
		model.addAttribute("listDmJkzk", listDmJkzk);
		model.addAttribute("listDmHyzk", listDmHyzk);
		model.addAttribute("listDmMz", listDmMz);
		model.addAttribute("listDmXb", listDmXb);
		model.addAttribute("listDmBm", listDmBm);
		model.addAttribute("type", "fzbryjbxx");
		model.addAttribute("index", "fzbryjbxx");
		model.addAttribute("showKey", showKey);
		return "fzbryjbxx/editfzbryjbxx";
	}

	@RequestMapping(value = "/editryjbxxfzb.do", method = RequestMethod.GET)
	public String editRyjbxxFzb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		RyjbxxFzb ryxx1 = ryjbxxFzbDAO.getRyjbxxFzbByRybhFyDm(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		if (ryxx1 == null) {
			String errmsg = "未找到该人员，请联系管理员！";
			model.addAttribute(errmsg,"errmsg");
			return "error";
		} else {
			String nl = String.valueOf(DateUtil.getAge(ryxx1.getDCsrq()));
			List<Dm> listDmBm = ryjbxxManager.getDmListByName("内设机构");
			List<Dm> listDmXb = ryjbxxManager.getDmListByName("性别");
			List<Dm> listDmMz = ryjbxxManager.getDmListByName("民族");
			List<Dm> listDmHyzk = ryjbxxManager.getDmListByName("婚姻状况");
			List<Dm> listDmJkzk = ryjbxxManager.getDmListByName("健康状况");
			List<Dm> listDmZwlb = ryjbxxManager.getDmListByName("职务类别");
			List<Dm> listDmDzzw = ryjbxxManager.getDmListByName("党组职务");
			List<Dm> listDmBz = ryjbxxManager.getDmListByName("编制");
			List<Dm> listDmZyzs = ryjbxxManager.getDmListByName("专业证书");
			List<Dm> listDmQdfgzgzs = ryjbxxManager.getDmListByName("法官资格证书");
			List<Dm> listDmJtj = ryjbxxManager.getDmListByName("进入途径");
			List<Dm> listDmJly = ryjbxxManager.getDmListByName("进入来源");
			List<Dm> listDmYzw = ryjbxxManager.getDmListByName("职务");
			List<Dm> listDmYzj = ryjbxxManager.getDmListByName("职级");
			List<Dm> listDmCyy = ryjbxxManager.getDmListByName("调离原因");
			List<Dm> listDmQx = ryjbxxManager.getDmListByName("调离去向");
			List<Dm> listDmZzmm = ryjbxxManager.getDmListByName("政治面貌");
			List<Dm> listDmGz = ryjbxxManager.getDmListByName("工种");
			List<Dm> listDmXw = ryjbxxManager.getDmListByName("学位");
			List<Dm> listDmXl = ryjbxxManager.getDmListByName("文化程度");
			List<Dm> listDmZy = ryjbxxManager.getDmListByName("专业");
			model.addAttribute("listDmXw", listDmXw);
			model.addAttribute("listDmZy", listDmZy);
			model.addAttribute("listDmXl", listDmXl);
			model.addAttribute("listDmZzmm", listDmZzmm);
			model.addAttribute("listDmGz", listDmGz);
			model.addAttribute("listDmQx", listDmQx);
			model.addAttribute("listDmCyy", listDmCyy);
			model.addAttribute("listDmYzj", listDmYzj);
			model.addAttribute("listDmYzw", listDmYzw);
			model.addAttribute("listDmJly", listDmJly);
			model.addAttribute("listDmJtj", listDmJtj);
			model.addAttribute("listDmQdfgzgzs", listDmQdfgzgzs);
			model.addAttribute("listDmZyzs", listDmZyzs);
			model.addAttribute("listDmBz", listDmBz);
			model.addAttribute("listDmDzzw", listDmDzzw);
			model.addAttribute("listDmZwlb", listDmZwlb);
			model.addAttribute("listDmJkzk", listDmJkzk);
			model.addAttribute("listDmHyzk", listDmHyzk);
			model.addAttribute("listDmMz", listDmMz);
			model.addAttribute("listDmXb", listDmXb);
			model.addAttribute("listDmBm", listDmBm);
			model.addAttribute("type", "fzbryjbxx");
			model.addAttribute("index", "fzbryjbxx");
			model.addAttribute("nl", nl);
			model.addAttribute("ryxx1", ryxx1);
			model.addAttribute("showKey", showKey);
			return "fzbryjbxx/editfzbryjbxx";
		}
	}

	@RequestMapping(value = "/saveryjbxxfzb.aj", method = RequestMethod.POST)
	public void saveRyjbxxfzb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		int rybh = Integer.valueOf(code[1]);
		int fydm = Integer.valueOf(code[0]);
		RyjbxxFzbVO vo = new RyjbxxFzbVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		RyjbxxFzb ry = ryviewConvertor.getfzbByVO(vo);
		ryjbxxFzbDAO.saveRyFzb(rybh, fydm, ry);
	}

	@RequestMapping(value = "/ryjbxxfzb.do", method = RequestMethod.GET)
	public String showRyjbxxfzbGet(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		return showRyjbxxFzb(request, response, model);

	}
	
	@RequestMapping(value = "/delPhotofzb.aj", method = RequestMethod.POST)
	public void DeletePhotoFzb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		int result = fzbPhotoDAO.delFzbPhoto(code[0], code[1]) ? 0 : 1;
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/daochuPhotofzb.aj", method = RequestMethod.GET)
	public void daochuPhotoFzb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		FzbPhoto fzbPhoto = fzbPhotoDAO.getFzbPhoto(code[0], code[1]);
		String dirPath = getDirPath();
		String sorPath = dirPath + code[0] + code[1] + ".png";
		if (fzbPhoto != null) {
			File file = new File(sorPath);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			FileOutputStream outputStream = new FileOutputStream(file);
			byte[] photo = fzbPhoto.getIPhoto();
			outputStream.write(photo);
			outputStream.flush();
			outputStream.close();
		}else{
		File file = new File(this.getClass().getResource("/").getPath(),
		"moren.png");
		String filenameString = file.getAbsolutePath();
		downloadFile(filenameString, request, response);
		}
		
	}
	@RequestMapping(value = "/photofzb.do", method = RequestMethod.GET)
	public void photoFzb(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		FzbPhoto fzbPhoto = fzbPhotoDAO.getFzbPhoto(code[0], code[1]);
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");

		if (fzbPhoto != null && fzbPhoto.getIPhoto() != null) {
			response.getOutputStream().write(fzbPhoto.getIPhoto());
		} else {
			File file = new File(this.getClass().getResource("/").getPath(),
					"moren.png");
			response.getOutputStream().write(
					FileUtils.readFileToByteArray(file));
		}

	}

	@RequestMapping(value = "/isphotofzb.aj", method = RequestMethod.POST)
	public void isphotoFzb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		FzbPhoto fzbPhoto = fzbPhotoDAO.getFzbPhoto(code[0], code[1]);
		if (fzbPhoto == null) {
			ResponseBuilder builder = new ResponseBuilder();
			builder.writeJsonResponse(response, 1);
		}
	}
	
	@RequestMapping(value = "/uploadpicfzb.aj", method = RequestMethod.POST)
	public void uploadpicFzb(HttpServletRequest request,
			HttpServletResponse response,@RequestParam("file") MultipartFile file, ModelMap model) throws Exception {

		ResponseBuilder builder = new ResponseBuilder();
		String showkey = request.getParameter("showkey");
		String[] code = NFyRybhCodeUtils.decode(showkey);
		int fydm = Integer.valueOf(code[0]);
		int rybh = Integer.valueOf(code[1]);
		if (file.isEmpty()) {
			//"上传的文件不能为空";
			builder.writeResponse(response, "-1");
			return;
		}
		// 检查文件大小
		int fileSize = (int) (file.getSize() / 1024);
		if (fileSize > 1024) {
			//"上传的文件太大，文件大小不能超过200K";
			builder.writeResponse(response, "-2");
			return;
		}
		FzbPhoto photoOrig = fzbPhotoDAO.getFzbPhoto(code[0],code[1]);
		if(photoOrig != null){
			photoOrig.setIPhoto(file.getBytes());
			fzbPhotoDAO.update(photoOrig);
		}else{
			FzbPhoto photo = new FzbPhoto();
			photo.setNFy(fydm);
			photo.setNRybh(rybh);
			photo.setIPhoto(file.getBytes());
			fzbPhotoDAO.save(photo);
		}
		builder.writeResponse(response, "0");
	}
	
	//简历信息
	@RequestMapping(value = "/jlxxfzb.do", method = RequestMethod.GET)
	public String showJlxxFzb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<JlxxVO> jlxxVOs = fzbJlxxService.getJlxxByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));//
		model.addAttribute("jlxxList", jlxxVOs);
		model.addAttribute("index", "jlxx");
		model.addAttribute("showKey", showKey);
		model.addAttribute("isHidden",((UserContext)request.getSession().getAttribute("user")).isHidden());
		model.addAttribute("cxm",ryjbxxFzbDAO.getRyjbxxFzbByRybhFyDm(Integer.valueOf(code[1]), Integer.valueOf(code[0])).getCXm());
		model.addAttribute("fymc",dmService.dmByDmBxh(Integer.valueOf(code[0]),ConstantsFyrs.NBXH_DWMC).getCMc());
		return "ryjbxx/jlxxfzb";

	}

	@RequestMapping(value = "/jlxxfzb.aj", method = RequestMethod.POST)
	public String showPopJlxxFzb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		JlxxVO VO = new JlxxVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = fzbJlxxService.getRsJlxxById(keyid, fydm, rybh);
		}
		model.addAttribute("jlxx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_jlxxfzb";
	}

	@RequestMapping(value = "/deleteJlxxfzb.aj", method = RequestMethod.POST)
	public void deleteJlxxFzb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = fzbJlxxService.delRsJlxxById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addJlxxfzb.aj", method = RequestMethod.POST)
	public void addJlxxFzb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		JlxxVO vo = new JlxxVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		JlxxVO jlxxVO = new JlxxVO();
		jlxxVO = fzbJlxxService.addJlxx(vo);
		if (jlxxVO.getDQsrq() == null) {
			jlxxVO.setDQsrq("");
		}
		if (jlxxVO.getDJzrq() == null) {
			jlxxVO.setDJzrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, jlxxVO);
	}

	@RequestMapping(value = "/saveJlxxfzb.aj", method = RequestMethod.POST)
	public void saveJlxxFzb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		JlxxVO vo = new JlxxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		JlxxVO jlxxVO = new JlxxVO();
		jlxxVO = fzbJlxxService.updateRsJlxx(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, jlxxVO);
	}
	
	private String getDirPath() {
		return System.getProperty("web.fyrs.root") + "resources\\images\\";
	}
	private void downloadFile(String filename, HttpServletRequest request,
			HttpServletResponse response) {
		File file = new File(filename);
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(file, "r");
			java.io.FileInputStream fis = new java.io.FileInputStream(
					raf.getFD());
			response.setHeader("Server", "www.trydone.com");
			response.setHeader("Accept-Ranges", "bytes");
			long pos = 0;
			long len;
			len = raf.length();
			if (request.getHeader("Range") != null) {
				response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
				pos = Long.parseLong(request.getHeader("Range")
						.replaceAll("bytes=", "").replaceAll("-", ""));
			}
			response.setHeader("Content-Length", Long.toString(len - pos));
			if (pos != 0) {
				response.setHeader(
						"Content-Range",
						new StringBuffer().append("bytes ").append(pos)
								.append("-").append(Long.toString(len - 1))
								.append("/").append(len).toString());
			}
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", new StringBuffer()
					.append("attachment;filename=\"").append(file.getName())
					.append("\"").toString());
			raf.seek(pos);
			byte[] b = new byte[2048];
			int i;
			OutputStream outs = response.getOutputStream();
			while ((i = raf.read(b)) != -1) {
				outs.write(b, 0, i);
			}
			raf.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
