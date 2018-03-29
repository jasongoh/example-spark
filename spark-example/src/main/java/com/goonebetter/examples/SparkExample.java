package com.goonebetter.examples;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;

public class SparkExample {

	public static void main(String[] args) {
	    String logFile = "C:/spark-2.3.0-bin-hadoop2.7/README.md"; // Should be some file on your system
	    SparkSession spark = SparkSession.builder().appName("Simple Application").master("local").getOrCreate();
	    Dataset<String> logData = spark.read().textFile(logFile).cache();

	    long numAs = logData.filter(s -> s.contains("a")).count();
	    long numBs = logData.filter(s -> s.contains("b")).count();

	    System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);

	    spark.stop();
	}

}
