package com.ranorextest;

/**
 * Created by Тёма on 28.12.2014.
 */
public class AllVIPUsers {
    String allVIPUsers;

    public AllVIPUsers(String VIPUsers){
        this.allVIPUsers = VIPUsers;
    }

    public String getVIPUsers(){
        return allVIPUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AllVIPUsers)) return false;

        AllVIPUsers that = (AllVIPUsers) o;

        if (!allVIPUsers.equals(that.allVIPUsers)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return allVIPUsers.hashCode();
    }
}
