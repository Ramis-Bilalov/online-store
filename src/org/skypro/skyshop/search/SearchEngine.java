package org.skypro.skyshop.search;

public class SearchEngine {

    Searchable[] searchArray;
    int arraySize;


    public SearchEngine(int arraySize) {
        this.arraySize = arraySize;
        searchArray = new Searchable[arraySize];
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

