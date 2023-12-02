package crashguard.android.library;

import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class AlarmServiceWorkerListener implements a1 {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<SystemAlarmService> f38589a;

    /* renamed from: b  reason: collision with root package name */
    private final int f38590b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlarmServiceWorkerListener(SystemAlarmService systemAlarmService, int i4) {
        this.f38589a = new WeakReference<>(systemAlarmService);
        this.f38590b = i4;
    }

    @Override // crashguard.android.library.a1
    public void onWorkFinished() {
        try {
            this.f38589a.get().a(this.f38590b);
        } catch (Throwable unused) {
        }
    }
}
