package de.thi.associations.bpmn.delegates;

import de.thi.associations.bpmn.data.MockDataBaseSingleton;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Daniel Mehlber
 */
public class MemberRemover implements JavaDelegate {

    private final static Logger LOG = LoggerFactory.getLogger(MemberRemover.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        final String member = (String) delegateExecution.getVariable("memberName");
        final String association = (String) delegateExecution.getVariable("associationName");

        MockDataBaseSingleton database = MockDataBaseSingleton.getInstance();
        database.getAssociation(association).get().removeMember(member);

        LOG.info("\uD83E\uDDF9 Mitglied {} wurde erfolgreich von Verein {} entfernt", member, association);
    }
}
