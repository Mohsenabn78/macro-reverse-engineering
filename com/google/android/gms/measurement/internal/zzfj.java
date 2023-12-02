package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzra;
import com.google.firebase.messaging.Constants;
import kotlinx.coroutines.DebugKt;
import net.bytebuddy.description.type.TypeDescription;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzfj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.measurement.zzbr f21613a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ServiceConnection f21614b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzfk f21615c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfj(zzfk zzfkVar, com.google.android.gms.internal.measurement.zzbr zzbrVar, ServiceConnection serviceConnection) {
        this.f21615c = zzfkVar;
        this.f21613a = zzbrVar;
        this.f21614b = serviceConnection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        Bundle bundle;
        zzfk zzfkVar = this.f21615c;
        zzfl zzflVar = zzfkVar.f21617b;
        str = zzfkVar.f21616a;
        com.google.android.gms.internal.measurement.zzbr zzbrVar = this.f21613a;
        ServiceConnection serviceConnection = this.f21614b;
        zzflVar.f21618a.zzaB().zzg();
        Bundle bundle2 = new Bundle();
        bundle2.putString("package_name", str);
        try {
            bundle = zzbrVar.zzd(bundle2);
        } catch (Exception e4) {
            zzflVar.f21618a.zzaA().zzd().zzb("Exception occurred while retrieving the Install Referrer", e4.getMessage());
        }
        if (bundle == null) {
            zzflVar.f21618a.zzaA().zzd().zza("Install Referrer Service returned a null response");
            bundle = null;
        }
        zzflVar.f21618a.zzaB().zzg();
        zzgd.h();
        if (bundle != null) {
            long j4 = bundle.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j4 == 0) {
                zzflVar.f21618a.zzaA().zzk().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundle.getString("install_referrer");
                if (string != null && !string.isEmpty()) {
                    zzflVar.f21618a.zzaA().zzj().zzb("InstallReferrer API result", string);
                    zzlp zzv = zzflVar.f21618a.zzv();
                    Uri parse = Uri.parse(TypeDescription.Generic.OfWildcardType.SYMBOL.concat(string));
                    zzra.zzc();
                    Bundle S = zzv.S(parse, zzflVar.f21618a.zzf().zzs(null, zzeg.zzaw));
                    if (S == null) {
                        zzflVar.f21618a.zzaA().zzd().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = S.getString("medium");
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j5 = bundle.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j5 == 0) {
                                zzflVar.f21618a.zzaA().zzd().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                S.putLong("click_timestamp", j5);
                            }
                        }
                        if (j4 == zzflVar.f21618a.zzm().f21594f.zza()) {
                            zzflVar.f21618a.zzaA().zzj().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (zzflVar.f21618a.zzJ()) {
                            zzflVar.f21618a.zzm().f21594f.zzb(j4);
                            zzflVar.f21618a.zzaA().zzj().zzb("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            S.putString("_cis", "referrer API v2");
                            zzflVar.f21618a.zzq().zzF(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, S, str);
                        }
                    }
                } else {
                    zzflVar.f21618a.zzaA().zzd().zza("No referrer defined in Install Referrer response");
                }
            }
        }
        ConnectionTracker.getInstance().unbindService(zzflVar.f21618a.zzaw(), serviceConnection);
    }
}
