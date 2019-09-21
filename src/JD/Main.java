package JD;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author smi1e
 * Date 2019/8/20 14:34
 * Description
 */
public class Main {
    private static Scanner in = new Scanner(System.in);

    private static int Quick_GCD(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (!(a % 2 == 1) && !(b % 2 == 1)) {
            return Quick_GCD(a >> 1, b >> 1) << 1;
        } else if (!(b % 2 == 1)) {
            return Quick_GCD(a, b >> 1);
        } else if (!(a % 2 == 1)) {
            return Quick_GCD(a >> 1, b);
        } else {
            return Quick_GCD(Math.abs(a - b), Math.min(a, b));
        }
    }

    public static void metricMean() {
        while (in.hasNext()) {
            int sum = 0;
            int num = in.nextInt();
            for (int i = 2; i < num; i++) {
                int t = num;
                while (t != 0) {
                    int s = t / i;
                    sum += t - s * i;
                    t = s;
                }
            }
            int i = Quick_GCD(sum, num - 2);
            System.out.println((sum / i) + "/" + ((num - 2) / i));
        }
    }

    private static int shi(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    private static int bin(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 2;
            num /= 2;
        }
        return res;
    }

    public static void luckyNum() {
        ArrayList<Integer> tres = new ArrayList<>();
        tres.add(1);
        while (in.hasNext()) {
            int res = 0;
            int num = in.nextInt();
            int i = 1;
            for (int j = tres.size() - 1; j >= 0; j--) {
                if (num > tres.get(j)) {
                    i = tres.get(j) + 1;
                    res = tres.size() - j;
                }
            }
            for (; i <= num; i++) {
                int s = shi(i);
                int b = bin(i);
                if (s == b) {
                    tres.add(i);
                    res++;
                }
            }
            System.out.println(res);
        }
    }

    public static void setGo() {
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            Set<Integer> res = new HashSet<>();
            for (int i = 0; i < m + n; i++) {
                res.add(in.nextInt());
            }
            List<Integer> collect = res.stream().sorted(Integer::compareTo).collect(Collectors.toList());
            for (int i = 0; i < collect.size(); i++) {
                if (i == collect.size() - 1) {
                    System.out.print(collect.get(i));
                } else {
                    System.out.print(collect.get(i) + " ");
                }
            }
            System.out.println();
        }
    }

    public static void shopping() {
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            Map<String, Integer> buy = new HashMap<>(m);
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                prices[i] = in.nextInt();
            }
            for (int i = 0; i < m; i++) {
                String t = in.next();
                Integer cnt = buy.get(t);
                if (cnt != null) {
                    buy.replace(t, cnt + 1);
                } else {
                    buy.put(t, 1);
                }
            }

            List<Map.Entry<String, Integer>> collect = buy.entrySet().stream().sorted((a, b) -> -a.getValue().compareTo(b.getValue())).collect(Collectors.toList());
            Arrays.sort(prices);
            int min = 0;
            int max = 0;
            int index = 0;
            int last = n - 1;
            for (Map.Entry e : collect) {
                min += (Integer) e.getValue() * prices[index++];
                max += (Integer) e.getValue() * prices[last--];
            }
            System.out.println(min + " " + max);

        }
    }

    public static void shares(){
        while (in.hasNext()) {
            Map<Integer,Integer>buy = new HashMap<>();
            Map<Integer,Integer>sell = new HashMap<>();
            int n = in.nextInt();
            int s = in.nextInt();
            for (int i = 0; i < n; i++) {
                String type = in.next();
                int p = in.nextInt();
                int q = in.nextInt();
                if (type.equals("S")){
                    Integer cnt;
                    if ((cnt = sell.get(p))!=null){
                        sell.replace(p,cnt+q);
                    }else {
                        sell.put(p,q);
                    }
                }else {
                    Integer cnt;
                    if ((cnt = buy.get(p))!=null){
                        buy.replace(p,cnt+q);
                    }else {
                        buy.put(p,q);
                    }
                }
            }

            List<Map.Entry<Integer, Integer>> buys = buy.entrySet().stream().sorted((a, b) -> -a.getKey().compareTo(b.getKey())).limit(s).collect(Collectors.toList());
            List<Map.Entry<Integer, Integer>> sells = sell.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).limit(s).collect(Collectors.toList());
            for (int i = sells.size()-1;i >=0;i--){
                System.out.println("S "+sells.get(i).getKey()+" "+sells.get(i).getValue());
            }
            buys.forEach((x)->{
                System.out.println("B "+x.getKey()+" "+x.getValue());
            });


        }
    }

    public static void main(String[] args) {

    }
}
