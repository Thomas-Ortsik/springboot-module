package academy.everyonecodes.restauranttaxer.data;

public class RestaurantDish {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public RestaurantDish(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
