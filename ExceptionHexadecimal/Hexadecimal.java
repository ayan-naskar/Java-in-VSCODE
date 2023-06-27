public class Hexadecimal{
    private String val;

    Hexadecimal(){
        val = "0";
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) throws HexException {
        int i=0;
        char[] cpy = val.toCharArray();
        val = val.toUpperCase();
        for(char ch : val.toCharArray()){
            if(!Character.isDigit(ch)){
                if(!(ch>='A' && ch<='F'))
                    throw new HexException("Invalid Hexadecimal digits ["+cpy[i]+" at position : "+(i+1)+"]");
            }
            i++;
        }
        this.val = val;
    }

    @Override
    public String toString(){
        return val;
    } 

    public void convertDecimalToHex(int deci) throws HexException {
        String val = "";
        while(deci>0){
            int n=0;
            for(int i=0;i<4;i++){
                n=n|((deci&1)<<i);
                deci = deci >> 1;
            }
            if(n<10) val = n + val;
            else val = (char)(n+'A') + val;
            // System.out.println(n+"   "+val);
            // System.out.println(Integer.toBinaryString(n));
        }
        if(val.equals("")) val=this.val;
        setVal(val);
    }

    public int getDecimal() {
        char[] v = val.toCharArray();
        int i,d=0,ch;
        for(i=0;i<v.length;i++){
            d=d<<4;
            ch = (v[i]>='A')?v[i]-'A':v[i]-'0';
            d=d|ch;
        }
        return d;
    }
}