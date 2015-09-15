package nju.software.fyrs.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.security.SignatureException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.service.sign.ExterfaceException;
import nju.software.fyrs.service.sign.SignKey;
import nju.software.fyrs.service.sign.Signature;
import nju.software.fyrs.biz.manager.RyjbxxManager;
import nju.software.fyrs.biz.vo.BmbdVO;
import nju.software.fyrs.biz.vo.BzxxVO;
import nju.software.fyrs.biz.vo.CcxxVO;
import nju.software.fyrs.biz.vo.CgxxVO;
import nju.software.fyrs.biz.vo.DjxxVO;
import nju.software.fyrs.biz.vo.DmCommonVO;
import nju.software.fyrs.biz.vo.FlzwVO;
import nju.software.fyrs.biz.vo.GwyjbVO;
import nju.software.fyrs.biz.vo.GzxxVO;
import nju.software.fyrs.biz.vo.HbgbVO;
import nju.software.fyrs.biz.vo.JliuxxVO;
import nju.software.fyrs.biz.vo.JlixxVO;
import nju.software.fyrs.biz.vo.JlxxVO;
import nju.software.fyrs.biz.vo.JrzwVO;
import nju.software.fyrs.biz.vo.JtxxVO;
import nju.software.fyrs.biz.vo.KhxxVO;
import nju.software.fyrs.biz.vo.LdbzVO;
import nju.software.fyrs.biz.vo.PxxxVO;
import nju.software.fyrs.biz.vo.RcxxVO;
import nju.software.fyrs.biz.vo.RyjbxxVO;
import nju.software.fyrs.biz.vo.RysxFljlVO;
import nju.software.fyrs.biz.vo.RysxHtVO;
import nju.software.fyrs.biz.vo.RysxShebaoVO;
import nju.software.fyrs.biz.vo.SfksVO;
import nju.software.fyrs.biz.vo.SwxxVO;
import nju.software.fyrs.biz.vo.SyyyxVO;
import nju.software.fyrs.biz.vo.TxlVO;
import nju.software.fyrs.biz.vo.WyxxVO;
import nju.software.fyrs.biz.vo.XiujiaVO;
import nju.software.fyrs.biz.vo.XlxxVO;
import nju.software.fyrs.biz.vo.XwxxVO;
import nju.software.fyrs.biz.vo.XzzwVO;
import nju.software.fyrs.biz.vo.ZdxxVO;
import nju.software.fyrs.biz.vo.ZjbgVO;
import nju.software.fyrs.biz.vo.ZjxxVO;
import nju.software.fyrs.biz.vo.ZyjszwVO;
import nju.software.fyrs.biz.vo.ZzmmVO;
import nju.software.fyrs.data.dao.RysxPhotoDAO;
import nju.software.fyrs.data.dataobject.Dm;
import nju.software.fyrs.data.dataobject.Gryjda;
import nju.software.fyrs.data.dataobject.Jgxx;
import nju.software.fyrs.data.dataobject.RysxPhoto;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.JgxxService;
import nju.software.fyrs.service.RyjbxxService;
import nju.software.fyrs.service.YjdaScbbService;
import nju.software.fyrs.util.BeanUtilsEx;
import nju.software.fyrs.util.ConstantsFyrs;
import nju.software.fyrs.util.DmCommonList;
import nju.software.fyrs.util.NFyRybhCodeUtils;
import nju.software.fyrs.util.ParameterUtil;
import nju.software.fyrs.util.RolesUtil;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

@Controller
public class JbxxController {
	Log logger = LogFactory.getLog(JbxxController.class);
	Signature md5Signature;
	RyjbxxManager ryjbxxManager;
	private DmService dmService;
	private RysxPhotoDAO rysxPhotoDAO;
	private RyjbxxService ryjbxxService;
	private YjdaScbbService yjdaScbbService;
	private JgxxService jgxxService;

	public void setJgxxService(JgxxService jgxxService) {
		this.jgxxService = jgxxService;
	}

	public void setYjdaScbbService(YjdaScbbService yjdaScbbService) {
		this.yjdaScbbService = yjdaScbbService;
	}

	public void setRyjbxxManager(RyjbxxManager ryjbxxManager) {
		this.ryjbxxManager = ryjbxxManager;
	}

	public void setRyjbxxService(RyjbxxService ryjbxxService) {
		this.ryjbxxService = ryjbxxService;
	}

	public void setRysxPhotoDAO(RysxPhotoDAO rysxPhotoDAO) {
		this.rysxPhotoDAO = rysxPhotoDAO;
	}

	@RequestMapping(value = "/ryjbxx.do", method = RequestMethod.POST)
	public String showRyjbxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String isOnlyLook = request.getParameter("isOnlyLook");
		// 如果 isOnlyLook 为 true 表示只能查看
		if (isOnlyLook != null) {
			RolesUtil.getUserContext(request).setHidden(
					Boolean.valueOf(NFyRybhCodeUtils.decode(isOnlyLook)[2]));
		}

