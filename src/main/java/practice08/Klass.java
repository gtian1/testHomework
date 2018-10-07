package practice08;

public class Klass {
    private int klass;
    private Student leader;
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
        this.leader=leader;
    }

    public Student getLeader() {
        return leader;
    }
}
