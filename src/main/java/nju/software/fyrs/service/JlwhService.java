package nju.software.fyrs.service;

import java.util.List;

import nju.software.fyrs.data.dataobject.Jlwh;

public interface JlwhService {
   public List<Jlwh> listJlwhByFyBm(int fydm,int bmbh);
   public List<Jlwh> listJlwhByFy(int fydm);
   public Jlwh addJlwh(Jlwh jlwh);
   public void updateJlwh(Jlwh jlwh);
   public Jlwh getJlwh(int fydm,String nid);
   public void deleteJlwh(int fydm,String nid);
}
