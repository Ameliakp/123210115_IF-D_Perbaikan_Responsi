/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import responsi.Model.adminModel;
import responsi.Model.rentModel;
import responsi.View.EditRenterData;
import responsi.View.RenterDataView;

/**
 *
 * @author Lenovo
 */
public class editController {
       adminModel model;
    EditRenterData view;
    
    public editController (adminModel model, EditRenterData view){
        this.model = model;
        this.view = view;
        
         view.btnAddPanel.addActionListener(new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String nama = view.getName();
                String contact = view.getContact();
                String durasi = view.getRentTime();
                model.updateData(nama,contact, durasi);
            }
        });
          view.btnDelete.addActionListener(new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent arg0) {             
                model.deleteData();
            }
        });
    }
}
