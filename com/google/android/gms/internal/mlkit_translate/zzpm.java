package com.google.android.gms.internal.mlkit_translate;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzpm implements zzpr {
    @VisibleForTesting
    final List zza;

    public zzpm(Context context, zzpl zzplVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzplVar.zzc()) {
            arrayList.add(new zzqc(context, zzplVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpr
    public final void zza(zzpj zzpjVar) {
        for (zzpr zzprVar : this.zza) {
            zzprVar.zza(zzpjVar);
        }
    }
}
