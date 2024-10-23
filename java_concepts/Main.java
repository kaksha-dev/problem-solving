import com.sun.nio.zipfs.ZipInfo;

public class Main {
    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(s.getClass().getClassLoader());
        System.out.println(s.getClass().getResource("String.class"));
        System.out.println(s.getClass().getResource("ZipInfo.class"));
        System.out.println(s.getClass().getResource("Student.class"));
        ZipInfo z = new ZipInfo();
        System.out.println(z.getClass().getClassLoader());
        System.out.println(z.getClass().getResource("String.class"));
        System.out.println(z.getClass().getResource("ZipInfo.class"));
        System.out.println(z.getClass().getResource("Student.class"));

        Student student = new Student(1, "a", 1.2f);
        System.out.println(student.getClass().getClassLoader());
        System.out.println(student.getClass().getResource("String.class"));
        System.out.println(student.getClass().getResource("ZipInfo.class"));
        System.out.println(student.getClass().getResource("Student.class"));


    }

}