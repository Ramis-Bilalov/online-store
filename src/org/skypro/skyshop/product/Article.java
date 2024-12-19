package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {

    String articleName;
    String articleText;

    public Article(String articleName, String articleText) {
        this.articleName = articleName;
        this.articleText = articleText;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return articleName + "\n" + articleText;
    }

    @Override
    public String searchTerm() {
        return articleName + "\n" + articleText;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }
}
