package com.google.android.gms.internal.ads;

import com.google.android.gms.nearby.uwb.RangingPosition;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzgot extends zzgnt {
    private static final Logger zza = Logger.getLogger(zzgot.class.getName());
    private static final boolean zzb = zzgsq.zzA();
    public static final /* synthetic */ int zzf = 0;
    zzgou zze;

    private zzgot() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgot(zzgos zzgosVar) {
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
            j4 >>>= 14;
            i4 += 2;
        }
        if ((j4 & (-16384)) != 0) {
            return i4 + 1;
        }
        return i4;
    }

    public static zzgot zzC(byte[] bArr, int i4, int i5) {
        return new zzgop(bArr, 0, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzw(int i4, zzgqw zzgqwVar, zzgrp zzgrpVar) {
        int zzat = ((zzgnn) zzgqwVar).zzat(zzgrpVar);
        int zzA = zzA(i4 << 3);
        return zzA + zzA + zzat;
    }

    public static int zzx(int i4) {
        if (i4 >= 0) {
            return zzA(i4);
        }
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzy(zzgqw zzgqwVar, zzgrp zzgrpVar) {
        int zzat = ((zzgnn) zzgqwVar).zzat(zzgrpVar);
        return zzA(zzat) + zzat;
    }

    public static int zzz(String str) {
        int length;
        try {
            length = zzgsv.zze(str);
        } catch (zzgsu unused) {
            length = str.getBytes(zzgpw.zzb).length;
        }
        return zzA(length) + length;
    }

    public final void zzD() {
        if (zzb() == 0) {
            return;
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzE(String str, zzgsu zzgsuVar) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzgsuVar);
        byte[] bytes = str.getBytes(zzgpw.zzb);
        try {
            int length = bytes.length;
            zzs(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzgoq(e4);
        }
    }

    public abstract void zzI() throws IOException;

    public abstract void zzJ(byte b4) throws IOException;

    public abstract void zzK(int i4, boolean z3) throws IOException;

    public abstract void zzL(int i4, zzgoe zzgoeVar) throws IOException;

    @Override // com.google.android.gms.internal.ads.zzgnt
    public abstract void zza(byte[] bArr, int i4, int i5) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i4, int i5) throws IOException;

    public abstract void zzi(int i4) throws IOException;

    public abstract void zzj(int i4, long j4) throws IOException;

    public abstract void zzk(long j4) throws IOException;

    public abstract void zzl(int i4, int i5) throws IOException;

    public abstract void zzm(int i4) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzn(int i4, zzgqw zzgqwVar, zzgrp zzgrpVar) throws IOException;

    public abstract void zzo(int i4, String str) throws IOException;

    public abstract void zzq(int i4, int i5) throws IOException;

    public abstract void zzr(int i4, int i5) throws IOException;

    public abstract void zzs(int i4) throws IOException;

    public abstract void zzt(int i4, long j4) throws IOException;

    public abstract void zzu(long j4) throws IOException;
}
