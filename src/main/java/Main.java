import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.*;
import entities.dto.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.*;


public class Main {
    private static final String URL = "http://localhost:8081";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    public static void main(String[] args) {

        headers.setContentType(MediaType.APPLICATION_JSON);

        Seller seller1 = new Seller( "Dasha", "Orlova", SellerWish.GooglePromotion);
        List<Thing> addedThings = createThingList(seller1);
        List<Integer> quantities = Arrays.asList(1,2,3,4,5);

        //added things on site
        addThingsOnSite(seller1, addedThings, quantities);

        //get things from DB
        ResponseEntity<ThingsDTO> response2 = restTemplate
                .exchange(URL + "/things/getAll", HttpMethod.GET, headersEntity, ThingsDTO.class);
        printThings(Objects.requireNonNull(response2.getBody()).getThings());

        //get things from DB
         response2 = restTemplate
                 .exchange(URL + "/things/getAll", HttpMethod.GET, headersEntity, ThingsDTO.class);
         List<Thing> thingsForSale = Objects.requireNonNull(response2.getBody()).getThings();
         printThings(thingsForSale);

        Customer customer1 = new Customer( "Masha", "Driha", Size.M, Problems.AppSlowsDown);
        Customer customer2 = new Customer( "Anna", "Derek", Size.XS, Problems.ButtonIsNotPressed);

        //creating orders
        System.out.println("Trying to create new order");
        List<Thing> bucketForCustomer1 = new ArrayList<>(thingsForSale.subList(0, 2));
        makeOrder(customer1, seller1, bucketForCustomer1);

        System.out.println("Trying to create new order");
        List<Thing> bucketForCustomer2 = new ArrayList<>(thingsForSale.subList(2, 5));
        // bucketForCustomer2.add(thingsForSale.get(5));
        makeOrder(customer2, seller1, bucketForCustomer2);

        //get things from DB
        response2 = restTemplate
                .exchange(URL + "/things/getAll", HttpMethod.GET, headersEntity, ThingsDTO.class);
        printThings(Objects.requireNonNull(response2.getBody()).getThings());

        //get customers from DB
        ResponseEntity<CustomerDTO> response4 = restTemplate
                .exchange(URL + "/customers/getAll", HttpMethod.GET, headersEntity, CustomerDTO.class);
        System.out.println("___________________________________________" + "\nCustomers: ");
        for (Customer c : Objects.requireNonNull(response4.getBody()).getCustomers()) {
            System.out.println(c);
        }
        System.out.println("\n___________________________________________");

        ResponseEntity<OrdersDTO> response5 = restTemplate
                .exchange(URL + "/orders/getAll", HttpMethod.GET, headersEntity, OrdersDTO.class);
        System.out.println("___________________________________________" + "\nOrders: ");
        for (Order o : Objects.requireNonNull(response5.getBody()).getOrders()) {
            System.out.println(o);
        }
        System.out.println("\n___________________________________________");
    }

    private static void makeOrder(Customer customer, Seller seller, List<Thing> bucketForCustomer) {
        CreateOrderDTO createOrderDTO = new CreateOrderDTO();
        createOrderDTO.setCustomer(customer);
        createOrderDTO.setSeller(seller);
        createOrderDTO.setThings(bucketForCustomer);
        HttpEntity<CreateOrderDTO> createOrder = new HttpEntity<>(createOrderDTO);
        ResponseEntity<Void> response4 = restTemplate
                .exchange(URL + "/orders/create", HttpMethod.POST,
                        createOrder, Void.class);
    }

    public static List<Thing> createThingList(Seller seller1) {

        Thing thing1 = new Thing(NameofThing.shirt, 30, Size.M, ConditionOfThing.good);
        Thing thing2 = new Thing(NameofThing.skirt, 35, Size.S, ConditionOfThing.veryGood);
        Thing thing3 = new Thing(NameofThing.suit, 100, Size.S, ConditionOfThing.ideal);
        Thing thing4 = new Thing(NameofThing.jeans, 80, Size.M, ConditionOfThing.norm);
        Thing thing5 = new Thing(NameofThing.dress, 57, Size.L, ConditionOfThing.New);

        return Arrays.asList(thing1, thing2, thing3, thing4, thing5);
    }


    private static void addThingsOnSite(Seller seller1, List<Thing> addedThings, List<Integer> quantities) {
        ServeDTO serveDTO = new ServeDTO();
        serveDTO.setSeller(seller1);
        serveDTO.setThing(addedThings);
        System.out.println(seller1);
        serveDTO.setThingQuantities(quantities);
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String serveJsonStr = gson.toJson(serveDTO);

        HttpEntity<String> serveJson = new HttpEntity<>(serveJsonStr, headers);
        ResponseEntity<Void> response1 = restTemplate
                .exchange(URL + "/sell/sellThings", HttpMethod.POST, serveJson, Void.class);

        System.out.println("Seller " + seller1.getLastName() + " has added " + addedThings);
    }

    private static void printThings(List<Thing> things) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n___________________________________________");
        stringBuilder.append("\nThings: ");
        for (Thing th : things) {
            stringBuilder.append("\n").append(th);
        }
        stringBuilder.append("\n___________________________________________");

        System.out.println(stringBuilder.toString());
    }
}
