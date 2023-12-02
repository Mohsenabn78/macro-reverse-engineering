package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
final class zze extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f25228a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zze(zzg zzgVar, Handler handler, TaskCompletionSource taskCompletionSource) {
        super(handler);
        this.f25228a = taskCompletionSource;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i4, Bundle bundle) {
        if (i4 != 1) {
            if (i4 != 2) {
                this.f25228a.trySetResult(1);
                return;
            } else {
                this.f25228a.trySetResult(0);
                return;
            }
        }
        this.f25228a.trySetResult(-1);
    }
}
