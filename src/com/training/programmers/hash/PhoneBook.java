package com.training.programmers.hash;

import java.util.HashMap;

public class PhoneBook {

    public static void main(String[] args) {

        String[] phone_book = {"123", "456", "789"};

        System.out.println(solution(phone_book));

    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        for(String phone : phone_book){

            int number = 0;
            HashMap<Integer, String> hm = new HashMap<Integer, String>();

            for(int i=0;i<phone_book.length;i++){
                if(!phone.equals(phone_book[i])) {
                    hm.put(number,phone.length() < phone_book[i].length() ? phone_book[i].substring(0,phone.length()) : (String)phone_book[i]);
                    number++;
                }
            }

            for(int j=0;j<hm.size();j++){
                if(phone.equals(hm.get(j)))
                    return false;
            }
        }

        return answer;
    }
}
