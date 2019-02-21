import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Solution5 s = new Solution5();
        s.Permutation("aas");

    }

    //二维数组中的查找
    public boolean Find(int target, int[][] array) {
        for (int[] a : array) {
            for (int i : a) {
                if (i == target) {
                    return true;
                }
            }
        }
        return false;
    }

    //替换空格
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

    //从尾到头打印链表
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        ListNode temp = listNode;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }

    //重建二叉树
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //确定根节点
        TreeNode t = null;
        int l = 0;
        boolean f = true;
        for (int a : pre) {
            for (int i = 0; i < in.length; i++) {
                if (a == in[i]) {
                    t = new TreeNode(a);
                    l = i;
                    f = false;
                    break;
                }
            }
            if (!f) {
                break;
            }
        }
        //确定左子树
        if (l == 0) {
            t.left = null;
        } else {
            int[] inl = new int[l];
            for (int i = 0; i < l; i++) {
                inl[i] = in[i];
            }
            TreeNode leftTree = reConstructBinaryTree(pre, inl);
            t.left = leftTree;
        }
        //确定右子树
        if (l == in.length - 1) {
            t.right = null;
        } else {
            int[] inr = new int[in.length - l - 1];
            for (int i = 0; i < inr.length; i++) {
                inr[i] = in[i + l + 1];
            }
            TreeNode rightTree = reConstructBinaryTree(pre, inr);
            t.right = rightTree;
        }
        return t;
    }

    //用两个栈实现堆
    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack2.empty()) {
                if (stack1.empty()) {
                    throw new RuntimeException("Queue is empty!");
                }
                int a;
                while (!stack1.empty()) {
                    a = stack1.pop();
                    stack2.push(a);
                }
            }
            return stack2.pop();
        }
    }

    //数组的旋转
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[0];
    }

    //斐波那契数列
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int a = Fibonacci(n - 1) + Fibonacci(n - 2);
        return a;
    }

    //跳青蛙
    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int a = JumpFloor(target - 1) + JumpFloor(target - 2);
        return a;
    }

    //变态跳青蛙
    public int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int b = 0;
        for (int i = 1; i < target; i++) {
            b += JumpFloorII(i);
        }
        return b + 1;
    }

    //覆盖矩形
    public int RectCover(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int b = RectCover(target - 1) + RectCover(target - 2);
        return b;
    }

    //二进制中1的个数
    public static int NumberOf1(int n) {
        int num = 0;
        char[] ns = Integer.toBinaryString(n).toCharArray();
        for (char ens : ns) {
            if (ens == '1') {
                num += 1;
            }
        }
        return num;
    }

    //给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
    public double Power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序
    public void reOrderArray(int[] array) {
        ArrayList<Integer> j = new ArrayList<Integer>();
        ArrayList<Integer> o = new ArrayList<Integer>();
        for (int i : array) {
            if (i % 2 == 0) {
                o.add(i);
            } else {
                j.add(i);
            }
        }
        j.addAll(o);
        for (int i = 0; i < array.length; i++) {
            array[i] = j.get(i);
        }
    }

    //输入一个链表，输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> s = new Stack<ListNode>();
        s.push(head);
        while (head.next != null) {
            head = head.next;
            s.push(head);
        }
        if (k > s.size()) {
            return null;
        }
        ListNode l = null;
        for (int i = 0; i < k; i++) {
            l = s.pop();
        }
        return l;
    }

    //输入一个链表，反转链表后，输出新链表的表头。
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> s = new Stack<ListNode>();
        while (head.next != null) {
            s.push(head);
            head = head.next;
        }
        ListNode newHead = head;
        while (!s.empty()) {
            head.next = s.pop();
            head = head.next;
        }
        head.next = null;
        return newHead;
    }

    //输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode result;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            result = list2;
            list2 = list2.next;
        } else {
            result = list1;
            list1 = list1.next;
        }
        ListNode a = result;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                result.next = list2;
                list2 = list2.next;
            } else {
                result.next = list1;
                list1 = list1.next;
            }
            result = result.next;
        }
        while (list1 != null) {
            result.next = list1;
            list1 = list1.next;
            result = result.next;
        }
        while (list2 != null) {
            result.next = list2;
            list2 = list2.next;
            result = result.next;
        }
        return a;
    }

    //输入两棵二叉树A，B，判断B是不是A的子结构。
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubtree(root1, root2) || HasSubtree(root1.right, root2) || HasSubtree(root1.left, root2);
    }

    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
        } else {
            return false;
        }
    }

    //操作给定的二叉树，将其变换为源二叉树的镜像。
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        } else {
            if (root.left != null) {
                Mirror(root.left);
            }
            if (root.right != null) {
                Mirror(root.right);
            }
            TreeNode a = root.left;
            root.left = root.right;
            root.right = a;
        }
    }

    //输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
    public ArrayList<Integer> printMatrix_(int a, int m, int n, int[][] matrix, ArrayList<Integer> result) {
        if (n - 2 * a == 1) {
            for (int x = a; x < m - a; x++) {
                result.add(matrix[a][x]);
            }
            return result;
        }
        if (m - 2 * a == 1) {
            for (int y = a; y < n - a; y++) {
                result.add(matrix[y][m - a - 1]);
            }
            return result;
        }
        for (int x = a; x < m - a; x++) {
            result.add(matrix[a][x]);
        }
        for (int y = a + 1; y < n - a; y++) {
            result.add(matrix[y][m - a - 1]);
        }
        for (int x = m - a - 2; x > a - 1; x--) {
            result.add(matrix[n - a - 1][x]);
        }
        for (int y = n - a - 2; y > a; y--) {
            result.add(matrix[y][a]);
        }
        return result;
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int m = matrix[0].length;
        int n = matrix.length;
        int a = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (m - 2 * a > 0 && n - 2 * a > 0) {
            result = printMatrix_(a, m, n, matrix, result);
            a += 1;
        }
        return result;
    }

    //定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数
    public class Solution2 {
        private Stack<Integer> s1 = new Stack<>();
        private Stack<Integer> s2 = new Stack<>();

        public void push(int node) {
            s1.push(node);
            if (s2.size() == 0) {
                s2.push(node);
            } else {
                if (s2.peek() >= node) {
                    s2.push(node);
                }
            }
        }

        public void pop() {
            if (s1.pop() == s2.peek()) {
                s2.pop();
            }
        }

        public int top() {
            return s1.peek();
        }

        public int min() {
            return s2.peek();
        }
    }

    //输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> s = new Stack<>();
        int a = 0;
        for (int i : pushA) {
            s.push(i);
            while (s.size() != 0 && s.peek() != popA[a]) {
                a += 1;
                s.pop();
            }
        }
        if (a == pushA.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    //从上往下打印出二叉树的每个节点，同层节点从左至右打印。
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<TreeNode> nodes = new ArrayList<>();
        if (root == null) {
            return result;
        }
        nodes.add(root);
        for (int i = 0; i < nodes.size(); i++) {
            result.add(nodes.get(i).val);
            if (nodes.get(i).left != null) {
                nodes.add(nodes.get(i).left);
            }
            if (nodes.get(i).right != null) {
                nodes.add(nodes.get(i).right);
            }
        }
        return result;

    }

    //输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int last = sequence[sequence.length - 1];
        int n = 0;
        for (; n < sequence.length - 1; n++) {
            if (sequence[n] > last) {
                break;
            }
        }
        int i = n;
        for (; i < sequence.length - 1; i++) {
            if (sequence[i] < last) {
                return false;
            }
        }
        boolean l = true;
        boolean r = true;
        if (n != 0) {
            int[] f = Arrays.copyOfRange(sequence, 0, n);
            l = VerifySquenceOfBST(f);
        }
        if (n != sequence.length - 1) {
            int[] b = Arrays.copyOfRange(sequence, n, sequence.length - 1);
            r = VerifySquenceOfBST(b);
        }
        return l && r;
    }

    //输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径
    public class Solution3 {
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();

        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
            if (root == null) {
                return paths;
            }
            path.add(root.val);
            if (root.left == null && root.right == null && target == root.val) {
                paths.add(new ArrayList<>(path));
            }
            if (root.left != null && target >= root.val) {
                FindPath(root.left, target - root.val);
            }
            if (root.right != null && target >= root.val) {
                FindPath(root.right, target - root.val);
            }
            path.remove(path.size() - 1);
            return paths;
        }
    }

    //输入一个复杂链表，返回结果为复制后复杂链表的head
    public class Solution4 {
        public RandomListNode Clone(RandomListNode pHead) {
            if (pHead == null) {
                return null;
            }
            RandomListNode runner = pHead;
            RandomListNode copy = null;
            while (runner != null) {
                copy = new RandomListNode(runner.label);
                copy.next = runner.next;
                runner.next = copy;
                runner = copy.next;
            }

            runner = pHead;
            while (runner != null) {
                copy = runner.next;
                copy.random = runner.random == null ? null : runner.random.next;
                runner = runner.next.next;
            }

            runner = pHead;
            pHead = runner.next;
            while (true) {
                copy = runner.next;
                runner.next = copy.next;
                runner = copy.next;
                if (runner == null) {
                    break;
                } else {
                    copy.next = runner.next;
                }
            }
            return pHead;
        }
    }

    //输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode plast = null;
        plast = convertNode(plast, pRootOfTree);
        TreeNode result = plast;
        while (plast.left != null) {
            plast = plast.left;
        }
        return result;

    }

    public TreeNode convertNode(TreeNode plast, TreeNode cur) {
        if (cur == null) {
            return null;
        }
        if (cur.left != null) {
            plast = convertNode(plast, cur.left);
        }
        cur.left = plast;
        if (plast != null) {
            plast.right = cur;
        }
        plast = cur;
        if (cur.right != null) {
            plast = convertNode(plast, cur.right);
        }
        return plast;
    }

    //输入一个字符串,按字典序打印出该字符串中字符的所有排列
    public static class Solution5 {
        ArrayList<String> result = new ArrayList<>();

        public String permutationString(String s, char[] chars) {
            String s1 = String.valueOf(s);
            for (char c : chars) {
                s = s1;
                s = s + c;
                if (chars.length != 1) {
                    char[] chars1 = new char[chars.length-1];
                    int i = 0;
                    boolean f = true;
                    for(char a : chars){
                        if(a!=c || !f){
                            chars1[i] = a;
                            i++;
                        }else {
                            f = false;
                        }
                    }
                    s = permutationString(s, chars1);
                }else {
                    if(!result.contains(s)){
                        result.add(s);
                    }
                }
            }
            return s;
        }

        public ArrayList<String> Permutation(String str) {
            if (str == null) {
                return null;
            }
            char[] chars = str.toCharArray();
            String s = "";
            permutationString(s, chars);
            System.out.println(result);
            return result;
        }
    }

    //数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
    public int MoreThanHalfNum_Solution(int [] array) {
        for (int b : array) {
            int i = 0;
            for (int a : array) {
                if (a == b) {
                    i++;
                }
                if (i > array.length / 2) {
                    return a;
                }
            }

        }
        return 0;
    }

    //输入n个整数，找出其中最小的K个数
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(k>input.length){
            return null;
        }
        Arrays.sort(input);
        for(int i =0;i<k;i++){
            result.add(input[i]);
        }
        return result;
    }
}

