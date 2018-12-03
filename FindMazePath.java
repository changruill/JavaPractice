public class FindMazePath {

    public static boolean nextStep(boolean[][] is_dead_end, int[] location, int[] destination)
    {
        // 每一步四个方向都可以走
        if(location[0] == destination[0] && location[1] == destination[1])
            return true;

        int[] original_location = new int[]{location[0], location[1]};
        // 递归的时候走过的路不能再走
        // go up
        if(location[0]-1 >= 0 && !is_dead_end[location[0]-1][location[1]])
        {
            location[0]--;
            is_dead_end[original_location[0]][original_location[1]] = true;
            if(nextStep(is_dead_end, location, destination))
                return true;
            location[0] = original_location[0];
            location[1] = original_location[1];
            is_dead_end[original_location[0]][original_location[1]] = false;
        }
        // go down
        if(location[0]+1 < is_dead_end.length && !is_dead_end[location[0]+1][location[1]])
        {
            location[0]++;
            is_dead_end[original_location[0]][original_location[1]] = true;
            if(nextStep(is_dead_end, location, destination))
                return true;
            location[0] = original_location[0];
            location[1] = original_location[1];
            is_dead_end[original_location[0]][original_location[1]] = false;
        }
        // go left
        if(location[1]-1 >= 0 && !is_dead_end[location[0]][location[1]-1])
        {
            location[1]--;
            is_dead_end[original_location[0]][original_location[1]] = true;
            if(nextStep(is_dead_end, location, destination))
                return true;
            location[0] = original_location[0];
            location[1] = original_location[1];
            is_dead_end[original_location[0]][original_location[1]] = false;
        }
        // go right
        if(location[1]+1 < is_dead_end[0].length && !is_dead_end[location[0]][location[1]+1])
        {
            location[1]++;
            is_dead_end[original_location[0]][original_location[1]] = true;
            if(nextStep(is_dead_end, location, destination))
                return true;
            location[0] = original_location[0];
            location[1] = original_location[1];
            is_dead_end[original_location[0]][original_location[1]] = false;
        }
        // no way to go
        is_dead_end[location[0]][location[1]] = true;
        return false;
    }

    public static boolean goUp(boolean[][] is_dead_end, int[] cur_location, int[] destination, int[] ori_location)
    {
        cur_location[0]--;
        is_dead_end[ori_location[0]][ori_location[1]] = true;
        if(nextStepOneWay(is_dead_end, cur_location, destination, "up"))
            return true;
        cur_location[0] = ori_location[0];
        cur_location[1] = ori_location[1];
        is_dead_end[ori_location[0]][ori_location[1]] = false;
        return false;
    }

    public static boolean goDown(boolean[][] is_dead_end, int[] cur_location, int[] destination, int[] ori_location)
    {
        cur_location[0]++;
        is_dead_end[ori_location[0]][ori_location[1]] = true;
        if(nextStepOneWay(is_dead_end, cur_location, destination, "down"))
            return true;
        cur_location[0] = ori_location[0];
        cur_location[1] = ori_location[1];
        is_dead_end[ori_location[0]][ori_location[1]] = false;
        return false;
    }

    public static boolean goLeft(boolean[][] is_dead_end, int[] cur_location, int[] destination, int[] ori_location)
    {
        cur_location[1]--;
        is_dead_end[ori_location[0]][ori_location[1]] = true;
        if(nextStepOneWay(is_dead_end, cur_location, destination, "left"))
            return true;
        cur_location[0] = ori_location[0];
        cur_location[1] = ori_location[1];
        is_dead_end[ori_location[0]][ori_location[1]] = false;
        return false;
    }

    public static boolean goRight(boolean[][] is_dead_end, int[] cur_location, int[] destination, int[] ori_location)
    {
        cur_location[1]++;
        is_dead_end[ori_location[0]][ori_location[1]] = true;
        if(nextStepOneWay(is_dead_end, cur_location, destination, "right"))
            return true;
        cur_location[0] = ori_location[0];
        cur_location[1] = ori_location[1];
        is_dead_end[ori_location[0]][ori_location[1]] = false;
        return false;
    }

    public static boolean nextStepOneWay(boolean[][] is_dead_end, int[] location, int[] destination, String last_step)
    {
        // 每一步只可以走跟上一步同向的方向，只要没有撞墙就不会停下来（包括不会停在终点），撞墙则可以选择另一个方向
        if(location[0] == destination[0] && location[1] == destination[1])
            return true;

        int[] original_location = new int[]{location[0], location[1]};

        switch (last_step)
        {
            case "up":
                if(location[0]-1 >= 0 && !is_dead_end[location[0]-1][location[1]])
                {
                    if(goUp(is_dead_end, location, destination, original_location))
                        return true;
                }
                else
                {
                    if(location[1]-1 >= 0 && !is_dead_end[location[0]][location[1]-1])
                    {
                        if(goLeft(is_dead_end, location, destination, original_location))
                            return true;
                    }
                    if(location[1]+1 < is_dead_end[0].length && !is_dead_end[location[0]][location[1]+1])
                    {
                        if(goRight(is_dead_end, location, destination, original_location))
                            return true;
                    }
                }
                is_dead_end[location[0]][location[1]] = true;
                return false;

            case "down":
                if(location[0]+1 < is_dead_end.length && !is_dead_end[location[0]+1][location[1]])
                {
                    if(goDown(is_dead_end, location, destination, original_location))
                        return true;
                }

                else
                {
                    if(location[1]-1 >= 0 && !is_dead_end[location[0]][location[1]-1])
                    {
                        if(goLeft(is_dead_end, location, destination, original_location))
                            return true;
                    }
                    if(location[1]+1 < is_dead_end[0].length && !is_dead_end[location[0]][location[1]+1])
                    {
                        if(goRight(is_dead_end, location, destination, original_location))
                            return true;
                    }
                }
                is_dead_end[location[0]][location[1]] = true;
                return false;

            case "left":
                if(location[1]-1 >= 0 && !is_dead_end[location[0]][location[1]-1])
                {
                    if(goLeft(is_dead_end, location, destination, original_location))
                        return true;
                }

                else
                {
                    if(location[0]-1 >= 0 && !is_dead_end[location[0]-1][location[1]])
                    {
                        if(goUp(is_dead_end, location, destination, original_location))
                            return true;
                    }
                    if(location[0]+1 < is_dead_end.length && !is_dead_end[location[0]+1][location[1]])
                    {
                        if(goDown(is_dead_end, location, destination, original_location))
                            return true;
                    }
                }
                is_dead_end[location[0]][location[1]] = true;
                return false;

            case "right":
                if(location[1]+1 < is_dead_end[0].length && !is_dead_end[location[0]][location[1]+1])
                {
                    if(goRight(is_dead_end, location, destination, original_location))
                        return true;
                }
                else
                {
                    if(location[0]-1 >= 0 && !is_dead_end[location[0]-1][location[1]])
                    {
                        if(goUp(is_dead_end, location, destination, original_location))
                            return true;
                    }
                    if(location[0]+1 < is_dead_end.length && !is_dead_end[location[0]+1][location[1]])
                    {
                        if(goDown(is_dead_end, location, destination, original_location))
                            return true;
                    }
                }
                is_dead_end[location[0]][location[1]] = true;
                return false;
            case "first step":
                if(location[0]-1 >= 0 && !is_dead_end[location[0]-1][location[1]])
                {
                    if(nextStepOneWay(is_dead_end, location, destination, "up"))
                        return true;
                }
                if(location[0]+1 < is_dead_end.length && !is_dead_end[location[0]+1][location[1]])
                {
                    if(nextStepOneWay(is_dead_end, location, destination, "down"))
                        return true;
                }
                if(location[1]-1 >= 0 && !is_dead_end[location[0]][location[1]-1])
                {
                    if(nextStepOneWay(is_dead_end, location, destination, "left"))
                        return true;
                }
                if(location[1]+1 < is_dead_end[0].length && !is_dead_end[location[0]][location[1]+1])
                {
                    if(nextStepOneWay(is_dead_end, location, destination, "right"))
                        return true;
                }
                return false;

            default:
                System.out.println("illegal input");
                return false;
        }
    }

    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        /**
         * @param maze: the maze
         * @param start: the start
         * @param destination: the destination
         * @return: whether the ball could stop at the destination
         */
        if(maze == null || maze.length == 0 || maze[0].length == 0)
        {
            System.out.println("不是二维数组");
            return false;
        }
        if(start[0]<0 || start[0] >= maze.length || start[1]<0 || start[1]>=maze[0].length)
        {
            System.out.println("起点索引越界");
            return false;
        }
        if(destination[0]<0 || destination[0] >= maze.length || destination[1]<0 || destination[1]>=maze[0].length)
        {
            System.out.println("终点索引越界");
            return false;
        }
        if(maze[start[0]][start[1]] == 1 || maze[destination[0]][destination[1]] == 1)
        {
            System.out.println("起点/终点是墙");
            return false;
        }
        if(start[0] == destination[0] && start[1] == destination[1])
            return true;

        int[] current_location = new int[]{start[0], start[1]};
        boolean[][] is_dead_end = new boolean[maze.length][maze[0].length];
        for(int i = 0; i < maze.length; i++)
            for(int j = 0; j < maze[0].length; j++)
            {
                if(maze[i][j] == 1)
                    is_dead_end[i][j] = true;
                else
                    is_dead_end[i][j] = false;
            }

        //return nextStep(is_dead_end, current_location, destination);

        // 想停下来的必要条件是至少有一个方向是墙且对面方向不是墙
        if(((destination[0]==0 || maze[destination[0]-1][destination[1]]==1) && (destination[0]+1<maze.length && maze[destination[0]+1][destination[1]]==0))
                || ((destination[0]==maze.length-1 || maze[destination[0]+1][destination[1]]==1) && (destination[0]>0 && maze[destination[0]-1][destination[1]]==0))
                || ((destination[1]==0 || maze[destination[0]][destination[1]-1]==1) && (destination[1]+1<maze[0].length && maze[destination[0]][destination[1]+1]==0))
                || ((destination[1]==maze[0].length-1 || maze[destination[0]][destination[0]+1]==1) && (destination[1]>0 && maze[destination[0]][destination[1]-1]==0)))
            return nextStepOneWay(is_dead_end, current_location, destination, "first step");
        else
            return false;

    }

    public static void main(String args[])
    {
//        0 0 1 0 0
//        0 0 0 0 0
//        0 0 0 1 0
//        1 1 0 1 1
//        0 0 0 0 0
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0,4};
        int[] destination = {3,3};

        System.out.println(hasPath(maze, start ,destination));
    }

}
