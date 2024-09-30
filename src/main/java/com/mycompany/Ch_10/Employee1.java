/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ch_10;

/**
 *
 * @author HP
 */
//10.13
public abstract class Employee1 implements Payable {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    public Employee1(String firstName, String lastName,
                    String socialSecurityNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getSocialSecurityNumber(){
        return socialSecurityNumber;
    }

    @Override
    public String toString() {
        return String.format("%s %s%nsocial security number: %s",
                getFirstName(), getLastName(), getSocialSecurityNumber());
    }
}
