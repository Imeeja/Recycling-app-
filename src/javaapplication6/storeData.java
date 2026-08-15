package javaapplication6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class storeData {

    public static Map<String, Household> households = new HashMap<>();

    public static void saveData() throws IOException {

        ObjectOutputStream out =
                new ObjectOutputStream(
                        new FileOutputStream("households.dat")
                );

        out.writeObject(households);

        out.close();
    }

    @SuppressWarnings("unchecked")
    public static void loadData() throws IOException, ClassNotFoundException {

        ObjectInputStream in =
                new ObjectInputStream(
                        new FileInputStream("households.dat")
                );

        households = (Map<String, Household>) in.readObject();

        in.close();
    }
}