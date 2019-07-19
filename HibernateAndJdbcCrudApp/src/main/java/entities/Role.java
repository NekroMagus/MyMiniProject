package entities;

public enum Role {
    USER("USER"), ADMIN("ADMIN");

    private String role;

    Role(String role) {
        this.role = role;
    }
}
