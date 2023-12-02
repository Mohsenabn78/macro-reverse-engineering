package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
public final class zzmk implements zzmp {
    @VisibleForTesting
    final List zza;

    public zzmk(Context context, zzmj zzmjVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzmjVar.zzc()) {
            arrayList.add(new zzmy(context, zzmjVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzmp
    public final void zza(zzmh zzmhVar) {
        for (zzmp zzmpVar : this.zza) {
            zzmpVar.zza(zzmhVar);
        }
    }
}
