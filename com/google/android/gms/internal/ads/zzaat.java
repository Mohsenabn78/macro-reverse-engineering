package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.android.dx.io.Opcodes;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import java.util.Arrays;
import org.jcodings.transcode.EConvFlags;
import org.jetbrains.anko.DimensionsKt;
import org.joni.constants.internal.StackType;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaat {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzc = {-1, ConnectionsStatusCodes.STATUS_NETWORK_NOT_CONNECTED, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] zzd = {64, 112, 128, 192, Opcodes.SHL_INT_LIT8, 256, 384, 448, 512, DimensionsKt.XXXHDPI, 768, 896, 1024, 1152, StackType.POS, StackType.STOP_BT, 1920, 2048, StackType.RETURN, StackType.VOID, 2688, StackType.ABSENT_POS, 2823, 2944, StackType.ABSENT, EConvFlags.NEWLINE_DECORATOR_READ_MASK, 4096, 6144, 7680};

    public static zzam zza(byte[] bArr, @Nullable String str, @Nullable String str2, @Nullable zzad zzadVar) {
        zzez zzezVar;
        int i4 = 0;
        int i5 = -1;
        if (bArr[0] == Byte.MAX_VALUE) {
            zzezVar = new zzez(bArr, bArr.length);
        } else {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            byte b4 = copyOf[0];
            if (b4 == -2 || b4 == -1) {
                for (int i6 = 0; i6 < copyOf.length - 1; i6 += 2) {
                    byte b5 = copyOf[i6];
                    int i7 = i6 + 1;
                    copyOf[i6] = copyOf[i7];
                    copyOf[i7] = b5;
                }
            }
            int length = copyOf.length;
            zzezVar = new zzez(copyOf, length);
            if (copyOf[0] == 31) {
                zzez zzezVar2 = new zzez(copyOf, length);
                while (zzezVar2.zza() >= 16) {
                    zzezVar2.zzl(2);
                    zzezVar.zzf(zzezVar2.zzd(14), 14);
                }
            }
            zzezVar.zzi(copyOf, copyOf.length);
        }
        zzezVar.zzl(60);
        int i8 = zzb[zzezVar.zzd(6)];
        int i9 = zzc[zzezVar.zzd(4)];
        int zzd2 = zzezVar.zzd(5);
        if (zzd2 < 29) {
            i5 = (zzd[zzd2] * 1000) / 2;
        }
        zzezVar.zzl(10);
        if (zzezVar.zzd(2) > 0) {
            i4 = 1;
        }
        int i10 = i8 + i4;
        zzak zzakVar = new zzak();
        zzakVar.zzH(str);
        zzakVar.zzS("audio/vnd.dts");
        zzakVar.zzv(i5);
        zzakVar.zzw(i10);
        zzakVar.zzT(i9);
        zzakVar.zzB(null);
        zzakVar.zzK(str2);
        return zzakVar.zzY();
    }
}
