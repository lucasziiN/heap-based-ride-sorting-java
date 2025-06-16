
/**
 * A MinHeap class for managing ride objects.
 * It provides methods for inserting, removing, and managing rides in a heap structure.
 */
public class MinHeap{
    Ride[] heapArray;  // Array to store the heap elements
    int next;          // Index for the next insertion
    
    /**
     * Constructor for creating a MinHeap with a specified capacity.
     * Ensures the capacity does not exceed 20.
     *
     * @param capacity the maximum number of rides the heap can hold
     */
    public MinHeap(int capacity) {
        if (capacity > 20){
            capacity = 20; // Limit capacity to 20
        }
        heapArray = new Ride[capacity];
        next = 1; // Start with the first element at index 1
    }
    
    /**
    * Prints the current state of the heap.
    * For each position in the heap array, it prints the index and the timestamp of the ride, if present.
    */
    public void print(){
        for (int i=0; i <heapArray.length; i++){
            if (heapArray[i] != null) {
                System.out.println(i + ": " + heapArray[i].timeStamp);
            } else {
                System.out.println(i + ": null");
            }
        }
    } 

    /**
    * Inserts a ride into the MinHeap.
    * The ride is inserted only if there is no ride with the same ride ID, the heap is not full, and the ride has passengers.
    * If a ride with the same start and end IDs and a start time within 10 minutes exists in the heap, and there is enough capacity,
    * the passengers are combined with the existing ride.
    *
    * Time Complexity: O(n) - The method may iterate over the heapArray up to the number of elements in the heap
    * to check for duplicates and combine rides.
    * Memory Complexity: O(1) - No additional memory is used other than for a few variables. The heapArray size remains constant.
    *
    * @param r the ride to be inserted
    * @return true if the ride was successfully inserted or combined, false otherwise
    */
    public boolean insert(Ride r){
        // Check if there is already a ride with the same rideId
        for (int i = 1; i < next; i++) {
            if (heapArray[i].rideId == r.rideId) {
                return false;
            }
        }

        // Check if heap is full
        if (next >= heapArray.length) {
            return false;
        }
        
        // Check if ride has passengers
        if (r.passengerCount == 0){
            return false;
        }
        
        // Check for possible ride combinations
        for (int i = 0; i < next; i++){
            if (heapArray[i] != null && checkForCombine(heapArray[i], r)){
                for (int j = 0; j <r.passengerCount; j++){
                    heapArray[i].passengers[heapArray[i].passengerCount] = r.passengers[j];
                    heapArray[i].passengerCount++;
                }
                return true;
            }
        }
        
        // Add ride and upheap
        heapArray[next] = r;
        upHeap(next);
        next ++;
        return true;
    }

