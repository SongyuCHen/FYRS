package nju.software.fyrs.service.impl;

import java.util.ArrayList;
import java.util.List;

import nju.software.fyrs.biz.vo.FyVO;
import nju.software.fyrs.data.dao.Pub_DmbDao;
import nju.software.fyrs.data.dataobject.Pub_DmbDO;
import nju.software.fyrs.service.FyService;
import nju.software.fyrs.service.convertor.DmbConvertor;
import nju.software.fyrs.service.model.DmbModel;

import org.apache.log4j.Logger;

/**
 * 
 * ��÷�Ժ�б���Ϣ��
 * 
 */
public class FyServiceImpl implements FyService {

	private static final Logger logger = Logger.getLogger(FyServiceImpl.class);

	Pub_DmbDao pub_DmbDao;

	/**
	 * ��÷�Ժ�б���Ϣ
	 * 
	 * return FyVO
	 */
	public FyVO getJsfyList() {
		List<DmbModel> fyModelList = new ArrayList<DmbModel>();
		List<Pub_DmbDO> jsfyDOList = pub_DmbDao.getJsFydmb(); // ������з�Ժ���б�
		for (Pub_DmbDO dmbDO : jsfyDOList) {
			DmbModel dmbModel = new DmbModel();
			dmbModel = DmbConvertor.getDmModelByPub_DmbDO(dmbDO);
			fyModelList.add(dmbModel);
		}
		// ��������ʼ����Ժģ��
		if (logger.isInfoEnabled()) {
			logger.info("��ý������з�Ժ�б�");
		}
		DmbModel gyModel = new DmbModel();// ��������ʼ����Ժģ��
		FyVO jsgyVO = new FyVO();
		int index = 0;
		int flag = 0;
		try {
			// ��ø�Ժ��Ϣ
			while (index < fyModelList.size() && flag < 1) {
				if (fyModelList.get(index).getDmbh().endsWith("00")
						&& !fyModelList.get(index).getDmbh().equals("000")) {
					gyModel = fyModelList.get(index);
					flag++;
				}
				index++;
			}
			jsgyVO.setFydm(gyModel.getDmbh());
			jsgyVO.setFymc(gyModel.getDmms());
			jsgyVO.setFyjc(gyModel.getBz());

			// ��ø��м���Ժ����Ϣ
			List<FyVO> zyList = new ArrayList<FyVO>();
			for (int j = 0; j < fyModelList.size(); j++) {
				if (jsgyVO.getFydm().charAt(0) == fyModelList.get(j)
						.getDmbh().charAt(0)
						&& jsgyVO.getFydm().charAt(1) == fyModelList.get(j)
								.getDmbh().charAt(1)
						&& fyModelList.get(j).getDmbh().charAt(8) != '0'
						// && fyModelList.get(j).getDmbh().charAt(8) != '1'
						&& fyModelList.get(j).getDmbh().charAt(9) == '0') {
					FyVO newZyVO = new FyVO(fyModelList.get(j).getDmms(),
							fyModelList.get(j).getDmbh(), fyModelList
									.get(j).getBz());
					zyList.add(newZyVO);
				}
			}
			jsgyVO.setXjfyList(zyList);

			// ������л�Ժ����Ϣ
			for (int j = 0; j < jsgyVO.getXjfyList().size(); j++) {
				List<FyVO> jyList = new ArrayList<FyVO>();// ��������ʼ����Ժ��Ϣlist
				for (int k = 0; k < fyModelList.size(); k++) {
					if (jsgyVO.getFydm().charAt(0) == fyModelList.get(k)
							.getDmbh().charAt(0)
							&& jsgyVO.getFydm().charAt(1) == fyModelList
									.get(j).getDmbh().charAt(1)
							&& jsgyVO.getXjfyList().get(j).getFydm().charAt(2) == fyModelList
									.get(k).getDmbh().charAt(2)
							&& jsgyVO.getXjfyList().get(j).getFydm().charAt(3) == fyModelList
									.get(k).getDmbh().charAt(3)
							&& fyModelList.get(k).getDmbh().charAt(8) != '0'
							&& fyModelList.get(k).getDmbh().charAt(9) != '0') {
						FyVO newJyVO = new FyVO(fyModelList.get(k).getDmms(),
								fyModelList.get(k).getDmbh(), fyModelList
										.get(k).getBz());
						jyList.add(newJyVO);
					}
				}
				jsgyVO.getXjfyList().get(j).setXjfyList(jyList);
			}
			jsgyVO = new FyVO(gyModel.getDmms(), gyModel.getDmbh(),
					gyModel.getBz(), zyList);
			return jsgyVO;
		} catch (Exception e) {
			logger.error("��÷�Ժ�б���Ϣʱ�����쳣", e);
			return null;
		}
	}

	public void setPub_DmbDao(Pub_DmbDao pub_DmbDao) {
		this.pub_DmbDao = pub_DmbDao;
	}
}