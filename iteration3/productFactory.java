package systemAnalysis;

public class productFactory {
	
	public RAM getRam(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount,
			String type, String multiChanel, double casLatency){
		return new RAM(productId,  productName,  stock,  unitCost,  isActive, isProductDiscount,
						type, multiChanel,  casLatency);
		
	}
	
	public Motherboard getMotherboard(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String cpuSocketType, String series, String formFactor, String memoryStandard){
		return new Motherboard(productId, productName, stock, unitCost, isActive,
				isProductDiscount, cpuSocketType, series,  formFactor, memoryStandard); 
		
	}
	
	public CPU getCPU(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String series, String CPUSocketType, double operatingFrequency){
		return new CPU( productId,  productName, stock,  unitCost, 
					isActive, isProductDiscount,  series,  CPUSocketType,  operatingFrequency);
		
	}
	
	public Monitor getMonitor(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String screenResolution, boolean curved, boolean is3d) {
        return new Monitor( productId,  productName, stock,  unitCost,  isActive,  isProductDiscount,  screenResolution, curved, is3d);
	}
}

