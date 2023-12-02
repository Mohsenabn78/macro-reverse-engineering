package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfvk extends zzfvm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfvk(zzfrx zzfrxVar, boolean z3) {
        super(zzfrxVar, true);
        zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzfvm
    public final /* bridge */ /* synthetic */ Object zzH(List list) {
        Object obj;
        ArrayList zza = zzfsq.zza(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfvl zzfvlVar = (zzfvl) it.next();
            if (zzfvlVar != null) {
                obj = zzfvlVar.zza;
            } else {
                obj = null;
            }
            zza.add(obj);
        }
        return Collections.unmodifiableList(zza);
    }
}
