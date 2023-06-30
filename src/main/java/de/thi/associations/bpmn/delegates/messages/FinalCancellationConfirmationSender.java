package de.thi.associations.bpmn.delegates.messages;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FinalCancellationConfirmationSender implements JavaDelegate {

    private final static Logger LOG = LoggerFactory.getLogger(FinalCancellationConfirmationSender.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        final String member = (String) delegateExecution.getVariable("memberName");
        final String association = (String) delegateExecution.getVariable("associationName");


        LOG.info("Notification to former member {}:  You successfully left association {}", member, association);
    }

}
