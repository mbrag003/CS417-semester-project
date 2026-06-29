package project;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/***
 * Takes the list of CoreTempReading arrays created in TermperatureArray.java and creates piecewise linerar interpolation equations dor each CPU core's temperature readings and write those equations to seperate
 * output files. 
 */
public class PiecewiseLinearInterpolation {

    private double[] times;
    private double[] readingsForCore;
    private String inputFileName;
    private int coreNumber;


    /***
     * Constructor for the PiecewiseLinearInterpolation class. Takes the readings for a certain core, the input file name, and the core number and initialized them. 
     * @param readingsForCore the list of temperature readings for a certain core
     * @param inputFileName the input file name that contains the temperature readings
     * @param coreNumber the specific core the readings belong to
     */
    public PiecewiseLinearInterpolation(double[] readingsForCore, double[] times, String inputFileName, int coreNumber){
        this.readingsForCore = readingsForCore;
        this.times = times;
        this.inputFileName = inputFileName;
        this.coreNumber = coreNumber;
    }

    /***
     * Returns the readings for the core.
     * @return the readings for the core
     */
    public double[] getReadingsForCore(){
        return readingsForCore;
    }

    /***
     * Returns the times that the temperature readings taken.
     * @return the times that the temperate readings taken. 
     */
    public double[] getTimes(){
        return times;
    }

    /***
     * Returns the input file name.
     * @return the input file name
     */
    public String getInputFileName(){
        return inputFileName;
    }

    /***
     * Returns the core number.
     * @return the core number. 
     */
    public int getCoreNumber(){
        return coreNumber;
    }

    /***
     * This method builds the output file name based on the input file name and the core number that was given when the class was initialized. 
     * The names are based on the sample output provided in Semester Project - Piecewise Linear Interpolation on canvas. 
     * @return the output file name
     */
    private String buildOutputFileName(){

        // This code was adapted from Approach 1 of "Program to Get the file extension in Java" from Geeks for Geeks found at https://www.geeksforgeeks.org/java/how-to-get-the-file-extension-in-java/.
        int dotIndex = inputFileName.lastIndexOf(".");
        String fileName = (dotIndex > 0) ? inputFileName.substring(0, dotIndex) : "";

        if (coreNumber == 0){
            return fileName + "-core-00.txt";
        }
        else if (coreNumber == 1){
            return fileName + "-core-01.txt";
        }
        else if (coreNumber == 2){
            return fileName + "-core-02.txt";
        }
        else if (coreNumber == 3){
            return fileName + "-core-03.txt";
        }

        return "";

    }

    /***
     * Returns value of x in the equation y = mx + b based on the array of times provided for the core readings. 
     * @param k an integer from 0 to the size of the times array
     * @return the time from the array
     */
    private double getX(int k){
        return times[k];
    }

    /***
     * Returns value of y in the equation y = mx + b based on the array of temperature readings provided for the core. 
     * @param k an integer from 0 to the size of the times array
     * @return the temperature reading from the array
     */
    private double getY(int k){
        return readingsForCore[k];
    }

    /***
     * Calculates slope using the equation m = (y1-y0)/ (x1-x0).
     * @param x0 time 1
     * @param x1 time 2 
     * @param y0 temperature reading corresponding to time 1
     * @param y1 temperature reading corresponding to time 2
     * @return the value of the slope between those two points
     */
    private double getM(double x0, double x1, double y0, double y1){
        return (y1 - y0)/(x1 - x0);
    }

    /***
     * Calculates the y intercept of the line using the equation b = y - m*x.
     * @param x the time
     * @param y the temperature reading corresponding to the time
     * @param m the slope of the line
     * @return the y intercept of the line
     */
    private double getB(double x, double y, double m){
        return y - m*x;
    }


    /***
     * Builds the string for the output file based on the temperature reading in the array.
     * @param k an interger from 0 to the size of the times array
     * @return a string for the output file for that specific pair of times
     */
    private String buildLine(int k){
        double x0 = getX(k);
        double x1 = getX(k+1);
        double y0 = getY(k);
        double y1 = getY(k+1);
        double m = getM(x0, x1, y0, y1);
        double b = getB(x0, y0, m);

        return String.format("%8.0f <= x <= %8.0f ; y = %12.4f + %12.4f x ; interpolation", x0, x1, b, m);

    }

    /***
     * Creates the output file for the core. 
     */
    public void writeOutputFile() {
        String outputFileName = buildOutputFileName();

        try (PrintWriter out = new PrintWriter(outputFileName)){
            for (int k = 0; k < readingsForCore.length - 1; k++){
                out.println(buildLine(k));
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Error: could not write to " + outputFileName);
        }
    }
}
