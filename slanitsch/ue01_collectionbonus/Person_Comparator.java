package slanitsch.ue01_collectionbonus;

import java.util.Comparator;

public class Person_Comparator implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b) {
        int person1Length = a.famname.length();
        int person2Length = b.famname.length();
        if (person1Length != person2Length) {
            return Integer.compare(person1Length, person2Length);
        } else {
            return a.famname.compareToIgnoreCase(b.famname);
        }
    }
}

