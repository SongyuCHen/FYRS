package nju.software.fyrs.service;

import nju.software.fyrs.data.dataobject.Dwxx;

public interface DwxxService {
  public Dwxx findDwxxByFy(int fydm);
  public void updateDwxxByFy(Dwxx dwxx);
}
