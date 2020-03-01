public class MiGong {
    public static void main(String[] args) {
        //定义一个地图8*7的
        int [][] arr = new int[8][7];
        //先将上下全部置为1
        for(int i=0;i<7;i++){
            arr[0][i] = 1;
            arr[7][i] = 1;
        }
        //左右置为1
        for(int j = 0;j<8;j++){
            arr[j][0] = 1;
            arr[j][6] = 1;
        }
        //增加俩个挡板
        arr[3][1] = 1;
        arr[3][2] = 1;
//        for(int i = 0;i<8;i++){
//            for(int j = 0;j<7;j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
        migong(arr,1,1);
        for(int i = 0;i<8;i++){
            for(int j = 0;j<7;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
    //使用递归回溯来给小球找路
    //说明
    //1. map 表示地图
    //2. i,j 表示从地图的哪个位置开始出发 (1,1)
    //3. 如果小球能到 map[6][5] 位置，则说明通路找到.
    //4. 约定： 当 map[i][j] 为 0 表示该点没有走过 当为 1 表示墙 ； 2 表示通路可以走 ； 3 表示该点已经走过，但是走不通
    //5. 在走迷宫时，需要确定一个策略(方法) 下->右->上->左 , 如果该点走不通，再回溯
    public static boolean migong(int[][] map,int i,int j){
        if(map[6][5]==2){
            return true;
        }else {
            if(map[i][j]==0) {
                map[i][j] = 2;
                if(migong(map,i+1,j)){
                    return true;
                }else if(migong(map,i,j+1)){
                    return true;
                }else if(migong(map,i-1,j)){
                    return true;
                }else if(migong(map,i,j-1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }

    }
}
