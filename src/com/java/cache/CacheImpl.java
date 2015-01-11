package com.java.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CacheImpl<K,V> implements Cache{

	
	private volatile static CacheImpl instance;
	private static  int capacity = 10;
	private ConcurrentHashMap<K, V> map;
	private ConcurrentLinkedQueue<K> queue;
	  
	
	private CacheImpl(){
		//this.capacity = capacity;
		this.map = new ConcurrentHashMap<K,V>();
		this.queue = new ConcurrentLinkedQueue<K>();
		
	}
	
	/**
	 * thread safe singleton method using double checked 
	 * locking principle to improve performance 
	 * 
	 * @return - singleton instance
	 */
	public static CacheImpl getInstance() {
		if(instance == null){
			synchronized (CacheImpl.class){
				if(instance == null){
					instance = new CacheImpl();
				}
			}
		}
		return instance;
	}
	
	@Override
	public void put(final Object key, final Object value) {
		if(key == null || value == null)
			throw new NullPointerException();
		
		//case 1: when key exists in cache, remove it and add it to the tail
		if(map.containsKey(key)){
			queue.remove(key);
		}
		
		//case 2: when cache is full, remove older entry and add the new entry
		while(queue.size() >= capacity){
			K expiredKey = queue.poll();
			if(expiredKey != null){
				map.remove(expiredKey);
			}
		}
		//case 3: add values to queue and map
		queue.add((K) key);
		map.put((K)key, (V)value);
	}

	@Override
	public Object get(final Object key) {
		return map.get(key);
	}
	
	public static void main(String[] args){
		CacheImpl<Object,Object> cache = CacheImpl.getInstance();
		cache.put ("1", "one");                           // 1
		cache.put ("2", "two");                           // 2 1
		cache.put ("3", "three");                         // 3 2 1
		cache.put ("4", "four");                          // 4 3 2

		if (cache.get("2") == null) throw new Error();    // 2 4 3
	   cache.put ("5", "five");                          // 5 2 4
	   cache.put ("4", "second four");                   // 4 5 2
	   // Verify cache content.
	   if (!cache.get("4").equals("second four")) throw new Error();
	   if (!cache.get("5").equals("five"))        throw new Error();
	   if (!cache.get("2").equals("two"))         throw new Error();
	   System.out.println(cache.toString());
	   

	}

	@Override
	public String toString() {
		return "CacheImpl [map=" + map + ", queue=" + queue + "]";
	}

}
