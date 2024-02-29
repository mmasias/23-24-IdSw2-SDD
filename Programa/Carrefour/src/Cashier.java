import java.util.List;
import com.google.gson.reflect.TypeToken;




public class Cashier 
{
    String filePath = "C:\\Users\\Sergio\\Desktop\\Caja Carrefour\\Carrefour\\src\\BD_Cashier";

    List<Cashier> cashiers = getLCashiers();

    int id;
    String name;
    String workShift;
    boolean workBreak;
    boolean isServing;

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

public String GetWorkShift(int id)
{
    List<Cashier> list = cashiers;

    for (Cashier cashier : list) 
    {
        if (cashier.id == id) 
        {
            return cashier.workShift;
            
        }

    }


    return null;
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

            SaveNewData(list);
        }

    }

    
}

public List<Cashier> getLCashiers() {
    if (cashiers == null) {
        cashiers = BD_DATA.readJsonFile(filePath, new TypeToken<List<Cashier>>(){}.getType());
    }
    return cashiers;
}


public void SaveNewData(List<Cashier> list){BD_DATA.writeJsonFile(filePath, cashiers);}

}
