/**
 * Created by kie827 on 6/9/2016.
 * Project Euler #102
 */
import java.util.Scanner;
import java.io.*;

public class TriangleContainment {
    public static void main(String[] args) {
        try{
            int count = 0;
            Scanner scan = new Scanner (new File ("triangles.txt"));
            System.out.println(new Triangle("-340,495,-153,-910,835,-947").containsOrigin());
            System.out.println(new Triangle("-175,41,-421,-714,574,-645").containsOrigin());
            while (scan.hasNextLine()){
                Triangle tri = new Triangle (scan.nextLine());
                if (tri.containsOrigin())
                    count++;
            }
            System.out.println(count);
        }
        catch (IOException e){
            System.err.println(e);
        }
    }

    static class Triangle{
        Point p1;
        Point p2;
        Point p3;
        public Triangle(String line){
            String[] str = line.split(",");
            p1 = new Point(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
            p2 = new Point(Integer.parseInt(str[2]), Integer.parseInt(str[3]));
            p3 = new Point(Integer.parseInt(str[4]), Integer.parseInt(str[5]));
        }

        private boolean containsOrigin(){
            return contains(p1, p2, p3) && contains(p1, p3, p2) && contains(p2, p3, p1);
        }

        private boolean contains(Point a, Point b, Point c){
            boolean lineAbove = false;
            if (function(a, b, 0) > 0)
                lineAbove = true;

            if (lineAbove)
                return function(a, b, c.x) > c.y;
            else
                return function(a, b, c.x) < c.y;
        }

        private double function(Point a, Point b, int x){
            return (1.0 * x - a.x)*((1.0 * b.y - a.y)/(1.0 * b.x - a.x)) + a.y;
        }
    }

    static class Point{
        int x;
        int y;
        public Point(int a, int b){
            x = a;
            y = b;
        }
    }
}
