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
        double[] scales1 = {80, 75, 70, 60 , 50}; //Scale Course
        double[] scales2 = {75, 70, 65, 60 , 40};
        // double[] myNum3 = {70, 65, 60, 53 , 30};

        Student obj = new Student("Kunakorn Topurin", "Computer") {};

        obj.addCourse(new ScaleCourse("c100", 4, scales1),75.0);
        obj.addCourse(new ScaleCourse("c102", 3, scales2),65.0);
        obj.addCourse(new SatisfactoryCourse("c104", 3, 50),50.0);

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
        double gpa = 0 ;
        int calCredit = 0;
        double nGrade = 0;
        System.out.println("Name: "+ getName());
        System.out.println("Major: "+ getMajor());
        System.out.println("Courses Taken: ");
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] != null)
                System.out.println(courses[i].getName() + " " + courses[i].getType() + " " + courses[i].getCredit() 
                + " "+ (RawGrade[i]) + " " + (courses[i].getFinalLetterGrade(RawGrade[i])));
            
            if (courses[i].getType() == "Scale") {
                switch (courses[i].getFinalLetterGrade(RawGrade[i])) {
                    case "A":
                        nGrade = 4.0;
                        break;
                    case "B":
                        nGrade = 3.0;
                        break;
                    case "C":
                        nGrade = 2.0;
                        break;
                    case "D":
                        nGrade = 1.0;
                        break;
                    case "F":
                        nGrade = 0.0;
                        break;
                }

                gpa += ((nGrade)*courses[i].getCredit());
                calCredit += courses[i].getCredit();

            }
            else
                break;    
        }
        System.out.println("Total Credits:"+ getSumCredit());
        System.out.printf("Overall GPA: %.2f", (gpa/calCredit));

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
    public String getFinalLetterGrade(double grade){ //Not use this function
        return "";
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

    public ScaleCourse(String name,int credit,double[] scales){
        setCredit(credit);
        setName(name);
        this.scales = scales;
    }

    @Override public String getFinalLetterGrade(double grade){
        String letterGrade = "";
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
    @Override public String getType(){
        return "Scale";
    }
}
class SatisfactoryCourse extends Course{
    private double threshold;

    public SatisfactoryCourse(String name,int credit,double threshold){
        this.threshold = threshold;
        setCredit(credit);
        setName(name);
    }

    @Override public String getType(){
        return "S/U  ";
    }
    @Override public String getFinalLetterGrade(double grade){
        String letterGrade;
        if (grade >= threshold)
            letterGrade = "S";
        else
            letterGrade = "U";
        return letterGrade;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }
}

