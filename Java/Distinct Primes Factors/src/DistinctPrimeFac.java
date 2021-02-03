import java.util.ArrayList;

/**
 * Created by kie827 on 8/16/2016.
 */
public class DistinctPrimeFac {

    public static void main(String[] args) {
        final int TARGET_DISTINCT_FACTORS = 4;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int num = 2;
        while (list.size() < TARGET_DISTINCT_FACTORS){
            int count = getPrimeFac(num, new ArrayList<Prime>()).size();
            if (count == TARGET_DISTINCT_FACTORS){
                list.add(num);
            }
            else{
                list = new ArrayList<Integer>();
            }
            num++;
        }
        System.out.println(list);

    }

    private static ArrayList<Prime> getPrimeFac(int num, ArrayList<Prime> list){
        double sqrt = Math.sqrt(num);
        for (int i = 2 ; i <= sqrt ; i ++){
            if (num % i == 0){
                // add
                add(i, list);
                return getPrimeFac(num / i, list);
            }
        }
        add(num, list);
        return list;
    }

    private static void add(int num, ArrayList<Prime> list){
        boolean found = false;
        for (Prime p : list){
            if (p.num == num){
                p.exp++;
                found = true;
                break;
            }
        }
        if (!found){
            list.add(new Prime(num));
        }
    }

}

class Prime{
    int num;
    int exp;

    public Prime(int num){
        this.num = num;
        exp = 1;
    }

    @Override
    public String toString(){
        return "[" + num + ", " + exp + "]";
    }
}