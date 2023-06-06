/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import responsi.Model.adminModel;

import responsi.View.AdminPageView;
import responsi.View.EditRenterData;
import responsi.View.LoginPageView;
/**
 *
 * @author Lenovo
 */
public class adminController {
    adminModel model;
    AdminPageView view;
    Object columnName[] = {"name", "id", "contact", "duration", "bill", "status", "room"};
        public adminController(adminModel model, AdminPageView view){
        this.model = model;
        this.view = view;
        
        if (model.getRenterData()!=0) {
            String dataRenter[][] = model.readRenter();
            view.tabel.setModel((new JTable(dataRenter, columnName)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "No Data");
        }
        view.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);

                int baris = view.tabel.getSelectedRow();
                 
                String id = view.tabel.getValueAt(baris, 1).toString();
                String status = view.tabel.getValueAt(baris, 5).toString();
                
                if("notPaid".equals(status)){
                adminModel model = new adminModel(id);
                model.updateStatus();
                }
                else{
                adminModel model = new adminModel(id);
                EditRenterData view = new EditRenterData();
                editController controller = new editController(model,view);
                }  
            }
        });
        view.blogout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPageView().setVisible(true);
                view.logout(); 
            }
        });
        view.bread.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            if (model.getRenterData()!=0) {
            String dataRenter[][] = model.readRenter();
            view.tabel.setModel((new JTable(dataRenter, columnName)).getModel());
            }
            else {
            JOptionPane.showMessageDialog(null, "No Data");
            }
            }
        });   
    }   
}
