import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var arr = new ArrayList <>();
        for (int i = 1; i < 7; i++) {
            arr.add(i);
        }
        int rekSum=GetRekursSumm(arr,0);
        System.out.println(rekSum);
    }

    private static int GetRekursSumm(ArrayList arrList, int sum){

        if (arrList.size()==1) {
            return (int) arrList.get(0);
        }
        else  {
            sum=(int) arrList.get(0);
            arrList.remove(0);

            return sum+GetRekursSumm(arrList,sum);
        }

    }
}