package de.thi.associations.bpmn.data;

import java.util.LinkedList;
import java.util.List;

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
}
