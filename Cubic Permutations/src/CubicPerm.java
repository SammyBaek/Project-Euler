import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by kie827 on 8/16/2016.
 */
public class CubicPerm {
    public static void main(String[] args) {
        final int TARGET_NUMBER = 5;
        ArrayList<Permutatation> [] list = new ArrayList [1000];
        all:
        for (int i = 1 ; i < 100000 ; i ++){
            Permutatation p = new Permutatation(i);
            int index = p.getIndex();
            if (list[index] == null)
                list[index] = new ArrayList<Permutatation>();
            boolean found = false;
            for (Permutatation perm : list[index])
                if (perm.equals(p)){
                    perm.list.add(i);
                    found = true;
                    break;
                }
            if (!found)
                list[index].add(p);
        }

        for (int i = 0 ; i < list.length ; i ++){
            if (list[i] == null)
                continue;
            ArrayList<Permutatation> perm = list[i];
            for (Permutatation p : perm){
                if (p.list.size() == TARGET_NUMBER){
                    System.out.println(p.list);
                }
            }
        }
    }
}

class Permutatation{
    int[] digits = new int[10];
    ArrayList<Integer> list = new ArrayList<Integer>();
    public Permutatation(int num){
        BigInteger big = new BigInteger(Integer.toString(num)).multiply(new BigInteger(Integer.toString(num)))
                .multiply(new BigInteger(Integer.toString(num)));
        String str = big.toString();
        for (int i = 0 ; i < str.length() ; i ++)
            digits[Integer.parseInt(str.substring(i, i+1))]++;
        list.add(num);
    }

    // my version of "hashing"
    public int getIndex(){
        int index = 0;
        for (int i = 0 ; i < digits.length ; i ++)
            index += i * digits[i];
        return index;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Permutatation))
            return false;
        Permutatation other = (Permutatation) o;
        if (this.digits.length != other.digits.length)
            return false;
        for (int i = 0 ; i < digits.length ; i ++)
            if (this.digits[i] != other.digits[i])
                return false;
        return true;
    }

    @Override
    public String toString(){
        return list.toString();
    }
}