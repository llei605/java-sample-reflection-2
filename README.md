# java-sample-reflection-2

声明：本实例用于个人学习参考。所有内容均参考至网络，由本人手动敲（抄）写。请勿用于商业途径。

```
腾讯公开课
视频地址：https://www.bilibili.com/video/av15314122
```



1. 获得一个类的字节码对象有3种方法

   * 通过Object类的getClass方法； 

     ```java
     public static void main(String[] args) {
         Person p = new Person();
     
         Class class1 = p.getClass();
         System.out.println(class1);
     
         Class class2 = p.getClass();
         System.out.println(class2);
     
         System.out.println(class1 == class2); // 字节码文件在程序的一次运行中，只会被加载到内存中一次
     }
     ```

   * 通过类型.class

     ``` java
     Class class3 = Person.class;
     ```

   * 通过Class类的静态方法forName("类的全路径")

     ``` java
     Class class4 = Class.forName("com.sample.bean.Person");
     ```

2. 对象和对象的字节码

   | No.  | 对象     | 字节码        |
   | ---- | -------- | ------------- |
   | 1    | 成员变量 | Field对象     |
   | 2    | 成员方法 | Method对象    |
   | 3    | 构造方法 | Construct对象 |

3. 如何通过字节码对象来创建对象

   ```java
   Person p2 = (Person)class4.newInstance();
   ```

4. 通过Constructor对象来创建对象

   ```java
   Constructor constructor = class4.getConstructor(String.class);
   Person p3 = (Person)constructor.newInstance("tom");
   ```

   **看到54分33秒**