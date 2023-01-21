/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Eugenio
 */
@Interceptor
public class CounterInterceptor {
    private int count = 0;
    @AroundInvoke
    
    public Object counter(InvocationContext ic) throws Exception{
        count ++;
        System.out.println("Il metodo "+ic.getMethod().getName()+ " è stato invocato ben "+ count+ " volte");
        return ic.proceed();
    }
    
}
