package DAO;

import static DAO.client.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class rv {
     private int id;
    private int jour;
    private int id_client;
    private int id_creneau;
    private int getIdcreneau;
    public rv (int id,int jour,int id_client,int id_creneau){
        super();
        this.id=id;
        this.jour=jour;
        this.id_client=id_client;
        this.id_creneau=id_creneau;
        
    }
    public int getId(){
        return id;
    }
    public void SetId(int id){
        this.id=id;
        
    }
    public int getJour(){
        return jour;
    }
    public void SetJour(int jour){
        this.jour=jour;
        
    }public int getIdclient(){
        return id_client;
    }
    public void SetIdclient(int id_client){
        this.id_client=id_client;
        
    }public int getIdcreneau(){
        return id_creneau;
    }
    public void SetIdcreneau(int id_creneau){
        this.id_creneau=id_creneau;
        
    }
      public void updateRv(rv c){
        con=Connect.getCon();
        String req="update rv SET jour=? ,id_client=?,id_creneau=? where id=?";
        try{
            PreparedStatement ps=con.prepareStatement(req);
            ps.setInt(2,c.getJour());
            ps.setInt(3,c.getIdclient());
            ps.setInt(4,c.getIdcreneau());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public rv getRv(int idc){
        rv cli =null;
        con=Connect.getCon();
        String req="select * from rv where id=?";
        try{
            PreparedStatement ps=con.prepareStatement(req);
            ps.setInt(1,idc);
            ResultSet res=ps.executeQuery();
            if(res.next()){
                cli=new rv(idc,res.getInt("jour"),res.getInt("id_client"),res.getInt("id_creneau"));
            }
        }catch(SQLException e){
                        e.printStackTrace();
        }
         return null;
    }
    public List<rv> getRvs() throws SQLException{
        PreparedStatement pst;
        ResultSet rs;
        List<rv> lp=new ArrayList<>();
        con=Connect.getCon();
        String req="select * from rv";
        try{
         pst=con.prepareStatement(req);
             rs=pst.executeQuery();
            if(rs.next()){
                rv c=new rv(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
       lp.add(c);
        }
        return lp;
    }catch(SQLException e){
        e.printStackTrace();
    }
        return null;
}
}
