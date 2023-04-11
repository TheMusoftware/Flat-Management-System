public class Flat {
    private static int totalFlat = 0;
    Person [] persons = new Person[10];// Max 10 people allowed to live in this flats
    private int peopleCounter  = 0;
    private Floor floor;
    private Building building;
    private String flatId;

    public static int getTotalFlat() {
        return totalFlat;
    }

    public Floor getFloor() {
        return floor;
    }

    public Building getBuilding() {
        return building;
    }

    public String getFlatId() {
        return flatId;
    }


    public void setFlatId(String flatId) {
        this.flatId = flatId;
    }

    public void addPerson(Person person){
        boolean isAddAble = true;
        if( peopleCounter < persons.length){
            for (Person person1 : persons){
                if(person.equals(person1)){
                    System.out.printf("%s is already lived here.%n",person.getFullName());
                    isAddAble = false;
                    break;
                }
            }
            if(isAddAble){
                person.setAddress(flatId + " " + floor.getColor() + " " +building.getName() + " " + building.getBuildingNo() );
                persons[peopleCounter] = person;
                peopleCounter++;
                System.out.printf("%s is added in %s %n",person.getFullName(),flatId);
            }
        }
    }
    public void showAllPeople(){
        for (Person person : persons){
            if(person!=null)
                System.out.printf("Name: %s\t\tAge: %d%n",person.getFullName(),person.getAge());
        }
    }

    public Flat(Floor floor, String flatId) {
        Flat flat = new Flat(flatId);
        this.floor = floor;
        this.flatId = flatId;
        this.building = floor.getBuilding();
        floor.addFlat(flat);
        totalFlat++;
    }
    private Flat(String flatId){
        this.flatId = flatId;
    }

}
