package bo.ucb.edu.covid_tracer_platform_backend.dto;

public class UserPasswordRequest {
    private Integer userId;
    private String passwordCurrent;
    private String passwordNew;

    public UserPasswordRequest() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPasswordCurrent() {
        return passwordCurrent;
    }

    public void setPasswordCurrent(String passwordCurrent) {
        this.passwordCurrent = passwordCurrent;
    }

    public String getPasswordNew() {
        return passwordNew;
    }

    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }

    @Override
    public String toString() {
        return "userPasswordCurrent{" +
                "userId=" + userId +
                ", passwordCurrent='" + passwordCurrent + '\'' +
                ", passwordNew='" + passwordNew + '\'' +
                '}';
    }

}
