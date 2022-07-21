package com.company;

public class Article {

    private long id;
    private String title;
    private  String content;

    public Article(long id, String title) {
        super();
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArticleMemento createMemento(){
        ArticleMemento articleMemento = new ArticleMemento(id,title,content);
        return articleMemento;
    }

    public void restore(ArticleMemento article){
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }

    public String toString(){
        return "Article { id: "+id+", title : "+title+", content: "+content+" }";
    }

}
