public class Customer {
    private String name, memberType;
    private boolean member = false;
    
    public Customer(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public boolean isMember() {
        return member;
    }
    
    public void setMember(boolean member) {
        this.member=member;
    }
    
    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
    
    @Override
    public String toString() {
        System.out.println("hmm");
        return "{Name : "+name+", Type : "+memberType+"} = "+member;
    }
}
