import java.lang.reflect.Constructor;

import com.sample.bean.Person;

/**
 * Demo01
 */
public class Demo01 {

    public static void main(String[] args) throws Exception {
        
        Person p = new Person();

        // 1-1. 通过Object类的getClass方法；
        Class class1 = p.getClass();
        Class class2 = p.getClass();

        System.out.print("class1 == class2 => ");
        System.out.println(class1 == class2); // 字节码文件在程序的一次运行中，只会被加载到内存中一次


        // 1-2. 通过类型.class
        Class class3 = Person.class;
        System.out.print("class2 == class3 => ");
        System.out.println(class2 == class3);

        System.out.print("int.class => ");
        System.out.println(int.class);


        // 1-3. 通过Class类的静态方法forName("类的全路径")
        Class class4 = Class.forName("com.sample.bean.Person");
        System.out.print("class3 == class4 => ");
        System.out.println(class3 == class4);

        // 2-1. 通过字节码对象来创建对象
        Person p2 = (Person)class4.newInstance(); // newInstance()返回的是Object对象，因此需要强转

        // 2-2. 通过构造方法来创建对象 (一般用于传参时)
        Constructor constructor = class4.getConstructor(String.class);
        Person p3 = (Person)constructor.newInstance("tom");

        // 2-3. 获得对象的所有（公共+私有）属性或方法
        Constructor constructor2 = class4.getDeclaredConstructor(Integer.class);
        constructor2.setAccessible(true);
        Person p4 = (Person)constructor2.newInstance(12);
        System.out.println("p4 => " + p4);

        // 2-4. 获得所有对象或方法
        Constructor[] constructor3 = class4.getConstructors();
        for (Constructor var : constructor3) {
            System.out.print("var => ");
            System.out.println(var);
        }
        Constructor[] constructor4 = class4.getDeclaredConstructors();
        for (Constructor var2 : constructor4) {
            System.out.print("var2 => ");
            System.out.println(var2);
        }

    }
}