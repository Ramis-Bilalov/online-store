package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {

    static List<Searchable> searchArray = new LinkedList<>();


    public SearchEngine() {
        searchArray = new LinkedList<>();
    }

    public Searchable getSearchTerm(String searchItem) throws BestResultNotFound {
        for (Searchable searchable : searchArray) {
            if (searchable.getStringRepresentation().contains(searchItem)) {
                return searchable;
            }
        }
        return null;
    }

        public List<Searchable> getSearchArray (String searchTerm){
            List<Searchable> newArray = new LinkedList<>();

            for (Searchable searchable : searchArray) {
                if (searchable.searchTerm().contains(searchTerm)) {
                    newArray.add(searchable);
                }
            }
            return newArray;
        }

        public void addNewSearchable (Searchable searchable){
            if (searchable != null) {
                searchArray.add(searchable);
            }
        }
    }

