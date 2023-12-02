package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzart {
    private static final String zzd = "zzart";
    protected final Context zza;
    private ExecutorService zze;
    private DexClassLoader zzf;
    private zzaqy zzg;
    private byte[] zzh;
    private final boolean zzl;
    private zzaqn zzo;
    private final Map zzp;
    private zzarm zzr;
    private volatile AdvertisingIdClient zzi = null;
    private volatile boolean zzj = false;
    private Future zzk = null;
    private volatile zzaon zzm = null;
    private Future zzn = null;
    protected boolean zzb = false;
    protected boolean zzc = false;
    private boolean zzq = false;

    private zzart(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.zzl = applicationContext != null;
        context = applicationContext != null ? applicationContext : context;
        this.zza = context;
        this.zzp = new HashMap();
        if (this.zzr != null) {
            return;
        }
        this.zzr = new zzarm(context);
    }

    public static zzart zzg(Context context, String str, String str2, boolean z3) {
        zzaqy zzaqyVar;
        boolean z4;
        boolean z5;
        zzart zzartVar = new zzart(context);
        try {
            zzartVar.zze = Executors.newCachedThreadPool(new zzarp());
            zzartVar.zzj = z3;
            if (z3) {
                zzartVar.zzk = zzartVar.zze.submit(new zzarq(zzartVar));
            }
            zzartVar.zze.execute(new zzars(zzartVar));
            try {
                GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
                if (googleApiAvailabilityLight.getApkVersion(zzartVar.zza) > 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                zzartVar.zzb = z4;
                if (googleApiAvailabilityLight.isGooglePlayServicesAvailable(zzartVar.zza) == 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                zzartVar.zzc = z5;
            } catch (Throwable unused) {
            }
            zzartVar.zzo(0, true);
            if (zzarw.zzc() && ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcV)).booleanValue()) {
                throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
            }
            zzaqyVar = new zzaqy(null);
            zzartVar.zzg = zzaqyVar;
            try {
            } catch (zzaqx e4) {
                throw new zzarj(e4);
            }
        } catch (zzarj unused2) {
        }
        try {
            byte[] zzb = zzapd.zzb("THDWXzjjYOq9y9/d/gcKuzbUJu6FkzolekKt4SY4cbo=", false);
            if (zzb.length == 32) {
                byte[] bArr = new byte[16];
                ByteBuffer.wrap(zzb, 4, 16).get(bArr);
                for (int i4 = 0; i4 < 16; i4++) {
                    bArr[i4] = (byte) (bArr[i4] ^ 68);
                }
                zzartVar.zzh = bArr;
                try {
                    try {
                        File cacheDir = zzartVar.zza.getCacheDir();
                        if (cacheDir == null && (cacheDir = zzartVar.zza.getDir("dex", 0)) == null) {
                            throw new zzarj();
                        }
                        File file = new File(String.format("%s/%s.jar", cacheDir, "1684864811298"));
                        if (!file.exists()) {
                            byte[] zzb2 = zzartVar.zzg.zzb(zzartVar.zzh, "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");
                            file.createNewFile();
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            if (Build.VERSION.SDK_INT >= 33) {
                                file.setReadOnly();
                            }
                            fileOutputStream.write(zzb2, 0, zzb2.length);
                            fileOutputStream.close();
                        }
                        zzartVar.zzx(cacheDir, "1684864811298");
                        try {
                            zzartVar.zzf = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), null, zzartVar.zza.getClassLoader());
                            zzy(file);
                            zzartVar.zzw(cacheDir, "1684864811298");
                            zzz(String.format("%s/%s.dex", cacheDir, "1684864811298"));
                            zzartVar.zzo = new zzaqn(zzartVar);
                            zzartVar.zzq = true;
                            return zzartVar;
                        } catch (Throwable th) {
                            zzy(file);
                            zzartVar.zzw(cacheDir, "1684864811298");
                            zzz(String.format("%s/%s.dex", cacheDir, "1684864811298"));
                            throw th;
                        }
                    } catch (FileNotFoundException e5) {
                        throw new zzarj(e5);
                    } catch (IOException e6) {
                        throw new zzarj(e6);
                    }
                } catch (zzaqx e7) {
                    throw new zzarj(e7);
                } catch (NullPointerException e8) {
                    throw new zzarj(e8);
                }
            }
            throw new zzaqx(zzaqyVar);
        } catch (IllegalArgumentException e9) {
            throw new zzaqx(zzaqyVar, e9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzv() {
        try {
            if (this.zzi == null && this.zzl) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zza);
                advertisingIdClient.start();
                this.zzi = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzi = null;
        }
    }

    private final void zzw(File file, String str) {
        Throwable th;
        FileOutputStream fileOutputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, "1684864811298"));
        if (file2.exists()) {
            return;
        }
        File file3 = new File(String.format("%s/%s.dex", file, "1684864811298"));
        if (!file3.exists()) {
            return;
        }
        long length = file3.length();
        if (length <= 0) {
            return;
        }
        byte[] bArr = new byte[(int) length];
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file3);
            try {
                if (fileInputStream2.read(bArr) <= 0) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                    zzy(file3);
                    return;
                }
                System.out.print("test");
                System.out.print("test");
                System.out.print("test");
                zzaoq zza = zzaor.zza();
                byte[] bytes = Build.VERSION.SDK.getBytes();
                zzgoe zzgoeVar = zzgoe.zzb;
                zza.zzc(zzgoe.zzv(bytes, 0, bytes.length));
                byte[] bytes2 = "1684864811298".getBytes();
                zza.zzd(zzgoe.zzv(bytes2, 0, bytes2.length));
                byte[] bytes3 = this.zzg.zza(this.zzh, bArr).getBytes();
                zza.zza(zzgoe.zzv(bytes3, 0, bytes3.length));
                byte[] zze = zzaph.zze(bytes3);
                zza.zzb(zzgoe.zzv(zze, 0, zze.length));
                file2.createNewFile();
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] zzax = ((zzaor) zza.zzal()).zzax();
                    fileOutputStream.write(zzax, 0, zzax.length);
                    fileOutputStream.close();
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused2) {
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                    }
                    zzy(file3);
                } catch (zzaqx | IOException | NoSuchAlgorithmException unused4) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                    zzy(file3);
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused7) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused8) {
                        }
                    }
                    zzy(file3);
                    throw th;
                }
            } catch (zzaqx | IOException | NoSuchAlgorithmException unused9) {
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (zzaqx | IOException | NoSuchAlgorithmException unused10) {
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    private final boolean zzx(File file, String str) {
        FileOutputStream fileOutputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, "1684864811298"));
        if (!file2.exists()) {
            return false;
        }
        File file3 = new File(String.format("%s/%s.dex", file, "1684864811298"));
        if (!file3.exists()) {
            FileInputStream fileInputStream = null;
            try {
                long length = file2.length();
                if (length <= 0) {
                    zzy(file2);
                    return false;
                }
                byte[] bArr = new byte[(int) length];
                FileInputStream fileInputStream2 = new FileInputStream(file2);
                try {
                    try {
                        if (fileInputStream2.read(bArr) <= 0) {
                            zzy(file2);
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused) {
                            }
                            return false;
                        }
                        try {
                            try {
                                zzaor zzd2 = zzaor.zzd(bArr, zzgoy.zza());
                                if ("1684864811298".equals(new String(zzd2.zzh().zzA())) && Arrays.equals(zzd2.zzf().zzA(), zzaph.zze(zzd2.zze().zzA())) && Arrays.equals(zzd2.zzg().zzA(), Build.VERSION.SDK.getBytes())) {
                                    byte[] zzb = this.zzg.zzb(this.zzh, new String(zzd2.zze().zzA()));
                                    file3.createNewFile();
                                    fileOutputStream = new FileOutputStream(file3);
                                    try {
                                        fileOutputStream.write(zzb, 0, zzb.length);
                                        try {
                                            fileInputStream2.close();
                                        } catch (IOException unused2) {
                                        }
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException unused3) {
                                        }
                                        return true;
                                    } catch (zzaqx | IOException | NoSuchAlgorithmException unused4) {
                                        fileInputStream = fileInputStream2;
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (IOException unused5) {
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException unused6) {
                                            }
                                        }
                                        return false;
                                    } catch (Throwable th) {
                                        th = th;
                                        fileInputStream = fileInputStream2;
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (IOException unused7) {
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException unused8) {
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                zzy(file2);
                                try {
                                    fileInputStream2.close();
                                } catch (IOException unused9) {
                                }
                                return false;
                            } catch (NullPointerException unused10) {
                                fileInputStream2.close();
                                return false;
                            }
                        } catch (IOException unused11) {
                            return false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                    }
                } catch (zzaqx | IOException | NoSuchAlgorithmException unused12) {
                    fileOutputStream = null;
                }
            } catch (zzaqx | IOException | NoSuchAlgorithmException unused13) {
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        }
        return false;
    }

    private static final void zzy(File file) {
        if (!file.exists()) {
            String.format("File %s not found. No need for deletion", file.getAbsolutePath());
        } else {
            file.delete();
        }
    }

    private static final void zzz(String str) {
        zzy(new File(str));
    }

    public final int zza() {
        if (this.zzo != null) {
            return zzaqn.zzd();
        }
        return Integer.MIN_VALUE;
    }

    public final Context zzb() {
        return this.zza;
    }

    public final zzaon zzc() {
        return this.zzm;
    }

    public final zzaqn zzd() {
        return this.zzo;
    }

    public final zzaqy zze() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzarm zzf() {
        return this.zzr;
    }

    public final AdvertisingIdClient zzh() {
        if (!this.zzj) {
            return null;
        }
        if (this.zzi != null) {
            return this.zzi;
        }
        Future future = this.zzk;
        if (future != null) {
            try {
                future.get(2000L, TimeUnit.MILLISECONDS);
                this.zzk = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.zzk.cancel(true);
            }
        }
        return this.zzi;
    }

    public final DexClassLoader zzi() {
        return this.zzf;
    }

    public final Method zzj(String str, String str2) {
        zzatg zzatgVar = (zzatg) this.zzp.get(new Pair(str, str2));
        if (zzatgVar == null) {
            return null;
        }
        return zzatgVar.zza();
    }

    public final ExecutorService zzk() {
        return this.zze;
    }

    public final Future zzl() {
        return this.zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzo(int i4, boolean z3) {
        if (this.zzc) {
            Future<?> submit = this.zze.submit(new zzarr(this, i4, true));
            if (i4 == 0) {
                this.zzn = submit;
            }
        }
    }

    public final boolean zzp() {
        return this.zzc;
    }

    public final boolean zzq() {
        return this.zzb;
    }

    public final boolean zzr() {
        return this.zzq;
    }

    public final boolean zzs() {
        return this.zzr.zza();
    }

    public final boolean zzt(String str, String str2, Class... clsArr) {
        Pair pair = new Pair(str, str2);
        if (!this.zzp.containsKey(pair)) {
            this.zzp.put(pair, new zzatg(this, str, str2, clsArr));
            return true;
        }
        return false;
    }

    public final byte[] zzu() {
        return this.zzh;
    }
}
