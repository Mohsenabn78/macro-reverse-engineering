package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbz  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzbz {
    private final zztp zza;
    private final List zzb;
    private final zzom zzc = zzom.zza;

    private zzbz(zztp zztpVar, List list) {
        this.zza = zztpVar;
        this.zzb = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final zzbz zza(zztp zztpVar) throws GeneralSecurityException {
        zzl(zztpVar);
        return new zzbz(zztpVar, zzk(zztpVar));
    }

    public static final zzbz zzh(zzbe zzbeVar, zzbd zzbdVar) throws GeneralSecurityException, IOException {
        byte[] bArr = new byte[0];
        zzry zza = zzbeVar.zza();
        if (zza != null && zza.zzd().zzd() != 0) {
            try {
                zztp zzg = zztp.zzg(zzbdVar.zza(zza.zzd().zzq(), bArr), zzagq.zza());
                zzl(zzg);
                return zza(zzg);
            } catch (zzahl unused) {
                throw new GeneralSecurityException("invalid keyset, corrupted key material");
            }
        }
        throw new GeneralSecurityException("empty keyset");
    }

    private static zzlu zzi(zzto zztoVar) {
        Integer valueOf;
        int zza = zztoVar.zza();
        if (zztoVar.zze() == zzui.RAW) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(zza);
        }
        try {
            return zzlu.zza(zztoVar.zzb().zzf(), zztoVar.zzb().zze(), zztoVar.zzb().zzb(), zztoVar.zze(), valueOf);
        } catch (GeneralSecurityException e4) {
            throw new zzmi("Creating a protokey serialization failed", e4);
        }
    }

    @Nullable
    private static Object zzj(zzkb zzkbVar, zzto zztoVar, Class cls) throws GeneralSecurityException {
        try {
            zztc zzb = zztoVar.zzb();
            int i4 = zzcr.zza;
            return zzcr.zzd(zzb.zzf(), zzb.zze(), cls);
        } catch (UnsupportedOperationException unused) {
            return null;
        } catch (GeneralSecurityException e4) {
            if (e4.getMessage().contains("No key manager found for key type ") || e4.getMessage().contains(" not supported by key manager of type ")) {
                return null;
            }
            throw e4;
        }
    }

    private static List zzk(zztp zztpVar) {
        zzbu zzbuVar;
        boolean z3;
        ArrayList arrayList = new ArrayList(zztpVar.zza());
        for (zzto zztoVar : zztpVar.zzh()) {
            int zza = zztoVar.zza();
            try {
                zzbn zza2 = zzkz.zzc().zza(zzi(zztoVar), zzcs.zza());
                int zzk = zztoVar.zzk() - 2;
                if (zzk != 1) {
                    if (zzk != 2) {
                        if (zzk == 3) {
                            zzbuVar = zzbu.zzc;
                        } else {
                            throw new GeneralSecurityException("Unknown key status");
                            break;
                        }
                    } else {
                        zzbuVar = zzbu.zzb;
                    }
                } else {
                    zzbuVar = zzbu.zza;
                }
                zzbu zzbuVar2 = zzbuVar;
                if (zza == zztpVar.zzb()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                arrayList.add(new zzby(zza2, zzbuVar2, zza, z3, null));
            } catch (GeneralSecurityException unused) {
                arrayList.add(null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static void zzl(zztp zztpVar) throws GeneralSecurityException {
        if (zztpVar != null && zztpVar.zza() > 0) {
            return;
        }
        throw new GeneralSecurityException("empty keyset");
    }

    @Nullable
    private static final Object zzm(zzkb zzkbVar, zzbn zzbnVar, Class cls) throws GeneralSecurityException {
        try {
            return zzkw.zza().zzc(zzbnVar, cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public final String toString() {
        return zzct.zza(this.zza).toString();
    }

    public final zzbz zzb() throws GeneralSecurityException {
        if (this.zza != null) {
            zztm zzc = zztp.zzc();
            for (zzto zztoVar : this.zza.zzh()) {
                zztc zzb = zztoVar.zzb();
                if (zzb.zzb() == zztb.ASYMMETRIC_PRIVATE) {
                    String zzf = zzb.zzf();
                    zzafy zze = zzb.zze();
                    zzbo zza = zzcr.zza(zzf);
                    if (zza instanceof zzco) {
                        zztc zzd = ((zzco) zza).zzd(zze);
                        String zzf2 = zzd.zzf();
                        zzcr.zza(zzf2).zzb(zzd.zze());
                        zztn zztnVar = (zztn) zztoVar.zzu();
                        zztnVar.zza(zzd);
                        zzc.zzb((zzto) zztnVar.zzi());
                    } else {
                        throw new GeneralSecurityException("manager for key type " + zzf + " is not a PrivateKeyManager");
                    }
                } else {
                    throw new GeneralSecurityException("The keyset contains a non-private key");
                }
            }
            zzc.zzc(this.zza.zzb());
            return zza((zztp) zzc.zzi());
        }
        throw new GeneralSecurityException("cleartext keyset is not available");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zztp zzc() {
        return this.zza;
    }

    public final zztu zzd() {
        return zzct.zza(this.zza);
    }

    public final Object zze(zzbh zzbhVar, Class cls) throws GeneralSecurityException {
        Object obj;
        boolean z3;
        Class zzc = zzcr.zzc(cls);
        if (zzc != null) {
            zztp zztpVar = this.zza;
            Charset charset = zzct.zza;
            int zzb = zztpVar.zzb();
            int i4 = 0;
            boolean z4 = false;
            boolean z5 = true;
            for (zzto zztoVar : zztpVar.zzh()) {
                if (zztoVar.zzk() == 3) {
                    if (zztoVar.zzi()) {
                        if (zztoVar.zze() != zzui.UNKNOWN_PREFIX) {
                            if (zztoVar.zzk() != 2) {
                                if (zztoVar.zza() == zzb) {
                                    if (!z4) {
                                        z4 = true;
                                    } else {
                                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                                    }
                                }
                                if (zztoVar.zzb().zzb() != zztb.ASYMMETRIC_PUBLIC) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                z5 &= z3;
                                i4++;
                            } else {
                                throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zztoVar.zza())));
                            }
                        } else {
                            throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zztoVar.zza())));
                        }
                    } else {
                        throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zztoVar.zza())));
                    }
                }
            }
            if (i4 != 0) {
                if (!z4 && !z5) {
                    throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
                }
                zzch zzchVar = new zzch(zzc, null);
                zzchVar.zzc(this.zzc);
                for (int i5 = 0; i5 < this.zza.zza(); i5++) {
                    zzto zzd = this.zza.zzd(i5);
                    if (zzd.zzk() == 3) {
                        zzkb zzkbVar = (zzkb) zzbhVar;
                        Object zzj = zzj(zzkbVar, zzd, zzc);
                        if (this.zzb.get(i5) != null) {
                            obj = zzm(zzkbVar, ((zzby) this.zzb.get(i5)).zza(), zzc);
                        } else {
                            obj = null;
                        }
                        if (obj == null && zzj == null) {
                            throw new GeneralSecurityException("Unable to get primitive " + zzc.toString() + " for key of type " + zzd.zzb().zzf());
                        } else if (zzd.zza() == this.zza.zzb()) {
                            zzchVar.zzb(obj, zzj, zzd);
                        } else {
                            zzchVar.zza(obj, zzj, zzd);
                        }
                    }
                }
                return zzkw.zza().zzd(zzchVar.zzd(), cls);
            }
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        throw new GeneralSecurityException("No wrapper found for ".concat(cls.getName()));
    }

    public final void zzf(zzcb zzcbVar, zzbd zzbdVar) throws GeneralSecurityException, IOException {
        byte[] bArr = new byte[0];
        zztp zztpVar = this.zza;
        byte[] zzb = zzbdVar.zzb(zztpVar.zzq(), bArr);
        try {
            if (zztp.zzg(zzbdVar.zza(zzb, bArr), zzagq.zza()).equals(zztpVar)) {
                int length = zzb.length;
                zzrx zza = zzry.zza();
                zza.zza(zzafy.zzn(zzb, 0, length));
                zza.zzb(zzct.zza(zztpVar));
                zzcbVar.zzb((zzry) zza.zzi());
                return;
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (zzahl unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzg(com.google.android.gms.internal.p002firebaseauthapi.zzcb r5) throws java.security.GeneralSecurityException, java.io.IOException {
        /*
            r4 = this;
            com.google.android.gms.internal.firebase-auth-api.zztp r0 = r4.zza
            java.util.List r0 = r0.zzh()
            java.util.Iterator r0 = r0.iterator()
        La:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L64
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.firebase-auth-api.zzto r1 = (com.google.android.gms.internal.p002firebaseauthapi.zzto) r1
            com.google.android.gms.internal.firebase-auth-api.zztc r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zztb r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zztb r3 = com.google.android.gms.internal.p002firebaseauthapi.zztb.UNKNOWN_KEYMATERIAL
            if (r2 == r3) goto L3b
            com.google.android.gms.internal.firebase-auth-api.zztc r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zztb r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zztb r3 = com.google.android.gms.internal.p002firebaseauthapi.zztb.SYMMETRIC
            if (r2 == r3) goto L3b
            com.google.android.gms.internal.firebase-auth-api.zztc r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zztb r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zztb r3 = com.google.android.gms.internal.p002firebaseauthapi.zztb.ASYMMETRIC_PRIVATE
            if (r2 == r3) goto L3b
            goto La
        L3b:
            java.security.GeneralSecurityException r5 = new java.security.GeneralSecurityException
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.google.android.gms.internal.firebase-auth-api.zztc r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zztb r2 = r2.zzb()
            java.lang.String r2 = r2.name()
            r3 = 0
            r0[r3] = r2
            com.google.android.gms.internal.firebase-auth-api.zztc r1 = r1.zzb()
            java.lang.String r1 = r1.zzf()
            r2 = 1
            r0[r2] = r1
            java.lang.String r1 = "keyset contains key material of type %s for type url %s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r5.<init>(r0)
            throw r5
        L64:
            com.google.android.gms.internal.firebase-auth-api.zztp r0 = r4.zza
            r5.zzc(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzbz.zzg(com.google.android.gms.internal.firebase-auth-api.zzcb):void");
    }
}
