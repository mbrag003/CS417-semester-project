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

4 output files will be created, one being sample-input-core-00.txt. It will contain test *similar* to:

```
       0 <= x <=       30 ; y =      61.0000 +       0.6333 x ; interpolation
      30 <= x <=       60 ; y =      98.0000 +      -0.6000 x ; interpolation
      60 <= x <=       90 ; y =      20.0000 +       0.7000 x ; interpolation
      90 <= x <=      120 ; y =     128.0000 +      -0.5000 x ; interpolation
``` 

Note: If run using a file that does not exist or cannot be found, the following error message will be displayed.

```
Error: The file cannot be found. Please check the file name and try again.
```
