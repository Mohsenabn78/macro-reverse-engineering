package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {

    /* renamed from: a  reason: collision with root package name */
    private final ListenerHolder f20092a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Feature[] f20093b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f20094c;

    /* renamed from: d  reason: collision with root package name */
    private final int f20095d;

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public RegisterListenerMethod(@NonNull ListenerHolder<L> listenerHolder, @Nullable Feature[] featureArr, boolean z3, int i4) {
        this.f20092a = listenerHolder;
        this.f20093b = featureArr;
        this.f20094c = z3;
        this.f20095d = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public abstract void a(@NonNull A a4, @NonNull TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;

    @KeepForSdk
    public void clearListener() {
        this.f20092a.clear();
    }

    @Nullable
    @KeepForSdk
    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.f20092a.getListenerKey();
    }

    @Nullable
    @KeepForSdk
    public Feature[] getRequiredFeatures() {
        return this.f20093b;
    }

    public final int zaa() {
        return this.f20095d;
    }

    public final boolean zab() {
        return this.f20094c;
    }
}
