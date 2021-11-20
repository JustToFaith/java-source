package cn.personalweb.test;

/**
 * @program: JavaSourceLearn
 * @description:
 * @author: lizheng
 * @create: 2020-11-28 20:20
 **/
public class User implements Cloneable{
    private String name;
    private String sex;
    private int age;
    private int phoneNumber;

    public User() {
    }

    public User(String name, String sex, int age, int phoneNumber) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


