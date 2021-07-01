package recurse;

/**
 * @author cl
 * @create 2021-07-01 17:38
 **/
public class Queens8Death {
    int max = 8;
    //数组索引表示行，值表示列
    int[] arr = new int[max];
    int sucCount = 0;


    public static void main(String[] args) {
        Queens8Death queen = new Queens8Death();
        queen.placeQueen(0);
        System.out.println("总成功数" + queen.sucCount);
    }

    /**
     * 放置第nIndex个(nIndex从0开始)
     * nIndex即行索引
     */
    private void placeQueen(int nIndex) {
        if (nIndex == max) {
            print();
            sucCount++;
            return;
        }
        int rowIndex = nIndex;
        //遍历列
        for (int colIndex = 0; colIndex < max; colIndex++) {
            if (check(rowIndex, colIndex)) {
                arr[rowIndex] = colIndex;
                placeQueen(nIndex + 1);
            }
        }
    }

    private boolean check(int rowIndex, int colIndex) {
        for (int i = 0; i < rowIndex; i++) {
            //同一列
            if (arr[i] == colIndex) {
                return false;
            }
            //对角线，斜率为1
            if ((rowIndex - i) == Math.abs(arr[i] - colIndex)) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
