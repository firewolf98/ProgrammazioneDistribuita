/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espositoluca;

import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Luca
 */
@Interceptor
@Counter
public class CounterInterceptor {
   private int counter = 0;
   @AroundInvoke
   public Object countMethod(InvocationContext ic) throws Exception
   {
       counter++;
       System.out.println(""+counter);
       try{
        return ic.proceed();
       }finally{
       }
   }
}
