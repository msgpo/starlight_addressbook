package com.wreckit.addressbook;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 
public class JTableUsage extends JFrame
{
    DefaultTableModel model;
    JTable table;
    String col[] = {"Name","Address","Phone"};
    
    public static void main(String args[])
    {
    	new JTableUsage().start(); 
    }
 
    public void start()
    {
     
    	model = new DefaultTableModel(col,2); 
        table=new JTable(model)
        {@Override
        	public boolean isCellEditable(int arg0, int arg1) 
        	{
        		return false;
        	}
        };
    JScrollPane pane = new JScrollPane(table);
     
    table.setValueAt("csanuragjain",0,0);
     
    add(pane);
    setVisible(true);
    setSize(500,400);
    setLayout(new FlowLayout());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}