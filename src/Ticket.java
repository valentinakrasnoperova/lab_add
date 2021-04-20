public class Ticket {
    int id;
    String serviceName;
    String problemDescription;
    boolean isActive;
    int customerId;
    int supportSpecialistId;

    public Ticket(int id, String serviceName, String problemDescription, boolean isActive, int customerId, int supportSpecialistId) {
        this.id = id;
        this.serviceName = serviceName;
        this.problemDescription = problemDescription;
        this.isActive = isActive;
        this.customerId = customerId;
        this.supportSpecialistId = supportSpecialistId;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", problemDescription='" + problemDescription + '\'' +
                ", isActive=" + isActive +
                ", customerId=" + customerId +
                ", supportSpecialistId=" + supportSpecialistId +
                '}';
    }
}
