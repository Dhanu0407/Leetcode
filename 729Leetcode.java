 class MyCalendar{
   TreeMap<Integer,Integer> map;

   public MyCalendar(){
    map = new TreeMap<>();
   }

   public boolean book(int start, int end){
    Integer previousVal = map.lowerKey(end);

    if(previousVal!=null && start<=map.get(previousVal)-1){
        return false;
    }
    map.put(start,end);
    return true;
   }
}