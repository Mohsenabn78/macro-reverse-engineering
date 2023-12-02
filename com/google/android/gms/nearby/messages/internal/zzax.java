package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzax extends zzbg {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ListenerHolder f22430c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzbh f22431d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzax(zzbh zzbhVar, ListenerHolder listenerHolder, ListenerHolder listenerHolder2) {
        super(listenerHolder);
        this.f22431d = zzbhVar;
        this.f22430c = listenerHolder2;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzbg, com.google.android.gms.nearby.messages.internal.zzab
    public final void zzd() {
        ListenerHolder.ListenerKey<?> listenerKey = this.f22430c.getListenerKey();
        if (listenerKey != null) {
            this.f22431d.doUnregisterEventListener(listenerKey);
        }
        super.zzd();
    }
}
