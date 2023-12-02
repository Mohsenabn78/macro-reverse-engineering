package com.google.android.gms.nearby.messages.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.nearby.zznq;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public class zzbe extends zzu {

    /* renamed from: b  reason: collision with root package name */
    private static final zznq f22436b = new zzbd();
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final ListenerHolder f22437a;

    public zzbe(@Nullable ListenerHolder listenerHolder) {
        this.f22437a = listenerHolder;
    }

    public void zzd() {
        ListenerHolder listenerHolder = this.f22437a;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(f22436b);
        }
    }
}
