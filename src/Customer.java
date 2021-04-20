import java.util.ArrayList;
import java.util.List;

public class Customer {
    int id;
    String username;
    String password;
    int profileID;
    List<Integer> services;
    List<Integer> tickets;

    public Customer(int id, String username, String password, int profileID) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.profileID = profileID;
        services = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    public List<Integer> getServices() {
        return services;
    }

    public int getId() {
        return id;
    }

    public int getProfileID() {
        return profileID;
    }

    public List<Integer> getTickets() {
        return tickets;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", profileID=" + profileID +
                ", services=" + services +
                ", tickets=" + tickets +
                '}';
    }
}
