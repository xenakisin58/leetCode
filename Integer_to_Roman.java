class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder("");
        int[] digits = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int i=0;
        while(num>0){
            int multiple = num/digits[i];
            num -= digits[i]*multiple;
            for( ; multiple > 0; multiple--){
                sb.append(roman[i]);
            }
            i++;
        }
        return sb.toString();
    }
}
