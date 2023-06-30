package de.thi.associations.bpmn.delegates;

import de.thi.associations.bpmn.data.Association;
import de.thi.associations.bpmn.data.Member;
import de.thi.associations.bpmn.data.MockDataBaseSingleton;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MemberChecker implements JavaDelegate {

    private final static Logger LOG = LoggerFactory.getLogger(MemberChecker.class);

    private boolean doesMemberExist(List<Member> members, String memberName) {
        for(Member member : members) {
            if (member.getName().equals(memberName) && !member.isCancelled()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        final String memberName = (String) delegateExecution.getVariable("memberName");
        final String associationName = (String) delegateExecution.getVariable("associationName");

        MockDataBaseSingleton database = MockDataBaseSingleton.getInstance();
        Association association = database.getAssociation(associationName).get();

        boolean found = doesMemberExist(association.getMemberList(), memberName);
        delegateExecution.setVariableLocal("isMember", found);

        if(found) {
            LOG.info("member {} is in association {}", memberName, associationName);
        } else {
            LOG.warn("no member {} in association {}", memberName, associationName);
        }
    }
}
