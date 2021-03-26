package com.training.programmers.hash;

import java.util.*;

public class MusicSort {
    public static void main(String[] args) {

        String[] genres = {"pop", "classic", "pop", "pop"};
        int[] plays = {600, 500, 2500, 600};

        System.out.println(solution(genres, plays));
    }


    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        List<Integer> genresSort = new ArrayList<Integer>();

        for(int i = 0; i < genres.length; i++) {

            if(hm.containsKey(genres[i]))
                hm.put(genres[i], (hm.get(genres[i])+plays[i]));
            else
                hm.put(genres[i], plays[i]);

        }

        List<String> genresList = sortByValue(hm);

        for(String genresStr : genresList) {

            HashMap<String, Integer> hmPlays = new HashMap<String, Integer>();

            for(int j = 0; j < genres.length; j++) {
                if(genresStr.equals(genres[j]))
                    hmPlays.put(Integer.toString(j),plays[j]);

            }

            List<String> playsList = sortByValue(hmPlays);

            if(playsList.size() > 0) {

                if(playsList.size() < 2) {
                    genresSort.add(Integer.parseInt(playsList.get(0)));

                }else{

                    for(int k = 0; k < 2; k++) {

                        genresSort.add(Integer.parseInt(playsList.get(k)));
                    }

                }
            }
        }

        answer = new int[genresSort.size()];

        for(int h=0; h < answer.length; h++) {
            answer[h] = genresSort.get(h);
        }

        return answer;
    }

    public static List<String> sortByValue(HashMap<String, Integer> hm){

        List<String> keyNameList = new ArrayList<String>();
        keyNameList.addAll(hm.keySet());


        Collections.sort(keyNameList, new Comparator() {

            public int compare(Object o1, Object o2) {
                Object v1 = hm.get(o1);
                Object v2 = hm.get(o2);

                int result = ((Comparable) v1).compareTo(v2);

                if(result == 0) { //비고값이 같을경우 낮은 인덱스값을 처리한다.(아래 역순정렬이라서 비교값을 변경했다.)
                    return ((Comparable) o2).compareTo(o1);
                }

                return result;

            }

        });

        Collections.reverse(keyNameList); //역순정렬

        return keyNameList;
    }
}
