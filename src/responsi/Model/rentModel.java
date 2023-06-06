/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class rentModel {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/al_maul";
    static final String USER = "root";
    static final String PASS = "";
    String roomName;
    String harga;
    Connection connection;
    Statement statement;
    
    public rentModel(String roomName, String harga) {
        this.roomName = roomName;
        this.harga = harga;
        try{
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Success");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Connection Failed");
        }
          
    }
    public void insertData(String name, String contact, String id, String duration){
         try {
            String query = "INSERT INTO `renter` (`name`, `contact`, `id`, `duration`, `bill`, `status`, `room`) " + 
                        "VALUES ('" + name + "','" + contact + "','" + id + "','" + duration + "','" + harga + "',"+ "'notPaid'"+ ",'" + roomName + "')";
            String sql = "UPDATE `rooms` "
                    + "SET "
                    + "`status`='"+name+"'"
                    + " WHERE `name`='" + roomName + "'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.executeUpdate(sql);
            
            JOptionPane.showMessageDialog(null, "Register Success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(e.getMessage().equals("out")){
                JOptionPane.showMessageDialog(null, "Out of Bound");
            }else{
                JOptionPane.showMessageDialog(null, "Register Failed");
            }     
        }
    }
}
