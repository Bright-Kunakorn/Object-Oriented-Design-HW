package hw1_630510613;

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
        double[] myNum2 = {75, 70, 65, 60 , 40};
        double[] myNum3 = {70, 65, 60, 53 , 30};

        Student obj = new Student("Kunakorn Topurin", "Computer") {};

        obj.addCourse(new ScaleCourse("c100", 3, myNum1),20.0);
        obj.addCourse(new ScaleCourse("c102", 3, myNum2),80.0);
        obj.addCourse(new ScaleCourse("c103", 3, myNum3),60.0);

        obj.printTranscript();
    }   
}

abstract class Student {
    //Attribute
    private Course[] courses = new Course[4];
    private double[] RawGrade = new double[4];
    private String name;
    private String major;
    private int index = 0;
    
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
    public int getSumCredit(){
        int sumCredit = 0;
        for (Object elem : courses) {
            if (elem != null)
                sumCredit += ((Course) elem).getCredit();
            else
                break;
        }
        return sumCredit;
    }
    public double getSumGrade(){
        double SumGrade = 0;
        for (Double elem : RawGrade) {
            SumGrade += elem;
        }
        return SumGrade;
    }
    //operator
    public void addCourse(Course course,double grade){
        courses[index] = course;
        RawGrade[index] = grade;
        ++index;
    }
    public void printTranscript(){
        System.out.println("Name: "+ getName());
        System.out.println("Major: "+ getMajor());
        System.out.println("Courses Taken: ");
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] != null)
                System.out.println(courses[i].getName() +" "+ (RawGrade[i]) +" "+ courses[i].getCredit()+" "
                +(courses[i].getFinalLetterGrade(RawGrade[i])));
            else
                break;
        }
        System.out.println("Total Credits:"+ getSumCredit());
        System.out.println("Overall GPA:"+ getSumGrade()/getSumCredit());
    }
}

class Course {
    //Attribute
    private String name;
    private int credit;
    private String type;
    
    public Course(String name,int credit){

    }
    //set altibute
    public void setName(String name){
        this.name = name;
    }
    public void setCredit(int credit){
        this.credit = credit;
    }
    public Course() {
    }
    //operation
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
    public double[] scales = new double[5];
    private String letterGrade;

    public ScaleCourse(String name,int credit,double[] scales){
        setCredit(credit);
        setName(name);
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
        setCredit(credit);
        setName(name);
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


