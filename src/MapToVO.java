import java.util.HashMap;
import java.util.Map;

public class MapToVO {



    public static Object convertMapToPojo(Map<String,String> test , Object pojo){

        java.lang.reflect.Method[] methods = pojo.getClass().getMethods();

        Map methodMap = new HashMap();
        String prefix = "set";

        for(java.lang.reflect.Method checkMethod : methods){
            String methodNameCheck = checkMethod.getName();
            try {
                if(methodNameCheck.startsWith(prefix)) {
                    String methodKey = methodNameCheck.substring(3,methodNameCheck.length());
                    System.out.println(methodKey + " : " + test.get(methodKey));
                    checkMethod.invoke(pojo, test.get(methodKey));
                }
            }catch (Exception e){

            }
        }

        TestPojo test1 = (TestPojo)pojo;
        System.out.println(test1.toString());
        return pojo;
    }


    public static void main(String args[]){

        TestPojo test = new TestPojo();
        HashMap map = new HashMap();

        map.put("KEY_TEST" , "test111");
        map.put("TEST_VAR1" , "test111");
        map.put("TEST_VAR2" , "test222");
        map.put("TEST_VAR3" , "test333");
        map.put("TEST_VAR4" , "test444");

        TestPojo check = (TestPojo)MapToVO.convertMapToPojo(map , test);
    }
}
