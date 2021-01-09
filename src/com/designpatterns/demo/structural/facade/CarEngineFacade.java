package com.designpatterns.demo.structural.facade;

public class CarEngineFacade {
    private static int DEFAULT_COOLING_TEMP = 24;
    private static int STOPPED_COOLING_TEMP = 30;
    private FuelPump fuelPump = new FuelPump();
    private Ignition ignition = new Ignition();
    private AirConditioner ac = new AirConditioner();
    private Dashboard dashboard = new Dashboard();

    public static void main() {
        CarEngineFacade carEngineFacade = new CarEngineFacade();
        carEngineFacade.startEngine();
        carEngineFacade.stopEngine();
    }

    public void startEngine() {
        fuelPump.start();
        ignition.start();
        ac.setCoolingTemp(DEFAULT_COOLING_TEMP);
        dashboard.turnOnTachometer();
    }

    public void stopEngine() {
        fuelPump.stop();
        ignition.stop();
        ac.setCoolingTemp(STOPPED_COOLING_TEMP);
        dashboard.turnOffTachometer();
    }

    private class FuelPump {
        public void start() {}
        public void stop() {}
    }

    private class Ignition {
        public void start() {}
        public void stop() {}
    }

    private class AirConditioner {
        public void setCoolingTemp(int temp) {}
    }

    private class Dashboard {
        public void turnOnTachometer() {}
        public void turnOffTachometer() {}
    }
}
