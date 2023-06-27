package all_programs;

class Method_Overloading {
    public static void main(String[] args) {
        System.out.println("Method with "+ method(1));
        System.out.println("Method with "+ method(1.0));
    }
    static String method(int data) {
        return "Integer parameter is called";
    }
    static String method(double data) {
        return "Double parameter is called";
    }
}