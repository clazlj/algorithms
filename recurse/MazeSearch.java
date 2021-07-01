package recurse;

/**
 * 8行7列的迷宫格
 * 四周和部分格子是墙，用1标识
 * 7行6列为出口
 * @author cl
 * @create 2021-06-28 10:29
 **/
public class MazeSearch {

    public static void main(String[] args) {
        int[][] maze = getMaze();
        System.out.println("初始化的迷宫：");
        printMaze(maze);

        int startRow = 2, startCol = 1;
        System.out.println("从起点" + (startRow + 1) + "行，" + (startCol + 1) + "列开始探索迷宫...");
        searchMaze(maze, startRow, startCol);

        System.out.println("探索迷宫后的结果：");
        printMaze(maze);
    }

    private static int[][] getMaze() {
        int row = 8, col = 7;
        int[][] maze = new int[row][col];
        for (int i = 0; i < col; i++) {
            maze[0][i] = 1;
            maze[row - 1][i] = 1;
        }
        for (int i = 0; i < row; i++) {
            maze[i][0] = 1;
            maze[i][col - 1] = 1;
        }

        //4行的2列、3列置为墙
        maze[3][1] = 1;
        maze[3][2] = 1;

        //3行3列置为墙
        maze[2][2] = 1;

        //2行2列置为墙
        //maze[1][1] = 1;

        return maze;
    }

    private static void printMaze(int[][] maze) {
        for (int[] ints : maze) {
            for (int j : ints) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    /**
     * 探索迷宫
     * 7行6列为出口
     * 约定2是可以走通的，3是走不通的
     * 暂定探索路线的策略是向下->向右->向上->向左（也可以换其他策略）
     */
    private static boolean searchMaze(int[][] maze, int i, int j) {
        if (maze[6][5] == 2) {
            return true;
        } else if (maze[i][j] == 0) {
            //临时置为可通行
            maze[i][j] = 2;
            if (searchMaze(maze, i + 1, j)) {
                //向下可行
                return true;
            } else if (searchMaze(maze, i, j + 1)) {
                //向右可行
                return true;
            } else if (searchMaze(maze, i - 1, j)) {
                //向上可行
                return true;
            } else if (searchMaze(maze, i, j - 1)) {
                //向左可行
                return true;
            }
            //可通行改成不可通行
            maze[i][j] = 3;
            return false;
        } else {
            return false;
        }
    }
}
