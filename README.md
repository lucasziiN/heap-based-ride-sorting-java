# Ride Scheduler Using Replaceable Min Heap – COMPX201 Assignment 4

This Java program simulates an OnDemand ride-sharing scheduler using a **replaceable minimum binary heap** to prioritize ride requests by timestamp. It supports insertions, deletions, sorting, and ride optimizations — complete with a thorough **JUnit test suite**.

Developed for COMPX201 – Data Structures & Algorithms at the University of Waikato (2024, May).

---

## 🚖 Overview

This simulation models a rideshare dispatching system (like BayBus OnDemand or UberX Share). The dispatcher has:

- ⏱️ Timestamp-based priority (earlier rides first)
- 🚗 A 20-ride limit in the heap
- 👥 Up to 6 passengers per ride
- 🔁 Heap replacement and sorting
- 🧠 Optimization to merge overlapping rides with identical routes

---

## 🧱 Class Overview

### `Ride.java`
Defines a ride with:
- Ride ID (`int`)
- Timestamp (`Date`)
- Start and end location IDs (`int`)
- Passenger list (`String[]`)
- Implements `Comparable` for min-heap behavior
- Overrides `toString()` to display ride details

### `MinHeap.java`
A custom dynamic min heap storing `Ride` objects.

#### Public Methods:
- `insert(Ride r)`
- `remove(Ride r)`
- `isEmpty()`
- `peek()`
- `heapify(Ride[] rides, int rideNum)`
- `dump()`
- `sort() → Ride[]`

#### Private Helpers:
- `upheap()`
- `downheap()`

### `RideOptimizer.java` *(Optional - Part 3)*
- Merges compatible rides (same route, within 10 mins)
- Handles ride capacity constraints

---

## 🧪 Testing with JUnit

A full JUnit suite verifies:
- `Ride.compareTo()` – 6 tests
- `Ride.toString()` – 2 tests
- Heap insertion – 8 tests
- Heap removal – 4 tests
- `isEmpty()`, `peek()`, `dump()`, `heapify()`, `sort()` – 20+ tests
- Ride optimization logic – multiple tests for time-range merges and passenger limits

### Example:
```java
@Test
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
```

--- 

## 📦 File Structure
```plaintext
ride-scheduler-heap/
├── Ride.java
├── MinHeap.java
├── Main.java
├── MinHeapTest.java
└── README.md
```

--- 

## 🧠 Key Concepts
- Min Heap: Array-based binary heap with replace capability
- Heap Sort: In-place sort based on ride timestamps
- Comparable: Prioritizing rides via natural ordering
- Test-Driven Development: Edge and functional coverage using JUnit
- Optimization: Merge rides with shared start/end points & temporal proximity

--- 

## 🏁 How to Compile & Run

javac *.java
java Main.java            

# Run tests
javac -cp junit-platform-console-standalone-1.8.2.jar -d out *.java
java -jar junit-platform-console-standalone-1.8.2.jar -cp out --scan-classpath

---

## 👨‍🎓 Author
Lucas Oda
University of Waikato
COMPX201 – Assignment 4
Data Structures & Algorithms (2024)


## 📜 License
For educational and academic use only.
