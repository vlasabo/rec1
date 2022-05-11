import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var arr = new ArrayList <>();
        for (int i = 1; i < 7; i++) {
            arr.add(i);
        }
        int rekSum=GetRecursSumm((ArrayList) arr.clone());
        int sizeArrayList=GetRecursSize((ArrayList) arr.clone());
        System.out.println(rekSum);
        System.out.println(sizeArrayList);
    }

    private static int GetRecursSumm(ArrayList arrList){
        if (arrList.size()==0)
            return 0;

        int sum=0;
        if (arrList.size()==1) {
            return (int) arrList.get(0);
        }
        else  {
            sum=(int) arrList.get(0);
            arrList.remove(0);

            return sum+GetRecursSumm(arrList);
        }

    }


    private static int GetRecursSize(ArrayList arrList){
    int sizeArrayList=0;
    if (arrList.isEmpty())
        return 0;
    else
        arrList.remove(0);
        return GetRecursSize(arrList)+1;
    }


}