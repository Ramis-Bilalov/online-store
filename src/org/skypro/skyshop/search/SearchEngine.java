package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        TreeSet<Searchable> searchableSet = searchSet.stream()
                .filter(searchable -> searchable.searchTerm().contains(searchTerm))
                .sorted(new SearchableComparator())
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
        return searchableSet;
    }

    public void addNewSearchable(Searchable searchable) {
        if (searchable != null) {
            searchSet.add(searchable);
        }
    }
}

