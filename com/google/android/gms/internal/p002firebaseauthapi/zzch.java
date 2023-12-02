package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzch  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzch {
    private final Class zza;
    private zzci zzd;
    private ConcurrentMap zzb = new ConcurrentHashMap();
    private final List zzc = new ArrayList();
    private zzom zze = zzom.zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzch(Class cls, zzcg zzcgVar) {
        this.zza = cls;
    }

    private final zzch zze(@Nullable Object obj, @Nullable Object obj2, zzto zztoVar, boolean z3) throws GeneralSecurityException {
        byte[] array;
        if (this.zzb != null) {
            if (obj == null && obj2 == null) {
                throw new GeneralSecurityException("at least one of the `fullPrimitive` or `primitive` must be set");
            }
            if (zztoVar.zzk() == 3) {
                Integer valueOf = Integer.valueOf(zztoVar.zza());
                if (zztoVar.zze() == zzui.RAW) {
                    valueOf = null;
                }
                zzbn zza = zzkz.zzc().zza(zzlu.zza(zztoVar.zzb().zzf(), zztoVar.zzb().zze(), zztoVar.zzb().zzb(), zztoVar.zze(), valueOf), zzcs.zza());
                int ordinal = zztoVar.zze().ordinal();
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal != 3) {
                            if (ordinal != 4) {
                                throw new GeneralSecurityException("unknown output prefix type");
                            }
                        } else {
                            array = zzbi.zza;
                        }
                    }
                    array = ByteBuffer.allocate(5).put((byte) 0).putInt(zztoVar.zza()).array();
                } else {
                    array = ByteBuffer.allocate(5).put((byte) 1).putInt(zztoVar.zza()).array();
                }
                zzci zzciVar = new zzci(obj, obj2, array, zztoVar.zzk(), zztoVar.zze(), zztoVar.zza(), zztoVar.zzb().zzf(), zza);
                ConcurrentMap concurrentMap = this.zzb;
                List list = this.zzc;
                ArrayList arrayList = new ArrayList();
                arrayList.add(zzciVar);
                zzck zzckVar = new zzck(zzciVar.zzg(), null);
                List list2 = (List) concurrentMap.put(zzckVar, Collections.unmodifiableList(arrayList));
                if (list2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.addAll(list2);
                    arrayList2.add(zzciVar);
                    concurrentMap.put(zzckVar, Collections.unmodifiableList(arrayList2));
                }
                list.add(zzciVar);
                if (z3) {
                    if (this.zzd == null) {
                        this.zzd = zzciVar;
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

    public final zzch zza(@Nullable Object obj, @Nullable Object obj2, zzto zztoVar) throws GeneralSecurityException {
        zze(obj, obj2, zztoVar, false);
        return this;
    }

    public final zzch zzb(@Nullable Object obj, @Nullable Object obj2, zzto zztoVar) throws GeneralSecurityException {
        zze(obj, obj2, zztoVar, true);
        return this;
    }

    public final zzch zzc(zzom zzomVar) {
        if (this.zzb != null) {
            this.zze = zzomVar;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build");
    }

    public final zzcm zzd() throws GeneralSecurityException {
        ConcurrentMap concurrentMap = this.zzb;
        if (concurrentMap != null) {
            zzcm zzcmVar = new zzcm(concurrentMap, this.zzc, this.zzd, this.zze, this.zza, null);
            this.zzb = null;
            return zzcmVar;
        }
        throw new IllegalStateException("build cannot be called twice");
    }
}
