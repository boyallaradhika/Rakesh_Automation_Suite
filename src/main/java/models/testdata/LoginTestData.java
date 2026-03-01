package models.testdata;

public class LoginTestData {
    private String validUsername;
    private String validPassword;
    private String invalidUsername;
    private String invalidPassword;

    public String getValidUsername() {
        return validUsername;
    }
    public void setValidUsername(String validUsername) {
        this.validUsername = validUsername;
    }
    public String getValidPassword() {
        return validPassword;
    }
    public void setValidPassword(String validPassword) {
        this.validPassword = validPassword;
    }
    public String getInvalidUsername() {
        return invalidUsername;
    }
    public void setInvalidUsername(String invalidUsername) {
        this.invalidUsername = invalidUsername;
    }
    public String getInvalidPassword() {
        return invalidPassword;
    }
    public void setInvalidPassword(String invalidPassword) {
        this.invalidPassword = invalidPassword;
    }
}
