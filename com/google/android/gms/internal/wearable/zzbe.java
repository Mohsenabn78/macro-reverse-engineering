package com.google.android.gms.internal.wearable;

import com.google.android.gms.nearby.uwb.RangingPosition;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public abstract class zzbe extends zzam {
    private static final Logger zzb = Logger.getLogger(zzbe.class.getName());
    private static final boolean zzc = zzeo.zzx();
    zzbf zza;

    private zzbe() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbe(zzbd zzbdVar) {
    }

    public static int zzA(int i4) {
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

    public static int zzB(long j4) {
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
            i4 += 2;
            j4 >>>= 14;
        }
        if ((j4 & (-16384)) != 0) {
            return i4 + 1;
        }
        return i4;
    }

    public static zzbe zzC(byte[] bArr) {
        return new zzbb(bArr, 0, bArr.length);
    }

    public static int zzt(zzaw zzawVar) {
        int zzd = zzawVar.zzd();
        return zzA(zzd) + zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzu(int i4, zzdc zzdcVar, zzdn zzdnVar) {
        int zzA = zzA(i4 << 3);
        int i5 = zzA + zzA;
        zzag zzagVar = (zzag) zzdcVar;
        int zzH = zzagVar.zzH();
        if (zzH == -1) {
            zzH = zzdnVar.zza(zzagVar);
            zzagVar.zzK(zzH);
        }
        return i5 + zzH;
    }

    public static int zzv(int i4) {
        if (i4 >= 0) {
            return zzA(i4);
        }
        return 10;
    }

    public static int zzw(zzci zzciVar) {
        int zza = zzciVar.zza();
        return zzA(zza) + zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(zzdc zzdcVar, zzdn zzdnVar) {
        zzag zzagVar = (zzag) zzdcVar;
        int zzH = zzagVar.zzH();
        if (zzH == -1) {
            zzH = zzdnVar.zza(zzagVar);
            zzagVar.zzK(zzH);
        }
        return zzA(zzH) + zzH;
    }

    public static int zzy(String str) {
        int length;
        try {
            length = zzet.zzc(str);
        } catch (zzes unused) {
            length = str.getBytes(zzcd.zzb).length;
        }
        return zzA(length) + length;
    }

    public static int zzz(int i4) {
        return zzA(i4 << 3);
    }

    public final void zzD() {
        if (zza() == 0) {
            return;
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzE(String str, zzes zzesVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzesVar);
        byte[] bytes = str.getBytes(zzcd.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzbc(e4);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b4) throws IOException;

    public abstract void zzd(int i4, boolean z3) throws IOException;

    public abstract void zze(int i4, zzaw zzawVar) throws IOException;

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
