package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.arlosoft.macrodroid.celltowers.CellTowerBackgroundScanService;
import com.google.android.gms.ads.impl.R;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbqo extends zzbqw {
    private final Map zza;
    private final Context zzb;
    private final String zzc;
    private final long zzd;
    private final long zze;
    private final String zzf;
    private final String zzg;

    public zzbqo(zzcez zzcezVar, Map map) {
        super(zzcezVar, "createCalendarEvent");
        this.zza = map;
        this.zzb = zzcezVar.zzi();
        this.zzc = zze("description");
        this.zzf = zze("summary");
        this.zzd = zzd("start_ticks");
        this.zze = zzd("end_ticks");
        this.zzg = zze(FirebaseAnalytics.Param.LOCATION);
    }

    private final long zzd(String str) {
        String str2 = (String) this.zza.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    private final String zze(String str) {
        if (TextUtils.isEmpty((CharSequence) this.zza.get(str))) {
            return "";
        }
        return (String) this.zza.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Intent zzb() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzc);
        data.putExtra("eventLocation", this.zzg);
        data.putExtra("description", this.zzf);
        long j4 = this.zzd;
        if (j4 > -1) {
            data.putExtra("beginTime", j4);
        }
        long j5 = this.zze;
        if (j5 > -1) {
            data.putExtra(CellTowerBackgroundScanService.EXTRA_END_TIME, j5);
        }
        data.setFlags(268435456);
        return data;
    }

    public final void zzc() {
        String str;
        String str2;
        String str3;
        String str4;
        if (this.zzb == null) {
            zzg("Activity context is not available.");
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        if (!new zzbaw(this.zzb).zzb()) {
            zzg("This feature is not available on the device.");
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        AlertDialog.Builder zzG = com.google.android.gms.ads.internal.util.zzs.zzG(this.zzb);
        Resources zzd = com.google.android.gms.ads.internal.zzt.zzo().zzd();
        if (zzd != null) {
            str = zzd.getString(R.string.s5);
        } else {
            str = "Create calendar event";
        }
        zzG.setTitle(str);
        if (zzd != null) {
            str2 = zzd.getString(R.string.s6);
        } else {
            str2 = "Allow Ad to create a calendar event?";
        }
        zzG.setMessage(str2);
        if (zzd != null) {
            str3 = zzd.getString(R.string.s3);
        } else {
            str3 = HttpHeaders.ACCEPT;
        }
        zzG.setPositiveButton(str3, new zzbqm(this));
        if (zzd != null) {
            str4 = zzd.getString(R.string.s4);
        } else {
            str4 = "Decline";
        }
        zzG.setNegativeButton(str4, new zzbqn(this));
        zzG.create().show();
    }
}
