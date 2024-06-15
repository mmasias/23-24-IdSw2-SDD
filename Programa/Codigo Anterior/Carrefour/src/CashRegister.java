import java.util.ArrayList;
import java.util.List;
import com.google.gson.reflect.TypeToken;

public class CashRegister implements TimeObserver {
    
    int id;
    String CurrentCashier;
    boolean isOpen;    
    boolean isOccupied;    
    int remainingPacks; // Paquetes restantes para procesar
    static List<CashRegister> lRegisters = new ArrayList<>(); // Lista de todas las cajas registradoras

    public  void onTimeChange(String time, boolean allOpen) {
        for (CashRegister register : lRegisters) {
            if(register.isOccupied)
            { 
                if (register.remainingPacks == 0) {
                    register.isOccupied = false;
                } else{
                register.remainingPacks--;
                }
            }
        }
    }

    String filePath = "C:\\Users\\Sergio\\Desktop\\Carrefour\\src\\BD_CashRegister";


    
    Cashier cashiers = new Cashier();

    List<Cashier> lCashiers = cashiers.getLCashiers(); 

    


    // Aqui realiza al abrir el centro la apertura y asignacion de 2 cajas,modificar para ingresar nombre de Cashier en su caja
    public CashRegister()
    {
        
        for (CashRegister cashRegister : lRegisters) 
        {
            if (cashRegister.id == 1 || cashRegister.id == 2) 
            {
                for (Cashier cashiers : lCashiers) 
                {
                    if (cashiers.id ==1 || cashiers.id ==2) 
                    {
                        cashiers.isServing = true;
                        cashRegister.CurrentCashier = cashiers.name;
                    }
                } 
        
        
                
                cashRegister.isOpen = true;
                
                cashRegister.isOccupied  = true;              
                
                
            }            

        }
        cashiers.SaveNewData(lCashiers);
        SaveNewData(lRegisters);


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

    public void OpenNewCash()
    {
        Cashier cashier = new Cashier();
        List<CashRegister> list = getLRegisters();
        List<Cashier> lisCashiers = cashier.getLCashiers();
        for (CashRegister register : list)
        {
            if (register.isOpen == false) {
                for(Cashier cashiers : lisCashiers)
                {
                    if (cashiers.isServing == false) {
                        register.CurrentCashier = cashiers.id;
                        cashiers.isServing = true;
                        cashiers.SaveNewData(lisCashiers);   
                    }
                }
                register.SaveNewData(list);
            }
        }
        
        
    }


    public void SaveNewData(List<CashRegister> list){BD_DATA.writeJsonFile(filePath, lRegisters);}

    public List<CashRegister> getLRegisters() {
        if (lRegisters == null) {
            lRegisters = BD_DATA.readJsonFile(filePath, new TypeToken<List<CashRegister>>(){}.getType());
        }
        return lRegisters;
    }
    



}
