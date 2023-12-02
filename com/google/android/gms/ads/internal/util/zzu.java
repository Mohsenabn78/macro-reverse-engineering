package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbzk;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@TargetApi(24)
/* loaded from: classes4.dex */
public class zzu extends zzt {
    @VisibleForTesting
    static final boolean a(int i4, int i5, int i6) {
        if (Math.abs(i4 - i5) <= i6) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.ads.internal.util.zzaa
    public final boolean zze(Activity activity, Configuration configuration) {
        int i4;
        boolean isInMultiWindowMode;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeB)).booleanValue()) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeD)).booleanValue()) {
            isInMultiWindowMode = activity.isInMultiWindowMode();
            return isInMultiWindowMode;
        }
        com.google.android.gms.ads.internal.client.zzay.zzb();
        int zzx = zzbzk.zzx(activity, configuration.screenHeightDp);
        int zzx2 = zzbzk.zzx(activity, configuration.screenWidthDp);
        com.google.android.gms.ads.internal.zzt.zzp();
        DisplayMetrics zzq = zzs.zzq((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i5 = zzq.heightPixels;
        int i6 = zzq.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            i4 = activity.getResources().getDimensionPixelSize(identifier);
        } else {
            i4 = 0;
        }
        int round = ((int) Math.round(activity.getResources().getDisplayMetrics().density + 0.5d)) * ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzez)).intValue();
        if (a(i5, zzx + i4, round) && a(i6, zzx2, round)) {
            return false;
        }
        return true;
    }
}
