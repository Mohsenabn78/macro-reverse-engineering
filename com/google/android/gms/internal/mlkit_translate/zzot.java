package com.google.android.gms.internal.mlkit_translate;

import android.util.Log;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzot {
    private static final MediaType zzb = MediaType.parse("application/json; charset=utf-8");
    public final zzou zza;
    private final OkHttpClient zzc;
    @Nullable
    private zzpb zzd;
    private final zzoy zze;
    private final String zzf;

    public zzot(zzou zzouVar, zzoy zzoyVar) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.zzc = builder.connectTimeout(10000L, timeUnit).readTimeout(10000L, timeUnit).writeTimeout(10000L, timeUnit).build();
        this.zza = zzouVar;
        this.zze = zzoyVar;
        this.zzd = null;
        this.zzf = "https://firebaseinstallations.googleapis.com/v1";
    }

    private static long zze(long j4, String str) {
        return j4 + (Long.parseLong(str.replaceFirst("s$", "")) * 1000);
    }

    @Nullable
    private final String zzf(Headers headers, String str, String str2, zzox zzoxVar, zzox zzoxVar2) {
        String str3;
        try {
            Response execute = this.zzc.newCall(new Request.Builder().headers(headers).url(str).post(RequestBody.create(zzb, str2)).build()).execute();
            int code = execute.code();
            zzoxVar2.zzf(code);
            if (code >= 200 && code < 300) {
                try {
                    ResponseBody body = execute.body();
                    String string = body.string();
                    body.close();
                    return string;
                } catch (IOException e4) {
                    Log.e("MLKitFbInstsRestClient", "Error retrieving response body from HTTPS POST request to <" + str + ">", e4);
                    zznk zznkVar = zznk.RPC_ERROR;
                    zzoxVar2.zzd(zznkVar);
                    zzoxVar.zzb(zznkVar);
                    return null;
                }
            }
            Log.e("MLKitFbInstsRestClient", "Got HTTP status " + code + " from HTTPS POST request to <" + str + ">");
            try {
                ResponseBody body2 = execute.body();
                str3 = body2.string();
                body2.close();
            } catch (IOException unused) {
                str3 = "<none>";
            }
            "HTTP Response Body:\n".concat(String.valueOf(str3));
            zznk zznkVar2 = zznk.RPC_ERROR;
            zzoxVar2.zzd(zznkVar2);
            zzoxVar.zzb(zznkVar2);
            return null;
        } catch (IOException e5) {
            Log.e("MLKitFbInstsRestClient", "Connection error (or timeout) sending HTTPS POST request to <" + str + ">", e5);
            zzoxVar2.zzd(zznk.NO_CONNECTION);
            zzoxVar.zzb(zznk.NO_CONNECTION);
            return null;
        }
    }

    @Nullable
    public final zzpb zza() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzb(zzop zzopVar, zzox zzoxVar) throws zzrb, IOException, InterruptedException {
        zzoy zzoyVar;
        String format = String.format("%s/projects/%s/installations", this.zzf, this.zza.zzc());
        Headers build = new Headers.Builder().add("x-goog-api-key", this.zza.zza()).build();
        String format2 = String.format("{fid: '%s', appId: '%s', authVersion: '%s', sdkVersion: '%s'}", zzopVar.zza(), this.zza.zzb(), "FIS_v2", "o:a:mlkit:1.0.0");
        long currentTimeMillis = System.currentTimeMillis();
        zzox zzoxVar2 = new zzox();
        zzoxVar2.zzg();
        String zzf = zzf(build, format, format2, zzoxVar, zzoxVar2);
        zzoxVar2.zze();
        try {
            if (zzf == null) {
                return false;
            }
            try {
                zzbr zzb2 = zzbt.zzb(zzf).zzb();
                try {
                    String zzd = zzb2.zzd("name").zzd();
                    zzop zzopVar2 = new zzop(zzb2.zzd("fid").zzd());
                    String zzd2 = zzb2.zzd("refreshToken").zzd();
                    zzbr zzc = zzb2.zzc("authToken");
                    String zzd3 = zzc.zzd("token").zzd();
                    String zzd4 = zzc.zzd("expiresIn").zzd();
                    long zze = zze(currentTimeMillis, zzd4);
                    Log.i("MLKitFbInstsRestClient", "installation name: " + zzd);
                    String zza = zzopVar2.zza();
                    StringBuilder sb = new StringBuilder();
                    sb.append("fid: ");
                    sb.append(zza);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("refresh_token: ");
                    sb2.append(zzd2);
                    String valueOf = String.valueOf(zzc);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("auth token: ");
                    sb3.append(valueOf);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("auth token expires in: ");
                    sb4.append(zzd4);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("auth token expiry: ");
                    sb5.append(zze);
                    this.zzd = new zzpb(zzopVar2, zzd2, zzd3, zze);
                    this.zze.zza(zzle.INSTALLATION_ID_FIS_CREATE_INSTALLATION, zzoxVar2);
                    return true;
                } catch (ClassCastException | IllegalStateException | NullPointerException e4) {
                    String obj = zzb2.toString();
                    Log.e("MLKitFbInstsRestClient", "Error traversing JSON object returned from url <" + format + ">:\nraw json:\n" + zzf + "\nparsed json:\n" + obj, e4);
                    zznk zznkVar = zznk.RPC_RETURNED_INVALID_RESULT;
                    zzoxVar2.zzd(zznkVar);
                    zzoxVar.zzb(zznkVar);
                    zzoyVar = this.zze;
                    zzoyVar.zza(zzle.INSTALLATION_ID_FIS_CREATE_INSTALLATION, zzoxVar2);
                    return false;
                }
            } catch (zzbv | IllegalStateException | NullPointerException e5) {
                Log.e("MLKitFbInstsRestClient", "Error parsing JSON object returned from <" + format + ">:\n" + zzf, e5);
                zznk zznkVar2 = zznk.RPC_RETURNED_MALFORMED_RESULT;
                zzoxVar2.zzd(zznkVar2);
                zzoxVar.zzb(zznkVar2);
                zzoyVar = this.zze;
            }
        } finally {
            this.zze.zza(zzle.INSTALLATION_ID_FIS_CREATE_INSTALLATION, zzoxVar2);
        }
    }

    public final boolean zzc(final zzox zzoxVar) throws InterruptedException {
        if (this.zzd == null) {
            return false;
        }
        boolean zza = zzrd.zza(new zzrc() { // from class: com.google.android.gms.internal.mlkit_translate.zzor
            @Override // com.google.android.gms.internal.mlkit_translate.zzrc
            public final boolean zza() {
                return zzot.this.zzd(zzoxVar);
            }
        });
        if (!zza) {
            zzoxVar.zzc(zznk.RPC_EXPONENTIAL_BACKOFF_FAILED);
        }
        return zza;
    }

    public final boolean zzd(zzox zzoxVar) {
        zzoy zzoyVar;
        String format = String.format("%s/projects/%s/installations/%s/authTokens:generate", this.zzf, this.zza.zzc(), this.zzd.zzb().zza());
        Headers build = new Headers.Builder().add("authorization", "FIS_v2 ".concat(String.valueOf(this.zzd.zzc()))).add("x-goog-api-key", this.zza.zza()).build();
        String format2 = String.format("{installation:{sdkVersion:'%s'}}", "o:a:mlkit:1.0.0");
        long currentTimeMillis = System.currentTimeMillis();
        zzox zzoxVar2 = new zzox();
        zzoxVar2.zzg();
        String zzf = zzf(build, format, format2, zzoxVar, zzoxVar2);
        zzoxVar2.zze();
        try {
            if (zzf == null) {
                zzoyVar = this.zze;
            } else {
                try {
                    zzbr zzb2 = zzbt.zzb(zzf).zzb();
                    try {
                        String zzd = zzb2.zzd("token").zzd();
                        String zzd2 = zzb2.zzd("expiresIn").zzd();
                        long zze = zze(currentTimeMillis, zzd2);
                        StringBuilder sb = new StringBuilder();
                        sb.append("refreshed auth token: ");
                        sb.append(zzd);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("auth token expires in: ");
                        sb2.append(zzd2);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("auth token expiry: ");
                        sb3.append(zze);
                        this.zzd = new zzpb(this.zzd.zzb(), this.zzd.zzc(), zzd, zze);
                        return true;
                    } catch (ClassCastException | IllegalStateException | NullPointerException e4) {
                        zznk zznkVar = zznk.RPC_RETURNED_INVALID_RESULT;
                        zzoxVar2.zzd(zznkVar);
                        zzoxVar.zzb(zznkVar);
                        String obj = zzb2.toString();
                        Log.e("MLKitFbInstsRestClient", "Error traversing JSON object returned from <" + format + ">:\nraw json:\n" + zzf + "\nparsed json:\n" + obj, e4);
                        zzoyVar = this.zze;
                    }
                } catch (zzbv e5) {
                    Log.e("MLKitFbInstsRestClient", "Error parsing JSON object returned from <" + format + ">:\n" + zzf, e5);
                    zznk zznkVar2 = zznk.RPC_RETURNED_MALFORMED_RESULT;
                    zzoxVar2.zzd(zznkVar2);
                    zzoxVar.zzb(zznkVar2);
                    zzoyVar = this.zze;
                }
            }
            zzoyVar.zza(zzle.INSTALLATION_ID_FIS_GENERATE_AUTH_TOKEN, zzoxVar2);
            return false;
        } finally {
            this.zze.zza(zzle.INSTALLATION_ID_FIS_GENERATE_AUTH_TOKEN, zzoxVar2);
        }
    }
}
