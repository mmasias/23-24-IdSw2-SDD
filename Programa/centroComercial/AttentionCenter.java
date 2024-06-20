import java.util.List;

public class AttentionCenter {
    private CustomerQueue customerQueue;
    private CashRegister[] cashRegisters;
    private List<Cashier> allCashiers;
    private DataLog dataLog;

    public AttentionCenter(CustomerQueue customerQueue, CashRegister[] cashRegisters, List<Cashier> allCashiers,
            DataLog dataLog) {
        this.customerQueue = customerQueue;
        this.cashRegisters = cashRegisters;
        this.allCashiers = allCashiers;
        this.dataLog = dataLog;
    }

    public void processNextCustomer() {
        if (!customerQueue.isEmpty()) {
            Customer customer = customerQueue.serveNextCustomer();
            if (customer != null) {
                System.out.println("Processing customer: " + customer.getId());
            }
        }
    }
    public void manageQueue() {
        while (!customerQueue.isEmpty()) {
            processNextCustomer();
        }
    }



    public void assignCustomersToCashRegisters() {
        if (!cashRegisters[0].isOpen() && cashRegisters[0].getBreakCounter() <= 0) {
            cashRegisters[0].getCurrentCashier().startShift();
            cashRegisters[0].openRegister();
        }
        if (!cashRegisters[1].isOpen() && cashRegisters[1].getBreakCounter() <= 0) {
            cashRegisters[1].getCurrentCashier().startShift();
            cashRegisters[1].openRegister();
        }

        int requiredQueueLength = 10;
        for (int i = 1; i < cashRegisters.length; i++) {
            if (!cashRegisters[i].isOpen() && customerQueue.getSize() >= requiredQueueLength
                    && cashRegisters[i].getBreakCounter() <= 0) {
                cashRegisters[i].getCurrentCashier().startShift();
                cashRegisters[i].openRegister();
            }
            requiredQueueLength += 5;
        }

        for (CashRegister cashRegister : cashRegisters) {
            if (cashRegister.isOpen() && !cashRegister.isOccupied() && customerQueue.getSize() > 0) {
                Customer customer = customerQueue.peekCustomer();
                cashRegister.serveCustomer(customer);
                customerQueue.removeCustomer();
            }
        }
    }

    public void processCustomersInCashRegisters(ShoppingCenter shoppingCenter) {
        for (CashRegister cashRegister : cashRegisters) {
            if (cashRegister.isOccupied()) {
                cashRegister.processCustomer(shoppingCenter);
            }
        }
    }

    public void closeCashRegisters() {
        int requiredQueueLength = 10;
        boolean closedOne = false;

        for (int i = 1; i < cashRegisters.length && !closedOne; i++) {
            if (cashRegisters[i].isOpen() && !cashRegisters[i].isOccupied() &&
                    cashRegisters[i].getServedCustomers() >= 5 &&
                    customerQueue.getSize() < requiredQueueLength) {
                cashRegisters[i].closeRegister();
                dataLog.registerCashRegisterClosure(); 
                closedOne = true;
            }
            requiredQueueLength += 5;
        }
    }

    public void updateOpenMinutes() {
        for (CashRegister cashRegister : cashRegisters) {
            if (cashRegister.isOpen()) {
                dataLog.incrementOpenMinutes(cashRegister.getId());
            }
        }
    }

    public void handleShiftChanges(String currentTime) {
        if (currentTime.equals("15:00")) {
            for (CashRegister cashRegister : cashRegisters) {
                Cashier currentCashier = cashRegister.getCurrentCashier();
                if (currentCashier != null && currentCashier.getWorkShift().startsWith("09")) {
                    if (!cashRegister.isOccupied()) {
                        changeCashier(cashRegister);
                    } else {
                        cashRegister.setPendingShiftChange(true);
                    }
                }
            }
        }
    }

    public void changeCashier(CashRegister cashRegister) {
        Cashier currentCashier = cashRegister.getCurrentCashier();
        if (currentCashier != null) {
            currentCashier.endShift();
        }

        for (Cashier cashier : allCashiers) {
            if (cashier.getWorkShift().startsWith("15") && !cashier.isServing()) {
                cashRegister.setCurrentCashier(cashier);
                cashier.startShift();
                System.out.println(
                        "Shift changed at cash register " + cashRegister.getId() + " to cashier " + cashier.getName());
                break;
            }
        }
    }

    public void checkAndInitiateBreaks(String currentTime) {
        for (CashRegister cashRegister : cashRegisters) {
            System.out.println(
                    "Checking break for cashier at register " + cashRegister.getId() + " at time " + currentTime);
            if (cashRegister.isOpen() && cashRegister.getCurrentCashier() != null) {
                System.out.println("Register open: " + cashRegister.isOpen());
                System.out.println("Current time: " + currentTime + ", Work break time: "
                        + cashRegister.getCurrentCashier().getWorkBreak());
                System.out.println("Pending shift change: " + cashRegister.isPendingShiftChange() + "t/f: "
                        + currentTime.equals(cashRegister.getCurrentCashier().getWorkBreak()));

                if (currentTime.equals(cashRegister.getCurrentCashier().getWorkBreak())
                        && !cashRegister.isPendingShiftChange()) {
                    cashRegister.startBreak();
                }

                if (cashRegister.isPendingBreak()) {
                    cashRegister.startBreak();
                }
            }
        }
    }

    public CashRegister[] getCashRegisters() {
        return cashRegisters;
    }
}
