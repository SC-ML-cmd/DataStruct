/**
 * @author Wsc
 * @create 2021-03-30 9:28
 */

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * @program: DataStruct
 * @description:
 * @author: Wsc
 * @create: 2021-03-30 09:28
 **/
public class ArrayQueue {
    public static void main(String[] args) {
        //测试
        //创建队列
        ArrayQueue queue = new ArrayQueue(3);
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        char key = ' ';
        do {
            System.out.println("s(show): 显示队列中数据");
            System.out.println("a(add):  添加数据到队列");
            System.out.println("g(get):  从队列中取出数据");
            System.out.println("h(head): 查看队列头的数据");
            System.out.println("e(exit): 退出");
            key = sc.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    int val = sc.nextInt();
                    queue.addQueue(val);
                    break;
                case 'g':
                    try{
                        int getVal = queue.getQueue();
                        System.out.println("取得一个值："+ getVal);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int head = queue.getHead();
                        System.out.println("队列头对应的值为：" + head);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }

        }while (key != 'e');
    }
    private int maxSize; //表示数组的最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //该数据用于存放数据，模拟队列

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部，本质是指向对列头真正有数据的前一个位置
        rear = -1;//指向对列尾，本质是指向对列尾即对列最后一个数据
    }

    //判断对列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断对列是否为空
    public boolean isEmpty() {
        //front 指明front后一个位置才有数据
        //rear 指明rear及rear之前才有数据
        return front == rear;
    }

    //添加数据
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("对列已满");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //获取对列数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("对列为空，无法获取");
        }
        front++;
        return arr[front];
    }

    //显示对列中的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("对列为空，无法显示");
            return;
        }
        for (int i = front + 1; i <= rear; i++) {
            System.out.printf("arr[%d]:%d\n", i, arr[i]);
        }
    }

    //返回对列头数据
    public int getHead() {
        if (isEmpty()) {
            System.out.println("对列为空");
            throw new RuntimeException("对列为空");
        }
        return arr[front + 1];
    }

}
