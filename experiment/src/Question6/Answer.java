package Question6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Answer {
    public static Map<Character, Integer> map = new HashMap<>();
    public static Map<Integer, Character> remap = new HashMap<>();

    public static void Init(String s) {
        RecordType[] cnt = new RecordType[25];
        for (int i = 0; i < 25; i++)
            cnt[i].ch = i;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            cnt[temp - 'A'].num++;
        }
        for (int i = 0; i < 25; i++)
            for (int j = i + 1; j < 25; j++) {
                if (cnt[i].num > cnt[j].num) {
                    RecordType temp = cnt[i];
                    cnt[i] = cnt[j];
                    cnt[j] = temp;
                }
            }
        Tree Huffman = new Tree(cnt[0].num, (Tree) null, null);
        for (int i = 1; i < 25; i++) {
            if (cnt[i].num == 0)
                break;
            Node now = new Node((char) (cnt[i].ch + 'A'), cnt[i].num, null, null);
            Huffman = new Tree(cnt[i].num + Huffman.root.w, now, Huffman);
        }
        Node node = Huffman.root;
        int temp = 0;
        while (node.right != null) {
            if (node.left != null) {
                map.put(node.left.ch, temp);
                remap.put(temp, node.left.ch);
                temp = (temp + 1) * 10;
                node = node.right;
            }
        }
        map.put(node.ch, temp + 1);
        remap.put(temp + 1, node.ch);
    }

    public static ArrayList<Integer> Encode(String s, Map<Character, Integer> map) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
            ans.add(map.get(s.charAt(i)));
        return ans;
    }

    public static String Decode(ArrayList<Integer> encode, Map<Character, Integer> map) {
        StringBuilder result = new StringBuilder();
        for (Integer integer : encode)
            result.append(remap.get(integer));
        return result.toString();
    }

    public static void main(String[] args) {
        String s;
        Scanner reader = new Scanner(System.in);
        s = reader.next();
        ArrayList<Integer> encode = Encode(s, map);
        String decode = Decode(encode, map);
        System.out.println(decode);
    }
}
