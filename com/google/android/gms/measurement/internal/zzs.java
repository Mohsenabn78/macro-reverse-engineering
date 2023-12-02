package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.firebase.messaging.Constants;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzs {

    /* renamed from: a  reason: collision with root package name */
    private final zzgd f22089a;

    public zzs(zzgd zzgdVar) {
        this.f22089a = zzgdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void a(String str, Bundle bundle) {
        String uri;
        this.f22089a.zzaB().zzg();
        if (!this.f22089a.zzJ()) {
            if (bundle.isEmpty()) {
                uri = null;
            } else {
                if (true == str.isEmpty()) {
                    str = DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
                }
                Uri.Builder builder = new Uri.Builder();
                builder.path(str);
                for (String str2 : bundle.keySet()) {
                    builder.appendQueryParameter(str2, bundle.getString(str2));
                }
                uri = builder.build().toString();
            }
            if (!TextUtils.isEmpty(uri)) {
                this.f22089a.zzm().f21610v.zzb(uri);
                this.f22089a.zzm().f21611w.zzb(this.f22089a.zzax().currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void b() {
        String str;
        this.f22089a.zzaB().zzg();
        if (!d()) {
            return;
        }
        if (e()) {
            this.f22089a.zzm().f21610v.zzb(null);
            Bundle bundle = new Bundle();
            bundle.putString("source", "(not set)");
            bundle.putString("medium", "(not set)");
            bundle.putString("_cis", "intent");
            bundle.putLong("_cc", 1L);
            this.f22089a.zzq().e(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_cmpx", bundle);
        } else {
            String zza = this.f22089a.zzm().f21610v.zza();
            if (TextUtils.isEmpty(zza)) {
                this.f22089a.zzaA().zzh().zza("Cache still valid but referrer not found");
            } else {
                long zza2 = this.f22089a.zzm().f21611w.zza() / 3600000;
                Uri parse = Uri.parse(zza);
                Bundle bundle2 = new Bundle();
                Pair pair = new Pair(parse.getPath(), bundle2);
                for (String str2 : parse.getQueryParameterNames()) {
                    bundle2.putString(str2, parse.getQueryParameter(str2));
                }
                ((Bundle) pair.second).putLong("_cc", (zza2 - 1) * 3600000);
                Object obj = pair.first;
                if (obj == null) {
                    str = "app";
                } else {
                    str = (String) obj;
                }
                this.f22089a.zzq().e(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, (Bundle) pair.second);
            }
            this.f22089a.zzm().f21610v.zzb(null);
        }
        this.f22089a.zzm().f21611w.zzb(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        if (d() && e()) {
            this.f22089a.zzm().f21610v.zzb(null);
        }
    }

    final boolean d() {
        if (this.f22089a.zzm().f21611w.zza() > 0) {
            return true;
        }
        return false;
    }

    final boolean e() {
        if (!d() || this.f22089a.zzax().currentTimeMillis() - this.f22089a.zzm().f21611w.zza() <= this.f22089a.zzf().zzi(null, zzeg.zzS)) {
            return false;
        }
        return true;
    }
}
