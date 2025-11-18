public class SomeService {

    public void doSome(){
        System.out.println("doSome执行。");
    }

    public String doSome(String name){
        System.out.println("doSome(String name)执行。");
        return name;
    }

    public String doSome(String name, int i){
        System.out.println("doSome(String name, int i)执行。");
        return name + i;
    }
}
