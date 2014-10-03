package ci.java.com;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONObject;

/**
 *   Steps
 *   Build a URL to access the geocoding service.
 *   Read from the URL.
 *   Build a JSON object for the content.
 *   Retrieve the first result from an array of results.
 *   Print out the information.

 * @author robin
 *
 */

public class JsonParsing {
	
	public static void geocoding(String addr) throws Exception
	{
	    // build a URL
	    String s = "http://maps.google.com/maps/api/geocode/json?" +
	                    "sensor=false&address=";
	    s += URLEncoder.encode(addr, "UTF-8");
	    URL url = new URL(s);
	 
	    // read from the URL
	    Scanner scan = new Scanner(url.openStream());
	    String str = new String();
	    while (scan.hasNext())
	        str += scan.nextLine();
	    scan.close();
	 
	    // build a JSON object
	    JSONObject obj = new JSONObject(str);
	    if (! obj.getString("status").equals("OK"))
	        return;
	 
	    // get the first result
	    JSONObject res = obj.getJSONArray("results").getJSONObject(0);
	    System.out.println(res.getString("formatted_address"));
	    JSONObject loc =
	        res.getJSONObject("geometry").getJSONObject("location");
	    String res1 = obj.getJSONArray("results").toString();
	    System.out.println(res1);
	    System.out.println("lat: " + loc.getDouble("lat") +
	                        ", lng: " + loc.getDouble("lng"));
	}

	public static void main(String[] args) throws Exception {
		geocoding("100 Wall Street");

	}

}
