package com.company;

import java.util.List;

public class DepthFirst {

    //eğer yol varsa true dönücek ve pathlistesi doldurulacak
    public static boolean searchPath(int[][] maze, int x, int y
            , List<Integer> path){

        //hedef nodea ulaşılırsa
        if (maze[y][x] == 9) {
            path.add(x);
            path.add(y);
            return true;
        }


        //Geçerli konum ziyaret edilmeyen bir düğümse (0) onu ziyaret edilmiş olarak
        //değiştirelim (2)
        if (maze[y][x] == 0) {
            maze[y][x] = 2;


            //tüm komşu nodeları ziyaret edicez
            //eğer yol bulunursa, path listesini geçerli konumlarla dolduralım
            //recursive olacak burası
            int dx = -1;
            int dy = 0;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 1;
            dy = 0;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0;
            dy = -1;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0;
            dy = 1;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }
        }
        return false;
    }
}
