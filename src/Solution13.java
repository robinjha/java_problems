import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


class Interval {
	int start;
	int end;
 
	Interval() {
		start = 0;
		end = 0;
	}
 
	Interval(int s, int e) {
		start = s;
		end = e;
	}
	
	@Override
	public String toString() {
		return start + ":" + end ;
	}
}
 
public class Solution13 {
	
	
	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
 
		if (intervals == null || intervals.size() <= 1)
			return intervals;
 
		// sort intervals by using self-defined Comparator
		Collections.sort(intervals, new IntervalComparator());
 
		ArrayList<Interval> result = new ArrayList<Interval>();
 
		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
 
			if (prev.end > curr.start) {
				// merged case
				Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end));
				prev = merged;
			} else {
				result.add(prev);
				prev = curr;
			}
		}
 
		result.add(prev);
 
		return result;
	}
	
	 public static String convertToCommaDelimited(ArrayList<Interval> list) {
	        StringBuffer res = new StringBuffer("");
	        for (int i = 0;  i < list.size(); i++) {
	            res.append(list.get(i));
	            if (i != list.size() - 1) {
	                res.append(',');
	            }
	        }
	        System.out.println(res.toString());
	        return res.toString();
	    }
	
	public static void compressedString(String str){
		ArrayList<Interval> intervals =  new ArrayList<Interval>();
		StringBuffer result = new StringBuffer("");
		String[] values = str.replaceAll("^[,\\s]+", "").split("[,\\s]+");
		//System.out.println(str);
		System.out.println(Arrays.toString(values));
		for(String i: values){
			String[] parts = i.split(":");
			Interval intvl = new Interval(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
			intervals.add(intvl);
		}
		intervals = merge(intervals);
		convertToCommaDelimited(intervals);
		/*for(Interval j : intervals){
			System.out.print(j.toString()+",");
		}*/
	}
	
	
	public static void main(String[] args){
		compressedString("1:4  ,  5:10,11:20");
		compressedString("5:10,1:2");
		
	}
}
 
class IntervalComparator implements Comparator<Interval> {
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
	
}
