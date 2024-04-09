package Controllers;

import Enums.TileTypes;
import Models.Map;
import Models.Tile;
import Models.World;
import Views.WorldView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WorldController {

    private World world;
    private WorldView worldView;
    private void initializeWorldMap(){
        String path = " ";

        Map worldMap = this.world.getMap();
        List<String[]> mapData = this.readFileContent(path);
        populateMap(mapData, world.getMap());
    }

    public List<String[]> readFileContent(String filePath){
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

    private void populateMap(List<String[]> mapData, Map worldMap){
        for(int i = 0; i < mapData.size(); i++){
            for(int j = 0; j < mapData.get(i).length; j++){
                worldMap.updateTile(i, j, createTileByNumber(mapData.get(i)[j]));
            }
        }
    }

    private Tile createTileByNumber(String tileNumber){
        for(TileTypes tileType : TileTypes.values()){
            if(tileType.getTileNumber().equals(tileNumber)){
                return new Tile(tileType);
            }
        }
        return null;
    }

    private char getRandomCharacterMovement(){
        Random random = new Random();
        char[] movements = {'W', 'A', 'S', 'D'};
        return movements[random.nextInt(movements.length)];
    }

    private char getUserInput(){
        Scanner scanner = new Scanner(System.in);
        return processUserInput(Character.toUpperCase(scanner.nextLine().charAt(0));
    }

    private char processUserInput(char input){
        if(input == ('W' | 'A' | 'S' | 'D')){
            return input;
        } else {
            return ' ';
        }
    }

}
