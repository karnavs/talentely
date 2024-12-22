/*The *Simple Banking System* GitHub repository contains code for a basic banking application that allows users to perform essential banking operations. 
Key features include account creation, balance inquiries, deposits, withdrawals, fund transfers, and transaction history.
The system supports user authentication with secure login and manages multiple accounts. 
Written in [insert programming language], this code serves as an educational tool for learning about object-oriented programming, file handling, and basic financial transactions in software development.*/

import java.util.Scanner;

public class SimpleBankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a sample customer and account
        Customer customer = new Customer("John Doe", "12345678", 1000.0);

        // Menu
        while (true) {
            System.out.println("\n --- Banking Menu --- ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    customer.getAccount().deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    customer.getAccount().withdraw(withdrawalAmount);
                    break;

                case 3:
                    customer.getAccount().checkBalance();
                    break;

                case 4:
                    System.out.println("Exiting ... Thank you for using the system!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

class Customer {
    private String name;
    private Account account;

    public Customer(String name, String accountNumber, double initialBalance) {
        this.name = name;
        this.account = new Account(name, accountNumber, initialBalance);
    }

    // Accessor Methods
    public Account getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }
}

class Account {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    // Constructor
    public Account(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful! New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal Successful! New Balance: " + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Balance Inquiry
    public void checkBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
}
/*Remove Duplicates from sorted array*/
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int slow = 1;
        
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        
        return slow;
    }
}
/*Length of Last word*/
class Solution {
    public int lengthOfLastWord(String s) {
        // Step 1: Trim the string to remove leading and trailing spaces
        s = s.trim();
        
        // Step 2: Find the length of the last word
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break; // Stop when we hit the first space
            }
            length++;
        }
        
        return length;
    }
}
/*Palindrome Number*/
public class Solution {
    public boolean isPalindrome(int x) {
        // Special case for negative numbers
        if (x < 0) return false;
        
        // Special case for numbers ending with 0
        if (x % 10 == 0 && x != 0) return false;
        
        int original = x;
        int reversed = 0;
        
        while (x > 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        
        return original == reversed;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] testCases = {121, -121, 10, 12321};
        
        for (int x : testCases) {
            System.out.println("Input: " + x + " -> Output: " + sol.isPalindrome(x));
        }
    }
}
/*Merge two sorted lists*/
class ListNode {
    int val;
    ListNode next;

    // Constructor
    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // Static deserialize method
    public static ListNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        String[] values = data.substring(1, data.length() - 1).split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (String val : values) {
            current.next = new ListNode(Integer.parseInt(val.trim()));
            current = current.next;
        }

        return dummy.next;
    }
}
/*Climbing stairs*/
public class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        
        int[] dp = new int[n + 1];
        dp[0] = 1; // 1 way to stand still (0 steps)
        dp[1] = 1; // 1 way to take one step (1 step)
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
}
/*Same Tree*/
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both trees are empty
        if (p == null && q == null) {
            return true;
        }
        // One of the trees is empty
        if (p == null || q == null) {
            return false;
        }
        // Values are different
        if (p.val != q.val) {
            return false;
        }
        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
/*Binary tree inorder traversal*/
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Traverse the left subtree
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // Process the node
            current = stack.pop();
            result.add(current.val);
            // Traverse the right subtree
            current = current.right;
        }

        return result;
    }
}
/*Converted Sorted Array to Binary tree*/
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { 
        this.val = val; 
        this.left = null; 
        this.right = null; 
    }
}

public class Solution {
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    // Helper function to build the tree recursively
    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;  // Base case: no elements to form a tree
        }

        // Find the middle element
        int mid = left + (right - left) / 2;

        // Create the root node with the middle element
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively build the left and right subtrees
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);

        return root;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: nums = [-10,-3,0,5,9]
        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNode root1 = solution.sortedArrayToBST(nums1);
        printTree(root1);  // You can implement a tree printer if you need to see the output

        // Example 2: nums = [1,3]
        int[] nums2 = {1, 3};
        TreeNode root2 = solution.sortedArrayToBST(nums2);
        printTree(root2);  // You can implement a tree printer if you need to see the output
    }

    // Helper function to print the tree (in-order traversal)
    private static void printTree(TreeNode root) {
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }
}
/*Balanced Binary Tree*/
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

public class Solution {
    
