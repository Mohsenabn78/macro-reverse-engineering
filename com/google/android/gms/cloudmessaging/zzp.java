package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
/* loaded from: classes4.dex */
public abstract class zzp<T> {

    /* renamed from: a  reason: collision with root package name */
    final int f19918a;

    /* renamed from: b  reason: collision with root package name */
    final TaskCompletionSource<T> f19919b = new TaskCompletionSource<>();

    /* renamed from: c  reason: collision with root package name */
    final int f19920c;

    /* renamed from: d  reason: collision with root package name */
    final Bundle f19921d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(int i4, int i5, Bundle bundle) {
        this.f19918a = i4;
        this.f19920c = i5;
        this.f19921d = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(zzq zzqVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzqVar);
            StringBuilder sb = new StringBuilder(valueOf.length() + 14 + valueOf2.length());
            sb.append("Failing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
        }
        this.f19919b.setException(zzqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(T t3) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t3);
            StringBuilder sb = new StringBuilder(valueOf.length() + 16 + valueOf2.length());
            sb.append("Finishing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
        }
        this.f19919b.setResult(t3);
    }

    public final String toString() {
        int i4 = this.f19920c;
        int i5 = this.f19918a;
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i4);
        sb.append(" id=");
        sb.append(i5);
        sb.append(" oneWay=");
        sb.append(b());
        sb.append("}");
        return sb.toString();
    }
}
