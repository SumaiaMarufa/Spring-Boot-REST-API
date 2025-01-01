package com.example.post.model;

public class User {
    private  String name;
    private String email;
    private int userId;

     //Getters and setters
     public String getName()
     {
        return name;
     }
 
     public void setName(String name)
     {
        this.name = name;
     }

      public String getEmail()
      {
        return email;
      } 

      public void setEmail(String email)
      {
        this.email=email;
      }

      public int getUserId()
      {
        return userId;
      }

      public void setUserId(int userId)
      {
        this.userId=userId;
      }
}
