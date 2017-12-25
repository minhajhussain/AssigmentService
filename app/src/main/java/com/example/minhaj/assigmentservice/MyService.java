package com.example.minhaj.assigmentservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    
   public static final String TAG = "MTAG";
    private int limit;

    public MyService() {
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: service created");
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: service started");

        Thread t= new Thread(new Runnable(){
            @Override
            public void run() {
                Log.d(TAG, "run: running");
                for(int i=0;i < intent.getIntExtra("Limit",0) ;i++){
                    try{
                        Thread.sleep(1000);
                        Log.d(TAG, "run: loop" + i);
                    }catch (Exception e){

                    }
                }
            }
        });

        t.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: service destroyed");
    }
}
