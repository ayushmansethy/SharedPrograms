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

public class Ordermanegement {
    private List<Order> orders;

    public Ordermanegement() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
        // Sort the list after each addition based on entry time
        Collections.sort(orders, Comparator.comparingLong(o -> o.getEntryTime().getTime()));
    }

    public List<Order> getOrdersBetweenTimeIntervals(Date startTime, Date endTime) {
        List<Order> result = new ArrayList<>();
        int startIndex = binarySearch(orders, startTime, true);
        int endIndex = binarySearch(orders, endTime, false);

        for (int i = startIndex; i <= endIndex; i++) {
            result.add(orders.get(i));
        }

        return result;
    }

    private int binarySearch(List<Order> orders, Date targetTime, boolean isStart) {
        int low = 0;
        int high = orders.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            Date midTime = orders.get(mid).getEntryTime();

            if (midTime.compareTo(targetTime) < 0) {
                low = mid + 1;
            } else if (midTime.compareTo(targetTime) > 0) {
                high = mid - 1;
            } else {
                // Handle the case when targetTime is found, and it's an endpoint (start or end of the interval)
                if (isStart) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Ordermanegement orderManager = new Ordermanegement();

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
