class CustomStack{
    int[] stack;
    int size;
    int index;
    int capacity;
    int[] oper;
    public CustomStack(int maxSize){
      stack=new int[maxSize];
      size=0;
      index=-1;
      capacity=maxSize;
      oper=new int[maxSize];
    }
    private boolean isFull(){
        return size==capacity;
    }
    private boolean isEmpty(){
       return size==0;
    }
    public void push(int x){
      if(isFull()){
        return;
      }
      index++;
      size++;
      stack[index]=x;
    }
    public int pop(){
      if(isEmpty()){
        return -1;
      }
      int val = stack[index];
      val+=oper[index];

      if(index>0){
        oper[index-1]+=oper[index];
      }
      oper[index]=0;
      index--;
      size--;
      return val;
    }
    public void increment(int k, int val){
      if(isEmpty()){
        return;
      }
      int num = Math.min(size,k);
      oper[num-1] += val;

    //   for(int i=0; i<num; i++){
    //     stack[i]+=val;
    //   }
    }
}