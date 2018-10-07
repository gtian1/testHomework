package practice07;

public class Teacher extends Person{
    private Klass klass;
    public Teacher(String name, int age, Klass klass) {
        super(name,age);
        this.klass=klass;
    }

    public Teacher(String name, int age) {
        super(name,age);
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        //"My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.
        return "My name is "+getName()+". I am "+getAge()+" years old. I am a Teacher. I teach "+((getKlass()!=null)&&(getKlass().getKlass()!=0)?"Class "+getKlass().getKlass()+".":"No Class.");
    }

    public String introduceWith(Student jerry) {
        return "My name is "+getName()+". I am "+getAge()+" years old. I am a Teacher. I "+(jerry.getKlass().getKlass()==getKlass().getKlass()?"":"don't ")+"teach Jerry.";
    }
}
