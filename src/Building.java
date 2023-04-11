import java.util.Scanner;

public class Building {
    private static int totalBuilding = 0;
    private Floor [] floors = new Floor[10]; // Max 10 floors allowed to live in this apartments
    private String name;
    private  String buildingNo;
    private int floorCounter = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public int getFloorCounter() {
        return floorCounter;
    }

    public static int getTotalBuilding() {
        return totalBuilding;
    }

    public Floor[] getFloors() {
        return floors;
    }

    public  void addFloor(Floor floor){
        boolean isAddAble = true;
        if( floorCounter < floors.length){
            for (Floor floor1 : floors){
                if(floor.equals(floor1)){
                    System.out.printf("%s is already in %s.%n",floor.getColor(),getName());
                    isAddAble = false;
                    break;
                }
                else if ( floor1 != null && floor.getColor().equals(floor1.getColor())) {
                    Scanner scan = new Scanner(System.in);
                    System.out.printf("Color %s was already taken please re-enter: ",floor.getColor());
                    floor.setColor(scan.nextLine());
                    addFloor(floor);

                }
            }
            if(isAddAble){
                //flat.setFloor();
                floors[floorCounter] = floor;
                floorCounter++;
                System.out.printf("Floor %s is added in building %s %n",floor.getColor(),getName());
            }
        }
    }
    public void showAllFloors(){
        for (Floor floor : floors){
            if(floor != null)
                System.out.printf("Floor color: %s\t\tBuilding: %s%n",floor.getColor(),getName());
            //else System.out.println("Floor is null");
        }
    }
    public Building(String name, String buildingNo) {
        this.name = name;
        this.buildingNo = buildingNo;
        totalBuilding++;
    }
}
