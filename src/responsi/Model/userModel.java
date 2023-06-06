/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import responsi.Controller.adminController;
import responsi.Controller.roomController;
import responsi.View.AdminPageView;
import responsi.View.RoomListView;

/**
 *
 * @author Lenovo
 */
public class userModel {
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/al_maul";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection connection;
    Statement statement;
    
    public userModel() {
        try{
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Success");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Connection Failed");
        }
    }
    public void loginUser(String username, String password){
           try {
            String query = "SELECT * FROM `accounts` WHERE `username` = '" +username+"' AND `password` = '" +password+ "' AND `role` = 'renter'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if(resultSet.next()){
                roomModel model = new roomModel(username);
                RoomListView view = new RoomListView();
                roomController controller = new roomController(model,view);
            }
            else{
             statement.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
              try {
            String query = "SELECT * FROM `accounts` WHERE `username` = '" +username+"' AND `password` = '" +password+ "' AND `role` = 'admin'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if(resultSet.next()){
                adminModel model = new adminModel(username);
                AdminPageView view = new AdminPageView();
                adminController controller = new adminController(model,view);
            }
            else{
             statement.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    
    }
}
