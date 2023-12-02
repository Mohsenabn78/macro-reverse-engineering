package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.google.mlkit.nl.translate.TranslateLanguage;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaqs {
    private static final String[] zza = {"/aclk", "/pcs/click", "/dbm/clk"};
    private final String zzb = "ad.doubleclick.net";
    private final String[] zzc = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private final zzaqo zzd;

    @Deprecated
    public zzaqs(zzaqo zzaqoVar) {
        this.zzd = zzaqoVar;
    }

    private final Uri zzg(Uri uri, String str) throws zzaqt {
        uri.getClass();
        try {
            try {
                if (uri.getHost().equals(this.zzb)) {
                    if (!uri.toString().contains("dc_ms=")) {
                        String uri2 = uri.toString();
                        int indexOf = uri2.indexOf(";adurl");
                        if (indexOf != -1) {
                            int i4 = indexOf + 1;
                            return Uri.parse(uri2.substring(0, i4) + "dc_ms=" + str + ";" + uri2.substring(i4));
                        }
                        String encodedPath = uri.getEncodedPath();
                        int indexOf2 = uri2.indexOf(encodedPath);
                        return Uri.parse(uri2.substring(0, encodedPath.length() + indexOf2) + ";dc_ms=" + str + ";" + uri2.substring(indexOf2 + encodedPath.length()));
                    }
                    throw new zzaqt("Parameter already exists: dc_ms");
                }
            } catch (NullPointerException unused) {
            }
            if (uri.getQueryParameter(TranslateLanguage.MALAY) == null) {
                String uri3 = uri.toString();
                int indexOf3 = uri3.indexOf("&adurl");
                if (indexOf3 == -1) {
                    indexOf3 = uri3.indexOf("?adurl");
                }
                if (indexOf3 != -1) {
                    int i5 = indexOf3 + 1;
                    return Uri.parse(uri3.substring(0, i5) + TranslateLanguage.MALAY + "=" + str + "&" + uri3.substring(i5));
                }
                return uri.buildUpon().appendQueryParameter(TranslateLanguage.MALAY, str).build();
            }
            throw new zzaqt("Query parameter already exists: ms");
        } catch (UnsupportedOperationException unused2) {
            throw new zzaqt("Provided Uri is not in a valid state");
        }
    }

    @Deprecated
    public final Uri zza(Uri uri, Context context, View view, Activity activity) throws zzaqt {
        try {
            return zzg(uri, this.zzd.zzf(context, uri.getQueryParameter("ai"), view, activity));
        } catch (UnsupportedOperationException unused) {
            throw new zzaqt("Provided Uri is not in a valid state");
        }
    }

    @Deprecated
    public final Uri zzb(Uri uri, Context context) throws zzaqt {
        return zzg(uri, this.zzd.zzg(context));
    }

    @Deprecated
    public final zzaqo zzc() {
        return this.zzd;
    }

    @Deprecated
    public final void zzd(MotionEvent motionEvent) {
        this.zzd.zzk(motionEvent);
    }

    public final boolean zze(Uri uri) {
        if (zzf(uri)) {
            String[] strArr = zza;
            for (int i4 = 0; i4 < 3; i4++) {
                if (uri.getPath().endsWith(strArr[i4])) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean zzf(Uri uri) {
        uri.getClass();
        try {
            String host = uri.getHost();
            String[] strArr = this.zzc;
            for (int i4 = 0; i4 < 3; i4++) {
                if (host.endsWith(strArr[i4])) {
                    return true;
                }
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }
}
