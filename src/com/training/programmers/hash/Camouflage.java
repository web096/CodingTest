package com.training.programmers.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Camouflage {
    public static void main(String[] args) {

        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution(clothes));

    }

    public static int solution(String[][] clothes) {

        int answer = 0;

        List<String> keyName = new ArrayList<String>();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        for(int i = 0; i < clothes.length; i++) {

            if(hm.containsKey(clothes[i][1])) {
                int typeCount = hm.get(clothes[i][1])+1;

                hm.put(clothes[i][1], typeCount);
            }else {
                keyName.add(clothes[i][1]);
                hm.put(clothes[i][1], 1);
            }

        }

        //System.out.println(hm);
        for(int j = 0; j < keyName.size(); j++) {

            if(answer > 0) {
                answer = answer * (hm.get(keyName.get(j))+1);
            } else {
                answer = hm.get(keyName.get(j))+1; //옷 타별로 안입었을 경우 추가
            }

        }
        //옷을 아무것도 안입을 케이스 제외
        return answer-1;

    }
}
