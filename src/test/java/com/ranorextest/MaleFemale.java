package com.ranorextest;

import org.openqa.selenium.WebElement;

/**
 * Created by Тёма on 04.01.2015.
 */
public class MaleFemale {
    String maleFemale;
    WebElement element;

    public MaleFemale(String maleFemale){
        this.maleFemale = maleFemale;
    }

    public String getMaleFemale() {
        return maleFemale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MaleFemale)) return false;

        MaleFemale that = (MaleFemale) o;

        if (maleFemale != null ? !maleFemale.equals(that.maleFemale) : that.maleFemale != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return maleFemale != null ? maleFemale.hashCode() : 0;
    }
}
