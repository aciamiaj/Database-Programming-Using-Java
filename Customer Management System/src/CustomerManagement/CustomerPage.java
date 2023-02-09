/*************************************************************************************************
*  Course_Name – Assignment x                                                                    *

*  I declare that this assignment is my own work in accordance with Humber Academic Policy.      *

*  No part of this assignment has been copied manually or electronically from any other source   *

*  (including web sites) or distributed to other students/social media.                          *
*  Name: Jaimaica Daisy Eugenio	Student ID: N01516797 Date: June 10, 2022               		 *
*  Name: Jaspreet Singh         Student ID: N01513743 Date: June 10, 2022 		                 *
*  Name: Anna Salas             Student ID: N01517324 Date: June 10, 2022               		 *
* ************************************************************************************************/

package CustomerManagement;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


public class CustomerPage extends JFrame {
	private static final String File_Name = "customer.dat";
	JFrame frame = new JFrame();
	JTextField txtCustomerID = new JTextField();
	JTextField txtCustomerName = new JTextField();
	JTextField txtCustomerPhone = new JTextField();
	JTextField txtCustomerEmail = new JTextField();
	JTextField txtCustomerPostal = new JTextField();
	JTextField txtUpdateCustomerID = new JTextField();
	JTextField txtUpdateCustomerName = new JTextField();
	JTextField txtUpdateCustomerPhone = new JTextField();
	JTextField txtUpdateCustomerEmail = new JTextField();
	JTextField txtUpdateCustomerPostal = new JTextField();
	JTextArea txaViewResult = new JTextArea();

	JButton btnAdd, btnClear, btnFind, btnUpdate, btnUpdateExit, btnView, btnViewExit;
	
	//Method to create the page
	public CustomerPage() {
		
		createCustomerPage();
		addActionListeners();
	}
	
	//Create the page with 3 tabs for Add, Update and View
	private void createCustomerPage() {
		frame = new JFrame();
		frame.setTitle("Customer Management System");
		frame.setBounds(100, 100, 360, 420);
		frame.getContentPane().setLayout(null);	
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 320, 350);
		frame.getContentPane().add(tabbedPane);	

		JPanel pnlAdd = new JPanel();
		pnlAdd.setLayout(null);
		JPanel pnlUpdate = new JPanel();
		pnlUpdate.setLayout(null);
		JPanel pnlView = new JPanel();
		pnlView.setLayout(null);

