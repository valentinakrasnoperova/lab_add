import java.util.ArrayList;
import java.util.List;

public class Service {
    int id;
    String serviceName;
    boolean isActive;
    int serviceMonthPrice;
    List<Integer> customers;

    public Service(int id, String serviceName, boolean isActive, int serviceMonthPrice) {
        this.id = id;
        this.serviceName = serviceName;
        this.isActive = isActive;
        this.serviceMonthPrice = serviceMonthPrice;
        customers = new ArrayList<>();
    }

    public List<Integer> getCustomers() {
        return customers;
    }

    public String getServiceName() {
        return serviceName;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", isActive=" + isActive +
                ", serviceMonthPrice=" + serviceMonthPrice +
                ", customers=" + customers +
                '}';
    }
}
