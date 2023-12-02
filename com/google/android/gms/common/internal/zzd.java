package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzd extends zzab {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private BaseGmsClient f20558a;

    /* renamed from: b  reason: collision with root package name */
    private final int f20559b;

    public zzd(@NonNull BaseGmsClient baseGmsClient, int i4) {
        this.f20558a = baseGmsClient;
        this.f20559b = i4;
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    @BinderThread
    public final void onPostInitComplete(int i4, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
        Preconditions.checkNotNull(this.f20558a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f20558a.onPostInitHandler(i4, iBinder, bundle, this.f20559b);
        this.f20558a = null;
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    @BinderThread
    public final void zzb(int i4, @Nullable Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    @BinderThread
    public final void zzc(int i4, @NonNull IBinder iBinder, @NonNull zzj zzjVar) {
        BaseGmsClient baseGmsClient = this.f20558a;
        Preconditions.checkNotNull(baseGmsClient, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        Preconditions.checkNotNull(zzjVar);
        BaseGmsClient.zzj(baseGmsClient, zzjVar);
        onPostInitComplete(i4, iBinder, zzjVar.f20564a);
    }
}
