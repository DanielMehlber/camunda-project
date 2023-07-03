package de.thi.associations.bpmn.delegates.messages;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Daniel Mehlber
 */
public class MemberCancellationConfirmationSender implements JavaDelegate {

    private final static Logger LOG = LoggerFactory.getLogger(AssociationManagerCancellationNotifier.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        final String member = (String) delegateExecution.getVariable("memberName");
        final String association = (String) delegateExecution.getVariable("associationName");


        LOG.info("✉ An Mitglied {}: Deine Austrittsanfrage aus Verein {} wird verarbeitet", member,association);
    }

}
