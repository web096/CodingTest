package com.training.kakao2021;

import java.util.Arrays;
import java.util.List;

public class advertisement {
    /*
    *[문제]
        “죠르디”의 동영상 재생시간 길이 play_time, 공익광고의 재생시간 길이 adv_time, 시청자들이 해당 동영상을 재생했던 구간 정보 logs가 매개변수로 주어질 때, 시청자들의 누적 재생시간이 가장 많이 나오는 곳에 공익광고를 삽입하려고 합니다.
        이때, 공익광고가 들어갈 시작 시각을 구해서 return 하도록 solution 함수를 완성해 주세요. 만약, 시청자들의 누적 재생시간이 가장 많은 곳이 여러 곳이라면, 그중에서 가장 빠른 시작 시각을 return 하도록 합니다.

      [제한사항]
        play_time, adv_time은 길이 8로 고정된 문자열입니다.
        play_time, adv_time은 HH:MM:SS 형식이며, 00:00:01 이상 99:59:59 이하입니다.
        즉, 동영상 재생시간과 공익광고 재생시간은 00시간 00분 01초 이상 99시간 59분 59초 이하입니다.
        공익광고 재생시간은 동영상 재생시간보다 짧거나 같게 주어집니다.
        logs는 크기가 1 이상 300,000 이하인 문자열 배열입니다.
        logs 배열의 각 원소는 시청자의 재생 구간을 나타냅니다.
        logs 배열의 각 원소는 길이가 17로 고정된 문자열입니다.
        logs 배열의 각 원소는 H1:M1:S1-H2:M2:S2 형식입니다.
        H1:M1:S1은 동영상이 시작된 시각, H2:M2:S2는 동영상이 종료된 시각을 나타냅니다.
        H1:M1:S1은 H2:M2:S2보다 1초 이상 이전 시각으로 주어집니다.
        H1:M1:S1과 H2:M2:S2는 play_time 이내의 시각입니다.
        시간을 나타내는 HH, H1, H2의 범위는 00~99, 분을 나타내는 MM, M1, M2의 범위는 00~59, 초를 나타내는 SS, S1, S2의 범위는 00~59까지 사용됩니다. 잘못된 시각은 입력으로 주어지지 않습니다. (예: 04:60:24, 11:12:78, 123:12:45 등)
        return 값의 형식
        공익광고를 삽입할 시각을 HH:MM:SS 형식의 8자리 문자열로 반환합니다.
    * */

    public static void main(String[] args){

        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        System.out.println(solution(play_time, adv_time, logs));
    }

    public static String solution(String play_time, String adv_time, String[] logs){
        /*
         * TODO https://tech.kakao.com/2021/01/25/2021-kakao-recruitment-round-1/ 5번 광고삽입
         * 각 시간들을 초단위로 변경하여 배열의 인덱스로 이용한다.
         * example
         * playTime 1분이라면 60초이고 60개의 배열을 생성한다.
         * advTime 15초라면 60개의 배열 중 15개의 인덱스로 생각하면 된다.
         * 각 구간별 재생기록 역시 초로 환산하여 배열의 해당 인덱스에 +1 sum해준다.
         * advTime의 크기로 합산하며 최고 함이 큰 인덱스의 시작점을 찾는다.
         */
        int playSec = timeToSecond(play_time);
        int advSec = timeToSecond(adv_time);

        int[] total_time = new int[playSec]; //초기값 0

        for(String log : logs){
            String[] viewTime = log.split("-");
            int logStartSec = timeToSecond(viewTime[0]);
            int logEndSec = timeToSecond(viewTime[1]);

            for(int i = logStartSec; i < logEndSec; i++){
                total_time[i] += 1;
            }
        }

        long currSum = 0; //logs의 크기가 300,000이하인 문자열이므로 int의 범위를 벗어난다.
        for(int i = 0; i < advSec; i++){
            currSum += total_time[i]; //최초 인덱스부터 광고 시간까지 배열의 인덱스의 값을 합하여 초기화 한다.
        }

        long maxSum = currSum;
        int maxIdx = 0;
        for(int i = advSec; i < playSec; i++){ //초기화 시점 이후부터 플레이 시간의 끝까지 배열의 인덱스를 1칸씩 이동한다.
            currSum = currSum + total_time[i] - total_time[i - advSec]; //배열의 인덱스의 값을 합하는데 이미 지나온(total_time[i-advSec]) 인덱스의 값을 제외한다.

            if(maxSum < currSum){
                maxSum = currSum;
                maxIdx = i - advSec + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Long.toString((maxIdx / 60 /60 % 24)));
        sb.append(":");
        sb.append(Long.toString((maxIdx / 60 % 60)));
        sb.append(":");
        sb.append(Long.toString((maxIdx % 60)));

        return sb.toString();
    }

    public static int timeToSecond(String time){

        String[] value = time.split(":");

        return (Integer.parseInt(value[0]) * 60 * 60)+(Integer.parseInt(value[1]) * 60)+Integer.parseInt(value[2]);
    }
}
