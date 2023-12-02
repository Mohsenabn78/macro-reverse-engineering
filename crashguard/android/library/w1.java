package crashguard.android.library;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class w1 implements a0 {

    /* renamed from: a  reason: collision with root package name */
    private final a f39085a;

    /* renamed from: b  reason: collision with root package name */
    private int f39086b = 0;

    /* loaded from: classes6.dex */
    interface a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w1(a aVar) {
        this.f39085a = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public /* synthetic */ void onActivityCreated(Activity activity, Bundle bundle) {
        z.a(this, activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public /* synthetic */ void onActivityDestroyed(Activity activity) {
        z.b(this, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public /* synthetic */ void onActivityPaused(Activity activity) {
        z.c(this, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public /* synthetic */ void onActivityResumed(Activity activity) {
        z.d(this, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public /* synthetic */ void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        z.e(this, activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(@NonNull Activity activity) {
        int i4;
        if (CrashGuardActivity.class.getName().equals(activity.getClass().getName())) {
            i4 = -1;
        } else {
            i4 = 1;
        }
        int i5 = this.f39086b + i4;
        this.f39086b = i5;
        if (i5 > 0) {
            ((q0) this.f39085a).s();
            return;
        }
        this.f39086b = 0;
        ((q0) this.f39085a).r();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(@NonNull Activity activity) {
        int i4 = this.f39086b - 1;
        this.f39086b = i4;
        if (i4 > 0) {
            ((q0) this.f39085a).s();
            return;
        }
        this.f39086b = 0;
        ((q0) this.f39085a).r();
    }
}
