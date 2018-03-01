package com.zee.hadoop.averagecount;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class AverageMapper extends Mapper<Object, Text, IntWritable, CountTuple> {

	private IntWritable outHour = new IntWritable();
	private CountTuple outCountAverage = new CountTuple();
    private static int count=0;
	private final static SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

	@SuppressWarnings("deprecation")
	@Override
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

		//System.out.println(value.toString());
		// Parse the input string into a nice map
		Map<String, String> parsed = com.zee.mrdputils.MRDPUtils.transformXmlToMap(value.toString());

		Set set=parsed.entrySet();
		Iterator it=set.iterator();

		while(it.hasNext()){
		    //System.out.println("Iteration "+count++);
            Map.Entry mentry = (Map.Entry)it.next();
            //System.out.print("Parsed key is: "+ mentry.getKey());// + " & Value is: ");
            //System.out.println(mentry.getValue());
        }
        System.out.print(" PostID= "+parsed.get("PostId"));
		System.out.print(" Text="+parsed.get("Text"));
        System.out.print(" Score="+parsed.get("Score"));
        System.out.print(" CreationDate="+parsed.get("CreationDate"));
        System.out.println(" UserId="+parsed.get("UserId"));
        String postId=parsed.get("PostId");
        String comment=parsed.get("Text");
        String score=parsed.get("Score");
        String strDate=parsed.get("CreationDate");
        String UserId=parsed.get("UserId");
        if ((strDate == null) || (comment == null) || (score==null) ||(UserId==null) ||(postId==null) ){
            //We want the complete Record
            return;
        }
        else{
            try {
                outCountAverage.setCount(outCountAverage.getCount() + 1);
                outHour.set(1);
                context.write(outHour, outCountAverage);
            }
            catch(java.lang.NullPointerException npe){
                System.out.println(npe.getMessage());
                return;
            }
            catch(Exception ee){
                System.out.println("An Exception occured "+ee.toString());
            }

        }
        return;


		// Grab the "CreationDate" field,
		// since it is what we are grouping by
		/*
        String strDate = parsed.get("CreationDate");

		// Grab the comment to find the length
		String text = parsed.get("Text");
		
		String userId=parsed.get("UserId");
		
		

		// .get will return null if the key is not there
		if (strDate == null || text == null) {
			// skip this record
			return;
		}

		try {
			// get the hour this comment was posted in
			Date creationDate = frmt.parse(strDate);
			outHour.set(creationDate.getHours());

			// get the comment length
			outCountAverage.setCount(1);
			outCountAverage.setAverage(text.length());

			// write out the user ID with min max dates and count
			context.write(outHour, outCountAverage);

		} catch (ParseException e) {
			System.err.println(e.getMessage());
			return;
		}
		*/
	}
}
