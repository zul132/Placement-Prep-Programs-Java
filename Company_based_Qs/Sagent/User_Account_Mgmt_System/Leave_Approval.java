/*
    You are tasked with implementing a User Account Management system with three distinct user roles: HR, Manager, and Employee. 
    Each role has specific privileges:

    Employee: Can request leave approval from HR, view assigned tasks, and update task status.
    Manager: Has all the privileges of an Employee, can assign tasks to employees, and reassign employees to different managers.
    HR: Can approve or reject leave requests and print organizational information for employees and their supervisors.

    You are specifically required to implement the functionality for Leave Request by employee  and Leave Approval/Rejection by HR.
*/

import java.util.ArrayList;
import java.util.List;

class Request {
    private String empName;
    private String hrName;
    private int noOfDays;
    private String startDate;
    private String status;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Request(String empName, String hrName, int noOfDays, String startDate) {
        this.empName = empName;
        this.hrName = hrName;
        this.noOfDays = noOfDays;
        this.startDate = startDate;
        status = "Sent";
    }
}

class User {
    protected String username;
    protected String password;
    protected String email;
    protected String loginTime;
    protected String Role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public User(String username, String password, String email, String loginTime, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.loginTime = loginTime;
        Role = role;
    }
}

class Employee extends User {
    private String managerName;
    private String hrName;

    public Employee(String username, String password, String email, String loginTime, String role, String manager,
            String hr) {
        super(username, password, email, loginTime, role);
        managerName = manager;
        hrName = hr;
    }

    public void requestLeave(int noOfDays, String startDate) {
        Request newReq = new Request(username, hrName, noOfDays, startDate);
        Leave_Approval.leaveRequests.add(newReq);
    }

}

class Manager extends User {
    private String hrName;

    public Manager(String username, String password, String email, String loginTime, String role, String hr) {
        super(username, password, email, loginTime, role);
        hrName = hr;
    }

    public void requestLeave(int noOfDays, String startDate) {
        Request newReq = new Request(username, hrName, noOfDays, startDate);
        Leave_Approval.leaveRequests.add(newReq);
    }

}

class HR extends User {

    public HR(String username, String password, String email, String loginTime, String role) {
        super(username, password, email, loginTime, role);
    }

    public void reviewLeaveRequest() {
        // Search the leave requests array to find which request is sent to this HR
        for (int i = 0; i < Leave_Approval.leaveRequests.size(); i++) {
            if (Leave_Approval.leaveRequests.get(i).getHrName().equals(username)) {
                // check if the no of days requested is valid
                // Assume employee is allowed 3 days leave per month
                if (Leave_Approval.leaveRequests.get(i).getNoOfDays() > 3)
                    Leave_Approval.leaveRequests.get(i).setStatus("Rejected");
                else
                    Leave_Approval.leaveRequests.get(i).setStatus("Approved");
            }
        }
    }
}

public class Leave_Approval {
    public static ArrayList<Request> leaveRequests = new ArrayList<Request>();
    static List<User> accounts = new ArrayList<User>();

    public static void main(String[] args) {
        // Create some sample users
        HR hr1 = new HR("Santhosh", "abcd@123", "santhosh1999@xyz.com", "8:45 AM", "HR");
        Manager manager1 = new Manager("Thomas", "1234@abc", "tommy2001@xyz.com", "10:10 AM", "Manager", "Santhosh");
        Employee emp1 = new Employee("John", "12345678", "johndoe@xyz.com", "9:08 AM", "Employee", "Thomas",
                "Santhosh");
        Employee emp2 = new Employee("Tina", "abcdefgh", "tina123@xyz.com", "8:30 AM", "Employee", "Thomas",
                "Santhosh");

        // Add the users to the database
        accounts.add(hr1);
        accounts.add(manager1);
        accounts.add(emp1);
        accounts.add(emp2);

        // Sample leave requests
        emp1.requestLeave(2, "2024-08-01");
        emp2.requestLeave(4, "2024-08-03");

        // HR reviewing leave requests
        hr1.reviewLeaveRequest();

        // Print the status of leave requests
        for (Request req : leaveRequests) {
            System.out.println("Employee: " + req.getEmpName() + ", Leave Status: " + req.getStatus());
        }
    }
}
