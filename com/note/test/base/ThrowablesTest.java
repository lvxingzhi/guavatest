package note.test.base;

import com.google.common.base.Throwables;
import org.junit.Test;

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
public class ThrowablesTest {

    /**
     * 直接抛出ERROR,RUNTIMEEXCEPTION
     * 把非RUNTIMEEXCEPTION包装为RUNTIMEEXCEPTION抛出
     */
    @Test
    public void t_throwablesProPagate(){
        Throwables.propagate(new Exception());
    }

    /**
     * 抛出指定的异常类型
     * 其他类型不抛出
     */
    @Test
    public void t_throwablesPropagateIfInstanceof(){
        Throwables.propagateIfInstanceOf(new Exception(),RuntimeException.class);
    }

    /**
     * 抛出ERROR,RUNTIMEEXCEPTION
     * 其他类型不抛出
     */
    @Test
    public void t_throwablesPropagateIfPossible_01(){
        Throwables.propagateIfPossible(new Exception());
    }

    /**
     * 抛出ERROR,RUNTIMEEXCEPTION,以及指定类型异常
     * 其他类型不抛出
     */
    @Test
    public void t_throwablesPropagateIfPossible_02(){
        Throwables.propagateIfPossible(new Exception(),RuntimeException.class);
    }

    ////////////////////////////////工具方法


    /**
     * 获取异常的真实异常类型
     */
    @Test
    public void t_throwablesGetRootCause(){
        Exception e = new NullPointerException();
        RuntimeException rune = new RuntimeException(e);
        System.out.println(rune);
        Throwable t = Throwables.getRootCause(rune);
        System.out.println(t);
    }

    /**
     * 获取异常所有层级
     */
    @Test
    public void t_throwablesGetCausalChain(){
        Exception e = new NullPointerException();
        RuntimeException rune = new RuntimeException(e);
        List<Throwable> list = Throwables.getCausalChain(rune);
        System.out.println(list.toString());
    }

    /**
     * 获取异常所有层级
     */
    @Test
    public void t_throwablesGetStackTraceAsString(){
        Exception e = new NullPointerException("asdf");
        RuntimeException rune = new RuntimeException(e);
        String str = Throwables.getStackTraceAsString(rune);
        System.out.println(str);
    }

}
