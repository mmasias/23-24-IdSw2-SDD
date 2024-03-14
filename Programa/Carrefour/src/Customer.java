import java.util.List;
import java.util.ArrayList;

public class Customer
{
    private static List<Customer> customers = new ArrayList<Customer>();

    int id;
    int numberOfPacks;

    public void AddCostumer()
    {
        List<Customer> lista = customers;
        Customer newcCustomer = new Customer();
        
        if(lista == null){newcCustomer.id = 1;newcCustomer.numberOfPacks = PacksRandom(); lista.add(newcCustomer);}
        else  
        {
            newcCustomer.id = lista.size();
            newcCustomer.numberOfPacks = PacksRandom();
            lista.add(newcCustomer);
        }
    
        customers = lista;
    }
    



    public int GetPacks(int id) 
    {
        List<Customer> lista = customers;
        

        for ( Customer list : lista) 
        {

            if (list.id == id) 
            {
                return list.numberOfPacks;
            
            }
            
        }

        return 0;
    }

    private int PacksRandom() { return  5 + (int)(Math.random() * ((15 - 5) + 1));}

}
