package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

public class SearchEngine {

    Searchable[] searchArray;
    int arraySize;


    public SearchEngine(int arraySize) {
        this.arraySize = arraySize;
        searchArray = new Searchable[arraySize];
    }

    public Searchable getSearchTerm(String searchItem) throws BestResultNotFound {
        Searchable searchable = null;
        int count = 0;
        for (int i = 0; i < searchArray.length; i++) {
            if(searchArray[i].toString().contains(searchItem)) {
                count++;
                System.out.println(searchArray[i].toString());
                searchable = searchArray[i];
            }
        }
        if(searchable != null) {
            return searchable;
        } else throw new BestResultNotFound("Для поисковой строки " + searchItem + " не нашлось подходящей статьи");
    }

    public Searchable[] getSearchArray(String searchTerm) {
        Searchable[] newArray = new Searchable[5];
        for (int i = 0; i < arraySize; i++) {
            if (searchArray[i].getStringRepresentation().contains(searchTerm)) {
                int count = 0;
                newArray[count] = searchArray[i];
                count++;
                if(i == arraySize) {
                    break;
                }
            }
        }
        return newArray;
    }

    public void addNewSearchable(Searchable object) {
        for (int i = 0; i < arraySize; i++) {
            if(searchArray[i]==null) {
                searchArray[i] = object;
                break;
            }
        }
    }
}

