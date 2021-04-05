import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

// 프로그래머스 level3 _ 정확도 PASS, 효율성 FAIL
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        HashSet<String> kinds = new HashSet<>(Arrays.asList(gems)); //보석 종류
        HashMap<String, Integer> resultMap = new HashMap< >();
        int min = Integer.MAX_VALUE;

        for(int i = 0; i<gems.length;i++){
            if (!resultMap.containsKey(gems[i]))
                resultMap.put(gems[i], i);
            else if(resultMap.containsKey(gems[i])){
                resultMap.remove(gems[i]);
                resultMap.put(gems[i], i);
            }

            // 보석의 모든 종류가 다 들어옴
            if(resultMap.size() == kinds.size()){
                Vector<Integer> tmp = new Vector<>(resultMap.values());
                Object[] tmpArr = tmp.toArray();
                Arrays.sort(tmpArr);

                // 기존의 구간과 현재 구간을 비교, 더 적으면 교체
                if(min > (int)tmpArr[tmpArr.length-1] - (int)tmpArr[0]) {
                    min = (int) tmpArr[tmpArr.length - 1] - (int) tmpArr[0];
                    answer[0] = (int)tmpArr[0]+1;
                    if(tmpArr.length == 0)
                        answer[1] = (int)tmpArr[0]+1;
                    answer[1] = (int)tmpArr[tmpArr.length-1]+1;
                }
            }
        }
        return answer;
    }
}

