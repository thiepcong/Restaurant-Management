package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO669 {
	public static Connection con;
    
    public DAO669(){
        if(con == null){
            String dbUrl = "jdbc:mysql://localhost:3306/restaurant";
            String dbClass = "com.mysql.cj.jdbc.Driver";
            try {
                Class.forName(dbClass);
                con = DriverManager.getConnection (dbUrl, "root", "123456");
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
