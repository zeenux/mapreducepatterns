package com.zee.etc;

import java.util.Map;
import java.util.HashMap;
import java.util.*;
public class MapExample {
	
	public static void main(String [] args)
	{
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Test Object");
		map.put(2, "Second Object");
		
		Set set=map.entrySet();
		Iterator it=set.iterator();
		while(it.hasNext()) {
			Map.Entry mEntry=(Map.Entry)it.next();
			System.out.println("Key is "+mEntry.getKey()+" And Value is "+mEntry.getValue());
		}
		
		   
	}   
      
      
   
}

   
   
