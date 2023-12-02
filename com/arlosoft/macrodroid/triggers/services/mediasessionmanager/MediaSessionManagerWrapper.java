package com.arlosoft.macrodroid.triggers.services.mediasessionmanager;

import android.content.Context;
import android.media.session.MediaSessionManager;
import android.os.Handler;
import android.view.KeyEvent;
import androidx.annotation.RequiresApi;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@RequiresApi(api = 23)
/* loaded from: classes3.dex */
public class MediaSessionManagerWrapper {

    /* renamed from: a  reason: collision with root package name */
    private MediaSessionManager f15575a;

    /* renamed from: b  reason: collision with root package name */
    private VolumeKeyLongPressListener f15576b;

    /* loaded from: classes3.dex */
    public class ProxyListener implements InvocationHandler {
        public ProxyListener() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            MediaSessionManagerWrapper.this.f15576b.onVolumeKeyLongPress((KeyEvent) objArr[0]);
            return new Object();
        }
    }

    /* loaded from: classes3.dex */
    public interface VolumeKeyLongPressListener {
        void onVolumeKeyLongPress(KeyEvent keyEvent);
    }

    public MediaSessionManagerWrapper(Context context, VolumeKeyLongPressListener volumeKeyLongPressListener) {
        Object systemService;
        this.f15576b = volumeKeyLongPressListener;
        systemService = context.getSystemService(MediaSessionManager.class);
        MediaSessionManager mediaSessionManager = (MediaSessionManager) systemService;
        this.f15575a = mediaSessionManager;
        try {
            mediaSessionManager.getClass();
            Class<?> cls = Class.forName("android.media.session.MediaSessionManager$OnVolumeKeyLongPressListener");
            this.f15575a.getClass().getMethod("setOnVolumeKeyLongPressListener", cls, Handler.class).invoke(this.f15575a, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new ProxyListener()), null);
        } catch (Exception e4) {
            SystemLog.logError("Failed to call setOnVolumeKeyLongPressListener: " + e4.toString());
        }
    }
}
