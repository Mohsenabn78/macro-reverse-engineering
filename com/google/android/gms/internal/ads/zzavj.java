package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.PriorityQueue;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzavj {
    @VisibleForTesting
    static long zza(long j4, int i4) {
        long zza;
        if (i4 == 1) {
            return j4;
        }
        if ((i4 & 1) == 0) {
            zza = zza((j4 * j4) % 1073807359, i4 >> 1);
        } else {
            zza = j4 * (zza((j4 * j4) % 1073807359, i4 >> 1) % 1073807359);
        }
        return zza % 1073807359;
    }

    @VisibleForTesting
    static String zzb(String[] strArr, int i4, int i5) {
        int i6 = i5 + i4;
        if (strArr.length < i6) {
            zzbzr.zzg("Unable to construct shingle");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i7 = i6 - 1;
            if (i4 < i7) {
                sb.append(strArr[i4]);
                sb.append(' ');
                i4++;
            } else {
                sb.append(strArr[i7]);
                return sb.toString();
            }
        }
    }

    public static void zzc(String[] strArr, int i4, int i5, PriorityQueue priorityQueue) {
        int length = strArr.length;
        int i6 = 6;
        if (length < 6) {
            zzd(i4, zze(strArr, 0, length), zzb(strArr, 0, length), length, priorityQueue);
            return;
        }
        long zze = zze(strArr, 0, 6);
        zzd(i4, zze, zzb(strArr, 0, 6), 6, priorityQueue);
        int i7 = 1;
        while (true) {
            int length2 = strArr.length;
            if (i7 < length2 - 5) {
                String zzb = zzb(strArr, i7, i6);
                zze = ((((((zze + 1073807359) - ((zza(16785407L, 5) * ((zzavf.zza(strArr[i7 - 1]) + 2147483647L) % 1073807359)) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((zzavf.zza(strArr[i7 + 5]) + 2147483647L) % 1073807359)) % 1073807359;
                zzd(i4, zze, zzb, length2, priorityQueue);
                i7++;
                i6 = 6;
            } else {
                return;
            }
        }
    }

    @VisibleForTesting
    static void zzd(int i4, long j4, String str, int i5, PriorityQueue priorityQueue) {
        zzavi zzaviVar = new zzavi(j4, str, i5);
        if ((priorityQueue.size() == i4 && (((zzavi) priorityQueue.peek()).zzc > zzaviVar.zzc || ((zzavi) priorityQueue.peek()).zza > zzaviVar.zza)) || priorityQueue.contains(zzaviVar)) {
            return;
        }
        priorityQueue.add(zzaviVar);
        if (priorityQueue.size() > i4) {
            priorityQueue.poll();
        }
    }

    private static long zze(String[] strArr, int i4, int i5) {
        long zza = (zzavf.zza(strArr[0]) + 2147483647L) % 1073807359;
        for (int i6 = 1; i6 < i5; i6++) {
            zza = (((zza * 16785407) % 1073807359) + ((zzavf.zza(strArr[i6]) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return zza;
    }
}
