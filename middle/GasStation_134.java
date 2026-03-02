package middle;

public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int zero = 0;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i]-cost[i] <= 0) {
                if (gas[i]-cost[i] == 0) { zero++; }
                continue;
            }
            int begin=0;
            int sum=0;
            while(begin<gas.length){
                sum+=gas[(i+begin)%gas.length] - cost[(i+begin)%gas.length];
                if(sum<0){
                    break;
                }
                begin++;
            }
            if (begin==gas.length){
                return i;
            }

        }
        return zero==gas.length? 0 :-1;
    }
}
