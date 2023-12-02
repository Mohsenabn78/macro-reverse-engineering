package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzek extends zzf {

    /* renamed from: c  reason: collision with root package name */
    private String f21504c;

    /* renamed from: d  reason: collision with root package name */
    private String f21505d;

    /* renamed from: e  reason: collision with root package name */
    private int f21506e;

    /* renamed from: f  reason: collision with root package name */
    private String f21507f;

    /* renamed from: g  reason: collision with root package name */
    private String f21508g;

    /* renamed from: h  reason: collision with root package name */
    private long f21509h;

    /* renamed from: i  reason: collision with root package name */
    private final long f21510i;

    /* renamed from: j  reason: collision with root package name */
    private List f21511j;

    /* renamed from: k  reason: collision with root package name */
    private String f21512k;

    /* renamed from: l  reason: collision with root package name */
    private int f21513l;

    /* renamed from: m  reason: collision with root package name */
    private String f21514m;

    /* renamed from: n  reason: collision with root package name */
    private String f21515n;

    /* renamed from: o  reason: collision with root package name */
    private String f21516o;

    /* renamed from: p  reason: collision with root package name */
    private long f21517p;

    /* renamed from: q  reason: collision with root package name */
    private String f21518q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzek(zzgd zzgdVar, long j4) {
        super(zzgdVar);
        this.f21517p = 0L;
        this.f21518q = null;
        this.f21510i = j4;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:1|(1:3)(6:65|66|(1:68)(2:83|(1:85))|69|70|(20:72|(1:74)(1:81)|76|77|5|(1:64)(1:9)|10|11|13|(1:15)|16|17|(1:19)(1:53)|20|(3:22|(1:24)(1:26)|25)|(3:28|(1:30)(1:33)|31)|34|(3:36|(1:38)(3:45|(3:48|(1:50)|46)|51)|(2:40|41)(2:43|44))|52|(0)(0)))|4|5|(1:7)|64|10|11|13|(0)|16|17|(0)(0)|20|(0)|(0)|34|(0)|52|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01db, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01dc, code lost:
        r11.f21734a.zzaA().zzd().zzc("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzet.f(r0), r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0194 A[Catch: IllegalStateException -> 0x01db, TryCatch #3 {IllegalStateException -> 0x01db, blocks: (B:46:0x0172, B:50:0x018c, B:52:0x0194, B:56:0x01b2, B:55:0x01ae, B:58:0x01bc, B:60:0x01d2, B:62:0x01d7, B:61:0x01d5), top: B:90:0x0172 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01bc A[Catch: IllegalStateException -> 0x01db, TryCatch #3 {IllegalStateException -> 0x01db, blocks: (B:46:0x0172, B:50:0x018c, B:52:0x0194, B:56:0x01b2, B:55:0x01ae, B:58:0x01bc, B:60:0x01d2, B:62:0x01d7, B:61:0x01d5), top: B:90:0x0172 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x024c  */
    @Override // com.google.android.gms.measurement.internal.zzf
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({com.google.firebase.remoteconfig.RemoteConfigConstants.RequestFieldKey.APP_ID, "appStore", "appName", "gmpAppId", "gaAppId"})
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void a() {
        /*
            Method dump skipped, instructions count: 612
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzek.a():void");
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean c() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final int d() {
        zza();
        return this.f21513l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final int e() {
        zza();
        return this.f21506e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02cb  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzq f(java.lang.String r41) {
        /*
            Method dump skipped, instructions count: 767
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzek.f(java.lang.String):com.google.android.gms.measurement.internal.zzq");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final String g() {
        zza();
        return this.f21515n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final List h() {
        return this.f21511j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void i() {
        String format;
        String str;
        zzg();
        if (!this.f21734a.zzm().f().zzj(zzha.ANALYTICS_STORAGE)) {
            this.f21734a.zzaA().zzc().zza("Analytics Storage consent is not granted");
            format = null;
        } else {
            byte[] bArr = new byte[16];
            this.f21734a.zzv().h().nextBytes(bArr);
            format = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        zzer zzc = this.f21734a.zzaA().zzc();
        Object[] objArr = new Object[1];
        if (format == null) {
            str = "null";
        } else {
            str = "not null";
        }
        objArr[0] = str;
        zzc.zza(String.format("Resetting session stitching token to %s", objArr));
        this.f21516o = format;
        this.f21517p = this.f21734a.zzax().currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean j(String str) {
        String str2 = this.f21518q;
        boolean z3 = false;
        if (str2 != null && !str2.equals(str)) {
            z3 = true;
        }
        this.f21518q = str;
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final String zzl() {
        zza();
        Preconditions.checkNotNull(this.f21504c);
        return this.f21504c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final String zzm() {
        zzg();
        zza();
        Preconditions.checkNotNull(this.f21514m);
        return this.f21514m;
    }
}
