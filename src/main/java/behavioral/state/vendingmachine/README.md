# Vending Machine
In this scenario, the vending machine can be in different states depending on its current behavior. For example, if it's waiting for a customer to make a selection, it's in the "idle" state. If it's currently dispensing a product, it's in the "dispensing" state. By using the State pattern, we can encapsulate the behavior of each state into its own class, making it easier to manage and modify the vending machine's behavior.

First, let's define the states that our vending machine can be in:
```java
public interface VendingMachineState {
    void insertCoin();
    void selectProduct();
    void dispense();
}
```
Next, let's create concrete implementations of each state:
```java
public class IdleState implements VendingMachineState {
    private final VendingMachine vendingMachine;
    
    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted");
        vendingMachine.setState(new CoinInsertedState(vendingMachine));
    }

    @Override
    public void selectProduct() {
        System.out.println("Please insert a coin first");
    }

    @Override
    public void dispense() {
        System.out.println("Please select a product first");
    }
}

public class CoinInsertedState implements VendingMachineState {
    private final VendingMachine vendingMachine;
    
    public CoinInsertedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted");
    }

    @Override
    public void selectProduct() {
        System.out.println("Product selected");
        vendingMachine.setState(new DispensingState(vendingMachine));
    }

    @Override
    public void dispense() {
        System.out.println("Please select a product first");
    }
}

public class DispensingState implements VendingMachineState {
    private final VendingMachine vendingMachine;
    
    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted");
    }

    @Override
    public void selectProduct() {
        System.out.println("Product already selected");
    }

    @Override
    public void dispense() {
        System.out.println("Product dispensed");
        vendingMachine.setState(new IdleState(vendingMachine));
    }
}
```
Each state implements the `VendingMachineState` interface, which defines the methods that can be called on the state. The `IdleState` is the initial state of the vending machine, and it handles the behavior when the machine is waiting for a coin to be inserted. The `CoinInsertedState` is the state when a coin has been inserted, and the machine is waiting for a product to be selected. The `DispensingState` is the state when a product has been selected, and the machine is dispensing the product.

Finally, let's create the `VendingMachine` class, which will keep track of the current state of the machine and delegate behavior to that state:
```java
public class VendingMachine {  
    private VendingMachineState currentState;  
  
 public VendingMachine() {  
        this.currentState = new IdleState(this);  
  }  
  
    public void insertCoin() {  
        currentState.insertCoin();  
  }  
  
    public void selectProduct() {  
        currentState.selectProduct();  
  }  
  
    public void dispense() {  
        currentState.dispense();  
  }  
  
    public void setCurrentState(VendingMachineState state) {  
        this.currentState = state;  
  }  
}
```