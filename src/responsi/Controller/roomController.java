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
import responsi.Model.rentModel;
import responsi.Model.roomModel;
import responsi.Model.userModel;
import responsi.View.LoginPageView;
import responsi.View.RenterDataView;
import responsi.View.RoomListView;

/**
 *
 * @author Lenovo
 */
public class roomController {
    roomModel model;
    RoomListView view;
    String username;
    Object columnName[] = {"name", "size", "price", "status"};
    public roomController (roomModel model, RoomListView view){
        this.model = model;
        this.view = view;
        model.username = username;
        
        if (model.getRoomData()!=0) {
            String dataMovie[][] = model.readRoom();
            view.tabel.setModel((new JTable(dataMovie, columnName)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "No Data");
        }
        
        view.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);

                int baris = view.tabel.getSelectedRow();
                String name = view.tabel.getValueAt(baris, 0).toString();
                String harga = view.tabel.getValueAt(baris, 2).toString();
                String status = view.tabel.getValueAt(baris, 3).toString();
                
                if("empty".equals(status)){
                rentModel model = new rentModel(name,harga);
                RenterDataView view = new RenterDataView();
                rentController controller = new rentController(model,view);
                }
                else{
                JOptionPane.showMessageDialog(null, "Kamar Sudah Terisi");
                }    
            }

        });
        
        view.bcancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPageView().setVisible(true);
                view.logout();
            }
        
        });
        view.bread.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            if (model.getRoomData()!=0) {
            String dataRenter[][] = model.readRoom();
            view.tabel.setModel((new JTable(dataRenter, columnName)).getModel());
            }
            else {
            JOptionPane.showMessageDialog(null, "No Data");
            }
            } 
        });
        
    }
    
}
