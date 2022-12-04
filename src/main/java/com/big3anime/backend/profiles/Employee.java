package com.big3anime.backend.profiles;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;


import com.big3anime.backend.finance.Salary;



enum Department {
    QUALITY,
    DEVELOPMENT,
    DEVOPS,
    SALES,
    MARKETTING,
    SUPPLYCHAIN,
    HUMANRESOURCE,
    FINANCE    
}


public class Employee {
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

    public Employee(String employeeid, String firstname, String lastname, String workemail, String personalEmail,
            Employee reportingManager, String division, Department department, String title, Date doj) {
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

    public Employee() {
        this.employeeid = null;
        this.firstname = null;
        this.lastname = null;
        this.workemail = null;
        this.personalEmail = null;
        this.reportingManager = null;
        this.division = null;
        this.department = null;
        this.title = null;
    }

    public Employee(Employee emp) {
        this(emp.getEmployeeid(), emp.getFirstname(), emp.getLastname(), emp.getWorkemail(), emp.getPersonalEmail(),
                emp.getReportingManager(), emp.getDivision(), emp.getDepartment(), emp.getTitle(),
                emp.getDateOfJoining());
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
        return title;
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
        return dateOfJoining;
    }

    public Date getTerminateDate() {
        return terminateDate;
    }

    public Salary getSalary() {
        return salary;
    }

    public ConcurrentHashMap<String, String> getBankDetails() {
        return bankDetails;
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
