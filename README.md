# TenPin Java Challenge - Jobsity

This project contains the Java Challenge for Jobsity.

## Requirements

- Java 8 or below
- Maven 3.5+

## Running the project

### Tests

To run the tests of the project, you will need to execute the following command:

```shell script
mvn test 
```

### Running the project

To execute the App class(The main class of the project), you will need to generate the artifact using the following command:
```shell script
mvn clean install
```

After this, execute the command:

```shell script
java -cp target/tenpin-1.0-SNAPSHOT.jar com.jobsity.App <PATH_TO_INPUT>
```
where PATH_TO_INPUT is path of the input file in the system.



