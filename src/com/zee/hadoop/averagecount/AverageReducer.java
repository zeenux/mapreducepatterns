package com.zee.hadoop.averagecount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class AverageReducer extends Reducer<IntWritable, CountAverageTuple, IntWritable, CountAverageTuple> {
	
private CountAverageTuple result = new CountAverageTuple();

@Override
public void reduce(IntWritable key, Iterable<CountAverageTuple> values,	Context context) throws IOException, InterruptedException {

	float sum = 0;
	float count = 0;

// Iterate through all input values for this key
	for (CountAverageTuple val : values) {
		sum += val.getCount() * val.getAverage();
		count += val.getCount();
	}

	result.setCount(count);
	result.setAverage(sum / count);

	context.write(key, result);
}

}
