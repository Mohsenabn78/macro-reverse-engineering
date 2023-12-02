package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfyb {
    private final zzgkx zza;
    private final List zzb;
    private final zzghn zzc;

    private zzfyb(zzgkx zzgkxVar, List list, zzghn zzghnVar) {
        this.zza = zzgkxVar;
        this.zzb = list;
        this.zzc = zzghnVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final zzfyb zza(zzgkx zzgkxVar) throws GeneralSecurityException {
        zzi(zzgkxVar);
        return new zzfyb(zzgkxVar, zzh(zzgkxVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final zzfyb zzb(zzgkx zzgkxVar, zzghn zzghnVar) throws GeneralSecurityException {
        zzi(zzgkxVar);
        return new zzfyb(zzgkxVar, zzh(zzgkxVar), zzghnVar);
    }

    public static final zzfyb zzc(zzfyf zzfyfVar) throws GeneralSecurityException {
        zzfxy zzfxyVar = new zzfxy();
        zzfxw zzfxwVar = new zzfxw(zzfyfVar, null);
        zzfxwVar.zze();
        zzfxwVar.zzd();
        zzfxyVar.zza(zzfxwVar);
        return zzfxyVar.zzb();
    }

    private static zzgfa zzf(zzgkw zzgkwVar) {
        Integer valueOf;
        int zza = zzgkwVar.zza();
        if (zzgkwVar.zzf() == zzglq.RAW) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(zza);
        }
        try {
            return zzgfa.zza(zzgkwVar.zzc().zzg(), zzgkwVar.zzc().zzf(), zzgkwVar.zzc().zzc(), zzgkwVar.zzf(), valueOf);
        } catch (GeneralSecurityException e4) {
            throw new zzgfl("Creating a protokey serialization failed", e4);
        }
    }

    @Nullable
    private static Object zzg(zzgdj zzgdjVar, zzgkw zzgkwVar, Class cls) throws GeneralSecurityException {
        try {
            zzgkk zzc = zzgkwVar.zzc();
            int i4 = zzfyp.zza;
            return zzfyp.zzc(zzc.zzg(), zzc.zzf(), cls);
        } catch (UnsupportedOperationException unused) {
            return null;
        } catch (GeneralSecurityException e4) {
            if (e4.getMessage().contains("No key manager found for key type ") || e4.getMessage().contains(" not supported by key manager of type ")) {
                return null;
            }
            throw e4;
        }
    }

    private static List zzh(zzgkx zzgkxVar) {
        zzfxs zzfxsVar;
        boolean z3;
        ArrayList arrayList = new ArrayList(zzgkxVar.zza());
        for (zzgkw zzgkwVar : zzgkxVar.zzh()) {
            int zza = zzgkwVar.zza();
            try {
                zzfxn zza2 = zzgeg.zzc().zza(zzf(zzgkwVar), zzfyq.zza());
                int zzk = zzgkwVar.zzk() - 2;
                if (zzk != 1) {
                    if (zzk != 2) {
                        if (zzk == 3) {
                            zzfxsVar = zzfxs.zzc;
                        } else {
                            throw new GeneralSecurityException("Unknown key status");
                            break;
                        }
                    } else {
                        zzfxsVar = zzfxs.zzb;
                    }
                } else {
                    zzfxsVar = zzfxs.zza;
                }
                zzfxs zzfxsVar2 = zzfxsVar;
                if (zza == zzgkxVar.zzc()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                arrayList.add(new zzfya(zza2, zzfxsVar2, zza, z3, null));
            } catch (GeneralSecurityException unused) {
                arrayList.add(null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static void zzi(zzgkx zzgkxVar) throws GeneralSecurityException {
        if (zzgkxVar != null && zzgkxVar.zza() > 0) {
            return;
        }
        throw new GeneralSecurityException("empty keyset");
    }

    @Nullable
    private static final Object zzj(zzgdj zzgdjVar, zzfxn zzfxnVar, Class cls) throws GeneralSecurityException {
        try {
            return zzgee.zza().zzc(zzfxnVar, cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public final String toString() {
        zzgkx zzgkxVar = this.zza;
        Charset charset = zzfyr.zza;
        zzgkz zza = zzglc.zza();
        zza.zzb(zzgkxVar.zzc());
        for (zzgkw zzgkwVar : zzgkxVar.zzh()) {
            zzgla zza2 = zzglb.zza();
            zza2.zzc(zzgkwVar.zzc().zzg());
            zza2.zzd(zzgkwVar.zzk());
            zza2.zzb(zzgkwVar.zzf());
            zza2.zza(zzgkwVar.zza());
            zza.zza((zzglb) zza2.zzal());
        }
        return ((zzglc) zza.zzal()).toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzgkx zzd() {
        return this.zza;
    }

    public final Object zze(zzfxl zzfxlVar, Class cls) throws GeneralSecurityException {
        Object obj;
        boolean z3;
        Class zzb = zzfyp.zzb(cls);
        if (zzb != null) {
            zzgkx zzgkxVar = this.zza;
            Charset charset = zzfyr.zza;
            int zzc = zzgkxVar.zzc();
            int i4 = 0;
            boolean z4 = false;
            boolean z5 = true;
            for (zzgkw zzgkwVar : zzgkxVar.zzh()) {
                if (zzgkwVar.zzk() == 3) {
                    if (zzgkwVar.zzj()) {
                        if (zzgkwVar.zzf() != zzglq.UNKNOWN_PREFIX) {
                            if (zzgkwVar.zzk() != 2) {
                                if (zzgkwVar.zza() == zzc) {
                                    if (!z4) {
                                        z4 = true;
                                    } else {
                                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                                    }
                                }
                                if (zzgkwVar.zzc().zzc() != zzgkj.ASYMMETRIC_PUBLIC) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                z5 &= z3;
                                i4++;
                            } else {
                                throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzgkwVar.zza())));
                            }
                        } else {
                            throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzgkwVar.zza())));
                        }
                    } else {
                        throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzgkwVar.zza())));
                    }
                }
            }
            if (i4 != 0) {
                if (!z4 && !z5) {
                    throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
                }
                zzfyh zzfyhVar = new zzfyh(zzb, null);
                zzfyhVar.zzc(this.zzc);
                for (int i5 = 0; i5 < this.zza.zza(); i5++) {
                    zzgkw zze = this.zza.zze(i5);
                    if (zze.zzk() == 3) {
                        zzgdj zzgdjVar = (zzgdj) zzfxlVar;
                        Object zzg = zzg(zzgdjVar, zze, zzb);
                        if (this.zzb.get(i5) != null) {
                            obj = zzj(zzgdjVar, ((zzfya) this.zzb.get(i5)).zza(), zzb);
                        } else {
                            obj = null;
                        }
                        if (obj == null && zzg == null) {
                            throw new GeneralSecurityException("Unable to get primitive " + zzb.toString() + " for key of type " + zze.zzc().zzg());
                        } else if (zze.zza() == this.zza.zzc()) {
                            zzfyhVar.zzb(obj, zzg, zze);
                        } else {
                            zzfyhVar.zza(obj, zzg, zze);
                        }
                    }
                }
                return zzgee.zza().zzd(zzfyhVar.zzd(), cls);
            }
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        throw new GeneralSecurityException("No wrapper found for ".concat(cls.getName()));
    }

    private zzfyb(zzgkx zzgkxVar, List list) {
        this.zza = zzgkxVar;
        this.zzb = list;
        this.zzc = zzghn.zza;
    }
}
