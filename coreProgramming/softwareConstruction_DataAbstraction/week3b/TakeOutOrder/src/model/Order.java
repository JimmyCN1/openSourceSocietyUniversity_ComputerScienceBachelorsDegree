package model;

public class Order {
    private Integer ticketNumber;
    private String customerName;
    private String comboID;
    private Double price;
    private String specialInstructions;
    private String status;
    private String waitTime;

    public Order(Integer ticketNumber) {
        this.setTicketNumber(ticketNumber);
    }

    //SETTERS:
    public void setTicketNumber(Integer ticketNumber) { this.ticketNumber = ticketNumber; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setComboID(String comboID) { this.comboID = comboID; }
    public void setSpecialInstructions(String specialInstructions) { this.specialInstructions = specialInstructions; }
    public void setStatus(String status) { this.status = status; }

    //GETTERS:
    public Integer getTicketNumber() { return ticketNumber; }
    public String getCustomerName() { return customerName; }
    public String getComboID() { return comboID; }
    public Double getPrice() { return price; }
    public String getSpecialInstructions() { return specialInstructions; }
    public String getStatus() { return status; }
    public String getWaitTime() { return waitTime; }

    //MODIFIES: this
    //EFFECTS; sets the price and wait time of the order depending on the order taken
    public void setPriceAndWaitTime(String combo) {
        Double price;
        String wait;
        switch(combo) {
            case "A":
                ComboA comboA = new ComboA();
                price = comboA.getPrice();
                this.price = price;
                wait = comboA.getCookingTime();
                this.waitTime = wait;
                break;
            case "B":
                ComboB comboB = new ComboB();
                price = comboB.getPrice();
                this.price = price;
                wait = comboB.getCookingTime();
                this.waitTime = wait;
                break;
            case "C":
                ComboC comboC = new ComboC();
                price = comboC.getPrice();
                this.price = price;
                wait = comboC.getCookingTime();
                this.waitTime = wait;
                break;
            case "D":
                ComboD comboD = new ComboD();
                price = comboD.getPrice();
                this.price = price;
                wait = comboD.getCookingTime();
                this.waitTime = wait;
                break;
        }
    }

}

