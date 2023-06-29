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

        neuland.getMemberList().add(new Member("Susi Sorglos"));
        neuland.getMemberList().add(new Member("Hugo Habicht"));
        neuland.getMemberList().add(new Member("Kermit Frog"));

        studentsLife.getMemberList().add(new Member("Susi Sorglos"));
    }

    public static MockDataBaseSingleton getInstance() {
        if(singleton == null) {
            singleton = new MockDataBaseSingleton();
        }

        return singleton;
    }

}
