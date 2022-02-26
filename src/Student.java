public class Student {
    private String studentID;
    private String fullName;
    private String course;
    private int yearLvl;
    private String address;
    private String email;
    private String contact;
    
    public Student(String studentID, String fullName, String course, int yearLvl, String address, String email, String contact)
    {
            this.studentID = studentID;
            this.fullName = fullName;
            this.course = course;
            this.yearLvl = yearLvl;
            this.address = address;
            this.email = email;
            this.contact = contact;
    }
    public String getstudentID() {
            return studentID;
    }
    public void setstudentID(String studentID) {
            this.studentID = studentID;
    }
    public String getfullName() {
            return fullName;
    }
    public void setfullName(String fullName) {
            this.fullName = fullName;
    }
    public String getCourse() {
            return course;
    }
    public void setCourse(String course) {
            this.course = course;
    }
    public int getyearLvl() {
            return yearLvl;
    }
    public void setLevel(int yearLvl) {
            this.yearLvl = yearLvl;
    }
    public String getaddress() {
            return address;
    }
    public void setAddress(String address) {
            this.address = address;
    }
    public String getemail() {
            return email;
    }
    public void setEmail(String email) {
            this.email = email;
    }
    public String getcontact() {
            return contact;
    }
    public void setContact(String contact) {
            this.contact = contact;
    }
}