    /**
    * Checks if two rides can be combined.
    * The rides can be combined if they have the same start and end IDs, their start times are within 10 minutes of each other,
    * and the total number of passengers does not exceed the capacity of the ride.
    *
    * Time Complexity: O(1) - The operations within this method do not involve iteration, they are simply
    * constant time checks and arithmetic operations.
    * Memory Complexity: O(1) - No additional memory is used other than a few variables for calculations.
    *
    * @param ride1 the first ride
    * @param ride2 the second ride
    * @return true if the rides can be combined, false otherwise
    */
    public boolean checkForCombine(Ride ride1, Ride ride2){
        if (ride1.startId == ride2.startId && ride1.endId == ride2.endId){
            // calculate time difference in ms
            long timeDiff = Math.abs(ride1.timeStamp.getTime() - ride2.timeStamp.getTime());

            // Convert 10 minutes to ms
            long tenMinutesInMs = 10 * 60 * 1000;

            // Check if the time difference is within 10 minutes
            if (timeDiff <= tenMinutesInMs) {
                // Check if there is enough capacity to combine the passengers
                if (ride1.passengerCount + ride2.passengerCount <= ride1.passengers.length) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
    * Removes a ride from the heap.
    * Finds the ride in the heap, swaps it with the last ride, removes it, and restores the heap property.
    *
    * @param r the ride to be removed
    * @return true if the ride was successfully removed, false otherwise
    */
    public boolean remove(Ride r){
        int posRoot = -1;
        int posLast = next - 1;
        

        for (int i = 1; i < next; i++) {
            if (heapArray[i].equals(r)) {
                posRoot = i;
                break;
            }
        }

        if (posRoot == -1) {
            return false;  // Ride object not found in the heap
        }
        
        // Swap the ride with the last ride and remove it
        swap(posRoot, posLast);
        next --;
        heapArray[next] = null;

        // Restore the heap by moving the swapped ride up or down
        if (posRoot < next) {
            if (posRoot > 1 && heapArray[posRoot] != null && heapArray[posRoot].compareTo(heapArray[posRoot / 2]) < 0) {
                upHeap(posRoot);
            } else {
                downHeap(posRoot);
            }
        }
        return true;
        

    }

    /**
    * Checks if the heap is empty.
    *
    * @return true if the heap is empty, false otherwise
    */
    public boolean isEmpty(){
        if (next == 1){
            return true;
        }
        return false;
    }

    /**
    * Retrieves the ride with the highest priority (the root of the heap) without removing it.
    *
    * @return the ride with the highest priority, or null if the heap is empty
    */
    public Ride peek(){
        if (this.isEmpty()){
            return null;
        }
        
        return heapArray[1];

    }

    /**
    * Builds a heap from an array of rides.
    * Copies the rides into the heap array and applies the heapify process to restore the heap property.
    *
    * @param rides the array of rides to be turned into a heap
    * @param rideNum the number of rides in the array
    */
    public void heapify(Ride[] rides, int rideNum){
        if (rideNum > 20){
            return;
        }

        heapArray = new Ride[rideNum+1];
        next = 1;
        
        // Copy the rides to the heap array
        for (int i = 0; i<rideNum; i++){
            heapArray[next] = rides[i];
            next++;
        }

        // Apply heapify process
        for (int i = (next - 1) / 2; i > 0; i--) {
            downHeap(i);
        }
    }

    /**
    * Sorts the rides in the heap.
    * Extracts the rides in ascending order and returns them in a sorted array.
    *
    * @return a sorted array of rides
    */
    public Ride[] sort(){
        int originalNext = next;
        Ride[] sortedRides = new Ride[originalNext - 1];
        
        // Continue extracting the minimum element and rebuilding the heap
        for (int i = 0; i < sortedRides.length; i++) {
            sortedRides[i] = heapArray[1];
            heapArray[1] = heapArray[next - 1];
            next--;
            downHeap(1);
        }

        // Restore the original heap state
        next = originalNext;
        for (int i = 0; i < sortedRides.length; i++) {
            heapArray[i + 1] = sortedRides[i];
        }

        return sortedRides;
    }
    
    /**
    * Dumps the current state of the heap.
    * For each position in the heap array, it prints the ride details or null if no ride is present.
    */
    public void dump(){
        for (int i = 0; i<heapArray.length;i++){
            if (heapArray[i] != null) {
                System.out.println(heapArray[i]);
            } else {
                System.out.println(i + ": null");
            }
        }
    }

    /**
    * Moves a ride up the heap to restore the heap property.
    * Swaps the ride with its parent until the heap property is satisfied.
    *
    * @param pos the position of the ride to be moved up
    */
    private void upHeap(int pos){
        int posChild = pos;
        while (posChild > 1){
            // Calculate the parent's position
            int posParent = posChild/2;
            // Check if the current node is smaller than its parent
            if (heapArray[posChild] != null && heapArray[posParent] != null &&
                heapArray[posChild].compareTo(heapArray[posParent])< 0){
                // Swap the child and parent
                swap(posChild, posParent);
            }
            // Move up to the parent's position
            posChild = posParent;
        }
    }

    /**
    * Moves a ride down the heap to restore the heap property.
    * Swaps the ride with its smallest child until the heap property is satisfied.
    *
    * @param pos the position of the ride to be moved down
    */
    private void downHeap(int pos){
        int smallest = -1;
        int posParent = pos;
        int left, right;

        while (posParent<next){
            // Calculate the positions of the left and right children
            left = posParent * 2;
            right = (posParent * 2) + 1;

            // Assume the parent is the smallest
            smallest = posParent;

             // Check if the left child is smaller than the parent
            if (left < next && heapArray[left] != null && (heapArray[left].compareTo(heapArray[posParent]) <0)){
                smallest = left;
            }

            // Check if the right child is smaller than the smallest found so far
            if (right < next && heapArray[right] != null &&(heapArray[right].compareTo(heapArray[smallest]) <0)){
                smallest = right;
            }

            // If the smallest is not the parent, swap and continue
            if (posParent != smallest){
                swap(smallest,posParent);
                posParent = smallest;
            }
            else{
                break; // If the parent is the smallest, the heap property is restored
            }
        }
    }

    /**
    * Swaps two rides in the heap array.
    *
    * @param pos1 the position of the first ride
    * @param pos2 the position of the second ride
    */
    public void swap(int pos1, int pos2){
        Ride tempValue = heapArray[pos1];
        heapArray[pos1] = heapArray[pos2];
        heapArray[pos2] = tempValue;
    }
}