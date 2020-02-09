package DAO;

import static DAO.client.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class creneau {
      private int id;
    private int version;
    private int hdebut;
    private int mdebut;
       private int hfin;
    private int mfin;
    private int id_medecin;
    public creneau (int id,int version,int hdebut,int mdebut,int hfin,int mfin, int id_medecin){
        super();
        this.id=id;
        this.version=version;
        this.hdebut=hdebut;
        this.mdebut=mdebut;
        this.hfin=hfin;
        this.mfin=mfin;
        this.id_medecin=id_medecin;
        
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
        this.version=version;
        
    }public int getHdebut(){
        return hdebut;
    }
    public void SetHdebut(int hdebut){
        this.hdebut=hdebut;
        
    }public int getMdebut(){
        return mdebut;
    }
    public void SetMdebut(int mdebut){
        this.mdebut=mdebut;
        }
    public int getHfin(){
        return hfin;
    }
    public void SetHfin(int hfin){
        this.hfin=hfin;
        
    }public int getMfin(){
        return mfin;
    }
    public void SetMfin(int mfin){
        this.mfin=mfin;
        
    }public int getIdmedecin(){
        return id_medecin;
    }
    public void SetIdmedecin(int id_medecin){
        this.id_medecin=id_medecin;
        
    }
      public void updateCreneau(creneau c){
        con=Connect.getCon();
        String req="update creneaux SET version=? ,hdebut=?,mdebut=?,hfin=? ,mfin=?,id_medecin=?where id=?";
        try{
            PreparedStatement ps=con.prepareStatement(req);
            ps.setInt(2,c.getVersion());
            ps.setInt(3,c.getHdebut());
            ps.setInt(4,c.getHfin());
            ps.setInt(5,c.getMdebut());
            ps.setInt(6,c.getMfin());
            ps.setInt(7,c.getIdmedecin());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public creneau getCreneau(int idc){
        creneau cli =null;
        con=Connect.getCon();
        String req="select * from creneaux where id=?";
        try{
            PreparedStatement ps=con.prepareStatement(req);
            ps.setInt(1,idc);
            ResultSet res=ps.executeQuery();
            if(res.next()){
                cli=new creneau(idc,res.getInt("version"),res.getInt("hdebut"),res.getInt("hfin"),res.getInt("mdebut"),res.getInt("mfin"),res.getInt("id_medecin"));
            }
        }catch(SQLException e){
                        e.printStackTrace();
        }
         return null;
    }
    public List<creneau> getCreneaux() throws SQLException{
        PreparedStatement pst;
        ResultSet rs;
        List<creneau> lp=new ArrayList<>();
        con=Connect.getCon();
        String req="select * from creneaux";
        try{
         pst=con.prepareStatement(req);
             rs=pst.executeQuery();
            if(rs.next()){
                creneau c=new creneau(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7));
       lp.add(c);
        }
        return lp;
    }catch(SQLException e){
        e.printStackTrace();
    }
        return null;
}
}
