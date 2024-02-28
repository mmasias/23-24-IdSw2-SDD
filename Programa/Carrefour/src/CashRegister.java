import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashRegister {
    
    private int id;
    Cashier CashierReference;

    List<Cashier> list = CashierReference.GetAllCashier(); 
    Map<Integer, Integer> empleadoPuestoMap = new HashMap<>();


    public CashRegister()
    {

        for (Cashier cashier : list) {

            if (cashier.id == 1) 
            {
                empleadoPuestoMap.put(1, cashier.id); 
            } else if (cashier.id == 2) 
            {
                empleadoPuestoMap.put(2, cashier.id);
            }
            
        }


    }

   

}
