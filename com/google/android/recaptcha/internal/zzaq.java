package com.google.android.recaptcha.internal;

import android.net.TrafficStats;
import android.webkit.URLUtil;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzaq implements zzap {
    @NotNull
    private final String zza;

    public zzaq(@NotNull String str) {
        this.zza = str;
    }

    private static final void zzb(byte[] bArr) {
        List listOf;
        for (zzkx zzkxVar : zzla.zzi(bArr).zzj()) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"INIT_TOTAL", "EXECUTE_TOTAL"});
            if (listOf.contains(zzkxVar.zzj().name()) && zzkxVar.zzS()) {
                zzkxVar.zzH();
                zzkxVar.zzI();
                zzkxVar.zzj().name();
                zzkxVar.zzg().zzk();
                zzkxVar.zzg().zzf();
                zzkxVar.zzT();
            } else {
                zzkxVar.zzH();
                zzkxVar.zzI();
                zzkxVar.zzj().name();
                zzkxVar.zzT();
            }
        }
    }

    @Override // com.google.android.recaptcha.internal.zzap
    public final boolean zza(@NotNull byte[] bArr) {
        HttpURLConnection httpURLConnection;
        try {
            TrafficStats.setThreadStatsTag((int) Thread.currentThread().getId());
            zzb(bArr);
            if (URLUtil.isHttpUrl(this.zza)) {
                URLConnection openConnection = new URL(this.zza).openConnection();
                Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                httpURLConnection = (HttpURLConnection) openConnection;
            } else if (URLUtil.isHttpsUrl(this.zza)) {
                URLConnection openConnection2 = new URL(this.zza).openConnection();
                Intrinsics.checkNotNull(openConnection2, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                httpURLConnection = (HttpsURLConnection) openConnection2;
            } else {
                throw new MalformedURLException("Recaptcha server url only allows using Http or Https.");
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-protobuffer");
            httpURLConnection.connect();
            httpURLConnection.getOutputStream().write(bArr);
            if (httpURLConnection.getResponseCode() != 200) {
                return false;
            }
            return true;
        } catch (Exception e4) {
            e4.getMessage();
            return false;
        }
    }
}
