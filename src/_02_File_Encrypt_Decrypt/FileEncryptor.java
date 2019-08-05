package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("Write a message to encrypt");
		String link = "src/_02_File_Encrypt_Decrypt/test2.txt";
		try
		{
			FileWriter fw = new FileWriter(link);
			fw.append(encrypt(s));
			fw.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	static String encrypt(String s)
	{
		String a = "";
		for (int i = 0; i < s.length(); i++)
		{
			int c = (s.toCharArray()[i] + 1);
			a+=(char)c;
		}
		return a;
	}
}
