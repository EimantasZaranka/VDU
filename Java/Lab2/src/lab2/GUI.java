package lab2;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.event.*;

public class GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	int width, height;
	private GridBagConstraints c;
	private MonsterDaoImpl mdi;
	
	JTextField searchInput;
	JButton searchButton;
	JTable table;
	JButton addNew;
	DefaultTableModel tableModel;
	
	GUI(int width, int height){
		super("Lab2 IF1900011");
		this.width=width; this.height=height;
		mdi = new MonsterDaoImpl();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		setLayout(new GridBagLayout());	
		c = new GridBagConstraints();
		String[] columnNames = {"ID", "Name", "Level","Health", "Damage", "Range"};
		tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);	
		
		c.insets = new Insets(5,5,5,5);
		c.weightx = 1;
		c.weighty = 1;
		
		
		searchRow();
		tableRow();
		addNewRow();
		
		pack();
		//setSize(this.width,this.height);
		setResizable(false);
		setVisible(true);
	}	
	
	private void searchRow() {
		c.fill = GridBagConstraints.LINE_START;
		JLabel searchLabel = new JLabel("Enter monsters name: ");
		c.gridx = 0;
		c.gridwidth = 1;
		c.gridy = 0;
		add(searchLabel,c);
				
		searchInput = new JTextField(20);
		c.gridx = 1;
		c.gridwidth = 3;
		c.gridy = 0;
		add(searchInput, c);	
		
		searchButton = new JButton("Search");
		c.gridx = 4;
		c.gridwidth = 1;
		c.gridy = 0;
		add(searchButton, c);
		
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Get text from text field
				String inp = "";
				if(searchInput.getText().equals("")){
					innitFill();
				}else {
					inp = searchInput.getText();
					//Get array list of monsters who's name matches
					ArrayList<Monster> selected = mdi.getMonsterByName(inp);
					
					//update JTable
					clearTable();
					for(int i = 0; i < selected.size(); i++) {
						addToTable(selected.get(i));
					}
					
					//clear TextField
					searchInput.setText("");
				}
				
				
			}
		});
	}
	
	private void tableRow() {
		innitFill();

		TableColumnModel tcm = table.getColumnModel();
		tcm.removeColumn(tcm.getColumn(0));
		
				
		JScrollPane sp = new JScrollPane(table);
		
				
		c.gridx = 0;
		c.gridwidth = 9;
		c.gridy = 1;
		
		
		add(sp, c);
		
		table.getModel().addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent  e) {
				
				if (TableModelEvent.UPDATE == e.getType()) {
					int editedRow = e.getFirstRow();				
					Monster m = new Monster();			
					
					m.setID(Integer.parseInt(
							table.getModel().getValueAt(editedRow, 0).toString())
					);
					
					m.setName(table.getModel().getValueAt(editedRow, 1).toString());
					
					m.setLevel(Integer.parseInt(
							table.getModel().getValueAt(editedRow, 2).toString())
					);
					
					m.setHealth(Integer.parseInt(
							table.getModel().getValueAt(editedRow, 3).toString())
					);
					
					m.setDamage(Integer.parseInt(
							table.getModel().getValueAt(editedRow, 4).toString())
					);
					
					m.setRange(Integer.parseInt(
							table.getModel().getValueAt(editedRow, 5).toString())	
					);
					
					mdi.updateMonster(m);
				
				}
			}
		});

	}
	
	private void addNewRow() {
		addNew = new JButton("Add Monster");
		addNew.setBounds(0,0,100,50);
		//c.gridx=2;
		c.gridy=2;
		add(addNew, c);
		
		addNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame newWindow = new JFrame("Add monster");
				newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				newWindow.setLayout(new GridBagLayout());	
				GridBagConstraints nc = new GridBagConstraints();
				nc.insets = new Insets(5,5,5,5);
				nc.weightx = 1;
				nc.weighty = 1;
				
				JLabel nameLabel = new JLabel("Name: ");
				nc.gridx = 0;
				nc.gridy = 0;
				newWindow.add(nameLabel, nc);
				
				JLabel levelLabel = new JLabel("Level: ");
				nc.gridx = 0;
				nc.gridy = 1;
				newWindow.add(levelLabel, nc);
				
				JLabel healthLabel = new JLabel("Health: ");
				nc.gridx = 0;
				nc.gridy = 2;
				newWindow.add(healthLabel, nc);
				
				JLabel damageLabel = new JLabel("Damage: ");
				nc.gridx = 0;
				nc.gridy = 3;
				newWindow.add(damageLabel, nc);
				
				JLabel rangeLabel = new JLabel("Range: ");
				nc.gridx = 0;
				nc.gridy = 4;
				newWindow.add(rangeLabel, nc);
				
				JTextField nameInput = new JTextField(20);
				nc.gridx = 2;
				nc.gridy = 0;
				newWindow.add(nameInput, nc);
				
				JTextField levelInput = new JTextField(20);
				nc.gridx = 2;
				nc.gridy = 1;
				newWindow.add(levelInput, nc);
				
				JTextField healthInput = new JTextField(20);
				nc.gridx = 2;
				nc.gridy = 2;
				newWindow.add(healthInput, nc);
				
				JTextField damageInput = new JTextField(20);
				nc.gridx = 2;
				nc.gridy = 3;
				newWindow.add(damageInput, nc);
				
				JTextField rangeInput = new JTextField(20);
				nc.gridx = 2;
				nc.gridy = 4;
				newWindow.add(rangeInput, nc);
				
				JButton addNewButton = new JButton("Save");
				nc.gridx = 7;
				nc.gridy = 6;
				newWindow.add(addNewButton, nc);
				
				addNewButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(nameInput.getText().equals("")) {
							JOptionPane.showMessageDialog(newWindow, 
									"Name must be filled!", "ATTENTION!", 
									JOptionPane.WARNING_MESSAGE);
						}
						else {
							Monster m = new Monster();
							m.setName(nameInput.getText());
							
							String h = healthInput.getText();
							String l = levelInput.getText();
							String d = damageInput.getText();
							String r = rangeInput.getText();
							
							if(h.equals("")) {h="-1";}
							if(l.equals("")) {l="-1";}
							if(d.equals("")) {d="-1";}
							if(r.equals("")) {r="-1";}
							
							
							m.setHealth(Integer.parseInt(h));
							m.setLevel(Integer.parseInt(l));
							m.setDamage(Integer.parseInt(d));
							m.setRange(Integer.parseInt(r));
							
							int i = mdi.insertMonster(m);
							if(i != 0) {
								m.setID(i);
								addToTable(m);
								newWindow.dispose();
							}else {
								JOptionPane.showMessageDialog(newWindow, 
										"Error with data, please check it!", "ATTENTION!", 
										JOptionPane.WARNING_MESSAGE);
							}
							
							
						}
					}
				});
				
				JButton cancelButton = new JButton("Cancel");
				nc.gridx = 8;
				nc.gridy = 6;
				newWindow.add(cancelButton, nc);
				
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						newWindow.dispose();					
					}
				});
								
				newWindow.pack();
				newWindow.setResizable(false);
				newWindow.setVisible(true);
			}
		});
	}
	
	private void addToTable(Monster m) {
		Object[] data = {
				m.getID(),
				m.getName(),
				m.getLevel(),
				m.getHealth(),
				m.getDamage(),
				m.getRange()
		};
		
		tableModel.addRow(data);
	}
	
	private void clearTable() {
		int rowCount = table.getModel().getRowCount();
		
		for (int i = rowCount - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
	}
	
	private void innitFill() {
		clearTable();
		ArrayList<Monster> m = mdi.getAllMonsters();
		for(int i = 0; i < m.size(); i++) {
			addToTable(m.get(i));
		}
	}
	
}
