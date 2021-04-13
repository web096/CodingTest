package com.training.kakao2021;

import java.util.*;

public class MenuRenuwal {

    static List<Map<String, Integer>> FoodMaps = new ArrayList<>();
    static int[] MaxCnt = new int[11];

    public static void main(String[] args){

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};

        String[] result = solution(orders, course);
        Arrays.stream(result).forEach(System.out::println);

    }

    public static String[] solution(String[] orders, int[] course){
        /*
         * TODO https://tech.kakao.com/2021/01/25/2021-kakao-recruitment-round-1/ 2번 메뉴리뉴얼
         */

        for(int i=0; i<11; i++){
            FoodMaps.add(new HashMap<String, Integer>());
        }

        for(String str : orders){
            char[] arr = str.toCharArray();
            Arrays.sort(arr); //배열 정렬 default : 오름차순 / 내림차순으로 처리하고 싶을경우 Arrays.sort(arr, Collections.reversOrder())
            comb(arr, 0, new StringBuilder());
        }

        List<String> list = new ArrayList<>();
        for(int len : course){
            for(Map.Entry<String, Integer> entry : FoodMaps.get(len).entrySet()){ //HashMap or Map의 key와 value값을 확인하기 위해서 entry에 entrySet()을 사용한다. key값만 필요로 할 경우 keySet()을 사용한다.
                if(entry.getValue() >= 2 && entry.getValue() == MaxCnt[len]){
                    list.add(entry.getKey());
                }
            }
        }

        Collections.sort(list); //리스트형 정렬 defalut : 오름차순 / 내림차순으로 처리하고 싶을경우 Collections.revers(list)

        String[] answer = new String[list.size()];
        for (int i=0; i<list.size();i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void comb(char[] str, int pos, StringBuilder candi){

        if(pos >= str.length){
            int len = candi.length();
            if(len >= 2){
                int cnt = FoodMaps.get(len).getOrDefault(candi.toString(),0) +1; //HashMap에 값이 없을경우 기본값을 설정하기 위해서는 getOrDefault를 사용한다.
                FoodMaps.get(len).put(candi.toString(), cnt);
                MaxCnt[len] = Math.max(MaxCnt[len],cnt); //두값을 비교해서 큰값을 반환한다. 반대로 작을값을 반환하고자 할때는 Math.min을 사용한다.
            }
            return;
        }

        comb(str, pos+1, candi.append(str[pos])); //포함
        candi.setLength(candi.length()-1); //candi value 되돌리기
        comb(str, pos+1, candi); //불포함
    }
}
