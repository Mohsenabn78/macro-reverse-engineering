package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
abstract class zzfvm extends zzfvb {
    @CheckForNull
    private List zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfvm(zzfrx zzfrxVar, boolean z3) {
        super(zzfrxVar, true, true);
        List zza;
        if (zzfrxVar.isEmpty()) {
            zza = Collections.emptyList();
        } else {
            zza = zzfsq.zza(zzfrxVar.size());
        }
        for (int i4 = 0; i4 < zzfrxVar.size(); i4++) {
            zza.add(null);
        }
        this.zza = zza;
    }

    abstract Object zzH(List list);

    @Override // com.google.android.gms.internal.ads.zzfvb
    final void zzg(int i4, Object obj) {
        List list = this.zza;
        if (list != null) {
            list.set(i4, new zzfvl(obj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfvb
    final void zzv() {
        List list = this.zza;
        if (list != null) {
            zzd(zzH(list));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzfvb
    public final void zzz(int i4) {
        super.zzz(i4);
        this.zza = null;
    }
}
