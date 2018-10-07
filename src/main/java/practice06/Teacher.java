package practice06;

public class Teacher extends Person{
    private int klass;
    public Teacher(String name, int age, int klass) {
        super(name,age);
        this.klass=klass;
    }

    public Teacher(String name, int age) {
        super(name,age);
    }

    public int getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        return "My name is "+getName()+". I am "+getAge()+" years old. I am a Teacher. I teach "+(getKlass()==0?"No Class.":"Class "+getKlass()+".");
    }
}
