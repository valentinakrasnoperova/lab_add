import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SupportService {
    int profilesId;
    int ticketsId;
    List<Customer> listOfCustomers;
    List<SupportSpecialist> listOfSpecialists;
    List<Profile> listOfProfiles;
    List<Service> listOfServices;
    List<Ticket> listOfTickets;

    SupportService() {
        listOfCustomers = new ArrayList<>();
        listOfSpecialists = new ArrayList<>();
        listOfProfiles = new ArrayList<>();
        listOfServices = new ArrayList<>();
        listOfTickets = new ArrayList<>();
    }

    public static void main(String[] args) {
        SupportService suppService = new SupportService();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            suppService.addNewCustomer(i, "customerUserName" + i, "password" + i,
                    suppService.profilesId, "Customer" + i + " Name" + i, "Customer" + i + " Surname" + i,
                    "customer" + i + "email@bla.com", "+3809325418" + i, "address" + i,
                    "postalCode" + i);

            suppService.profilesId++;
        }

        for (int i = 0; i < 3; i++) {
            suppService.addNewSpecialist(i, "specialistUserName" + i, "password" + i,
                    suppService.profilesId, "Specialist" + i + " Name" + i, "Specialist" + i + " Surname" + i,
                    "specialist" + i + "email@bla.com", "+3809325418" + i, "address" + i,
                    "postalCode" + i);

            suppService.profilesId++;
        }

        for (int i = 0; i < 5; i++) {
            suppService.addNewService(i, "serviceName" + i, true, 100 + i);
        }


        // (every customer can use a few services) and Service can have a few client's ID)
        int numberOfServices;
        int serviceId;
        Service service;
        List<Integer> listOfInts = new ArrayList<>();
        for (Customer customer : suppService.listOfCustomers) {

            numberOfServices = random.nextInt(3) + 1; // number of client's services from 1 to 3

            for (int i = 0; i < numberOfServices; i++) {
                serviceId = random.nextInt(suppService.listOfServices.size());
                while (listOfInts.contains(serviceId)) {
                    serviceId = random.nextInt(suppService.listOfServices.size());
                }

                listOfInts.add(serviceId);

                customer.getServices().add(serviceId);

                service = suppService.listOfServices.get(serviceId);

                service.getCustomers().add(customer.getId());
            }

            listOfInts.clear();
        }

        // every Customer - has at least one ticket and can have more then one
        // one SupportSpecialist can have many unanswered tickets
        int numberOfTicket;
        Ticket ticket;
        SupportSpecialist specialist;
        for (Customer customer : suppService.listOfCustomers) {

            numberOfTicket = random.nextInt(2) + 1;

            for (int i = 0; i < numberOfTicket; i++) {
                service = suppService.listOfServices.get(random.nextInt(suppService.listOfServices.size()));


                specialist = suppService.listOfSpecialists.get(random.nextInt(suppService.listOfSpecialists.size()));

                ticket = suppService.addNewTicket(suppService.ticketsId, service.getServiceName(),
                        "problem" + numberOfTicket + "." + i, true,
                        customer.getId(), specialist.getId());

                customer.getTickets().add(ticket.getId());

                specialist.getTickets().add(ticket.getId());

                suppService.ticketsId++;
            }
        }

        /*

        #fetch_all_customers - displays all clients with their respective profiles
        #fetch_all_tickets - displays all packages with clients without profiles
        #fetch_all_specialists - displays all those employees with profiles and tickets
        #fetch_all_services - displays all services with the respective clients
        */
        Scanner scan = new Scanner(System.in);
        String request;
        while (true) {
            System.out.println("Please enter your request:");
            request = scan.nextLine();

            switch (request) {
                case "#fetch_all_customers": {
                    suppService.fetchAllCustomers();
                    break;
                }
                case "#fetch_all_tickets": {
                    suppService.fetchAllTickets();
                    break;
                }
                case "#fetch_all_specialists": {
                    suppService.fetchAllSpecialists();
                    break;
                }
                case "#fetch_all_services": {
                    suppService.fetchAllServices();
                    break;
                }
                case "#exit": {
                    return;
                }
                default: {
                    System.out.println("You have entered wrong request");
                }
            }

        }
    }


    void addNewCustomer(int id, String username, String password,
                        int profileID, String firstName, String lastName, String email,
                        String phoneNumber, String address, String postalCode) {
        listOfCustomers.add(new Customer(id, username, password, profileID));
        listOfProfiles.add(new Profile(profileID, firstName, lastName, email, phoneNumber, address, postalCode, id));
    }

    void addNewSpecialist(int id, String username, String password, int profileId,
                          String firstName, String lastName, String email, String phoneNumber,
                          String address, String postalCode) {
        listOfSpecialists.add(new SupportSpecialist(id, username, password, profileId));
        listOfProfiles.add(new Profile(profileId, firstName, lastName, email, phoneNumber, address, postalCode, id));
    }

    void addNewService(int id, String serviceName, boolean isActive, int serviceMonthPrice) {
        listOfServices.add(new Service(id, serviceName, isActive, serviceMonthPrice));
    }

    Ticket addNewTicket(int id, String serviceName, String problemDescription, boolean isActive, int customerId, int supportSpecialistId) {
        Ticket ticket = new Ticket(id, serviceName, problemDescription, isActive, customerId, supportSpecialistId);
        listOfTickets.add(ticket);

        return ticket;
    }

    void fetchAllCustomers() {
        for (Customer customer : listOfCustomers) {
            System.out.println(customer);
            System.out.println(listOfProfiles.get(customer.getProfileID()));
            System.out.println("------------------------------------------------");
        }
        System.out.println("=======================================================");
    }

    void fetchAllTickets() {
        for (Ticket ticket : listOfTickets) {
            System.out.println(ticket);
            System.out.println(listOfCustomers.get(ticket.getCustomerId()));
            System.out.println("------------------------------------------------");
        }
        System.out.println("=======================================================");
    }

    void fetchAllSpecialists() {
        List<Integer> tickets;
        for (SupportSpecialist specialist : listOfSpecialists) {
            System.out.println(specialist);
            System.out.println();
            System.out.println(listOfProfiles.get(specialist.getProfileId()));
            System.out.println();
            tickets = specialist.getTickets();
            for (int ticketId : tickets) {
                System.out.println(listOfTickets.get(ticketId));
            }
            System.out.println("------------------------------------------------");
        }
        System.out.println("=======================================================");
    }

    void fetchAllServices() {
        List<Integer> customers;
        for (Service service : listOfServices) {
            System.out.println(service);
            System.out.println();
            customers = service.getCustomers();
            for (int customerId : customers) {
                System.out.println(listOfCustomers.get(customerId));
            }
            System.out.println("------------------------------------------------");
        }
        System.out.println("=======================================================");
    }
}