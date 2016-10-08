import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;

import java.io.IOException;

public class FirmataSingleton {

    private final static int PIN = 13;

    private final static int DELAY = 500;

    private final static int HIGH = 1;

    private final static int LOW = 0;

    private final static String PORT = "COM3";

    private final static String READY = "device is now ready!";

    private final static String FOR_PIN = "Pin 13 set to Output mode.";

    private final static String PIN_HIGH = "Pin 13 set to logic HIGH.";

    private static FirmataSingleton firmataSingleton;

    private static IODevice device;

    private FirmataSingleton() {}

    public static FirmataSingleton getInstance() {
        if(firmataSingleton == null)
            firmataSingleton = new FirmataSingleton();
        return firmataSingleton;
    }

    public void startDevice() {
        device = new FirmataDevice(PORT);

        try {
            device.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!device.isReady()) {

        }
        System.out.println(READY);
    }

    public void setPin() {
        try {
            device.getPin(PIN).setMode(Pin.Mode.OUTPUT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(FOR_PIN);
    }


    public void loopAndCheck() {

        try {
            for (;;) {
                device.getPin(PIN).setValue(HIGH);
                Thread.sleep(DELAY);
                device.getPin(PIN).setValue(LOW);
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(PIN_HIGH);

    }

}
