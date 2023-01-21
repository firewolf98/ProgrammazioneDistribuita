/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.HashMap;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;


/**
 *
 * @author Eugenio
 */
@Interceptor
public class CounterMethodInterceptor {
    private HashMap<String,Integer> counter = new HashMap<>();
    @AroundInvoke
    public Object counterMethod(InvocationContext ic) throws Exception
    {
        if(counter.get(ic.getMethod().getName()) != null)
        {
            int count = counter.get(ic.getMethod().getName());
            count++;
            System.out.println("Il metodo "+ic.getMethod().getName()+" è stato invocato "+count+" volte");
            counter.put(ic.getMethod().getName(), count);
        }
        else
        {
            counter.put(ic.getMethod().getName(), 1);
            System.out.println("Il metodo "+ic.getMethod().getName()+" è stato invocato 1 volta");
        
        }
        return ic.proceed();
    }
}
