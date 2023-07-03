package de.thi.associations.bpmn.delegates.debug;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemberLeftAssociation implements JavaDelegate {

    private final static Logger LOG = LoggerFactory.getLogger(MemberLeftAssociation.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        final String member = (String) delegateExecution.getVariable("memberName");
        final String association = (String) delegateExecution.getVariable("associationName");

        LOG.info("\uD83C\uDFC1 {} hat den Verein {} endgültig verlassen", member, association);
    }
}
