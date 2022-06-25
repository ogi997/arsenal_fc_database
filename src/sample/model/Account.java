package sample.model;

public class Account {
    private Integer idAccount;
    private String username;
    private String password;

    public Account() {
        super();
    }

    public Account(Integer idAccount) {
        super();
        this.idAccount = idAccount;
    }

    public Account(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public Account(Integer idAccount, String username, String password) {
        super();
        this.idAccount = idAccount;
        this.username = username;
        this.password = password;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idAccount == null) ? 0 : idAccount.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Account [idAccount=" + idAccount + ", username=" + username + ", password=" + password + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        if (idAccount == null) {
            return other.idAccount == null;
        } else return idAccount.equals(other.idAccount);
    }
}
