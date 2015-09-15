package nju.software.fyrs.service.convertor;

import nju.software.fyrs.data.dataobject.Pub_DmbDO;
import nju.software.fyrs.service.model.DmbModel;
import nju.software.fyrs.util.BeanUtilsEx;

public class DmbConvertor {

	public static DmbModel getDmModelByPub_DmbDO(Pub_DmbDO dmbDO) {
		DmbModel dmModel = new DmbModel();
		BeanUtilsEx.copyProperties(dmbDO, dmModel);
		return dmModel;
	}

	public static Pub_DmbDO getPub_DmbDOByDmModel(DmbModel dmModel) {
		Pub_DmbDO dmbDO = new Pub_DmbDO();
		BeanUtilsEx.copyProperties(dmModel, dmbDO);
		return dmbDO;
	}
}
