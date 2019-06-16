package com.khusin

import com.khusin.RuleBeans.CaseWrapper
import org.kie.api.{KieBase, KieServices}
import org.kie.internal.command.CommandFactory

/**
  * Created by sinchan on 08/09/17.
  */
object DroolsUtil {

  def loadRules():KieBase ={
    val kieServices = KieServices.Factory.get()
    val kieContainer = kieServices.getKieClasspathContainer()
    return kieContainer.getKieBase("rules")
  }

  def applyRules(base: KieBase,garage: Garage): Garage ={
    val session = base.newStatelessKieSession();
    session.execute(CommandFactory.newInsert(garage));
    return garage;
  }

  def applyRulesForBundle(base: KieBase,caseWrapper: CaseWrapper): CaseWrapper ={
    val session = base.newStatelessKieSession();
    session.execute(CommandFactory.newInsert(caseWrapper));
    return caseWrapper;
  }
}
