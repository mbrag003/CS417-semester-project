package project;

import java.util.List;

import edu.odu.cs.cs417.TemperatureParser.CoreTempReading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;

import static edu.odu.cs.cs417.TemperatureParser.CoreTempReading;
import static edu.odu.cs.cs417.TemperatureParser.parseRawTemps;

public class Main {


    /***
     * The main function used to demonstrate the TemperatureParser class. It parses the temperature file specified in the command line argument and prints the readings to the console. Code adapted from ParseTempsDriver.java from the CS417 semester project repository.
     * @param args
     */
    public static void main(String[] args) {
        
        BufferedReader tFileStream = parseTempsFile(args);

        if (tFileStream == null) {
            return;
        }
        else {

            // Parse the temperature file and store the readings in a list of CoreTempReading objects. Code adapted from ParseTempsDriver.java from the CS417 semester project repository.
            List<CoreTempReading> allTheTemps = parseRawTemps(tFileStream);

            //Store the readings in arrays.
            TemperatureArray temperatureArray = new TemperatureArray(allTheTemps);
            temperatureArray.populateArrays();
            
            //Print the output file for core 0.
            PiecewiseLinearInterpolation piecewiseLinearInterpolation0 = new PiecewiseLinearInterpolation(temperatureArray.getReadings_core_0(), temperatureArray.getTimes(), args[0], 0);
            piecewiseLinearInterpolation0.writeOutputFile();

            //Print the output file for core 1.
            PiecewiseLinearInterpolation piecewiseLinearInterpolation1 = new PiecewiseLinearInterpolation(temperatureArray.getReadings_core_1(), temperatureArray.getTimes(), args[0], 1);
            piecewiseLinearInterpolation1.writeOutputFile();

            //Print the output file for core 2.
            PiecewiseLinearInterpolation piecewiseLinearInterpolation2 = new PiecewiseLinearInterpolation(temperatureArray.getReadings_core_2(), temperatureArray.getTimes(), args[0], 2);
            piecewiseLinearInterpolation2.writeOutputFile();

            //Print the output file for core 3.
            PiecewiseLinearInterpolation piecewiseLinearInterpolation3 = new PiecewiseLinearInterpolation(temperatureArray.getReadings_core_3(), temperatureArray.getTimes(), args[0], 3);
            piecewiseLinearInterpolation3.writeOutputFile();
        }   


    }

    /***
     * Parse the temperature file from the command line argument and return a BufferedReader for it. If the file cannot be found or the argument is not provided, an error message is printed to the user. 
     * @param args used to pass in a single filename
     * @return a BufferedReader for the file specified in the command line argument
     */
    public static BufferedReader parseTempsFile(String[] args) {
        BufferedReader tFileStream = null;

        // Parse command line argument 1. Code adapted from ParseTempsDriver.java from the CS417 semester project repository.
        try {
            tFileStream = new BufferedReader(new FileReader(new File(args[0])));
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Please provide a filename as a command line argument.");
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: The file cannot be found. Please check the file name and try again.");
        }

        return tFileStream;
    }
}


