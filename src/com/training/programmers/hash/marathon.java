package com.training.programmers.hash;

import java.util.Arrays;

public class marathon {
    public void main(String[] args) {

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "misla"};

        System.out.println(solution(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0 ; i < completion.length; i++){
            if(!participant[i].equals(completion[i]))
                return participant[i];
        }
        answer = participant[completion.length];

        return answer;
    }
}
