import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        int[] students = new int[n + 1];

        for (int i = 0; i < lost.length; i++) {
            students[lost[i]]--;
        }
        for (int i = 0; i < reserve.length; i++) {
            students[reserve[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (students[i] == -1) {
                if (i > 1 && students[i - 1] == 1) { // 1보다 크고, 이전의 학생이 체육복이 있다면,
                    students[i - 1] = 0;
                    students[i] = 0;
                } else if (i < n && students[i + 1] == 1) { // n보다 작고, 이후의 학생이 체육복이 있다면
                    students[i + 1] = 0;
                    students[i] = 0;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (students[i] >= 0) count++;
        }

        return count;
    }
}
