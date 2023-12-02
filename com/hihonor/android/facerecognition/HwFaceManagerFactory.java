package com.hihonor.android.facerecognition;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.hihonor.android.facerecognition.FaceManager;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HwFaceManagerFactory.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/hihonor/android/facerecognition/HwFaceManagerFactory;", "", "Landroid/content/Context;", "context", "Lcom/hihonor/android/facerecognition/FaceManager;", "getFaceManager", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "biometric_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class HwFaceManagerFactory {
    @NotNull
    public static final HwFaceManagerFactory INSTANCE = new HwFaceManagerFactory();

    private HwFaceManagerFactory() {
    }

    @JvmStatic
    @Nullable
    public static final synchronized FaceManager getFaceManager(@Nullable Context context) {
        synchronized (HwFaceManagerFactory.class) {
            try {
                try {
                    try {
                        if (Build.VERSION.SDK_INT < 29) {
                            Log.e("FaceRecognize", "The current version does not support face recognition");
                            return null;
                        }
                        FaceManager.Companion companion = FaceManager.Companion;
                        return (FaceManager) FaceManager.class.getDeclaredMethod("getFaceManager", Context.class).invoke(null, context);
                    } catch (IllegalAccessException unused) {
                        Log.i("FaceRecognize", "Throw exception: IllegalAccessException");
                        return null;
                    } catch (InvocationTargetException unused2) {
                        Log.i("FaceRecognize", "Throw exception: InvocationTargetException");
                        return null;
                    }
                } catch (ClassNotFoundException unused3) {
                    Log.i("FaceRecognize", "Throw exception: ClassNotFoundException");
                    return null;
                }
            } catch (NoSuchMethodException unused4) {
                Log.i("FaceRecognize", "Throw exception: NoSuchMethodException");
                return null;
            }
        }
    }
}
