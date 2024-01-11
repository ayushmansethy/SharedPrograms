import java.util.*;

class Order {
    private int orderId;
    private Date entryTime;

    public Order(int orderId, Date entryTime) {
        this.orderId = orderId;
        this.entryTime = entryTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public Date getEntryTime() {
        return entryTime;
    }
}

public class OrderManager {
    private TreeMap<Date, Order> orderMap;

    public OrderManager() {
        // Initialize the TreeMap with a custom comparator for sorting based on time
        this.orderMap = new TreeMap<>(Comparator.comparingLong(Date::getTime));
    }

    public void addOrder(Order order) {
        orderMap.put(order.getEntryTime(), order);
    }

    public List<Order> getOrdersBetweenTimeIntervals(Date startTime, Date endTime) {
        SortedMap<Date, Order> subMap = orderMap.subMap(startTime, endTime);
        return new ArrayList<>(subMap.values());
    }

    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();

        // Adding some sample data
        orderManager.addOrder(new Order(1, new Date(2024, 0, 11, 10, 30)));  // January 11, 2024, 10:30 AM
        orderManager.addOrder(new Order(2, new Date(2024, 0, 11, 12, 45)));  // January 11, 2024, 12:45 PM
        orderManager.addOrder(new Order(3, new Date(2024, 0, 11, 15, 0)));   // January 11, 2024, 3:00 PM

        // Retrieving orders between two time intervals
        Date startTime = new Date(2024, 0, 11, 11, 0);  // January 11, 2024, 11:00 AM
        Date endTime = new Date(2024, 0, 11, 14, 0);    // January 11, 2024, 2:00 PM

        List<Order> ordersBetweenIntervals = orderManager.getOrdersBetweenTimeIntervals(startTime, endTime);

        // Displaying the retrieved orders
        System.out.println("Orders between " + startTime + " and " + endTime + ":");
        for (Order order : ordersBetweenIntervals) {
            System.out.println("Order ID: " + order.getOrderId() + ", Entry Time: " + order.getEntryTime());
        }
    }
}
