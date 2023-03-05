package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoArticleImp implements daoArticle{
    private Connection MyCon;
    public daoArticleImp(){
        MyCon = daoFactory.getConnection();
    }
    @Override
    public void create(Article art) {
        String Req;
        Req="INSERT INTO `article`(`Code`, `Descreption`, `Prix`) VALUES(?,?,?)";
        PreparedStatement Pst;
        try {
            Pst = MyCon.prepareStatement(Req);
            Pst.setString(1,art.getCode());
            Pst.setString(2,art.getDescreption());
            Pst.setFloat(3,art.getPrix());
            int lig=Pst.executeUpdate();
            if(lig==0){
                System.out.println("article add with success");
            }else {
                System.out.println("article added  failed !!!!");
            }
        }catch (SQLException ex){
            ex.getMessage();
        }
    }
    public void All(){
        String req;
        req = "SELECT * FROM `article`";
        Statement St;
        try{
            St=MyCon.createStatement();
            ResultSet rs = St.executeQuery(req);
            System.out.println("LISTE DES ARTICLE");
            while (rs.next()){
                System.out.println(rs.getString(1)+" :"+
                                   rs.getString("Descreption") +""+
                                   rs.getFloat(3));
            }
        }catch (SQLException ex){
            ex.getMessage();
        }
    }

    @Override
    public List<Article> SetAll() {
        String req;
        req = "SELECT * FROM `article`";
        Statement St;
        Article art;
        List<Article> articles=new ArrayList<Article>();
        try{
            St=MyCon.createStatement();
            ResultSet rs = St.executeQuery(req);
            while (rs.next()){
                art=new Article();
                art.setCode(rs.getString(1));
                art.setDescreption(rs.getString(2));
                art.setPrix(rs.getFloat(3));
                articles.add(art);
            }
        }catch (SQLException ex){
            ex.getMessage();
        }
        return articles;
    }

    public void Update(Article art) {
        String Req;
        Req="UPDATE `article` SET `Descreption`=?,`Prix`=? WHERE Code=?";
        PreparedStatement Pst;
        try {
            Pst = MyCon.prepareStatement(Req);
            Pst.setString(1,art.getCode());
            Pst.setString(2,art.getDescreption());
            Pst.setFloat(3,art.getPrix());
            int lig=Pst.executeUpdate();
            if(lig!=0){
                System.out.println("article update with success");
            }else {
                System.out.println("article update  failed !!!!");
            }
        }catch (SQLException ex){
            ex.getMessage();
        }
    }

    @Override
    public void DeleteArticle(Article art) {
        String Req;
        Req="DELETE FROM `article` WHERE Code=?";
        PreparedStatement Pst;
        try {
            Pst = MyCon.prepareStatement(Req);
            Pst.setString(1,art.getCode());
            Pst.executeUpdate();
            int lig=Pst.executeUpdate();
            if(lig!=0){
                System.out.println("article Delete with success");
            }else {
                System.out.println("article Delete  failed !!!!");
            }
        }catch (SQLException ex){
            ex.getMessage();
        }
    }
    public Article getArticle(String code){return null;}
}
