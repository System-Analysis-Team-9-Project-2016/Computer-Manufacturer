package BusinessLayer.ProductClasses;

public class Desktop extends ComputerSystem {


  private boolean gamingSystem;

  public Desktop(int productId, String productName, int stock, double unitCost, boolean isActive, boolean isProductDiscount, String OS, boolean gamingSystem) {
      super(productId, productName, stock, unitCost, isActive, isProductDiscount, OS);

      this.gamingSystem = gamingSystem;
  }


  public boolean isGamingSystem() {
      return gamingSystem;
  }

  public void setGamingSystem(boolean gamingSystem) {
      this.gamingSystem = gamingSystem;
  }
  
  public double getUnitCost() {
		  if(!this.getComponents().isEmpty()){
  		  for(int i = 0; i<this.getComponents().size();i++) {
  			  unitCost = unitCost + this.getComponents().get(i).unitCost;
  		  }
	  }
	  return unitCost;
  }

}