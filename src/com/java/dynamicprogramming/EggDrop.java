package com.java.dynamicprogramming;


/**
 * Given eggs and total number of floors find the 
 * least number of egg-droppings that is guaranteed to work in all cases
 * What strategy should you adopt to minimize the number egg drops it takes to find the solution?.
 * (And what is the worst case for the number of drops it will take?)
 * detailed explanation : http://datagenetics.com/blog/july22012/index.html
 * Created by robin on 2/7/15.
 * 
 */
public class EggDrop {

	/**
	 * recursive solution
	 * @param noOfEggs
	 * @param noOfFloor
	 * @return
	 * @throws Exception
	 */
    public static int maxDropFloor(int noOfEggs, int noOfFloor) throws Exception{
        if(noOfEggs < 0 || noOfFloor < 0) throw new Exception("The no of eggs and number of floor needs to be a positive integer");

        if(noOfFloor == 0 || noOfFloor == 1) return noOfFloor; // 1 floor or no floors
        
        if(noOfEggs == 1) return noOfFloor;

        int maxFloor = 0, minValue = Integer.MAX_VALUE;

        for(int i = 1; i <= noOfFloor; i++){
            maxFloor = Math.max(maxDropFloor(noOfEggs -1, i-1), maxDropFloor(noOfEggs,noOfFloor-i));
            if(maxFloor < minValue){
                minValue = maxFloor;
            }
        }
        return minValue+1;
    }

    /**
     * egg problem solution using dynamic programming
     * time complexity - O(noOfEggs*noOfFloor^2)
     * auxiliary space - O(noOfEggs*noOfFloor)
     * @param noOfEggs
     * @param noOfFloor
     * @return
     * @throws Exception
     */
    public static int maxDropFloorDP(int noOfEggs, int noOfFloor) throws Exception{
    	int[][] drops = new int[noOfEggs][noOfFloor];
    	if(noOfEggs < 0 || noOfFloor < 0) throw new Exception("The no of eggs and number of floor needs to be a positive integer");
    	
    	int res = 0;
    	
    	// if we only have one egg
    	for(int i = 1; i < noOfFloor ; i++){ 
    		drops[1][i] = i;
    	}
    	
    	// 0 for 0 floor and 1 for 1 floor
    	for(int i = 0; i < noOfEggs; i++){
    		drops[i][0] = 0;
    		drops[i][1] = 1;
    	}
    	
    	
    	//complete the drops array
    	for(int i = 2; i < noOfEggs; i++){
    		for(int j = 2; j < noOfFloor; j++){
    			drops[i][j] = Integer.MAX_VALUE;
    			for(int k = 1; k <= j; k++){
    				res = Math.max(drops[i-1][k-1], drops[i][j-k]);
    				if(res < drops[i][j]){
    					drops[i][j] = res;
    				}
    			}
    		}
    	}
    	return drops[noOfEggs][noOfFloor];
    }


    public static void main(String[] args) throws  Exception{
        int noOfAvailableEggs = 2;
        int noOfFloors = 36;
        //System.out.println("Floor value :" + maxDropFloor(noOfAvailableEggs, noOfFloors));
        System.out.println("Floor value (DP) :" + maxDropFloor(noOfAvailableEggs, noOfFloors));
    }
}
