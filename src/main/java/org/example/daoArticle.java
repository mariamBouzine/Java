package org.example;

import java.util.List;

public interface daoArticle {
    public  void create(Article art);
    public  void All();
    public List<Article> SetAll();
    public void Update(Article art);
    public void DeleteArticle(Article art);


}
