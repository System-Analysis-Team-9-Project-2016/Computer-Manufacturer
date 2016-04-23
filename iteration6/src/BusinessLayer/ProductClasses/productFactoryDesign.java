package BusinessLayer.ProductClasses;

public class productFactoryDesign {
	
	public CPU getCPU(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String series, String CPUSocketType, double operatingFrequency){
		return new CPU(productId, productName, stock, unitCost, isActive, isProductDiscount, series, CPUSocketType, operatingFrequency);
	}
	
	public RAM getRAM(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String type, String multiChannel, double casLatency){
		return new RAM(productId, productName, stock, unitCost, isActive, isProductDiscount, type, multiChannel, casLatency);
	}
	
	public GPU getGPU(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String memory, boolean virtualRealityReady, int displayPorts){
		return new GPU(productId, productName, stock, unitCost, isActive, isProductDiscount, memory, virtualRealityReady, displayPorts);
	}
	
	public Keyboard getKeyboard(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String keySwitchType, boolean backlit){
		return new Keyboard(productId, productName, stock, unitCost, isActive, isProductDiscount, keySwitchType, backlit);
	}
	
	public MemoryDrives getMemory(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, boolean desktopType, int driveCapacity, String RPM){
		return new MemoryDrives(productId, productName, stock, unitCost, isActive, isProductDiscount, desktopType, driveCapacity, RPM);
	}
	
	public Monitor getMonitor(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String screenResolution, boolean curved, boolean is3d){
		return new Monitor(productId, productName, stock, unitCost, isActive, isProductDiscount, screenResolution, curved, is3d);
	}
	
	public Mouse getMouse(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, int dpi, boolean programmableButtons, boolean dpiSwitching){
		return new Mouse(productId, productName, stock, unitCost, isActive, isProductDiscount, dpi, programmableButtons, dpiSwitching);
	}
	
	public Speaker getSpeaker(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, int watts, boolean desktopControls, boolean subwoofer, int satelliteSpeakers){
		return new Speaker(productId, productName, stock, unitCost, isActive, isProductDiscount, watts, desktopControls, subwoofer, satelliteSpeakers);
	}
	
	public Tablet getTablet(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String OS, boolean stylus, int screenSize, int screenRez, boolean attachableKeyboard, double weight){
		return new Tablet(productId, productName, stock, unitCost, isActive, isProductDiscount, OS, stylus, screenSize, screenRez, attachableKeyboard, weight);
	}
	
	public Laptop getLaptop(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String OS, boolean gamingLaptop, int screenSize, int screenRez, double weight){
		return new Laptop(productId, productName, stock, unitCost, isActive, isProductDiscount, OS, gamingLaptop, screenSize, screenRez, weight);
	}
	
	public Desktop getDesktop(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String OS, boolean gamingSystem){
		return new Desktop(productId, productName, stock, unitCost, isActive, isProductDiscount, OS, gamingSystem);
	}
	
	public Motherboard getMotherboard(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String cpuSocketType, String series, String formFactor, String memoryStandard){
		return new Motherboard(productId, productName, stock, unitCost, isActive, isProductDiscount, cpuSocketType, series, formFactor, memoryStandard);
	}
}

	/*public Product getComponent(String productType){

		if(productType.equals(null))
			return null;
		if(productType.equals("CPU")){
			return new CPU(0, productType, 0, 0, false, false, productType, productType, 0);
		}
		else if(productType.equals("RAM")){
			return new RAM(0, productType, 0, 0, false, false, productType, productType, 0);
		}
		else if (productType.equals("GPU")){
			return new GPU(0, productType, 0, 0, false, false, productType, false, 0);
		}
		
		return null;
	}	
}*/
