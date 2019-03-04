import org.junit.Test;

import java.util.Arrays;

/**
 * xuhaixing
 * 2018/8/27 21:57
 **/
public class App {

    /**
     * 选择排序
     * 每次比较出最小的，和第一个元素交换和第二个元素交换.,..
     */
    @Test
    public void selectSort() {
        int[] arr = {1, 2, 0, 9, 3, 65, 8, 9, 0, 3, 1, 8, 6, 4, 9};

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
        //[0, 0, 1, 1, 2, 3, 3, 4, 6, 8, 8, 9, 9, 9, 65]
    }

}
