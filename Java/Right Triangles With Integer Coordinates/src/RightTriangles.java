import java.util.Arrays;

/**
 * Created by kie827 on 6/9/2016.
 * Project Euler #91
 */
public class RightTriangles {
    public static void main(String[] args) {
        final int RANGE = 50;
        Point[] grid = new Point[(RANGE+1)*(RANGE+1)];
        int index = 0;
        for (int x = 0 ; x <= RANGE ; x++)
            for (int y = 0 ; y <= RANGE ; y++)
                grid[index++] = new Point(x, y);

        int count = 0;
        for (int i = 1 ; i < grid.length-1 ; i ++){
            for (int j = i+1 ; j < grid.length ; j ++){
                Triangle tri = new Triangle (new Point(0,0), grid[i], grid[j]);
                if (tri.isRightTri())
                    count++;
            }
        }
        System.out.println(count);
    }
}

class Triangle{
    Point p1;
    Point p2;
    Point p3;
    public Triangle (Point a, Point b, Point c){
        p1 = a;
        p2 = b;
        p3 = c;
    }
    public boolean isRightTri(){
        double[] distances = new double [3];
        distances[0] = p1.distance(p2);
        distances[1] = p2.distance(p3);
        distances[2] = p1.distance(p3);
        Arrays.sort(distances);
        if (distances[0]+distances[1] < distances[2])
            return false;
        else if (distances[0]+distances[2] < distances[1])
            return false;
        else if (distances[1]+distances[2] < distances[0])
            return false;

        return Math.abs(Math.pow(distances[2],2) - Math.pow(distances[1],2) - Math.pow(distances[0], 2)) < 1e-4;
    }
}

class Point{
    int x;
    int y;
    public Point (int a, int b){
        x = a;
        y = b;
    }
    public double distance(Point p){
        return Math.sqrt(Math.pow(p.y-this.y, 2) + Math.pow(p.x-this.x, 2));
    }
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}