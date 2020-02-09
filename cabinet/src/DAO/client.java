package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class client {
    public static Connection con;
     private int id;
    private int version;
    private String titre;
    private String nom;
    private String prenom;
    public client (int id,int version,String titre,String nom,String prenom){
        super();
        this.id=id;
        this.version=version;
        this.titre=titre;
        this.nom=nom;
        this.prenom=prenom;
        
    }
    public int getId(){
        return id;
    }
    public void SetId(int id){
        this.id=id;
        
    }
    public int getVersion(){
        return version;
    }
    public void SetVersion(int version){
        this.version=id;
        
    }public String getTitre(){
        return titre;
    }
    public void SetTitre(String titre){
        this.titre=titre;
        
    }public String getNom(){
        return nom;
    }
    public void SetNom(String nom){
        this.nom=nom;
        
    }public String getPrenom(){
        return prenom;
    }
    public void SetPrenom(String prenom){
        this.prenom=prenom;
        
    }
    public void updateClient(client c){
        con=Connect.getCon();
        String req="update clients SET version=? ,titre=?,nom=?,prenom=? where id=?";
        try{
            PreparedStatement ps=con.prepareStatement(req);
            ps.setString(3,c.getTitre());
            ps.setString(4,c.getNom());
            ps.setString(5,c.getPrenom());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public client getClient(int idc){
        client cli =null;
        con=Connect.getCon();
        String req="select * from clients where id=?";
        try{
            PreparedStatement ps=con.prepareStatement(req);
            ps.setInt(1,idc);
            ResultSet res=ps.executeQuery();
            if(res.next()){
                cli=new client(idc,res.getInt("version"),res.getString("titre"),res.getString("nom"),res.getString("prenom"));
            }
        }catch(SQLException e){
                        e.printStackTrace();
        }
         return null;
    }
    public List<client> getClients() throws SQLException{
        PreparedStatement pst;
        ResultSet rs;
        List<client> lp=new ArrayList<>();
        con=Connect.getCon();
        String req="select * from clients";
        try{
         pst=con.prepareStatement(req);
             rs=pst.executeQuery();
            if(rs.next()){
                client c=new client(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5));
       lp.add(c);
        }
        return lp;
    }catch(SQLException e){
        e.printStackTrace();
    }
        return null;
}}
