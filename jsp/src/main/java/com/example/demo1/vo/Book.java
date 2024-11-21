package com.example.demo1.vo;

public class Book{
    private Integer bookId;
    private String bookName;
    private String publisher;
    private Integer price;



    public Integer getBookId(){
        return this.bookId;
    }

    public String getBookName(){
        return this.bookName;
    }

    public String getPublisher(){
        return this.publisher;
    }

    public Integer getPrice(){
        return this.price;
    }

    public void setBookId(Integer bookId){
        this.bookId = bookId;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setPrice(Integer price){
        this.price = price;
    }
}