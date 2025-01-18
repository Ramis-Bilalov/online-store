package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    static Map<String, Searchable> searchArray = new TreeMap<>();


    public Searchable getSearchTerm(String searchItem) throws BestResultNotFound {
        for (Map.Entry<String, Searchable> entry : searchArray.entrySet()) {
            Searchable value = entry.getValue();
            if (value.getStringRepresentation().contains(searchItem)) {
                return value;
            }
        }
        return null;
    }

    public List<Searchable> getSearchArray(String searchTerm) {
        List<Searchable> newArray = new LinkedList<>();
        for (Map.Entry<String, Searchable> entry : searchArray.entrySet()) {
            Searchable value = entry.getValue();
            if (value.searchTerm().contains(searchTerm)) {
                newArray.add(value);
            }
        }
        return newArray;
    }

    public void addNewSearchable(Searchable searchable) {
        if (searchable != null) {
            searchArray.put(searchable.searchTerm(), searchable);
        }
    }
}

