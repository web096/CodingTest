package com.training.kakao2021;

import java.util.*;

public class Search {

    public static void main(String[] args) {

        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        int[] results = solution(info, query);

        for(int result : results ){
            System.out.println("result ::> "+result);
        }


    }

    public static int[] solution(String[] info, String[] query){

        /*
         * TODO https://tech.kakao.com/2021/01/25/2021-kakao-recruitment-round-1/ 3번 순위검색
         * 1차원 배열로 문제 풀이
         * 완전탐색(비트마스크)
         * hashMap
         * bit 연산을 이용한 부분집합
         * 이진탐색(binary search) / Lower Bound
         * Lower Bound와 Upper Bound는 일종의 이분 탐색에서 파생된 것으로,
         * 이분 탐색이 '원하는 값 k를 찾는 과정' 이라면 Lower Bound는 '원하는 값 k 이상이 처음 나오는 위치를 찾는 과정' 이며, Upper Bound는 '원하는 값 k를 초과한 값이 처음 나오는 위치를 찾는 과정'이다.
         * * [조건]을 만족하는 사람 중 코딩 테스트 점수를 X점 [이상] 받은 사람은 모두 몇 명인가?
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
            int[] arr = {Wordmap.get(word[0]) *3*3*3,
                    Wordmap.get(word[1]) *3*3,
                    Wordmap.get(word[2]) *3,
                    Wordmap.get(word[3])
            };
            int score = Integer.parseInt(word[4]);

            //부분집합(binarySearch)
            for(int i = 0; i<(1<<arr.length); i++){ //부분집합의 경우의 수를 확인 (비트연산 << n는 왼쪽으로 n만큼 왼쪽으로 시프트한다. 2의 n승을 의미한한다.)
                int idx = 0;
                for(int j = 0; j < arr.length; j++){ //부분집합 생성
                    if((i & (1<<j)) != 0){
                        idx += arr[j];
                    }
                }
                ScoreList.get(idx).add(score);
            }
        }

        for(int i = 0; i<4*3*3*3; i++)
            Collections.sort(ScoreList.get(i));
//System.out.println("sort after ::> "+ScoreList);
        int[] answer = new int[query.length];
        for(int i = 0; i< query.length; i++){
            String[] word = query[i].split(" ");
            //조건에 맞는 index값을 찾는다.
            int idx = Wordmap.get(word[0]) *3*3*3 +
                    Wordmap.get(word[2]) *3*3 +
                    Wordmap.get(word[4]) *3 +
                    Wordmap.get(word[6]);
            int score = Integer.parseInt(word[7]);
            //조건의 index에서 해당하는 점수가 있는지 조회한다. ret값이 음수(-)가 나온다는건 해당 index에 값이 없다는것을 뜻한다.
            int ret = Collections.binarySearch(ScoreList.get(idx), score);

            if(ret < 0){
                ret = -(ret+1);
            }else{
                for(int j = ret -1; j>=0; j--){
                    if(ScoreList.get(idx).get(j) == score) {
                        ret = j;
                    } else {
                        break; //score와 다른값이라면 lower bound
                    }
                }
            }
//System.out.println("idx ::> "+idx);
//System.out.println("ScoreList idx ::> "+ScoreList.get(idx));
//System.out.println("ScoreList size ::> "+ScoreList.get(idx).size());
//System.out.println("ret ::> "+ret);
            answer[i] = ScoreList.get(idx).size() - ret; //SocreList.get(idx) 사이즈에 ret의 위치값을 빼면 나머지 갯수를 알수 있다.
        }

        return answer;
    }
}
