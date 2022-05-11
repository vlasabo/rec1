import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        var arr = new ArrayList<>();
        //заполнение
        for (int i = 1; i < 7; i++) {
            arr.add(i);
        }
        for (int i = 19; i > 8; i--) {
            arr.add(i);
        }


        var copyArr=(ArrayList) arr.clone(); //отсортированный для бинарного
        Collections.sort(copyArr);
        //вызов рекурсивных функций
        int rekSum = GetRecursSumm((ArrayList) arr.clone());
        int sizeArrayList = GetRecursSize((ArrayList) arr.clone());
        int maxArrayList = GetRecursMax((ArrayList) arr.clone(),(int) arr.get(0));

        int elementPosition = findRecursiveBinary(copyArr,2,0,copyArr.size()-1);

        //вывод
        System.out.println("Сумма всех элементов = "+rekSum);
        System.out.println("Размер = "+sizeArrayList);
        System.out.println("Максимальный элемент = "+maxArrayList);
        System.out.println("Позиция искомого в отсортированном массиве = "+elementPosition);
    }

    private static int GetRecursSumm(ArrayList arrList) {
        if (arrList.size() == 0)
            return 0;

        int sum = 0;
        if (arrList.size() == 1) {
            return (int) arrList.get(0);
        } else {
            sum = (int) arrList.get(0);
            arrList.remove(0);

            return sum + GetRecursSumm(arrList);
        }

    }


    private static int GetRecursSize(ArrayList arrList) {
        int sizeArrayList = 0;
        if (arrList.isEmpty())
            return 0;
        else
            arrList.remove(0);
        return GetRecursSize(arrList) + 1;
    }

    private static int GetRecursMax(ArrayList arrList,int max) {
        if (arrList.size()==1)
            return (max>(int) arrList.get(0))?max:(int) arrList.get(0);
        else {
            arrList.remove(0);
            if ((int) arrList.get(0)>max) {
                max=(int) arrList.get(0);
            }

        }
        return GetRecursMax(arrList,max);


    }


    private static int findRecursiveBinary(ArrayList arrList, int theSearch, int startSearcIndex, int stopSearchIndex) {
        if (stopSearchIndex-startSearcIndex>=2){
            int halfIndex= (stopSearchIndex+startSearcIndex)/2;
            if ((Integer) arrList.get(halfIndex)>theSearch) {
                stopSearchIndex = halfIndex - 1;
                return findRecursiveBinary(arrList, theSearch, startSearcIndex, stopSearchIndex);
            }
            else if ((Integer) arrList.get(halfIndex)<theSearch) {
                startSearcIndex = halfIndex + 1;
                return findRecursiveBinary(arrList, theSearch, startSearcIndex, stopSearchIndex);
            }
            else return halfIndex;
        }
        else {
            if (theSearch == (Integer) arrList.get(startSearcIndex))
                return startSearcIndex;
            else if (theSearch == (Integer) arrList.get(stopSearchIndex))
                return stopSearchIndex;
            //else return -1;
        }
    return -1;
    }
}