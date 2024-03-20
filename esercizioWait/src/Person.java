public class Person {
    private String name;
    private String surname;
    private String id;
    Person(String name, String surame, String id){
        this.name = name;
        this.surname = surame;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getId() {
        return id;
    }
    @Override
    public String toString(){
        return getName() + " " + getSurname() + " " + getId();
    }
}
