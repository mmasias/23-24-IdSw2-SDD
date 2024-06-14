public class CashRegister {
    private int id;
    private Cashier currentCashier;
    private Customer currentCustomer;
    private boolean isOpen;
    private boolean isOccupied;
    private int servedCustomers;
    private boolean pendingShiftChange;
    private boolean pendingBreak;
    private int breakCounter;
    private AttentionCenter attentionCenter;

    public CashRegister(int id, AttentionCenter attentionCenter) {
        this.id = id;
        this.isOpen = false;
        this.isOccupied = false;
        this.servedCustomers = 0;
        this.pendingShiftChange = false;
        this.pendingBreak = false;
        this.breakCounter = 0;
        this.attentionCenter = attentionCenter;
    }

    public int getId() {
        return id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Cashier getCurrentCashier() {
        return currentCashier;
    }

    public void setCurrentCashier(Cashier currentCashier) {
        this.currentCashier = currentCashier;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public int getServedCustomers() {
        return servedCustomers;
    }

    public int getBreakCounter() {
        return breakCounter;
    }

    public void setBreakCounter(int breakCounter) {
        this.breakCounter = breakCounter;
    }

    public void openRegister() {
        this.isOpen = true;
        this.servedCustomers = 0;
        this.breakCounter = 0;
        System.out.println("Cash register " + this.id + " is now open.");
    }

    public void closeRegister() {
        if (!this.isOccupied) {
            this.isOpen = false;
            System.out.println("Cash register " + this.id + " is now closed.");
            this.servedCustomers = 0;
        }
    }

    public void serveCustomer(Customer customer) {
        if (!this.isOccupied && this.currentCashier != null && this.currentCashier.isServing()) {
            this.isOccupied = true;
            this.currentCustomer = customer;
            this.servedCustomers++;
            System.out.println("Serving customer " + customer.getId() + " at cash register " + this.id);
        }
    }

    public void processCustomer(ShoppingCenter shoppingCenter) {
        if (this.isOccupied && this.currentCustomer != null) {
            int remainingItems = this.currentCustomer.getNumberOfItemPacks() - 1;
            this.currentCustomer.setNumberOfItemPacks(remainingItems);
            if (remainingItems <= 0) {
                shoppingCenter.removeCustomer(this.currentCustomer);
                finishServingCustomer();
            }
        }
    }

    public void finishServingCustomer() {
        if (this.currentCustomer != null) {
            System.out.println(
                    "Finished serving customer " + this.currentCustomer.getId() + " at cash register " + this.id);
        }
        this.isOccupied = false;
        this.currentCustomer = null;
        System.out.println("Cash register " + this.id + " is now free.");

        if (this.pendingShiftChange) {
            this.pendingShiftChange = false;
            attentionCenter.changeCashier(this);
        }
    }

    public boolean isPendingShiftChange() {
        return pendingShiftChange;
    }

    public boolean isPendingBreak() {
        return pendingBreak;
    }

    public void setPendingShiftChange(boolean pendingShiftChange) {
        this.pendingShiftChange = pendingShiftChange;
    }

    public void startBreak() {
        if (this.isOccupied) {
            this.pendingBreak = true;
            System.out.println("break " + this.currentCashier.getName());
        }
        if (pendingBreak && !this.isOccupied) {
            System.out.println("break begin" + this.currentCashier.getName());
            beginBreak();
        }
    }

    private void beginBreak() {
        this.isOpen = false;
        System.out.println("Cash register " + this.id + " is closed for a break.");
        this.breakCounter = 15; 
    }

    public void endBreak() {
        this.isOpen = true;
        this.pendingBreak = false;
        System.out.println("Cash register " + this.id + " is now open after break.");
    }

}
