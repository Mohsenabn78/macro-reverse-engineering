package com.google.android.gms.internal.icing;

import com.google.android.gms.nearby.uwb.RangingPosition;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public abstract class zzcm extends zzbw {
    private static final Logger zzb = Logger.getLogger(zzcm.class.getName());
    private static final boolean zzc = zzfn.zza();
    zzcn zza;

    private zzcm() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcm(zzcj zzcjVar) {
    }

    public static int zzA(zzcf zzcfVar) {
        int zzc2 = zzcfVar.zzc();
        return zzw(zzc2) + zzc2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzB(zzee zzeeVar, zzep zzepVar) {
        zzbs zzbsVar = (zzbs) zzeeVar;
        int zzi = zzbsVar.zzi();
        if (zzi == -1) {
            zzi = zzepVar.zzd(zzbsVar);
            zzbsVar.zzj(zzi);
        }
        return zzw(zzi) + zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzE(int i4, zzee zzeeVar, zzep zzepVar) {
        int zzw = zzw(i4 << 3);
        int i5 = zzw + zzw;
        zzbs zzbsVar = (zzbs) zzeeVar;
        int zzi = zzbsVar.zzi();
        if (zzi == -1) {
            zzi = zzepVar.zzd(zzbsVar);
            zzbsVar.zzj(zzi);
        }
        return i5 + zzi;
    }

    public static zzcm zzt(byte[] bArr) {
        return new zzck(bArr, 0, bArr.length);
    }

    public static int zzu(int i4) {
        return zzw(i4 << 3);
    }

    public static int zzv(int i4) {
        if (i4 >= 0) {
            return zzw(i4);
        }
        return 10;
    }

    public static int zzw(int i4) {
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

    public static int zzx(long j4) {
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

    public static int zzy(String str) {
        int length;
        try {
            length = zzfr.zzc(str);
        } catch (zzfq unused) {
            length = str.getBytes(zzdh.zza).length;
        }
        return zzw(length) + length;
    }

    public static int zzz(zzdm zzdmVar) {
        int zza = zzdmVar.zza();
        return zzw(zza) + zza;
    }

    public final void zzC() {
        if (zzs() == 0) {
            return;
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzD(String str, zzfq zzfqVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzfqVar);
        byte[] bytes = str.getBytes(zzdh.zza);
        try {
            int length = bytes.length;
            zzl(length);
            zzq(bytes, 0, length);
        } catch (zzcl e4) {
            throw e4;
        } catch (IndexOutOfBoundsException e5) {
            throw new zzcl(e5);
        }
    }

    public abstract void zza(int i4, int i5) throws IOException;

    public abstract void zzb(int i4, int i5) throws IOException;

    public abstract void zzc(int i4, int i5) throws IOException;

    public abstract void zzd(int i4, int i5) throws IOException;

    public abstract void zze(int i4, long j4) throws IOException;

    public abstract void zzf(int i4, long j4) throws IOException;

    public abstract void zzg(int i4, boolean z3) throws IOException;

    public abstract void zzh(int i4, String str) throws IOException;

    public abstract void zzi(int i4, zzcf zzcfVar) throws IOException;

    public abstract void zzj(byte b4) throws IOException;

    public abstract void zzk(int i4) throws IOException;

    public abstract void zzl(int i4) throws IOException;

    public abstract void zzm(int i4) throws IOException;

    public abstract void zzn(long j4) throws IOException;

    public abstract void zzo(long j4) throws IOException;

    public abstract void zzq(byte[] bArr, int i4, int i5) throws IOException;

    public abstract int zzs();
}
