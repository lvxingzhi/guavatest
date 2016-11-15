package note.test.collections;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>不可变集合 <p>
 *
 * @author note
 * @version 1.0.0
 * @date 2016/11/15.
 */
public class CollectionsTest {

    /**
     * 初始化的三种方法-拷贝
     */
    @Test
    public void t_copyOf_01() {
        Set set = new HashSet<>();
        ImmutableSet immutableSet = ImmutableSet.copyOf(set);

    }

    /**
     * 初始化的三种方法-插入
     */
    @Test
    public void t_of_01() {
        ImmutableSet immutableSet = ImmutableSet.of("a", "b", "c", "d");
    }

    /**
     * 初始化的三种方法-多次累加
     */
    @Test
    public void t_builder() {
        List list = new ArrayList<> ();
        list.add("a");
        list.add("b");
        ImmutableSet immutableSet = ImmutableSet.builder().add("c").addAll(list).build();
        System.out.println(immutableSet.asList().get(0));
    }


}
