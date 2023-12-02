package com.google.android.recaptcha.internal;

import com.google.android.gms.nearby.uwb.RangingPosition;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public abstract class zzfk extends zzep {
    public static final /* synthetic */ int zzb = 0;
    private static final Logger zzc = Logger.getLogger(zzfk.class.getName());
    private static final boolean zzd = zzjp.zzx();
    zzfl zza;

    private zzfk() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfk(zzfj zzfjVar) {
    }

    public static zzfk zzA(byte[] bArr, int i4, int i5) {
        return new zzfh(bArr, 0, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzt(int i4, zzhy zzhyVar, zzil zzilVar) {
        int zza = ((zzei) zzhyVar).zza(zzilVar);
        int zzy = zzy(i4 << 3);
        return zzy + zzy + zza;
    }

    public static int zzu(int i4) {
        if (i4 >= 0) {
            return zzy(i4);
        }
        return 10;
    }

    public static int zzv(zzhy zzhyVar) {
        int zzn = zzhyVar.zzn();
        return zzy(zzn) + zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzw(zzhy zzhyVar, zzil zzilVar) {
        int zza = ((zzei) zzhyVar).zza(zzilVar);
        return zzy(zza) + zza;
    }

    public static int zzx(String str) {
        int length;
        try {
            length = zzju.zzc(str);
        } catch (zzjt unused) {
            length = str.getBytes(zzgw.zzb).length;
        }
        return zzy(length) + length;
    }

    public static int zzy(int i4) {
        if ((i4 & RangingPosition.RSSI_UNKNOWN) == 0) {
            return 1;
        }
        if ((i4 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i4) == 0) {
            return 3;
        }
        if ((i4 & (-268435456)) == 0) {
            return 4;
        }
        return 5;
    }

    public static int zzz(long j4) {
        int i4;
        if (((-128) & j4) == 0) {
            return 1;
        }
        if (j4 < 0) {
            return 10;
        }
        if (((-34359738368L) & j4) != 0) {
            j4 >>>= 28;
            i4 = 6;
        } else {
            i4 = 2;
        }
        if (((-2097152) & j4) != 0) {
            j4 >>>= 14;
            i4 += 2;
        }
        if ((j4 & (-16384)) != 0) {
            return i4 + 1;
        }
        return i4;
    }

    public final void zzB() {
        if (zza() == 0) {
            return;
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzC(String str, zzjt zzjtVar) throws IOException {
        zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzjtVar);
        byte[] bytes = str.getBytes(zzgw.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzfi(e4);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b4) throws IOException;

    public abstract void zzd(int i4, boolean z3) throws IOException;

    public abstract void zze(int i4, zzez zzezVar) throws IOException;

    public abstract void zzf(int i4, int i5) throws IOException;

    public abstract void zzg(int i4) throws IOException;

    public abstract void zzh(int i4, long j4) throws IOException;

    public abstract void zzi(long j4) throws IOException;

    public abstract void zzj(int i4, int i5) throws IOException;

    public abstract void zzk(int i4) throws IOException;

    public abstract void zzl(byte[] bArr, int i4, int i5) throws IOException;

    public abstract void zzm(int i4, String str) throws IOException;

    public abstract void zzo(int i4, int i5) throws IOException;

    public abstract void zzp(int i4, int i5) throws IOException;

    public abstract void zzq(int i4) throws IOException;

    public abstract void zzr(int i4, long j4) throws IOException;

    public abstract void zzs(long j4) throws IOException;
}
