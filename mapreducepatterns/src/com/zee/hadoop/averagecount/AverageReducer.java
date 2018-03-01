package com.zee.hadoop.averagecount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class AverageReducer extends Reducer<IntWritable, CountTuple, IntWritable, CountTuple> {
	
private CountTuple result = new CountTuple();

@Override
public void reduce(IntWritable key, Iterable<CountTuple> values,	Context context) throws IOException, InterruptedException {

	float sum = 0;
	int count = 0;

// Iterate through all input values for this key
	for (CountTuple val : values) {
		result.setComment(val.getComment());
		result.setCreationDate(val.getCreationDate());
		result.setPostId(val.getPostId());
		result.setRowId(val.getRowId());
		result.setScore(val.getScore());
		result.setUserId(val.getUserId());
		result.setCount(count++);
		//sum += val.getCount() * val.getAverage();
		//count += val.getCount();
	}

	result.setCount(count);
	//result.setAverage(sum / count);

	context.write(key, result);
}

}
