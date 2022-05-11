import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var arr = new ArrayList<>();
        //заполнение
        for (int i = 1; i < 7; i++) {
            arr.add(i);
        }
        for (int i = 9; i > 1; i--) {
            arr.add(i);
        }
        arr.add(11);
        arr.add(28);
        arr.add(14);
        arr.add(0);

        //вызов рекурсивных функций
        int rekSum = GetRecursSumm((ArrayList) arr.clone());
        int sizeArrayList = GetRecursSize((ArrayList) arr.clone());
        int maxArrayList = GetRecursMax((ArrayList) arr.clone(),(int) arr.get(0));

        //вывод
        System.out.println("Сумма всех элементов = "+rekSum);
        System.out.println("Размер = "+sizeArrayList);
        System.out.println("Максимальный элемент = "+maxArrayList);
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

}