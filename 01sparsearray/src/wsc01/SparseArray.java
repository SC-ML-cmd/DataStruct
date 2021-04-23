package wsc01;/**
 * @author Wsc
 * @create 2021-03-28 20:50
 */

import org.junit.Test;

/**
 * @program: DataStruct
 * @description:
 * @author: Wsc
 * @create: 2021-03-28 20:50
 **/
public class SparseArray {
    @Test
    public void testarr(){
        int chessArr3[] = new int[11]; //数组
        int[] chessArr4 = new int[3];
        System.out.println(chessArr3);
        System.out.println(chessArr4);
    }
    public static void main(String[] args) {
        //创建一个原始数组11 * 11
        //0: 表示没有棋子， 1: 表示有黑子   2：表示蓝子

        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("原始的二维数组");
        for (int[] row : chessArr1){
            for (int data : row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //获取数组中有效数据的个数
        int sum = 0;
        for (int[] row : chessArr1){
            for (int data : row){
                if (data != 0){
                    sum++;
                }
            }
        }
        //创建稀疏数组 第一行以及sum行
        int sparseArr[][] = new int[sum+1][3];
        //设置数组第一行
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //设置稀疏数组其他值
        int count = 0;
        for (int i = 0; i < 11; i++){
            for (int j=0; j < 11; j++){
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //打印稀疏数组
        System.out.println("压缩后稀疏数组：");
        for (int i = 0; i < sparseArr.length; i++){
            System.out.printf("%d\t%d\t%d\t\n",
                    sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        //还原后的稀疏数组
        System.out.println("还原稀疏数组");
        //还原回之前的棋盘数组
        int rowCount = sparseArr[0][0];
        int colCount = sparseArr[0][1];
        int chessArr2[][] = new int[rowCount][colCount];
        for (int i = 0; i < sparseArr[0][sum]; i ++){
            int row = sparseArr[i+1][0];
            int col = sparseArr[i+1][1];
            int val = sparseArr[i+1][2];

            chessArr2[row][col] = val;
        }

        //打印还原回的棋盘
        for(int[] row : chessArr2){
            for(int data : row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
