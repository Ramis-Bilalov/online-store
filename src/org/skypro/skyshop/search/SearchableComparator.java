package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        int lengthO1 = o1.getStringRepresentation().length();
        int lengthO2 = o2.getStringRepresentation().length();
        int compareIntegers = Integer.compare(lengthO1, lengthO2);
        String o1String = o1.getStringRepresentation();
        String o2String = o1.getStringRepresentation();
        if (compareIntegers == 0) {
            return o1String.compareTo(o2String);
        }
        return compareIntegers;
    }
}
