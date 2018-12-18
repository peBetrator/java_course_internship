package com.endava.straus.atf.enums;

public enum Browser {
    FIREFOX("webdriver.gecko.driver"),
    CHROME("webdriver.chrome.driver"),
    INTERNETEXPLORER("webdriver.ie.driver");

    private final String driverProperty;

    Browser(String driverProperty) {
        this.driverProperty = driverProperty;
    }

    public String getDriverProperty() {
        return driverProperty;
    }
}