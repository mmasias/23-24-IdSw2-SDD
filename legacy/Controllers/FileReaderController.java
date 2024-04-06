package Controllers;


import java.io.*;
import java.util.*;

class FileReaderController {

    private String filePath;

    public FileReaderController(String filePath) {
        this.filePath = filePath;
    }

    public void setFilePath(String path) {
        this.filePath = path;
    }

   
    public List<String[]> readCSV() throws FileNotFoundException  {
        List<String[]> listTiles = new ArrayList<String[]>();
        
        
        try {

            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            
            while((line = br.readLine()) != null) {
                String[] tokens = line.split(",", 0);
                listTiles.add(tokens);
                
            }

        } catch (Exception e) {

            System.out.println("Failed to read file");
            System.out.println(e.getMessage());
        }

        return listTiles;
    }

}