package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcfd implements View.OnAttachStateChangeListener {
    final /* synthetic */ zzbws zza;
    final /* synthetic */ zzcfg zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcfd(zzcfg zzcfgVar, zzbws zzbwsVar) {
        this.zzb = zzcfgVar;
        this.zza = zzbwsVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzb.zzR(view, this.zza, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
