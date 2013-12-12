package com.wreckit.addressbook;

import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("unused")
public class AddressBook extends JFrame implements ActionListener 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtYouNeedA;
	private JFileChooser fc;
	private File file;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private String col[] = {"Last Name","First Name","Address","City","State","Zip","Phone Number"};
	
	// File manipulation.
	private BufferedReader reader;
	private BufferedWriter writer;
	private FileWriter fWriter;
	private DefaultTableModel model;
	private String line;
	private String writeLine;
	private String lineToWrite;
	
	private int row;
	private JTable entriesTable;
	
	// Person array check
	private ArrayList<Person> personsList;
	private int option;

	/**
	 * Create the frame.
	 */
	public AddressBook() 
	{
		personsList = new ArrayList<Person>();
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddressBook.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		setFont(new Font("TF2 Secondary", Font.PLAIN, 13));
		setResizable(false);
		setTitle("Starlight Address Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 607, 21);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		mntmOpen.addActionListener(this);
		
		mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		mntmSave.addActionListener(this);
		
		mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		mntmExit.addActionListener(this);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 32, 587, 306);
		contentPane.add(tabbedPane);
		
		JPanel filePanel = new JPanel();
		tabbedPane.addTab("CSV File", null, filePanel, null);
		filePanel.setLayout(null);
		
		JLabel lblFileCurrentlyOpen = new JLabel("File currently open:");
		lblFileCurrentlyOpen.setBounds(10, 11, 138, 14);
		filePanel.add(lblFileCurrentlyOpen);
		
		txtYouNeedA = new JTextField();
		txtYouNeedA.setText("You need a CSV file here, mate. Open it from the File menu.");
		txtYouNeedA.setEditable(false);
		txtYouNeedA.setBounds(10, 28, 562, 22);
		filePanel.add(txtYouNeedA);
		txtYouNeedA.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Entries", null, scrollPane, null);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		model = new DefaultTableModel(col,25);
		entriesTable = new JTable(model);
		entriesTable.setBounds(10, 25, 560, 240);
		panel.add(entriesTable);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(21, 11, 67, 14);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(98, 11, 67, 14);
		panel.add(lblLastName);
		
		
		
		fc = new JFileChooser();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		 if (e.getSource() == mntmOpen) 
		 {
	            int returnVal = fc.showOpenDialog(AddressBook.this);

	            if (returnVal == JFileChooser.APPROVE_OPTION) 
	            {
	                file = fc.getSelectedFile();
	                txtYouNeedA.setText(file.getAbsolutePath());
	                //This is where a real application would open the file.
	                try 
	                {
	                	row = 0;
						BufferedReader reader = new BufferedReader(new FileReader(file));
						while ((line = reader.readLine()) != null) 
						{						  
							String[] person = line.split(",");
							Person p = new Person(person[0], person[1], person[2], person[3], person[4], person[5], person[6]);
							personsList.add(p);
							entriesTable.setValueAt(p.getLastName(),row,1);
							entriesTable.setValueAt(p.getFirstName(),row,0);
							entriesTable.setValueAt(p.getAddress(),row,2);
							entriesTable.setValueAt(p.getCity(), row, 3);
							entriesTable.setValueAt(p.getState(), row, 4);
							entriesTable.setValueAt(p.getZip(), row, 5);
							entriesTable.setValueAt(p.getPhone(), row, 6);
							row++;
						}
						reader.close();
					} 
	                catch (IOException e1) 
	                {
						e1.printStackTrace();
					}
	                
	            	
	            }
	       }
		 if (e.getSource() == mntmSave)
		 {
			 int returnVal = fc.showSaveDialog(AddressBook.this);

	         if (returnVal == JFileChooser.APPROVE_OPTION)
	         {
	        	 File inputFile = fc.getSelectedFile();
	        	 String path = inputFile.getPath();
	             //This is where a real application would save the file.
	        	 File tempFile = new File(path + "temp.sniper");
	        	 BufferedReader br;
	        	 row = 0;
	        	 try 
	        	 {
					br = new BufferedReader(new FileReader(inputFile));
					 try 
		        	 {
						 
							fWriter = new FileWriter(tempFile);
							while(((entriesTable.getValueAt(row, 0)) != null) && ((entriesTable.getValueAt(row, 1)) != null) && ((entriesTable.getValueAt(row, 2)) != null) && ((entriesTable.getValueAt(row, 3)) != null) && ((entriesTable.getValueAt(row, 4)) != null) && ((entriesTable.getValueAt(row, 5)) != null) && ((entriesTable.getValueAt(row, 6)) != null))
							{
								lineToWrite = entriesTable.getValueAt(row, 1) + "," + entriesTable.getValueAt(row, 0) + "," + entriesTable.getValueAt(row, 2) + "," + entriesTable.getValueAt(row, 3) + "," + entriesTable.getValueAt(row, 4) + "," + entriesTable.getValueAt(row, 5) + "," + entriesTable.getValueAt(row, 6);
						         fWriter.write(lineToWrite + "\n");
						         System.out.println(lineToWrite);
						        row++; 
						    }   
							fWriter.close();
							br.close();
					} 
		            catch (IOException e1) 
						{
							e1.printStackTrace();
						}
				}
	        	 catch (FileNotFoundException e2) 
	        	 {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
	        	 
	     	 if(!inputFile.delete())
	     	    {
	     	        JOptionPane.showMessageDialog(null, "Could not rename file");
	     	        return;
	     	    }
	     	    if(!tempFile.renameTo(inputFile))
	     	        JOptionPane.showMessageDialog(null, "Could not rename file"); 
	        	 
	        	
	         }
		 }
		 if (e.getSource() == mntmExit)
		 {
			 option = JOptionPane.showConfirmDialog(null,"Exit? Unsaved changes will be lost.",null, JOptionPane.YES_NO_OPTION);
             if(option == 0)
             {
                 System.exit(0);
             }
		 }
	}
}
