package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfe implements zzeh {
    @Nullable
    private Message zza;
    @Nullable
    private zzff zzb;

    private zzfe() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfe(zzfd zzfdVar) {
    }

    private final void zzd() {
        this.zza = null;
        this.zzb = null;
        zzff.zzl(this);
    }

    @Override // com.google.android.gms.internal.ads.zzeh
    public final void zza() {
        Message message = this.zza;
        message.getClass();
        message.sendToTarget();
        zzd();
    }

    public final zzfe zzb(Message message, zzff zzffVar) {
        this.zza = message;
        this.zzb = zzffVar;
        return this;
    }

    public final boolean zzc(Handler handler) {
        Message message = this.zza;
        message.getClass();
        boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
        zzd();
        return sendMessageAtFrontOfQueue;
    }
}
