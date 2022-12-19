package before.step1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Ex6_6_Collections {
    @SuppressWarnings("unchecked")
    public static <E> List<E> sorted(
            Collection<E> collection,
            Comparator<? super E> by
    ) {
        // '이 에 따라 toAr ray를 호출한 사람은 자유롭게 반환된 배열을 변경해도 된다.
        // 원본 컬렉션에는 영향이 없다.
        var result = (E[]) collection.toArray(); // ArrayList의 내부는 배열로 뒷받침되기 때문에 원소를 추가하거나 제거할수 없다.
        Arrays.sort(result, by);
        return Arrays.asList(result);
    }
}
