
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.*;

/**
 * Unit tests for MinHeap class.
 */
public class MinHeapTest {
    private final PrintStream standardOut = System.out; // To store the original System.out
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream(); // For capturing output

    /**
     * Sets up the environment before each test by capturing the standard output stream
     */
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor)); // Capture System.out
    }

    /**
     * Restores the standard output stream after each test
     */
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut); // Restore System.out
    }

    /**
     * Tests compareTo() method to ensure r1 is greater than r2.
     * This test sets two Ride objects with different timestamps and 
     * verifies that r1.compareTo(r2) returns a positive number.
     */
    @Test
    @DisplayName("Test compareTo(): r1 > r2 = true")
    public void compareToGreaterTestTrue(){
        // Assign   
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 35);
        cal.set(Calendar.SECOND, 1);
        cal.set(Calendar.MILLISECOND, 0);
        Date date1 = cal.getTime();

        // Only change minutes
        cal.set(Calendar.MINUTE, 20);
        Date date2 = cal.getTime();

        // Creating Ride objects with different timestamps
        // r1 is one second later than r2
        Ride r1 = new Ride(1, date1, 324, 586);
        Ride r2 = new Ride(2, date2, 350, 520);

        // Act
        int actual = r1.compareTo(r2);

        // Assert
        Assertions.assertTrue(actual > 0);

    }

    /**
     * Tests compareTo() method to ensure r1 is not greater than r2.
     * This test sets two Ride objects with different timestamps and 
     * verifies that r1.compareTo(r2) does not return a positive number.
     */
    @Test
    @DisplayName("Test compareTo(): r1 > r2 = false")
    public void compareToGreaterTestFalse(){
        // Assign   

        // Assign Dates 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 35);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date1 = cal.getTime();

        // Only change minutes
        cal.set(Calendar.MINUTE, 50);
        Date date2 = cal.getTime();

        // Creating Ride objects with different timestamps
        // r2 is one second later than r1
        Ride r1 = new Ride(1, date1, 324, 586);
        Ride r2 = new Ride(2, date2, 350, 520);

        // Act
        int actual = r1.compareTo(r2);

        // Assert
        Assertions.assertFalse(actual > 0);
    }

    /**
     * Tests compareTo() method to ensure r1 is less than r2.
     * This test sets two Ride objects with different timestamps and 
     * verifies that r1.compareTo(r2) returns a negative number.
     */
    @Test
    @DisplayName("Test compareTo(): r1 < r2 = True")
    public void compareToLesserTestTrue(){
        // Assign   

        // Assign Dates 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 35);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date1 = cal.getTime();

        // Only change minutes
        cal.set(Calendar.MINUTE, 50);
        Date date2 = cal.getTime();
        

        // Creating Ride objects with different timestamps
        // r2 is one second later than r1
        Ride r1 = new Ride(1, date1, 324, 586);
        Ride r2 = new Ride(2, date2, 350, 520);

        // Act
        int actual = r1.compareTo(r2);

        // Assert
        Assertions.assertTrue(actual < 0);
    }

    /**
     * Tests compareTo() method to ensure r1 is not less than r2.
     * This test sets two Ride objects with different timestamps and 
     * verifies that r1.compareTo(r2) does not return a negative number.
     */
    @Test
    @DisplayName("Test compareTo(): r1 < r2 = False")
    public void compareToLesserTestFalse(){
        // Assign   

        // Assign Dates 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 35);
        cal.set(Calendar.SECOND, 1);
        cal.set(Calendar.MILLISECOND, 0);
        Date date1 = cal.getTime();

        // Only change minutes
        cal.set(Calendar.MINUTE, 20);
        Date date2 = cal.getTime();

        // Creating Ride objects with different timestamps
        // r1 is one second later than r2
        Ride r1 = new Ride(1, date1, 324, 586);
        Ride r2 = new Ride(2, date2, 350, 520);

        // Act
        int actual = r1.compareTo(r2);

        // Assert
        Assertions.assertFalse(actual < 0);
    }

    /**
     * Tests compareTo() method to ensure r1 is equal to r2.
     * This test sets two Ride objects with identical timestamps and 
     * verifies that r1.compareTo(r2) returns 0.
     */
    @Test
    @DisplayName("Test compareTo(): r1 == r2 = True")
    public void compareToEqualTestTrue(){
        // Assign   

        // Assign Dates 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 35);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date1 = cal.getTime();

        // Set date2 as the exact same time
        Date date2 = cal.getTime();

        // Creating Ride objects with same timestamps
        Ride r1 = new Ride(1, date1, 324, 586);
        Ride r2 = new Ride(2, date2, 350, 520);

        // Act
        int actual = r1.compareTo(r2);

        // Assert
        Assertions.assertEquals(0, actual); // equal should be 0
    }

    /**
     * Tests compareTo() method to ensure r1 is not equal to r2.
     * This test sets two Ride objects with different timestamps and 
     * verifies that r1.compareTo(r2) does not return 0.
     */
    @Test
    @DisplayName("Test compareTo(): r1 == r2 = False")
    public void compareToEqualTestFalse(){
        // Assign   

        // Assign Dates 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 35);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Date date1 = cal.getTime();

        // Only change minutes
        cal.set(Calendar.MINUTE, 10);
        Date date2 = cal.getTime();


        // Creating Ride objects with same timestamps
        Ride r1 = new Ride(1, date1, 324, 586);
        Ride r2 = new Ride(2, date2, 350, 520);

        // Act
        int actual = r1.compareTo(r2);

        // Assert
        Assertions.assertNotEquals(0, actual); // Not equal should be -1 or 1
    }

    /**
     * Tests the toString() method for a Ride with passengers.
     * This test verifies the string representation of a Ride object 
     * that includes passengers.
     */
    @Test
    @DisplayName("Test toString(): with passengers")
    public void toStringWithPassengersTest() {
        // Assign
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        Ride r1 = new Ride(1, date, 324, 586);

        r1.AddPassenger("Joe Bloggs");
        r1.AddPassenger("Mary Smith");

        // Act
        String expected = 
        "--- Ride 001 -------\n" +
        "Time: 15:30:00\n" +
        "Start ID: 324\n" +
        "End ID: 586\n" +
        "Passengers:\n" +
        "Joe Bloggs\n" +
        "Mary Smith\n" +
        "--------------------";

        // Assert
        Assertions.assertEquals(expected, r1.toString());
    }
    
    /**
     * Tests the toString() method for a Ride without passengers.
     * This test verifies the string representation of a Ride object 
     * that does not include passengers.
     */
    @Test
    @DisplayName("Test toString(): without passengers")
    public void toStringWithoutPassengersTest() {
        // Assign
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        Ride r1 = new Ride(1, date, 324, 586);

        // Act
        String expected = 
        "--- Ride 001 -------\n" +
        "Time: 15:30:00\n" +
        "Start ID: 324\n" +
        "End ID: 586\n" +
        "Passengers:\n" +
        "--------------------";

        // Assert
        Assertions.assertEquals(expected, r1.toString());
    }

    /**
    * Tests the insert() method with a valid ride.
    * It verifies that inserting a ride into the MinHeap is successful.
    */
    @Test
    @DisplayName("Test insert(Ride r): Valid ride.")
    public void insertValidRideTest() {
        // Assign
        MinHeap minHeap = new MinHeap(4);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        // Add passenger to ride
        Ride r1 = new Ride(1, date, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        // Act
        boolean actual = minHeap.insert(r1);
        
        // Assert
        Assertions.assertTrue(actual);
    
    }

    /**
    * Tests the insert() method with multiple valid rides.
    * It verifies that inserting multiple rides into the MinHeap is successful.
    */
    @Test
    @DisplayName("Test insert(Ride r): Multiple valid rides")
    public void insertMultipleValidRideTest() {
        // Assign
        MinHeap minHeap = new MinHeap(4);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        // Only change minutes so rides do not combine
        cal.set(Calendar.MINUTE, 45);
        Date date2 = cal.getTime();
        
        // Only change minutes so rides do not combine
        cal.set(Calendar.MINUTE, 15);
        Date date3 = cal.getTime();
        
        // Add passengers to each ride
        Ride r1 = new Ride(1, date, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        Ride r2 = new Ride(2, date2, 324, 586);
        r2.AddPassenger("Mary Smith");

        Ride r3 = new Ride(3, date3, 324, 586);
        r3.AddPassenger("Charlie Brown");

        // Act
        minHeap.insert(r1);
        minHeap.insert(r2);
        boolean actual = minHeap.insert(r3);

        // Assert
        Assertions.assertTrue(actual);
    }

    /**
    * Tests the insert() method with an invalid duplicate ride ID.
    * It verifies that inserting a ride with a duplicate ID into the MinHeap is unsuccessful.
    */
    @Test
    @DisplayName("Test insert(Ride r): Invalid duplicate ride ID")
    public void insertInvalidDuplicateRideIdTest() {
        // Assign
        MinHeap minHeap = new MinHeap(4);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        // Only change minutes so rides do not combine
        cal.set(Calendar.MINUTE, 1);
        Date date2 = cal.getTime();

        // Create rides with same ID
        Ride r1 = new Ride(1, date, 324, 586);
        r1.AddPassenger("Joe Bloggs");
        Ride r2 = new Ride(1, date2, 324, 586); // Duplicate ID
        r2.AddPassenger("Mary Smith");

        // Act
        minHeap.insert(r1);
        boolean actual = minHeap.insert(r2);

        // Assert
        Assertions.assertFalse(actual);
    }

    /**
    * Tests the insert() method with another invalid duplicate ride ID.
    * It verifies that inserting multiple rides with duplicate IDs into the MinHeap is unsuccessful.
    */
    @Test
    @DisplayName("Test insert(Ride r): Invalid duplicate ride ID")
    public void insertAnotherInvalidDuplicateRideIdTest() {
        // Assign
        MinHeap minHeap = new MinHeap(4);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        // Only change minutes so rides do not combine
        cal.set(Calendar.MINUTE, 1);
        Date date2 = cal.getTime();

        // Create rides with same ID
        Ride r1 = new Ride(1, date, 324, 586);
        r1.AddPassenger("Joe Bloggs");
        Ride r2 = new Ride(2, date2, 324, 586); // Duplicate ID
        r2.AddPassenger("Mary Smith");
        Ride r3 = new Ride(2, date2, 324, 586); // Duplicate ID

        // Act
        minHeap.insert(r1);
        minHeap.insert(r2);
        boolean actual = minHeap.insert(r3);

        // Assert
        Assertions.assertFalse(actual);
    }

    /**
    * Tests the insert() method with a ride that has no passengers.
    * It verifies that inserting a ride with no passengers into the MinHeap is unsuccessful.
    */
    @Test
    @DisplayName("Test insert(Ride r): No passengers")
    public void insertNoPassengersTest() {
        // Assign
        MinHeap minHeap = new MinHeap(4);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        // Create ride
        Ride r1 = new Ride(1, date, 324, 586);

        // Act
        boolean actual = minHeap.insert(r1);

        // Assert
        Assertions.assertFalse(actual);
    }

    /**
    * Tests the insert() method with one ride with passengers and one without passengers.
    * It verifies that inserting a ride with no passengers into the MinHeap is unsuccessful
    * even if there are other rides present in the heap.
    */
    @Test
    @DisplayName("Test insert(Ride r): One ride with passengers and one without passengers")
    public void insertAnotherNoPassengersTest() {
        // Assign
        MinHeap minHeap = new MinHeap(4);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        // Only change minutes so rides do not combine
        cal.set(Calendar.MINUTE, 1);
        Date date2 = cal.getTime();

        // Create rides and add a passenger to r1
        Ride r1 = new Ride(1, date, 324, 586);
        r1.AddPassenger("Joe Bloggs");
        Ride r2 = new Ride(2, date2, 324, 586); // No passengers

        // Act
        minHeap.insert(r1);
        boolean actual = minHeap.insert(r2);

        // Assert
        Assertions.assertFalse(actual);
    }

    /**
    * Tests the insert() method with too many rides (more than 20).
    * It verifies that inserting more than 20 rides into the MinHeap is unsuccessful.
    */
    @Test
    @DisplayName("Test insert(Ride r): Too many rides (>20)")
    public void insertTooManyRidesTest() {
        // Assign
        MinHeap minHeap = new MinHeap(20);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        boolean actual = false;

        // Insert 20 rides
        for (int i = 1; i < 20; i++) {
            cal.set(Calendar.MINUTE, i);
            Ride r = new Ride(i, date, 324, 586);
            // Make sure to add 6 passengers to each ride so rides do not combine
            for (int j = 0; j <5; j++){
                r.AddPassenger("Passenger " + j); 
            }
            
            actual = minHeap.insert(r);
        }

        // Act
        cal.set(Calendar.MINUTE, 10);
        Date date2 = cal.getTime(); // Change minutes for the new ride so it does not combine
        Ride r21 = new Ride(21, date2, 324, 586);
        r21.AddPassenger("Passenger 21");
        actual = minHeap.insert(r21); // Insert 21st ride (over the limit of 20)

        // Assert
        Assertions.assertFalse(actual);
    }

    /**
    * Tests the insert() method by attempting to create a heap with a capacity greater than 20
    * and adding more than 20 rides, which is not possible as the company only has 20 cars.
    */
    @Test
    @DisplayName("Test insert(Ride r): Try creating a heap with a capacity > 20, add more than 20 rides")
    public void insertAnotherTooManyRidesTest() {
        // Assign
        MinHeap minHeap = new MinHeap(25); // Try going over the vehicle limit
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        boolean actual = false;

        // Insert 20 rides
        for (int i = 1; i < 20; i++) {
            cal.set(Calendar.MINUTE, i);
            Ride r = new Ride(i, date, 324, 586);
            // Make sure to add 6 passengers to each ride so rides do not combine
            for (int j = 0; j <5; j++){
                r.AddPassenger("Passenger " + j); 
            }
            
            actual = minHeap.insert(r);
        }

        // Act
        cal.set(Calendar.MINUTE, 10);
        Date date2 = cal.getTime(); // Change minutes for the new ride so it does not combine
        Ride r21 = new Ride(21, date2, 324, 586);
        r21.AddPassenger("Passenger 21");
        actual = minHeap.insert(r21); // Insert 21st ride (over the vehicle limit of 20)

        // Assert
        Assertions.assertFalse(actual);
    }

    /**
    * Tests the insert() method by attempting to insert rides beyond the heap capacity.
    * It verifies that inserting rides beyond the capacity of the MinHeap is unsuccessful.
    */
    @Test
    @DisplayName("Test insert(Ride r): Insert rides beyond capacity.")
    public void insertBeyondCapacityTest() {
        // Assign
        MinHeap minHeap = new MinHeap(5);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        boolean actual = true;
        // Insert 5 rides
        for (int i = 1; i < 5; i++) {
            Ride r = new Ride(i, date, 324, 586);
            // Make sure to add 6 passengers to each ride so rides do not combine
            for (int j = 0; j <5; j++){
                r.AddPassenger("Passenger " + j); 
            }
            actual = minHeap.insert(r);
        }

        // Act
        cal.set(Calendar.MINUTE, 10);
        Date date2 = cal.getTime(); // Change minutes for the new ride so it does not combine
        Ride r6 = new Ride(6, date2, 324, 586);
        r6.AddPassenger("Passenger 6");
        actual = minHeap.insert(r6); // Attempt to insert 6th

        // Assert
        Assertions.assertFalse(actual, "6th ride should not be inserted");
    }

    /**
    * Tests the remove() method with a valid ride.
    * It verifies that removing a ride from the MinHeap is successful.
    */
    @Test
    @DisplayName("Test remove(Ride r): Valid ride.")
    public void removeValidRideTest() {
        // Assign
        MinHeap minHeap = new MinHeap(4);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        Ride r1 = new Ride(1, date, 324, 586);
        r1.AddPassenger("Joe Bloggs");
        minHeap.insert(r1);

        // Act
        boolean actual = minHeap.remove(r1);

        // Assert
        Assertions.assertTrue(actual);
    }
 
    /**
     * Tests the remove() method by inserting two rides and removing one.
     * It verifies that removing one ride from the MinHeap containing two rides is successful.
     */
    @Test
    @DisplayName("Test remove(Ride r): Insert two rides, remove one (valid).")
    public void removeAnotherValidRideTest() {
        // Assign
        MinHeap minHeap = new MinHeap(4);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date1 = cal.getTime();

        // Only change minutes so rides do not combine
        cal.set(Calendar.MINUTE, 10);
        Date date2 = cal.getTime();

        Ride r1 = new Ride(1, date1, 324, 586);
        r1.AddPassenger("Joe Bloggs");
        Ride r2 = new Ride(2, date2, 324, 586);
        r2.AddPassenger("Mary Smith");

        minHeap.insert(r1);
        minHeap.insert(r2);

        // Act
        boolean actual = minHeap.remove(r1);

        // Assert
        Assertions.assertTrue(actual);
    }

    /**
    * Tests the remove() method by attempting to remove a ride twice.
    * It verifies that removing a ride that has already been removed from the MinHeap is unsuccessful.
    */
    @Test
    @DisplayName("Test remove(Ride r): Attempt to remove a ride twice")
    public void removeInvalidRideTest() {
        // Assign
        MinHeap minHeap = new MinHeap(4);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        Ride r1 = new Ride(1, date, 324, 586);
        r1.AddPassenger("Joe Bloggs");
        minHeap.insert(r1);


        // Act
        minHeap.remove(r1); // Remove once
        boolean actual = minHeap.remove(r1); // Remove twice

        // Assert
        Assertions.assertFalse(actual);
    }

    /**
    * Tests the remove() method by attempting to remove a ride not in the heap.
    * It verifies that removing a ride that is not present in the MinHeap is unsuccessful.
    */
    @Test
    @DisplayName("Test remove(Ride r): Attempt to remove a ride not in heap")
    public void removeAnotherInvalidRideTest() {
        // Assign
        MinHeap minHeap = new MinHeap(4);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        // Only change seconds
        cal.set(Calendar.SECOND, 10);
        Date date2 = cal.getTime();

        // Create two rides with passengers and different start ids so they do not combine
        Ride r1 = new Ride(1, date, 323, 586);
        r1.AddPassenger("Joe Bloggs");
        Ride r2 = new Ride(2, date2, 324, 586);
        r2.AddPassenger("Mary Smith");

        minHeap.insert(r1); // Insert only r1

        // Act
        boolean actual = minHeap.remove(r2); // Attempt to remove r2

        // Assert
        Assertions.assertFalse(actual);
    }

    /**
    * Tests the isEmpty() method with an empty heap.
    * It verifies that the MinHeap is empty when no rides are inserted.
    */
    @Test
    @DisplayName("Test isEmpty(): Empty heap")
    public void isEmptyEmptyHeapTest() {
        // Assign
        MinHeap minHeap = new MinHeap(4);

        // Act
        boolean actual = minHeap.isEmpty();

        // Assert
        Assertions.assertTrue(actual);
    }

    /**
    * Tests the isEmpty() method with an empty heap after inserting and removing one ride.
    * It verifies that the MinHeap is empty after inserting and then removing a ride.
    */
    @Test
    @DisplayName("Test isEmpty(): Empty heap after inserting and removing once," +
                " dependent on dump(), insert(Ride r) and remove(Ride r)")
    public void isEmptyEmptyHeapAfterInsertAndRemoveTest() {
        // Assign
        MinHeap minHeap = new MinHeap(4);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        // Create one valid ride
        Ride r1 = new Ride(1, date, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        minHeap.insert(r1); // Insert, heap has 1 value
        minHeap.remove(r1); // Remove, heap is now empty

        // Act
        boolean actual = minHeap.isEmpty();

        // Assert
        Assertions.assertTrue(actual);
    }

    /**
    * Tests the isEmpty() method with a non-empty heap.
    * It verifies that the MinHeap is not empty when a ride is inserted.
    */
    @Test
    @DisplayName("Test isEmpty(): Non-Empty heap")
    public void isEmptyNonEmptyHeapTest() {
        // Assign
        MinHeap minHeap = new MinHeap(4);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        // Create one valid ride
        Ride r1 = new Ride(1, date, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        minHeap.insert(r1);

        // Act
        boolean actual = minHeap.isEmpty();

        // Assert
        Assertions.assertFalse(actual);
    }

    /**
    * Tests the isEmpty() method with a non-empty heap after inserting twice and removing once.
    * It verifies that the MinHeap is not empty after inserting two rides and removing one.
    */
    @Test
    @DisplayName("Test isEmpty(): Non-Empty heap after inserting twice and removing once," +
                    " dependent on dump(), insert(Ride r) and remove(Ride r)")
    public void isEmptyNonEmptyHeapAfterInsertAndRemoveTest() {
        // Assign
        MinHeap minHeap = new MinHeap(4);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        cal.set(Calendar.SECOND, 1);
        Date date1 = cal.getTime();

        // Create two valid rides with different start IDs so they do not combine
        Ride r1 = new Ride(1, date, 323, 586);
        r1.AddPassenger("Joe Bloggs");
        Ride r2 = new Ride(2, date1, 324, 586);
        r2.AddPassenger("Charlie Brown");

        // Insert both
        minHeap.insert(r1);
        minHeap.insert(r2);

        minHeap.remove(r1); // Remove r1, heap still has r2 in

        // Act
        boolean actual = minHeap.isEmpty();

        // Assert
        Assertions.assertFalse(actual);
    }

    /**
    * Tests the peek() method with an empty heap.
    * It verifies that peeking into an empty MinHeap returns null.
    */
    @Test
    @DisplayName("Test peek(): Empty heap")
    public void peekEmptyHeapTest() {
        // Assign
        MinHeap minHeap = new MinHeap(4);

        // Act
        Ride actual = minHeap.peek();

        // Assert
        Assertions.assertNull(actual);
    }

    /**
    * Tests the peek() method with an empty heap after inserting and removing one ride.
    * It verifies that peeking into an empty MinHeap after inserting and removing a ride returns null.
    */
    @Test
    @DisplayName("Test peek(): Empty heap after inserting and removing once, " +
                    "dependent on insert(Ride r) and remove(Ride r)")
    public void peekEmptyHeapAfterInsertAndRemoveTest() {
        // Assign
        MinHeap minHeap = new MinHeap(4);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        // Create one valid ride
        Ride r1 = new Ride(1, date, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        minHeap.insert(r1); // Insert
        minHeap.remove(r1); // Remove, heap is now empty
        // Act
        Ride actual = minHeap.peek();

        // Assert
        Assertions.assertEquals(actual,null);
    }

    /**
    * Tests the peek() method with a non-empty heap.
    * It verifies that peeking into a non-empty MinHeap returns the ride with the highest priority.
    */
    @Test
    @DisplayName("Test peek(): Non-Empty heap")
    public void peekNonEmptyHeapTest() {
        // Assign
        MinHeap minHeap = new MinHeap(4);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        // Create one valid ride
        Ride r1 = new Ride(1, date, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        minHeap.insert(r1);

        // Act
        Ride actual = minHeap.peek();

        // Assert
        Assertions.assertEquals(actual,r1);
    }

    /**
    * Tests the peek() method with a non-empty heap after inserting twice and removing once.
    * It verifies that peeking into the MinHeap returns the correct ride after operations.
    */
    @Test
    @DisplayName("Test peek(): Non-Empty heap after inserting twice and removing once, " +
                    "dependent on insert(Ride r) and remove(Ride r)")
    public void peekNonEmptyHeapAfterInsertAndRemoveTest() {
        // Assign
        MinHeap minHeap = new MinHeap(4);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        cal.set(Calendar.SECOND, 1);
        Date date1 = cal.getTime();

        // Create two valid rides with different start IDs so they do not combine
        Ride r1 = new Ride(1, date, 323, 586);
        r1.AddPassenger("Joe Bloggs");
        Ride r2 = new Ride(2, date1, 324, 586);
        r2.AddPassenger("Charlie Brown");

        // Insert both
        minHeap.insert(r1);
        minHeap.insert(r2);

        minHeap.remove(r1); // Remove r1, heap still has r2 in

        // Act
        Ride actual = minHeap.peek();

        // Assert
        Assertions.assertEquals(actual,r2);
    }

    /**
    * Tests the heapify() method with an empty heap.
    * It verifies that heapifying an empty array of rides results in an empty MinHeap.
    */
    @Test
    @DisplayName("Test heapify(): Empty heap, dependent on dump()")
    public void heapifyEmptyHeapTest() {
        // Assign
        MinHeap minHeap = new MinHeap(4);
        Ride[] rides = new Ride[0];

        // Act
        minHeap.heapify(rides, rides.length);
        minHeap.dump();

        // Assert
        String actual = outputStreamCaptor.toString().trim().replaceAll("\\r\\n", "\n"); // Capture the output and get rid of hidden discrepancies 
        String expected = 
        "0: null";

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    /**
    * Tests the heapify() method with an empty heap after removing the only item.
    * It verifies that heapifying an array with one ride and then removing it results in an empty MinHeap.
    */
    @Test
    @DisplayName("Test heapify(): Empty heap after removing only item from heap" +
                    " dependent on dump() and remove(Ride r)")
    public void heapifyEmptyHeapAfterInsertAndRemoveTest() {
        // Assign

        // Assign Dates 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date1 = cal.getTime();

        // Creating valid Ride objects with different timestamps and passengers
        Ride r1 = new Ride(1, date1, 324, 586);
        r1.AddPassenger("Joe Bloggs");


        MinHeap minHeap = new MinHeap(4);
        Ride[] rides = new Ride[]{r1}; // Insert in non-minheap order

        
        // Act
        minHeap.heapify(rides, rides.length); 
        minHeap.remove(r1); // Remove r1 from heap, heap is now empty
        minHeap.dump();

        // Assert
        String actual = outputStreamCaptor.toString().trim().replaceAll("\\r\\n", "\n"); // Capture the output and get rid of hidden discrepancies 
        String expected = 
        "0: null\n" +
        "1: null";

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    /**
    * Tests the heapify() method by passing a number greater than 20 as rideNum.
    * It verifies that heapifying with a rideNum greater than the maximum allowed does not change the MinHeap.
    */
    @Test
    @DisplayName("Test heapify(): testing passing in a number greater than 20 as rideNum, dependent on dump()")
    public void heapifyInvalidRideNumTest() {
        // Assign

        // Assign Dates 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date1 = cal.getTime();


        // Creating a valid Ride object 
        Ride r1 = new Ride(1, date1, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        // Assign
        MinHeap minHeap = new MinHeap(4);
        Ride[] rides = new Ride[]{r1}; // Insert in non-minheap order

        // Act
        minHeap.heapify(rides, 21); // Should not change minHeap at all
        minHeap.dump();

        // Assert
        String actual = outputStreamCaptor.toString().trim().replaceAll("\\r\\n", "\n"); // Capture the output and get rid of hidden discrepancies 
        String expected = 
        "0: null\n" +
        "1: null\n" +
        "2: null\n" +
        "3: null";

        // Assert
        Assertions.assertEquals(actual, expected);
        
    }

    /**
    * Tests the heapify() method with an empty heap after inserting once.
    * It verifies that heapifying an empty array of rides and then inserting a ride results in an empty MinHeap.
    */
    @Test
    @DisplayName("Test heapify(): Empty heap, dependent on dump(), after heapify and " +
                    " inserting once to an empty heap")
    public void heapifyEmptyHeapAfterInsertTest() {
        // Assign

        // Assign Dates 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date1 = cal.getTime();


        // Creating a valid Ride object 
        
        Ride r1 = new Ride(1, date1, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        // Assign
        MinHeap minHeap = new MinHeap(4);
        Ride[] rides = new Ride[0]; // Insert in non-minheap order

        // Act
        minHeap.heapify(rides, rides.length);
        minHeap.insert(r1); // Should not add anything because array generated from heapify is not dynamic 
        minHeap.dump(); 

        // Assert
        String actual = outputStreamCaptor.toString().trim().replaceAll("\\r\\n", "\n"); // Capture the output and get rid of hidden discrepancies 
        String expected = 
        "0: null";

        // Assert
        Assertions.assertEquals(expected, actual);
        
    }

    /**
    * Tests the heapify() method with a non-empty heap.
    * It verifies that heapifying an array of rides results in a MinHeap with the correct order.
    */
    @Test
    @DisplayName("Test heapify(): Non-Empty heap, dependent on dump()")
    public void heapifyNonEmptyHeapTest() {
        // Assign

        // Assign Dates 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date1 = cal.getTime();

        // Only change the seconds
        cal.set(Calendar.SECOND, 1);
        Date date2 = cal.getTime();

        // Only change the seconds
        cal.set(Calendar.SECOND, 2);
        Date date3 = cal.getTime();

        // Only change the seconds
        cal.set(Calendar.SECOND, 3);
        Date date4 = cal.getTime();

        // Creating valid Ride objects with different timestamps, passengers and Start IDs so they do not combine
        // r1 is one second earlier than r2 and r2 is one second earlier r3, and so on
        Ride r1 = new Ride(1, date1, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        Ride r2 = new Ride(2, date2, 350, 520);
        r2.AddPassenger("Mary Smith");

        Ride r3 = new Ride(3, date3, 323, 583);
        r3.AddPassenger("Charlie Brown");

        Ride r4 = new Ride(4, date4, 352, 525);
        r4.AddPassenger("Elle Brown");


        MinHeap minHeap = new MinHeap(4);
        Ride[] rides = new Ride[]{r4,r1,r3,r2}; // Insert in non-minheap order

        
        // Act
        minHeap.heapify(rides, rides.length);
        minHeap.dump();

        // Assert
        String actual = outputStreamCaptor.toString().trim().replaceAll("\\r\\n", "\n"); // Capture the output and get rid of hidden discrepancies 
        String expected = 
        "0: null\n" +
        "--- Ride 001 -------\n" +
        "Time: 15:30:00\n" +
        "Start ID: 324\n" +
        "End ID: 586\n" +
        "Passengers:\n" +
        "Joe Bloggs\n" +
        "--------------------\n" +
        "--- Ride 002 -------\n" +
        "Time: 15:30:01\n" +
        "Start ID: 350\n" +
        "End ID: 520\n" +
        "Passengers:\n" +
        "Mary Smith\n" +
        "--------------------\n" +
        "--- Ride 003 -------\n" +
        "Time: 15:30:02\n" +
        "Start ID: 323\n" +
        "End ID: 583\n" +
        "Passengers:\n" +
        "Charlie Brown\n" +
        "--------------------\n" +
        "--- Ride 004 -------\n" +
        "Time: 15:30:03\n" +
        "Start ID: 352\n" +
        "End ID: 525\n" +
        "Passengers:\n" +
        "Elle Brown\n" +
        "--------------------";

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    /**
    * Tests the heapify() method with a non-empty heap after removing the minimum value.
    * It verifies that heapifying an array of rides and then removing the minimum ride maintains the correct order in the MinHeap.
    */
    @Test
    @DisplayName("Test heapify(): Non-Empty heap, after removing min value, dependent on dump() and remove(Ride r)")
    public void heapifyNonEmptyHeapAfterInsertAndRemoveTest() {
        // Assign

        // Assign Dates 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date1 = cal.getTime();

        // Only change the seconds
        cal.set(Calendar.SECOND, 1);
        Date date2 = cal.getTime();

        // Only change the seconds
        cal.set(Calendar.SECOND, 2);
        Date date3 = cal.getTime();

        // Only change the seconds
        cal.set(Calendar.SECOND, 3);
        Date date4 = cal.getTime();

        // Creating valid Ride objects with different timestamps, passengers and Start IDs so they do not combine
        // r1 is one second earlier than r2 and r2 is one second earlier r3, and so on
        Ride r1 = new Ride(1, date1, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        Ride r2 = new Ride(2, date2, 350, 520);
        r2.AddPassenger("Mary Smith");

        Ride r3 = new Ride(3, date3, 323, 583);
        r3.AddPassenger("Charlie Brown");

        Ride r4 = new Ride(4, date4, 352, 525);
        r4.AddPassenger("Elle Brown");


        MinHeap minHeap = new MinHeap(4);
        Ride[] rides = new Ride[]{r4,r1,r3,r2}; // Insert in non-minheap order

        
        // Act
        minHeap.heapify(rides, rides.length);
        minHeap.remove(r1);
        minHeap.dump();

        // Assert
        String actual = outputStreamCaptor.toString().trim().replaceAll("\\r\\n", "\n"); // Capture the output and get rid of hidden discrepancies 
        String expected = 
        "0: null\n" +
        "--- Ride 002 -------\n" +
        "Time: 15:30:01\n" +
        "Start ID: 350\n" +
        "End ID: 520\n" +
        "Passengers:\n" +
        "Mary Smith\n" +
        "--------------------\n" +
        "--- Ride 004 -------\n" +
        "Time: 15:30:03\n" +
        "Start ID: 352\n" +
        "End ID: 525\n" +
        "Passengers:\n" +
        "Elle Brown\n" +
        "--------------------\n" +
        "--- Ride 003 -------\n" +
        "Time: 15:30:02\n" +
        "Start ID: 323\n" +
        "End ID: 583\n" +
        "Passengers:\n" +
        "Charlie Brown\n" +
        "--------------------\n"+
        "4: null";

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    /**
    * Tests the dump() method with an empty heap.
    * It verifies that dumping an empty MinHeap produces the expected output.
    */
    @Test
    @DisplayName("Test Dump():Empty heap")
    public void dumpEmptyHeapTest() {
        // Assign
        MinHeap minHeap = new MinHeap(5);

        // Act
        minHeap.dump();

        // Assert
        String actual = outputStreamCaptor.toString().trim().replaceAll("\\r\\n", "\n"); // Capture the output and get rid of hidden discrepancies 
        String expected = 
        "0: null\n" +
        "1: null\n" +
        "2: null\n" +
        "3: null\n" +
        "4: null";

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    /**
    * Tests the dump() method with an empty heap after inserting and removing one ride.
    * It verifies that dumping the MinHeap after these operations produces the expected output.
    */
    @Test
    @DisplayName("Test Dump(): Empty heap, after inserting and removing once dependent on" +
                    "insert(ride r) and remove (ride r)")
    public void dumpEmptyHeapAfterInsertAndRemoveTest() {
        // Assign
        
        // Assign Dates 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date1 = cal.getTime();


        // Creating valid a Ride object
        Ride r1 = new Ride(1, date1, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        // Create a heap with enough space and insert values in non-minheap order
        MinHeap minHeap = new MinHeap(5);
        minHeap.insert(r1);
        // Act
        minHeap.dump();

        // Assert
        String actual = outputStreamCaptor.toString().trim().replaceAll("\\r\\n", "\n"); // Capture the output and get rid of hidden discrepancies 
        String expected = 
        "0: null\n" +
        "--- Ride 001 -------\n" +
        "Time: 15:30:00\n" +
        "Start ID: 324\n" +
        "End ID: 586\n" +
        "Passengers:\n" +
        "Joe Bloggs\n" +
        "--------------------\n" +
        "2: null\n" +
        "3: null\n" +
        "4: null";
        

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    /**
    * Tests the dump() method with a non-empty heap.
    * It verifies that dumping the MinHeap produces the expected output.
    */
    @Test
    @DisplayName("Test Dump(): Non-Empty heap, dependent on insert(Ride r)")
    public void dumpNonHeapEmptyTest() {
    
        // Assign
        
        // Assign Dates 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date1 = cal.getTime();


        // Creating valid a Ride object
        Ride r1 = new Ride(1, date1, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        // Create a heap with enough space and insert values in non-minheap order
        MinHeap minHeap = new MinHeap(5);
        minHeap.insert(r1);
        // Act
        minHeap.dump();

        // Assert
        String actual = outputStreamCaptor.toString().trim().replaceAll("\\r\\n", "\n"); // Capture the output and get rid of hidden discrepancies 
        String expected = 
        "0: null\n" +
        "--- Ride 001 -------\n" +
        "Time: 15:30:00\n" +
        "Start ID: 324\n" +
        "End ID: 586\n" +
        "Passengers:\n" +
        "Joe Bloggs\n" +
        "--------------------\n" +
        "2: null\n" +
        "3: null\n" +
        "4: null";
        

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    /**
    * Tests the dump() method with a non-empty heap after inserting twice and removing once.
    * It verifies that dumping the MinHeap after these operations produces the expected output.
    */
    @Test
    @DisplayName("Test Dump(): Non-Empty heap, after inserting twice and removing once dependent on" +
                    "insert(ride r) and remove (ride r)")
    public void dumpNonEmptyHeapAfterInsertAndRemoveTest() {
        // Assign
        
        // Assign Dates 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date1 = cal.getTime();

        // Only change the seconds
        cal.set(Calendar.SECOND, 1);
        Date date2 = cal.getTime();

        // Creating valid Ride objects with different timestamps, passengers and Start IDs so they do not combine
        // r1 is one second earlier than r2
        Ride r1 = new Ride(1, date1, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        Ride r2 = new Ride(2, date2, 350, 520);
        r2.AddPassenger("Mary Smith");


        // Create a heap with enough space and insert values in non-minheap order
        MinHeap minHeap = new MinHeap(5);
        minHeap.insert(r2);
        minHeap.insert(r1);
        
        // Act
        minHeap.dump();

        // Assert
        String actual = outputStreamCaptor.toString().trim().replaceAll("\\r\\n", "\n"); // Capture the output and get rid of hidden discrepancies 
        String expected = 
        "0: null\n" +
        "--- Ride 001 -------\n" +
        "Time: 15:30:00\n" +
        "Start ID: 324\n" +
        "End ID: 586\n" +
        "Passengers:\n" +
        "Joe Bloggs\n" +
        "--------------------\n" +
        "--- Ride 002 -------\n" +
        "Time: 15:30:01\n" +
        "Start ID: 350\n" +
        "End ID: 520\n" +
        "Passengers:\n" +
        "Mary Smith\n" +
        "--------------------\n" +
        "3: null\n" +
        "4: null";
        
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    /**
    * Tests the sort() method with an empty heap.
    * It verifies that sorting an empty MinHeap returns an empty array.
    */
    @Test
    @DisplayName("Test sort(): Empty heap")
    public void sortEmptyHeapTest() {
        // Assign
        MinHeap minHeap = new MinHeap(5);
        
        // Act
        Ride[] actual = minHeap.sort();
        Ride[] expected = new Ride[]{};

        // Assert
        Assertions.assertArrayEquals(expected, actual);
    }

    /**
    * Tests the sort() method with an empty heap after inserting and removing one ride.
    * It verifies that sorting an empty MinHeap after these operations returns an empty array.
    */
    @Test
    @DisplayName("Test sort(): Empty heap, after inserting and removing once" + 
                    " dependent on insert(ride r), remove(ride r)")
    public void sortEmptyHeapAfterInsertAndRemoveTest() {
        // Assign

        // Assign Dates 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date1 = cal.getTime();


        // Creating valid Ride objects with different timestamps and passengers
        // r1 is one second earlier than r2 and r2 is one second earlier r3, and so on
        Ride r1 = new Ride(1, date1, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        MinHeap minHeap = new MinHeap(5);

        minHeap.insert(r1);
        minHeap.remove(r1);
        
        // Act
        Ride[] actual = minHeap.sort();
        Ride[] expected = new Ride[]{};

        // Assert
        Assertions.assertArrayEquals(expected, actual);
    }

    /**
    * Tests the sort() method with a non-empty heap containing one ride.
    * It verifies that sorting the MinHeap returns an array with the single ride.
    */
    @Test
    @DisplayName("Test sort(): Non-Empty heap, one value")
    public void sortNonEmptyHeapTest() {
        // Assign

        // Assign Dates 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date1 = cal.getTime();


        // Creating valid Ride objects with different timestamps and passengers
        // r1 is one second earlier than r2 and r2 is one second earlier r3, and so on
        Ride r1 = new Ride(1, date1, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        MinHeap minHeap = new MinHeap(5);

        minHeap.insert(r1);
        
        // Act
        Ride[] actual = minHeap.sort();
        Ride[] expected = new Ride[]{r1};

        // Assert
        Assertions.assertArrayEquals(expected, actual);
    }

    /**
    * Tests the sort() method with a non-empty heap after inserting multiple rides.
    * It verifies that sorting the MinHeap returns an array with the rides in the correct order.
    */
    @Test
    @DisplayName("Test sort(): Non-Empty heap, after inserting multiple values")
    public void sortNonEmptyHeapMultValuesTest() {
        // Assign

        // Assign Dates 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date1 = cal.getTime();

        // Only change the seconds
        cal.set(Calendar.SECOND, 1);
        Date date2 = cal.getTime();

        // Only change the seconds
        cal.set(Calendar.SECOND, 2);
        Date date3 = cal.getTime();

        // Only change the seconds
        cal.set(Calendar.SECOND, 3);
        Date date4 = cal.getTime();

        // Only change the seconds
        cal.set(Calendar.SECOND, 4);
        Date date5 = cal.getTime();

        // Creating valid Ride objects with different timestamps, passengers and Start IDs so they do not combine
        // r1 is one second earlier than r2 and r2 is one second earlier r3, and so on
        Ride r1 = new Ride(1, date1, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        Ride r2 = new Ride(2, date2, 350, 520);
        r2.AddPassenger("Mary Smith");

        Ride r3 = new Ride(3, date3, 323, 583);
        r3.AddPassenger("Charlie Brown");

        Ride r4 = new Ride(4, date4, 352, 525);
        r4.AddPassenger("Elle Brown");

        Ride r5 = new Ride(5, date5, 353, 522);
        r5.AddPassenger("Lucas Oda");

        MinHeap minHeap = new MinHeap(6);

        minHeap.insert(r4);
        minHeap.insert(r2);
        minHeap.insert(r5);
        minHeap.insert(r3);
        minHeap.insert(r1); // Insert 5 rides

        // Act
        Ride[] actual = minHeap.sort();
        Ride[] expected = new Ride[]{r1,r2,r3,r4,r5};

        // Assert
        Assertions.assertArrayEquals(expected, actual);
    }

    /**
    * Tests the sort() method with a non-empty heap after inserting multiple rides and removing the minimum value.
    * It verifies that sorting the MinHeap returns an array with the remaining rides in the correct order.
    */
    @Test
    @DisplayName("Test sort(): Non-Empty heap, after inserting multiple times and removing min value")
    public void sortNonEmptyHeapMultValuesAndRemoveTest() {
        // Assign

        // Assign Dates 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date1 = cal.getTime();

        // Only change the seconds
        cal.set(Calendar.SECOND, 1);
        Date date2 = cal.getTime();

        // Only change the seconds
        cal.set(Calendar.SECOND, 2);
        Date date3 = cal.getTime();

        // Only change the seconds
        cal.set(Calendar.SECOND, 3);
        Date date4 = cal.getTime();

        // Only change the seconds
        cal.set(Calendar.SECOND, 4);
        Date date5 = cal.getTime();

        // Creating valid Ride objects with different timestamps, passengers and Start IDs so they do not combine
        // r1 is one second earlier than r2 and r2 is one second earlier r3, and so on
        Ride r1 = new Ride(1, date1, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        Ride r2 = new Ride(2, date2, 350, 520);
        r2.AddPassenger("Mary Smith");

        Ride r3 = new Ride(3, date3, 323, 583);
        r3.AddPassenger("Charlie Brown");

        Ride r4 = new Ride(4, date4, 352, 525);
        r4.AddPassenger("Elle Brown");

        Ride r5 = new Ride(5, date5, 353, 522);
        r5.AddPassenger("Lucas Oda");


        MinHeap minHeap = new MinHeap(6);

        minHeap.insert(r4);
        minHeap.insert(r2);
        minHeap.insert(r5);
        minHeap.insert(r3);
        minHeap.insert(r1); // Insert 5 rides
        
        minHeap.remove(r1); // Remove 1

        // Act
        Ride[] actual = minHeap.sort();
        Ride[] expected = new Ride[]{r2,r3,r4,r5};

        // Assert
        Assertions.assertArrayEquals(expected, actual);
    }

    /**
    * Tests the insert() method for combining trips within a 10-minute gap.
    * It verifies that inserting two rides with start times within 10 minutes of each other
    * results in the rides being combined in the MinHeap.
    */
    @Test
    @DisplayName("Test combine trips(ride r1, ride r2): Non-empty heap, two trips within 10mins gap")
    public void insertNonEmptyHeapCombineRidesTest() {
        // Assign

        // Assign Dates 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date1 = cal.getTime();

        // Only change the minutes
        cal.set(Calendar.MINUTE, 31);
        Date date2 = cal.getTime();

        // Creating valid Ride objects with different timestamps, passengers and Start IDs so they do not combine
        // r1 is one minute earlier than r2
        Ride r1 = new Ride(1, date1, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        Ride r2 = new Ride(2, date2, 324, 586);
        r2.AddPassenger("Mary Smith");

        MinHeap minHeap = new MinHeap(5);

        // Act
        
        minHeap.insert(r1); // Insert 5 rides
        minHeap.insert(r2);
        minHeap.dump();

        
        String actual = outputStreamCaptor.toString().trim().replaceAll("\\r\\n", "\n"); // Capture the output and get rid of hidden discrepancies 
        String expected = 
        "0: null\n" +
        "--- Ride 001 -------\n" +
        "Time: 15:30:00\n" +
        "Start ID: 324\n" +
        "End ID: 586\n" +
        "Passengers:\n" +
        "Joe Bloggs\n" +
        "Mary Smith\n" +
        "--------------------\n" +
        "2: null\n" +
        "3: null\n" +
        "4: null";

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    /**
    * Tests the insert() method for combining multiple trips.
    * It verifies that inserting three rides with start times within a few minutes of each other
    * results in the rides being combined in the MinHeap.
    */
    @Test
    @DisplayName("Test combine trips(ride r1, ride r2): Non-empty heap, three trips")
    public void insertNonEmptyHeapCombineMoreRidesTest() {
        // Assign

        // Assign Dates 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date1 = cal.getTime();

        // Only change the minutes
        cal.set(Calendar.MINUTE, 31);
        Date date2 = cal.getTime();

        // Only change the minutes
        cal.set(Calendar.MINUTE, 32);
        Date date3 = cal.getTime();


        // Creating valid Ride objects with different timestamps and passengers
        // r1 is one minute earlier than r2
        Ride r1 = new Ride(1, date1, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        Ride r2 = new Ride(2, date2, 324, 586);
        r2.AddPassenger("Mary Smith");

        Ride r3 = new Ride(3, date3, 324, 586);
        r3.AddPassenger("Charlie Brown");

        MinHeap minHeap = new MinHeap(5);

        // Act
        minHeap.insert(r1); // Insert 5 rides
        minHeap.insert(r2);
        minHeap.insert(r3);

        //minHeap.checkForCombine(r1,r2);
        minHeap.dump();

        
        String actual = outputStreamCaptor.toString().trim().replaceAll("\\r\\n", "\n"); // Capture the output and get rid of hidden discrepancies 
        String expected = 
        "0: null\n" +
        "--- Ride 001 -------\n" +
        "Time: 15:30:00\n" +
        "Start ID: 324\n" +
        "End ID: 586\n" +
        "Passengers:\n" +
        "Joe Bloggs\n" +
        "Mary Smith\n" +
        "Charlie Brown\n" +
        "--------------------\n" +
        "2: null\n" +
        "3: null\n" +
        "4: null";

        // Assert
        Assertions.assertEquals(expected, actual);
    }
}
