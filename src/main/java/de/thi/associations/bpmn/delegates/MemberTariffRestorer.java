package de.thi.associations.bpmn.delegates;

import de.thi.associations.bpmn.data.Member;
import de.thi.associations.bpmn.data.MockDataBaseSingleton;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Daniel Mehlber
 */
public class MemberTariffRestorer implements JavaDelegate {

    private final static Logger LOG = LoggerFactory.getLogger(MemberTariffRestorer.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        final String member = (String) delegateExecution.getVariable("memberName");
        final String association = (String) delegateExecution.getVariable("associationName");

        Member memberInstance = MockDataBaseSingleton.getInstance().getAssociation(association).get().findMember(member).get();

        LOG.info("✨ Tarif (Monatsbeitrag {}€) von Mitglied {} in Verein {} wiederhergestellt", memberInstance.getMonthlyFee(), member, association);
    }

}
