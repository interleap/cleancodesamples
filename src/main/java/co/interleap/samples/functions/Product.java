package co.interleap.samples.functions;

import javax.persistence.*;

public class Product {

  public static final int BOOK = 1;
  public static final int PHONE = 2;
  public static final int WATCH = 3;

  private Long id;
  private int productType;
  private String name;
  private int price;
  private String specs;
  private String author;
  private String publisher;
  private String colour;
  private String brand;
  private String model;
  private String watchType;

  protected Product(){}

  public Product(int productType, String name, int price, String specs, String author,String publisher,String colour,String brand,String model,String watchType)
  {
    this.productType = productType;
    this.name = name;
    this.price = price;
    this.specs = specs;
    this.author = author;
    this.publisher=publisher;
    this.colour=colour;
    this.brand = brand;
    this.model = model;
    this.watchType = watchType;
  }



  public String productDetails()
  {

    String details=" ";
    details = details + "Price: " + price;
    switch(productType){
      case BOOK:
        details = details + ", Name: " + name;
        details = details + ", Author: " + author;
        details = details + ", Publisher: " + publisher;
        break;
      case PHONE:
        details = details + ", Name: " + brand + " " + model;
        details = details + ", Specs: " + specs;
        details = details + ", Colour: " + colour;
        break;
      case WATCH:
        details = details + ", Name: " + brand + " " + model;
        details = details + ", Colour: " + colour;
        details = details + ", Type: " + watchType;
        break;
    }
    return details;
  }

  public int getPrice() {
    return price;
  }

  public int getProductType() {
    return productType;
  }
}
