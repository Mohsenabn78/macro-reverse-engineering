package com.google.android.gms.internal.measurement;

import com.google.android.gms.nearby.uwb.RangingPosition;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
public abstract class zzki extends zzjq {
    public static final /* synthetic */ int zzb = 0;
    private static final Logger zzc = Logger.getLogger(zzki.class.getName());
    private static final boolean zzd = zznu.zzx();
    zzkj zza;

    private zzki() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzki(zzkh zzkhVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzt(int i4, zzmi zzmiVar, zzmt zzmtVar) {
        int zzbu = ((zzjk) zzmiVar).zzbu(zzmtVar);
        int zzx = zzx(i4 << 3);
        return zzx + zzx + zzbu;
    }

    public static int zzu(int i4) {
        if (i4 >= 0) {
            return zzx(i4);
        }
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(zzmi zzmiVar, zzmt zzmtVar) {
        int zzbu = ((zzjk) zzmiVar).zzbu(zzmtVar);
        return zzx(zzbu) + zzbu;
    }

    public static int zzw(String str) {
        int length;
        try {
            length = zznz.zzc(str);
        } catch (zzny unused) {
            length = str.getBytes(zzlj.zzb).length;
        }
        return zzx(length) + length;
    }

    public static int zzx(int i4) {
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

    public static int zzy(long j4) {
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

    public static zzki zzz(byte[] bArr, int i4, int i5) {
        return new zzkf(bArr, 0, i5);
    }

    public final void zzA() {
        if (zza() == 0) {
            return;
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzB(String str, zzny zznyVar) throws IOException {
        zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zznyVar);
        byte[] bytes = str.getBytes(zzlj.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzkg(e4);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b4) throws IOException;

    public abstract void zzd(int i4, boolean z3) throws IOException;

    public abstract void zze(int i4, zzka zzkaVar) throws IOException;

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
