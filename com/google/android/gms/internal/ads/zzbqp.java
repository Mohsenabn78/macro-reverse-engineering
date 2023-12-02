package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzbqp implements View.OnClickListener {
    final /* synthetic */ zzbqq zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbqp(zzbqq zzbqqVar) {
        this.zza = zzbqqVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zza.zza(true);
    }
}
