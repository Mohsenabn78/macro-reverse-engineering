package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.nearby.zznq;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzbt extends zzu {

    /* renamed from: b  reason: collision with root package name */
    private static final zznq f22458b = new zzbs();

    /* renamed from: a  reason: collision with root package name */
    private final ListenerHolder f22459a;

    public zzbt(ListenerHolder listenerHolder) {
        this.f22459a = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzv
    public final void zzd() {
        this.f22459a.notifyListener(f22458b);
    }
}
