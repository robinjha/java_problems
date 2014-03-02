package ci.java.com;

public class MedianOfIntegerStream {
	
	public static int[] merge(int[] arr1, int[] arr2){
		if(arr1 == null || arr2 == null)
			try {
				throw new Exception("Passed null as argument");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		   int[] answer = new int[arr1.length + arr2.length];
		   int i = 0, j = 0, k = 0;
		   
		    while(i < arr1.length && j < arr2.length){
		        if(arr1[i] < arr2[j])
		            answer[k++] = arr1[i++];
		        else
		            answer[k++] = arr2[j++];
		         
		    }
		    
		    while(i < arr1.length)
		        answer[k++] = arr1[i++];
		        
		    while(j < arr2.length)
		        answer[k++] = arr2[j++];
		        
		    return answer;
		}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[] arrA = {1,2,3};
		int[] arrB = {3,5,6};
		
		for(int i: merge(null, arrB)){
			System.out.print(" "+ i);
		}

	}

}
