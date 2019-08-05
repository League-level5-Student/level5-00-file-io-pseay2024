package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void decrypt(String location)
	{
		try {
			FileReader fr = new FileReader(location);
			int c = fr.read();
			String s = "";
			while(c != -1)
			{
				s+=(char)(c - 1);
			}
			JOptionPane.showMessageDialog(null, s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
