package de.thi.associations.bpmn.data;

import java.util.*;

public class MockDataBaseSingleton {

    private List<Association> associations;

    private static MockDataBaseSingleton singleton;

    private MockDataBaseSingleton() {
        associations = new LinkedList<>();

        Association neuland = new Association("Neuland");
        Association studentsLife = new Association("StudentsLife");
        associations.add(neuland);
        associations.add(studentsLife);

        neuland.getMemberList().add(new Member("Susi", 30));
        neuland.getMemberList().add(new Member("Hugo", 20));
        neuland.getMemberList().add(new Member("Kermit", 25));

        studentsLife.getMemberList().add(new Member("Susi", 10));
    }

    public static MockDataBaseSingleton getInstance() {
        if(singleton == null) {
            singleton = new MockDataBaseSingleton();
        }

        return singleton;
    }

    public List<Association> getAssociations() {
        return associations;
    }

    public void setAssociations(List<Association> associations) {
        this.associations = associations;
    }

    public Optional<Association> getAssociation(String name) {
        for(Association association : associations) {
            if(association.getName().equals(name)) {
                return Optional.of(association);
            }
        }

        return Optional.empty();
    }
}
