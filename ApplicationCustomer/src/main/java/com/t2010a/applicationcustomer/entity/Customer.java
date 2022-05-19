package com.t2010a.applicationcustomer.entity;
import com.t2010a.applicationcustomer.util.DateTimeHelper;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Customer {
    private int Id;
    private String Name;
    private String Phone;
    private String Image;
    private LocalDateTime dob;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int status; // xoá mềm
    private HashMap<String, String> errors = new HashMap<>();


    public Customer(int id, String name, String phone, String image, LocalDateTime dob, LocalDateTime createdAt, LocalDateTime updatedAt, int status) {
        this.Id = id;
        Name = name;
        Phone = phone;
        Image = image;
        this.dob = dob;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Customer() {
        this.Name = "";
        this.Phone ="" ;
        this.Image = "";
    }

    public Customer(String name, String phone, String image) {
        Name = name;
        Phone = phone;
        Image = image;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = 1;
    }

    public Customer(int id, String name, String phone, String image, LocalDateTime dob) {
        this.Id = id;
        Name = name;
        Phone = phone;
        Image = image;
        this.dob = dob;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = 1;
    }

    public Customer(String name, String phone, String image, LocalDateTime dob) {
        this.Name = name;
        this.Phone = phone;
        this.Image = image;
        this.dob=dob;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = 1;
    }

    public boolean isValid(){
       checkValidate();
       return errors.size() ==0;
    }

    private void checkValidate() {
        //validate du lieu theo kieu cui bap
        if (Name == null || Name.length()==0){
            errors.put("name","Please enter name");
        }
        if (Phone == null || Phone.length()==0){
            errors.put("phone","Please enter phone");
        }
        if (Image == null || Image.length()==0){
            errors.put("image","Please enter image");
        }
        //if(email==null || email.length()==0){
        // errors.put("email","Please enter email")
        //}else if(!ValidationUtil.checkEmail(email)){
        // errors.put("email","Invalid email, please enter real email. For Example: ")
        // }
        //
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Image='" + Image + '\'' +
                ", dob=" + dob +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status=" + status +
                '}';
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDobString() {
        if (this.dob!=null){
            return DateTimeHelper.convertLocalDateTimeToString(this.dob);
        }
        return "";
    }
}
