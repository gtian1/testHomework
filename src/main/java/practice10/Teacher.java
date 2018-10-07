package practice10;

import java.util.Collection;
import java.util.LinkedList;

public class Teacher extends Person{
    private Klass klass;
    private  LinkedList<Klass> linkedList;
    public Teacher(int id,String name, int age,Klass klass){
        super(id,name, age);
        this.klass=klass;
    }

    public Teacher(int id, String name, int age) {
        super(id,name,age);
    }

    public Teacher(int id, String name, int age, LinkedList<Klass> linkedList) {
        super(id,name,age);
        this.linkedList=linkedList;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        //My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2, 3.
        //My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.
        String retureStr="My name is "+getName()+". I am "+getAge()+" years old. I am a Teacher. I teach";
        if(linkedList!=null&&!linkedList.isEmpty()){
            retureStr=retureStr+" Class ";
            for (Klass linkedList:linkedList
                 ) {
                retureStr+=linkedList.getKlass()+", ";
            }
            retureStr=retureStr.substring(0,retureStr.length()-2)+'.';
        }else{
            retureStr=retureStr+" No Class.";
        }
        return retureStr;
    }

    public String introduceWith(Student jerry) {
        //My name is Tom. I am 21 years old. I am a Teacher. I teach Jerry.
        //My name is Tom. I am 21 years old. I am a Teacher. I don't teach Jerry.
        boolean isNoTeach=this.isNoTeach(jerry);
        return "My name is "+getName()+". I am "+getAge()+" years old. I am a Teacher. I "+(jerry.getKlass()==getKlass()||!isNoTeach?"":"don't ")+"teach Jerry.";
    }
    private boolean isNoTeach(Student jerry){
        boolean isNoTeach=true;
        if(linkedList!=null&&!linkedList.isEmpty()){
            for (Klass klass:linkedList
            ) {
                if(jerry.getKlass().getKlass()==klass.getKlass()){
                    isNoTeach=false;
                    break;
                }

            }

        }
        return isNoTeach;
    }
    public LinkedList<Klass> getClasses() {
        return linkedList;
    }

    public boolean isTeaching(Student jerry) {
        boolean isNoTeach=this.isNoTeach(jerry);
        return (jerry!=null&&jerry.getKlass()!=null&&klass!=null&&jerry.getKlass().getKlass()==klass.getKlass()||!isNoTeach);
    }
}
