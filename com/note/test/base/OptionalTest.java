package note.test.base;

import com.google.common.base.Optional;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>对为空对象的封装类,替代null,使代码中只有不为空的对象和Optional对象(可能为null的对象) </p>
 * <p>
 *     当拿到一个对象为Optional类型时,需要主动去考虑为空的情况处理, 这是Optional的好处
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lvxz5
 * @version 1.0
 * @date 2016/11/8
 * @since 1.0
 */
public class OptionalTest {

    /**
     * 创建引用不为空的Optional
     * 传入null,抛异常
     */
    @Test(expected = NullPointerException.class)
    public void optionalOf() {
        Optional optional = Optional.of(null);
    }

    /**
     * 创建引用缺失的Optional
     */
    @Test
    public void optionalAbsent() {
        Optional optional = Optional.absent();
    }

    /**
     * 创建为空时引用缺失的Optional
     */
    @Test
    public void optionalfromNullable() {
        Optional optional = Optional.fromNullable(null);
    }

    /**
     * 判断是否为空
     */
    @Test
    public void optionalIsPresent() {
        Optional optional = Optional.fromNullable(null);
        Optional optional2 = Optional.fromNullable(new Object());
        boolean b = optional.isPresent();
        Assert.assertFalse(b);
        boolean b2 = optional2.isPresent();
        Assert.assertTrue(b2);
    }

    /**
     * 获取不为空的引用
     */
    @Test(expected = IllegalStateException.class)
    public void optionalGet() {
        Optional optional = Optional.fromNullable(null);
        optional.get();
    }

    /**
     * 获取可能为空的引用,为空时返回默认值
     */
    @Test
    public void optionalOr() {
        Optional optional = Optional.fromNullable(null);
        Object num = optional.or(1);
        Assert.assertEquals(num,1);
    }

    /**
     * 获取可能为空的引用,为空时返回null
     */
    @Test
    public void optionalOrNull(){
        Optional optional = Optional.fromNullable(null);
        Object num = optional.orNull();
        Assert.assertNull(num);

    }

    @Test
    public void optionalAsSet_null(){
        Optional optional = Optional.fromNullable(null);
        Set<Object> set =  optional.asSet();
        System.out.println(set);
    }

    @Test
    public void optionalAsSet_notnull(){
        Set<Object> originalSet = new HashSet<>();
        originalSet.add(new Object());
        Optional optional = Optional.fromNullable(originalSet);
        Set<Object> set =  optional.asSet();
        System.out.println(set);
    }




}
