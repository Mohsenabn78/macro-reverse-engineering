package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfxy {
    private final List zza = new ArrayList();
    private final zzghn zzb = zzghn.zza;
    private boolean zzc = false;

    public final void zzd() {
        for (zzfxw zzfxwVar : this.zza) {
            zzfxwVar.zza = false;
        }
    }

    public final zzfxy zza(zzfxw zzfxwVar) {
        zzfxy zzfxyVar;
        boolean z3;
        zzfxyVar = zzfxwVar.zzf;
        if (zzfxyVar == null) {
            z3 = zzfxwVar.zza;
            if (z3) {
                zzd();
            }
            zzfxwVar.zzf = this;
            this.zza.add(zzfxwVar);
            return this;
        }
        throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
    }

    public final zzfyb zzb() throws GeneralSecurityException {
        zzfxx zzfxxVar;
        zzfxx zzfxxVar2;
        zzfxx zzfxxVar3;
        int i4;
        zzfyf zzfyfVar;
        zzgfd zzd;
        boolean z3;
        zzfxx zzfxxVar4;
        zzfxx zzfxxVar5;
        zzfxx zzfxxVar6;
        zzfxx zzfxxVar7;
        zzfxs unused;
        zzfxx unused2;
        if (!this.zzc) {
            this.zzc = true;
            zzgku zzd2 = zzgkx.zzd();
            List list = this.zza;
            for (int i5 = 0; i5 < list.size() - 1; i5++) {
                zzfxxVar4 = ((zzfxw) list.get(i5)).zze;
                zzfxxVar5 = zzfxx.zza;
                if (zzfxxVar4 == zzfxxVar5) {
                    zzfxxVar6 = ((zzfxw) list.get(i5 + 1)).zze;
                    zzfxxVar7 = zzfxx.zza;
                    if (zzfxxVar6 != zzfxxVar7) {
                        throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
                    }
                }
            }
            HashSet hashSet = new HashSet();
            Integer num = null;
            for (zzfxw zzfxwVar : this.zza) {
                unused = zzfxwVar.zzb;
                zzfxxVar = zzfxwVar.zze;
                if (zzfxxVar != null) {
                    zzfxxVar2 = zzfxwVar.zze;
                    zzfxxVar3 = zzfxx.zza;
                    int i6 = 3;
                    if (zzfxxVar2 != zzfxxVar3) {
                        unused2 = zzfxwVar.zze;
                        i4 = 0;
                    } else {
                        i4 = 0;
                        while (true) {
                            if (i4 != 0 && !hashSet.contains(Integer.valueOf(i4))) {
                                break;
                            }
                            SecureRandom secureRandom = new SecureRandom();
                            byte[] bArr = new byte[4];
                            int i7 = 0;
                            while (i7 == 0) {
                                secureRandom.nextBytes(bArr);
                                i7 = ((bArr[0] & Byte.MAX_VALUE) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
                            }
                            i4 = i7;
                        }
                    }
                    Integer valueOf = Integer.valueOf(i4);
                    if (!hashSet.contains(valueOf)) {
                        hashSet.add(valueOf);
                        zzfxw.zza(zzfxwVar);
                        zzfyfVar = zzfxwVar.zzd;
                        zzfxs zzc = zzfxwVar.zzc();
                        if (!zzfxs.zza.equals(zzc)) {
                            if (zzfxs.zzb.equals(zzc)) {
                                i6 = 4;
                            } else if (zzfxs.zzc.equals(zzc)) {
                                i6 = 5;
                            } else {
                                throw new IllegalStateException("Unknown key status");
                            }
                        }
                        if (zzfyfVar instanceof zzgdx) {
                            zzd = ((zzgdx) zzfyfVar).zza();
                        } else {
                            zzd = zzgeg.zzc().zzd(zzfyfVar, zzgfb.class);
                        }
                        zzgfb zzgfbVar = (zzgfb) zzd;
                        zzgkk zza = zzfyp.zza(zzgfbVar.zzb());
                        zzgkv zzd3 = zzgkw.zzd();
                        zzd3.zzb(i4);
                        zzd3.zzd(i6);
                        zzd3.zza(zza);
                        zzd3.zzc(zzgfbVar.zzb().zzf());
                        zzd2.zza((zzgkw) zzd3.zzal());
                        z3 = zzfxwVar.zza;
                        if (z3) {
                            if (num == null) {
                                num = valueOf;
                            } else {
                                throw new GeneralSecurityException("Two primaries were set");
                            }
                        }
                    } else {
                        throw new GeneralSecurityException("Id " + i4 + " is used twice in the keyset");
                    }
                } else {
                    throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
                }
            }
            if (num != null) {
                zzd2.zzb(num.intValue());
                return zzfyb.zzb((zzgkx) zzd2.zzal(), this.zzb);
            }
            throw new GeneralSecurityException("No primary was set");
        }
        throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
    }
}
