package nju.software.fyrs.service;

import java.io.IOException;
import java.util.List;

import nju.software.fyrs.biz.vo.SysBackupVO;
import nju.software.fyrs.data.dataobject.SysBackup;

public interface SysBackupService {
  public List<SysBackupVO> listSysBackup();
  public void addSysBackup(SysBackup sysBackup);
  public SysBackup getSysBackup(String nid);
  public void deleteSysBackup(String nid);
  public boolean isGeneratorOnline(String basePath,String databaseName,String nid) throws IOException;
  public boolean isGeneratorOnlineAuto(String basePath,String databaseName,String dataBasePath,long currentTime) throws IOException;
}
