public class Airline {
    private String name;

    public Airline(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double calculateTicketPrice(boolean isInternational, boolean hasMeal) {
        double basePrice = isInternational ? 1300 : 1000;
        double mealPrice = hasMeal ? 300 : 0;
        return basePrice + mealPrice;
    }
}