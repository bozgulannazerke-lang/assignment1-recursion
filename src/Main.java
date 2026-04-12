import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount[] initialArray = new BankAccount[3];
        initialArray[0] = new BankAccount("101", "Ali", 150000);
        initialArray[1] = new BankAccount("102", "Naz", 220000);
        initialArray[2] = new BankAccount("103", "Aiym", 50000);

        LinkedList<BankAccount> accounts = new LinkedList<>();
        for (BankAccount acc : initialArray) {
            accounts.add(acc);
        }

        Stack<String> history = new Stack<>();
        Queue<String> billQueue = new LinkedList<>();
        Queue<BankAccount> accountRequests = new LinkedList<>();

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Enter Bank");
            System.out.println("2. Enter ATM");
            System.out.println("3. Admin Area");
            System.out.println("4. Exit");
            int mainChoice = sc.nextInt();
            sc.nextLine();

            if (mainChoice == 1) {
                System.out.println("1-Request Open Account, 2-Deposit, 3-Withdraw, 4-Pay Bill, 5-Undo");
                int bankChoice = sc.nextInt();
                sc.nextLine();

                if (bankChoice == 1) {
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    accountRequests.add(new BankAccount("Pending", name, 0));
                    System.out.println("Request sent to admin.");
                }
                else if (bankChoice == 2 || bankChoice == 3) {
                    System.out.print("Username: ");
                    String name = sc.nextLine();
                    boolean found = false;
                    for (BankAccount acc : accounts) {
                        if (acc.username.equals(name)) {
                            found = true;
                            System.out.print("Amount: ");
                            double amt = sc.nextDouble();
                            if (bankChoice == 2) {
                                acc.balance += amt;
                                history.push("Deposit " + amt + " to " + name);
                                System.out.println("Done! New balance: " + acc.balance);
                            } else {
                                if (acc.balance >= amt) {
                                    acc.balance -= amt;
                                    history.push("Withdraw " + amt + " from " + name);
                                    System.out.println("Done! New balance: " + acc.balance);
                                } else {
                                    System.out.println("Not enough money");
                                }
                            }
                        }
                    }
                    if (!found) System.out.println("Account not found");
                }
                else if (bankChoice == 4) {
                    System.out.print("Enter Bill Name: ");
                    String bill = sc.nextLine();
                    billQueue.add(bill);
                    System.out.println("Added to queue: " + bill);
                }
                else if (bankChoice == 5) {
                    if (!history.isEmpty()) {
                        System.out.println("Undo: " + history.pop() + " removed");
                    } else {
                        System.out.println("History is empty");
                    }
                }
            }

            else if (mainChoice == 2) {
                System.out.print("Enter username: ");
                String name = sc.nextLine();
                for (BankAccount acc : accounts) {
                    if (acc.username.equals(name)) {
                        System.out.println("1-Check Balance, 2-Withdraw");
                        int atmChoice = sc.nextInt();
                        if (atmChoice == 1) System.out.println("Balance: " + acc.balance);
                        else if (atmChoice == 2) {
                            System.out.print("Amount: ");
                            double amt = sc.nextDouble();
                            if (acc.balance >= amt) {
                                acc.balance -= amt;
                                history.push("ATM Withdraw " + amt + " from " + name);
                                System.out.println("Success");
                            } else System.out.println("No money");
                        }
                    }
                }
            }

            else if (mainChoice == 3) {
                System.out.println("1-Process Account, 2-Process Bill, 3-Show All");
                int adminChoice = sc.nextInt();
                if (adminChoice == 1) {
                    if (!accountRequests.isEmpty()) {
                        BankAccount newAcc = accountRequests.poll();
                        newAcc.accountNumber = "10" + (accounts.size() + 1);
                        accounts.add(newAcc);
                        System.out.println("Account approved for " + newAcc.username);
                    } else System.out.println("No requests");
                }
                else if (adminChoice == 2) {
                    if (!billQueue.isEmpty()) {
                        System.out.println("Processing: " + billQueue.poll());
                    } else System.out.println("No bills");
                }
                else if (adminChoice == 3) {
                    for (BankAccount acc : accounts) {
                        System.out.println(acc.username + " - " + acc.balance);
                    }
                }
            }

            else if (mainChoice == 4) {
                break;
            }
        }
    }
}