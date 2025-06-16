import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Represents a ride with a unique ID, timestamp, start and end locations, and a list of passengers.
 * Implements the Comparable interface to allow sorting based on the timestamp.
 */
public class Ride implements Comparable<Ride>{
    public int rideId;
    public Date timeStamp;
    public String[] passengers;
    public int startId;
    public int endId;
    public int passengerCount; // To keep track of the number of passengers

    /**
     * Constructor to initialize a Ride object with specified parameters.
     *
     * @param rideId the unique identifier for the ride
     * @param timeStamp the timestamp for the ride
     * @param startId the ID of the start location
     * @param endId the ID of the end location
     */
    public Ride(int rideId, Date timeStamp, int startId, int endId){
        this.rideId = rideId;
        this.timeStamp = timeStamp;
        this.startId = startId;
        this.endId = endId;

        this.passengers = new String[6]; // Initialize the passengers array with a capacity of 6
        this.passengerCount = 0;    // Initialize the passenger count to 0
    }

    /**
     * Adds a passenger to the ride if there is available space.
     *
     * @param passName the name of the passenger to be added
     */
    public void AddPassenger(String passName){
        if (passengerCount < passengers.length) {
            passengers[passengerCount] = passName;
            passengerCount++;
        } else {
            System.out.println("Cannot add more passengers, ride is full.");
        }
    }

    /**
     * Compares this ride to another ride based on the timestamp.
     *
     * @param r2 the ride to be compared with
     * @return -1 = r1 < r2
     *          0 = r1 = r2
     *          1 = r1 > r2
     *          (based on timestamps)
     */
    @Override
    public int compareTo(Ride r2) {
        return this.timeStamp.compareTo(r2.timeStamp);
    }

    /**
     * Returns a string representation of the ride, including ride details and passenger names.
     *
     * @return a formatted string with ride information
     */
    @Override
    public String toString() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        sb.append("--- Ride ").append(String.format("%03d", rideId)).append(" -------\n");
        sb.append("Time: ").append(timeFormat.format(timeStamp)).append("\n");
        sb.append("Start ID: ").append(startId).append("\n");
        sb.append("End ID: ").append(endId).append("\n");
        sb.append("Passengers:\n");
        for (int i = 0; i < passengerCount; i++) {
            sb.append(passengers[i]).append("\n");
        }
        sb.append("--------------------");
        return sb.toString();
    }
    
}
