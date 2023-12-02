package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.internal.ads.zzbcl;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzgws;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzn implements zzbcl {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzbcn f19361a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f19362b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Uri f19363c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(zzs zzsVar, zzbcn zzbcnVar, Context context, Uri uri) {
        this.f19361a = zzbcnVar;
        this.f19362b = context;
        this.f19363c = uri;
    }

    @Override // com.google.android.gms.internal.ads.zzbcl
    public final void zza() {
        CustomTabsIntent build = new CustomTabsIntent.Builder(this.f19361a.zza()).build();
        build.intent.setPackage(zzgws.zza(this.f19362b));
        build.launchUrl(this.f19362b, this.f19363c);
        this.f19361a.zzf((Activity) this.f19362b);
    }
}
