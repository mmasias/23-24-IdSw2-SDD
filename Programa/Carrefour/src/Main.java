import java.util.List;

public class Main implements TimeObserver {

    public static void main  (String[] args) {

        ShoppingCenter Carrefour = new ShoppingCenter();
        
        Carrefour.Start();

    }

    public  void onTimeChange(String time, boolean allOpen)
    {
    CashRegister register = new CashRegister();
    List<CashRegister> ListRegister = register.getLRegisters();

        for (CashRegister caja : ListRegister) {
            System.out.println("Caja atendida por: " + caja.CurrentCashier);
            System.out.println("Estado: " + (caja.isAbierta() ? "Abierta" : "Cerrada"));
            System.out.println("Número de clientes: " + caja.getNumeroDeClientes());
            System.out.println("Cola de clientes: " + caja.imprimirCola());
            System.out.println();
        }



    }

}
