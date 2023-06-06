/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import responsi.Model.rentModel;
import responsi.Model.userModel;
import responsi.View.LoginPageView;
import responsi.View.RenterDataView;

/**
 *
 * @author Lenovo
 */
public class rentController {
    rentModel model;
    RenterDataView view;
    
    public rentController (rentModel model, RenterDataView view){
        this.model = model;
        this.view = view;
        
         view.btnAddPanel.addActionListener(new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String nama = view.getName();
                String id = view.getId();
                String contact = view.getContact();
                String durasi = view.getRentTime();
                model.insertData(nama, id, contact, durasi);
            }
           
        });
    }
}
