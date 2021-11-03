package lab2;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
//import javax.swing.event.*;

public class GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	int width, height;
	private GridBagConstraints c;
	
	GUI(int width, int height){
		super("Lab2 IF1900011");
		this.width=width; this.height=height;
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		setLayout(new GridBagLayout());	
		c = new GridBagConstraints();
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
				
		JTextField searchInput = new JTextField(20);
		c.gridx = 1;
		c.gridwidth = 3;
		c.gridy = 0;
		add(searchInput, c);	
		
		JButton searchButton = new JButton("Search");
		c.gridx = 4;
		c.gridwidth = 1;
		c.gridy = 0;
		add(searchButton, c);
	}
	
	private void tableRow() {
		MonsterDaoImpl mdi = new MonsterDaoImpl();
		String[] columnNames = {"ID", "Name", "Level","Health", "Damage", "Range"};
		ArrayList<Monster> m = mdi.getAllMonsters();
		
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
				
		for(int i = 0; i < m.size(); i++) {
			Object[] data = {
				m.get(i).getID(),
				m.get(i).getName(),
				m.get(i).getLevel(),
				m.get(i).getHealth(),
				m.get(i).getDamage(),
				m.get(i).getRange()
			};
			
			tableModel.addRow(data);
		}
		
		JTable table = new JTable(tableModel);
		
		TableColumnModel tcm = table.getColumnModel();
		tcm.removeColumn(tcm.getColumn(0));
		
		
		
		JScrollPane sp = new JScrollPane(table);
		c.gridx = 0;
		c.gridwidth = 9;
		c.gridy = 1;
		
		
		add(sp, c);

	}
	
	private void addNewRow() {
		JButton addNew = new JButton("Add Monster");
		addNew.setBounds(0,0,100,50);
		//c.gridx=2;
		c.gridy=2;
		add(addNew, c);
	}

}
