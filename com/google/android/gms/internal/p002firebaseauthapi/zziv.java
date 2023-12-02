package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziv  reason: invalid package */
/* loaded from: classes4.dex */
final class zziv implements zzvb {
    private final String zza;
    private final int zzb;
    private zzqe zzc;
    private zzpg zzd;
    private int zze;
    private zzqq zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziv(zzth zzthVar) throws GeneralSecurityException {
        String zzg = zzthVar.zzg();
        this.zza = zzg;
        if (zzg.equals(zzcu.zzb)) {
            try {
                zzqh zze = zzqh.zze(zzthVar.zzf(), zzagq.zza());
                this.zzc = zzqe.zzd(zzcr.zzb(zzthVar).zze(), zzagq.zza());
                this.zzb = zze.zza();
            } catch (zzahl e4) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e4);
            }
        } else if (zzg.equals(zzcu.zza)) {
            try {
                zzpj zzc = zzpj.zzc(zzthVar.zzf(), zzagq.zza());
                this.zzd = zzpg.zzd(zzcr.zzb(zzthVar).zze(), zzagq.zza());
                this.zze = zzc.zzd().zza();
                this.zzb = this.zze + zzc.zze().zza();
            } catch (zzahl e5) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e5);
            }
        } else if (zzg.equals(zzid.zza)) {
            try {
                zzqt zze2 = zzqt.zze(zzthVar.zzf(), zzagq.zza());
                this.zzf = zzqq.zzd(zzcr.zzb(zzthVar).zze(), zzagq.zza());
                this.zzb = zze2.zza();
            } catch (zzahl e6) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e6);
            }
        } else {
            throw new GeneralSecurityException("unsupported AEAD DEM key type: ".concat(String.valueOf(zzg)));
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzvb
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzvb
    public final zzjq zzb(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length == this.zzb) {
            if (this.zza.equals(zzcu.zzb)) {
                zzqd zzb = zzqe.zzb();
                zzb.zzh(this.zzc);
                zzb.zza(zzafy.zzn(bArr, 0, this.zzb));
                return new zzjq((zzbd) zzcr.zzd(this.zza, ((zzqe) zzb.zzi()).zzo(), zzbd.class));
            } else if (this.zza.equals(zzcu.zza)) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zze);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zze, this.zzb);
                zzpl zzb2 = zzpm.zzb();
                zzb2.zzh(this.zzd.zze());
                zzafy zzafyVar = zzafy.zzb;
                zzb2.zza(zzafy.zzn(copyOfRange, 0, copyOfRange.length));
                zzsc zzb3 = zzsd.zzb();
                zzb3.zzh(this.zzd.zzf());
                zzb3.zza(zzafy.zzn(copyOfRange2, 0, copyOfRange2.length));
                zzpf zzb4 = zzpg.zzb();
                zzb4.zzc(this.zzd.zza());
                zzb4.zza((zzpm) zzb2.zzi());
                zzb4.zzb((zzsd) zzb3.zzi());
                return new zzjq((zzbd) zzcr.zzd(this.zza, ((zzpg) zzb4.zzi()).zzo(), zzbd.class));
            } else if (this.zza.equals(zzid.zza)) {
                zzqp zzb5 = zzqq.zzb();
                zzb5.zzh(this.zzf);
                zzb5.zza(zzafy.zzn(bArr, 0, this.zzb));
                return new zzjq((zzbj) zzcr.zzd(this.zza, ((zzqq) zzb5.zzi()).zzo(), zzbj.class));
            } else {
                throw new GeneralSecurityException("unknown DEM key type");
            }
        }
        throw new GeneralSecurityException("Symmetric key has incorrect length");
    }
}
