package test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Listen listen = new IntListenImpl();
        System.out.println(listen.add("Роберт"));
        System.out.println(listen.getSize());
        System.out.println(listen.add("Ульяна"));
        System.out.println(listen.getSize());
        System.out.println(listen.contains("Роберт"));
        System.out.println(listen.remove("Роберт"));
        System.out.println(listen.contains("Роберт"));
        System.out.println(listen.getSize());
        System.out.println(listen.add("Урал"));
        System.out.println(listen.indexOf("Урал"));
        System.out.println(listen.lastIndexOf("Урал"));
        System.out.println(listen.indexOf("Ульяна"));
        System.out.println(listen.set(1, "Ваня"));
        System.out.println(listen.contains("Урал"));
        System.out.println(Arrays.toString(listen.toArray()));
        System.out.println(listen.remove(1));
        System.out.println(listen.contains("Ваня"));
        System.out.println(listen.getSize());
        System.out.println(listen.add(0, "Анна"));
        System.out.println(Arrays.toString(listen.toArray()));
        Listen listen2 = new IntListenImpl();
        listen2.add(("Ульяна"));
        listen2.add(("Урал"));
        System.out.println(listen.equals(listen2));
        listen.clear();
        System.out.println(listen.getSize());
    }
}




