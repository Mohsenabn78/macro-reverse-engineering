package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfyh {
    private final Class zza;
    private zzfyi zzd;
    private ConcurrentMap zzb = new ConcurrentHashMap();
    private final List zzc = new ArrayList();
    private zzghn zze = zzghn.zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfyh(Class cls, zzfyg zzfygVar) {
        this.zza = cls;
    }

    private final zzfyh zze(@Nullable Object obj, @Nullable Object obj2, zzgkw zzgkwVar, boolean z3) throws GeneralSecurityException {
        byte[] array;
        if (this.zzb != null) {
            if (obj == null && obj2 == null) {
                throw new GeneralSecurityException("at least one of the `fullPrimitive` or `primitive` must be set");
            }
            if (zzgkwVar.zzk() == 3) {
                Integer valueOf = Integer.valueOf(zzgkwVar.zza());
                if (zzgkwVar.zzf() == zzglq.RAW) {
                    valueOf = null;
                }
                zzfxn zza = zzgeg.zzc().zza(zzgfa.zza(zzgkwVar.zzc().zzg(), zzgkwVar.zzc().zzf(), zzgkwVar.zzc().zzc(), zzgkwVar.zzf(), valueOf), zzfyq.zza());
                int ordinal = zzgkwVar.zzf().ordinal();
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal != 3) {
                            if (ordinal != 4) {
                                throw new GeneralSecurityException("unknown output prefix type");
                            }
                        } else {
                            array = zzfxm.zza;
                        }
                    }
                    array = ByteBuffer.allocate(5).put((byte) 0).putInt(zzgkwVar.zza()).array();
                } else {
                    array = ByteBuffer.allocate(5).put((byte) 1).putInt(zzgkwVar.zza()).array();
                }
                zzfyi zzfyiVar = new zzfyi(obj, obj2, array, zzgkwVar.zzk(), zzgkwVar.zzf(), zzgkwVar.zza(), zzgkwVar.zzc().zzg(), zza);
                ConcurrentMap concurrentMap = this.zzb;
                List list = this.zzc;
                ArrayList arrayList = new ArrayList();
                arrayList.add(zzfyiVar);
                zzfyk zzfykVar = new zzfyk(zzfyiVar.zzg(), null);
                List list2 = (List) concurrentMap.put(zzfykVar, Collections.unmodifiableList(arrayList));
                if (list2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.addAll(list2);
                    arrayList2.add(zzfyiVar);
                    concurrentMap.put(zzfykVar, Collections.unmodifiableList(arrayList2));
                }
                list.add(zzfyiVar);
                if (z3) {
                    if (this.zzd == null) {
                        this.zzd = zzfyiVar;
                    } else {
                        throw new IllegalStateException("you cannot set two primary primitives");
                    }
                }
                return this;
            }
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
        throw new IllegalStateException("addPrimitive cannot be called after build");
    }

    public final zzfyh zza(@Nullable Object obj, @Nullable Object obj2, zzgkw zzgkwVar) throws GeneralSecurityException {
        zze(obj, obj2, zzgkwVar, false);
        return this;
    }

    public final zzfyh zzb(@Nullable Object obj, @Nullable Object obj2, zzgkw zzgkwVar) throws GeneralSecurityException {
        zze(obj, obj2, zzgkwVar, true);
        return this;
    }

    public final zzfyh zzc(zzghn zzghnVar) {
        if (this.zzb != null) {
            this.zze = zzghnVar;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build");
    }

    public final zzfym zzd() throws GeneralSecurityException {
        ConcurrentMap concurrentMap = this.zzb;
        if (concurrentMap != null) {
            zzfym zzfymVar = new zzfym(concurrentMap, this.zzc, this.zzd, this.zze, this.zza, null);
            this.zzb = null;
            return zzfymVar;
        }
        throw new IllegalStateException("build cannot be called twice");
    }
}
