package de.thi.associations.bpmn.delegates;

import de.thi.associations.bpmn.data.MockDataBaseSingleton;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Daniel Mehlber
 */
public class MemberRestorer implements JavaDelegate {

    private final static Logger LOG = LoggerFactory.getLogger(MemberRestorer.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        final String member = (String) delegateExecution.getVariable("memberName");
        final String association = (String) delegateExecution.getVariable("associationName");

        MockDataBaseSingleton database = MockDataBaseSingleton.getInstance();
        database.getAssociation(association).get().restoreMember(member);

        LOG.info("✨ Mitgliedschaft von {} in Verein {} wiederhergestellt", member, association);
    }
}
