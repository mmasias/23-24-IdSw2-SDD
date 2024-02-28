package Controllers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

class FileReaderController {

    private String filePath;

    public FileReaderController(String filePath) {
        this.filePath = filePath;
    }

    public void setFilePath(String path) {
        this.filePath = path;
    }

    public List<String[]> readCSV() {
        List<String[]> listTiles = new ArrayList<String[]>();
        String[] tilesString = new String[0];
        int count = 0;

        FileReader fr = null;
        try {
            fr = new FileReader(filePath);
            int character = fr.read();

            while (character != -1) {
                String tileNumber = String.valueOf(character);
                tilesString[count] = tileNumber;

                count++;
                character = fr.read();
            }

            System.out.println(listTiles);
        } catch (FileNotFoundException e) {

            System.out.println("File not found");

            System.out.println(e.getMessage());
        } catch (Exception e) {

            System.out.println("Failed to read file");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                System.out.println("Failed to close the file");
                System.out.println(e.getMessage());
            }
        }

        listTiles.add(tilesString);
        return listTiles;
    }
}