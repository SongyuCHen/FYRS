package nju.software.fyrs.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.manager.YjdaNdkhManager;
import nju.software.fyrs.biz.vo.NdkhVO;
import nju.software.fyrs.biz.vo.NdkhjtxxVO;
import nju.software.fyrs.service.YjdaNdkhService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.model.UserContext;
import nju.software.fyrs.util.BeanUtilsEx;
import nju.software.fyrs.util.JacobHelper;
import nju.software.fyrs.util.RolesUtil;
import nju.software.fyrs.web.json.ResponseBuilder;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main/yjda")
public class YjdaNdkhController {
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(YjdaNdkhController.class);
	private RoleMenuService roleMenuService;
	private YjdaNdkhManager yjdaNdkhManager;
	private YjdaNdkhService yjdaNdkhService;

	public void setYjdaNdkhService(YjdaNdkhService yjdaNdkhService) {
		this.yjdaNdkhService = yjdaNdkhService;
	}

	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	public void setYjdaNdkhManager(YjdaNdkhManager yjdaNdkhManager) {
		this.yjdaNdkhManager = yjdaNdkhManager;
	}

	public YjdaNdkhManager getYjdaNdkhManager() {
		return yjdaNdkhManager;
	}

	@RequestMapping(value = "/ndkh.do", method = RequestMethod.GET)
	public String showNdkh(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		MenuShowUtils.headerMenu(request, model, roleMenuService, "ҵ������");
		MenuShowUtils.leftMenu(request, model, roleMenuService, "yjda");
		model.addAttribute("currentSelectLeftMenu", "��ȿ���");
		return "ndkh/show";
	}

