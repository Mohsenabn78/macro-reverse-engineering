package crashguard.android.library;

import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;

/* loaded from: classes6.dex */
public class AlarmWorkerService extends f1 {

    /* renamed from: d  reason: collision with root package name */
    private final int f38591d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlarmWorkerService(Context context, Bundle bundle, AlarmServiceWorkerListener alarmServiceWorkerListener, int i4) {
        super(context, bundle, alarmServiceWorkerListener);
        this.f38591d = i4;
    }

    @Override // crashguard.android.library.f1, java.lang.Runnable
    public void run() {
        PowerManager.WakeLock newWakeLock = ((PowerManager) a().getSystemService("power")).newWakeLock(1, String.format("CG:%s", String.valueOf(this.f38591d)));
        try {
            newWakeLock.acquire(5000L);
            super.run();
        } finally {
            if (newWakeLock.isHeld()) {
                newWakeLock.release();
            }
        }
    }
}