		String[] code = NFyRybhCodeUtils.decode(showKey);
		RyjbxxVO VO = ryjbxxManager.getJbxxVOByRybhFy(Integer.valueOf(code[1]),
				Integer.valueOf(code[0]));
		
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		if (VO == null) {
			return "ryjbxx/ryjbxx";
		} else {
			model.addAttribute("ryxx1", VO);
			model.addAttribute("type", "ryjbxx");
			model.addAttribute("index", "ryjbxx");
			model.addAttribute("showKey", showKey);
			return "ryjbxx/ryjbxx";
		}
	}

	@RequestMapping(value = "/ryxx.do", method = RequestMethod.GET)
	public String showRyxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		
		boolean checkSuccess = true;
		String errmsg = null;
		try{
			checkSign(request);
		}catch(ExterfaceException e ){
			logger.error("外部接口检查签名出错",e);
			errmsg = e.getMessage() + "！";
			checkSuccess = false;
		} catch (SignatureException e) {
			logger.error("签名出错",e);
			errmsg = "签名检查出错，请联系管理员！";
			checkSuccess = false;
		}
		if(!checkSuccess){
			model.addAttribute(errmsg,"errmsg");
			return "error";
		}
		
		String fydm = request.getParameter("fydm");
		String xm = request.getParameter("xm");
		String count = request.getParameter("count");
		String s_xm;

		byte[] bytes = xm.getBytes("iso-8859-1");
		if ((bytes.length == 4 && "2".equals(count))
				|| (bytes.length == 6 && "3".equals(count))) {
			s_xm = new String(bytes, "GBK");
		} else {
			s_xm = new String(bytes, "utf-8");
		}
		RyjbxxVO VO = ryjbxxManager.getRyjbxxVOByXmFy(fydm, s_xm);
		RolesUtil.getUserContext(request).setHidden(true);
		if (VO == null) {
			errmsg = "未找到该人员，请联系管理员！";
			model.addAttribute(errmsg,"errmsg");
			return "error";
		} else {
			String showKey = NFyRybhCodeUtils.encode(Integer.valueOf(fydm),
					VO.getNRybh());
			String[] code = NFyRybhCodeUtils.decode(showKey);
			RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
					Integer.valueOf(code[1]), ryjbxxService, dmService);
			model.addAttribute("ryxx1", VO);
			model.addAttribute("type", "ryjbxx");
			model.addAttribute("index", "ryjbxx");
			model.addAttribute("showKey", showKey);
			return "ryjbxx/ryjbxx";
		}
	}
	
	/**
	 * 检查签名
	 * @param request web请求
	 * @throws SignatureException 
	 */
	private void checkSign(HttpServletRequest request) throws SignatureException{
		Properties property = ParameterUtil.getInputs(request);
		String sign = property.getProperty("sign", null);
		if(sign==null){
			throw new ExterfaceException("签名为空");
		}
		property.remove("sign");
		String xm = request.getParameter("xm");
		String  count = request.getParameter("count");
		byte[] bytes;
		String s_xm = "";
		try {
			bytes = xm.getBytes("iso-8859-1");
			if ((bytes.length == 4 && "2".equals(count))
					|| (bytes.length == 6 && "3".equals(count))) {
				s_xm = new String(bytes, "GBK");
			} else {
				s_xm = new String(bytes, "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		property.remove("xm");
		property.put("xm", s_xm);
		
		String content = ParameterUtil.getSignData(property);
		
		logger.warn("签名内容为："+content+"签名为："+sign);
		boolean checked = md5Signature.check(content, sign, SignKey.KEY,"UTF-8");
		
		if(!checked){
			logger.warn("签名检查不过。内容为："+content+";签名为："+sign);
			throw new ExterfaceException("签名检查不过");
		}
	}
	/**
	 * @param md5Signature the md5Signature to set
	 */
	public void setMd5Signature(Signature md5Signature) {
		this.md5Signature = md5Signature;
	}

	@RequestMapping(value = "/addryjbxx.do", method = RequestMethod.GET)
	public String addRyjbxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		int fydm = Integer.valueOf(request.getParameter("fydm"));
		int rybh = ryjbxxService.getMaxRybhByFydm(fydm);
		String showKey = NFyRybhCodeUtils.encode(fydm, rybh);
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<Jgxx> jgxxs = jgxxService.bmByFyId(Integer.valueOf(Integer
				.valueOf(code[0])));
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
		model.addAttribute("jgxxs", jgxxs);
		model.addAttribute("type", "ryjbxx");
		model.addAttribute("index", "ryjbxx");
		model.addAttribute("showKey", showKey);
		return "ryjbxx/editryjbxx";
	}

	@RequestMapping(value = "/delPhoto.aj", method = RequestMethod.POST)
	public void DeletePhoto(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		int result = ryjbxxService.delRysxPhoto(code[0], code[1]) ? 0 : 1;
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/daochuPhoto.aj", method = RequestMethod.GET)
	public void daochuPhoto(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		RysxPhoto rysxPhoto = ryjbxxService.getRysxPhoto(code[0], code[1]);
		String dirPath = getDirPath();
		String sorPath = dirPath + code[0] + code[1] + ".png";
		if (rysxPhoto != null) {
			File file = new File(sorPath);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			FileOutputStream outputStream = new FileOutputStream(file);
			byte[] photo = rysxPhoto.getIPhoto();
			outputStream.write(photo);
			outputStream.flush();
			outputStream.close();
		}
		downloadFile(sorPath, request, response);
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

	private String getDirPath() {
		return System.getProperty("web.fyrs.root") + "resources\\images\\";
	}

	@RequestMapping(value = "/editryjbxx.do", method = RequestMethod.GET)
	public String editRyjbxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		RyjbxxVO VO = ryjbxxManager.getJbxxVOByRybhFy(Integer.valueOf(code[1]),
				Integer.valueOf(code[0]));
		if (VO == null) {
			return "ryjbxx/ryjbxx";
		} else {
			List<Jgxx> jgxxs = jgxxService.bmByFyId(Integer.valueOf(Integer
					.valueOf(code[0])));
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
			model.addAttribute("jgxxs", jgxxs);
			model.addAttribute("ryxx1", VO);
			model.addAttribute("type", "ryjbxx");
			model.addAttribute("index", "ryjbxx");
			model.addAttribute("showKey", showKey);
			return "ryjbxx/editryjbxx";
		}
	}

	@RequestMapping(value = "/saveryjbxx.aj", method = RequestMethod.POST)
	public void saveRyjbxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		int rybh = Integer.valueOf(code[1]);
		int fydm = Integer.valueOf(code[0]);
		RyjbxxVO VO = new RyjbxxVO();
		BeanUtilsEx.populate(VO, request.getParameterMap());
		ryjbxxManager.updateRyjbxx(VO, rybh, fydm);
	}

	@RequestMapping(value = "/ryjbxx.do", method = RequestMethod.GET)
	public String showRyjbxxGet(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		return showRyjbxx(request, response, model);

	}

	// 关于政治面貌的增删查改的请求
	@RequestMapping(value = "/zzmm.do", method = RequestMethod.GET)
	public String showZzmm(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<ZzmmVO> zzmmVOs = ryjbxxManager.getZzmmByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		model.addAttribute("zzmmList", zzmmVOs);
		model.addAttribute("index", "zzmm");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/zzmm";
	}

	@RequestMapping(value = "/zzmm.aj", method = RequestMethod.POST)
	public String showPopZzmm(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		String btnType = request.getParameter("btnType");
		ZzmmVO VO = new ZzmmVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsZzmmById(keyid, fydm, rybh);
		}
		List<DmCommonVO> dmSF = DmCommonList.listDmCommonVO(dmService,
				ConstantsFyrs.NBXH_SF + "");
		List<DmCommonVO> dmZZMM = DmCommonList.listDmCommonVO(dmService,
				ConstantsFyrs.NBXH_ZZMM + "");
		model.addAttribute("listDmZzmm", dmZZMM);
		model.addAttribute("listDm", dmSF);
		model.addAttribute("zzmm", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_zzmm";
	}

	@RequestMapping(value = "/deleteZzmm.aj", method = RequestMethod.POST)
	public void deleteZzmm(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");

		result = ryjbxxManager.delRsZzmmById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addZzmm.aj", method = RequestMethod.POST)
	public void addZzmm(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		ZzmmVO vo = new ZzmmVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		ZzmmVO zzmmVO = new ZzmmVO();
		zzmmVO = ryjbxxManager.addZzmm(vo);
		if (zzmmVO.getDJrrq() == null) {
			zzmmVO.setDJrrq("");
		}
		if (zzmmVO.getDZzrq() == null) {
			zzmmVO.setDZzrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, zzmmVO);
	}

	@RequestMapping(value = "/saveZzmm.aj", method = RequestMethod.POST)
	public void saveZzmm(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		ZzmmVO vo = new ZzmmVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		ZzmmVO zzmmVO = new ZzmmVO();
		zzmmVO = ryjbxxManager.updateRsZzmm(vo);
		if (zzmmVO.getDJrrq() == null) {
			zzmmVO.setDJrrq("");
		}
		if (zzmmVO.getDZzrq() == null) {
			zzmmVO.setDZzrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, zzmmVO);
	}

	// 关于职级信息的增删查改的请求
	@RequestMapping(value = "/zjxx.do", method = RequestMethod.GET)
	public String showZjxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<ZjxxVO> zjxxVOs = ryjbxxManager.getZjxxByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		model.addAttribute("zjxxList", zjxxVOs);
		model.addAttribute("index", "zjxx");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/zjxx";
	}
	
	@RequestMapping(value = "/zjxx.aj", method = RequestMethod.POST)
	public String showPopZjxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		ZjxxVO VO = new ZjxxVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsZjxxById(keyid, fydm, rybh);
		}
		List<Dm> listDmRmlb = ryjbxxManager.getDmListByName("任免类别");
		List<Dm> listDmZj = ryjbxxManager.getDmListByName("职级");
		List<Dm> listDmZjxz = ryjbxxManager.getDmListByName("职级性质");
		List<Dm> listDmRmyy = ryjbxxManager.getDmListByName("任免原因");
		List<Dm> listDmSf = ryjbxxManager.getDmListByName("是否");
		model.addAttribute("listDmRmlb", listDmRmlb);
		model.addAttribute("listDmZj", listDmZj);
		model.addAttribute("listDmZjxz", listDmZjxz);
		model.addAttribute("listDmRmyy", listDmRmyy);
		model.addAttribute("listDmSf", listDmSf);
		model.addAttribute("zjxx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_zjxx";
	}
	
	@RequestMapping(value = "/deleteZjxx.aj", method = RequestMethod.POST)
	public void deleteZjxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");

		result = ryjbxxManager.delRsZjxxById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addZjxx.aj", method = RequestMethod.POST)
	public void addZjxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		ZjxxVO vo = new ZjxxVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		ZjxxVO zjxxVO = new ZjxxVO();
		zjxxVO = ryjbxxManager.addZjxx(vo);
		
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, zjxxVO);
	}

	@RequestMapping(value = "/saveZjxx.aj", method = RequestMethod.POST)
	public void saveZjxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		ZjxxVO vo = new ZjxxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		ZjxxVO zjxxVO = new ZjxxVO();
		zjxxVO = ryjbxxManager.updateRsZjxx(vo);
		
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, zjxxVO);
	}

	
	// 关于行政职务
	@RequestMapping(value = "/xzzw.do", method = RequestMethod.GET)
	public String showXzzw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<XzzwVO> xzzwVOs = ryjbxxManager.getXzzwByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		model.addAttribute("xzzwList", xzzwVOs);
		model.addAttribute("index", "xzzw");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/xzzw";

	}

	@RequestMapping(value = "/xzzw.aj", method = RequestMethod.POST)
	public String showPopXzzw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		String btnType = request.getParameter("btnType");
		XzzwVO VO = new XzzwVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsXzzwById(keyid, fydm, rybh);
		}
		List<Dm> listDmXzzw = ryjbxxManager.getDmListByName("行政职务");
		model.addAttribute("listDmXzzw", listDmXzzw);
		model.addAttribute("xzzw", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_xzzw";

	}

	@RequestMapping(value = "/deleteXzzw.aj", method = RequestMethod.POST)
	public void deleteXzzw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsXzzwById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addXzzw.aj", method = RequestMethod.POST)
	public void addXzzw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		XzzwVO vo = new XzzwVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		XzzwVO xzzwVO = new XzzwVO();
		xzzwVO = ryjbxxManager.addXzzw(vo);
		if (xzzwVO.getDRmrq() == null) {
			xzzwVO.setDRmrq("");
		}
		if (xzzwVO.getDPzrq() == null) {
			xzzwVO.setDPzrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, xzzwVO);
	}

	@RequestMapping(value = "/saveXzzw.aj", method = RequestMethod.POST)
	public void saveXzzw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		XzzwVO vo = new XzzwVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		XzzwVO xzzwVO = new XzzwVO();
		xzzwVO = ryjbxxManager.updateRsXzzw(vo);
		if (xzzwVO.getDRmrq() == null) {
			xzzwVO.setDRmrq("");
		}
		if (xzzwVO.getDPzrq() == null) {
			xzzwVO.setDPzrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, xzzwVO);
	}

	// 关于法律职务
	@RequestMapping(value = "/flzw.do", method = RequestMethod.GET)
	public String showFlzw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<FlzwVO> flzwVOs = ryjbxxManager.getFlzwByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));//
		model.addAttribute("flzwList", flzwVOs);
		model.addAttribute("index", "flzw");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/flzw";

	}

	@RequestMapping(value = "/flzw.aj", method = RequestMethod.POST)
	public String showPopFlzw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		FlzwVO VO = new FlzwVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsFlzwById(keyid, fydm, rybh);
		}
		model.addAttribute("flzw", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_flzw";
	}

	@RequestMapping(value = "/deleteFlzw.aj", method = RequestMethod.POST)
	public void deleteFlzw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsFlzwById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addFlzw.aj", method = RequestMethod.POST)
	public void addFlzw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		FlzwVO vo = new FlzwVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		FlzwVO flzwVO = new FlzwVO();
		flzwVO = ryjbxxManager.addFlzw(vo);
		if (flzwVO.getDRmrq() == null) {
			flzwVO.setDRmrq("");
		}
		if (flzwVO.getDPzrq() == null) {
			flzwVO.setDPzrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, flzwVO);
	}

	@RequestMapping(value = "/saveFlzw.aj", method = RequestMethod.POST)
	public void saveFlzw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		FlzwVO vo = new FlzwVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		FlzwVO flzwVO = new FlzwVO();
		flzwVO = ryjbxxManager.updateRsFlzw(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, flzwVO);
	}

	// 学历信息
	@RequestMapping(value = "/xlxx.do", method = RequestMethod.GET)
	public String showXlxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<XlxxVO> xlxxVOs = ryjbxxManager.getXlxxByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));//
		model.addAttribute("xlxxList", xlxxVOs);
		model.addAttribute("index", "xlxx");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/xlxx";

	}

	@RequestMapping(value = "/xlxx.aj", method = RequestMethod.POST)
	public String showPopXlxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		XlxxVO VO = new XlxxVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsXlxxById(keyid, fydm, rybh);
		}
		List<Dm> listDmXl = ryjbxxManager.getDmListByName("文化程度");
		List<Dm> listDmSxzy = ryjbxxManager.getDmListByName("专业");
		List<Dm> listDmJyxs = ryjbxxManager.getDmListByName("教育形式");
		List<Dm> listDmXxxs = ryjbxxManager.getDmListByName("学习形式");
		List<Dm> listDmXxszgj = ryjbxxManager.getDmListByName("国家");
		List<Dm> listDmJyxl = ryjbxxManager.getDmListByName("是否");
		List<Dm> listDmXxlb = ryjbxxManager.getDmListByName("培训机构");
		model.addAttribute("listDmXxlb", listDmXxlb);
		model.addAttribute("listDmJyxl", listDmJyxl);
		model.addAttribute("listDmXxszgj", listDmXxszgj);
		model.addAttribute("listDmXxxs", listDmXxxs);
		model.addAttribute("listDmJyxs", listDmJyxs);
		model.addAttribute("listDmSxzy", listDmSxzy);
		model.addAttribute("listDmXl", listDmXl);
		model.addAttribute("xlxx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_xlxx";
	}

	@RequestMapping(value = "/deleteXlxx.aj", method = RequestMethod.POST)
	public void deleteXlxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsXlxxById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addXlxx.aj", method = RequestMethod.POST)
	public void addXlxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		XlxxVO vo = new XlxxVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		XlxxVO xlxxVO = new XlxxVO();
		xlxxVO = ryjbxxManager.addXlxx(vo);
		if (xlxxVO.getDByrq() == null) {
			xlxxVO.setDByrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, xlxxVO);
	}

	@RequestMapping(value = "/saveXlxx.aj", method = RequestMethod.POST)
	public void saveXlxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		XlxxVO vo = new XlxxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		XlxxVO xlxxVO = new XlxxVO();
		xlxxVO = ryjbxxManager.updateRsXlxx(vo);
		if (xlxxVO.getDByrq() == null) {
			xlxxVO.setDByrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, xlxxVO);
	}

	// 学位信息
	@RequestMapping(value = "/xwxx.do", method = RequestMethod.GET)
	public String showXwxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<XwxxVO> xwxxVOs = ryjbxxManager.getXwxxByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));//
		model.addAttribute("xwxxList", xwxxVOs);
		model.addAttribute("index", "xwxx");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/xwxx";

	}

	@RequestMapping(value = "/xwxx.aj", method = RequestMethod.POST)
	public String showPopXwxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		XwxxVO VO = new XwxxVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsXwxxById(keyid, fydm, rybh);
		}
		List<Dm> listDmXw = ryjbxxManager.getDmListByName("学位");
		List<Dm> listDmSxzy = ryjbxxManager.getDmListByName("专业");
		List<Dm> listDmJyxs = ryjbxxManager.getDmListByName("教育形式");
		List<Dm> listDmXxxs = ryjbxxManager.getDmListByName("学习形式");
		List<Dm> listDmSygj = ryjbxxManager.getDmListByName("国家");
		List<Dm> listDmXxlb = ryjbxxManager.getDmListByName("培训机构");
		model.addAttribute("listDmXxlb", listDmXxlb);
		model.addAttribute("listDmXw", listDmXw);
		model.addAttribute("listDmSxzy", listDmSxzy);
		model.addAttribute("listDmXxxs", listDmXxxs);
		model.addAttribute("listDmJyxs", listDmJyxs);
		model.addAttribute("listDmSygj", listDmSygj);
		model.addAttribute("xwxx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_xwxx";
	}

	@RequestMapping(value = "/deleteXwxx.aj", method = RequestMethod.POST)
	public void deleteXwxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsXwxxById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addXwxx.aj", method = RequestMethod.POST)
	public void addXwxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		XwxxVO vo = new XwxxVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		XwxxVO xwxxVO = new XwxxVO();
		xwxxVO = ryjbxxManager.addXwxx(vo);
		if (xwxxVO.getDByrq() == null) {
			xwxxVO.setDByrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, xwxxVO);
	}

	@RequestMapping(value = "/saveXwxx.aj", method = RequestMethod.POST)
	public void saveXwxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		XwxxVO vo = new XwxxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		XwxxVO xwxxVO = new XwxxVO();
		xwxxVO = ryjbxxManager.updateRsXwxx(vo);
		if (xwxxVO.getDByrq() == null) {
			xwxxVO.setDByrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, xwxxVO);
	}

	// 简历信息
	@RequestMapping(value = "/jlxx.do", method = RequestMethod.GET)
	public String showJlxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<JlxxVO> jlxxVOs = ryjbxxManager.getJlxxByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));//
		model.addAttribute("jlxxList", jlxxVOs);
		model.addAttribute("index", "jlxx");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/jlxx";

	}

	@RequestMapping(value = "/jlxx.aj", method = RequestMethod.POST)
	public String showPopJlxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		JlxxVO VO = new JlxxVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsJlxxById(keyid, fydm, rybh);
		}
		model.addAttribute("jlxx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_jlxx";
	}

	@RequestMapping(value = "/deleteJlxx.aj", method = RequestMethod.POST)
	public void deleteJlxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsJlxxById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addJlxx.aj", method = RequestMethod.POST)
	public void addJlxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		JlxxVO vo = new JlxxVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		JlxxVO jlxxVO = new JlxxVO();
		jlxxVO = ryjbxxManager.addJlxx(vo);
		if (jlxxVO.getDQsrq() == null) {
			jlxxVO.setDQsrq("");
		}
		if (jlxxVO.getDJzrq() == null) {
			jlxxVO.setDJzrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, jlxxVO);
	}

	@RequestMapping(value = "/saveJlxx.aj", method = RequestMethod.POST)
	public void saveJlxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		JlxxVO vo = new JlxxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		JlxxVO jlxxVO = new JlxxVO();
		jlxxVO = ryjbxxManager.updateRsJlxx(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, jlxxVO);
	}

	// 家庭信息
	@RequestMapping(value = "/jtxx.do", method = RequestMethod.GET)
	public String showJtxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<JtxxVO> jtxxVOs = ryjbxxManager.getJtxxByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));//
		model.addAttribute("jtxxList", jtxxVOs);
		model.addAttribute("index", "jtxx");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/jtxx";

	}

	@RequestMapping(value = "/jtxx.aj", method = RequestMethod.POST)
	public String showPopJtxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		JtxxVO VO = new JtxxVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsJtxxById(keyid, fydm, rybh);
		}
		List<Dm> listDmJtgx = ryjbxxManager.getDmListByName("家庭关系");
		List<Dm> listDmZzmm = ryjbxxManager.getDmListByName("政治面貌");
		model.addAttribute("listDmZzmm", listDmZzmm);
		model.addAttribute("listDmJtgx", listDmJtgx);
		model.addAttribute("jtxx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_jtxx";
	}

	@RequestMapping(value = "/deleteJtxx.aj", method = RequestMethod.POST)
	public void deleteJtxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsJtxxById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addJtxx.aj", method = RequestMethod.POST)
	public void addJtxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		JtxxVO vo = new JtxxVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		JtxxVO jtxxVO = new JtxxVO();
		jtxxVO = ryjbxxManager.addJtxx(vo);
		if (jtxxVO.getDCsrq() == null) {
			jtxxVO.setDCsrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, jtxxVO);
	}

	@RequestMapping(value = "/saveJtxx.aj", method = RequestMethod.POST)
	public void saveJtxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		JtxxVO vo = new JtxxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		JtxxVO jtxxVO = new JtxxVO();
		jtxxVO = ryjbxxManager.updateRsJtxx(vo);
		if (jtxxVO.getDCsrq() == null) {
			jtxxVO.setDCsrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, jtxxVO);
	}

	// 考核信息
	@RequestMapping(value = "/khxx.do", method = RequestMethod.GET)
	public String showKhxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<KhxxVO> KhxxVOs = ryjbxxManager.getKhxxByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));//
		model.addAttribute("khxxList", KhxxVOs);
		model.addAttribute("index", "khxx");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/khxx";
	}

	@RequestMapping(value = "/khxx.aj", method = RequestMethod.POST)
	public String showPopKhxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		KhxxVO VO = new KhxxVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsKhxxById(keyid, fydm, rybh);
		}
		List<Dm> listDmKhjg = ryjbxxManager.getDmListByName("考核");
		model.addAttribute("listDmKhjg", listDmKhjg);
		model.addAttribute("khxx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_khxx";
	}

	@RequestMapping(value = "/deleteKhxx.aj", method = RequestMethod.POST)
	public void deleteKhxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsKhxxById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addKhxx.aj", method = RequestMethod.POST)
	public void addKhxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		KhxxVO vo = new KhxxVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		KhxxVO khxxVO = new KhxxVO();
		khxxVO = ryjbxxManager.addKhxx(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, khxxVO);
	}

	@RequestMapping(value = "/saveKhxx.aj", method = RequestMethod.POST)
	public void saveKhxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		KhxxVO vo = new KhxxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		KhxxVO khxxVO = new KhxxVO();
		khxxVO = ryjbxxManager.updateRsKhxx(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, khxxVO);
	}

	// 奖励信息
	@RequestMapping(value = "/jlixx.do", method = RequestMethod.GET)
	public String showjlixx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<JlixxVO> jlixxVOs = ryjbxxManager.getJlixxByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));//
		model.addAttribute("jlixxList", jlixxVOs);
		model.addAttribute("index", "jlixx");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/jlixx";
	}

	@RequestMapping(value = "/jlixx.aj", method = RequestMethod.POST)
	public String showPopJlixx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		JlixxVO VO = new JlixxVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsJlixxById(keyid, fydm, rybh);
		}
		List<Dm> listDmJljb = ryjbxxManager.getDmListByName("奖励级别");
		List<Dm> listDmJlyy = ryjbxxManager.getDmListByName("奖励原因");
		List<Dm> listDmJllb = ryjbxxManager.getDmListByName("个人奖励类别");
		List<Dm> listDmGrqk = ryjbxxManager.getDmListByName("个人情况");
		model.addAttribute("listDmGrqk", listDmGrqk);
		model.addAttribute("listDmJllb", listDmJllb);
		model.addAttribute("listDmJlyy", listDmJlyy);
		model.addAttribute("listDmJljb", listDmJljb);
		model.addAttribute("jlixx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_jlixx";
	}

	@RequestMapping(value = "/deleteJlixx.aj", method = RequestMethod.POST)
	public void deleteJlixx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsJlixxById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addJlixx.aj", method = RequestMethod.POST)
	public void addJlixx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		JlixxVO vo = new JlixxVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		JlixxVO jlixxVO = new JlixxVO();
		jlixxVO = ryjbxxManager.addJlixx(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, jlixxVO);
	}

	@RequestMapping(value = "/saveJlixx.aj", method = RequestMethod.POST)
	public void saveJlixx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		JlixxVO vo = new JlixxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		JlixxVO jlixxVO = new JlixxVO();
		jlixxVO = ryjbxxManager.updateRsJlixx(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, jlixxVO);
	}

	// 司法考试
	@RequestMapping(value = "/sfks.do", method = RequestMethod.GET)
	public String showSfks(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<SfksVO> sfksVOs = ryjbxxManager.getSfksByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));//
		model.addAttribute("sfksVOList", sfksVOs);
		model.addAttribute("index", "sfks");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/sfks";
	}

	@RequestMapping(value = "/sfks.aj", method = RequestMethod.POST)
	public String showPopSfks(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		SfksVO VO = new SfksVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsSfksById(keyid, fydm, rybh);
		}
		List<Dm> listDmZslx = ryjbxxManager.getDmListByName("法律职业资格证书类型");
		model.addAttribute("listDmZslx", listDmZslx);
		model.addAttribute("sfks", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_sfks";
	}

	@RequestMapping(value = "/deleteSfks.aj", method = RequestMethod.POST)
	public void deleteSfks(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsSfksById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addSfks.aj", method = RequestMethod.POST)
	public void addSfks(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		SfksVO vo = new SfksVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		SfksVO sfksVO = new SfksVO();
		sfksVO = ryjbxxManager.addSfks(vo);
		if (sfksVO.getDBzrq() == null) {
			sfksVO.setDBzrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, sfksVO);
	}

	@RequestMapping(value = "/saveSfks.aj", method = RequestMethod.POST)
	public void saveSfks(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		SfksVO vo = new SfksVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		SfksVO sfksVO = new SfksVO();
		sfksVO = ryjbxxManager.updateRsSfks(vo);
		if (sfksVO.getDBzrq() == null) {
			sfksVO.setDBzrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, sfksVO);
	}

	// 交流信息
	@RequestMapping(value = "/jliuxx.do", method = RequestMethod.GET)
	public String showJliuxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<JliuxxVO> jliuxxVOs = ryjbxxManager.getJliuxxByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));//
		model.addAttribute("jliuxxList", jliuxxVOs);
		model.addAttribute("index", "jliuxx");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/jliuxx";
	}

	@RequestMapping(value = "/jliuxx.aj", method = RequestMethod.POST)
	public String showPopJliuxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		JliuxxVO VO = new JliuxxVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsJliuxxById(keyid, fydm, rybh);
		}
		List<Dm> listDmJllb = ryjbxxManager.getDmListByName("交流类别");
		List<Dm> listDmJlfs = ryjbxxManager.getDmListByName("交流方式");
		List<Dm> listDmJlzwxz = ryjbxxManager.getDmListByName("交流职务");
		model.addAttribute("listDmJlzwxz", listDmJlzwxz);
		model.addAttribute("listDmJlfs", listDmJlfs);
		model.addAttribute("listDmJllb", listDmJllb);
		model.addAttribute("jliuxx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_jliuxx";
	}

	@RequestMapping(value = "/deleteJliuxx.aj", method = RequestMethod.POST)
	public void deleteJliuxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsJliuxxById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addJliuxx.aj", method = RequestMethod.POST)
	public void addJliuxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		JliuxxVO vo = new JliuxxVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		JliuxxVO jliuxxVO = new JliuxxVO();
		jliuxxVO = ryjbxxManager.addJliuxx(vo);
		if (jliuxxVO.getDJsrq() == null) {
			jliuxxVO.setDJsrq("");
		}
		if (jliuxxVO.getDKsrq() == null) {
			jliuxxVO.setDKsrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, jliuxxVO);
	}

	@RequestMapping(value = "/saveJliuxx.aj", method = RequestMethod.POST)
	public void saveJliuxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		JliuxxVO vo = new JliuxxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		JliuxxVO jliuxxVO = new JliuxxVO();
		jliuxxVO = ryjbxxManager.updateRsJliuxx(vo);
		if (jliuxxVO.getDJsrq() == null) {
			jliuxxVO.setDJsrq("");
		}
		if (jliuxxVO.getDKsrq() == null) {
			jliuxxVO.setDKsrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, jliuxxVO);
	}

	// 培训信息
	@RequestMapping(value = "/pxxx.do", method = RequestMethod.GET)
	public String showPxxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<PxxxVO> pxxxVOs = ryjbxxManager.getPxxxByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));//
		model.addAttribute("pxxxList", pxxxVOs);
		model.addAttribute("index", "pxxx");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/pxxx";
	}

	@RequestMapping(value = "/pxxx.aj", method = RequestMethod.POST)
	public String showPopPxxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		PxxxVO VO = new PxxxVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsPxxxById(keyid, fydm, rybh);
		}
		List<Dm> listDmPxxs = ryjbxxManager.getDmListByName("学习形式");
		List<Dm> listDmPxzl = ryjbxxManager.getDmListByName("培训种类");
		List<Dm> listDmZy = ryjbxxManager.getDmListByName("专业");
		List<Dm> listDmPxfs = ryjbxxManager.getDmListByName("培训方式");
		List<Dm> listDmJgzl = ryjbxxManager.getDmListByName("培训机构");
		model.addAttribute("listDmPxzl", listDmPxzl);
		model.addAttribute("listDmPxfs", listDmPxfs);
		model.addAttribute("listDmZy", listDmZy);
		model.addAttribute("listDmJgzl", listDmJgzl);
		model.addAttribute("listDmPxxs", listDmPxxs);
		model.addAttribute("pxxx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_pxxx";
	}

	@RequestMapping(value = "/deletePxxx.aj", method = RequestMethod.POST)
	public void deletePxxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsPxxxById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addPxxx.aj", method = RequestMethod.POST)
	public void addPxxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		PxxxVO vo = new PxxxVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		PxxxVO pxxxVO = new PxxxVO();
		pxxxVO = ryjbxxManager.addPxxx(vo);
		if (pxxxVO.getDJsrq() == null) {
			pxxxVO.setDJsrq("");
		}
		if (pxxxVO.getDKsrq() == null) {
			pxxxVO.setDKsrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, pxxxVO);
	}

	@RequestMapping(value = "/savePxxx.aj", method = RequestMethod.POST)
	public void savePxxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		PxxxVO vo = new PxxxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		PxxxVO pxxxVO = new PxxxVO();
		pxxxVO = ryjbxxManager.updateRsPxxx(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, pxxxVO);
	}

	// 人才信息
	@RequestMapping(value = "/rcxx.do", method = RequestMethod.GET)
	public String showRcxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<RcxxVO> rcxxVOs = ryjbxxManager.getRcxxByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		model.addAttribute("rcxxList", rcxxVOs);
		model.addAttribute("index", "rcxx");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/rcxx";
	}

	@RequestMapping(value = "/rcxx.aj", method = RequestMethod.POST)
	public String showPopRcxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		RcxxVO VO = new RcxxVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsRcxxById(keyid, fydm, rybh);
		}
		List<Dm> listDmBm = ryjbxxManager.getDmListByName("内设机构");
		List<Dm> listDmRclx = ryjbxxManager.getDmListByName("人才信息");
		model.addAttribute("listDmBm", listDmBm);
		model.addAttribute("listDmRclx", listDmRclx);
		model.addAttribute("rcxx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_rcxx";
	}

	@RequestMapping(value = "/deleteRcxx.aj", method = RequestMethod.POST)
	public void deleteRcxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsRcxxById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addRcxx.aj", method = RequestMethod.POST)
	public void addRcxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		RcxxVO vo = new RcxxVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		RcxxVO rcxxVO = new RcxxVO();
		rcxxVO = ryjbxxManager.addRcxx(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, rcxxVO);
	}

	@RequestMapping(value = "/saveRcxx.aj", method = RequestMethod.POST)
	public void saveRcxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		RcxxVO vo = new RcxxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		RcxxVO rcxxVO = new RcxxVO();
		rcxxVO = ryjbxxManager.updateRsRcxx(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, rcxxVO);
	}

	// 等级信息
	@RequestMapping(value = "/djxx.do", method = RequestMethod.GET)
	public String showDjxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<DjxxVO> djxxVOs = ryjbxxManager.getDjxxByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		model.addAttribute("djxxList", djxxVOs);
		model.addAttribute("index", "djxx");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/djxx";
	}

	@RequestMapping(value = "/djxx.aj", method = RequestMethod.POST)
	public String showPopDjxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		DjxxVO VO = new DjxxVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsDjxxById(keyid, fydm, rybh);
		}
		List<Dm> listDmDjbdlb = ryjbxxManager.getDmListByName("等级变动类别");
		List<Dm> listDmDjbdyy = ryjbxxManager.getDmListByName("等级变动原因");
		List<Dm> listDmDjlb = ryjbxxManager.getDmListByName("等级类别");
		List<Dm> listDmDj = ryjbxxManager.getDmListByName("等级");
		model.addAttribute("listDmDjbdlb", listDmDjbdlb);
		model.addAttribute("listDmDjbdyy", listDmDjbdyy);
		model.addAttribute("listDmDjlb", listDmDjlb);
		model.addAttribute("listDmDj", listDmDj);
		model.addAttribute("djxx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_djxx";
	}

	@RequestMapping(value = "/deleteDjxx.aj", method = RequestMethod.POST)
	public void deleteDjxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsDjxxById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addDjxx.aj", method = RequestMethod.POST)
	public void addDjxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		DjxxVO vo = new DjxxVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		DjxxVO djxxVO = new DjxxVO();
		djxxVO = ryjbxxManager.addDjxx(vo);
		if (djxxVO.getDQsrq() == null) {
			djxxVO.setDQsrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, djxxVO);
	}

	@RequestMapping(value = "/saveDjxx.aj", method = RequestMethod.POST)
	public void saveDjxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		DjxxVO vo = new DjxxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		DjxxVO djxxVO = new DjxxVO();
		djxxVO = ryjbxxManager.updateRsDjxx(vo);
		if (djxxVO.getDQsrq() == null) {
			djxxVO.setDQsrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, djxxVO);
	}

	// 公务员级别
	@RequestMapping(value = "/gwyjb.do", method = RequestMethod.GET)
	public String showGwyjb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<GwyjbVO> gwyjbVOs = ryjbxxManager.getGwyjbByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		model.addAttribute("gwyjbList", gwyjbVOs);
		model.addAttribute("index", "gwyjb");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/gwyjb";
	}

	@RequestMapping(value = "/gwyjb.aj", method = RequestMethod.POST)
	public String showPopGwyjb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		GwyjbVO VO = new GwyjbVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsGwyjbById(keyid, fydm, rybh);
		}
		List<Dm> listDmGwyjb = ryjbxxManager.getDmListByName("公务员级别");
		List<Dm> listDmGzdc = ryjbxxManager.getDmListByName("工资档次");
		model.addAttribute("listDmGzdc", listDmGzdc);
		model.addAttribute("listDmGwyjb", listDmGwyjb);
		model.addAttribute("gwyjb", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_gwyjb";
	}

	@RequestMapping(value = "/deleteGwyjb.aj", method = RequestMethod.POST)
	public void deleteGwyjb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsGwyjbById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addGwyjb.aj", method = RequestMethod.POST)
	public void addGwyjb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		GwyjbVO vo = new GwyjbVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		GwyjbVO gwyjbVO = new GwyjbVO();
		gwyjbVO = ryjbxxManager.addGwyjb(vo);
		if (gwyjbVO.getDQsrq() == null) {
			gwyjbVO.setDQsrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, gwyjbVO);
	}

	@RequestMapping(value = "/saveGwyjb.aj", method = RequestMethod.POST)
	public void saveGwyjb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		GwyjbVO vo = new GwyjbVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		GwyjbVO gwyjbVO = new GwyjbVO();
		gwyjbVO = ryjbxxManager.updateRsGwyjb(vo);
		if (gwyjbVO.getDQsrq() == null) {
			gwyjbVO.setDQsrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, gwyjbVO);
	}

	// 专业技术职务
	@RequestMapping(value = "/zyjszw.do", method = RequestMethod.GET)
	public String showZyjszw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<ZyjszwVO> zyjszwVOs = ryjbxxManager.getZyjszwByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		model.addAttribute("zyjszwVOList", zyjszwVOs);
		model.addAttribute("index", "zyjszw");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/zyjszw";
	}

	@RequestMapping(value = "/zyjszw.aj", method = RequestMethod.POST)
	public String showPopZyjszw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		ZyjszwVO VO = new ZyjszwVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsZyjszwById(keyid, fydm, rybh);
		}
		List<Dm> listDmQdmc = ryjbxxManager.getDmListByName("聘任名称");
		List<Dm> listDmZyjstj = ryjbxxManager.getDmListByName("专业技术途径");
		List<Dm> listDmPrmc = ryjbxxManager.getDmListByName("聘任名称");
		List<Dm> listDmZcdj = ryjbxxManager.getDmListByName("职称等级");
		model.addAttribute("listDmZcdj", listDmZcdj);
		model.addAttribute("listDmPrmc", listDmPrmc);
		model.addAttribute("listDmZyjstj", listDmZyjstj);
		model.addAttribute("listDmQdmc", listDmQdmc);
		model.addAttribute("zyjszw", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_zyjszw";
	}

	@RequestMapping(value = "/deleteZyjszw.aj", method = RequestMethod.POST)
	public void deleteZyjszw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsZyjszwById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addZyjszw.aj", method = RequestMethod.POST)
	public void addZyjszw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		ZyjszwVO vo = new ZyjszwVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		ZyjszwVO zyjszwVO = new ZyjszwVO();
		zyjszwVO = ryjbxxManager.addZyjszw(vo);
		if (zyjszwVO.getDPrrq() == null) {
			zyjszwVO.setDPrrq("");
		}
		if (zyjszwVO.getDQdrq() == null) {
			zyjszwVO.setDQdrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, zyjszwVO);
	}

	@RequestMapping(value = "/saveZyjszw.aj", method = RequestMethod.POST)
	public void saveZyjszw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		ZyjszwVO vo = new ZyjszwVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		ZyjszwVO zyjszwVO = new ZyjszwVO();
		zyjszwVO = ryjbxxManager.updateRsZyjszw(vo);
		if (zyjszwVO.getDPrrq() == null) {
			zyjszwVO.setDPrrq("");
		}
		if (zyjszwVO.getDQdrq() == null) {
			zyjszwVO.setDQdrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, zyjszwVO);
	}

	// 兼任职务
	@RequestMapping(value = "/jrzw.do", method = RequestMethod.GET)
	public String showJrzw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<JrzwVO> jrzwVOs = ryjbxxManager.getJrzwByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		model.addAttribute("jrzwList", jrzwVOs);
		model.addAttribute("index", "jrzw");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/jrzw";
	}

	@RequestMapping(value = "/jrzw.aj", method = RequestMethod.POST)
	public String showPopJrzw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		JrzwVO VO = new JrzwVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsJrzwById(keyid, fydm, rybh);
		}
		List<Dm> listDmRmlb = ryjbxxManager.getDmListByName("任免类别");
		List<Dm> listDmRmyy = ryjbxxManager.getDmListByName("任免原因");
		model.addAttribute("listDmRmyy", listDmRmyy);
		model.addAttribute("listDmRmlb", listDmRmlb);
		model.addAttribute("jrzw", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_jrzw";
	}

	@RequestMapping(value = "/deleteJrzw.aj", method = RequestMethod.POST)
	public void deleteJrzw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsJrzwById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addJrzw.aj", method = RequestMethod.POST)
	public void addJrzw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		JrzwVO vo = new JrzwVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		JrzwVO jrzwVO = new JrzwVO();
		jrzwVO = ryjbxxManager.addJrzw(vo);
		if (jrzwVO.getDPzrq() == null) {
			jrzwVO.setDPzrq("");
		}
		if (jrzwVO.getDRmrq() == null) {
			jrzwVO.setDRmrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, jrzwVO);
	}

	@RequestMapping(value = "/saveJrzw.aj", method = RequestMethod.POST)
	public void saveJrzw(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		JrzwVO vo = new JrzwVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		JrzwVO jrzwVO = new JrzwVO();
		jrzwVO = ryjbxxManager.updateRsJrzw(vo);
		if (jrzwVO.getDPzrq() == null) {
			jrzwVO.setDPzrq("");
		}
		if (jrzwVO.getDRmrq() == null) {
			jrzwVO.setDRmrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, jrzwVO);
	}

	// 领导班子
	@RequestMapping(value = "/ldbz.do", method = RequestMethod.GET)
	public String showLdbz(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<LdbzVO> ldbzVOs = ryjbxxManager.getLdbzByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		model.addAttribute("ldbzList", ldbzVOs);
		model.addAttribute("index", "ldbz");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/ldbz";
	}

	@RequestMapping(value = "/ldbz.aj", method = RequestMethod.POST)
	public String showPopLdbz(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		LdbzVO VO = new LdbzVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsLdbzById(keyid, fydm, rybh);
		}
		List<Dm> listDmZw = ryjbxxManager.getDmListByName("职务");
		model.addAttribute("listDmZw", listDmZw);
		model.addAttribute("ldbz", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_ldbz";
	}

	@RequestMapping(value = "/deleteLdbz.aj", method = RequestMethod.POST)
	public void deleteLdbz(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsLdbzById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addLdbz.aj", method = RequestMethod.POST)
	public void addLdbz(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		LdbzVO vo = new LdbzVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		LdbzVO ldbzVO = new LdbzVO();
		ldbzVO = ryjbxxManager.addLdbz(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, ldbzVO);
	}

	@RequestMapping(value = "/saveLdbz.aj", method = RequestMethod.POST)
	public void saveLdbz(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		LdbzVO vo = new LdbzVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		LdbzVO ldbzVO = new LdbzVO();
		ldbzVO = ryjbxxManager.updateRsLdbz(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, ldbzVO);
	}

	// 后备干部
	@RequestMapping(value = "/hbgb.do", method = RequestMethod.GET)
	public String showHbgb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<HbgbVO> hbgbVOs = ryjbxxManager.getHbgbByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		model.addAttribute("hbgbList", hbgbVOs);
		model.addAttribute("index", "hbgb");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/hbgb";
	}

	@RequestMapping(value = "/hbgb.aj", method = RequestMethod.POST)
	public String showPopHbgb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		HbgbVO VO = new HbgbVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsHbgbById(keyid, fydm, rybh);
		}
		List<Dm> listDmZw = ryjbxxManager.getDmListByName("职务");
		model.addAttribute("listDmZw", listDmZw);
		model.addAttribute("hbgb", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_hbgb";
	}

	@RequestMapping(value = "/deleteHbgb.aj", method = RequestMethod.POST)
	public void deleteHbgb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsHbgbById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addHbgb.aj", method = RequestMethod.POST)
	public void addHbgb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		HbgbVO vo = new HbgbVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		HbgbVO hbgbVO = new HbgbVO();
		hbgbVO = ryjbxxManager.addHbgb(vo);
		if (hbgbVO.getDJssj() == null) {
			hbgbVO.setDJssj("");
		}
		if (hbgbVO.getDKssj() == null) {
			hbgbVO.setDKssj("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, hbgbVO);
	}

	@RequestMapping(value = "/saveHbgb.aj", method = RequestMethod.POST)
	public void saveHbgb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		HbgbVO vo = new HbgbVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		HbgbVO hbgbVO = new HbgbVO();
		hbgbVO = ryjbxxManager.updateRsHbgb(vo);
		if (hbgbVO.getDJssj() == null) {
			hbgbVO.setDJssj("");
		}
		if (hbgbVO.getDKssj() == null) {
			hbgbVO.setDKssj("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, hbgbVO);
	}

	// 工资信息
	@RequestMapping(value = "/gzxx.do", method = RequestMethod.GET)
	public String showGzxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<GzxxVO> gzxxVOs = ryjbxxManager.getGzxxByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		model.addAttribute("gzxxList", gzxxVOs);
		model.addAttribute("index", "gzxx");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/gzxx";
	}

	@RequestMapping(value = "/gzxx.aj", method = RequestMethod.POST)
	public String showPopGzxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		GzxxVO VO = new GzxxVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsGzxxById(keyid, fydm, rybh);
		}
		model.addAttribute("gzxx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_gzxx";
	}

	@RequestMapping(value = "/deleteGzxx.aj", method = RequestMethod.POST)
	public void deleteGzxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsGzxxById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addGzxx.aj", method = RequestMethod.POST)
	public void addGzxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		GzxxVO vo = new GzxxVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		GzxxVO gzxxVO = new GzxxVO();
		gzxxVO = ryjbxxManager.addGzxx(vo);
		if (gzxxVO.getDZwgzdcsj() == null) {
			gzxxVO.setDZwgzdcsj("");
		}
		if (gzxxVO.getMZwgze() == null) {
			gzxxVO.setMZwgze("");
		}
		if (gzxxVO.getMJbgze() == null) {
			gzxxVO.setMJbgze("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, gzxxVO);
	}

	@RequestMapping(value = "/saveGzxx.aj", method = RequestMethod.POST)
	public void saveGzxxs(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		GzxxVO vo = new GzxxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		GzxxVO gzxxVO = new GzxxVO();
		gzxxVO = ryjbxxManager.updateRsGzxx(vo);
		if (gzxxVO.getDZwgzdcsj() == null) {
			gzxxVO.setDZwgzdcsj("");
		}
		if (gzxxVO.getMZwgze() == null) {
			gzxxVO.setMZwgze("");
		}
		if (gzxxVO.getMJbgze() == null) {
			gzxxVO.setMJbgze("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, gzxxVO);
	}

	// 惩处信息
	@RequestMapping(value = "/ccxx.do", method = RequestMethod.GET)
	public String showCcxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		List<CcxxVO> ccxxVOs = ryjbxxManager.getCcxxByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		model.addAttribute("ccxxList", ccxxVOs);
		model.addAttribute("index", "ccxx");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/ccxx";
	}

	@RequestMapping(value = "/ccxx.aj", method = RequestMethod.POST)
	public String showPopCcxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		CcxxVO VO = new CcxxVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsCcxxById(keyid, fydm, rybh);
		}
		List<Dm> listDmCclb = ryjbxxManager.getDmListByName("惩罚程度");
		List<Dm> listDmCcyy = ryjbxxManager.getDmListByName("惩罚原因");
		model.addAttribute("listDmCclb", listDmCclb);
		model.addAttribute("listDmCcyy", listDmCcyy);
		model.addAttribute("ccxx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_ccxx";
	}

	@RequestMapping(value = "/deleteCcxx.aj", method = RequestMethod.POST)
	public void deleteCcxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsCcxxById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addCcxx.aj", method = RequestMethod.POST)
	public void addCcxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		CcxxVO vo = new CcxxVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		CcxxVO ccxxVO = new CcxxVO();
		ccxxVO = ryjbxxManager.addCcxx(vo);
		if (ccxxVO.getDCcrq() == null) {
			ccxxVO.setDCcrq("");
		}
		if (ccxxVO.getDJcrq() == null) {
			ccxxVO.setDJcrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, ccxxVO);
	}

	@RequestMapping(value = "/saveCcxx.aj", method = RequestMethod.POST)
	public void saveCcxxs(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		CcxxVO vo = new CcxxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		CcxxVO ccxxVO = new CcxxVO();
		ccxxVO = ryjbxxManager.updateRsCcxx(vo);
		if (ccxxVO.getDCcrq() == null) {
			ccxxVO.setDCcrq("");
		}
		if (ccxxVO.getDJcrq() == null) {
			ccxxVO.setDJcrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, ccxxVO);
	}

	// 伤亡信息
	@RequestMapping(value = "/swxx.do", method = RequestMethod.GET)
	public String showSwxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		List<SwxxVO> swxxVOs = ryjbxxManager.getSwxxByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		model.addAttribute("swxxList", swxxVOs);
		model.addAttribute("index", "swxx");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/swxx";
	}

	@RequestMapping(value = "/swxx.aj", method = RequestMethod.POST)
	public String showPopSwxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		SwxxVO VO = new SwxxVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsSwxxById(keyid, fydm, rybh);
		}
		List<Dm> listDmSwcd = ryjbxxManager.getDmListByName("伤亡程度");
		List<Dm> listDmSwyy = ryjbxxManager.getDmListByName("伤亡原因");
		model.addAttribute("listDmSwcd", listDmSwcd);
		model.addAttribute("listDmSwyy", listDmSwyy);
		model.addAttribute("swxx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_swxx";
	}

	@RequestMapping(value = "/deleteSwxx.aj", method = RequestMethod.POST)
	public void deleteSwxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsSwxxById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addSwxx.aj", method = RequestMethod.POST)
	public void addSwxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		SwxxVO vo = new SwxxVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		SwxxVO swxxVO = new SwxxVO();
		swxxVO = ryjbxxManager.addSwxx(vo);
		if (swxxVO.getDSwrq() == null) {
			swxxVO.setDSwrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, swxxVO);
	}

	@RequestMapping(value = "/saveSwxx.aj", method = RequestMethod.POST)
	public void saveSwxxs(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		SwxxVO vo = new SwxxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		SwxxVO swxxVO = new SwxxVO();
		swxxVO = ryjbxxManager.updateRsSwxx(vo);
		if (swxxVO.getDSwrq() == null) {
			swxxVO.setDSwrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, swxxVO);
	}

	// 在读信息
	@RequestMapping(value = "/zdxx.do", method = RequestMethod.GET)
	public String showZdxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<ZdxxVO> zdxxVOs = ryjbxxManager.getZdxxByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		model.addAttribute("zdxxList", zdxxVOs);
		model.addAttribute("index", "zdxx");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/zdxx";
	}

	@RequestMapping(value = "/zdxx.aj", method = RequestMethod.POST)
	public String showPopZdxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		ZdxxVO VO = new ZdxxVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsZdxxById(keyid, fydm, rybh);
		}
		List<Dm> listDmXl = ryjbxxManager.getDmListByName("文化程度");
		List<Dm> listDmZdzy = ryjbxxManager.getDmListByName("专业");
		List<Dm> listDmJyxs = ryjbxxManager.getDmListByName("教育形式");
		List<Dm> listDmXxxs = ryjbxxManager.getDmListByName("学习形式");
		model.addAttribute("listDmXl", listDmXl);
		model.addAttribute("listDmZdzy", listDmZdzy);
		model.addAttribute("listDmJyxs", listDmJyxs);
		model.addAttribute("listDmXxxs", listDmXxxs);
		model.addAttribute("zdxx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_zdxx";
	}

	@RequestMapping(value = "/deleteZdxx.aj", method = RequestMethod.POST)
	public void deleteZdxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsZdxxById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addZdxx.aj", method = RequestMethod.POST)
	public void addZdxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		ZdxxVO vo = new ZdxxVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		ZdxxVO zdxxVO = new ZdxxVO();
		zdxxVO = ryjbxxManager.addZdxx(vo);
		if (zdxxVO.getDRxrq() == null) {
			zdxxVO.setDRxrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, zdxxVO);
	}

	@RequestMapping(value = "/saveZdxx.aj", method = RequestMethod.POST)
	public void saveZdxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		ZdxxVO vo = new ZdxxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		ZdxxVO zdxxVO = new ZdxxVO();
		zdxxVO = ryjbxxManager.updateRsZdxx(vo);
		if (zdxxVO.getDRxrq() == null) {
			zdxxVO.setDRxrq("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, zdxxVO);
	}

	// 出国信息
	@RequestMapping(value = "/cgxx.do", method = RequestMethod.GET)
	public String showCgxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<CgxxVO> cgxxVOs = ryjbxxManager.getCgxxByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		model.addAttribute("cgxxList", cgxxVOs);
		model.addAttribute("index", "cgxx");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/cgxx";
	}

	@RequestMapping(value = "/cgxx.aj", method = RequestMethod.POST)
	public String showPopCgxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		CgxxVO VO = new CgxxVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsCgxxById(keyid, fydm, rybh);
		}
		List<Dm> listDmGb = ryjbxxManager.getDmListByName("国家");
		List<Dm> listDmCgsf = ryjbxxManager.getDmListByName("出国身份");
		List<Dm> listDmCgxz = ryjbxxManager.getDmListByName("出国性质");
		model.addAttribute("listDmGb", listDmGb);
		model.addAttribute("listDmCgsf", listDmCgsf);
		model.addAttribute("listDmCgxz", listDmCgxz);
		model.addAttribute("cgxx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_cgxx";
	}

	@RequestMapping(value = "/deleteCgxx.aj", method = RequestMethod.POST)
	public void deleteCgxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsCgxxById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addCgxx.aj", method = RequestMethod.POST)
	public void addCgxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		CgxxVO vo = new CgxxVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		CgxxVO cgxxVO = new CgxxVO();
		cgxxVO = ryjbxxManager.addCgxx(vo);
		if (cgxxVO.getDJssj() == null) {
			cgxxVO.setDJssj("");
		}
		if (cgxxVO.getDKssj() == null) {
			cgxxVO.setDKssj("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, cgxxVO);
	}

	@RequestMapping(value = "/saveCgxx.aj", method = RequestMethod.POST)
	public void saveCgxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		CgxxVO vo = new CgxxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		CgxxVO cgxxVO = new CgxxVO();
		cgxxVO = ryjbxxManager.updateRsCgxx(vo);
		if (cgxxVO.getDJssj() == null) {
			cgxxVO.setDJssj("");
		}
		if (cgxxVO.getDKssj() == null) {
			cgxxVO.setDKssj("");
		}
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, cgxxVO);
	}

	// 外语信息
	@RequestMapping(value = "/wyxx.do", method = RequestMethod.GET)
	public String showWyxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<WyxxVO> wyxxVOs = ryjbxxManager.getWyxxByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		model.addAttribute("wyxxList", wyxxVOs);
		model.addAttribute("index", "wyxx");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/wyxx";
	}

	@RequestMapping(value = "/wyxx.aj", method = RequestMethod.POST)
	public String showPopWyxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		WyxxVO VO = new WyxxVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsWyxxById(keyid, fydm, rybh);
		}
		List<Dm> listDmSlcd = ryjbxxManager.getDmListByName("语种熟练程度");
		List<Dm> listDmSpjb = ryjbxxManager.getDmListByName("外语水平");
		List<Dm> listDmWyyz = ryjbxxManager.getDmListByName("语种");
		model.addAttribute("listDmSlcd", listDmSlcd);
		model.addAttribute("listDmSpjb", listDmSpjb);
		model.addAttribute("listDmWyyz", listDmWyyz);
		model.addAttribute("wyxx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_wyxx";
	}

	@RequestMapping(value = "/deleteWyxx.aj", method = RequestMethod.POST)
	public void deleteWyxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsWyxxById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addWyxx.aj", method = RequestMethod.POST)
	public void addWyxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		WyxxVO vo = new WyxxVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		WyxxVO wyxxVO = new WyxxVO();
		wyxxVO = ryjbxxManager.addWyxx(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, wyxxVO);
	}

	@RequestMapping(value = "/saveWyxx.aj", method = RequestMethod.POST)
	public void saveWyxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		WyxxVO vo = new WyxxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		WyxxVO wyxxVO = new WyxxVO();
		wyxxVO = ryjbxxManager.updateRsWyxx(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, wyxxVO);
	}

	// 通讯录
	@RequestMapping(value = "/txl.do", method = RequestMethod.GET)
	public String showTxl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<TxlVO> txlVOs = ryjbxxManager.getTxlByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		model.addAttribute("txlList", txlVOs);
		model.addAttribute("index", "txl");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/txl";
	}

	@RequestMapping(value = "/txl.aj", method = RequestMethod.POST)
	public String showPopTxl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		TxlVO VO = new TxlVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsTxlById(keyid, fydm, rybh);
		}
		model.addAttribute("txl", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_txl";
	}

	@RequestMapping(value = "/deleteTxl.aj", method = RequestMethod.POST)
	public void deleteTxl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsTxlById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addTxl.aj", method = RequestMethod.POST)
	public void addTxl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		TxlVO vo = new TxlVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		TxlVO txlVO = new TxlVO();
		txlVO = ryjbxxManager.addTxl(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, txlVO);
	}

	@RequestMapping(value = "/saveTxl.aj", method = RequestMethod.POST)
	public void saveTxl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		TxlVO vo = new TxlVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		TxlVO txlVO = new TxlVO();
		txlVO = ryjbxxManager.updateRsTxl(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, txlVO);
	}

	@RequestMapping(value = "/syyyx.do", method = RequestMethod.GET)
	public String showSyyyx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String rybh = "100";
		List<SyyyxVO> syyyxVOs = ryjbxxManager.getSyyyxByRybh(rybh);
		model.addAttribute("syyyxList", syyyxVOs);
		model.addAttribute("index", "syyyx");
		return "ryjbxx/syyyx";
	}

	@RequestMapping(value = "/syyyx.aj", method = RequestMethod.POST)
	public String showPopSyyyx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String rybh = "100";
		String bh = request.getParameter("bh");
		String btnType = request.getParameter("btnType");
		SyyyxVO VO = new SyyyxVO();
		if (!btnType.equals("0")) {
			VO = ryjbxxManager.getRsSyyyxById(rybh, bh);
		}
		model.addAttribute("syyyx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_syyyx";
	}

	@RequestMapping(value = "/deleteSyyyx.aj", method = RequestMethod.POST)
	public void deleteSyyyx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String rybh = "100";
		String bh = request.getParameter("bh");
		result = ryjbxxManager.delRsSyyyxById(rybh, bh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addSyyyx.aj", method = RequestMethod.POST)
	public void addSyyyx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		SyyyxVO vo = new SyyyxVO();
		String rybh = "100";
		BeanUtilsEx.populate(vo, request.getParameterMap());
		String result = "-1";
		int id = ryjbxxManager.getMaxBhByRybh("RysxSyyyx", rybh) + 1;
		vo.setNId(Integer.toString(id));
		vo.setNRybh(rybh);
		result = Integer.toString(ryjbxxManager.addSyyyx(vo));
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/saveSyyyx.aj", method = RequestMethod.POST)
	public void saveSyyyx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		SyyyxVO vo = new SyyyxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNRybh("100");
		String result = "-1";
		result = ryjbxxManager.updateRsSyyyx(vo) ? "0" : "-1";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	// 备注信息
	@RequestMapping(value = "/bzxx.do", method = RequestMethod.GET)
	public String showBzxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		List<BzxxVO> bzxxVOs = ryjbxxManager.getBzxxByRybhFy(
				Integer.valueOf(code[1]), Integer.valueOf(code[0]));
		model.addAttribute("bzxxList", bzxxVOs);
		model.addAttribute("index", "bzxx");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/bzxx";
	}

	@RequestMapping(value = "/bzxx.aj", method = RequestMethod.POST)
	public String showPopBzxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		BzxxVO VO = new BzxxVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			VO = ryjbxxManager.getRsBzxxById(keyid, fydm, rybh);
		}
		model.addAttribute("bzxx", VO);
		model.addAttribute("btnType", btnType);
		return "ryjbxx/pop/view_bzxx";
	}

	@RequestMapping(value = "/deleteBzxx.aj", method = RequestMethod.POST)
	public void deleteBzxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxManager.delRsBzxxById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}

	@RequestMapping(value = "/addBzxx.aj", method = RequestMethod.POST)
	public void addBzxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		BzxxVO vo = new BzxxVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		BzxxVO bzxxVO = new BzxxVO();
		bzxxVO = ryjbxxManager.addBzxx(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, bzxxVO);
	}

	@RequestMapping(value = "/saveBzxx.aj", method = RequestMethod.POST)
	public void saveBzxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		BzxxVO vo = new BzxxVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		BzxxVO bzxxVO = new BzxxVO();
		bzxxVO = ryjbxxManager.updateRsBzxx(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, bzxxVO);
	}

	@RequestMapping(value = "/photo.do", method = RequestMethod.GET)
	public void photo(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {

		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		RysxPhoto rysxPhoto = ryjbxxService.getRysxPhoto(code[0], code[1]);
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");

		if (rysxPhoto != null && rysxPhoto.getIPhoto() != null) {
			response.getOutputStream().write(rysxPhoto.getIPhoto());
		} else {
			File file = new File(this.getClass().getResource("/").getPath(),
					"moren.png");
			response.getOutputStream().write(
					FileUtils.readFileToByteArray(file));
		}

	}

	@RequestMapping(value = "/isphoto.aj", method = RequestMethod.POST)
	public void isphoto(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		RysxPhoto rysxPhoto = ryjbxxService.getRysxPhoto(code[0], code[1]);
		if (rysxPhoto == null) {
			ResponseBuilder builder = new ResponseBuilder();
			builder.writeJsonResponse(response, 1);
		}
	}

	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}
	
	@RequestMapping(value = "/uploadpic.aj", method = RequestMethod.POST)
	public void uploadpic(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

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
			//"上传的文件太大，文件大小不能超过1M";
			builder.writeResponse(response, "-2");
			return;
		}
		RysxPhoto photoOrig = rysxPhotoDAO.getRysxPhoto(code[0],code[1]);
		if(photoOrig != null){
			photoOrig.setIPhoto(file.getBytes());
			rysxPhotoDAO.update(photoOrig);
		}else{
			RysxPhoto photo = new RysxPhoto();
			photo.setNFy(fydm);
			photo.setNRybh(rybh);
			photo.setIPhoto(file.getBytes());
			rysxPhotoDAO.save(photo);
		}
		builder.writeResponse(response, "0");
	}

	@RequestMapping(value = "/gryjda.do", method = RequestMethod.GET)
	public String showGryjda(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		model.addAttribute("index", "gryjda");
		model.addAttribute("showKey", showKey);
		RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
				Integer.valueOf(code[1]), ryjbxxService, dmService);
		return "ryjbxx/gryjda";
	}

	@RequestMapping(value = "/scgrbb.aj", method = RequestMethod.POST)
	public void showGryjdajtxx(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String kssj = request.getParameter("kssj");
		String jzsj = request.getParameter("jzsj");
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);

		String[] kssjs = kssj.split("-");
		String[] jzsjs = jzsj.split("-");
		RyjbxxVO VO = ryjbxxManager.getJbxxVOByRybhFy(Integer.valueOf(code[1]),
				Integer.valueOf(code[0]));
		String yhmc = VO.getCXm();
		Calendar calendarTo = Calendar.getInstance();
		Calendar calendarFrom = Calendar.getInstance();
		calendarFrom.set(Integer.parseInt(kssjs[0]),
				Integer.parseInt(kssjs[1]) - 1, Integer.parseInt(kssjs[2]), 0,
				0, 0);
		calendarTo.set(Integer.parseInt(jzsjs[0]),
				Integer.parseInt(jzsjs[1]) - 1, Integer.parseInt(jzsjs[2]), 0,
				0, 0);
		Date dateFrom = calendarFrom.getTime();
		Date dateTo = calendarTo.getTime();
		// 切换到原来的数据源
		String saveBefore = RolesUtil.getUserContext(request)
				.getCurrentDataSource();
		RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
		Gryjda gryjda = yjdaScbbService.getGryjda(dateFrom, dateTo, yhmc);
		ResponseBuilder builder = new ResponseBuilder();
		try {
			builder.writeJsonResponse(response, gryjda);
		} catch (IOException e) {
			e.printStackTrace();
		}
		RolesUtil.getUserContext(request).setCurrentDataSource(saveBefore);
	}

	
	
		
		
		
		
		
		
		@RequestMapping(value = "/pxjl.do", method = RequestMethod.GET)
		public String showpxjl(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			String showKey = request.getParameter("showKey");
			String[] code = NFyRybhCodeUtils.decode(showKey);

			model.addAttribute("index", "pxjl");
			model.addAttribute("showKey", showKey);
			RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
					Integer.valueOf(code[1]), ryjbxxService, dmService);
			return "ryjbxx/pxjl";
		}
		
		
		
		// 关于合同信息
		@RequestMapping(value = "/htxx.do", method = RequestMethod.GET)
		public String showhtxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			String showKey = request.getParameter("showKey");
			String[] code = NFyRybhCodeUtils.decode(showKey);

			List<RysxHtVO> htxxVOs = ryjbxxManager.getHtxxByRybhFy(
					Integer.valueOf(code[1]), Integer.valueOf(code[0]));
			model.addAttribute("htxxList", htxxVOs);
			model.addAttribute("index", "htxx");
			model.addAttribute("showKey", showKey);
			RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
					Integer.valueOf(code[1]), ryjbxxService, dmService);
			return "ryjbxx/htxx";
		}
		
		@RequestMapping(value = "/htxx.aj", method = RequestMethod.POST)
		public String showPophtxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			String btnType = request.getParameter("btnType");
			RysxHtVO VO = new RysxHtVO();
			if (!btnType.equals("0")) {
				String keyid = request.getParameter("keyid");
				String fydm = request.getParameter("fydm");
				String rybh = request.getParameter("rybh");
				VO = ryjbxxManager.getRsHtxxById(keyid, fydm, rybh);
			}
			List<Dm> listDmzwlx= ryjbxxManager.getDmListByName("行政职务");
			model.addAttribute("listDmzwlx", listDmzwlx);
			model.addAttribute("htxx", VO);
			model.addAttribute("btnType", btnType);
			return "ryjbxx/pop/view_htxx";
		}

		@RequestMapping(value = "/deletehtxx.aj", method = RequestMethod.POST)
		public void deletehtxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			String result = "0";
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			result = ryjbxxManager.delRsHtxxById(keyid, fydm, rybh) ? "1" : "0";
			ResponseBuilder builder = new ResponseBuilder();
			builder.writeJsonResponse(response, new Gson().toJson(result));
		}

		@RequestMapping(value = "/addhtxx.aj", method = RequestMethod.POST)
		public void addhtxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			RysxHtVO vo = new RysxHtVO();
			String showKey = request.getParameter("showKey");
			String[] code = NFyRybhCodeUtils.decode(showKey);
			BeanUtilsEx.populate(vo, request.getParameterMap());
			vo.setNFy(code[0]);
			vo.setNRybh(code[1]);
			RysxHtVO htxxVO = new RysxHtVO();
			htxxVO = ryjbxxManager.addHtxx(vo);
			ResponseBuilder builder = new ResponseBuilder();
			builder.writeJsonResponse(response, htxxVO);
		}

		@RequestMapping(value = "/savehtxx.aj", method = RequestMethod.POST)
		public void savehtxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			RysxHtVO vo = new RysxHtVO();
			BeanUtilsEx.populate(vo, request.getParameterMap());
			RysxHtVO htxxVO = new RysxHtVO();
			htxxVO = ryjbxxManager.updateRsHtxx(vo);
			ResponseBuilder builder = new ResponseBuilder();
			builder.writeJsonResponse(response, htxxVO);
		}
		
		// 关于休假信息
		@RequestMapping(value = "/xjxx.do", method = RequestMethod.GET)
		public String showXjxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			String showKey = request.getParameter("showKey");
			String[] code = NFyRybhCodeUtils.decode(showKey);
			List<XiujiaVO> xiujiaVOs = ryjbxxManager.getXiujiaByRybhFy(Integer.valueOf(code[1]), Integer.valueOf(code[0]));
			model.addAttribute("xjxxList",xiujiaVOs);
			model.addAttribute("index", "xjxx");
			model.addAttribute("showKey", showKey);
			RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
					Integer.valueOf(code[1]), ryjbxxService, dmService);
			return "ryjbxx/xjxx";
		}
				
		@RequestMapping(value = "/xjxx.aj", method = RequestMethod.POST)
		public String showPopxjxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			String btnType = request.getParameter("btnType");
			XiujiaVO VO = new XiujiaVO();
			if (!btnType.equals("0")) {
				String keyid = request.getParameter("keyid");
				String fydm = request.getParameter("fydm");
				String rybh = request.getParameter("rybh");
				VO = ryjbxxManager.getXiujiaById(keyid, fydm, rybh);
			}
			List<Dm> listDmXjlx= ryjbxxManager.getDmListByName("休假类型");
			model.addAttribute("listDmXjlx", listDmXjlx);
			model.addAttribute("xjxx", VO);
			model.addAttribute("btnType", btnType);
			return "ryjbxx/pop/view_xjxx";
		}

		@RequestMapping(value = "/deletexjxx.aj", method = RequestMethod.POST)
		public void deletexjxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			String result = "0";
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			result = ryjbxxManager.delXiujiaById(keyid, fydm, rybh) ? "1" : "0";
			ResponseBuilder builder = new ResponseBuilder();
			builder.writeJsonResponse(response, new Gson().toJson(result));
		}

		@RequestMapping(value = "/addxjxx.aj", method = RequestMethod.POST)
		public void addxjxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			XiujiaVO vo = new XiujiaVO();
			String showKey = request.getParameter("showKey");
			String[] code = NFyRybhCodeUtils.decode(showKey);
			BeanUtilsEx.populate(vo, request.getParameterMap());
			vo.setNFy(code[0]);
			vo.setNRybh(code[1]);
			XiujiaVO xjxxVO = new XiujiaVO();
			xjxxVO = ryjbxxManager.addXiujia(vo);
			ResponseBuilder builder = new ResponseBuilder();
			builder.writeJsonResponse(response, xjxxVO);
		}

		@RequestMapping(value = "/savexjxx.aj", method = RequestMethod.POST)
		public void savexjxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			RysxHtVO vo = new RysxHtVO();
			BeanUtilsEx.populate(vo, request.getParameterMap());
			XiujiaVO xjxxVO = new XiujiaVO();
			xjxxVO = ryjbxxManager.updateXiujia(xjxxVO);
			ResponseBuilder builder = new ResponseBuilder();
			builder.writeJsonResponse(response, xjxxVO);
		}
		//关于社保记录
		@RequestMapping(value = "/sbjl.do", method = RequestMethod.GET)
		public String showsbjl(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			String showKey = request.getParameter("showKey");
			String[] code = NFyRybhCodeUtils.decode(showKey);
			List<RysxShebaoVO> sbVos = ryjbxxManager.getShebaoByRybhFy(Integer.valueOf(code[1]), Integer.valueOf(code[0]));
			model.addAttribute("shebaoList",sbVos);
			model.addAttribute("index", "sbjl");
			model.addAttribute("showKey", showKey);
			RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
					Integer.valueOf(code[1]), ryjbxxService, dmService);
			return "ryjbxx/sbjl";
		}
		@RequestMapping(value = "/sbjl.aj", method = RequestMethod.POST)
		public String showPopsbjl(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			String btnType = request.getParameter("btnType");
			RysxShebaoVO VO = new RysxShebaoVO();
			if (!btnType.equals("0")) {
				String keyid = request.getParameter("keyid");
				String fydm = request.getParameter("fydm");
				String rybh = request.getParameter("rybh");
				VO = ryjbxxManager.getShebaoById(keyid, fydm, rybh);
			}
			List<Dm> listDmSblx= ryjbxxManager.getDmListByName("保险类型");
			model.addAttribute("listDmXzlx", listDmSblx);
			model.addAttribute("sbjl", VO);
			model.addAttribute("btnType", btnType);
			return "ryjbxx/pop/view_sbjl";
		}
		@RequestMapping(value = "/deletesbjl.aj", method = RequestMethod.POST)
		public void deletesbjl(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
				String result= "0";
				String keyid = request.getParameter("keyid");
				String fydm = request.getParameter("fydm");
				String rybh = request.getParameter("rybh");
				result = ryjbxxManager.delShebaoById(keyid, fydm, rybh)? "1" : "0";
				ResponseBuilder builder = new ResponseBuilder();
				builder.writeJsonResponse(response, new Gson().toJson(result));
		
		}
		@RequestMapping(value = "/addsbjl.aj", method = RequestMethod.POST)
		public void addsbjl(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
				RysxShebaoVO vo = new RysxShebaoVO();
				String showKey = request.getParameter("showKey");
				String[] code = NFyRybhCodeUtils.decode(showKey);
				BeanUtilsEx.populate(vo, request.getParameterMap());
				vo.setNFy(code[0]);
				vo.setNRybh(code[1]);
				RysxShebaoVO shebaoVO = new RysxShebaoVO();
				shebaoVO = ryjbxxManager.addShebao(vo);
				ResponseBuilder builder = new ResponseBuilder();
				builder.writeJsonResponse(response, shebaoVO);
		}
		@RequestMapping(value = "/savesbjl.aj", method = RequestMethod.POST)
		public void savesbjl(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
				RysxShebaoVO vo = new RysxShebaoVO();
				BeanUtilsEx.populate(vo, request.getParameterMap());
				RysxShebaoVO shebaoVO = new RysxShebaoVO();
				shebaoVO = ryjbxxManager.updateShebao(vo);
				ResponseBuilder builder = new ResponseBuilder();
				builder.writeJsonResponse(response, shebaoVO);
		}
		//关于薪酬福利
		@RequestMapping(value = "/xcflxx.do", method = RequestMethod.GET)
		public String showxcflxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			String showKey = request.getParameter("showKey");
			String[] code = NFyRybhCodeUtils.decode(showKey);
			List<RysxFljlVO> fljlVOs = ryjbxxManager.getRysxFljlByRybhFy(Integer.valueOf(code[1]), Integer.valueOf(code[0]));
			model.addAttribute("fljlList",fljlVOs);
			model.addAttribute("index", "xcflxx");
			model.addAttribute("showKey", showKey);
			RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
					Integer.valueOf(code[1]), ryjbxxService, dmService);
			return "ryjbxx/xcflxx";
		}
		@RequestMapping(value = "/xcflxx.aj", method = RequestMethod.POST)
		public String showPopxcflxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			String btnType = request.getParameter("btnType");
			RysxFljlVO VO = new RysxFljlVO();
			if (!btnType.equals("0")) {
				String keyid = request.getParameter("keyid");
				String fydm = request.getParameter("fydm");
				String rybh = request.getParameter("rybh");
				VO = ryjbxxManager.getRysxFljlById(keyid, fydm, rybh);
			}
			model.addAttribute("fljl", VO);
			model.addAttribute("btnType", btnType);
			return "ryjbxx/pop/view_xcflxx";
		}
		@RequestMapping(value = "/deletexcflxx.aj", method = RequestMethod.POST)
		public void deletexcflxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			String result = "0";
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			result = ryjbxxManager.delRysxFljlById(keyid, fydm, rybh) ? "1" : "0";
			ResponseBuilder builder = new ResponseBuilder();
			builder.writeJsonResponse(response, new Gson().toJson(result));
		}
		@RequestMapping(value = "/addxcflxx.aj", method = RequestMethod.POST)
		public void addxcflxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			RysxFljlVO vo = new RysxFljlVO();
			String showKey = request.getParameter("showKey");
			String[] code = NFyRybhCodeUtils.decode(showKey);
			BeanUtilsEx.populate(vo, request.getParameterMap());
			vo.setNFy(code[0]);
			vo.setNRybh(code[1]);
			RysxFljlVO fljlVO = new RysxFljlVO();
			fljlVO = ryjbxxManager.addRysxFljl(vo);
			ResponseBuilder builder = new ResponseBuilder();
			builder.writeJsonResponse(response, fljlVO);
		}
		@RequestMapping(value = "/savexcflxx.aj", method = RequestMethod.POST)
		public void savexcflxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			RysxFljlVO vo = new RysxFljlVO();
			BeanUtilsEx.populate(vo, request.getParameterMap());
			RysxFljlVO fljlVO = new RysxFljlVO();
			fljlVO = ryjbxxManager.updateRysxFljl(vo);
			ResponseBuilder builder = new ResponseBuilder();
			builder.writeJsonResponse(response, fljlVO);
		}
		//职级变动信息
		@RequestMapping(value = "/zjbbxx.do", method = RequestMethod.GET)
		public String showzjbbxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			String showKey = request.getParameter("showKey");
			String[] code = NFyRybhCodeUtils.decode(showKey);
			List<ZjbgVO> zjbgVOs = ryjbxxManager.getZjbdByRybhFy(Integer.valueOf(code[1]), Integer.valueOf(code[0]));
			model.addAttribute("zjbgList",zjbgVOs);
			model.addAttribute("index", "zjbbxx");
			model.addAttribute("showKey", showKey);
			RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
					Integer.valueOf(code[1]), ryjbxxService, dmService);
			return "ryjbxx/zjbbxx";
		}
		@RequestMapping(value = "/zjbbxx.aj", method = RequestMethod.POST)
		public String showPopzjbbxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			String btnType = request.getParameter("btnType");
			ZjbgVO VO = new ZjbgVO();
			if (!btnType.equals("0")) {
				String keyid = request.getParameter("keyid");
				String fydm = request.getParameter("fydm");
				String rybh = request.getParameter("rybh");
				VO = ryjbxxManager.getZjbdById(keyid, fydm, rybh);
			}
			List<Dm> listDmzj= ryjbxxManager.getDmListByName("职级");
			model.addAttribute("listDmZj", listDmzj);
			model.addAttribute("zjbg", VO);
			model.addAttribute("btnType", btnType);
			return "ryjbxx/pop/view_zjbbxx";
		}
		@RequestMapping(value = "/deletezjbbxx.aj", method = RequestMethod.POST)
		public void deletezjbbxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			String result = "0";
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			result = ryjbxxManager.delZjbdById(keyid, fydm, rybh) ? "1" : "0";
			ResponseBuilder builder = new ResponseBuilder();
			builder.writeJsonResponse(response, new Gson().toJson(result));
		}
		@RequestMapping(value = "/addzjbbxx.aj", method = RequestMethod.POST)
		public void addzjbbxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			ZjbgVO vo = new ZjbgVO();
			String showKey = request.getParameter("showKey");
			String[] code = NFyRybhCodeUtils.decode(showKey);
			BeanUtilsEx.populate(vo, request.getParameterMap());
			vo.setNFy(code[0]);
			vo.setNRybh(code[1]);
			ZjbgVO zjbgVO = new ZjbgVO();
			zjbgVO = ryjbxxManager.addZjbd(vo);
			ResponseBuilder builder = new ResponseBuilder();
			builder.writeJsonResponse(response, zjbgVO);
		}
		@RequestMapping(value = "/savezjbbxx.aj", method = RequestMethod.POST)
		public void savezjbbxx(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			ZjbgVO vo = new ZjbgVO();
			BeanUtilsEx.populate(vo, request.getParameterMap());
			ZjbgVO zjbgVO = new ZjbgVO();
			zjbgVO = ryjbxxManager.updateZjbd(vo);
			ResponseBuilder builder = new ResponseBuilder();
			builder.writeJsonResponse(response, zjbgVO);
		}
		//部门变动信息
		@RequestMapping(value = "/zgqk.do", method = RequestMethod.GET)
		public String showzgqk(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			String showKey = request.getParameter("showKey");
			String[] code = NFyRybhCodeUtils.decode(showKey);
			List<BmbdVO> bmbdVOs = ryjbxxManager.getBmbdByRybhFy(Integer.valueOf(code[1]), Integer.valueOf(code[0]));
			model.addAttribute("zgqkList",bmbdVOs);
			model.addAttribute("index", "zgqk");
			model.addAttribute("showKey", showKey);
			RolesUtil.ryjbxxCommon(request, model, Integer.valueOf(code[0]),
					Integer.valueOf(code[1]), ryjbxxService, dmService);
			return "ryjbxx/zgqk";
		}
		@RequestMapping(value = "/zgqk.aj", method = RequestMethod.POST)
		public String showPopzgqk(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			String btnType = request.getParameter("btnType");
			BmbdVO VO = new BmbdVO();
			if (!btnType.equals("0")) {
				String keyid = request.getParameter("keyid");
				String fydm = request.getParameter("fydm");
				String rybh = request.getParameter("rybh");
				VO = ryjbxxManager.getBmbdById(keyid, fydm, rybh);
			}
			List<Dm> listDmBm= ryjbxxManager.getDmListByName("内设机构");
			model.addAttribute("listDmBm", listDmBm);
			model.addAttribute("zgqk", VO);
			model.addAttribute("btnType", btnType);
			return "ryjbxx/pop/view_zgqk";
		}
		@RequestMapping(value = "/deletezgqk.aj", method = RequestMethod.POST)
		public void deletezgqk(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			String result = "0";
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			String rybh = request.getParameter("rybh");
			result = ryjbxxManager.delBmbdById(keyid, fydm, rybh) ? "1" : "0";
			ResponseBuilder builder = new ResponseBuilder();
			builder.writeJsonResponse(response, new Gson().toJson(result));
		}
		@RequestMapping(value = "/addzgqk.aj", method = RequestMethod.POST)
		public void addzgqk(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			BmbdVO vo = new BmbdVO();
			String showKey = request.getParameter("showKey");
			String[] code = NFyRybhCodeUtils.decode(showKey);
			BeanUtilsEx.populate(vo, request.getParameterMap());
			vo.setNFy(code[0]);
			vo.setNRybh(code[1]);
			BmbdVO bmbdVO = new BmbdVO();
			bmbdVO = ryjbxxManager.addBmbd(vo);
			ResponseBuilder builder = new ResponseBuilder();
			builder.writeJsonResponse(response, bmbdVO);
		}
		@RequestMapping(value = "/savezgqk.aj", method = RequestMethod.POST)
		public void savezgqk(HttpServletRequest request,
				HttpServletResponse response, ModelMap model) throws Exception {
			BmbdVO vo = new BmbdVO();
			BeanUtilsEx.populate(vo, request.getParameterMap());
			BmbdVO bmbdVO = new BmbdVO();
			bmbdVO = ryjbxxManager.updateBmbd(vo);
			ResponseBuilder builder = new ResponseBuilder();
			builder.writeJsonResponse(response, bmbdVO);
		}
}
