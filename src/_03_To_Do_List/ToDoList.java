package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class ToDoList implements ActionListener{
	/*
	 * Create a program with five buttons: add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	ArrayList<String> tasks = new ArrayList<String>();
	
	JButton addTask = new JButton("Add Task");
	JButton viewTask = new JButton("View Tasks");
	JButton removeTask = new JButton("Remove Task");
	JButton saveList = new JButton("Save List");
	JButton loadList = new JButton("Load List");
	String location = "src/_03_To_Do_List/todolist.txt";
	ToDoList()
	{
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		//add task, view tasks, remove task, save list, and load list
		addTask.addActionListener(this);
		viewTask.addActionListener(this);
		removeTask.addActionListener(this);
		saveList.addActionListener(this);
		loadList.addActionListener(this);
		jp.add(addTask);
		jp.add(viewTask);
		jp.add(removeTask);
		jp.add(saveList);
		jp.add(loadList);
		jf.add(jp);
		jf.pack();
		jf.setVisible(true);
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(location));
			tasks = new ArrayList<String>();
			String line = br.readLine();
			while (line != null)
			{
				tasks.add(line);
				line = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (((JButton)e.getSource()).getText())
		{
		case "Add Task":
			tasks.add(JOptionPane.showInputDialog("What task do you want to add?"));
			break;
		case "View Tasks":
			StringBuilder sb = new StringBuilder();
			for (String s : tasks)
			{
				sb.append(s + "\n");
			}
			JOptionPane.showMessageDialog(null, sb.toString());
			break;
		case "Remove Task":
			tasks.remove(tasks.indexOf(JOptionPane.showInputDialog("What do you want to remove?")));
			break;
		case "Save List":
			FileWriter fw;
			try {
				fw = new FileWriter(location);
				for (String s : tasks)
				{
					fw.append(s + "\n");
				}
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Load List":
			String newLoc = JOptionPane.showInputDialog("Where do you want to load it from?");
			try {
				BufferedReader br = new BufferedReader(new FileReader(newLoc));
				tasks = new ArrayList<String>();
				String line = br.readLine();
				while (line != null)
				{
					tasks.add(line);
					line = br.readLine();
				}
				br.close();
			} catch (Exception e1) {e1.printStackTrace();}
			break;
		}
	}
}
