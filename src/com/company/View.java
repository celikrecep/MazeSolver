package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;
import java.util.Timer;

public class View extends  JFrame{
Timer timer = new Timer();
    int sayac=1;


    //labirenti temsil etmek için
    //iki boyutlu dizi kullanıcaz(grafik olarak)

    /**
     * maze[row][col]
     * value = 0 ziyaret edilmemiş node
     *       = 1 duvarlar
     *       = 2 ziyaret edilmiş node
     *       = 9 hedef node
     *
     *
     * ArrayIndexOutOfBounds'tan
     * kaçınmak için sınırlar "1" ile dolduruyoruz.
     */
    // internetten bulduğumuz  ikili labirent dizi kodu
    private int [][] maze =
            {       {1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,1,0,1,0,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,1,0,1,1,1,0,1},
                    {1,0,0,0,1,1,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,9,0,1},
                    {1,0,1,0,1,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,1,0,1},
                    {1,0,0,0,0,0,0,0,0,0,1,0,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1}
            };
    private int [][] maze1=
            {       {1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,1,0,1,0,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,1,0,1,1,1,0,1},
                    {1,0,0,0,1,1,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,0,0,1},
                    {1,0,1,0,1,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,1,0,1},
                    {1,0,0,0,0,0,0,0,9,0,1,0,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1}
            };

    private int [][] maze2=
            {       {1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,1,0,1,0,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,1,0,1,1,1,0,1},
                    {1,0,0,0,1,1,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,0,0,1},
                    {1,0,1,0,1,9,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,1,0,1},
                    {1,0,0,0,0,0,0,0,0,0,1,0,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1}
            };

    private int [][] maze3=
            {       {1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,1,0,1,0,1,0,0,0,0,9,1},
                    {1,0,1,0,0,0,1,0,1,1,1,0,1},
                    {1,0,0,0,1,1,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,0,0,1},
                    {1,0,1,0,1,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,1,0,1},
                    {1,0,0,0,0,0,0,0,0,0,1,0,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1}
            };



    Random rand = new Random();
    int n = rand.nextInt(4);



    private final List<Integer> path = new ArrayList<Integer>();
    private int pathIndex;

    public View(){
        setTitle("!!!");
        setSize(640,960);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        switch (n){
            case 0:DepthFirst.searchPath(maze,1,1,path); break;
            case 1:DepthFirst.searchPath(maze1,1,1,path); break;
            case 2:DepthFirst.searchPath(maze2,1,1,path); break;
            case 3:DepthFirst.searchPath(maze3,1,1,path); break;
            default: break;
        }
       timer.schedule(task,100,100);





    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // labirenti çiziyoruz
        g.translate(50,50);


        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                Color color;
                switch (n){
                    case 0 : switch (maze[row][col]) {
                        case 1 : color = Color.GRAY; break;//duvarlar
                        case 9 : color = Color.RED; break;
                        default : color = Color.WHITE;//yol
                    }
                        g.setColor(color);
                        //içi dolu kareler için
                        g.fillRect(30 * col, 30 * row, 30, 30);
                        g.setColor(Color.WHITE);
                        //içi boş kareler için
                        g.drawRect(30 * col, 30 * row, 30, 30); break;

                    case 1: switch (maze1[row][col]) {
                        case 1 : color = Color.GRAY; break;//duvarlar
                        case 9 : color = Color.RED; break;
                        default : color = Color.WHITE;//yol
                    }
                        g.setColor(color);
                        //içi dolu kareler için
                        g.fillRect(30 * col, 30 * row, 30, 30);
                        g.setColor(Color.WHITE);
                        //içi boş kareler için
                        g.drawRect(30 * col, 30 * row, 30, 30); break;

                    case 2 : switch (maze2[row][col]) {
                        case 1 : color = Color.GRAY; break;//duvarlar
                        case 9 : color = Color.RED; break;
                        default : color = Color.WHITE;//yol
                    }
                        g.setColor(color);
                        //içi dolu kareler için
                        g.fillRect(30 * col, 30 * row, 30, 30);
                        g.setColor(Color.WHITE);
                        //içi boş kareler için
                        g.drawRect(30 * col, 30 * row, 30, 30); break;

                    case 3 : switch (maze3[row][col]) {
                        case 1 : color = Color.GRAY; break;//duvarlar
                        case 9 : color = Color.RED; break;
                        default : color = Color.WHITE;//yol
                    }
                        g.setColor(color);
                        //içi dolu kareler için
                        g.fillRect(30 * col, 30 * row, 30, 30);
                        g.setColor(Color.WHITE);
                        //içi boş kareler için
                        g.drawRect(30 * col, 30 * row, 30, 30); break;
                        default: break;

                }




            }
        }
        //yol listesini çiziyoruz
        for(int p = 0; p < path.size(); p+=2){
            int pathX = path.get(p);
            int pathY = path.get(p + 1);
            g.setColor(Color.GREEN);
            g.fillRect(pathX * 30,pathY * 30,30,30);


        }


        int pathX = path.get(pathIndex);
        int pathY = path.get(pathIndex + 1);
        g.setColor(Color.RED);
        g.fillRect(pathX * 30, pathY * 30, 30, 30);

    }
//timer görevini yazdık
    //amaç fareyi yol boyunca hareket ettirmek
    TimerTask task = new TimerTask() {
        @Override
        public void run() {

            sayac++;
            pathIndex += 2;

            if (pathIndex > path.size() - 2) {
                pathIndex = path.size() - 2;
            }
            repaint();
            if(sayac == path.size()/2){

                timer.cancel();


            }


        }
    };

    @Override
    protected void processKeyEvent(KeyEvent ke) {
        if (ke.getID() != KeyEvent.KEY_PRESSED) {
            return;
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            pathIndex -= 2;
            if (pathIndex < 0) {
                pathIndex = 0;
            }
        }
        
        repaint();
    }




}
