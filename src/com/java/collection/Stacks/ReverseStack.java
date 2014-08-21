/**
 * 
 * 1. v = Pop top one element from s
2. Push all remaining element to t
3. Push v to s
4. Push all t elements back to s
   This will get first element of s in correct reverse position.
   Continue for all other elements by keeping a count of how many elements are reversed.
 */

package com.java.collection.Stacks;

import java.util.Stack;

public class ReverseStack {
	
	public static Stack<Integer> reverseStack(Stack<Integer> s, Stack<Integer> t, int var){
		int count = s.size();
		
		while(count >= 0){
			var = s.pop();
			int n = 0;
			while(n < count-1){
				t.push(s.pop());
				n++;
			}
			s.push(var);
			while(!t.isEmpty()){
				s.push(t.pop());
			}
			count--;
		}
		System.out.println("REVERSED STACK");
		for(Integer rev: s){
			System.out.println(rev);
		}
		
		/*int count = s.size();

        Stack<Integer> t = new Stack<Integer>();

        while (count-- > 0)
        {
            int v = s.pop();
            int n = 0;
            while(n++ < count) t.push(s.pop());
            s.push(v);
            while (!t.isEmpty()) s.push(t.pop());
        }

        System.out.println("REVERSED STACK");
        for(Integer rev: s){
			System.out.println(rev);
		}*/
        
        return s;
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> t = new Stack<Integer>();
		int var = 0;
		s.add(0);
		s.add(1);
		s.add(2);
		s.add(3);
		
		System.out.println("ORIGINAL STACK");
		for(Integer rev: s){
			System.out.println(rev);
		}
		
		reverseStack(s,t,var);

	}

}
