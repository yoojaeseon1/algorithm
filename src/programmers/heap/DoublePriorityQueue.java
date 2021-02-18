package programmers.heap;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class DoublePriorityQueue {

	public static void main(String[] args) {
		
//		String[] operations = {"I 16","D 1"};
//		String[] operations = {"I 7","I 5","I -5","D -1"};
		String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		
		System.out.println(solution(operations)[0]);
		System.out.println(solution(operations)[1]);
		
		Queue<Integer> queue = new LinkedList<>();
		
		
		
		
	}
	
    public static int[] solution(String[] operations) {
        
        
        PriorityDeque priorityDeque = new PriorityDeque();
        
        for(int operationsI = 0; operationsI < operations.length; operationsI++) {
            
            String oneOfOperations = operations[operationsI];
            
            if(oneOfOperations.charAt(0)=='I')
                priorityDeque.enqueue(Integer.parseInt(oneOfOperations.substring(2)));
            else {
                if(oneOfOperations.charAt(2) == '1')
                    priorityDeque.dequeueMax();
                else
                    priorityDeque.dequeueMin();
            }
            
        }
        
        int[] answer = {0,0};
        if(priorityDeque.size() > 0) {
            answer[0] = priorityDeque.peekMax();
            answer[1] = priorityDeque.peekMin();
        }
        
        return answer;
    }

}

class PriorityDeque{
    
    private List<Integer> queueList;
    private boolean wasEnqueued;
    
    
    public PriorityDeque(){
        this.queueList = new LinkedList<>();
        this.wasEnqueued = false;
    }
    
    public void enqueue(int element) {
        this.queueList.add(element);
        this.wasEnqueued = true;
    }
    
    public int dequeueMax() {
        
        if(this.queueList.size() == 0)
            return -1;
//    	throw new NoSuchElementException();
        
        if(this.wasEnqueued){
            Collections.sort(this.queueList);
            this.wasEnqueued = false;
        }
        
        int dequeuedElement = queueList.get(queueList.size()-1);
        this.queueList.remove(queueList.size()-1);
        return dequeuedElement;
    }
    
    public int dequeueMin(){
        
        if(queueList.size() == 0)
            return -1;
//        	throw new NoSuchElementException();
        
        if(wasEnqueued) {
            Collections.sort(queueList);
            wasEnqueued = false;
        }
        
        int dequeuedElement = queueList.get(0);
        queueList.remove(0);
        return dequeuedElement;    
    }
    
    public int peekMax() {
        if(this.queueList.size()==0)
        	throw new NoSuchElementException();
        
        if(wasEnqueued)
            Collections.sort(this.queueList);
        
        return this.queueList.get(this.queueList.size()-1);
    }
    
    public int peekMin() {
        if(this.queueList.size()==0)
        	throw new NoSuchElementException();
        
        if(this.wasEnqueued)
            Collections.sort(this.queueList);
        
        return this.queueList.get(0);
    }
    
    public int size(){
        return this.queueList.size();
    }
}
