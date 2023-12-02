package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzash extends zzath {
    private static final zzati zzi = new zzati();
    private final Context zzj;

    public zzash(zzart zzartVar, String str, String str2, zzanq zzanqVar, int i4, int i5, Context context, zzanj zzanjVar) {
        super(zzartVar, "jrfJs+Yxsv/gGQ+cGnmY8EkHVJn84HokHsebN4IZy0eeE0ECK9wrDY7bM1U167G5", "b0nnYr5Y43sLp9uCG6eLzyBhSsauFEDPWpaZrhJ4ttc=", zzanqVar, i4, 27);
        this.zzj = context;
    }

    private final String zzc() {
        try {
            if (this.zzb.zzl() != null) {
                this.zzb.zzl().get();
            }
            zzaon zzc = this.zzb.zzc();
            if (zzc != null && zzc.zzaj()) {
                return zzc.zzh();
            }
            return null;
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzath
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        Boolean bool;
        int i4;
        boolean z3;
        String str;
        zzape zzapeVar;
        AtomicReference zza = zzi.zza(this.zzj.getPackageName());
        synchronized (zza) {
            zzape zzapeVar2 = (zzape) zza.get();
            if (zzapeVar2 == null || zzarw.zzd(zzapeVar2.zza) || zzapeVar2.zza.equals(ExifInterface.LONGITUDE_EAST) || zzapeVar2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                if (!zzarw.zzd(null)) {
                    i4 = 5;
                } else {
                    if (!zzarw.zzd(null)) {
                        bool = Boolean.FALSE;
                    } else {
                        bool = Boolean.FALSE;
                    }
                    bool.booleanValue();
                    i4 = 3;
                }
                if (i4 == 3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Boolean valueOf = Boolean.valueOf(z3);
                Boolean bool2 = (Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzce);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcd)).booleanValue()) {
                    str = zzb();
                } else {
                    str = null;
                }
                if (bool2.booleanValue() && this.zzb.zzp() && zzarw.zzd(str)) {
                    str = zzc();
                }
                zzape zzapeVar3 = new zzape((String) this.zzf.invoke(null, this.zzj, valueOf, str));
                if (zzarw.zzd(zzapeVar3.zza) || zzapeVar3.zza.equals(ExifInterface.LONGITUDE_EAST)) {
                    int i5 = i4 - 1;
                    if (i5 != 3) {
                        if (i5 == 4) {
                            throw null;
                        }
                    } else {
                        String zzc = zzc();
                        if (!zzarw.zzd(zzc)) {
                            zzapeVar3.zza = zzc;
                        }
                    }
                }
                zza.set(zzapeVar3);
            }
            zzapeVar = (zzape) zza.get();
        }
        synchronized (this.zze) {
            if (zzapeVar != null) {
                this.zze.zzx(zzapeVar.zza);
                this.zze.zzX(zzapeVar.zzb);
                this.zze.zzZ(zzapeVar.zzc);
                this.zze.zzi(zzapeVar.zzd);
                this.zze.zzw(zzapeVar.zze);
            }
        }
    }

    protected final String zzb() {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            byte[] zzf = zzarw.zzf((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcf));
            ArrayList arrayList = new ArrayList();
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(zzf)));
            if (!Build.TYPE.equals("user")) {
                arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(zzarw.zzf((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcg)))));
            }
            Context context = this.zzj;
            String packageName = context.getPackageName();
            this.zzb.zzk();
            if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals(ExifInterface.LATITUDE_SOUTH)) {
                return null;
            }
            final zzfwv zzf2 = zzfwv.zzf();
            context.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new PackageManager.OnChecksumsReadyListener() { // from class: com.google.android.gms.internal.ads.zzatj
                @Override // android.content.pm.PackageManager.OnChecksumsReadyListener
                public final void onChecksumsReady(List list) {
                    int type;
                    byte[] value;
                    zzfwv zzfwvVar = zzfwv.this;
                    if (list == null) {
                        zzfwvVar.zzd(null);
                        return;
                    }
                    try {
                        int size = list.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            ApkChecksum apkChecksum = (ApkChecksum) list.get(i4);
                            type = apkChecksum.getType();
                            if (type == 8) {
                                value = apkChecksum.getValue();
                                zzfwvVar.zzd(zzarw.zzb(value));
                                return;
                            }
                        }
                        zzfwvVar.zzd(null);
                    } catch (Throwable unused) {
                        zzfwvVar.zzd(null);
                    }
                }
            });
            return (String) zzf2.get();
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}
