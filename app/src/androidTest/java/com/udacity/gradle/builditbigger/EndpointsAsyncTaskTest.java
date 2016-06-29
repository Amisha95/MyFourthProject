package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;

import org.mockito.Mock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class EndpointsAsyncTaskTest extends AndroidTestCase
{
    EndpointsAsyncTask endpointsAsyncTask;
    String result;
    @Mock
    Context mockContext;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        result=null;
        endpointsAsyncTask=new EndpointsAsyncTask() {
            @Override
        protected void onPostExecute(String Joke)
            {

            }
        };
    }

    public void testAsyncReturnType()
    {
        try{
            endpointsAsyncTask.execute(mockContext);
            result=endpointsAsyncTask.get(10, TimeUnit.SECONDS);
            assertNotNull(result);
        } catch (InterruptedException e) {
            fail("Timed out");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
