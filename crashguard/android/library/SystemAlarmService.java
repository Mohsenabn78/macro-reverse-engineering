package crashguard.android.library;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
import java.util.LinkedList;

/* loaded from: classes6.dex */
public class SystemAlarmService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedList f38610a = new LinkedList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i4) {
        try {
            int indexOf = this.f38610a.indexOf(Integer.valueOf(i4));
            if (indexOf > -1) {
                this.f38610a.remove(indexOf);
                if (this.f38610a.size() < 1 && stopSelfResult(i4)) {
                    return;
                }
            }
            if (this.f38610a.isEmpty()) {
                stopSelf();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        super.onStartCommand(intent, i4, i5);
        try {
            Bundle bundleExtra = intent.getBundleExtra(c0.f38660l);
            if (bundleExtra != null) {
                this.f38610a.add(Integer.valueOf(i5));
                g6.b(getApplicationContext()).e(new AlarmWorkerService(getApplicationContext(), bundleExtra, new AlarmServiceWorkerListener(this, i5), i5));
                return 2;
            }
            return 2;
        } catch (Throwable unused) {
            return 2;
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i4) {
        super.onTrimMemory(i4);
    }
}
