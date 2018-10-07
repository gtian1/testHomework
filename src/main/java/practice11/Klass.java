package practice11;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Klass {
    private int klass;
    private Student leader;
    private List<Student> studentList=new ArrayList<Student>();
    private Teacher teacher;
    public Klass(int klass) {
        this.klass=klass;
    }

    public int getKlass() {
        return klass;
    }

    public int getNumber() {
        return 2;
    }

    public String getDisplayName() {
        return "Class "+klass;
    }

    public void assignLeader(Student leader) {
        //It is not one of us.
        if(studentList.contains(leader)){
            this.leader=leader;
            if (teacher!=null)
                out.print("I am "+teacher.getName()+". I know "+leader.getName()+" become Leader of Class "+klass+".\n");
        }else{
            out.print("It is not one of us.\n");
        }
    }

    public Student getLeader() {
        return leader;
    }

    public void appendMember(Student student) {

        studentList.add(student);
        if(student!=null&&teacher!=null){
            out.print("I am "+teacher.getName()+". I know "+student.getName()+" has joined Class "+klass+".\n");
        }
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
