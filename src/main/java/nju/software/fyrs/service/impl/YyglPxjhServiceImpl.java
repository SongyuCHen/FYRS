package nju.software.fyrs.service.impl;

import java.util.List;

import nju.software.fyrs.biz.vo.YyglPxjhVO;
import nju.software.fyrs.data.dao.RysxTablekeyDAO;
import nju.software.fyrs.data.dao.YyglPxjhDAO;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.YyglPxjhService;

public class YyglPxjhServiceImpl implements YyglPxjhService {
	private YyglPxjhDAO yyglPxjhDAO;
	private DmService dmService;
	private RysxTablekeyDAO rysxTablekeyDAO;
	@Override
	public List<YyglPxjhVO> getPxjhByFy(String fydm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public YyglPxjhVO getPxjhById(String id, String fydm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public YyglPxjhVO addPxjh(YyglPxjhVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public YyglPxjhVO updatePxjh(YyglPxjhVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delPxjhById(String id, String fydm) {
		// TODO Auto-generated method stub
		return false;
	}

}
