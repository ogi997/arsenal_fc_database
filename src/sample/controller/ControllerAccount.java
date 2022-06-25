package sample.controller;

import sample.model.Account;
import sample.wrapper.WrapperAccount;

import java.util.List;

public class ControllerAccount {

    public List<Account> getAll() {
        return WrapperAccount.selectAll();
    }

    public boolean save(Account account) {
        return WrapperAccount.insert(account) == 1;
    }

    public int update(Account account) {
        return WrapperAccount.update(account);
    }

    public int deleteAccount(Account account) {
        return WrapperAccount.delete(account);
    }

    public Account userExist(Account account) {
        return WrapperAccount.userExist(account);
    }
}
