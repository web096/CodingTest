package com.training.kakao2021;

public class IDrecommend {

    public static void main(String[] args){
        String new_id = "z-+.^.";
        System.out.println(solution(new_id));
    }

    public static String solution(String new_id){

         /*
         * https://tech.kakao.com/2021/01/25/2021-kakao-recruitment-round-1/ 1번 아이디추천
         * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
           2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
           3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
           4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
           5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
           6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
                만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
           7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
          */

        StringBuilder answer = new StringBuilder();

        boolean lastDot = false; //연속되는 '.'를 판변하기 위해 사용
        for(char ch : new_id.toCharArray()){
            if(!isValid(ch)) continue;
            if(ch == '.'){
                if(answer.length() == 0 || lastDot) continue;
                lastDot = true;
            }else{
                lastDot = false;
            }

            ch = Character.toLowerCase(ch);
            answer.append(ch);
        }

        if(answer.length() >= 16)
            answer.setLength(15); //setLength(길이) 원하는길이 외 나머지 문자는 삭제

        if(answer.length() == 0) //빈 문자열인 경우
            answer.append('a');

        if(answer.charAt(answer.length()-1) == '.') //charAt(index) 문자열의 index에 위치한 문자를 가져온다.
            answer.deleteCharAt(answer.length()-1); //deleteCharAt(index) 문자열의 index에 위치한 문자를 삭제한다.

        if(answer.length() <= 2){
            char lastLetter = answer.charAt(answer.length()-1);
            while (answer.length() < 3){
                answer.append(lastLetter);
            }
        }

        return answer.toString();
    }

    public static boolean isValid(char c){
        if(Character.isLetterOrDigit(c)) return true; //Letter : 문자 / Digit : 숫자 / 문자만 판별할때 Character.isLetter / 숫자만 판별할때 Character.isDigit
        if(c == '-' || c == '_' || c == '.') return true;

        return false;
    }
}
