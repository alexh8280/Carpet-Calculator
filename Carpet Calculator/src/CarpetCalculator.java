import java.util.*;



public class CarpetCalculator implements Calculatable {
	
	float pricePerSquareFoot;
	float installationCharge;
	float percentDiscount;


	
	public CarpetCalculator(float pricePerSquareFoot) {
		this.pricePerSquareFoot = pricePerSquareFoot;
	}

	public CarpetCalculator(float pricePerSquareFoot, float installationCharge) {
		this.pricePerSquareFoot = pricePerSquareFoot;
		this.installationCharge = installationCharge;
	}
	
	static ArrayList<Integer> rooms = new ArrayList<>();

	public static void main(String[] args) {
		
		 	var carpetCalculator = new CarpetCalculator(5.00f);
	        carpetCalculator.addRoom(new Room(10, 20));
	        carpetCalculator.addRoom(new Room(20, 10));
	        System.out.println(carpetCalculator.getTotalCost());

	        var carpetCalculator2 = new CarpetCalculator(5.00F, 500.00F);
	        carpetCalculator2.addRoom(new Room(10, 20));
	        carpetCalculator2.addRoom(new Room(20, 10));
	        carpetCalculator2.addRoom(new Room(10, 10));
	        System.out.println(carpetCalculator2.getTotalCost());

	        var carpetCalculator3 = new CarpetCalculator(5.00F, 500.00F);
	        carpetCalculator3.addRoom(new Room(10, 10));
	        carpetCalculator3.addPercentDiscount(25);
	        System.out.println(carpetCalculator3.getTotalCost());


	}


	public void addRoom(Room room) {
		int area = room.width * room.length;
		rooms.add(area);
		
	}
	
	
	
	public String getTotalCost() {
		float pricePerSquareFoot = this.pricePerSquareFoot;
		float installationCharge = this.installationCharge;
		int sum = 0;
		for (Integer room : rooms) {
            sum += room;
		}
		float cost = installationCharge + (pricePerSquareFoot * sum);
		String totalCost = String.valueOf(cost);
		rooms.clear();
		return "$" + totalCost + "0";
	}

	
	public void addPercentDiscount(float percentDiscount) {
		pricePerSquareFoot = pricePerSquareFoot - ((percentDiscount/100) * pricePerSquareFoot);
		installationCharge = installationCharge - ((percentDiscount/100) * installationCharge);
	}

}