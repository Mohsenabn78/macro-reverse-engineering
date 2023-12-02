package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfgy {
    private final zzfhf zza;
    private final WebView zzb;
    private final List zzc = new ArrayList();
    private final Map zzd = new HashMap();
    private final String zze = "";
    @Nullable
    private final String zzf;
    private final zzfgz zzg;

    private zzfgy(zzfhf zzfhfVar, WebView webView, String str, List list, @Nullable String str2, String str3, zzfgz zzfgzVar) {
        this.zza = zzfhfVar;
        this.zzb = webView;
        this.zzg = zzfgzVar;
        this.zzf = str2;
    }

    public static zzfgy zzb(zzfhf zzfhfVar, WebView webView, @Nullable String str, String str2) {
        return new zzfgy(zzfhfVar, webView, null, null, str, "", zzfgz.HTML);
    }

    public static zzfgy zzc(zzfhf zzfhfVar, WebView webView, @Nullable String str, String str2) {
        return new zzfgy(zzfhfVar, webView, null, null, str, "", zzfgz.JAVASCRIPT);
    }

    public final WebView zza() {
        return this.zzb;
    }

    public final zzfgz zzd() {
        return this.zzg;
    }

    public final zzfhf zze() {
        return this.zza;
    }

    @Nullable
    public final String zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zze;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final Map zzi() {
        return Collections.unmodifiableMap(this.zzd);
    }
}
