package slanitsch.ue01_collectionbonus;

import java.util.Objects;

public class Person implements Comparable<Person> {
    public String vorname;
    public String famname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(vorname.trim().toLowerCase(), person.vorname.trim().toLowerCase()) &&
                Objects.equals(famname.trim().toLowerCase(), person.famname.trim().toLowerCase());
    }

    @Override
    public int hashCode() {

        return Objects.hash(vorname, famname);
    }

    @Override
    public int compareTo(Person o) {
        if (famname.equals(o.famname)) {
            return vorname.compareToIgnoreCase(o.vorname);
        } else {
            return famname.compareToIgnoreCase(o.famname);
        }
    }
}
