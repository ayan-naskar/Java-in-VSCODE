import java.util.Date;
public class Visit {
    private Customer customer;
    private Date date;
    private double serviceExpense, productExpense;
    
    public Visit(Customer customer, Date date) {
        this.customer = customer;
        this.date=date;
    }
    
    public String getName() {
        return customer.getName();
    }
    
    public double getServiceExpense(){
        return serviceExpense;
    }
    
    public double getProductExpense() {
        return productExpense;
    }
    
    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }
    
    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }
    
    public double getTotalExpense() {
    
        if(customer.isMember()){
            return (1.0 - DiscountRate.getServiceDiscountRate(customer.getMemberType()))*serviceExpense +
                   (1.0 - DiscountRate.getProductDiscountRate(customer.getMemberType()))*productExpense * 0.9;
        }else return serviceExpense + productExpense;
    }

    @Override
    public String toString() {
        return date+" {"+customer+"}\n[Service Expense = "+getServiceExpense()+", ProductExpense = "+getProductExpense()+", Total Expense = "+getTotalExpense()+"]";
    }
}
