import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;
import java.lang.*;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.*;



public class Bordcomputer implements BCInterface {
	String _deviceName[] = new String[3];
	// radio 0, cd 1, usb 2, 
	boolean[] installedDevices = {false, false, false};
	int playingDevice = 0;
	int volume = 0;
	public Radio device0 = null;
	public CDPlayer device1 = null;
	public USB device2 = null;
		
	public Bordcomputer() {
		
		try {
			setDevices();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	public static void main(String[] args) {
		Bordcomputer bc = new Bordcomputer();
		//bc.readConfig();
		try {
			bc.setDevices();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//bc.showOptions();
		//int randomInt = (int)(8 * Math.random());
		//System.out.println(randomInt);
		//bc.enterOptions(randomInt);
		//bc.louder(2);
		//bc.quieter(1);
		//bc.showVolume();
		//bc.next();
		//bc.prev();
		bc.play();
		//bc.changeDevice();
	}
	*/
	private void readConfig() {
		Properties prop = new Properties();
		String fileName = "C:\\Users\\allan\\eclipse-workspace\\HKP\\src\\geraete.config";
		try (FileInputStream fis = new FileInputStream(fileName)) {
		    prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		_deviceName[0] = prop.getProperty("geraete.radio");
		_deviceName[1] = prop.getProperty("geraete.cd");
		_deviceName[2] = prop.getProperty("geraete.usb");
		
		for(int i = 0; i < _deviceName.length; i++) {
			if(_deviceName[i].length() != 0) {
				
				System.out.println(_deviceName[i] + " was found.");
		    }
		}
	}
	
	private void setDevices() throws ClassNotFoundException {
		readConfig();
		
		
		for(int i = 0; i < _deviceName.length; i++) {
			if(_deviceName[i].length() != 0) {
				
				if(i == 0) {
					installedDevices[i] = true; //radio
					playingDevice = i;
					device0 = new Radio();
				}
				else if(i == 1) {
					installedDevices[i] = true; //cd
					playingDevice = i;
					device1 = new CDPlayer();
				}
				else if(i == 2) {
					installedDevices[i] = true; //usb
					playingDevice = i;
					device2 = new USB();
				}
				
				System.out.println(_deviceName[i] + " is set.");
		    }
			
		}
	}
	
	public void shutdown() {
		System.out.println("Shutting down.");
		System.exit(0);
	}
	
	public void changeDevice() {
		playingDevice++;
		if(playingDevice == installedDevices.length) {
			playingDevice = 0;
		}
		
		String[] devices = {"Radio", "CD Player", "USB Player"};
		
		System.out.println("Changing device to " + devices[playingDevice] + "...");
		
		if(installedDevices[playingDevice] == false) System.out.println(devices[playingDevice] + " not found.");
		else System.out.println(devices[playingDevice] + " is set.");
		
		
	}
	
	public void showOptions() {
		Bordcomputer bc = new Bordcomputer();
		Class c = bc.getClass();
		Method[] m = c.getDeclaredMethods();
		
		for(int i = 0; i < m.length; i++) {
			System.out.println(m[i].toString());
		}
		
	}

	public void enterOptions(int choice) {
		//choice = (int)(8 * Math.random());
		switch(choice) {
			case 0:
				System.out.println("Option Shutdown was selected.");
				shutdown();
				break;
			case 1:
				System.out.println("Option Change Device was selected.");
				changeDevice();
				break;
			case 2:
				System.out.println("Option Show Options was selected.");
				showOptions();
				break;
			case 3:
				System.out.println("Option Louder was selected.");
				louder(0);
				break;
			case 4:
				System.out.println("Option Quieter was selected.");
				quieter(0);
				break;
			case 5:
				System.out.println("Option Show Volume was selected.");
				showVolume();
				break;
			case 6:
				System.out.println("Option Next Music was selected.");
				next();
				break;
			case 7:
				System.out.println("Option Previous Music was selected.");
				prev();
				break;
			case 8:
				System.out.println("Option Play Music was selected.");
				play();	
				break;
		}
		
	}

	public void louder(int p) {
		if(volume < 100) volume += p;
		System.out.println("Volume increased by " + p +".");
	}

	public void quieter(int p) {
		if(volume > 0) volume -= p;
		System.out.println("Volume decreased by " + p +".");
	}
	
	public void showVolume() {
		System.out.println("Current volume: " + volume);
	}
	
	public void next() {
		
		if(playingDevice == 0 && installedDevices[0] == true) {
		
			device0.next();
		}
		else if(playingDevice == 1 && installedDevices[1] == true) {
		
			device1.next();
		}
		else if(playingDevice == 2 && installedDevices[2] == true) {
		
			device2.next();
		}
		
		
	}
	
	public void prev() {
		
		if(playingDevice == 0 && installedDevices[0] == true) {
			
			device0.prev();
}
		else if(playingDevice == 1 && installedDevices[1] == true) {
			
			device1.prev();
		}
		else if(playingDevice == 2 && installedDevices[2] == true) {
			
			device2.prev();
		}
		
		
	}

	public void play() {
		
		if(playingDevice == 0 && installedDevices[0] == true) {
		
			System.out.println(device0.play());
}
		else if(playingDevice == 1 && installedDevices[1] == true) {
		
			System.out.println(device1.play());
		}
		else if(playingDevice == 2 && installedDevices[2] == true) {
		
			System.out.println(device2.play());
		}
		
		
		
	}

}
