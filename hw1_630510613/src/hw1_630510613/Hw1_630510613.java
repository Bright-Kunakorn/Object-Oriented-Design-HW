package hw1_630510613;
import java.util.List;

/**
 *
 * @author bright
 */
public class Hw1_630510613 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        double[] myNum1 = {80, 75, 70, 60 , 50};

        ScaleCourse c1 = new ScaleCourse(null, 0, myNum1);
        SatisfactoryCourse c2 = new  SatisfactoryCourse(null, 2, 50);
        System.out.println(c1.getFinalLetterGrade(70));
        System.out.println(c2.getFinalLetterGrade(20));
        Student obj = new Student("Kunakorn Topurin", "Computer") {};
        obj.printTranscript();

    }   
}

abstract class Student {
    //Attribute
    private List<Course> courses;
    private double[] RawGrade;
    private String name;
    private int grade;
    private String major;
    //constructor
    public Student(String name,String major){
        this.name = name;
        this.major = major;
    }
    //Get var
    public String getName(){
        return this.name;
    }
    public String getMajor(){
        return this.major;
    }
    //operator
    public void addCourse(){
        
    }
    public void printTranscript(){
        System.out.println("Name: "+ getName());
        System.out.println("Major: "+ getMajor());
        System.out.println("Courses Taken: ");

    }
}


class Course {
    //Attribute
    private String name;
    private int credit;
    private String type;
    
    public Course(){
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCredit(int credit){
        this.credit = credit;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getFinalLetterGrade(double grade){
        return type;
    }
    public String getType(){
        return type;
    }
    public String getName(){
        return this.name;
    }
    public int getCredit(){
        return this.credit;
    }
}
class ScaleCourse extends Course{
    public double[] scales;
    private String letterGrade;

    public ScaleCourse(String name,int credit,double[] scales){
        this.scales = scales;
    }

    public String getFinalLetterGrade(double grade){
        if (grade >= scales[0])
            letterGrade = "A";
        else if (grade >= scales[1])
            letterGrade = "B";
        else if (grade >= scales[2])
            letterGrade = "C";
        else if (grade >= scales[3])
            letterGrade = "D";
        else if (grade < scales[4])
            letterGrade = "F";
        return letterGrade;
    }
    public String getType(){
        return letterGrade;
    }
}
class SatisfactoryCourse extends Course{
    private double threshold;
    private String letterGrade;

    public SatisfactoryCourse(String name,int credit,double threshold){
        this.threshold = threshold;
    }

    public String getType(){
        return letterGrade;
    }
    public String getFinalLetterGrade(double grade){
        if (grade >= threshold)
            letterGrade = "S";
        else
            letterGrade = "U";
        return letterGrade;
    }
}


