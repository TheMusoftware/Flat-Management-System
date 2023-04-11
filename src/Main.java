import java.util.Scanner;

public class Main {
    static Building [] allBuildings = new Building[10];
    public static void showAllBuildings(){
        for(Building builded : allBuildings){
            if(builded != null){
                System.out.printf("Building name : %s%n",builded.getName());
            }
        }
    }
    public static void showAll(){
        System.out.printf("Total Buildings : %d%nTotal Floors : %d%nTotal Flats : %d%nTotal People: %d",Building.getTotalBuilding(),Floor.getTotalFloors(),Flat.getTotalFlat(),Person.getTotalPeople());

    }
    public static void main(String[] args) {
        showAll();
        Person person = new Person("Mustafa",21);
        Building building = new Building("White House","01/A");
        Floor blue = new Floor(building,"blue");
        Floor blue2 = new Floor(building,"blue");
        Flat flat = new Flat(blue,"CL19");
        Flat flat2 = new Flat(blue,"CL19");
        flat.addPerson(person);
        flat.addPerson(person);
        blue.showAllFlats();
        building.showAllFloors();
        person.showPersonInfo();
        showAll();



    }
}