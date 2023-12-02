package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.nearby.zznq;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzbw extends zzaa {

    /* renamed from: b  reason: collision with root package name */
    private static final zznq f22461b = new zzbv();

    /* renamed from: a  reason: collision with root package name */
    private final ListenerHolder f22462a;

    public zzbw(ListenerHolder listenerHolder) {
        this.f22462a = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzab
    public final void zzd() {
        this.f22462a.notifyListener(f22461b);
    }
}
