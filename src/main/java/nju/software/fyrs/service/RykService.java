package nju.software.fyrs.service;

import java.util.List;

import nju.software.fyrs.service.model.RykcxModel;
import nju.software.fyrs.service.model.RyviewModel;


/**
 * @author ypc
 * »À‘±ø‚Service
 *
 */
public interface RykService {

	List<RyviewModel> getRyviewList(RykcxModel cx);

	boolean swapOrder(Integer fydm, Integer rybh1, Integer rybh2);

	boolean swapRcOrder(Integer fydm, Integer rybh1, Integer rybh2, Integer rcklx);

//	boolean addRc(int rybh, int fydm, int rcklx);

	boolean moveToHistory(Integer fydm, Integer rybh, Integer rcklx);

	boolean addFzbry(Integer fydm, Integer rybh, Integer fzbrylx, Integer bm);

	boolean moveToFzbHistory(Integer fydm, Integer rybh, Integer bm, Integer fzbrylx);

}
