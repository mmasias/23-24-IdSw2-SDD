import java.util.ArrayList;
import java.util.List;

public class ShoppingCenter {
    private String openingHour;
    private String closingHour;
    private boolean isOpen;
    private List<Customer> customersInside;

    public ShoppingCenter(String openingHour, String closingHour) {
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.isOpen = false;
        this.customersInside = new ArrayList<>();
    }

    
    public String getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(String openingHour) {
        this.openingHour = openingHour;
    }

    public String getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(String closingHour) {
        this.closingHour = closingHour;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public List<Customer> getCustomersInside() {
        return customersInside;
    }

    public void addCustomer(Customer customer) {
        customersInside.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customersInside.remove(customer);
    }

    public void openCenter() {
        this.isOpen = true;
        System.out.println("09:00 - ABRE EL SUPERMERCADO");
    }

    public void closeCenter() {
        this.isOpen = false;
        System.out.println("EL SUPERMERCADO HA CERRADO");
    }

    
    public void updateStatus(String currentTime) {
        if (currentTime.equals(this.openingHour) && !this.isOpen) {
            openCenter();
        }
    }
}
