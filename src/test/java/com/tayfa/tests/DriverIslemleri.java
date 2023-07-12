package com.tayfa.tests;

import com.tayfa.utilities.Driver;
import org.testng.annotations.Test;

public class DriverIslemleri {

    @Test
    public static void driverISlemleri(){
        Driver.getDriver().get("https://www.amazon.com");

        

    }
}
