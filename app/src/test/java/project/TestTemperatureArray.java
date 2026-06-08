package project;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import edu.odu.cs.cs417.TemperatureParser.CoreTempReading;

/***
 * Test class for TemperatureArray.java.
 */
public class TestTemperatureArray {

    //Sample CoreTempReading objects and list for use in tests
    CoreTempReading reading1 = new CoreTempReading(0, new double[]{30.0, 31.0, 32.0, 33.0});
    CoreTempReading reading2 = new CoreTempReading(1, new double[]{30.5, 31.5, 32.5, 33.5});
    List<CoreTempReading> readings = List.of(reading1, reading2);


    /***
     * The Constructor should take a list of CoreTemperatureReading objects and create empty arrays the size of the list for each core.
     */
    @Test
    public void testTemperatureArrayConstructor(){
        TemperatureArray temperatureArray = new TemperatureArray(readings);
        assertThat(temperatureArray.getReadings(), is(readings));
        assertThat(temperatureArray.getNumberOfReadings(), is(2));
        assertThat(temperatureArray.getTimes().length, is(2));
    }

    /***
     * The populateArrays method should take the list of CoreTempReading objects and populate arrays for each core.
     */
    @Test
    public void testPopulateArrays() {
        TemperatureArray temperatureArray = new TemperatureArray(readings);
        temperatureArray.populateArrays();
        assertThat(temperatureArray.getTimes(), is(new int[]{0, 1}));
        assertThat(temperatureArray.getReadings_core_0(), is(new double[]{30.0, 30.5}));
        assertThat(temperatureArray.getReadings_core_1(), is(new double[]{31.0, 31.5}));
        assertThat(temperatureArray.getReadings_core_2(), is(new double[]{32.0, 32.5}));
        assertThat(temperatureArray.getReadings_core_3(), is(new double[]{33.0, 33.5}));
    }
}
