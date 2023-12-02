package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import org.json.JSONException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaca  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaca {
    public static void zza(String str, zzabx zzabxVar, Type type, zzabg zzabgVar) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(60000);
            zzabgVar.zza(httpURLConnection);
            zzc(httpURLConnection, zzabxVar, type);
        } catch (SocketTimeoutException unused) {
            zzabxVar.zza("TIMEOUT");
        } catch (UnknownHostException unused2) {
            zzabxVar.zza("<<Network Error>>");
        } catch (IOException e4) {
            zzabxVar.zza(e4.getMessage());
        }
    }

    public static void zzb(String str, zzabc zzabcVar, zzabx zzabxVar, Type type, zzabg zzabgVar) {
        try {
            Preconditions.checkNotNull(zzabcVar);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoOutput(true);
            byte[] bytes = zzabcVar.zza().getBytes(Charset.defaultCharset());
            int length = bytes.length;
            httpURLConnection.setFixedLengthStreamingMode(length);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setConnectTimeout(60000);
            zzabgVar.zza(httpURLConnection);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream(), length);
            try {
                bufferedOutputStream.write(bytes, 0, length);
                bufferedOutputStream.close();
                zzc(httpURLConnection, zzabxVar, type);
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable th2) {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                }
                throw th;
            }
        } catch (NullPointerException e4) {
            e = e4;
            zzabxVar.zza(e.getMessage());
        } catch (SocketTimeoutException unused) {
            zzabxVar.zza("TIMEOUT");
        } catch (UnknownHostException unused2) {
            zzabxVar.zza("<<Network Error>>");
        } catch (IOException e5) {
            e = e5;
            zzabxVar.zza(e.getMessage());
        } catch (JSONException e6) {
            e = e6;
            zzabxVar.zza(e.getMessage());
        }
    }

    private static void zzc(HttpURLConnection httpURLConnection, zzabx zzabxVar, Type type) {
        InputStream errorStream;
        try {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (zzd(responseCode)) {
                    errorStream = httpURLConnection.getInputStream();
                } else {
                    errorStream = httpURLConnection.getErrorStream();
                }
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, "UTF-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                        }
                        throw th;
                    }
                }
                bufferedReader.close();
                String sb2 = sb.toString();
                if (!zzd(responseCode)) {
                    zzabxVar.zza((String) zzabb.zza(sb2, String.class));
                } else {
                    zzabxVar.zzb((zzabd) zzabb.zza(sb2, type));
                }
                httpURLConnection.disconnect();
            } catch (zzyt e4) {
                e = e4;
                zzabxVar.zza(e.getMessage());
                httpURLConnection.disconnect();
            } catch (SocketTimeoutException unused) {
                zzabxVar.zza("TIMEOUT");
                httpURLConnection.disconnect();
            } catch (IOException e5) {
                e = e5;
                zzabxVar.zza(e.getMessage());
                httpURLConnection.disconnect();
            }
        } catch (Throwable th3) {
            httpURLConnection.disconnect();
            throw th3;
        }
    }

    private static final boolean zzd(int i4) {
        if (i4 >= 200 && i4 < 300) {
            return true;
        }
        return false;
    }
}
