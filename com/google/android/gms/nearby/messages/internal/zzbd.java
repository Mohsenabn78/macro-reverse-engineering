package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.internal.nearby.zznq;
import com.google.android.gms.nearby.messages.PublishCallback;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzbd extends zznq {
    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((PublishCallback) obj).onExpired();
    }
}
