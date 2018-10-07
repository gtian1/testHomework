package practice07;

public class Klass {
    private int klass;
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
}
