package practice09;

public class Student extends Person{
    private Klass klass;
    public Student(int wtf,String name, int age) {
        super(wtf,name, age);
    }
    public Student(int wtf,String name, int age,Klass klass){
        super(wtf,name, age);
        this.klass=klass;
    }

    @Override
    public String introduce() {
        //My name is Tom. I am 21 years old. I am a Student. I am at Class 2.
        //My name is Tom. I am 21 years old. I am a Student. I am Leader of Class 2.
        StringBuilder returStr=new StringBuilder();
        returStr.append("My name is " + getName() + ". I am " + getAge() + " years old. I am a Student. I am ");
        if(klass!=null&&klass.getLeader()!=null){
            returStr.append("Leader of Class "+getKlass().getKlass()+".");
        }else{
            returStr.append("at Class "+getKlass().getKlass()+".");
        }
        return returStr.toString();
    }

    public Klass getKlass() {
        return klass;
    }
    public boolean equals(Object obj) {
        Student student=(Student) obj;
        return student!=null&&getId()==student.getId();
    }
}
