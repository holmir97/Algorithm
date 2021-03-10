import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> nulList = Arrays.stream(nums).boxed().collect(Collectors.toList());\
        List<Integer> result = new ArrayList<>();
        int len = nums.length;

        for(int i =1; i< len +1;i++){
            if(nulList.contains(i))
                continue;
            else
                result.add(i);
        }
        return result;
    }
}