		tabbedPane.addTab("Add", null, pnlAdd, null);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1); 
		
		JLabel lblAddNewCustomer = new JLabel("Add New Customer");
		lblAddNewCustomer.setBounds(10, 10, 220, 15);
		pnlAdd.add(lblAddNewCustomer);	
		
		JLabel lblCustomerID = new JLabel("Customer ID:");
		lblCustomerID.setBounds(10, 45, 200, 15);
		pnlAdd.add(lblCustomerID);	
		
		txtCustomerID.setBounds(100, 40, 150, 25);
		pnlAdd.add(txtCustomerID);
		txtCustomerID.setColumns(10);
		
		JLabel lblCustomerName = new JLabel("Name:");
		lblCustomerName.setBounds(50, 75, 200, 15);
		pnlAdd.add(lblCustomerName);	
		
		txtCustomerName.setBounds(100, 70, 200, 25);
		pnlAdd.add(txtCustomerName);
		txtCustomerName.setColumns(10);
		
		JLabel lblCustomerPhone = new JLabel("Phone:");
		lblCustomerPhone.setBounds(48, 105, 200, 15);
		pnlAdd.add(lblCustomerPhone);	
		
		txtCustomerPhone.setBounds(100, 100, 150, 25);
		pnlAdd.add(txtCustomerPhone);
		txtCustomerPhone.setColumns(10);
		
		JLabel lblCustomerEmail = new JLabel("Email:");
		lblCustomerEmail.setBounds(53, 135, 200, 15);
		pnlAdd.add(lblCustomerEmail);	
		
		txtCustomerEmail.setBounds(100, 130, 200, 25);
		pnlAdd.add(txtCustomerEmail);
		txtCustomerEmail.setColumns(10);
		
		JLabel lblCustomerPostal = new JLabel("Postal Code:");
		lblCustomerPostal.setBounds(15, 165, 200, 15);
		pnlAdd.add(lblCustomerPostal);	
		
		txtCustomerPostal.setBounds(100, 160, 120, 25);
		pnlAdd.add(txtCustomerPostal);
		txtCustomerPostal.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(65, 210, 90, 25);
		pnlAdd.add(btnAdd);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(165, 210, 90, 25);
		pnlAdd.add(btnClear);
		
		tabbedPane.addTab("Update", null, pnlUpdate, null);
		
		JLabel lblUpdateCustomer = new JLabel("Update Existing Customer");
		lblUpdateCustomer.setBounds(10, 10, 220, 15);
		pnlUpdate.add(lblUpdateCustomer);
		
		JLabel lblUpdateCustomerID = new JLabel("Enter Customer ID:");
		lblUpdateCustomerID.setBounds(10, 45, 200, 15);
		pnlUpdate.add(lblUpdateCustomerID);	
		
		txtUpdateCustomerID.setBounds(150, 40, 150, 25);
		pnlUpdate.add(txtUpdateCustomerID);
		txtUpdateCustomerID.setColumns(10);
		
		JLabel lblUpdateCustomerName = new JLabel("Name:");
		lblUpdateCustomerName.setBounds(50, 75, 200, 15);
		pnlUpdate.add(lblUpdateCustomerName);	
		
		txtUpdateCustomerName.setBounds(100, 70, 200, 25);
		pnlUpdate.add(txtUpdateCustomerName);
		txtUpdateCustomerName.setColumns(10);
		
		JLabel lblUpdateCustomerPhone = new JLabel("Phone:");
		lblUpdateCustomerPhone.setBounds(48, 105, 200, 15);
		pnlUpdate.add(lblUpdateCustomerPhone);	
		
		txtUpdateCustomerPhone.setBounds(100, 100, 150, 25);
		pnlUpdate.add(txtUpdateCustomerPhone);
		txtUpdateCustomerPhone.setColumns(10);
		
		JLabel lblUpdateCustomerEmail = new JLabel("Email:");
		lblUpdateCustomerEmail.setBounds(53, 135, 200, 15);
		pnlUpdate.add(lblUpdateCustomerEmail);	
		
		txtUpdateCustomerEmail.setBounds(100, 130, 200, 25);
		pnlUpdate.add(txtUpdateCustomerEmail);
		txtUpdateCustomerEmail.setColumns(10);
		
		JLabel lblUpdateCustomerPostal = new JLabel("Postal Code:");
		lblUpdateCustomerPostal.setBounds(15, 165, 200, 15);
		pnlUpdate.add(lblUpdateCustomerPostal);	
		
		txtUpdateCustomerPostal.setBounds(100, 160, 120, 25);
		pnlUpdate.add(txtUpdateCustomerPostal);
		txtUpdateCustomerPostal.setColumns(10);
		
		btnFind = new JButton("Find");
		btnFind.setBounds(45, 210, 70, 25);
		pnlUpdate.add(btnFind);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(115, 210, 90, 25);
		pnlUpdate.add(btnUpdate);
		
		btnUpdateExit = new JButton("Exit");
		btnUpdateExit.setBounds(205, 210, 70, 25);
		pnlUpdate.add(btnUpdateExit);
		
		tabbedPane.addTab("View", null, pnlView, null);
		
		JLabel lblViewCustomer = new JLabel("View List Of All Customers");
		lblViewCustomer.setBounds(10, 10, 220, 15);
		pnlView.add(lblViewCustomer);

		JScrollPane scrollPane = new JScrollPane(txaViewResult);
		scrollPane.setBounds(10, 40, 295, 220);
		pnlView.add(scrollPane);
		
		btnView = new JButton("View");
		btnView.setBounds(65, 280, 90, 25);
		pnlView.add(btnView);
		
		btnViewExit = new JButton("Exit");
		btnViewExit.setBounds(165, 280, 90, 25);
		pnlView.add(btnViewExit);
	}
	
	//add customer 
	public void addActionListeners() {
		btnAdd.addActionListener(e-> {
			String id = txtCustomerID.getText();
			String customerName = txtCustomerName.getText();
			String customerPhone = txtCustomerPhone.getText();
			String customerEmail = txtCustomerEmail.getText();
			String customerPostal = txtCustomerPostal.getText();

			if (id.equals("") || customerName.equals("") || customerPhone.equals("") || customerEmail.equals("") || customerPostal.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter All Valid Information");
				return;
			} else if (isIDExists(id)) {
				JOptionPane.showMessageDialog(null, "ID Already Exists");
				return;
			}

			try {
				FileOutputStream fileOutputStream = new FileOutputStream(new File(File_Name),true);
				String output =  id+","+customerName+","+customerPhone+","+customerEmail+","+customerPostal+"\n";
				fileOutputStream.write(output.getBytes());
				fileOutputStream.close();
				JOptionPane.showMessageDialog(null, "Customer Added Successfully");
				txtCustomerID.setText("");
				txtCustomerName.setText("");
				txtCustomerPhone.setText("");
				txtCustomerEmail.setText("");
				txtCustomerPostal.setText("");

			} catch (IOException ex) {
				ex.printStackTrace();
			}

		});
		//validate for number(integer) values only
		txtCustomerID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyEvent) {
				if(!(((int)keyEvent.getKeyChar() >= 48 && (int)keyEvent.getKeyChar() <= 57) || (int)keyEvent.getKeyChar() == 8)) {
					JOptionPane.showMessageDialog(null, "Please Enter Number Only");
					txtCustomerID.setText("");
				}
			}
		});

		txtUpdateCustomerID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent keyEvent) {
				if(!(((int)keyEvent.getKeyChar() >= 48 && (int)keyEvent.getKeyChar() <= 57) || (int)keyEvent.getKeyChar() == 8)) {
					JOptionPane.showMessageDialog(null, "Please Enter A Valid Customer ID.");
					txtUpdateCustomerID.setText("");
				}
			}
		});
		//Find customer by customer ID, once found will show a messagebox that customer id is found
		btnFind.addActionListener(e->{
			String output = "";
			String id = txtUpdateCustomerID.getText();
			boolean found = false;
			try {
				FileInputStream fileInputStream= new FileInputStream(new File(File_Name)); //File_Name = customer.dat
				int i;
				while ((i=fileInputStream.read()) != -1) { // != -1 meaning the customer id exists 
					if (i == 10) {
						if(output.substring(0, output.indexOf(",")).equals(id)) { //once found messagebox prompt found
							JOptionPane.showMessageDialog(null, "Customer ID Found!");
							found = true;
							break;
						}
						output = "";
					} else {
						output = output + (char) i;
					}
				}
				fileInputStream.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
			//if not found, messagebox will display ID not found
			if(!found) {
				JOptionPane.showMessageDialog(null, "Customer ID Not Found");
				txtUpdateCustomerName.setText("");
				txtUpdateCustomerPhone.setText("");
				txtUpdateCustomerEmail.setText("");
				txtUpdateCustomerPostal.setText("");
				return;
			}
			//populate the textboxes of customers details based on customer ID
			output = output.substring(output.indexOf(",")+1);
			txtUpdateCustomerName.setText(output.substring(0, output.indexOf(",")));
			output = output.substring(output.indexOf(",")+1);
			txtUpdateCustomerPhone.setText(output.substring(0, output.indexOf(",")));
			output = output.substring(output.indexOf(",")+1);
			txtUpdateCustomerEmail.setText(output.substring(0, output.indexOf(",")));
			output = output.substring(output.indexOf(",")+1);
			txtUpdateCustomerPostal.setText(output);
		});
		//Update the changes on customer, search by customerID
		btnUpdate.addActionListener(e->{
			String customerName = txtUpdateCustomerName.getText();
			String customerPhone = txtUpdateCustomerPhone.getText();
			String customerEmail = txtUpdateCustomerEmail.getText();
			String customerPostal = txtUpdateCustomerPostal.getText();

			if (customerName.equals("") || customerPhone.equals("") || customerEmail.equals("") || customerPostal.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Find Valid ID");
				return;
			}

			String output = "";
			//update the customer by customer ID
			String id = txtUpdateCustomerID.getText();
			List<String> inputString = new ArrayList<>();
			try {
				FileInputStream fileInputStream = new FileInputStream(new File(File_Name));
				int i;
				while ((i=fileInputStream.read()) != -1) { // != -1 meaning the customer id exists 
					if (i == 10) {
						inputString.add(output);
						output = "";
					} else {
						output = output + (char) i;
					}
				}

				fileInputStream.close();
				//update the changes by index
				for (int index = 0; index<inputString.size();index++) {
					String s = inputString.get(index);
					if(s.substring(0, s.indexOf(",")).equals(id)) { //check if customer id exists
						inputString.set(index, id+","+customerName+","+customerPhone+","+customerEmail+","+customerPostal);
					}
				}

				String result = "";
				for(String s : inputString) {
					result = result + s + "\n";
				}

				//System.out.println(result);

				FileOutputStream fileOutputStream = new FileOutputStream(new File(File_Name), false);
				fileOutputStream.write(result.getBytes());
				fileOutputStream.close();
				//if update is successful, meesagebox will show as updated successfully
				JOptionPane.showMessageDialog(null, "Updated Successfully");
				txtUpdateCustomerName.setText("");
				txtUpdateCustomerPhone.setText("");
				txtUpdateCustomerEmail.setText("");
				txtUpdateCustomerPostal.setText("");

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});
		//view all the customers and show in textarea
		btnView.addActionListener(e->{
			try {
				FileInputStream fileInputStream= new FileInputStream(new File(File_Name));
				int i, j=0;
				StringBuilder output = new StringBuilder();
				String data[] = {"ID : ", "Name : ", "Phone : ", "Email : ", "Postal Code : "};
				output.append(data[j]);
				while ((i=fileInputStream.read()) != -1) { //if there is data, it will append in textarea
					if (i == 44) {
						j++;
						output.append("\n"+data[j]);
					} else if (i == 10) {
						output.append("\n\n");
						j=0;
						output.append(data[j]);
					} else {
						output.append((char) i);
					}
				}
				txaViewResult.setText(output.delete(output.lastIndexOf("ID : "), output.length()).toString());
				fileInputStream.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});


		btnClear.addActionListener(e-> {
			txtCustomerID.setText("");
			txtCustomerName.setText("");
			txtCustomerPhone.setText("");
			txtCustomerEmail.setText("");
			txtCustomerPostal.setText("");
		});

		btnUpdateExit.addActionListener(e-> {
			System.exit(0);
		});

		btnViewExit.addActionListener(e-> {
			System.exit(0);
		});
	}

	public boolean isIDExists(String id) {
		try {
			FileInputStream fileInputStream= new FileInputStream(new File(File_Name));
			int i;
			String output = "";
			while ((i=fileInputStream.read()) != -1) {
				if (i == 10) {
					if(output.substring(0, output.indexOf(",")).equals(id)) {
						return true;
					}
					output = "";
				} else {
					output = output + (char) i;
				}
			}
			fileInputStream.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	public static void main(String[] args) {
		CustomerPage window = new CustomerPage();
		window.frame.setLocationRelativeTo(null);
		window.frame.setVisible(true);
		window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
