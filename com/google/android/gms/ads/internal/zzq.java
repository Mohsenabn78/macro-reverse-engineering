package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.ads.zzaqs;
import com.google.android.gms.internal.ads.zzbzr;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzq extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzs f19398a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzq(zzs zzsVar, zzp zzpVar) {
        this.f19398a = zzsVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public final String doInBackground(Void... voidArr) {
        try {
            zzs zzsVar = this.f19398a;
            zzs.i(zzsVar, (zzaqs) zzs.h(zzsVar).get(1000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e4) {
            e = e4;
            zzbzr.zzk("", e);
        } catch (ExecutionException e5) {
            e = e5;
            zzbzr.zzk("", e);
        } catch (TimeoutException e6) {
            zzbzr.zzk("", e6);
        }
        return this.f19398a.zzp();
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzs zzsVar = this.f19398a;
        if (zzs.c(zzsVar) != null && str != null) {
            zzs.c(zzsVar).loadUrl(str);
        }
    }
}
