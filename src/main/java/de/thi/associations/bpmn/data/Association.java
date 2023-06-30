package de.thi.associations.bpmn.data;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Association {

    private String name;
    private List<Member> memberList;

    public Association(String name) {
        this.name = name;
        this.memberList = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public Optional<Member> findMember(String name) {
        for(Member member : memberList) {
            if(member.getName().equals(name)) {
                return Optional.of(member);
            }
        }

        return Optional.empty();
    }

    public void removeMember(String name) {
        findMember(name).get().setCancelled(true);
    }

    public void restoreMember(String name) {
        findMember(name).get().setCancelled(false);
    }
}
