package edu.nwmissouri.bigdatasec2group1.kafka.simple;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Bihani Tamang  on 03/1/2021
 */
public class ProducerByBihani {
  private static Scanner in;

  public static void main(String[] argv) throws Exception {
    if (argv.length != 1) {
      System.err.println("Please specify 1 parameter (the name of the topic)");
      System.exit(-1);
    }
    String topicName = argv[0];
    in = new Scanner(System.in);
    System.out.println("Thank you for providing the topic " + topicName + "\n");
    System.out.println("Enter message (type exit to quit).\n");

    // Configure the Producer
    Properties configProperties = new Properties();
    configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
        "org.apache.kafka.common.serialization.ByteArraySerializer");
    configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
        "org.apache.kafka.common.serialization.StringSerializer");
    System.out.println("The configuration properties are: " + configProperties.toString());
    System.out.println("\nWill use this configuration to create a producer.\n");

    org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);

    //create your custom logic here
    Random rand = new Random();

    for (int i = 1; i <= 10; i++) {
	//generate random number between 1 to 10
        int generateRandomNumber = rand.nextInt(10)+1;
        String movieList = movieGenerator(generateRandomNumber);
        ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, movieList);
        producer.send(rec);
      }

    String line = in.nextLine();
    while (!line.equals("exit")) {
      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, line);
      producer.send(rec);
      line = in.nextLine();
    }

    in.close();
    producer.close();

  }
    
        private static String movieGenerator(int top10favMovie) {
        switch(top10favMovie){
            case 1:
                return "Shawshank Redemption";
            case 2:
                return "Shutter Island";
            case 3:
                return "Prisoners";
            case 4:
                return "A good liar";
            case 5:
                return "Gone Girl";
            case 6:
                return "The Truman Show";
            case 7:
                return "Inception";
            case 8:
                return "The Wolf of Wall Street";
            case 9:
                return "Borat";
            case 10:
                return "The Dictator";
            default:
                return "The Truman Show";
        }
    }
        
  }