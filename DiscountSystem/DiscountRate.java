public class DiscountRate {
    private static double serviceDiscountPremium = 0.2, 
    serviceDiscountGold = 0.15,
    serviceDiscountSilver = 0.1,
    productDiscountPremium = 0.1, 
    productDiscountGold = 0.1,
    productDiscountSilver = 0.1;

    public static double getServiceDiscountRate(String type){
        switch(type){
            case "Premium":
                return serviceDiscountPremium;
            case "Gold":
                return serviceDiscountGold;
            case "Silver":
                return serviceDiscountSilver;
            default:
                return 0.0;
        }
    }

    public static double getProductDiscountRate(String type){
        switch(type){
            case "Premium":
                return productDiscountPremium;
            case "Gold":
                return productDiscountGold;
            case "Silver":
                return productDiscountSilver;
            default:
                return 0.0;
        }
    }
}