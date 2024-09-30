package com.mycompany.bkash;

public class Bkash {
    private BkashUser[] users = new BkashUser[100];
    private int userCount = 0;

    public BkashUser findUserByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getPhoneNumber().equals(phoneNumber)) {
                return users[i];
            }
        }
        return null;
    }

    public void registerUser(String phoneNumber, String pin) {
        if (findUserByPhoneNumber(phoneNumber) == null) {
            if (pin.length() == 4 && pin.matches("\\d+")) {
                users[userCount++] = new BkashUser(phoneNumber, pin);
                System.out.println("Sign Up successful!");
            } else {
                System.out.println("PIN must be 4 digits. Registration failed.");
            }
        } else {
            System.out.println("Already signed up with this phone number.");
        }
    }

    public BkashUser signIn(String phoneNumber, String pin) {
        BkashUser user = findUserByPhoneNumber(phoneNumber);
        if (user != null && user.verifyPin(pin)) {
            return user;
        }
        return null;
    }
}
