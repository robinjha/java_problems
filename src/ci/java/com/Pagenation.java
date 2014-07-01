package ci.java.com;

public class Pagenation {
	
	public static void paginate(int current_page, int total_pages) {
	    int NUM_VISIBLE_PAGES = 11;
	    int val = 0;
	    StringBuilder sb = new StringBuilder();
	    String result = "";
	    for(int i = 0; i < total_pages; i++){
	        if(i == current_page){  // for current page
	            sb.append("[");
	            sb.append(i);
	            sb.append("]");
	            val++;
	        }else{      //for all other pages 
	            
	            
	        }
	    }
	    System.out.println(sb.toString());
	}
	
	public static void paginatePages(int current_page, int total_pages){
		StringBuilder sb = new StringBuilder();
		int startPage = current_page -4;
		int endPage = current_page +4;
		
		if(startPage <= 0){
			endPage -= (startPage -1);
			startPage = 1;
		}
		
		if(endPage > total_pages)
			endPage = total_pages;
		
		if(startPage > 1) sb.append(1+"...");
		for(int i = startPage ; i <= endPage ; i++){
			sb.append(" "+i+" ");
		}
		if(endPage < total_pages) sb.append("..."+total_pages);
		System.out.println(sb.toString());
	}
	
	public static void paginationTest(int current_page, int total_pages){
		int NUM_VISIBLE_PAGES = 11;
		int startPage = current_page -4;
		int endPage = current_page +4;

		StringBuilder sb = new StringBuilder();

		if(startPage <= 0){
			endPage -= (startPage -1);
			startPage = 1;
		}

		if(endPage > total_pages)
			endPage = total_pages;

		if(startPage > 1) sb.append(1+"...");
		for(int j = startPage ; j <= endPage ; j++){
			if(j == current_page){  // for current page
				sb.append("["+j+"]");
			}else{
				sb.append(" "+j+" ");
			}
		}
		if(endPage < total_pages) sb.append("..."+total_pages);

		System.out.println(sb.toString());
	}
	
	/*public static void pagePages(int curPage, int totalPage){
		int startPage = 0;
		int endPage = 0;
		int diff = 0;
		StringBuilder sb = new StringBuilder();
		startPage = (curPage < 5)? 1 : curPage - 4;
		endPage = 8 + startPage;
		endPage = (totalPage < endPage) ? totalPage : endPage;
		diff = startPage - endPage + 8;
		startPage -= (startPage - diff > 0) ? diff : 0;

		if (startPage > 1)  sb.append(" First ... ");
		for(int i=startPage; i<=endPage; i++) sb.append(" "+i+" ");
		if (endPage < totalPage) sb.append(" ... Last ");
		System.out.println(sb.toString());
	}
*/
	/*paginate(1, 30) == "[1] 2 3 4 5 6 7 8 9 10 ... 30"
	paginate(5, 30) == "1 2 3 4 [5] 6 7 8 9 10 ... 30"
	paginate(10, 30) == "1 ... 6 7 8 9 [10] 11 12 13 14 ... 30"
	paginate(24, 30) == "1 ... 20 21 22 23 [24] 25 26 27 28 ... 30"
	paginate(30, 30) == "1 ... 21 22 23 24 25 26 27 28 29 [30]"*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//paginate(1, 30);
		//paginatePages(1,30);
		//paginatePages(5,30);
		//paginatePages(10,30);
		//paginatePages(24,30);
		//paginatePages(30,30);
		//pagePages(1,30);
		paginationTest(1,30);
		paginationTest(5,30);
		paginationTest(10,30);
		paginationTest(24,30);
		paginationTest(30,30);
		
	}

}
