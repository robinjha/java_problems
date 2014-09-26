package ci.java.com;

import java.text.DecimalFormat;

public class ConvertNumbersToWords {
	
	public static final String[] tens = {
		"",
		" ten",
		" twenty",
		" thirty",
		" forty",
		" fifty",
		" sixty",
		" seventy",
		" eighty",
		" ninety"
	};

	public static final String[] nums = {"",
	    " one",
	    " two",
	    " three",
	    " four",
	    " five",
	    " six",
	    " seven",
	    " eight",
	    " nine",
	    " ten",
	    " eleven",
	    " twelve",
	    " thirteen",
	    " fourteen",
	    " fifteen",
	    " sixteen",
	    " seventeen",
	    " eighteen",
	    " nineteen"};
	
	public static String convertLessThanThousand(int num){
		String convertedNum = "";
		
		if(num % 100 < 20){
			convertedNum = nums[num % 100] ;
			num = num/100;
		}else{
			convertedNum = nums[num%10];
			num /= 10;
			convertedNum = tens[num%10] + convertedNum;
			num /= 10;
		}
		
		if(num == 0) return convertedNum;
		//return convertedNum;
		return nums[num] +" hundred"+ convertedNum;
	}
	
	public static String convert(long num){
		
		if(num == 0) return "Zero";
		
		String strNum = Long.toString(num);
		
		String mask = "000000000000";
		DecimalFormat df = new DecimalFormat(mask);
		strNum = df.format(num);
		String result = "";
		
		// XXXnnnnnnnnn
	    int billions = Integer.parseInt(strNum.substring(0,3));
	    // nnnXXXnnnnnn
	    int millions  = Integer.parseInt(strNum.substring(3,6));
	    // nnnnnnXXXnnn
	    int hundredThousands = Integer.parseInt(strNum.substring(6,9));
	    // nnnnnnnnnXXX
	    int thousands = Integer.parseInt(strNum.substring(9,12));
	    
	    String bill;
	    switch(billions){
	    case 0:
	    	bill = "";
	    	break;
	    case 1:
	    	bill = "One billion ";
	    	break;
	    default:
	    	bill = convertLessThanThousand(billions) + " billion ";
	    }
	    result += bill;
	    
	    String mill;
	    switch(millions){
	    case 0:
	    	mill = "";
	    	break;
	    case 1:
	    	mill = "One million ";
	    	break;
	    default:
	    	mill = convertLessThanThousand(millions) + " million ";
	    }
	    result += mill;
		
	    String hunThousand;
	    switch (hundredThousands){
	    case 0:
	    	hunThousand = "";
	    	break;
	    case 1:
	    	hunThousand = " one thousand";
	    	break;
	    default:
	    	hunThousand = convertLessThanThousand(hundredThousands) + " thousand ";
	    }
	    
	    result += hunThousand;
	    
	    String thousand;
	    thousand = convertLessThanThousand(thousands);
	    result+=thousand;
	    	
		return result;
	}
	
	
	
	public static void main(String[] args) {
		
		//System.out.println(convertLessThanThousand(151));
		System.out.println(convert(2147483647));

	}

}
