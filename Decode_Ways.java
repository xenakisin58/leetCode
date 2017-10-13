class Solution {
    public boolean checkOne(char one){
        return (one != '0');
    }
    public boolean checkTwo(char one, char two){
        return (one == '1' || (one == '2' && two <='6'));
    }
    
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0)=='0')
            return 0;
        if(s.length()==1) {
            if (checkOne(s.charAt(0)))
                return 1;
            else
                return 0;
        }
        
        int fn=0, fn_1=0, fn_2=1;
        if (checkOne(s.charAt(0)) && checkOne(s.charAt(1)))
            fn_1++;
        if(checkTwo(s.charAt(0), s.charAt(1)))
            fn_1++;

        for(int i=2; i< s.length(); i++) {    
            if(checkOne(s.charAt(i)))
                fn+= fn_1;
            if(checkTwo(s.charAt(i-1), s.charAt(i)))
                fn+=fn_2;
            if(fn == 0)
                return 0;
            fn_2 = fn_1;
            fn_1 = fn;
            fn=0;
        }
        return fn_1;  
    }
}
