package com.ranorextest;

/**
 * Created by Тёма on 28.12.2014.
 */
public class Category {
    String сategory;

    public Category(String сategory){
        this.сategory = сategory;
    }

    public String getСategory(){
        return сategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (сategory != null ? !сategory.equals(category.сategory) : category.сategory != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return сategory != null ? сategory.hashCode() : 0;
    }



}
