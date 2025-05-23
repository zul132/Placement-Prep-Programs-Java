package org.example;

public class User {
    private final String username;
    private final String userType; // "regular" or "premium"

    public User(String username, String userType) {
        this.username = username;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public String getUserType() {
        return userType;
    }
}
