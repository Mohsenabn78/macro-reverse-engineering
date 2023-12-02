package com.google.android.gms.internal.ads;

import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfmm {
    public static final int zza;
    public static final ClipData zzb;

    static {
        int i4;
        if (Build.VERSION.SDK_INT > 22) {
            i4 = 67108864;
        } else {
            i4 = 0;
        }
        zza = i4;
        zzb = ClipData.newIntent("", new Intent());
    }

    @Nullable
    public static PendingIntent zza(Context context, int i4, Intent intent, int i5, int i6) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9 = true;
        if ((i5 & 88) == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzfph.zzf(z3, "Cannot set any dangerous parts of intent to be mutable.");
        if ((i5 & 1) != 0 && !zzb(0, 3)) {
            z4 = false;
        } else {
            z4 = true;
        }
        zzfph.zzf(z4, "Cannot use Intent.FILL_IN_ACTION unless the action is marked as mutable.");
        if ((i5 & 2) != 0 && !zzb(0, 5)) {
            z5 = false;
        } else {
            z5 = true;
        }
        zzfph.zzf(z5, "Cannot use Intent.FILL_IN_DATA unless the data is marked as mutable.");
        if ((i5 & 4) != 0 && !zzb(0, 9)) {
            z6 = false;
        } else {
            z6 = true;
        }
        zzfph.zzf(z6, "Cannot use Intent.FILL_IN_CATEGORIES unless the category is marked as mutable.");
        if ((i5 & 128) != 0 && !zzb(0, 17)) {
            z7 = false;
        } else {
            z7 = true;
        }
        zzfph.zzf(z7, "Cannot use Intent.FILL_IN_CLIP_DATA unless the clip data is marked as mutable.");
        if (intent.getComponent() != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        zzfph.zzf(z8, "Must set component on Intent.");
        if (zzb(0, 1)) {
            zzfph.zzf(!zzb(i5, 67108864), "Cannot set mutability flags if PendingIntent.FLAG_IMMUTABLE is set.");
        } else {
            if (Build.VERSION.SDK_INT >= 23 && !zzb(i5, 67108864)) {
                z9 = false;
            }
            zzfph.zzf(z9, "Must set PendingIntent.FLAG_IMMUTABLE for SDK >= 23 if no parts of intent are mutable.");
        }
        Intent intent2 = new Intent(intent);
        if (Build.VERSION.SDK_INT < 23 || !zzb(i5, 67108864)) {
            if (intent2.getPackage() == null) {
                intent2.setPackage(intent2.getComponent().getPackageName());
            }
            if (!zzb(0, 3) && intent2.getAction() == null) {
                intent2.setAction("");
            }
            if (!zzb(0, 9) && intent2.getCategories() == null) {
                intent2.addCategory("");
            }
            if (!zzb(0, 5) && intent2.getData() == null) {
                intent2.setDataAndType(Uri.EMPTY, "*/*");
            }
            if (!zzb(0, 17) && intent2.getClipData() == null) {
                intent2.setClipData(zzb);
            }
        }
        return PendingIntent.getService(context, 0, intent2, i5);
    }

    private static boolean zzb(int i4, int i5) {
        if ((i4 & i5) == i5) {
            return true;
        }
        return false;
    }
}
