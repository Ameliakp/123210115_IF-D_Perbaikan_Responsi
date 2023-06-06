/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class roomModel {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/al_maul";
    static final String USER = "root";
    static final String PASS = "";
    public String username;
    Connection connection;
    Statement statement;
    
    public roomModel(String username) {
    this.username = username;
        try{
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Success");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Connection Failed");
        }
          
    }
    public int getRoomData(){
        try {
            int totalData = 0;
            String query = "SELECT * FROM `rooms`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                totalData++;
            }
            statement.close();
            return totalData;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return 0;
        }
    }
        public String[][] readRoom(){
        try{
            int totalData = 0;
            
            String data[][] = new String[getRoomData()][4];
            
            String query = "SELECT * FROM `rooms`"; 
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[totalData][0] = resultSet.getString("name");
                data[totalData][1] = resultSet.getString("size");                
                data[totalData][2] = resultSet.getString("price");
                data[totalData][3] = resultSet.getString("status");
                totalData++;
            }
            statement.close();
            return data;
               
        }catch(SQLException e){
            System.out.println("Error : " + e.getMessage());
            return null;
        }
    }
}
