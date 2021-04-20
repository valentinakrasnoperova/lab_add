import java.util.ArrayList;
import java.util.List;

public class SupportSpecialist {
    int id;
    String username;
    String password;
    int profileId;
    List<Integer> tickets;

    public SupportSpecialist(int id, String username, String password, int profileId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.profileId = profileId;
        tickets = new ArrayList<>();
    }

    public List<Integer> getTickets() {
        return tickets;
    }

    public int getId() {
        return id;
    }

    public int getProfileId() {
        return profileId;
    }

    @Override
    public String toString() {
        return "SupportSpecialist{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", profileId=" + profileId +
                ", tickets=" + tickets +
                '}';
    }
}
