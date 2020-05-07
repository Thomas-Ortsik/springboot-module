package academy.everyonecodes.steampurchases.domain;

public class Purchase {

    private String username;
    private String name;

    public Purchase(String username, String name, String uuid, double price) {
        this.username = username;
        this.name = name;
        this.uuid = uuid;
        this.price = price;
    }

    //for the sake of testing with insomnia I turn the UUID into a String
    private String uuid;
    private double price;

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }

    public double getPrice() {
        return price;
    }
}
