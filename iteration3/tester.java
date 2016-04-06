import java.util.*;
class tester {
		public static void main (String args[]) {
			Desktop dansDesktop = new Desktop(123,"danTheMan",44,12.0,true,false,"Windows 7",true);
			CPU dansCPU = new CPU (1234, "thisIsMyCPU", 12, 1500.0, true, false, "I5 Series", "6 Pin socket", 3.7);
			dansDesktop.addProduct(dansCPU);
			Component tempComp = dansDesktop.getChildatIndex(0);
			String output = tempComp.getProductName();
			System.out.print(output);
		}
}