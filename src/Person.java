public class Person {
    private static int totalPeople = 0;
    private String fullName;
    private int age;
    private String address = "There is no address.";

    public static int getTotalPeople() {
        return totalPeople;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void showPersonInfo(){
        System.out.println("Name: "+getFullName());
        System.out.println("Age: "+getAge());
        System.out.println("Address: "+getAddress());
    }

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
        totalPeople++;
    }
}
