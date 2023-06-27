import java.util.Date;

public class testClass {
    public static void main(String[] args) {
        Customer c=new Customer("Ayan");
        c.setMember(true);
        c.setMemberType("Gold");
        Visit visit = new Visit(c,new Date());
        visit.setServiceExpense(125.0);
        visit.setProductExpense(100.0);
        System.out.println(visit);
        Visit v=new Visit(c,new Date("10/9/2022"));
        v.setServiceExpense(500.0);
        v.setProductExpense(1000.0);
        System.out.println(v);
    }
}
