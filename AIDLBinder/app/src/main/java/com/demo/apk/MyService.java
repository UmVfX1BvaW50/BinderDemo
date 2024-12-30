package com.demo.apk;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {
    public MyService() {
    }


    // 实现AIDL接口
    private final IMyAidlInterface.Stub binder = new IMyAidlInterface.Stub() {
        @Override
        public String getMessage(String input) throws RemoteException {
            return "Hello, " + input + "! This is a message from the Binder service.";
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        //返回AIDL接口
        return binder;
    }

}