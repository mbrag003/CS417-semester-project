package project;

import java.util.List;

import edu.odu.cs.cs417.TemperatureParser.CoreTempReading;



/***
 * Takes the list of CoreTempReading objects produced by the Main class and stores them in a number of arrays, one for each core.
 * Each array contains the temperature readings for that core, and the arrays are stored in a list. 
 */
public class TemperatureArray {

    private int numberOfReadings;
    private List<CoreTempReading> readings;


    // Arrays to store the temperature readings for each core. Code adapted from Example 2 in Semester Project - Input Library and Language Selection on canvas.
    private double[] times;
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
        this.times = new double[numberOfReadings];
        this.readings_core_0 = new double[numberOfReadings];
        this.readings_core_1 = new double[numberOfReadings];
        this.readings_core_2 = new double[numberOfReadings];
        this.readings_core_3 = new double[numberOfReadings];
    }

    /***
     * Returns the list of CoreTempReading objects.
     * @return the list of CoreTempReading objects
     */
    public List<CoreTempReading> getReadings() {
        return readings;
    }

    /***
     * Returns the number of readings in the list of CoreTemperatureReading objects.
     * @return the number of readings
     */
    public int getNumberOfReadings() {
        return numberOfReadings;
    }

    /***
     * Returns the array of time steps for each reading.
     * @return the array of time steps
     */
    public double[] getTimes() {
        return times;
    }


    /***
     * Returns the array of temperature readings for core 0.
     * @return the array of temperature readings for core 0
     */
    public double[] getReadings_core_0() {
        return readings_core_0;
    }

    /***
     * Returns the array of temperature readings for core 1.
     * @return the array of temperature readings for core 1
     */
    public double[] getReadings_core_1() {
        return readings_core_1;
    }

    /***
     * Returns the array of temperature readings for core 2.
     * @return the array of temperature readings for core 2
     */
    public double[] getReadings_core_2() {
        return readings_core_2;
    }

    /***
     * Returns the array of temperature readings for core 3.
     * @return the array of temperature readings for core 3
     */
    public double[] getReadings_core_3() {
        return readings_core_3;
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
     * Prints the readings for each core for a given time. 
     */
    public void printArrays() {
        for (int i = 0; i < numberOfReadings; i++) {
            System.out.println("Time: " + times[i] + " Core 0: " + readings_core_0[i] + " Core 1: " + readings_core_1[i] + " Core 2: " + readings_core_2[i] + " Core 3: " + readings_core_3[i]);
        }
    }



}
