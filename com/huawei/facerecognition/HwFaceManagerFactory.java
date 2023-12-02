package com.huawei.facerecognition;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes6.dex */
public class HwFaceManagerFactory {
    private static final String TAG = "FaceRecognize";

    private HwFaceManagerFactory() {
    }

    public static synchronized FaceManager getFaceManager(Context context) {
        synchronized (HwFaceManagerFactory.class) {
            try {
                try {
                    try {
                        if (Build.VERSION.SDK_INT < 29) {
                            Log.e(TAG, "The current version does not support face recognition");
                            return null;
                        }
                        return (FaceManager) Class.forName("com.huawei.facerecognition.FaceManagerFactory").getDeclaredMethod("getFaceManager", Context.class).invoke(null, context);
                    } catch (IllegalAccessException unused) {
                        Log.i(TAG, "Throw exception: IllegalAccessException");
                        return null;
                    } catch (InvocationTargetException unused2) {
                        Log.i(TAG, "Throw exception: InvocationTargetException");
                        return null;
                    }
                } catch (ClassNotFoundException unused3) {
                    Log.i(TAG, "Throw exception: ClassNotFoundException");
                    return null;
                }
            } catch (NoSuchMethodException unused4) {
                Log.i(TAG, "Throw exception: NoSuchMethodException");
                return null;
            }
        }
    }
}
