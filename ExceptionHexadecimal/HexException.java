public class HexException extends Exception {
    String message;
    HexException(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        return "HexException: "+message;
    }
}
