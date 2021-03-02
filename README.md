# maven-java-app-2

## Steps

##Compile and Build a Fat Jar File
Open PowerShell as Administrator in the root project folder, compile the code using Maven and create an executable jar file. 
Generated artificacts can be found in the new 'target' folder.
``` mvn clean compile assembly:single ```

1 - Run Zookeeper Service
Start and keep running the Zookeeper service.

2 - Run Kafka Service
Start and keep running the Kafka service.

3 - Start Consumer
Open PowerShell as Administrator in the root project folder, start the original consumer app:
``` java -cp target/kafka-case-1.0-SNAPSHOT-jar-with-dependencies.jar com.edu.nwmissouri.bigdatasec2group1.kafka.simple.Consumer ```

4 - Start Producer
Open a new PowerShell as Administrator in the root project folder, start the Producer app using topic test:
``` java -cp target/kafka-case-1.0-SNAPSHOT-jar-with-dependencies.jar com.edu.nwmissouri.bigdatasec2group1.kafka.simple.ProducerByBihani```
