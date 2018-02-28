package com.zee.hadoop.averagecount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;



public class AverageDriver {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		String[] otherArgs = new GenericOptionsParser(conf, args)
				.getRemainingArgs();
//		if (otherArgs.length != 2) {
//			System.err.println("Usage: AverageDriver <in> <out>");
//			System.exit(2);
//		}
		Job job = Job.getInstance(conf, "StackOverflow Average Comment Length");
		job.setJarByClass(AverageDriver.class);
		job.setMapperClass(AverageMapper.class);
		job.setCombinerClass(AverageReducer.class);
		job.setReducerClass(AverageReducer.class);
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(CountAverageTuple.class);
		FileInputFormat.addInputPath(job, new Path("/home/zeenux/HADOOP_DEV_RELATED/DATASETS/Comments.xml"));
		double rnd=Math.random();
		FileOutputFormat.setOutputPath(job, new Path("/home/zeenux/HADOOP_DEV_RELATED/op/output_"+rnd));
		System.exit(job.waitForCompletion(true) ? 0 : 1);

	}

}
