package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcep extends zzfy implements zzhb {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final zzha zzf;
    private zzgj zzg;
    private HttpURLConnection zzh;
    private final Queue zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private final long zzr;
    private final long zzs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcep(String str, zzhg zzhgVar, int i4, int i5, long j4, long j5) {
        super(true);
        zzdy.zzc(str);
        this.zze = str;
        this.zzf = new zzha();
        this.zzc = i4;
        this.zzd = i5;
        this.zzi = new ArrayDeque();
        this.zzr = j4;
        this.zzs = j5;
        if (zzhgVar != null) {
            zzf(zzhgVar);
        }
    }

    private final void zzl() {
        while (!this.zzi.isEmpty()) {
            try {
                ((HttpURLConnection) this.zzi.remove()).disconnect();
            } catch (Exception e4) {
                zzbzr.zzh("Unexpected error while disconnecting", e4);
            }
        }
        this.zzh = null;
    }

    @Override // com.google.android.gms.internal.ads.zzt
    public final int zza(byte[] bArr, int i4, int i5) throws zzgx {
        if (i5 == 0) {
            return 0;
        }
        try {
            long j4 = this.zzm;
            long j5 = this.zzn;
            if (j4 - j5 == 0) {
                return -1;
            }
            long j6 = this.zzo + j5;
            long j7 = i5;
            long j8 = this.zzs;
            long j9 = this.zzq;
            long j10 = j9 + 1;
            if (j6 + j7 + j8 > j10) {
                long j11 = this.zzp;
                if (j9 < j11) {
                    long min = Math.min(j11, Math.max(((this.zzr + j10) - j8) - 1, (-1) + j10 + j7));
                    zzk(j10, min, 2);
                    this.zzq = min;
                    j9 = min;
                }
            }
            int read = this.zzj.read(bArr, i4, (int) Math.min(j7, ((j9 + 1) - this.zzo) - this.zzn));
            if (read != -1) {
                this.zzn += read;
                zzg(read);
                return read;
            }
            throw new EOFException();
        } catch (IOException e4) {
            throw new zzgx(e4, this.zzg, 2000, 2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final long zzb(zzgj zzgjVar) throws zzgx {
        long min;
        this.zzg = zzgjVar;
        this.zzn = 0L;
        long j4 = zzgjVar.zzf;
        long j5 = zzgjVar.zzg;
        if (j5 == -1) {
            min = this.zzr;
        } else {
            min = Math.min(this.zzr, j5);
        }
        this.zzo = j4;
        HttpURLConnection zzk = zzk(j4, (min + j4) - 1, 1);
        this.zzh = zzk;
        String headerField = zzk.getHeaderField(HttpHeaders.CONTENT_RANGE);
        if (!TextUtils.isEmpty(headerField)) {
            Matcher matcher = zzb.matcher(headerField);
            if (matcher.find()) {
                try {
                    Long.parseLong(matcher.group(1));
                    long parseLong = Long.parseLong(matcher.group(2));
                    long parseLong2 = Long.parseLong(matcher.group(3));
                    long j6 = zzgjVar.zzg;
                    if (j6 != -1) {
                        this.zzm = j6;
                        this.zzp = Math.max(parseLong, (this.zzo + j6) - 1);
                    } else {
                        this.zzm = parseLong2 - this.zzo;
                        this.zzp = parseLong2 - 1;
                    }
                    this.zzq = parseLong;
                    this.zzk = true;
                    zzj(zzgjVar);
                    return this.zzm;
                } catch (NumberFormatException unused) {
                    zzbzr.zzg("Unexpected Content-Range [" + headerField + "]");
                }
            }
        }
        throw new zzcen(headerField, zzgjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    @Nullable
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzd() throws zzgx {
        try {
            InputStream inputStream = this.zzj;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    throw new zzgx(e4, this.zzg, 2000, 3);
                }
            }
        } finally {
            this.zzj = null;
            zzl();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfy, com.google.android.gms.internal.ads.zzge
    @Nullable
    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    @VisibleForTesting
    final HttpURLConnection zzk(long j4, long j5, int i4) throws zzgx {
        String uri = this.zzg.zza.toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
            httpURLConnection.setConnectTimeout(this.zzc);
            httpURLConnection.setReadTimeout(this.zzd);
            for (Map.Entry entry : this.zzf.zza().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, "bytes=" + j4 + "-" + j5);
            httpURLConnection.setRequestProperty("User-Agent", this.zze);
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, HTTP.IDENTITY_CODING);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            this.zzi.add(httpURLConnection);
            String uri2 = this.zzg.zza.toString();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                this.zzl = responseCode;
                if (responseCode >= 200 && responseCode <= 299) {
                    try {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        if (this.zzj != null) {
                            inputStream = new SequenceInputStream(this.zzj, inputStream);
                        }
                        this.zzj = inputStream;
                        return httpURLConnection;
                    } catch (IOException e4) {
                        zzl();
                        throw new zzgx(e4, this.zzg, 2000, i4);
                    }
                }
                Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                zzl();
                throw new zzceo(this.zzl, headerFields, this.zzg, i4);
            } catch (IOException e5) {
                zzl();
                String valueOf = String.valueOf(uri2);
                throw new zzgx("Unable to connect to ".concat(valueOf), e5, this.zzg, 2000, i4);
            }
        } catch (IOException e6) {
            String valueOf2 = String.valueOf(uri);
            throw new zzgx("Unable to connect to ".concat(valueOf2), e6, this.zzg, 2000, i4);
        }
    }
}
