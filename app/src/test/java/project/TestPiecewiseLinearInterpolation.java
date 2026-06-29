package project;

import java.io.File;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.odu.cs.cs417.TemperatureParser.CoreTempReading;

/***
 * Test class for PiecewiseLinearInterpolation.
 */
public class TestPiecewiseLinearInterpolation {

    //Sample CoreTempReading objects and list for use in tests
    CoreTempReading reading1 = new CoreTempReading(0, new double[]{30.0, 31.0, 32.0, 33.0});
    CoreTempReading reading2 = new CoreTempReading(1, new double[]{30.5, 31.5, 32.5, 33.5});
    List<CoreTempReading> readings = List.of(reading1, reading2);
    TemperatureArray temperatureArray = new TemperatureArray(readings);
    String inputFileName = "sample-input.txt";

    /***
     * The constructor should take an array of temperatures, the array of times, the input file name and the core number and initialize them. 
     */
    @Test 
    public void testConstructor(){
        temperatureArray.populateArrays();
        PiecewiseLinearInterpolation piecewiseLinearInterpolation = new PiecewiseLinearInterpolation(temperatureArray.getReadings_core_0(), temperatureArray.getTimes(), inputFileName, 0);
        assertThat(piecewiseLinearInterpolation.getReadingsForCore(), is(new double[]{30.0, 30.5}));
        assertThat(piecewiseLinearInterpolation.getTimes(), is(new double[]{0, 1}));
        assertThat(piecewiseLinearInterpolation.getInputFileName(), is("sample-input.txt"));
        assertThat(piecewiseLinearInterpolation.getCoreNumber(), is(0));
    }

    /***
     * The method writeOutputFile should create an output file with a name that uses the input file name and the core number specified.
     */
    @Test
    public void testOutputFileExists(){
        temperatureArray.populateArrays();
        PiecewiseLinearInterpolation piecewiseLinearInterpolation = new PiecewiseLinearInterpolation(temperatureArray.getReadings_core_0(), temperatureArray.getTimes(), inputFileName, 0);
        piecewiseLinearInterpolation.writeOutputFile();
        File outputFile = new File("sample-input-core-00.txt");
        assertTrue(outputFile.exists());
    }



}
