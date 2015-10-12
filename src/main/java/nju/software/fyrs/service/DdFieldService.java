package nju.software.fyrs.service;

import java.util.List;

import nju.software.fyrs.biz.vo.DdFieldCondtionVO;
import nju.software.fyrs.biz.vo.DdFieldVO;

public interface DdFieldService {
  public List<DdFieldVO> listByTableName(String tableName);
  public DdFieldVO getDdFieldByCName(String cName);
  public List<DdFieldCondtionVO> listByTableNameCondition(String tableName);
public Short getMaincodeByTableIdAndFieldName(String tableId,
		String fieldName);
public String getCnnameByTableIdAndFieldName(String tableId,
		String fieldName);
}
