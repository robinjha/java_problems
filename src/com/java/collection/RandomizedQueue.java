package com.java.collection;

public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private Item[] q;
    private int N = 0;
    private int first = 0;
    private int last = 0;
    
   public RandomizedQueue()           // construct an empty randomized queue
   {
       q = (Item[]) new Object[2];
   }
       
   public boolean isEmpty()           // is the queue empty?
   {
       return N == 0;
   }
   
   public int size()                  // return the number of items on the queue
   {
       return N;
   }
   
   private void resize(int max){
    Item[] temp = (Item[])new Object[max]; 
    for(int i = 0; i < N; i++){
        temp[i] = q[(first+i)%q.length];
    }
    q = temp;
    first = 0;
    last = N;
   }
   
   public void enqueue(Item item)     // add the item
   {
       if(N == q.length) resize(2*q.length);
       q[last++] = item;
       if(last == q.length) last = 0;
       N++;
   }
   
   public Item dequeue()              // delete and return a random item
   {
       if(isEmpty()) throw new NoSuchElementException("Queue Underflow");
       int r = StdRandom.uniform(N);
       Item item = q[r];
       q[r] = null;
       N--;
       if(N > 0 && N == q.length/4) resize(q.length/2);
       return item;
   }
   
   public Item sample()               // return (but do not delete) a random item
   {
       if(isEmpty()) throw new NoSuchElementException("Queue Underflow");
       int j = StdRandom.uniform(N);
       return q[j];
   }
   
   public Iterator<Item> iterator()   // return an independent iterator over items in random order
   {
       return new ArrayIterator();
   }
   
   private class ArrayIterator implements Iterator<Item>{
       private int i = 0;
       public boolean hasNext(){ return i < N;}
       public void remove(){throw new UnsupportedOperationException();}
       
       public Item next(){
           if(!hasNext()) throw new NoSuchElementException();
           Item item = q[(i + first) % q.length];
           i++;
           return item;
       }
   }
}
