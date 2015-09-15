package nju.software.fyrs.service;

import java.util.List;
import java.util.Map;

import nju.software.fyrs.biz.vo.SdcxQueryVO;
import nju.software.fyrs.biz.vo.SdcxShowColumnsVO;

public interface SdcxService {
  public List<List<String>> listSdcx(SdcxQueryVO root,Map<String,List<SdcxShowColumnsVO>> showTableAndColumns,String ryk,int[] roleIds,int loginFydm);
}
