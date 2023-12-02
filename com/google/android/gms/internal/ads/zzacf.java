package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzacf {
    public static int zza(int i4) {
        int i5 = 0;
        while (i4 > 0) {
            i4 >>>= 1;
            i5++;
        }
        return i5;
    }

    @Nullable
    public static zzbz zzb(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            String str = (String) list.get(i4);
            int i5 = zzfj.zza;
            String[] split = str.split("=", 2);
            if (split.length != 2) {
                zzer.zzf("VorbisUtil", "Failed to parse Vorbis comment: ".concat(str));
            } else if (split[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(zzads.zzb(new zzfa(Base64.decode(split[1], 0))));
                } catch (RuntimeException e4) {
                    zzer.zzg("VorbisUtil", "Failed to parse vorbis picture", e4);
                }
            } else {
                arrayList.add(new zzaff(split[0], split[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzbz(arrayList);
    }

    public static zzacc zzc(zzfa zzfaVar, boolean z3, boolean z4) throws zzcd {
        if (z3) {
            zzd(3, zzfaVar, false);
        }
        String zzx = zzfaVar.zzx((int) zzfaVar.zzq(), zzfot.zzc);
        int length = zzx.length();
        long zzq = zzfaVar.zzq();
        String[] strArr = new String[(int) zzq];
        int i4 = length + 15;
        for (int i5 = 0; i5 < zzq; i5++) {
            String zzx2 = zzfaVar.zzx((int) zzfaVar.zzq(), zzfot.zzc);
            strArr[i5] = zzx2;
            i4 = i4 + 4 + zzx2.length();
        }
        if (z4 && (zzfaVar.zzk() & 1) == 0) {
            throw zzcd.zza("framing bit expected to be set", null);
        }
        return new zzacc(zzx, strArr, i4 + 1);
    }

    public static boolean zzd(int i4, zzfa zzfaVar, boolean z3) throws zzcd {
        if (zzfaVar.zza() < 7) {
            if (z3) {
                return false;
            }
            int zza = zzfaVar.zza();
            throw zzcd.zza("too short header: " + zza, null);
        } else if (zzfaVar.zzk() != i4) {
            if (z3) {
                return false;
            }
            throw zzcd.zza("expected header type ".concat(String.valueOf(Integer.toHexString(i4))), null);
        } else if (zzfaVar.zzk() == 118 && zzfaVar.zzk() == 111 && zzfaVar.zzk() == 114 && zzfaVar.zzk() == 98 && zzfaVar.zzk() == 105 && zzfaVar.zzk() == 115) {
            return true;
        } else {
            if (z3) {
                return false;
            }
            throw zzcd.zza("expected characters 'vorbis'", null);
        }
    }
}
