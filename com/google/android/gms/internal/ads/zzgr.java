package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgr extends zzfy implements zzhb {
    private final boolean zzb;
    private final int zzc;
    private final int zzd;
    @Nullable
    private final String zze;
    @Nullable
    private final zzha zzf;
    private final zzha zzg;
    @Nullable
    private zzgj zzh;
    @Nullable
    private HttpURLConnection zzi;
    @Nullable
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;

    /* JADX WARN: Removed duplicated region for block: B:17:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.net.HttpURLConnection zzk(java.net.URL r3, int r4, @androidx.annotation.Nullable byte[] r5, long r6, long r8, boolean r10, boolean r11, java.util.Map r12) throws java.io.IOException {
        /*
            r2 = this;
            java.net.URLConnection r3 = r3.openConnection()
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3
            int r4 = r2.zzc
            r3.setConnectTimeout(r4)
            int r4 = r2.zzd
            r3.setReadTimeout(r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            com.google.android.gms.internal.ads.zzha r5 = r2.zzf
            java.util.Map r5 = r5.zza()
            r4.putAll(r5)
            com.google.android.gms.internal.ads.zzha r5 = r2.zzg
            java.util.Map r5 = r5.zza()
            r4.putAll(r5)
            r4.putAll(r12)
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L32:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L4e
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r12 = r5.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            r3.setRequestProperty(r12, r5)
            goto L32
        L4e:
            r4 = 0
            r0 = -1
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r12 != 0) goto L5d
            int r6 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r6 != 0) goto L5c
            r4 = 0
            goto L7c
        L5c:
            r6 = r4
        L5d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "bytes="
            r4.append(r5)
            r4.append(r6)
            java.lang.String r5 = "-"
            r4.append(r5)
            int r5 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r5 == 0) goto L78
            long r6 = r6 + r8
            long r6 = r6 + r0
            r4.append(r6)
        L78:
            java.lang.String r4 = r4.toString()
        L7c:
            if (r4 == 0) goto L83
            java.lang.String r5 = "Range"
            r3.setRequestProperty(r5, r4)
        L83:
            java.lang.String r4 = r2.zze
            if (r4 == 0) goto L8c
            java.lang.String r5 = "User-Agent"
            r3.setRequestProperty(r5, r4)
        L8c:
            r4 = 1
            if (r4 == r10) goto L92
            java.lang.String r4 = "identity"
            goto L94
        L92:
            java.lang.String r4 = "gzip"
        L94:
            java.lang.String r5 = "Accept-Encoding"
            r3.setRequestProperty(r5, r4)
            r3.setInstanceFollowRedirects(r11)
            r4 = 0
            r3.setDoOutput(r4)
            int r4 = com.google.android.gms.internal.ads.zzgj.zzj
            java.lang.String r4 = "GET"
            r3.setRequestMethod(r4)
            r3.connect()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgr.zzk(java.net.URL, int, byte[], long, long, boolean, boolean, java.util.Map):java.net.HttpURLConnection");
    }

    private final URL zzl(URL url, @Nullable String str, zzgj zzgjVar) throws zzgx {
        if (str != null) {
            try {
                URL url2 = new URL(url, str);
                String protocol = url2.getProtocol();
                if (!ProxyConfig.MATCH_HTTPS.equals(protocol) && !"http".equals(protocol)) {
                    throw new zzgx("Unsupported protocol redirect: ".concat(String.valueOf(protocol)), zzgjVar, 2001, 1);
                }
                if (!this.zzb && !protocol.equals(url.getProtocol())) {
                    String protocol2 = url.getProtocol();
                    throw new zzgx("Disallowed cross-protocol redirect (" + protocol2 + " to " + protocol + ")", zzgjVar, 2001, 1);
                }
                return url2;
            } catch (MalformedURLException e4) {
                throw new zzgx(e4, zzgjVar, 2001, 1);
            }
        }
        throw new zzgx("Null location redirect", zzgjVar, 2001, 1);
    }

    private final void zzm() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e4) {
                zzer.zzd("DefaultHttpDataSource", "Unexpected error while disconnecting", e4);
            }
            this.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzt
    public final int zza(byte[] bArr, int i4, int i5) throws zzgx {
        if (i5 == 0) {
            return 0;
        }
        try {
            long j4 = this.zzm;
            if (j4 != -1) {
                long j5 = j4 - this.zzn;
                if (j5 != 0) {
                    i5 = (int) Math.min(i5, j5);
                }
                return -1;
            }
            InputStream inputStream = this.zzj;
            int i6 = zzfj.zza;
            int read = inputStream.read(bArr, i4, i5);
            if (read == -1) {
                return -1;
            }
            this.zzn += read;
            zzg(read);
            return read;
        } catch (IOException e4) {
            zzgj zzgjVar = this.zzh;
            int i7 = zzfj.zza;
            throw zzgx.zza(e4, zzgjVar, 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x01dc, code lost:
        r2 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01fe, code lost:
        throw new com.google.android.gms.internal.ads.zzgx(new java.net.NoRouteToHostException("Too many redirects: " + r6), r27, 2001, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b2, code lost:
        if (r10 == 0) goto L62;
     */
    @Override // com.google.android.gms.internal.ads.zzge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzb(com.google.android.gms.internal.ads.zzgj r27) throws com.google.android.gms.internal.ads.zzgx {
        /*
            Method dump skipped, instructions count: 523
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgr.zzb(com.google.android.gms.internal.ads.zzgj):long");
    }

    @Override // com.google.android.gms.internal.ads.zzge
    @Nullable
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzd() throws zzgx {
        long j4;
        try {
            InputStream inputStream = this.zzj;
            if (inputStream != null) {
                long j5 = this.zzm;
                if (j5 == -1) {
                    j4 = -1;
                } else {
                    j4 = j5 - this.zzn;
                }
                HttpURLConnection httpURLConnection = this.zzi;
                try {
                    if (httpURLConnection != null) {
                        if (zzfj.zza <= 20) {
                            try {
                                InputStream inputStream2 = httpURLConnection.getInputStream();
                                if (j4 == -1) {
                                    if (inputStream2.read() != -1) {
                                    }
                                } else if (j4 <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                                }
                                String name = inputStream2.getClass().getName();
                                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                                    Class<? super Object> superclass = inputStream2.getClass().getSuperclass();
                                    superclass.getClass();
                                    Method declaredMethod = superclass.getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                                    declaredMethod.setAccessible(true);
                                    declaredMethod.invoke(inputStream2, new Object[0]);
                                }
                            } catch (Exception unused) {
                            }
                        }
                        inputStream.close();
                    }
                    inputStream.close();
                } catch (IOException e4) {
                    zzgj zzgjVar = this.zzh;
                    int i4 = zzfj.zza;
                    throw new zzgx(e4, zzgjVar, 2000, 3);
                }
            }
        } finally {
            this.zzj = null;
            zzm();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfy, com.google.android.gms.internal.ads.zzge
    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return zzfsf.zzd();
        }
        return new zzgp(httpURLConnection.getHeaderFields());
    }

    @Deprecated
    public zzgr() {
        this(null, ConnectionsStatusCodes.STATUS_NETWORK_NOT_CONNECTED, ConnectionsStatusCodes.STATUS_NETWORK_NOT_CONNECTED, false, null, null, false);
    }

    private zzgr(@Nullable String str, int i4, int i5, boolean z3, @Nullable zzha zzhaVar, @Nullable zzfpi zzfpiVar, boolean z4) {
        super(true);
        this.zze = str;
        this.zzc = i4;
        this.zzd = i5;
        this.zzb = z3;
        this.zzf = zzhaVar;
        this.zzg = new zzha();
    }
}
