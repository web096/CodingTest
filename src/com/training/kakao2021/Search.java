package com.training.kakao2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Search {

    public static void main(String[] args) {

        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        solution(info, query);
    }

    public static int[] solution(String[] info, String[] query){

        /*
         * hashMap
         * bit 연산을 이용한 부분집합
         * 이진탐색(binary search)
         * */

        Map<String, Integer> Wordmap = new HashMap<>();
        List<List<Integer>> ScoreList = new ArrayList<>();

        Wordmap.put("-",0);
        Wordmap.put("cpp",1);
        Wordmap.put("java",2);
        Wordmap.put("python",3);
        Wordmap.put("backend",1);
        Wordmap.put("frontend",2);
        Wordmap.put("junior",1);
        Wordmap.put("senior",2);
        Wordmap.put("chicken",1);
        Wordmap.put("pizza",2);

        for(int i = 0;i < 4*3*3*3; i++){
            ScoreList.add(new ArrayList<>());
        }

        for(String str : info){
            String[] word = str.split(" ");
            int[] arr = {Wordmap.get(word[0]),
                    Wordmap.get(word[1]),
                    Wordmap.get(word[2]),
                    Wordmap.get(word[3])
            };
            int score = Integer.parseInt(word[4]);
            System.out.println("length ::> "+arr.length);
            //부분집합
            for(int i = 0; i<(1<<arr.length); i++){ //부분집합의 경우의 수를 확인
                int idx = 0;
                for(int j = 0; j < arr.length; j++){ //부분집합 생성
                    if((i & (1<<j)) != 0){
                        System.out.println("i ::> "+arr[i]+" j ::>"+arr[j]);
                    }
                }
            }
        }

        int[] answer = {};
        return answer;
    }
}
