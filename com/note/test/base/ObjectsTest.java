package note.test.base;

import com.google.common.base.Objects;
import org.junit.Assert;
import org.junit.Test;

/**
 * <p>TODO <p>
 *
 * @author note
 * @version 1.0.0
 * @date 2016/11/8.
 */
public class ObjectsTest {

    @Test
    public void t_objectsEqual_01(){
        boolean b = Objects.equal("a",new String("a"));
        System.out.println(b);
        Assert.assertTrue(b);
    }

    @Test
    public void t_objectsEqual_02(){
        boolean b = Objects.equal(null,new String("a"));
        System.out.println(b);
        Assert.assertFalse(b);
    }

    @Test
    public void t_objectsEqual_03(){
        boolean b = Objects.equal("a",null);
        System.out.println(b);
        Assert.assertFalse(b);
    }

    @Test
    public void t_objectsEqual_04(){
        boolean b = Objects.equal(null,null);
        System.out.println(b);
        Assert.assertTrue(b);
    }

    @Test
    public void t_objectsHashCode_01(){
        int hashCode1= Objects.hashCode("1","2","3");
        System.out.println(hashCode1);
    }

    @Test
    public void t_objectsHashCode_02(){
        int hashCode1= Objects.hashCode("1","2","3");
        int hashCode2= Objects.hashCode("2","3","1");
        System.out.println(hashCode1+   "    " +   hashCode2);
    }


}
