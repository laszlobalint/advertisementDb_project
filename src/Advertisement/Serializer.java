package Advertisement;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Serializer {

    public static void serialize(TreeMap map, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(map);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /src/" + filename);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Map deserialize(String filename) {
        TreeMap map = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            map = (TreeMap) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("HashMap class not found.");
            c.printStackTrace();
        }
        return map;
    }
}
