import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;



public class Cashier 
{
    String filePath = "C:\\Users\\Sergio\\Desktop\\Caja Carrefour\\Carrefour\\src\\BD_Cashier";

    List<Cashier> cashiers = readJsonFile(filePath);

    int id;
    private String name;
    private char workShift;
    private boolean workBreak;
    private boolean isServing;

public int GetID(String name)
{
    List<Cashier> list = cashiers;

    for (Cashier cashier : list) 
    {
        if (cashier.name == name) 
        {
            return cashier.id;
            
        }

    }

    return 0;
}

public void SetIsServing(int id)
{
    List<Cashier> list = cashiers;

    for (Cashier cashier : list) 
    {
        if (cashier.id == id) 
        {
            cashier.isServing = true;
            
        }

    }

    

}
public boolean GetIsServing(int id)
{
    List<Cashier> list = cashiers;

    for (Cashier cashier : list) 
    {
        if (cashier.id == id) 
        {
            return cashier.isServing;
            
        }

    }

    return false;

}

public String GetName(int id)
{
    List<Cashier> list = cashiers;

    for (Cashier cashier : list) 
    {
        if (cashier.id == id) 
        {
            return cashier.name;
            
        }

    }

    return null;
}

public char GetWorkShift(int id)
{
    List<Cashier> list = cashiers;

    for (Cashier cashier : list) 
    {
        if (cashier.id == id) 
        {
            return cashier.workShift;
            
        }

    }


    return 0;
}

public boolean GetRest(int id)
{
    List<Cashier> list = cashiers;

    for (Cashier cashier : list) 
    {
        if (cashier.id == id) 
        {
            return cashier.workBreak;
            
        }

    }

    return false;
}

public void SetRest(int id)
{
    List<Cashier> list = cashiers;

    for (Cashier cashier : list) 
    {
        if (cashier.id == id) 
        {
            cashier.workBreak = true;

            writeJsonFile(filePath, list);
        }

    }

    
}

public List<Cashier> GetAllCashier()
{

    return cashiers;
}




private static List<Cashier> readJsonFile(String filename) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filename)) {
            Type listType = new TypeToken<List<Cashier>>() {}.getType();
            List<Cashier> employees = gson.fromJson(reader, listType);
            return employees;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

private static void writeJsonFile(String filename, List<Cashier> employees) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(employees, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
