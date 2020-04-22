package day01;

import java.io.*;

/**
 * @version 创建时间: 2020/4/22
 * @author: leon19961001@gmail.com
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {
        // 定义棋盘大小
        int ROW_CHESS_ARRAY = 11;
        int COL_CHESS_ARRAY = 11;
        int[][] chessArr1 = new int[ROW_CHESS_ARRAY][COL_CHESS_ARRAY];

        // 初始化棋盘上不为0的位置
        chessArr1[1][1] = 1;
        chessArr1[2][2] = 2;
        chessArr1[3][3] = 3;
        chessArr1[4][4] = 4;

        //打印数组
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.print(data + " ");
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < ROW_CHESS_ARRAY; i++) {
            for (int j = 0; j <COL_CHESS_ARRAY; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        // 创建稀疏数组的格式
        int[][] sparseArr1 = new int[sum+1][3];
        sparseArr1[0][0] = ROW_CHESS_ARRAY;
        sparseArr1[0][1] = COL_CHESS_ARRAY;
        sparseArr1[0][2] = sum;

        // 创建稀疏数组
        int count = 0;
        for (int i = 0; i < ROW_CHESS_ARRAY; i++) {
            for (int j = 0; j <COL_CHESS_ARRAY; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr1[count][0] = i;
                    sparseArr1[count][1] = j;
                    sparseArr1[count][2] = chessArr1[i][j];
                }
            }
        }

        //打印稀疏数组
        for (int[] row : sparseArr1) {
            for (int data : row) {
                System.out.print(data + " ");
            }
            System.out.println();
        }
        System.out.println("稀疏数组常见成功！");

        // 存储稀疏数组得模型
        File dest = new File("./resource/map.data");
        Writer os = null;
        os = new FileWriter(dest);

        // 数据拷贝
        for (int i = 0; i < sparseArr1.length; i++) {
            for (int j = 0; j < sparseArr1[0].length; j++) {
                os.write(sparseArr1[i][j] + "\t");
            }
            os.write("\r\n");
        }
        os.close();
        System.out.println("存储少稀疏数组成功!");

        // 取出稀疏数组
        File src = new File("./resource/map.data");
        BufferedReader in = new BufferedReader(new FileReader(src));
        int rowSparseArr = 0;
        String line;
        while ((line = in.readLine()) != null) {
            rowSparseArr++;
        }

        int[][] sparseAyy2 = new int[rowSparseArr][3];
        int rowTemp = 0;
        in.close();

        in = new BufferedReader(new FileReader(src));
        while ((line = in.readLine()) != null) {
            String[] temp = line.split("\t");
            for (int j = 0; j < temp.length; j++) {
                sparseAyy2[rowTemp][j] = Integer.parseInt(temp[j]);
            }
            rowTemp++;
        }
        in.close();

        for (int[] row : sparseAyy2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int[][] chessArr2 = new int[sparseAyy2[0][0]][sparseAyy2[0][1]];
        for (int k = 1; k < sparseAyy2.length; k++) {
            chessArr2[sparseAyy2[k][0]][sparseAyy2[k][1]] = sparseAyy2[k][2];
        }

        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
