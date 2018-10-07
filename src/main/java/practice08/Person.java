package practice08;

public class Person {
    private String name;
    private int age;
    private int id;
    public Person(String name, int age) {
        this.name=name;
        this.age=age;
    }

    public Person(int id, String name, int age) {
        this.age=age;
        this.name=name;
        this.id = id;
    }


    public String introduce() {
        return "My name is "+ name +". I am "+age+" years old.";
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean equals(Object obj) {
        Person person=(Person) obj;
        return id==person.getId();
    }
}
