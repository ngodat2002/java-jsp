package com.t2010a.applicationcustomer.run;

import com.google.protobuf.Int32Value;
import com.t2010a.applicationcustomer.entity.Customer;
import com.t2010a.applicationcustomer.model.CustomerModel;
import com.t2010a.applicationcustomer.model.InMemoryCustomerModel;
import com.t2010a.applicationcustomer.model.MySQLCustomerModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class CustomerApplication {
    private static CustomerModel customerModel;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Please choose type of model: ");
            System.out.println("--------------------------");
            System.out.println("1. In memory model.");
            System.out.println("2. My SQL model.");
            System.out.println("--------------------------");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    customerModel = new InMemoryCustomerModel();
                    break;
                case 2:
                    customerModel = new MySQLCustomerModel();
                    break;
            }
            generateMenu();
        }
    }

    private static void generateMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------------Customer Manager--------------");
            System.out.println("1. Create new customer");
            System.out.println("2. Show all customer");
            System.out.println("3. Update customer");
            System.out.println("4. Delete customer");
            System.out.println("5. Exit");
            System.out.println("------------------------------------------");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    createNewCustomer();
                    break;
                case 2:
                    showAllCustomer();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    System.out.println("Cya!");
                    break;
            }
            if (choice == 5) {
                break;
            }
        }
    }

    private static void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Id to deleted: ");
        int Id = scanner.nextInt();
        Customer existingStudent = customerModel.findById(Id);
        if (existingStudent == null) {
            System.err.println("404, Student not found!");
        } else {
            if (customerModel.delete(Id)) {
                System.out.println("Action success!");
            } else {
                System.err.println("Action fails, please try again!");
            }
        }
    }

    private static void updateCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter id to update: ");
        int Id = scanner.nextInt();
        Customer existingCustomer =  customerModel.findById(Id);
        if (existingCustomer == null) {
            System.err.println("404, Customer not found!");
        } else {
            System.out.println("Please enter name");
            String Name = scanner.next();
            existingCustomer.setName(Name);
            if (customerModel.update(Id, existingCustomer) != null) {
                System.out.println("Action success!");
            } else {
                System.err.println("Action fails, please try again!");
            }
        }
    }

    private static void showAllCustomer() {
        List<Customer> list = customerModel.findAll();
        for (Customer student :
                list) {
            System.out.println(student.toString());
        }
    }

    private static void createNewCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Name");
        String Name = scanner.nextLine();
        System.out.println("Please enter Phone");
        String Phone = scanner.nextLine();
        System.out.println("Please enter Image");
        String Image = scanner.nextLine();
        Customer customer =  new Customer(Name,Phone,Image);
        if (customerModel.save(customer)!=null){
            System.out.println("Create customer success!");
        }else {
            System.err.println("Save customer fails, please try again later!");
        }
    }
}
