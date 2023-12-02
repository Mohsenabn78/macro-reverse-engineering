package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbtk;
import com.google.android.gms.internal.ads.zzbws;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzb {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19373a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f19374b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final zzbws f19375c;

    /* renamed from: d  reason: collision with root package name */
    private final zzbtk f19376d = new zzbtk(false, Collections.emptyList());

    public zzb(Context context, @Nullable zzbws zzbwsVar, @Nullable zzbtk zzbtkVar) {
        this.f19373a = context;
        this.f19375c = zzbwsVar;
    }

    private final boolean a() {
        zzbws zzbwsVar = this.f19375c;
        if ((zzbwsVar != null && zzbwsVar.zza().zzf) || this.f19376d.zza) {
            return true;
        }
        return false;
    }

    public final void zza() {
        this.f19374b = true;
    }

    public final void zzb(@Nullable String str) {
        List<String> list;
        if (!a()) {
            return;
        }
        if (str == null) {
            str = "";
        }
        zzbws zzbwsVar = this.f19375c;
        if (zzbwsVar != null) {
            zzbwsVar.zzd(str, null, 3);
            return;
        }
        zzbtk zzbtkVar = this.f19376d;
        if (zzbtkVar.zza && (list = zzbtkVar.zzb) != null) {
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    String replace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                    zzt.zzp();
                    com.google.android.gms.ads.internal.util.zzs.zzH(this.f19373a, "", replace);
                }
            }
        }
    }

    public final boolean zzc() {
        if (a() && !this.f19374b) {
            return false;
        }
        return true;
    }
}
