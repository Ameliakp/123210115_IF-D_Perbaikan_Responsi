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
public class adminModel {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/al_maul";
    static final String USER = "root";
    static final String PASS = "";
    String idRenter;
    Connection connection;
    Statement statement;
    
    public adminModel(String idRenter) {
        this.idRenter = idRenter;
        try{
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Success");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Connection Failed");
        }
          
    }
     public int getRenterData(){
        try {
            int totalData = 0;
            String query = "SELECT * FROM `renter`";
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
        public String[][] readRenter(){
        try{
            int totalData = 0;
            
            String data[][] = new String[getRenterData()][7];
            
            String query = "SELECT * FROM `renter`"; 
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[totalData][0] = resultSet.getString("name");
                data[totalData][1] = resultSet.getString("id");                
                data[totalData][2] = resultSet.getString("contact");
                data[totalData][3] = resultSet.getString("duration");
                data[totalData][4] = resultSet.getString("bill");
                data[totalData][5] = resultSet.getString("status");
                data[totalData][6] = resultSet.getString("room");
                totalData++;
            }
            statement.close();
            return data;
               
        }catch(SQLException e){
            System.out.println("Error : " + e.getMessage());
            return null;
        }
    }
     public void updateData(String nama,String contact, String duration){
        try {
            
            String query = "UPDATE `renter` "
                    + "SET "
                    + "`name`='" + nama + "',"
                    + "`contact`='" + contact + "',"
                    + "`duration`='" + duration
                    + "' WHERE `id`='" + idRenter + "'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Update Success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(e.getMessage().equals("out")){
                JOptionPane.showMessageDialog(null, "Out of Bound");
            }else{
                JOptionPane.showMessageDialog(null, "Update Failed");
            }     
        }
    }
    
    public void deleteData () {
        try{
            String query = "DELETE FROM renter WHERE `id` = '"+idRenter+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Delete Success");
            
        }catch(SQLException e) {
            System.out.println("Error : " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Delete Failed");
        }
    }
     public void updateStatus(){
       JOptionPane.showConfirmDialog(null, "Are you want to proceed?", "Change Status", JOptionPane.YES_NO_OPTION);
       int choice = 0;
       if (choice == JOptionPane.YES_OPTION) {
            try {
            String query = "UPDATE `renter` "
                    + "SET "
                    + "`status`='Paid'"
                    + " WHERE `id`='" + idRenter + "'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Update Success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(e.getMessage().equals("out")){
                JOptionPane.showMessageDialog(null, "Out of Bound");
            }else{
                JOptionPane.showMessageDialog(null, "Update Failed");
            }     
        }
            System.out.println("User confirmed.");
        } else if (choice == JOptionPane.NO_OPTION) {
            // User clicked "No"
            System.out.println("User cancelled.");
        } else if (choice == JOptionPane.CANCEL_OPTION) {
            // User clicked "Cancel"
            System.out.println("User cancelled.");
        }
       
    }
}
