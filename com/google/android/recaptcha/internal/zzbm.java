package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzbm {
    @NotNull
    private final Map zza;
    @NotNull
    private final Set zzb;
    @NotNull
    private final Map zzc;

    public zzbm() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zza = linkedHashMap;
        this.zzb = new LinkedHashSet();
        this.zzc = linkedHashMap;
    }

    private final List zzh(List list) {
        int collectionSizeOrDefault;
        collectionSizeOrDefault = f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zza((zzmu) it.next()));
        }
        return arrayList;
    }

    @Nullable
    public final Object zza(@NotNull zzmu zzmuVar) throws zzt {
        int zzN = zzmuVar.zzN();
        int i4 = zzN - 1;
        if (zzN != 0) {
            switch (i4) {
                case 0:
                    return this.zza.get(Integer.valueOf(zzmuVar.zzi()));
                case 1:
                    return Boolean.valueOf(zzmuVar.zzL());
                case 2:
                    byte[] zzo = zzmuVar.zzH().zzo();
                    if (zzo.length == 1) {
                        return Byte.valueOf(zzo[0]);
                    }
                    throw new zzt(4, 6, null);
                case 3:
                    String zzJ = zzmuVar.zzJ();
                    if (zzJ.length() == 1) {
                        return Character.valueOf(zzJ.charAt(0));
                    }
                    throw new zzt(4, 6, null);
                case 4:
                    int zzj = zzmuVar.zzj();
                    if (zzj >= -32768 && zzj <= 32767) {
                        return Short.valueOf((short) zzj);
                    }
                    throw new zzt(4, 6, null);
                case 5:
                    return Integer.valueOf(zzmuVar.zzk());
                case 6:
                case 8:
                    throw new zzt(4, 6, null);
                case 7:
                    return Long.valueOf(zzmuVar.zzG());
                case 9:
                    return Float.valueOf(zzmuVar.zzg());
                case 10:
                    return Double.valueOf(zzmuVar.zzf());
                case 11:
                    return zzmuVar.zzK();
                case 12:
                    return null;
                default:
                    throw new zzt(4, 5, null);
            }
        }
        throw null;
    }

    @Nullable
    public final Object zzb(int i4) {
        return this.zza.remove(Integer.valueOf(i4));
    }

    @NotNull
    public final Map zzc() {
        return this.zzc;
    }

    public final void zzd() {
        this.zza.clear();
    }

    public final void zze(int i4, @Nullable Object obj) {
        zzf(173, obj);
        this.zzb.add(173);
    }

    public final void zzf(int i4, @Nullable Object obj) {
        this.zza.put(Integer.valueOf(i4), obj);
    }

    @NotNull
    public final Object[] zzg(@NotNull List list) {
        return zzh(list).toArray(new Object[0]);
    }
}
