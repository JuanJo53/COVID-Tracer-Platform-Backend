package bo.ucb.edu.covid_tracer_platform_backend.model;

public class Role {
    private Integer roleId;
    private String role;
    private Integer status;
    private Transaction transaction;

    public Role() {
        transaction = new Transaction();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", role='" + role + '\'' +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
