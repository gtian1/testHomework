package practice09;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int klass;
    private Student leader;
    private List<Student> studentList=new ArrayList<>();
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
        if(this.studentList.contains(leader)){
            this.leader=leader;
        }else {
            System.out.print("It is not one of us.\n");
        }
    }

    public Student getLeader() {
        return leader;
    }

    public void appendMember(Student student) {
        studentList.add(student);
    }

}
