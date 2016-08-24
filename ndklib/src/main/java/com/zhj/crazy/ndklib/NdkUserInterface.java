package com.zhj.crazy.ndklib;
import android.util.Log;
/**
 * Created by Fred Zhao on 2016/8/24.
 */
public class NdkUserInterface {

    private static final String TAG = "NdkUserInterface";

    static {
        Log.d(TAG, "NdkUserInterface init load");
        System.loadLibrary("crazyFredNdk");
    }

    private static NdkUserInterface instance;

    /**
     * 单例获取interface
     *
     * @return
     */
    public static NdkUserInterface getInstance() {

        if (null == instance) {
            instance = new NdkUserInterface();
        }
        return instance;
    }

    public native String getNdkString();//本地方法

}
