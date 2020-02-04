package cn.itcast.day06.demo04;

/*
构造方法是专门用来创建对象的方法，当我们通过关键字new来创建对象时，其实就是在调用构造方法。
格式：
public 类名称(参数类型 参数名称) {
    方法体
}

注意事项：
1. 构造方法的名称必须和所在的类名称完全一样，就连大小写也要一样
2. 构造方法不要写返回值类型，连void都不写
3. 构造方法不能return一个具体的返回值
4. 如果没有编写任何构造方法，那么编译器将会默认赠送一个构造方法，没有参数、方法体什么事情都不做。
public Student() {}
5. 一旦编写了至少一个构造方法，那么编译器将不再赠送。
6. 构造方法也是可以进行重载的。
重载：方法名称相同，参数列表不同。
 */
public class Student {

    // 成员变量
    private String name;
    private int age;

    // 无参数的构造方法
    public Student() {
        System.out.println("无参构造方法执行啦！");
    }

    // 全参数的构造方法
    public Student(String name, int age) {
        System.out.println("全参构造方法执行啦！");
        this.name = name;
        this.age = age;
    }

    // Getter Setter
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

}
