class A {

    static {

        System.out.print("1");

    }

    public A() {

        System.out.print("2");

    }

}

class B extends A {

    static {

        System.out.print("a");

    }

    public B() {

        System.out.print("b");

    }

}

public class Hello {

    public static void main(String[] ars) {

        A ab = new B();

        ab = new B();

    }

} 