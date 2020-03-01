public class Queen8 {

    int max = 8;
    int[] arr = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.cheek(0);
        System.out.println(count);
    }

    public void cheek(int n){
        if(n==max){ //递归的出口， 当n为8的时候，就是摆放第9个皇后，说明前面8个都不冲突，即为正常的摆放
            print();  //每一种方法，输出一次
            count++; //记录有多少种方法
            return;
        }
        //循环每一行的每一列
        for(int i=0;i<max;i++){
            arr[n] = i; //把当前列的值放入到数组中
            if(judge(n)){ //如果不冲突，继续进入下一行
                cheek(n+1); //递归开始，再判断n+1行的每一列和前面冲突不
            }
        }
    }

    //判断皇后是否冲突
    public boolean judge(int n){
        for(int i=0;i<n;i++){
            //这里的判断对角线上是否冲突用到了数学上的 x2 - x1 = y2 - y1; 斜率为1
            if(arr[i]==arr[n]|| Math.abs(n-i) == Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }

    //打印摆放的位置
    public void print(){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
