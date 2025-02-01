package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    static Set<Searchable> searchSet = new TreeSet<>(new SearchableComparator());


    public Searchable getSearchTerm(String searchItem) throws BestResultNotFound {
        for (Searchable searchable : searchSet) {
            if (searchable.getStringRepresentation().contains(searchItem)) {
                return searchable;
            }
        }
        return null;
    }

    public Set<Searchable> getSearchSet(String searchTerm) {
        Set<Searchable> newSet = new HashSet<>();
        for (Searchable searchable : searchSet) {
            if (searchable.searchTerm().contains(searchTerm)) {
                newSet.add(searchable);
            }
        }
        return newSet;
    }

    public void addNewSearchable(Searchable searchable) {
        if (searchable != null) {
            searchSet.add(searchable);
        }
    }
}

