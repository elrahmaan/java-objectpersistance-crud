/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahasiswa;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author USER
 */
public class Mahasiswa1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            Vector list;
            //Create a buffered reader for easy input 
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Checking for previous serialized list");
            //Check to see if serialized list exists 
            try {
                FileInputStream fin = new FileInputStream("list.out");
                //	Connect an object input stream to the list
                ObjectInputStream oin = new ObjectInputStream(fin);
                try {
                    //	Read the vector back from the list 
                    Object obj = oin.readObject();
                    //	Cast back to a vector
                    list = (Vector) obj;
                } catch (ClassCastException cce) {
                    //	Can't read it, create a blank one
                    list = new Vector();
                } catch (ClassNotFoundException cnfe) {
                    //	Can't read it, create a blank one
                    list = new Vector();
                }
                fin.close();
            } catch (FileNotFoundException fnfe) {
                //	Create a blank vector 
                list = new Vector();
            }
            for (;;) {
                //	Now, display menu 
                System.out.println("Menu :-");
                System.out.println("1.. Add item");
                System.out.println("2.. Delete item");
                System.out.println("3.. List items");
                System.out.println("4.. Save and quit");
                System.out.print("Choice : ");
                String response = reader.readLine();
                int choice = Integer.parseInt(response);
                switch (choice) {
                    case 1:
                        System.out.print("Enter item : ");
                        String item = reader.readLine();
                        list.addElement(item);
                        break;
                    case 2:
                        System.out.print("Enter item : ");
                        String deadItem = reader.readLine();
                        list.removeElement(deadItem);
                        break;
                    case 3:
                        for (Enumeration e = list.elements(); e.hasMoreElements();) {
                            System.out.println(e.nextElement());
                        }
                        break;

                    case 4:
                        System.out.println("Saving list");
                        FileOutputStream fout = new FileOutputStream("list.out");
                        ObjectOutputStream oout = new ObjectOutputStream(fout);
                        oout.writeObject(list);
                        fout.close();
                        System.exit(0);
                }
            }
        } catch (IOException ioe) {
            System.err.println("I/O error");
        }

    }
}

