class Solution {
    public int romanToInt(String s) {
        int sz = s.length();
        int entier = 0;
        /*
        int[] key = {1, 5, 10, 50, 100, 500, 1000};
        char[] romans = { 'I',  'V', 'X', 'L', 'C', 'D', 'M'};

        Map<Character, Integer> m = new HashMap<>();

        for(int i = 0; i < romans.length; i++){
            m.put(romans[i], key[i]);
        }
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V',5);
        m.put('X',10);
        m.put('L',50);
        m.put('C',100);
        m.put('D',500);
        m.put('M',1000);
        */
        

        for(int i = 0; i < sz; i++){
            int currentVal = getVal( s.charAt(i) );
            if(i < sz - 1 && currentVal < getVal( s.charAt(i+1))){
                entier -= currentVal;
            }else{
                entier += currentVal;
            }
            //entier +=  (i < sz - 1 && currentVal < getVal( s.charAt(i+1) )) ? -currentVal : currentVal;
        }

        return entier;
    }

    private int getVal(char s){
        switch(s){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}

