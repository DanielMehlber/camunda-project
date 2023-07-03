package de.thi.associations.bpmn.delegates;

import de.thi.associations.bpmn.data.MockDataBaseSingleton;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Daniel Mehlber
 */
public class AssociationChecker implements JavaDelegate {

    private final static Logger LOG = LoggerFactory.getLogger(AssociationChecker.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        final String associationName = (String) delegateExecution.getVariable("associationName");

        boolean exists = MockDataBaseSingleton.getInstance().getAssociation(associationName).isPresent();
        delegateExecution.setVariableLocal("associationExists", exists);

        if(exists) {
            LOG.info("✅ Verein {} existiert", associationName);
        } else {
            LOG.warn("⛔\uFE0F Verein {} ist dem System unbekannt. Abbruch.", associationName);
        }
    }
}
