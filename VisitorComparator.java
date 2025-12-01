// VisitorComparator.java
// Compares Visitors first by age (ascending), then by name (alphabetical)

import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {

    @Override
    public int compare(Visitor v1, Visitor v2) {
        if (v1.getAge() != v2.getAge()) {
            return Integer.compare(v1.getAge(), v2.getAge());
        }
        return v1.getName().compareToIgnoreCase(v2.getName());
    }
}