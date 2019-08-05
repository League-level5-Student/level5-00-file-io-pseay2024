package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args)
	{
		try {
			FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/test2.txt");
			int c = fr.read();
			String s = "";
			while(c != -1)
			{
				s+=(char)(c - 1);
				c = fr.read();
			}
			System.out.println("decrypted: " + s);
			JOptionPane.showMessageDialog(null, s);
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
