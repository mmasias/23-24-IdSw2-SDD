public class Customer {
    private int id;
    private int numberOfItemPacks;

    public Customer(int id, int numberOfItemPacks) {
        this.id = id;
        this.numberOfItemPacks = numberOfItemPacks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfItemPacks() {
        return numberOfItemPacks;
    }

    public void setNumberOfItemPacks(int numberOfItemPacks) {
        this.numberOfItemPacks = numberOfItemPacks;
    }

    public void purchaseItemPack() {
        if (this.numberOfItemPacks > 0) {
            this.numberOfItemPacks--;
        }
    }

    public void returnItemPack() {
        this.numberOfItemPacks++;
    }
}
