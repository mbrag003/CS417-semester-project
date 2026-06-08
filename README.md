# Requirements 

    * Java 21

# Compilation

The code can be compiled with the provided gradle file using ./gradlew jar command.

# Sample Execution and Output

If run without command line arguments, using

```
java -jar app/build/libs/assignment.jar 
```
The following error message will be displayed.

```
Error: Please provide a filename as a command line argument.
```

If run using 

```
java -jar app/build/libs/assignment.jar app/src/test/resources/sample-input.txt
```

output *similar* to 

```
Time: 0 Core 0: 61.0 Core 1: 63.0 Core 2: 50.0 Core 3: 58.0
Time: 30 Core 0: 80.0 Core 1: 81.0 Core 2: 68.0 Core 3: 77.0
Time: 60 Core 0: 62.0 Core 1: 63.0 Core 2: 52.0 Core 3: 60.0
Time: 90 Core 0: 83.0 Core 1: 82.0 Core 2: 70.0 Core 3: 79.0
Time: 120 Core 0: 68.0 Core 1: 69.0 Core 2: 58.0 Core 3: 65.0
```

will be displayed. 

Note: If run using a file that does not exist or cannot be found, the following error message will be displayed.

```
Error: The file cannot be found. Please check the file name and try again.
```
