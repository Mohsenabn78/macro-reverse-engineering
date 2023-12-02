package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzbqn implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbqo zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbqn(zzbqo zzbqoVar) {
        this.zza = zzbqoVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i4) {
        this.zza.zzg("Operation denied by user.");
    }
}
