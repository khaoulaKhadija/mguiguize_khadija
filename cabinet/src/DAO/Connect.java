package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {
    private static Connection con;
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql:"+"//127.0.0.1:3306/cabinet","root","");
            System.out.println("bien connecté");
        }catch(SQLException e){
            System.out.println(e);
            System.out.println("Probléme au niveau de BD");
        } catch (ClassNotFoundException ex) {
             System.out.println("Probléme au niveau de pilote");
        } 
    }
    public static Connection getCon(){
        return con;
    }
    public static void main(String [] args){
         getCon();
     }
}
