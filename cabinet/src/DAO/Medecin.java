package DAO;

import static DAO.client.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Medecin {
    private int id;
    private int version;
    private String titre;
    private String nom;
    private String prenom;
    public Medecin (int id,int version,String titre,String nom,String prenom){
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
      public void updateMedecin(Medecin cn){
        con=Connect.getCon();
        String req="update medecins SET version=? ,titre=?,nom=?,prenom=? where id=?";
        try{
            PreparedStatement ps=con.prepareStatement(req);
            ps.setString(3,cn.getTitre());
            ps.setString(4,cn.getNom());
            ps.setString(5,cn.getPrenom());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public Medecin getMedecin(int idc){
        Medecin med =null;
        con=Connect.getCon();
        String req="select * from medecins where id=?";
        try{
            PreparedStatement ps=con.prepareStatement(req);
            ps.setInt(1,idc);
            ResultSet res=ps.executeQuery();
            if(res.next()){
                med=new Medecin(idc,res.getInt("version"),res.getString("titre"),res.getString("nom"),res.getString("prenom"));
            }
        }catch(SQLException e){
                        e.printStackTrace();
        }
         return null;
    }
    public List<Medecin> getMedecins() throws SQLException{
        PreparedStatement pst;
        ResultSet rs;
        List<Medecin> l=new ArrayList<>();
        con=Connect.getCon();
        String req="select * from medecins";
        try{
         pst=con.prepareStatement(req);
             rs=pst.executeQuery();
            if(rs.next()){
                Medecin cn=new Medecin(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5));
       l.add(cn);
        }
        return l;
    }catch(SQLException e){
        e.printStackTrace();
    }
        return null;
}
}
