abstract class Bank {
    abstract int getBalance();
}

class BankA extends Bank {
    private int balance = 100;

    // Default constructor
    public BankA() {
        super(); // This is not necessary, but it's added for clarity
    }

    @Override
    int getBalance() {
        return balance;
    }
}

class BankB extends Bank {
    private int balance = 150;

    // Default constructor
    public BankB() {
        super(); // This is not necessary, but it's added for clarity
    }

    @Override
    int getBalance() {
        return balance;
    }
}

class BankC extends Bank {
    private int balance = 200;

    // Default constructor
    public BankC() {
        super(); // This is not necessary, but it's added for clarity
    }

    @Override
    int getBalance() {
        return balance;
    }
}

public class BankTest {
    public static void main(String[] args) {
        BankA bankA = new BankA();
        BankB bankB = new BankB();
        BankC bankC = new BankC();

        System.out.println("Balance in Bank A: Rs." + bankA.getBalance());
        System.out.println("Balance in Bank B: Rs." + bankB.getBalance());
        System.out.println("Balance in Bank C: Rs." + bankC.getBalance());
    }
}
