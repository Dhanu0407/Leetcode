class MyCircularDeque{
    private int K;
    private int[] deq;
    private int front;
    private int rear;
    private int currCount;
    public MyCircularDeque(int k){
        K=k;
        deq = new int[K];
        front = 0;
        rear = K-1;
        currCount = 0;
    }
    public boolean insertFront(int value){
       if(isFull()){
        return false;
       }
       front = (front-1+K)%K;
       deq[front]=value;
       currCount++;
       return true;
    }
    public boolean insertLast(int value){
        if(isFull()){
            return false;
        }
        rear = (rear+1)%K;
        deq[rear] = value;
        currCount++;
        return true;
    }
    public boolean deleteFront(){
      if(isEmpty()){
        return false;
      }
      front = (front+1)%K;
      currCount--;
      return true;
    }
    public boolean deleteLast(){
        if(isEmpty()){
            return false;
        }
        rear = (rear-1+K)%K;
        currCount--;
        return true;
    }
    public int getFront(){
      if(isEmpty()){
        return -1;
      }
      return deq[front];
    }
    public int getRear(){
        if(isEmpty()){
            return -1;
        }
        return deq[rear];
    }
    public boolean isEmpty(){
      return currCount==0; 
    }
    public boolean isFull(){
      return currCount==K;
    }
}