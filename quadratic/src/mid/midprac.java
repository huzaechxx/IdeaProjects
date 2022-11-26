package mid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
class movie{
    private String rating;
    private double IdNumber;
    private String movietitle;
    int days;
    movie(String rating,double IdNumber,String movietitle){
        this.rating=rating;
        this.movietitle=movietitle;
        this.IdNumber=IdNumber;
    }
    public String getRating(){
        return rating;
    }
    public String getMovietitle(){
        return movietitle;
    }
    public double getIdNumber(){
        return IdNumber;
    }
    public double calclatefee(int days){
        return days*2;
    }
    public boolean equals(Object obj){
        movie m = (movie) obj;
        if (this.IdNumber == m.IdNumber){
            return true;
        }else{
            return false;
        }
    }
}
class action extends movie{
    int days;
    action(String rating,double IdNumber,String movietitle){
        super(rating,IdNumber,movietitle);
    }
    public double calclatefee(int days){
        return days*3;
    }
}
class drama extends movie{
    int days;
    drama(String rating,double IdNumber,String movietitle){
        super(rating,IdNumber,movietitle);
    }
    public double calclatefee(int days){
        return days*2;
    }
}
class comedy extends movie{
    int days;
    comedy(String rating,double IdNumber,String movietitle){
        super(rating,IdNumber,movietitle);
    }
    public double calclatefee(int days){
        return days*2.5;
    }
}
abstract class shape{
    private String color;
    private boolean filled;
    shape(){

    }
    shape(String color,boolean filled){

    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color=color;
    }
    public boolean isFilled(){
        return filled;
    }
    public void setFilled(boolean filled){
        this.filled=filled;
    }
    public abstract double getperimeter();
    public abstract double getarea();
    public String tostring(){
        String st = "perimeter : "+this.getperimeter()+"\n area : "+this.getarea();
        return st;
    }
}
class circle extends shape{
    private double radius;
    public void setRadius(double radius){
        this.radius=radius;
    }
    public double getRadius(){
        return radius;
    }
    circle(){

    }
    circle(double radius){
        this.radius=radius;
    }
    circle(double radius,String color,boolean filled){
        super(color,filled);
        this.radius=radius;
    }
    public double getarea(){
        return ((Math.PI)*radius*radius);
    }

    @Override
    public double getperimeter() {
        return (2*Math.PI*radius);
    }
    public String tostring(){
        String st = "perimeter : "+this.getperimeter()+"\n area : "+this.getarea();
        return st;
    }
}
class rectangle extends shape{
    private double length,width;
    rectangle(){

    }
    rectangle(double length,double width){
        this.length=length;
        this.width=width;
    }
    rectangle(double length,double width,String color,boolean filled){
        super(color,filled);
        this.length=length;
        this.width=width;
    }
    public void setLength(double length){
        this.length=length;
    }
    public double getLength(){
        return length;
    }
    public void setWidth(double width){
        this.width=width;
    }
    public double getWidth(){
        return width;
    }
    public double getarea(){
        return length*width;
    }
    public double getperimeter(){
        return (2*(length+width));
    }
    public String tostring(){
        String st = "perimeter : "+this.getperimeter()+"\n area : "+this.getarea();
        return st;
    }
}
public class midprac {
    public static void shapesummary(shape [] s){
        for (int i = 0; i < s.length; i++) {
            System.out.println("area : "+s[i].getarea()+"\n perimeter : "+s[i].getperimeter());
        }
    }
    public static void main(String[] args) {
//        movie m1 = new movie("g",1,"z");
//        action a1 = new action("g",1,"z");
//        if (m1.equals(a1)){
//            System.out.println("equal");
//        }else{
//            System.out.println("not");
//        }
//        System.out.println("late fee is "+m1.calclatefee(3));
//        System.out.println("late fee is "+a1.calclatefee(3));
        Scanner sc = new Scanner(System.in);
        shape [] s = new shape[]{new circle(1),new rectangle(2,4),new circle(3),new rectangle(6,7)};
        System.out.println("enter 1:circle 2:rectangle");
        int choice = sc.nextInt();
        for (int i = 0; i < s.length; i++) {
            if (choice == 1){
                if (s[i] instanceof circle) {
                    circle c = (circle) s[i];
                    System.out.println("enter radius ");
                    double r = sc.nextDouble();
                    c.setRadius(r);
                }
            }else if (choice == 2){
                if (s[i] instanceof rectangle){
                    rectangle rect = (rectangle) s[i];
                    System.out.println("enter length");
                    double l = sc.nextDouble();
                    System.out.println("enter width");
                    double w = sc.nextDouble();
                    rect.setLength(l);
                    rect.setWidth(w);
                }
            }
        }
        midprac.shapesummary(s);
    }
}
