package com.google.android.gms.nearby.messages.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.nearby.zznq;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public class zzbg extends zzaa {

    /* renamed from: b  reason: collision with root package name */
    private static final zznq f22438b = new zzbf();
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final ListenerHolder f22439a;

    public zzbg(@Nullable ListenerHolder listenerHolder) {
        this.f22439a = listenerHolder;
    }

    public void zzd() {
        ListenerHolder listenerHolder = this.f22439a;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(f22438b);
        }
    }
}
