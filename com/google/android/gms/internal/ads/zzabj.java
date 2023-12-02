package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.compose.animation.core.AnimationKt;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import java.util.Collections;
import java.util.List;
import javax.mail.UIDFolder;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzabj {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final long zzj;
    @Nullable
    public final zzabi zzk;
    @Nullable
    private final zzbz zzl;

    private zzabj(int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j4, @Nullable zzabi zzabiVar, @Nullable zzbz zzbzVar) {
        this.zza = i4;
        this.zzb = i5;
        this.zzc = i6;
        this.zzd = i7;
        this.zze = i8;
        this.zzf = zzi(i8);
        this.zzg = i9;
        this.zzh = i10;
        this.zzi = zzh(i10);
        this.zzj = j4;
        this.zzk = zzabiVar;
        this.zzl = zzbzVar;
    }

    private static int zzh(int i4) {
        if (i4 != 8) {
            if (i4 != 12) {
                if (i4 != 16) {
                    if (i4 != 20) {
                        if (i4 != 24) {
                            return -1;
                        }
                        return 6;
                    }
                    return 5;
                }
                return 4;
            }
            return 2;
        }
        return 1;
    }

    private static int zzi(int i4) {
        switch (i4) {
            case ConnectionsStatusCodes.STATUS_NETWORK_NOT_CONNECTED /* 8000 */:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public final long zza() {
        long j4 = this.zzj;
        if (j4 == 0) {
            return -9223372036854775807L;
        }
        return (j4 * AnimationKt.MillisToNanos) / this.zze;
    }

    public final long zzb(long j4) {
        return Math.max(0L, Math.min((j4 * this.zze) / AnimationKt.MillisToNanos, this.zzj - 1));
    }

    public final zzam zzc(byte[] bArr, @Nullable zzbz zzbzVar) {
        bArr[4] = Byte.MIN_VALUE;
        int i4 = this.zzd;
        if (i4 <= 0) {
            i4 = -1;
        }
        zzbz zzd = zzd(zzbzVar);
        zzak zzakVar = new zzak();
        zzakVar.zzS("audio/flac");
        zzakVar.zzL(i4);
        zzakVar.zzw(this.zzg);
        zzakVar.zzT(this.zze);
        zzakVar.zzI(Collections.singletonList(bArr));
        zzakVar.zzM(zzd);
        return zzakVar.zzY();
    }

    @Nullable
    public final zzbz zzd(@Nullable zzbz zzbzVar) {
        zzbz zzbzVar2 = this.zzl;
        if (zzbzVar2 == null) {
            return zzbzVar;
        }
        return zzbzVar2.zzd(zzbzVar);
    }

    public final zzabj zze(List list) {
        return new zzabj(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(new zzbz(list)));
    }

    public final zzabj zzf(@Nullable zzabi zzabiVar) {
        return new zzabj(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, zzabiVar, this.zzl);
    }

    public final zzabj zzg(List list) {
        return new zzabj(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(zzacf.zzb(list)));
    }

    public zzabj(byte[] bArr, int i4) {
        zzez zzezVar = new zzez(bArr, bArr.length);
        zzezVar.zzj(i4 * 8);
        this.zza = zzezVar.zzd(16);
        this.zzb = zzezVar.zzd(16);
        this.zzc = zzezVar.zzd(24);
        this.zzd = zzezVar.zzd(24);
        int zzd = zzezVar.zzd(20);
        this.zze = zzd;
        this.zzf = zzi(zzd);
        this.zzg = zzezVar.zzd(3) + 1;
        int zzd2 = zzezVar.zzd(5) + 1;
        this.zzh = zzd2;
        this.zzi = zzh(zzd2);
        int zzd3 = zzezVar.zzd(4);
        int zzd4 = zzezVar.zzd(32);
        int i5 = zzfj.zza;
        this.zzj = ((zzd3 & UIDFolder.MAXUID) << 32) | (zzd4 & UIDFolder.MAXUID);
        this.zzk = null;
        this.zzl = null;
    }
}
