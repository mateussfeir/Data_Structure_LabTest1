import java.util.ArrayList;

class Student {
    // att
    public int idNumber;
    public String fname;
    public String lname;
    // constructor
    public Student(int idNumber, String fname, String lname){
        this.idNumber = idNumber;
        this.fname = fname;
        this.lname = lname;
    }
    // Output
    @Override
    public String toString(){
        return ("Id: "+idNumber+" Fname: "+fname+" Lname:"+lname);
    }
}

class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public  void addStudentSorted (Student student){
        students.add(student);
        insertionSort();
    }

    private void insertionSort (){
        for (int i=0; i< students.size(); i++){
            Student key = students.get(i);
            int j=i-1;
            while (j >= 0 && students.get(j).idNumber > key.idNumber){
                students.set(j + 1, students.get(j));
                j--;
            }
        students.set(j+1, key);
        }
    }

    public int binarySearch (int target){
        int lo = 0;
        int hi = students.size() -1;
        while (lo<= hi){
            int mid = (lo + hi)/2;
            if (target == students.get(mid).idNumber){
                return mid;
            } else if (target < students.get(mid).idNumber){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
    return -1;
    }

    public void printStudents() {
        for (int i = 0; i<students.size(); i++){
            System.out.println(students.get(i));
        }
    }
}

class LabTestFull1 {
    public static void main(String[] args){
        // Create the instance of the StudentManager class
        StudentManager manager = new StudentManager();
        // Add the Students
        manager.addStudentSorted(new Student(24, "Gabriel", "Menezes"));
        manager.addStudentSorted(new Student(69, "Samuel", "Puta"));
        manager.addStudentSorted(new Student(11, "Joacas", "Chyper"));
        manager.addStudentSorted(new Student(99, "Rhyna", "Dog"));

        manager.printStudents();

        // Search
        int target = 24;
        int index = manager.binarySearch(target);
        if (index != -1){
            System.out.println("Student id: "+target+" found at index: "+index+"!");
        } else {
            System.out.println("Student id: "+target+" not found!");
        }
    }
}