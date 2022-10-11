package ba.edu.ssst;

import java.util.ArrayList;

public interface IData {
    String getName();
    double getSize();
    ArrayList<String> getFiles();
    String getFile(String fileName);
    boolean setFile(String fileName, String data);
}
