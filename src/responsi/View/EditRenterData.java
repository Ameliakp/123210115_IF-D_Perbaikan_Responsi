/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Orenji
 */
public class EditRenterData extends JFrame{

    JFrame window = new JFrame();
    JLabel lName = new JLabel("Name ");
    public JTextField tfName = new JTextField();
    JLabel lContact= new JLabel("Contact ");
    public JTextField tfContact = new JTextField();
    JLabel lRentTime = new JLabel("RentTime ");
    public JTextField tfRentTime = new JTextField();

    public JButton btnAddPanel = new JButton("Update");
    public JButton btnDelete = new JButton("Delete Renter");

    public EditRenterData() {
        window.setTitle("Renter Data");
        window.setLayout(null);
        window.setSize(550,200);
        //window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        window.add(lName);
        window.add(tfName);
        window.add(lContact);
        window.add(tfContact);
        window.add(lRentTime);
        window.add(tfRentTime);
        window.add(btnDelete);
        window.add(btnAddPanel);
        
        //LABEL
        lName.setBounds(5, 30, 120, 20);
        lContact.setBounds(5,60,120,20);
        lRentTime.setBounds(5,90,120,20);

//TEXTFIELD
        tfName.setBounds(110, 35, 120, 20);
        tfContact.setBounds(110, 65, 120, 20);
        tfRentTime.setBounds(110, 95, 120, 20);


//BUTTON PANEL
        btnAddPanel.setBounds(110, 125, 120, 20);
        btnDelete.setBounds(350, 35, 120, 40);
    }

    public String getContact() {
        return tfContact.getText();
    }

    public String getRentTime() {
        return tfRentTime.getText();
    }

    public String getName() {
        return tfName.getText();
    }
    
}

