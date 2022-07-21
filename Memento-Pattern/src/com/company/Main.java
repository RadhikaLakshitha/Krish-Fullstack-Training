package com.company;

public class Main {

    public static void main(String[] args) {

        Article article = new Article(1,"Microservices");
        article.setContent("Lorem ipsam");
        System.out.println(article);

        ArticleMemento articleMemento = article.createMemento();

        article.setContent("789456");
        System.out.println(article);


        article.restore(articleMemento);
        System.out.println(article);
    }
}
