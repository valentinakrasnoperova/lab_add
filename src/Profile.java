public class Profile {
    int id;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String address;
    String postalCode;
    int profileID;

    public Profile(int id, String firstName, String lastName, String email, String phoneNumber, String address, String postalCode, int profileID) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.postalCode = postalCode;
        this.profileID = profileID;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", profileID=" + profileID +
                '}';
    }
}
