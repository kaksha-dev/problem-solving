package com.chitkara.uca;

public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        t.callCar(new Car());
        t.callCar(new Maruti());
        t.callCar(new Mercedez());
    }

    public void callCar(Car c) {
        System.out.println(c.hashCode());
        System.out.println(c.getClass().getName());
        c.m1();
        c.m2();

        if (c instanceof Maruti) {
            Maruti m = (Maruti) c;
            System.out.println(m.hashCode());
            m.m1();
            m.m2();
            m.m3();
        } else {
            System.out.println("I am not maruti but i am " + c.getClass().getName());
        }
    }
}
