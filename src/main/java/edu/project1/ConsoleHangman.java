//package edu.project1;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class ConsoleHangman {
//    public static void main(String[] args) {
//        String Word = "hello";
//        char[] WordGame = Word.toCharArray();
//        char[] WordSectret = new char[WordGame.length];
//        Arrays.fill(WordSectret, '*');
//        System.out.println(WordGame);
//        System.out.println(WordSectret);
//        boolean flag = true;
//        boolean check = false;
//        char sym;
//        Scanner in = new Scanner(System.in);
//        while (flag) {
//            check = false;
//            sym = in.next().charAt(0);
//            for (int i = 0; i < WordSectret.length; i++) {
//                if (WordGame[i] == sym) {
//                    WordSectret[i] = sym;
//                    check = true;
//                }
//            }
//            if (!check) {
//                System.out.println("No char");
//            } else {
//                System.out.println("Have char");
//            }
//            System.out.println(WordSectret);
//        }
//    }
//}
