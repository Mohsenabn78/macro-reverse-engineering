package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzamg implements zzaku {
    private final zzamf zzc;
    private final Map zza = new LinkedHashMap(16, 0.75f, true);
    private long zzb = 0;
    private final int zzd = 5242880;

    public zzamg(zzamf zzamfVar, int i4) {
        this.zzc = zzamfVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(InputStream inputStream) throws IOException {
        return (zzn(inputStream) << 24) | zzn(inputStream) | (zzn(inputStream) << 8) | (zzn(inputStream) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzf(InputStream inputStream) throws IOException {
        return (zzn(inputStream) & 255) | ((zzn(inputStream) & 255) << 8) | ((zzn(inputStream) & 255) << 16) | ((zzn(inputStream) & 255) << 24) | ((zzn(inputStream) & 255) << 32) | ((zzn(inputStream) & 255) << 40) | ((zzn(inputStream) & 255) << 48) | ((zzn(inputStream) & 255) << 56);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzh(zzame zzameVar) throws IOException {
        return new String(zzm(zzameVar, zzf(zzameVar)), "UTF-8");
    }

    static void zzj(OutputStream outputStream, int i4) throws IOException {
        outputStream.write(i4 & 255);
        outputStream.write((i4 >> 8) & 255);
        outputStream.write((i4 >> 16) & 255);
        outputStream.write((i4 >> 24) & 255);
    }

    static void zzk(OutputStream outputStream, long j4) throws IOException {
        outputStream.write((byte) j4);
        outputStream.write((byte) (j4 >>> 8));
        outputStream.write((byte) (j4 >>> 16));
        outputStream.write((byte) (j4 >>> 24));
        outputStream.write((byte) (j4 >>> 32));
        outputStream.write((byte) (j4 >>> 40));
        outputStream.write((byte) (j4 >>> 48));
        outputStream.write((byte) (j4 >>> 56));
    }

    static void zzl(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        int length = bytes.length;
        zzk(outputStream, length);
        outputStream.write(bytes, 0, length);
    }

    @VisibleForTesting
    static byte[] zzm(zzame zzameVar, long j4) throws IOException {
        int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        long zza = zzameVar.zza();
        if (i4 >= 0 && j4 <= zza) {
            int i5 = (int) j4;
            if (i5 == j4) {
                byte[] bArr = new byte[i5];
                new DataInputStream(zzameVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j4 + ", maxLength=" + zza);
    }

    private static int zzn(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private final void zzo(String str, zzamd zzamdVar) {
        if (!this.zza.containsKey(str)) {
            this.zzb += zzamdVar.zza;
        } else {
            this.zzb += zzamdVar.zza - ((zzamd) this.zza.get(str)).zza;
        }
        this.zza.put(str, zzamdVar);
    }

    private final void zzp(String str) {
        zzamd zzamdVar = (zzamd) this.zza.remove(str);
        if (zzamdVar != null) {
            this.zzb -= zzamdVar.zza;
        }
    }

    private static final String zzq(String str) {
        int length = str.length() / 2;
        return String.valueOf(String.valueOf(str.substring(0, length).hashCode())).concat(String.valueOf(String.valueOf(str.substring(length).hashCode())));
    }

    @Override // com.google.android.gms.internal.ads.zzaku
    public final synchronized zzakt zza(String str) {
        zzamd zzamdVar = (zzamd) this.zza.get(str);
        if (zzamdVar == null) {
            return null;
        }
        File zzg = zzg(str);
        try {
            zzame zzameVar = new zzame(new BufferedInputStream(new FileInputStream(zzg)), zzg.length());
            try {
                zzamd zza = zzamd.zza(zzameVar);
                if (!TextUtils.equals(str, zza.zzb)) {
                    zzalw.zza("%s: key=%s, found=%s", zzg.getAbsolutePath(), str, zza.zzb);
                    zzp(str);
                    return null;
                }
                byte[] zzm = zzm(zzameVar, zzameVar.zza());
                zzakt zzaktVar = new zzakt();
                zzaktVar.zza = zzm;
                zzaktVar.zzb = zzamdVar.zzc;
                zzaktVar.zzc = zzamdVar.zzd;
                zzaktVar.zzd = zzamdVar.zze;
                zzaktVar.zze = zzamdVar.zzf;
                zzaktVar.zzf = zzamdVar.zzg;
                List<zzalc> list = zzamdVar.zzh;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (zzalc zzalcVar : list) {
                    treeMap.put(zzalcVar.zza(), zzalcVar.zzb());
                }
                zzaktVar.zzg = treeMap;
                zzaktVar.zzh = Collections.unmodifiableList(zzamdVar.zzh);
                return zzaktVar;
            } finally {
                zzameVar.close();
            }
        } catch (IOException e4) {
            zzalw.zza("%s: %s", zzg.getAbsolutePath(), e4.toString());
            zzi(str);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaku
    public final synchronized void zzb() {
        long length;
        zzame zzameVar;
        File zza = this.zzc.zza();
        if (!zza.exists()) {
            if (!zza.mkdirs()) {
                zzalw.zzb("Unable to create cache dir %s", zza.getAbsolutePath());
                return;
            }
            return;
        }
        File[] listFiles = zza.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                try {
                    length = file.length();
                    zzameVar = new zzame(new BufferedInputStream(new FileInputStream(file)), length);
                } catch (IOException unused) {
                    file.delete();
                }
                try {
                    zzamd zza2 = zzamd.zza(zzameVar);
                    zza2.zza = length;
                    zzo(zza2.zzb, zza2);
                    zzameVar.close();
                } catch (Throwable th) {
                    zzameVar.close();
                    throw th;
                    break;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaku
    public final synchronized void zzc(String str, boolean z3) {
        zzakt zza = zza(str);
        if (zza != null) {
            zza.zzf = 0L;
            zza.zze = 0L;
            zzd(str, zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaku
    public final synchronized void zzd(String str, zzakt zzaktVar) {
        BufferedOutputStream bufferedOutputStream;
        zzamd zzamdVar;
        long j4;
        long j5 = this.zzb;
        int length = zzaktVar.zza.length;
        long j6 = j5 + length;
        int i4 = this.zzd;
        if (j6 > i4 && length > i4 * 0.9f) {
            return;
        }
        File zzg = zzg(str);
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(zzg));
            zzamdVar = new zzamd(str, zzaktVar);
        } catch (IOException unused) {
            if (!zzg.delete()) {
                zzalw.zza("Could not clean up file %s", zzg.getAbsolutePath());
            }
            if (!this.zzc.zza().exists()) {
                zzalw.zza("Re-initializing cache after external clearing.", new Object[0]);
                this.zza.clear();
                this.zzb = 0L;
                zzb();
                return;
            }
        }
        try {
            zzj(bufferedOutputStream, 538247942);
            zzl(bufferedOutputStream, zzamdVar.zzb);
            String str2 = zzamdVar.zzc;
            if (str2 == null) {
                str2 = "";
            }
            zzl(bufferedOutputStream, str2);
            zzk(bufferedOutputStream, zzamdVar.zzd);
            zzk(bufferedOutputStream, zzamdVar.zze);
            zzk(bufferedOutputStream, zzamdVar.zzf);
            zzk(bufferedOutputStream, zzamdVar.zzg);
            List<zzalc> list = zzamdVar.zzh;
            if (list != null) {
                zzj(bufferedOutputStream, list.size());
                for (zzalc zzalcVar : list) {
                    zzl(bufferedOutputStream, zzalcVar.zza());
                    zzl(bufferedOutputStream, zzalcVar.zzb());
                }
            } else {
                zzj(bufferedOutputStream, 0);
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.write(zzaktVar.zza);
            bufferedOutputStream.close();
            zzamdVar.zza = zzg.length();
            zzo(str, zzamdVar);
            if (this.zzb >= this.zzd) {
                if (zzalw.zzb) {
                    zzalw.zzd("Pruning old cache entries.", new Object[0]);
                }
                long j7 = this.zzb;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Iterator it = this.zza.entrySet().iterator();
                int i5 = 0;
                while (true) {
                    if (it.hasNext()) {
                        zzamd zzamdVar2 = (zzamd) ((Map.Entry) it.next()).getValue();
                        if (zzg(zzamdVar2.zzb).delete()) {
                            j4 = elapsedRealtime;
                            this.zzb -= zzamdVar2.zza;
                        } else {
                            j4 = elapsedRealtime;
                            String str3 = zzamdVar2.zzb;
                            zzalw.zza("Could not delete cache entry for key=%s, filename=%s", str3, zzq(str3));
                        }
                        it.remove();
                        i5++;
                        if (((float) this.zzb) < this.zzd * 0.9f) {
                            break;
                        }
                        elapsedRealtime = j4;
                    } else {
                        j4 = elapsedRealtime;
                        break;
                    }
                }
                if (zzalw.zzb) {
                    zzalw.zzd("pruned %d files, %d bytes, %d ms", Integer.valueOf(i5), Long.valueOf(this.zzb - j7), Long.valueOf(SystemClock.elapsedRealtime() - j4));
                }
            }
        } catch (IOException e4) {
            zzalw.zza("%s", e4.toString());
            bufferedOutputStream.close();
            zzalw.zza("Failed to write header for %s", zzg.getAbsolutePath());
            throw new IOException();
        }
    }

    public final File zzg(String str) {
        return new File(this.zzc.zza(), zzq(str));
    }

    public final synchronized void zzi(String str) {
        boolean delete = zzg(str).delete();
        zzp(str);
        if (!delete) {
            zzalw.zza("Could not delete cache entry for key=%s, filename=%s", str, zzq(str));
        }
    }

    public zzamg(File file, int i4) {
        this.zzc = new zzamc(this, file);
    }
}
