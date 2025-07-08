//java中方法参数不可以带默认值

//1.封装：对象代表什么，就要封装对应的数据，并提供数据的行为
//2.sun公司提供了JDK API 文档，其中说明了java已经提供的方法
/*3.private修饰成员只可以在本类中被调用
    一个合理的类的定义如下：
    public class GirlFriend{
    //对类的成员使用private
    private int age;
    //类的方法用public
    public void setAge(int a){
        if(a>=18 && a<=20){
            age=a;
        } else{
            System.out.println("非法数据");
        }
    }
    public int getAge(){
        return age;
    }
}
    这样的做法主要是保证成员数据的安全性，并且可以对外界传递过来的数据进行处理
 */

/*4.成员变量和局部变量  (满足低层屏高层)
    public class GirlFriend{
    private int age;       //此处age是成员变量
    public  void method(){
        int age=10;        //这里的age是局部变量
        System.out.println(age);   //如果此处要使用成员变量的age，要用this.age
      }
    }

    //因此，我们可以这样给成员的name赋值
    public void setName(String name){
        this.name=name
    }
 */

//5.构造方法
/*
基本格式：
public  class Student {
    public Student(){
        ...
    }
}
方法名和类名必需完全一致
没有返回值类型，连void都没有！！！！！！！！！！
没有具体的返回值（严禁用return）

如果没有写任何构造方法，虚拟机会自动给我们加一个空参构造方法，形如：
public Student(){

}
如果我们定义了一个构造方法，系统将不会再有无参构造，因此，在我们自定义带参构造时，我们必须也写上带参构造

我们可以自己写一个有参构造：
public Student(String name,int age){
    this.name=name;
    this.age=age;
}
在我们调用的时候，直接：
Student s=new Student("xixi",23);

自动生成构造方法的快捷键：alt+insert（如果没有反应，用alt+fn+insert）
更方便的：使用插件PTG，1s生成javabean
 */

//6.对象的内存图
/*Student s=new Student();
1.加载class文件
2.申明局部变量
3.在堆内存中开辟一个空间  new关键字完成
4.默认初始化    java中所有变量都会默认初始化为0，null等等
5.将堆内存中地址值赋值给左边的局部变量*/

//7.两个引用指向同一个对象
/*
public class Test {
    public static void main(String[] args) {
        Student s1=new Student();
        Student s2=s1;  //s2和s1指向同一个对象
                        //此处区别于：Student s2 = new Student();
                                    在堆中开辟了一个全新的s2的空间
        ...
    }
 */

//8.基本数据类型和引用数据类型
/*基本数据类型:
    byte,short,int,long,float,double,char,boolean
  引用数据类型:
    类，接口，数组
    引用数据类型的变量存储的是对象的地址值，而不是对象本身!!!!!!!!!!!!!!!
    引用数据类型的变量可以赋值为null
    引用数据类型的变量可以指向一个对象，也可以指向null
    引用数据类型的变量可以通过new关键字创建一个新的对象
 */

//9.this的内存原理
/*
    this的本质：代表方法调用者的地址值
    例如：
public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name; //此处的this代表当前对象的地址值
        this.age = age;
    }

    public void show() {
        System.out.println("Name: " + this.name + ", Age: " + this.age);
    }
    public static void main(String[] args) {
        Student s = new Student("Alice", 20);      this指向s对象，地址和s相同
        s.show(); // 调用show方法，this指向s对象
    }
 */

//10.成员变量在堆内存中，局部变量在栈内存中

