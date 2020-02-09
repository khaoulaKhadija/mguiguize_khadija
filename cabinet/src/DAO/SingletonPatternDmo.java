package DAO;

public class SingletonPatternDmo {
    public static void main(String args[]){
        SingleObject object=SingleObject.getInstance();
        object.showMessage();
    }
}
