package BankApplication;

import java.util.Scanner;

public class BankingSystemApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        BankingService service = new BankingServiceImpl();

        while (true) {
            System.out.println("\nBanking System");
            System.out.println("1. Add Customers");
            System.out.println("2. Add Accounts");
            System.out.println("3. Add Beneficiary");
            System.out.println("4. Add Transaction");
            System.out.println("5. Find Customer by Id");
            System.out.println("6. List all Accounts of specific Customer");
            System.out.println("7. List all transactions of specific Account");
            System.out.println("8. List all beneficiaries of specific customer");
            System.out.println("9. Exit");
            System.out.print("Enter your choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Customer Id : ");
                    int cid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name : ");
                    String name = sc.nextLine();
                    System.out.print("Address : ");
                    String addr = sc.nextLine();
                    System.out.print("Contact No. : ");
                    String contact = sc.nextLine();
                    service.addCustomer(new Customer(cid, name, addr, contact));
                    break;

                case 2:
                    System.out.print("Account Id : ");
                    int aid = sc.nextInt();
                    System.out.print("Customer Id : ");
                    int cId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Account Type Saving/Current : ");
                    String type = sc.nextLine();
                    System.out.print("Balance : ");
                    double bal = sc.nextDouble();
                    service.addAccount(new Account(aid, cId, type, bal));
                    break;

                case 3:
                    System.out.print("Customer Id : ");
                    int bcid = sc.nextInt();
                    System.out.print("Beneficiary Id : ");
                    int bid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name : ");
                    String bname = sc.nextLine();
                    System.out.print("Account No : ");
                    String accNo = sc.nextLine();
                    System.out.print("Bank Details : ");
                    String bank = sc.nextLine();
                    service.addBeneficiary(
                        new Beneficiary(bid, bcid, bname, accNo, bank));
                    break;

                case 4:
                    System.out.print("Account Id : ");
                    int taid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Type (Deposit/Withdrawal) : ");
                    String ttype = sc.nextLine();
                    System.out.print("Amount : ");
                    double amt = sc.nextDouble();
                    service.addTransaction(new Transaction(taid, ttype, amt));
                    break;

                case 5:
                    for (Customer c : service.getAllCustomers()) {
                        System.out.println(c);
                    }
                    System.out.print("Customer Id : ");
                    int fid = sc.nextInt();
                    System.out.println("Customer: " + service.findCustomerById(fid));
                    break;

                case 6:
                    for (Account a : service.getAllAccounts()) {
                        System.out.println(a);
                    }
                    System.out.print("Customer Id : ");
                    int acId = sc.nextInt();
                    for (Account a : service.getAccountsByCustomerId(acId)) {
                        System.out.println(a);
                    }
                    break;

                case 7:
                    System.out.print("Account Id : ");
                    int tid = sc.nextInt();
                    for (Transaction t : service.getTransactionsByAccountId(tid)) {
                        System.out.println(t);
                    }
                    break;

                case 8:
                    for (Beneficiary b : service.getAllBeneficiaries()) {
                        System.out.println(b);
                    }
                    System.out.print("Customer Id : ");
                    int bc = sc.nextInt();
                    for (Beneficiary b : service.getBeneficiariesByCustomerId(bc)) {
                        System.out.println(b);
                    }
                    break;

                case 9:
                    System.out.println("Thank you!");
                    System.exit(0);
            }
        }

	}

}
