package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgwp implements zzgwe {
    private static final zzgwe zza = zzgwf.zza(Collections.emptySet());
    private final List zzb;
    private final List zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgwp(List list, List list2, zzgwn zzgwnVar) {
        this.zzb = list;
        this.zzc = list2;
    }

    public static zzgwo zza(int i4, int i5) {
        return new zzgwo(i4, i5, null);
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    /* renamed from: zzc */
    public final Set zzb() {
        int size = this.zzb.size();
        ArrayList arrayList = new ArrayList(this.zzc.size());
        int size2 = this.zzc.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Collection collection = (Collection) ((zzgwr) this.zzc.get(i4)).zzb();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet zza2 = zzgwb.zza(size);
        int size3 = this.zzb.size();
        for (int i5 = 0; i5 < size3; i5++) {
            Object zzb = ((zzgwr) this.zzb.get(i5)).zzb();
            zzb.getClass();
            zza2.add(zzb);
        }
        int size4 = arrayList.size();
        for (int i6 = 0; i6 < size4; i6++) {
            for (Object obj : (Collection) arrayList.get(i6)) {
                obj.getClass();
                zza2.add(obj);
            }
        }
        return Collections.unmodifiableSet(zza2);
    }
}
