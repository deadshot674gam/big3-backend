package com.big3anime.backend.profiles;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import org.bson.Document;

import com.big3anime.backend.finance.Salary;



public class Employee {
    public enum Department {
        QUALITY,
        DEVELOPMENT,
        DEVOPS,
        SALES,
        MARKETTING,
        SUPPLYCHAIN,
        HUMANRESOURCE,
        FINANCE
    }
    private String employeeid;
    private String firstname;
    private String lastname;
    private String workemail;
    private String personalEmail;
    private Employee reportingManager;
    private String division;
    private Department department;
    private String title;
    private Date dateOfJoining;
    private Date terminateDate;

    private ConcurrentHashMap<String, String> bankDetails = new ConcurrentHashMap<>();

    private Salary salary;

    public Employee(String employeeid, String firstname, String lastname, String workemail, String personalEmail, Employee reportingManager, String division, Department department, String title, Date doj) {

        if(employeeid== null){
            throw new NullPointerException("Employeeid cannot be null");
        }
        this.employeeid = employeeid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.workemail = workemail;
        this.personalEmail = personalEmail;
        this.reportingManager = reportingManager;
        this.division = division;
        this.department = department;
        this.title = title;
        this.dateOfJoining = doj;
    }

    public Employee(Employee emp) {
        this(emp.getEmployeeid(), emp.getFirstname(), emp.getLastname(), emp.getWorkemail(), emp.getPersonalEmail(),
                emp.getReportingManager(), emp.getDivision(), emp.getDepartment(), emp.getTitle(),
                emp.getDateOfJoining());
    }

    public Employee(Document doc){
        this((String)doc.get("_id"),
        (String)doc.get("e_firstname"),
        (String)doc.get("e_lastname"),
        (String)doc.get("e_workEmail"),
        (String)doc.get("e_personalEmail"),
        (Employee)doc.get("e_reportingManager"),
        (String)doc.get("e_division"),
        (Department)doc.get("e_department"),
        (String)doc.get("e_title"),
        (Date)doc.get("e_dateOfJoining"));
    }



    public Document toDocument(){
        return new Document().append("_id", this.employeeid)
        .append("e_firstname", this.firstname)
        .append("e_lastname", this.lastname)
        .append("e_workEmail", this.workemail)
        .append("e_title", this.title)
        .append("e_personalEmail", this.personalEmail)
        .append("e_reportingManager",(this.reportingManager == null)? null: this.reportingManager.toDocument())
        .append("e_division", this.division)
        .append("e_department", this.department.toString())
        .append("e_dateOfJoining", this.dateOfJoining)
        .append("e_terminateDate", this.terminateDate)
        .append("e_salary", this.salary)
        .append("e_bankDetails", this.bankDetails);
        
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmployeeid() {
        return this.employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getWorkemail() {
        return this.workemail;
    }

    public void setWorkemail(String workemail) {
        this.workemail = workemail;
    }

    public String getPersonalEmail() {
        return this.personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public Employee getReportingManager() {
        return this.reportingManager;
    }

    public void setReportingManager(Employee reportingManager) {
        this.reportingManager = reportingManager;
    }

    public void setTerminateDate(Date terminateDate) {
        this.terminateDate = terminateDate;
    }

    public void setBankDetails(ConcurrentHashMap<String, String> bankDetails) {
        this.bankDetails = bankDetails;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Date getDateOfJoining() {
        return this.dateOfJoining;
    }

    public Date getTerminateDate() {
        return this.terminateDate;
    }

    public Salary getSalary() {
        return this.salary;
    }

    public ConcurrentHashMap<String, String> getBankDetails() {
        return this.bankDetails;
    }

    @Override
    public String toString() {
        return "Employee [employeeid=" + employeeid + ", firstname=" + firstname + ", lastname=" + lastname
                + ", workemail=" + workemail + ", personalEmail=" + personalEmail + ", reportingManager="
                + reportingManager + ", division=" + division + ", department=" + department + ", title=" + title + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((employeeid == null) ? 0 : employeeid.hashCode());
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (employeeid == null) {
            if (other.employeeid != null)
                return false;
        } else if (!employeeid.equals(other.employeeid))
            return false;
        if (firstname == null) {
            if (other.firstname != null)
                return false;
        } else if (!firstname.equals(other.firstname))
            return false;
        if (lastname == null) {
            if (other.lastname != null)
                return false;
        } else if (!lastname.equals(other.lastname))
            return false;
        return true;
    }

}
