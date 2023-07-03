package de.thi.associations.bpmn.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Daniel Mehlber
 */
public class CancellationReasonRecorder implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(CancellationReasonRecorder.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String reason = (String) delegateExecution.getVariable("reason");

        LOG.info("\uD83D\uDCDD Grund für Austritt wurde vermerkt: {}", reason);
    }
}
