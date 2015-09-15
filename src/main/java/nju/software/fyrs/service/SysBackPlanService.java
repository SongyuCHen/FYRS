package nju.software.fyrs.service;

import java.util.List;

import nju.software.fyrs.data.dataobject.SysBackPlan;

public interface SysBackPlanService {
  public List<SysBackPlan> listSysBackPlans();
  public void addSysBackPlan(SysBackPlan sysBackPlan);
  public void updateSysBackPlan(SysBackPlan sysBackPlan);
}
