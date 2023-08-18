package utils;

import edu.wpi.first.hal.HAL;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Rename class to match the feature
public class SubsystemFeatureTestTemplate {
    // Add the subsystem and hardware objects here

    @BeforeEach
    void setup() {
        assert HAL.initialize(500, 0); // initialize the HAL, crash if failed

        // Create our sim hardware and subsystem here
        
    }

    @SuppressWarnings("PMD.SignatureDeclareThrowsException")
    @AfterEach
    void shutdown() throws Exception {
        // Typically don't need anything in here
    }

    // Sample test case for exceptions
    // Change the test name to make sense in context
    @Test
    public void testMethod_withInvalidInputs_expectSomeException() {
        // Put input values here (includes variables and mocks)

        // Call replayHardware() here on your hardware object

        // Run method here and expect an exception
        assertThrows(Exception.class, // Change the exception class to the specific one we expect the code to throw
                () -> Math.abs(0)); // Change the call after the () -> to the method under test

        // Call varifyHardware() on your hardware object
        
    }

    // Sample normal test case
    // Change the test name to make sense in context
    @Test
    public void testMethod_withValidInputs_expectSomeOutput() {
        // Put input values here (includes variables and mocks)

        // Call replayHardware() here on your hardware object

        // Run method here and make assertions on what happens
        // For different types of assertions, type assert and look at options

        // Call varifyHardware() on your hardware object
        
    }
}
