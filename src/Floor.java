import java.util.Scanner;

public class Floor {
    private static int totalFloors = 0;
    private Flat [] flats = new Flat[4]; // 4 flats for per floor
    private Building building;
    private String color;
    private int flatCounter = 0;

    public static int getTotalFloors() {
        return totalFloors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Building getBuilding() {
        return building;
    }

    public  void addFlat(Flat flat){
        boolean isAddAble = true;
        if( flatCounter < flats.length){
            for (Flat flat1 : flats){
                if(flat.equals(flat1)){
                    System.out.printf("%s is already in %s.%n",flat.getFlatId(),getColor());
                    isAddAble = false;
                    break;
                }
                else if ( flat1 != null && flat.getFlatId().equals(flat1.getFlatId())) {
                    Scanner scan = new Scanner(System.in);
                    System.out.printf("%s was already taken please re-enter: ",flat.getFlatId());
                    flat.setFlatId(scan.nextLine());
                    addFlat(flat);

                }
            }
            if(isAddAble){
                //flat.setFloor();
                flats[flatCounter] = flat;
                flatCounter++;
                System.out.printf("%s is added in floor %s %n",flat.getFlatId(),color);
            }
        }
    }
    public void showAllFlats(){
        for (Flat flat : flats){
            if(flat != null)
                System.out.printf("Flat ID: %s\t\tFloor: %s%n",flat.getFlatId(),color);
            //else System.out.println("Flat is null");
        }
    }

    public Floor(Building building, String color) {
        Floor floor1 = new Floor(color);
        building.addFloor(floor1);
        this.building = building;
        this.color = floor1.getColor();
        totalFloors++;
    }
    private Floor(String color){
        this.color = color;
    }
}
