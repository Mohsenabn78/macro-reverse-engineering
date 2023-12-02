package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.net.HttpHeaders;
import com.tencent.soter.core.model.ConstantsSoter;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzebl extends zzbrl {
    private final Context zza;
    private final zzdqa zzb;
    private final zzbzw zzc;
    private final zzeba zzd;
    private final zzfev zze;
    private String zzf;
    private String zzg;

    @VisibleForTesting
    public zzebl(Context context, zzeba zzebaVar, zzbzw zzbzwVar, zzdqa zzdqaVar, zzfev zzfevVar) {
        this.zza = context;
        this.zzb = zzdqaVar;
        this.zzc = zzbzwVar;
        this.zzd = zzebaVar;
        this.zze = zzfevVar;
    }

    public static void zzc(Context context, zzdqa zzdqaVar, zzfev zzfevVar, zzeba zzebaVar, String str, String str2, Map map) {
        String str3;
        String zza;
        if (true != com.google.android.gms.ads.internal.zzt.zzo().zzx(context)) {
            str3 = "offline";
        } else {
            str3 = CustomTabsCallback.ONLINE_EXTRAS_KEY;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzig)).booleanValue() && zzdqaVar != null) {
            zzdpz zza2 = zzdqaVar.zza();
            zza2.zzb("gqi", str);
            zza2.zzb("action", str2);
            zza2.zzb("device_connectivity", str3);
            zza2.zzb("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()));
            for (Map.Entry entry : map.entrySet()) {
                zza2.zzb((String) entry.getKey(), (String) entry.getValue());
            }
            zza = zza2.zzf();
        } else {
            zzfeu zzb = zzfeu.zzb(str2);
            zzb.zza("gqi", str);
            zzb.zza("device_connectivity", str3);
            zzb.zza("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()));
            for (Map.Entry entry2 : map.entrySet()) {
                zzb.zza((String) entry2.getKey(), (String) entry2.getValue());
            }
            zza = zzfevVar.zza(zzb);
        }
        zzebaVar.zzd(new zzebc(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis(), str, zza, 2));
    }

    private static String zzo(int i4, String str) {
        Resources zzd = com.google.android.gms.ads.internal.zzt.zzo().zzd();
        if (zzd == null) {
            return str;
        }
        return zzd.getString(i4);
    }

    private final void zzp(String str, String str2, Map map) {
        zzc(this.zza, this.zzb, this.zze, this.zzd, str, str2, map);
    }

    private final void zzq(com.google.android.gms.ads.internal.util.zzbr zzbrVar) {
        try {
            if (zzbrVar.zzf(ObjectWrapper.wrap(this.zza), this.zzg, this.zzf)) {
                return;
            }
        } catch (RemoteException e4) {
            zzbzr.zzh("Failed to schedule offline notification poster.", e4);
        }
        this.zzd.zzc(this.zzf);
        zzp(this.zzf, "offline_notification_worker_not_scheduled", zzfsf.zzd());
    }

    private final void zzr(final Activity activity, @Nullable final com.google.android.gms.ads.internal.overlay.zzl zzlVar, final com.google.android.gms.ads.internal.util.zzbr zzbrVar) {
        com.google.android.gms.ads.internal.zzt.zzp();
        if (!NotificationManagerCompat.from(activity).areNotificationsEnabled()) {
            if (Build.VERSION.SDK_INT >= 33) {
                activity.requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 12345);
                zzp(this.zzf, "asnpdi", zzfsf.zzd());
                return;
            }
            com.google.android.gms.ads.internal.zzt.zzp();
            AlertDialog.Builder zzG = com.google.android.gms.ads.internal.util.zzs.zzG(activity);
            zzG.setTitle(zzo(R.string.notifications_permission_title, "Allow app to send you notifications?")).setPositiveButton(zzo(R.string.notifications_permission_confirm, HttpHeaders.ALLOW), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzebd
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    zzebl.this.zzd(activity, zzbrVar, zzlVar, dialogInterface, i4);
                }
            }).setNegativeButton(zzo(R.string.notifications_permission_decline, "Don't allow"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzebe
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    zzebl.this.zzj(zzlVar, dialogInterface, i4);
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzebf
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    zzebl.this.zzk(zzlVar, dialogInterface);
                }
            });
            zzG.create().show();
            zzp(this.zzf, "rtsdi", zzfsf.zzd());
            return;
        }
        zzq(zzbrVar);
        zzs(activity, zzlVar);
    }

    private final void zzs(Activity activity, @Nullable final com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        String zzo = zzo(R.string.offline_opt_in_confirmation, "You'll get a notification with the link when you're back online");
        com.google.android.gms.ads.internal.zzt.zzp();
        AlertDialog.Builder zzG = com.google.android.gms.ads.internal.util.zzs.zzG(activity);
        zzG.setMessage(zzo).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzebj
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                com.google.android.gms.ads.internal.overlay.zzl zzlVar2 = com.google.android.gms.ads.internal.overlay.zzl.this;
                if (zzlVar2 != null) {
                    zzlVar2.zzb();
                }
            }
        });
        AlertDialog create = zzG.create();
        create.show();
        Timer timer = new Timer();
        timer.schedule(new zzebk(this, create, timer, zzlVar), ConstantsSoter.FACEID_AUTH_CHECK_TIME);
    }

    private static final PendingIntent zzt(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setClassName(context, AdService.CLASS_NAME);
        intent.setAction(str);
        intent.putExtra("offline_notification_action", str);
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str3);
        return zzfmm.zza(context, 0, intent, zzfmm.zza | 1073741824, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Activity activity, com.google.android.gms.ads.internal.util.zzbr zzbrVar, com.google.android.gms.ads.internal.overlay.zzl zzlVar, DialogInterface dialogInterface, int i4) {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "confirm");
        zzp(this.zzf, "rtsdc", hashMap);
        activity.startActivity(com.google.android.gms.ads.internal.zzt.zzq().zzg(activity));
        zzq(zzbrVar);
        if (zzlVar != null) {
            zzlVar.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void zze(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (!stringExtra.equals("offline_notification_clicked") && !stringExtra.equals("offline_notification_dismissed")) {
            return;
        }
        String stringExtra2 = intent.getStringExtra("gws_query_id");
        String stringExtra3 = intent.getStringExtra("uri");
        boolean zzx = com.google.android.gms.ads.internal.zzt.zzo().zzx(this.zza);
        HashMap hashMap = new HashMap();
        char c4 = 2;
        if (stringExtra.equals("offline_notification_clicked")) {
            hashMap.put("offline_notification_action", "offline_notification_clicked");
            if (true == zzx) {
                c4 = 1;
            }
            hashMap.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
            hashMap.put("olaih", String.valueOf(stringExtra3.startsWith("http")));
            try {
                Intent launchIntentForPackage = this.zza.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                if (launchIntentForPackage == null) {
                    launchIntentForPackage = new Intent("android.intent.action.VIEW");
                    launchIntentForPackage.setData(Uri.parse(stringExtra3));
                }
                launchIntentForPackage.addFlags(268435456);
                this.zza.startActivity(launchIntentForPackage);
                hashMap.put("olaa", "olas");
            } catch (ActivityNotFoundException unused) {
                hashMap.put("olaa", "olaf");
            }
        } else {
            hashMap.put("offline_notification_action", "offline_notification_dismissed");
        }
        zzp(stringExtra2, "offline_notification_action", hashMap);
        try {
            SQLiteDatabase writableDatabase = this.zzd.getWritableDatabase();
            if (c4 == 1) {
                this.zzd.zzg(writableDatabase, this.zzc, stringExtra2);
            } else {
                zzeba.zzi(writableDatabase, stringExtra2);
            }
        } catch (SQLiteException e4) {
            zzbzr.zzg("Failed to get writable offline buffering database: ".concat(e4.toString()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void zzf(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) {
        for (int i4 = 0; i4 < strArr.length; i4++) {
            if (strArr[i4].equals("android.permission.POST_NOTIFICATIONS")) {
                zzebn zzebnVar = (zzebn) ObjectWrapper.unwrap(iObjectWrapper);
                Activity zza = zzebnVar.zza();
                com.google.android.gms.ads.internal.util.zzbr zzc = zzebnVar.zzc();
                com.google.android.gms.ads.internal.overlay.zzl zzb = zzebnVar.zzb();
                HashMap hashMap = new HashMap();
                if (iArr[i4] == 0) {
                    hashMap.put("dialog_action", "confirm");
                    if (zzc != null) {
                        zzq(zzc);
                    }
                    zzs(zza, zzb);
                } else {
                    hashMap.put("dialog_action", "dismiss");
                    if (zzb != null) {
                        zzb.zzb();
                    }
                }
                zzp(this.zzf, "asnpdc", hashMap);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void zzg(IObjectWrapper iObjectWrapper) {
        zzebn zzebnVar = (zzebn) ObjectWrapper.unwrap(iObjectWrapper);
        final Activity zza = zzebnVar.zza();
        final com.google.android.gms.ads.internal.overlay.zzl zzb = zzebnVar.zzb();
        final com.google.android.gms.ads.internal.util.zzbr zzc = zzebnVar.zzc();
        this.zzf = zzebnVar.zzd();
        this.zzg = zzebnVar.zze();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhZ)).booleanValue()) {
            zzp(this.zzf, "dialog_impression", zzfsf.zzd());
            com.google.android.gms.ads.internal.zzt.zzp();
            AlertDialog.Builder zzG = com.google.android.gms.ads.internal.util.zzs.zzG(zza);
            zzG.setTitle(zzo(R.string.offline_opt_in_title, "Open ad when you're back online.")).setMessage(zzo(R.string.offline_opt_in_message, "We'll send you a notification with a link to the advertiser site.")).setPositiveButton(zzo(R.string.offline_opt_in_confirm, "OK"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzebg
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    zzebl.this.zzl(zza, zzb, zzc, dialogInterface, i4);
                }
            }).setNegativeButton(zzo(R.string.offline_opt_in_decline, "No thanks"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzebh
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    zzebl.this.zzm(zzb, dialogInterface, i4);
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzebi
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    zzebl.this.zzn(zzb, dialogInterface);
                }
            });
            zzG.create().show();
            return;
        }
        zzr(zza, zzb, zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void zzh() {
        zzeba zzebaVar = this.zzd;
        final zzbzw zzbzwVar = this.zzc;
        zzebaVar.zze(new zzfdo() { // from class: com.google.android.gms.internal.ads.zzeaw
            @Override // com.google.android.gms.internal.ads.zzfdo
            public final Object zza(Object obj) {
                zzeba.zzb(zzbzw.this, (SQLiteDatabase) obj);
                return null;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void zzi(IObjectWrapper iObjectWrapper, String str, String str2) {
        String str3;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        com.google.android.gms.ads.internal.zzt.zzq().zzh(context, "offline_notification_channel", "AdMob Offline Notifications");
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(context, "offline_notification_channel").setContentTitle(zzo(R.string.offline_notification_title, "View the ad you saved when you were offline")).setContentText(zzo(R.string.offline_notification_text, "Tap to open ad")).setAutoCancel(true).setDeleteIntent(zzt(context, "offline_notification_dismissed", str2, str)).setContentIntent(zzt(context, "offline_notification_clicked", str2, str)).setSmallIcon(context.getApplicationInfo().icon);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        HashMap hashMap = new HashMap();
        try {
            notificationManager.notify(str2, 54321, smallIcon.build());
            str3 = "offline_notification_impression";
        } catch (IllegalArgumentException e4) {
            hashMap.put("notification_not_shown_reason", e4.getMessage());
            str3 = "offline_notification_failed";
        }
        zzp(str2, str3, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(com.google.android.gms.ads.internal.overlay.zzl zzlVar, DialogInterface dialogInterface, int i4) {
        this.zzd.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzp(this.zzf, "rtsdc", hashMap);
        if (zzlVar != null) {
            zzlVar.zzb();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(com.google.android.gms.ads.internal.overlay.zzl zzlVar, DialogInterface dialogInterface) {
        this.zzd.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzp(this.zzf, "rtsdc", hashMap);
        if (zzlVar != null) {
            zzlVar.zzb();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(Activity activity, com.google.android.gms.ads.internal.overlay.zzl zzlVar, com.google.android.gms.ads.internal.util.zzbr zzbrVar, DialogInterface dialogInterface, int i4) {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "confirm");
        zzp(this.zzf, "dialog_click", hashMap);
        zzr(activity, zzlVar, zzbrVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(com.google.android.gms.ads.internal.overlay.zzl zzlVar, DialogInterface dialogInterface, int i4) {
        this.zzd.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzp(this.zzf, "dialog_click", hashMap);
        if (zzlVar != null) {
            zzlVar.zzb();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(com.google.android.gms.ads.internal.overlay.zzl zzlVar, DialogInterface dialogInterface) {
        this.zzd.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzp(this.zzf, "dialog_click", hashMap);
        if (zzlVar != null) {
            zzlVar.zzb();
        }
    }
}
