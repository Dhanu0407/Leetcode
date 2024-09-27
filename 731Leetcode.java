class MyCalendarTwo {
    List<int[]> bookings;
    TreeMap<Integer,Integer> overlappedMap;
    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlappedMap = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        //if event is present in overlapped then return false
        Integer prevVal = overlappedMap.lowerKey(end);
        if(prevVal!=null && start <= overlappedMap.get(prevVal)-1){
            return false;
        }
        // insert into bookings and if it is overalapping with
        // any booking then insert into overlapped map
        for(int booking[] : bookings){
            // booking[0], start
            // booking[1], end
            int commStart = Math.max(booking[0],start);
            int commEnd = Math.min(booking[1],end);
            if(commStart<commEnd){
                overlappedMap.put(commStart,commEnd);
            }
        }
        bookings.add(new int[]{start,end});
        return true;
        
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */