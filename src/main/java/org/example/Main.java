package org.example;

public class Main {

    public static final double discountForMiddles = 0;
    public static final double discountForTeens = 50;
    public static final double discountForOlds = 30;
    public static final double commonCost = 70;

    public static void main(String[] args) {

        Ticket ticket = new Ticket.Builder(11,9,5,
                getPriceFromDiscount(commonCost, discountForTeens),
                getPriceFromDiscount(commonCost, discountForMiddles),
                getPriceFromDiscount(commonCost, discountForOlds)).build();
        System.out.println(ticket.getCommonCost());
    }

    public static int getPriceFromDiscount(double commonCost, double discount){
        return (int) (commonCost - (commonCost * (discount / 100)));
    }
}

class Ticket {
    private final int teens;
    private final int middles;
    private final int olds;
    private final int teensCost;
    private final int middlesCost;
    private final int oldsCost;

    private Ticket(Builder builder){
        this.teens = builder.teens;
        this.middles = builder.midles;
        this.olds = builder.olds;
        this.teensCost = builder.teensCost;
        this.middlesCost = builder.middlesCost;
        this.oldsCost = builder.oldsCost;
    }

    public int getTeens() {
        return teens;
    }

    public int getMidles() {
        return middles;
    }

    public int getOlds() {
        return olds;
    }

    public int getTeensCost() {
        return teensCost;
    }

    public int getMidlesCost() {
        return middlesCost;
    }

    public int getOldsCost() {
        return oldsCost;
    }

    public int getCommonCost(){
        return teensCost * teens + middlesCost * middles + oldsCost * olds;
    }

    static class Builder {
        private final int teens;
        private final int midles;
        private final int olds;
        private final int teensCost;
        private final int middlesCost;
        private final int oldsCost;

        public Builder(int teens, int midles, int olds, int teensCost, int middlesCost, int oldsCost){
            this.teens = teens;
            this.midles = midles;
            this.olds = olds;
            this.teensCost = teensCost;
            this.middlesCost = middlesCost;
            this.oldsCost = oldsCost;
        }

        public Ticket build(){
            return new Ticket(this);
        }
    }
}

