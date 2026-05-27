package com.example.state;

public class CoffeMachine {
    private CoffeMachineSate state;
    private int balance = 0;

   private class NoCoinState implements CoffeMachineSate {
        @Override
        public void insertCoin() {
            balance += 50;
            System.out.println("Coin insert. Balance: " + balance);
            state = new HasCoinState();
        }
        @Override
        public void selectCoffe() {
            System.out.println("Not enough coins");
        }
        @Override
        public void dispense() {
            System.out.println("coffe not selected");
        }
    }

    private class HasCoinState implements CoffeMachineSate {
        @Override
        public void insertCoin() {
            balance += 50;
            System.out.println("Coin new insert. Balance: " + balance);
        }

        @Override
        public void selectCoffe() {
            if (balance >= 100){
                System.out.println("Select your coffe");
                state = new CoffeSelectedState();
            } else  {
                System.out.println("Not enough coins");
            }
        }

        @Override
        public void dispense() {
            System.out.println("coffe not selected");
        }
    }

    private class CoffeSelectedState implements CoffeMachineSate {
        @Override
        public void insertCoin() {
            System.out.println("Balance is full");
        }

        @Override
        public void selectCoffe() {
            System.out.println("Coffe is selected");
        }

        @Override
        public void dispense() {
            System.out.println("Enjoy your coffe");
            balance -= 100;
            state = balance > 0 ? new HasCoinState() : new NoCoinState();
        }
    }

    public  CoffeMachine() {
        this.state = new NoCoinState();
    }

    public void insertCoin() {
        state.insertCoin();
        System.out.println("Current state: " + state);
    }
    public void selectCoffe() {
       state.selectCoffe();
       System.out.println("Current state: " + state);
    }
    public void dispense() {
       state.dispense();
       System.out.println("Current state: " + state);
    }
}
