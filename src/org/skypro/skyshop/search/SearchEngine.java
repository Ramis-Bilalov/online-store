package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    static Set<Searchable> searchArray = new TreeSet<>(new SearchableComparator());


    public Searchable getSearchTerm(String searchItem) throws BestResultNotFound {
        for (Searchable searchable : searchArray) {
            if (searchable.getStringRepresentation().contains(searchItem)) {
                return searchable;
            }
        }
        return null;
    }

    public Set<Searchable> getSearchArray(String searchTerm) {
        Set<Searchable> newArray = new HashSet<>();
        for (Searchable searchable : searchArray) {
            if (searchable.searchTerm().contains(searchTerm)) {
                newArray.add(searchable);
            }
        }
        return newArray;
    }

    public void addNewSearchable(Searchable searchable) {
        if (searchable != null) {
            searchArray.add(searchable);
        }
    }
}

