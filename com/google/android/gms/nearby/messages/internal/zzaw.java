package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzaw extends zzbe {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ListenerHolder f22428c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzbh f22429d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaw(zzbh zzbhVar, ListenerHolder listenerHolder, ListenerHolder listenerHolder2) {
        super(listenerHolder);
        this.f22429d = zzbhVar;
        this.f22428c = listenerHolder2;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzbe, com.google.android.gms.nearby.messages.internal.zzv
    public final void zzd() {
        ListenerHolder.ListenerKey<?> listenerKey = this.f22428c.getListenerKey();
        if (listenerKey != null) {
            this.f22429d.doUnregisterEventListener(listenerKey);
        }
        super.zzd();
    }
}