    // Main function to check if the tree is height-balanced
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1; // If the height is -1, the tree is unbalanced
    }

    // Helper function to check the balance and compute the height
    private int checkBalance(TreeNode node) {
        if (node == null) {
            return 0; // An empty tree is balanced with height 0
        }
        
        // Check left subtree
        int leftHeight = checkBalance(node.left);
        if (leftHeight == -1) {
            return -1; // If left subtree is unbalanced, propagate -1
        }
        
        // Check right subtree
        int rightHeight = checkBalance(node.right);
        if (rightHeight == -1) {
            return -1; // If right subtree is unbalanced, propagate -1
        }
        
        // Check if current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // If the difference in heights is greater than 1, it's unbalanced
        }
        
        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: root = [3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(solution.isBalanced(root1));  // Output: true

        // Example 2: root = [1,2,2,3,3,null,null,4,4]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);
        System.out.println(solution.isBalanced(root2));  // Output: false

        // Example 3: root = []
        TreeNode root3 = null;
        System.out.println(solution.isBalanced(root3));  // Output: true
    }
}
/*Minimum Depth of Binary tree*/
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

public class Solution {

    // Main function to find the minimum depth of the binary tree
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;  // If the tree is empty, depth is 0
        }

        // If the left child is null, we only care about the right subtree
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        
        // If the right child is null, we only care about the left subtree
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        // If both children are non-null, we compute the minimum depth of both subtrees
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        return Math.min(leftDepth, rightDepth) + 1; // Add 1 to account for the current node
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: root = [3, 9, 20, null, null, 15, 7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(solution.minDepth(root1));  // Output: 2

        // Example 2: root = [2, null, 3, null, 4, null, 5, null, 6]
        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(4);
        root2.right.right.right = new TreeNode(5);
        root2.right.right.right.right = new TreeNode(6);
        System.out.println(solution.minDepth(root2));  // Output: 5
    }
}
/*Pascal's Triangle*/
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        // Initialize the result list which will store all rows of Pascal's Triangle
        List<List<Integer>> triangle = new ArrayList<>();
        
        // Loop to generate each row of the triangle
        for (int i = 0; i < numRows; i++) {
            // Create a new row and set the size to i + 1 (for the i-th row)
            List<Integer> row = new ArrayList<>();
            
            // The first row element is always 1
            row.add(1);
            
            // Each element (except the first and last) is the sum of two elements above it
            for (int j = 1; j < i; j++) {
                row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
            }
            
            // The last row element is always 1
            if (i > 0) {
                row.add(1);
            }
            
            // Add the row to the triangle
            triangle.add(row);
        }
        
        return triangle;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: numRows = 5
        System.out.println(solution.generate(5));  
        // Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

        // Example 2: numRows = 1
        System.out.println(solution.generate(1));  
        // Output: [[1]]
    }
}
/*Two sum Problem*/
import java.util.HashMap;
import java.util.Scanner;

public class TwoSumSolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Input array elements
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Input target sum
        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();

        // Find and print the result
        int[] result = twoSum(nums, target);
        if (result.length == 2) {
            System.out.println("Indices of numbers adding up to the target: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two numbers add up to the target.");
        }

        scanner.close();
    }
    public static int[] twoSum(int[] nums, int target) {
        // Create a hashmap to store values and their indices
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        // Return empty array if no solution is found
        return new int[] {};
    }
}
/*Binary search tree*/
import java.util.Scanner;

public class BinarySearchProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the sorted array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements of the sorted array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the target value to search: ");
        int target = scanner.nextInt();

        int result = binarySearch(array, target);

        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found in the array.");
        }

        scanner.close();
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void printArray(int[] array) {
        System.out.print("Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void sortArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static boolean validateSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] parseInput(String input) {
        String[] parts = input.split(" ");
        int[] array = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            array[i] = Integer.parseInt(parts[i]);
        }
        return array;
    }

    public static int countOccurrences(int[] array, int target) {
        int count = 0;
        for (int num : array) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    public static int findMin(int[] array) {
        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }
}
/*Queue using an arrya*/
import java.util.Scanner;

public class ArrayQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;
        System.out.println(value + " enqueued to the queue.");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int value = queue[front];
        front = (front + 1) % queue.length;
        size--;
        System.out.println(value + " dequeued from the queue.");
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to peek.");
            return -1;
        }
        return queue[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % queue.length] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity of the queue: ");
        int capacity = scanner.nextInt();
        ArrayQueue queue = new ArrayQueue(capacity);

        while (true) {
            System.out.println("\n--- Queue Operations ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Check if Empty");
            System.out.println("6. Check if Full");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a value to enqueue: ");
                    int value = scanner.nextInt();
                    queue.enqueue(value);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    int frontValue = queue.peek();
                    if (frontValue != -1) {
                        System.out.println("Front of the queue: " + frontValue);
                    }
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    System.out.println(queue.isEmpty() ? "Queue is empty." : "Queue is not empty.");
                    break;
                case 6:
                    System.out.println(queue.isFull() ? "Queue is full." : "Queue is not full.");
                    break;
                case 7:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
