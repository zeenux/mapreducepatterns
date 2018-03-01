package com.zee.etc;
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String data="";
		String line=null;
		try {
			
			FileReader f=new FileReader("/home/zeenux/HADOOP_DEV_RELATED/DATASETS/Comments.xml");
			BufferedReader br=new BufferedReader(f);
			while((line=br.readLine())!=null) {
				data+=line;
			}
			
			HashMap myMap=(HashMap)XmlTransform.transformXmlToMap(data);
			Set set=myMap.entrySet();
			Iterator it=set.iterator();
			while(it.hasNext()) {
				Map.Entry mEntry=(Map.Entry)it.next();
				System.out.println("Key=> "+mEntry.getKey()+" Value=> "+mEntry.getValue());
			}
			
		}
		catch(IOException ex) {
			System.out.println(ex.toString());
		}
	}

}
