package com.zee.mrdputils;

import java.util.HashMap;
import java.util.Map;

public class MRDPUtils {
	public static final String[] REDIS_INSTANCES = { "p0", "p1", "p2", "p3",
			"p4", "p6" };
    public static int count=0;
	// This helper function parses the stackoverflow into a Map for us.
	public static Map<String, String> transformXmlToMap(String xml) {
		Map<String, String> map = new HashMap<String, String>();
		try {
		    //System.out.println("=============================");
		    //String[] mtokens=xml.trim().substring(5,xml.trim().length()).split("\"");
		    //System.out.println(xml.trim());
		    //for(String m:mtokens){
		      //  System.out.print(m+"||||");
            //}
            //System.out.println("=============================");

		    String[] tokens = xml.trim().substring(5, xml.trim().length() - 3).split("\"");

			//for (int i = 0; i < tokens.length - 1; i += 2) {
            for (int i = 0; i < tokens.length-1; i++) {
                //System.out.println("========================START RECORD "+(count++)+"========================");
				//System.out.println("Key: "+tokens[i]+" Value: "+tokens[i]+1);
               // System.out.println("========================END RECORD "+count+"========================");
				String key = tokens[i].trim();
				String val = tokens[i + 1];

				map.put(key.substring(0, key.length() - 1), val);

			}
		} catch (StringIndexOutOfBoundsException e) {
			System.err.println(xml);
		}

		return map;
	}
}
