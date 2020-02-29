public class Test {
    int x=-11;
    void setX(int x){
        this.x=x;
    }
    int getX(){
        return x;
    }

    public static void main(String[] str){
        Test t=new Test();
        t.setX(Math.abs(t.getX()));
        System.out.println(t.x);
    }
}
