package beike;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            long sum = 0;
            List<Long> list = new ArrayList<>();
            Map<Integer,Integer>map = new TreeMap<>();
            Arrays.sort(a);
            list.add(a[0]);
            for (int i = 1; i < n;) {
                if (a[i] != a[i - 1]) {
                    list.add(a[i]);
                }else {
                    int cot = 1;
                    int index = i;
                    while (true){
                        index++;
                        if (a[index]==a[index-1]){
                            cot++;
                        }else {
                            map.put(index,cot);
                            break;
                        }
                    }
                    i = index-1;
                }
                i++;
            }

            for (Map.Entry<Integer,Integer>e:map.entrySet()){
                Integer i = e.getKey()-1;
                Integer j = e.getKey()+1;
                Integer value = e.getValue();
                for (;value>0;value--){
                    if (i>=0&&i-1>=0&&j+1<list.size()&&j<list.size()){
                        long isum = Math.abs(list.get(i)-list.get(e.getKey()))+Math.abs(list.get(i-1)-list.get(e.getKey()));
                        long jsum = Math.abs(list.get(j)-list.get(e.getKey()))+Math.abs(list.get(j+1)-list.get(e.getKey()));
                        if (isum<jsum){
                            sum -= Math.abs(list.get(i)-list.get(i-1));
                            sum+=isum;
                            i--;
                        }else {
                            sum -= Math.abs(list.get(j)-list.get(j+1));
                            sum+=jsum;
                            j++;
                        }
                    }else {

                    }
                }
            }
        }
    }

}