package project;

import java.util.List;

import edu.odu.cs.cs417.TemperatureParser.CoreTempReading;



/***
 * Takes the list of CoreTempReading objects produced by the Main class and stores them in a number of arrays, one for each core.
 * Each array contains the temperature readings for that core, and the arrays are stored in a list. 
 */
public class TemperatureArray {

    private int numberOfReadings;
    List<CoreTempReading> readings;


    // Arrays to store the temperature readings for each core. Code adapted from Example 2 in Semester Project - Input Library and Language Selection on canvas.
    private int[] times;
    private double[] readings_core_0;
    private double[] readings_core_1;
    private double[] readings_core_2;
    private double[] readings_core_3;


    /***
     * Constructor for the TemperatureArray class. Takes a list of CoreTempReading objects and creates the arrays for each core. Code adapted from Example 2 in Semester Project - Input Library and Language Selection on canvas.
     * @param readings a list of CoreTempReading objects
     */
    public TemperatureArray(List<CoreTempReading> readings) {
        this.readings = readings;
        this.numberOfReadings = readings.size();
        this.times = new int[numberOfReadings];
        this.readings_core_0 = new double[numberOfReadings];
        this.readings_core_1 = new double[numberOfReadings];
        this.readings_core_2 = new double[numberOfReadings];
        this.readings_core_3 = new double[numberOfReadings];
    }


    /***
     * Populates the arrays for each core with temperature readings from the list of core temperature readings. Code adapted from ParseTempsDriver.java from the CS417 semester project repository.
     */
    public void populateArrays() {
        for (int i = 0; i < numberOfReadings; i++) {
            CoreTempReading reading = readings.get(i);
            times[i] = reading.step;
            readings_core_0[i] = reading.readings[0];
            readings_core_1[i] = reading.readings[1];
            readings_core_2[i] = reading.readings[2];
            readings_core_3[i] = reading.readings[3];
        }
    }

    /***
     * Prints the contents of each array.
     */
    public void printArrays() {
        System.out.println("Times: " + java.util.Arrays.toString(times));
        System.out.println("Core 0 Readings: " + java.util.Arrays.toString(readings_core_0));
        System.out.println("Core 1 Readings: " + java.util.Arrays.toString(readings_core_1));
        System.out.println("Core 2 Readings: " + java.util.Arrays.toString(readings_core_2));
        System.out.println("Core 3 Readings: " + java.util.Arrays.toString(readings_core_3));
    }



}
