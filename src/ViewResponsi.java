/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import responsi.Controller.loginController;
import responsi.Model.userModel;
import responsi.View.LoginPageView;

/**
 *
 * @author OWNER
 */
public class ViewResponsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        userModel model = new userModel();
        LoginPageView view = new LoginPageView();
        loginController controller = new loginController(model,view);
    }   
}
