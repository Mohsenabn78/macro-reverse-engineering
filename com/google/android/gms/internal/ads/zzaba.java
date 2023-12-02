package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaba {
    public static int zza(zzaax zzaaxVar, byte[] bArr, int i4, int i5) throws IOException {
        int i6 = 0;
        while (i6 < i5) {
            int zzb = zzaaxVar.zzb(bArr, i4 + i6, i5 - i6);
            if (zzb == -1) {
                break;
            }
            i6 += zzb;
        }
        return i6;
    }

    @Pure
    public static void zzb(boolean z3, @Nullable String str) throws zzcd {
        if (z3) {
            return;
        }
        throw zzcd.zza(str, null);
    }

    public static boolean zzc(zzaax zzaaxVar, byte[] bArr, int i4, int i5, boolean z3) throws IOException {
        try {
            return zzaaxVar.zzm(bArr, 0, i5, z3);
        } catch (EOFException e4) {
            if (z3) {
                return false;
            }
            throw e4;
        }
    }

    public static boolean zzd(zzaax zzaaxVar, byte[] bArr, int i4, int i5) throws IOException {
        try {
            ((zzaam) zzaaxVar).zzn(bArr, i4, i5, false);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean zze(zzaax zzaaxVar, int i4) throws IOException {
        try {
            ((zzaam) zzaaxVar).zzo(i4, false);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