	@RequestMapping(value = "/ndkh.aj", method = RequestMethod.POST)
	public void showNdkhAjax(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		UserContext userContext = (UserContext) request.getSession()
				.getAttribute("user");
		String yhmc = userContext.getYhmc();

		// �л�����Դ��ҵ������
		RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
		
		List<NdkhVO> listNdkhVO = yjdaNdkhManager.getNdByYhmc(yhmc);

		ResponseBuilder rb = new ResponseBuilder();
		try {
			rb.writeJsonResponse(response, listNdkhVO);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		// �л���ԭ��������Դ
		RolesUtil.getUserContext(request).setCurrentDataSource("fyrs");
	}

	// �������ȷ���Ǵ���ǰ�ı��棬������д�±���
	@RequestMapping(value = "/ndkhjtxx.do", method = RequestMethod.GET)
	public String showNdkhJtxx(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		UserContext userContext = (UserContext) request.getSession()
				.getAttribute("user");
		String yhmc = userContext.getYhmc();
		String khnd = request.getParameter("khnd");
		String sfkbj = request.getParameter("sfkbj");
		
		// �л�����Դ��ҵ������
		RolesUtil.getUserContext(request).setCurrentDataSource("yjda");

		NdkhjtxxVO ndkhjtxxVO = new NdkhjtxxVO();
		if (khnd == null) {
			ndkhjtxxVO = yjdaNdkhManager.getNdkhjtxxByYhmc(yhmc);
		} else {
			ndkhjtxxVO = yjdaNdkhManager.getNdkhjtxxByYhmcAndKhnd(yhmc, khnd);
		}
		
		// �л���ԭ��������Դ
		RolesUtil.getUserContext(request).setCurrentDataSource("fyrs");
		model.addAttribute("ndkhjtxx", ndkhjtxxVO);
		model.addAttribute("sfkbj",sfkbj);
		return "ndkh/ndkhjtxx";
	}
	
	// �������ȷ���Ǵ���ǰ�ı��棬������д�±���
		@RequestMapping(value = "/spndkhjtxx.do", method = RequestMethod.GET)
		public String spNdkhJtxx(Model model, HttpServletResponse response,
				HttpServletRequest request) {
			String rybh = request.getParameter("rybh");
			String khnd = request.getParameter("khnd");
			String qx = request.getParameter("qx");
			// �л�����Դ��ҵ������
			RolesUtil.getUserContext(request).setCurrentDataSource("yjda");

			NdkhjtxxVO ndkhjtxxVO = new NdkhjtxxVO();
			ndkhjtxxVO = yjdaNdkhService.getNdkhjtxxByRybhAndKhnd(rybh, khnd);

			// �л���ԭ��������Դ
			RolesUtil.getUserContext(request).setCurrentDataSource("fyrs");
			model.addAttribute("ndkhjtxx", ndkhjtxxVO);
			model.addAttribute("qx",qx);
			return "ndkh/ndkhjtxx";
		}
		
	@RequestMapping(value = "/addNdkhjtxx.aj", method = RequestMethod.POST)
	public void showNdkhjtxxAjax(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		// �л�����Դ��ҵ������
		RolesUtil.getUserContext(request).setCurrentDataSource("yjda");

		NdkhjtxxVO vo = new NdkhjtxxVO();
		try {
			BeanUtilsEx.populate(vo, request.getParameterMap());
			yjdaNdkhManager.addNdkhjtxx(vo);
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		}
		// �л���ԭ��������Դ
		RolesUtil.getUserContext(request).setCurrentDataSource("fyrs");

	}

	@RequestMapping(value = "/spNdkhjtxx.aj", method = RequestMethod.POST)
	public void spNdkhjtxxAjax(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		String rybh = request.getParameter("rybh");
		String nd = request.getParameter("nd");
		String zgldpy = request.getParameter("zgldpy");
		String select_jieguo = request.getParameter("select-jieguo");
		// �л�����Դ��ҵ������
		RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
		yjdaNdkhService.spNdkhjtxx(rybh,nd,zgldpy,select_jieguo);
		
		// �л���ԭ��������Դ
		RolesUtil.getUserContext(request).setCurrentDataSource("fyrs");

	}
	
	@RequestMapping(value = "/yldspNdkhjtxx.aj", method = RequestMethod.POST)
	public void yldspNdkhjtxxAjax(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		String rybh = request.getParameter("rybh");
		String nd = request.getParameter("nd");
		String jgfzrhkhwyhyj = request.getParameter("jgfzrhkhwyhyj");
		// �л�����Դ��ҵ������
		RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
		yjdaNdkhService.yldspNdkhjtxx(rybh,nd,jgfzrhkhwyhyj);
		
		// �л���ԭ��������Դ
		RolesUtil.getUserContext(request).setCurrentDataSource("fyrs");

	}
	
	@RequestMapping(value = "/showSignPic.do", method = RequestMethod.GET)
	public void showSignPic(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		// �л�����Դ��ҵ������
		RolesUtil.getUserContext(request).setCurrentDataSource("yjda");

		try {
			UserContext userContext = (UserContext) request.getSession()
					.getAttribute("user");
			String yhmc = userContext.getYhmc();

			byte[] signPic = yjdaNdkhManager.getSignPic(yhmc);
			response.setContentType("image/jpeg");
			ServletOutputStream outStream = response.getOutputStream();
			outStream.write(signPic);
			outStream.flush();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		// �л���ԭ��������Դ
		RolesUtil.getUserContext(request).setCurrentDataSource("fyrs");
	}

	@RequestMapping(value = "/getSign.do", method = RequestMethod.GET)
	public void getSign(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		String rybh = request.getParameter("rybh");
		String nd= request.getParameter("nd");
		String pic = request.getParameter("pic");
		// �л�����Դ��ҵ������
		RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
		try {
			byte[] signPic = yjdaNdkhService.getSign(rybh,nd,pic);
			if(signPic!=null&&signPic.length!=0){
				response.setContentType("image/jpeg");
				ServletOutputStream outStream = response.getOutputStream();
				outStream.write(signPic);
				outStream.flush();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		// �л���ԭ��������Դ
		RolesUtil.getUserContext(request).setCurrentDataSource("fyrs");
	}
	
	@RequestMapping(value = "/dyNdkhjtxx.aj", method = RequestMethod.GET)
	public String dyNdkhjtxxAjax(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		String rybh = request.getParameter("yhbh");
		String khnd = request.getParameter("khnd");
		
		// �л�����Դ��ҵ������
		RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
		
		NdkhjtxxVO ndkhjtxxVO = yjdaNdkhManager.getNdkhjtxxByRybhAndKhnd(rybh,
				khnd);
		String dirPath = getDirPath();
		String sourceFilePath = dirPath + "ndkhjtxx.doc";
		Long dateLong = new Date().getTime();
		String docpath = dirPath + "��ȿ��˸�����Ϣ" + "_" + dateLong + ".doc";
		try {
			JacobHelper jacob = new JacobHelper(false);
			jacob.openDocument(sourceFilePath);
			String skhnd = ndkhjtxxVO.getNd();
			String khndxs = "(" + skhnd + "���)";
			jacob.moveDown(1);
			jacob.insertText(khndxs, false, false, false, "0,0,0", "16", "����");

			String xm = ndkhjtxxVO.getXm();
			jacob.putTxtToCell(1, 1, 2, xm);

			String xb = ndkhjtxxVO.getXb();
			jacob.putTxtToCell(1, 1, 4, xb);

			String csny = ndkhjtxxVO.getCsny();
			jacob.putTxtToCell(1, 1, 6, csny);

			String zzmm = ndkhjtxxVO.getZzmm();
			jacob.putTxtToCell(1, 2, 2, zzmm);

			String zwsj = ndkhjtxxVO.getRxzsj();
			jacob.putTxtToCell(1, 2, 4, zwsj);

			String dwjzw = ndkhjtxxVO.getDw() + " " + ndkhjtxxVO.getZw();
			jacob.putTxtToCell(1, 3, 2, dwjzw);

			String cshfggz = ndkhjtxxVO.getCshfggz();
			jacob.putTxtToCell(1, 4, 2, cshfggz);

			String grzj = ndkhjtxxVO.getGrzj();
			jacob.putTxtToCell(1, 5, 2, grzj);

			String ldpy = ndkhjtxxVO.getZgldpyhkhdcjy();
			jacob.putTxtToCell(1, 6, 2, ldpy);
			
			jacob.save(docpath);
			jacob.close();
			downloadFile(docpath, request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		// �л���ԭ��������Դ
		RolesUtil.getUserContext(request).setCurrentDataSource("fyrs");
		return null;
	}

	private String getDirPath() {
		return System.getProperty("web.fyrs.root") + "resources\\doc\\";
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

	// �����û����ƻ�ø��û�����ȿ����е�Ȩ�ޣ���Ϊ����ϵͳ����ȿ�������ԱID����ͬ��
	@RequestMapping(value = "/ndkhyhqx.aj", method = RequestMethod.POST)
	public void getNdkhYhqx(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		UserContext userContext = (UserContext) request.getSession()
				.getAttribute("user");
		String yhmc = userContext.getYhmc();
		// �л�����Դ��ҵ������
		RolesUtil.getUserContext(request).setCurrentDataSource("yjda");

		List<String> qxList = yjdaNdkhManager.getYhQxByYhmc(yhmc);
		ResponseBuilder rb = new ResponseBuilder();
		try {
			rb.writeJsonResponse(response, qxList);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		// �л���ԭ��������Դ
		RolesUtil.getUserContext(request).setCurrentDataSource("fyrs");
	}

	// ������������ĵ���
	@RequestMapping(value = "/spbg.aj", method = RequestMethod.POST)
	public String showSpbgDlg(Model model, HttpServletResponse response,
			HttpServletRequest request) {

		return "ndkh/pop/view_spbg";
	}

	// ���������ڵı��棨�в��쵼��Ȩ�ޣ�
	@RequestMapping(value = "/bmncx.aj", method = RequestMethod.POST)
	public void SearchBmTjlist(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		UserContext userContext = (UserContext) request.getSession()
				.getAttribute("user");
		String yhmc = userContext.getYhmc();
		String year = request.getParameter("year");
		RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
		List<List<String>> listBmTjBg = yjdaNdkhService.getBmTjBg(yhmc, year);

		// �л���ԭ��������Դ
		RolesUtil.getUserContext(request).setCurrentDataSource("fyrs");
		ResponseBuilder rb = new ResponseBuilder();
		try {
			rb.writeJsonResponse(response, listBmTjBg);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	// �ɲ����ɲ���Ȩ�ޣ�����ʵ�ָɲ�����������
	@RequestMapping(value = "/gbcsp.aj", method = RequestMethod.POST)
	public String showGbcsp(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		model.addAttribute("gbcsp", "1");
		return "ndkh/pop/view_spbg";
	}

	// �ɲ�����ѯ���������ı���
	@RequestMapping(value = "/gbccx.aj", method = RequestMethod.POST)
	public void SearchGbccx(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		String year = request.getParameter("year");
		RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
		List<List<String>> listBmTjBg = yjdaNdkhService.getGbccx(year);

		// �л���ԭ��������Դ
		RolesUtil.getUserContext(request).setCurrentDataSource("fyrs");
		ResponseBuilder rb = new ResponseBuilder();
		try {
			rb.writeJsonResponse(response, listBmTjBg);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	// ����ͳ�Ƶ���
	@RequestMapping(value = "/bmtj.aj", method = RequestMethod.POST)
	public String showBmtj(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		return "ndkh/pop/view_bmtj";
	}

	// ���ɲ���ͳ������
	@RequestMapping(value = "/tjsc.aj", method = RequestMethod.POST)
	public void SearchTjsc(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		UserContext userContext = (UserContext) request.getSession()
				.getAttribute("user");
		String yhmc = userContext.getYhmc();
		String year = request.getParameter("year");
		RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
		List<List<String>> listBmTjBg = yjdaNdkhService.getTjsc(yhmc, year);

		// �л���ԭ��������Դ
		RolesUtil.getUserContext(request).setCurrentDataSource("fyrs");
		ResponseBuilder rb = new ResponseBuilder();
		try {
			rb.writeJsonResponse(response, listBmTjBg);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	// Ժ�쵼Ȩ�ޣ������в�
	@RequestMapping(value = "/spzc.aj", method = RequestMethod.POST)
	public String showSpzc(Model model, HttpServletResponse response,
			HttpServletRequest request) {

		model.addAttribute("gbcsp", "0");
		return "ndkh/pop/view_ldsp";
	}

	// Ժ�쵼��ѯ���������в�ı���
	@RequestMapping(value = "/ldspzc.aj", method = RequestMethod.POST)
	public void SearchLdspzc(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		UserContext userContext = (UserContext) request.getSession()
				.getAttribute("user");
		String yhmc = userContext.getYhmc();
		String year = request.getParameter("year");
		RolesUtil.getUserContext(request).setCurrentDataSource("yjda");
		List<List<String>> listBmTjBg = yjdaNdkhService.getLdspZc(yhmc, year);

		// �л���ԭ��������Դ
		RolesUtil.getUserContext(request).setCurrentDataSource("fyrs");
		ResponseBuilder rb = new ResponseBuilder();
		try {
			rb.writeJsonResponse(response, listBmTjBg);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	// Ժ�쵼��ÿ��������в����µĲ���
	@RequestMapping(value = "/spzcyx.aj", method = RequestMethod.POST)
	public String showSpzcyx(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		UserContext userContext = (UserContext) request.getSession()
				.getAttribute("user");
		String yhmc = userContext.getYhmc();
		RolesUtil.getUserContext(request).setCurrentDataSource("yjda");

		List<String> yhglbmList = yjdaNdkhService.getYhglBm(yhmc);

		// �л���ԭ��������Դ
		RolesUtil.getUserContext(request).setCurrentDataSource("fyrs");
		model.addAttribute("gbcsp", "1");
		model.addAttribute("bmList", yhglbmList);
		return "ndkh/pop/view_ldsp";
	}

	// Ժ�쵼��ѯ���������в����µı���
	@RequestMapping(value = "/ldspzcyx.aj", method = RequestMethod.POST)
	public void SearchLdspzcyx(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		String year = request.getParameter("year");
		String bmbh = request.getParameter("bm");
		RolesUtil.getUserContext(request).setCurrentDataSource("yjda");

		List<List<String>> listBmTjBg = yjdaNdkhService.getLdspZcyx(bmbh, year);

		// �л���ԭ��������Դ
		RolesUtil.getUserContext(request).setCurrentDataSource("fyrs");
		ResponseBuilder rb = new ResponseBuilder();
		try {
			rb.writeJsonResponse(response, listBmTjBg);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
