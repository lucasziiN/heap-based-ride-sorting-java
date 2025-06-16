import java.util.Calendar;
import java.util.Date;

public class Main {
    
    public static void main(String[] args){

        // Assign
        MinHeap minHeap = new MinHeap(4);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();

        // Only change the seconds
        cal.set(Calendar.SECOND, 10);
        Date date2 = cal.getTime();

        // Only change the seconds
        cal.set(Calendar.SECOND, 20);
        Date date3 = cal.getTime();

        Ride r1 = new Ride(1, date, 324, 586);
        r1.AddPassenger("Joe Bloggs");

        Ride r2 = new Ride(2, date2, 324, 586);
        r2.AddPassenger("Mary Smith");

        Ride r3 = new Ride(3, date3, 324, 586);
        r3.AddPassenger("Charlie Brown");

        // Act
        minHeap.insert(r1);
        minHeap.insert(r2);
        minHeap.insert(r3);

        Ride[] actual = minHeap.sort();

        System.out.println(actual);

        //MinHeap minHeap = new MinHeap(11);
        //minHeap.print();
        //System.out.println();
        //System.out.println("heap is empty: " + minHeap.isEmpty());
//
//
//
        //
        //// Creating Calendar instances to set specific dates
        //Calendar cal10 = Calendar.getInstance();
        //cal10.set(2023, Calendar.JANUARY, 1, 15, 30); // January 1, 2023, 15:30
        //Date date10 = cal10.getTime();
//
        //Calendar cal20 = Calendar.getInstance();
        //cal20.set(2023, Calendar.JANUARY, 1, 15, 34); // January 1, 2023, 15:34
        //Date date20 = cal20.getTime();
//
        //// Creating Ride objects with different timestamps and passengers
        //Ride r1 = new Ride(1, date10, 324, 586);
        //r1.AddPassenger("Joe Bloggs");
        //r1.AddPassenger("Mary Smith");
        //r1.AddPassenger("Charlie Brown");
//
        //Ride r2 = new Ride(2, date20, 324, 586);
        //r2.AddPassenger("Elle Brown");
//
        //
        //// Checking for combination
        //r1.checkForCombine(r1, r2);
//
        //// Print combined ride
        //System.out.println(r1);
//
        //System.out.println("Dumping");
        //minHeap.dump();
//
//
//
//
        //// Creating Calendar instances to set specific dates
        //Calendar cal1 = Calendar.getInstance();
        //cal1.set(2023, Calendar.JANUARY, 1, 10, 0); // January 1, 2023, 10:00 AM
        //Date date1 = cal1.getTime();
//
        //Calendar cal2 = Calendar.getInstance();
        //cal2.set(2023, Calendar.FEBRUARY, 1, 10, 0); // February 1, 2023, 10:00 AM
        //Date date2 = cal2.getTime();
//
        //Calendar cal3 = Calendar.getInstance();
        //cal3.set(2023, Calendar.MARCH, 1, 10, 0); // March 1, 2023, 10:00 AM
        //Date date3 = cal3.getTime();
//
        //Calendar cal4 = Calendar.getInstance();
        //cal4.set(2023, Calendar.APRIL, 1, 10, 0); // April 1, 2023, 10:00 AM
        //Date date4 = cal4.getTime();
//
        //Calendar cal5 = Calendar.getInstance();
        //cal5.set(2023, Calendar.MAY, 1, 10, 0); // May 1, 2023, 10:00 AM
        //Date date5 = cal5.getTime();
//
        //Calendar cal6 = Calendar.getInstance();
        //cal6.set(2023, Calendar.JUNE, 1, 10, 0); // June 1, 2023, 10:00 AM
        //Date date6 = cal6.getTime();
//
        //Calendar cal7 = Calendar.getInstance();
        //cal7.set(2023, Calendar.JULY, 1, 10, 0); // July 1, 2023, 10:00 AM
        //Date date7 = cal7.getTime();
//
        //Calendar cal8 = Calendar.getInstance();
        //cal8.set(2023, Calendar.AUGUST, 1, 10, 0); // August 1, 2023, 10:00 AM
        //Date date8 = cal8.getTime();
//
        //Calendar cal9 = Calendar.getInstance();
        //cal9.set(2023, Calendar.SEPTEMBER, 1, 10, 0); // September 1, 2023, 10:00 AM
        //Date date9 = cal9.getTime();
//
        ////Calendar cal10 = Calendar.getInstance();
        ////cal10.set(2023, Calendar.OCTOBER, 1, 10, 0); // October 1, 2023, 10:00 AM
        ////Date date10 = cal10.getTime();
//
        //// Creating Ride objects with different timestamps
        ////Ride r1 = new Ride(1, date1, 324, 586);
        //r1.AddPassenger("Joe Bloggs");
        //r1.AddPassenger("Mary Smith");
        ////r1.AddPassenger("Charlie Brown");
        //System.out.println(r1.toString());
//
        ////Ride r2 = new Ride(2, date2, 1, 1);
        //Ride r3 = new Ride(3, date3, 2, 2);
        //Ride r4 = new Ride(4, date4, 3, 3);
        //Ride r5 = new Ride(5, date5, 4, 4);
        //Ride r6 = new Ride(6, date6, 5, 5);
        //Ride r7 = new Ride(7, date7, 6, 6);
        //Ride r8 = new Ride(8, date8, 7, 7);
        //Ride r9 = new Ride(9, date9, 8, 8);
        //
//
        //// Print the Ride objects to verify
        //System.out.println(r1.timeStamp);
        //System.out.println(r2.timeStamp);
        //System.out.println(r3.timeStamp);
        //System.out.println(r4.timeStamp);
        //System.out.println(r5.timeStamp);
        //System.out.println(r6.timeStamp);
        //System.out.println(r7.timeStamp);
        //System.out.println(r8.timeStamp);
        //System.out.println(r9.timeStamp);
        //
        //
        //
        ////minHeap.insert();
        //minHeap.insert(r1);
        //minHeap.insert(r2);
        //minHeap.insert(r4);
        //minHeap.insert(r5);
        //minHeap.insert(r3);
        ////minHeap.insert(r6);
        ////minHeap.insert(r7);
        ////minHeap.insert(r8);
        ////minHeap.insert(r9);
//
//
        //System.out.println();
//
        //System.out.println("Dumping");
        //minHeap.dump();
//
        //System.out.println("Before heapify");
        //minHeap.print();
        //System.out.println();
        //System.out.println("heap is empty: " + minHeap.isEmpty());
        //
        ////System.out.println("removing jan");
        ////minHeap.remove(r1);
        ////minHeap.print();
        ////System.out.println("heap is empty: " + minHeap.isEmpty());
        ////System.out.println();
        //
        //System.out.println("removing may");
        //minHeap.remove(r5);
        //minHeap.print();
        //System.out.println("heap is empty: " + minHeap.isEmpty());
        //System.out.println();
//
        //
        //Ride[] rideArray = new Ride[]{r1,r2,r4,r5,r3,r6,r8,r3,r7};
//
//
        //System.out.println("Heapifying: ");
        //minHeap.heapify(rideArray, 9);
        //minHeap.print();
        //System.out.println();
        //System.out.println("heap is empty: " + minHeap.isEmpty());
//
        ////System.out.println("removing jan");
        ////minHeap.remove(r1);
        ////minHeap.print();
        ////System.out.println("heap is empty: " + minHeap.isEmpty());
        ////System.out.println();
        //
        ////System.out.println("removing may");
        ////minHeap.remove(r5);
        ////minHeap.print();
        ////System.out.println("heap is empty: " + minHeap.isEmpty());
        ////System.out.println();
//
        //System.out.println();
        //System.out.println("Before Sort:");
        //minHeap.dump();
        //System.out.println();
//
        //System.out.println("After Sort:");
        //Ride[] ridess = minHeap.sort();
        //for (int i = 0; i<ridess.length;i++){
        //    System.out.println(ridess[i].toString());
        //}
        //
        ////System.out.println("removing feb");
        ////minHeap.remove(r2);
        ////minHeap.print();
        ////System.out.println();
////
        ////System.out.println("adding sep");
        ////minHeap.insert(r9);
        ////minHeap.print();
        ////System.out.println();
        ////
        ////System.out.println("adding feb");
        ////minHeap.insert(r2);
        ////minHeap.print();
        ////System.out.println();
        ////
        ////System.out.println("adding may");
        ////minHeap.insert(r5);
        ////minHeap.print();
        ////System.out.println();
////
        ////System.out.println("adding jan");
        ////minHeap.insert(r1);
        ////minHeap.print();
        ////System.out.println();
////
        ////System.out.println("removing feb");
        ////minHeap.remove(r2);
        ////minHeap.print();
        ////System.out.println();

        
    }
    
}
