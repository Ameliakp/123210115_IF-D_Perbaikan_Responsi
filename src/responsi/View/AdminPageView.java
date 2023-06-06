/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi.View;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AdminPageView extends JFrame{ 
    JFrame window = new JFrame("Renter Data");
    Object columnName [];
    
    public String data[][] = new String [100][4];
    public DefaultTableModel tableModel = new DefaultTableModel(columnName,0);
    public JTable tabel = new JTable(tableModel);
    public JScrollPane scrollPane = new JScrollPane(tabel);
    
    public JButton blogout = new JButton("Logout");
    public JButton bread = new JButton("Read Data");

    public AdminPageView() {
        window.setLayout(null);
        window.setSize(550,600);
       
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        window.add(bread);
        window.add(scrollPane);
        window.add(blogout);
        scrollPane.setBounds(20, 35, 500, 300);
        blogout.setBounds(20, 350, 100,50);
        bread.setBounds(150, 350, 100,50);
        
        showData();
        window.setVisible(true);
    }
    
    private void showData(){
        
    }
    public void logout(){
    this.dispose();
    }
    
}
