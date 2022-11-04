import java.util.*;

class Solution {
    static int MAX = 10000000;
    static int SQRT_MAX = 3163;
    static int[] count = new int[10];
    static int[] digits = new int[10];
    static boolean[] non_prime = new boolean[MAX];

    static boolean check(int num){
        Arrays.fill(digits, 0);

        while(num>0){
            digits[num%10]++;
            num/=10;
        }

        for (int i = 0; i < 10; i++) {
            if (digits[i]>count[i])
                return false;
        }

        return true;
    }

    public int solution(String numbers) {

        for (int i = 0; i < numbers.length(); i++) {
            count[numbers.charAt(i)-'0']++;
        }

        // 에라토스테네스의 체
        for (int num = 2; num <= SQRT_MAX; num++) {
            if (non_prime[num]) continue;
            for (int i = num*2; i < MAX; i+=num) {
                non_prime[i] = true;
            }
        }

        int answer = 0;

        // 소수만 체크하면서 만들수 있는 수인지 확인
        for (int num = 2; num < MAX; num++) {
            if (non_prime[num]) continue;
            if (check(num)) answer++;
        }

        return answer;
    }

}
