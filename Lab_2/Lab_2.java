package Lab_2;

public class Lab_2 {
    public static void main(String[] args) {
        System.out.println(args[0]);
        StringBuffer sb = new StringBuffer(args[0]);
        System.out.println(sb.length());
        //12(34)56
        //01234567
        int j=0;
        for(int i=0; i < sb.length(); ++i){
            if(sb.charAt(i)=='('){
                j = i;
                ++j;
                while((j<sb.length())&&(sb.charAt(j)!=')')&&(sb.charAt(j)!='(')){
                    ++j;
                }
                if(sb.charAt(j)==')'){
                    sb.delete(i, (j+1));
                } else {
                    i = j;
                    --i;
                }
            }
        }
        System.out.println(sb);
    }
}
