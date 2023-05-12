package Taskkk_3;

public class MyDoubleStack {
    private int[] arr;
    private int red;
    private int blue;

    public MyDoubleStack(int capacity) {
        arr = new int[capacity];
        red= capacity;
        blue = -1;
    }

   
    public int pop1() {
        if (isEmpty1()) {
            throw new RuntimeException("Stack 1 is empty");
        }
        return arr[blue--];
    }

    public int pop2() {
        if (isEmpty2()) {
            throw new RuntimeException("Stack 2 is empty");
        }
        return arr[red++];
    }
    public void push1(int item) {
        if (isFull1()) {
            throw new RuntimeException("Stack 1 is full");
        }
        arr[++blue] = item;
    }

    public void push2(int item) {
        if (isFull2()) {
            throw new RuntimeException("Stack 2 is full");
        }
        arr[--red] = item;
    }
    public boolean isEmpty1() {
        return blue == -1;
    }

    public boolean isEmpty2() {
        return red == arr.length;
    }

    public boolean isFull1() {
        return blue + 1 == red;
    }

    public boolean isFull2() {
        return red - 1 == blue;
    }

    public static void main(String[] args) {
        MyDoubleStack stack = new MyDoubleStack(8);
        stack.push1(1);
        stack.push2(2);
        stack.push1(3);
        stack.push2(4);
        stack.push1(5);
        stack.push2(6);
        stack.push1(7);
        stack.push2(8);
        System.out.println(stack.pop1());
        System.out.println(stack.pop2());
    }
}
