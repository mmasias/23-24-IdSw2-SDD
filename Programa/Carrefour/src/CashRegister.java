import java.util.List;
import com.google.gson.reflect.TypeToken;

public class CashRegister {
    
    int id;
    int CurrentCashier;
    boolean isOcuppied;
    boolean isOpen;

    String filePath = "C:\\Users\\Sergio\\Desktop\\Caja Carrefour\\Carrefour\\src\\BD_CashRegister";

    List<CashRegister> lRegisters = getLRegisters();
    
    Cashier cashiers = new Cashier();

    List<Cashier> lCashiers = cashiers.getLCashiers();

    

    // Aqui realiza al abrir el centro la apertura y asignacion de 2 cajas
    public CashRegister()
    {
        for (CashRegister cashRegister : lRegisters) 
        {
            if (cashRegister.id == 1 || cashRegister.id == 2) 
            {
                cashRegister.isOpen = true;
                cashRegister.CurrentCashier = cashRegister.id;
                cashRegister.isOcuppied = true;              
                
                
            }            

        }
        SaveNewData(lRegisters);
        for (Cashier cashier : lCashiers) 
                {
                    if (cashier.id ==1 || cashier.id ==2) 
                    {
                        cashier.isServing = true;
                        
                    }
                } 
        
        cashiers.SaveNewData(lCashiers);

    }

    public int[] GetIdOpenned()
    {
        List<CashRegister> list = lRegisters;
        int[] openned = new int[list.size()];
        int count = 0;
        for (CashRegister rCashRegister : lRegisters) 
        {
            if (rCashRegister.isOpen) 
            {
                openned[count] = rCashRegister.id; 
                count++;
            }
            
        }


        return openned;
    }


    public void SaveNewData(List<CashRegister> list){BD_DATA.writeJsonFile(filePath, lRegisters);}

    public List<CashRegister> getLRegisters() {
        if (lRegisters == null) {
            lRegisters = BD_DATA.readJsonFile(filePath, new TypeToken<List<CashRegister>>(){}.getType());
        }
        return lRegisters;
    }
    



}
