package note.test.base;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <p>TODO </p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lvxz5
 * @version 1.0
 * @date 2016/11/9
 * @since 1.0
 */
public class OrderingTest {

    /**
     * 比较器初始化
     */
    @Test
    public void t_orderingInit_01(){
        // 初始化比较器1 以自然排序比较
        Ordering order = Ordering.natural();
        // 初始化比较器2   以字符串比较
        Ordering order2 = Ordering.usingToString();
        // 初始化比较器3  以comparator比较
        Ordering order3 = Ordering.from(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });

    }

    /**
     * 取最小值
     */
    @Test
    public void t_orderingMin_01(){
        Ordering order = Ordering.natural();
        long time1 = System.currentTimeMillis();
        long time2 = System.currentTimeMillis()+10;
        System.out.println(time1);
        System.out.println(time2);
        long time3 = (long)order.max(time1,time2);
        System.out.println(time3);
    }

    /**
     * 取最小值
     */
    @Test
    public void t_orderingMin_02(){
        Ordering order = Ordering.natural();
        long time1 = System.currentTimeMillis();
        long time2 = System.currentTimeMillis()+10;
        System.out.println(time1);
        System.out.println(time2);
        long time3 = (long)order.min(time1,time2);
        System.out.println(time3);
    }

    /**
     * 取最大值
     */
    @Test
    public void t_orderingMax_01(){
        Ordering order = Ordering.natural();
        long time1 = System.currentTimeMillis();
        long time2 = System.currentTimeMillis()+10;
        System.out.println(time1);
        System.out.println(time2);
        long time3 = (long)order.max(time1,time2);
        System.out.println(time3);
    }

    /**
     * 获取语义相反的排序器
     */
    @Test
    public void t_orderingReverse_1(){
        Ordering order = Ordering.natural();
        order = order.reverse();
    }

    /**
     * 获取把Null排在前面的排序器
     */
    @Test
    public void t_orderingNullsFirst_1(){
        Ordering order = Ordering.natural();
        order = order.nullsFirst();
    }

    /**
     * 获取把Null排在后面的排序器
     */
    @Test
    public void t_orderingNullsLast_1(){
        Ordering order = Ordering.natural();
        order = order.nullsLast();
    }

    /**
     * 给排序器增加相等时的排序规则
     */
    @Test
    public void t_orderingCompound_1(){
        Ordering order = Ordering.natural();
        order = order.compound(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
    }

    /**
     * 对计算结果进行排序的排序器
     */
    @Test
    public void t_orderingOnResultOf_01(){
        Ordering order = Ordering.natural();
        order.onResultOf(new Function() {
            @Override
            public Object apply(Object o) {
                return null;
            }
        });
    }

////////////////////////////////////////对迭代器的方法应用

    /**
     * 获取最大的前6个
     */
    @Test
    public void t_greatestOf_01(){
        Ordering order = Ordering.natural();
        List list = new ArrayList();
        order.greatestOf(list.iterator(),6);
    }

    /**
     * 获取最大的前6个
     */
    @Test
    public void t_greatestOf_02(){
        Ordering order = Ordering.natural();
        List list = new ArrayList();
        order.greatestOf(list,6);
    }

    /**
     * 判断是否已排序
     */
    public void t_isOrdered_01(){
        Ordering order = Ordering.natural();
        List list = new ArrayList();
        boolean b = order.isOrdered(list);
    }

    


}
