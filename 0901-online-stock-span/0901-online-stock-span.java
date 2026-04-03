import java.util.*;

class StockSpanner {

    Stack<Integer>s=new Stack<>();
    ArrayList<Integer>Stock=new ArrayList<>();
    ArrayList<Integer>span=new ArrayList<>();
        public StockSpanner() {
    }
    
    public int next(int price) {
    int i=Stock.size();
    Stock.add(price);
    span.add(1);
    while(!s.isEmpty()&&price>=Stock.get(s.peek())){
        s.pop();
    }
    if(s.isEmpty()){
        span.set(i,i+1);
    }else{
        int prevHigh=s.peek();
        span.set(i,i-s.peek());
    }
    s.push(i);
    return span.get(i);
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */