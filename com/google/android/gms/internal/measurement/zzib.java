package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public abstract class zzib {
    public static final /* synthetic */ int zzc = 0;
    @Nullable
    private static volatile zzhz zze = null;
    private static volatile boolean zzf = false;
    final zzhy zza;
    final String zzb;
    private final Object zzj;
    private volatile int zzk = -1;
    private volatile Object zzl;
    private static final Object zzd = new Object();
    private static final AtomicReference zzg = new AtomicReference();
    private static final zzid zzh = new zzid(new Object() { // from class: com.google.android.gms.internal.measurement.zzht
    });
    private static final AtomicInteger zzi = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzib(zzhy zzhyVar, String str, Object obj, boolean z3, zzia zziaVar) {
        if (zzhyVar.zza != null) {
            this.zza = zzhyVar;
            this.zzb = str;
            this.zzj = obj;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    public static void zzc() {
        zzi.incrementAndGet();
    }

    public static void zzd(final Context context) {
        if (zze == null && context != null) {
            Object obj = zzd;
            synchronized (obj) {
                if (zze == null) {
                    synchronized (obj) {
                        zzhz zzhzVar = zze;
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null) {
                            context = applicationContext;
                        }
                        if (zzhzVar == null || zzhzVar.zza() != context) {
                            zzhf.zze();
                            zzic.zzc();
                            zzhn.zze();
                            zze = new zzhc(context, zzir.zza(new zzim() { // from class: com.google.android.gms.internal.measurement.zzhs
                                @Override // com.google.android.gms.internal.measurement.zzim
                                public final Object zza() {
                                    Context context2 = context;
                                    int i4 = zzib.zzc;
                                    return zzho.zza(context2);
                                }
                            }));
                            zzi.incrementAndGet();
                        }
                    }
                }
            }
        }
    }

    abstract Object zza(Object obj);

    /* JADX WARN: Removed duplicated region for block: B:15:0x0040 A[Catch: all -> 0x00c5, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x0028, B:15:0x0040, B:17:0x0046, B:19:0x0050, B:23:0x0071, B:25:0x0079, B:28:0x0081, B:30:0x0087, B:34:0x0099, B:36:0x009f, B:33:0x0097, B:38:0x00a5, B:40:0x00a9, B:43:0x00b1, B:44:0x00b4, B:45:0x00b8, B:21:0x0065, B:46:0x00bd, B:47:0x00c2, B:48:0x00c3), top: B:55:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bd A[Catch: all -> 0x00c5, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x0028, B:15:0x0040, B:17:0x0046, B:19:0x0050, B:23:0x0071, B:25:0x0079, B:28:0x0081, B:30:0x0087, B:34:0x0099, B:36:0x009f, B:33:0x0097, B:38:0x00a5, B:40:0x00a9, B:43:0x00b1, B:44:0x00b4, B:45:0x00b8, B:21:0x0065, B:46:0x00bd, B:47:0x00c2, B:48:0x00c3), top: B:55:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzb() {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = com.google.android.gms.internal.measurement.zzib.zzi
            int r0 = r0.get()
            int r1 = r8.zzk
            if (r1 >= r0) goto Lc8
            monitor-enter(r8)
            int r1 = r8.zzk     // Catch: java.lang.Throwable -> Lc5
            if (r1 >= r0) goto Lc3
            com.google.android.gms.internal.measurement.zzhz r1 = com.google.android.gms.internal.measurement.zzib.zze     // Catch: java.lang.Throwable -> Lc5
            com.google.android.gms.internal.measurement.zzii r2 = com.google.android.gms.internal.measurement.zzii.zzc()     // Catch: java.lang.Throwable -> Lc5
            r3 = 0
            if (r1 == 0) goto L3b
            com.google.android.gms.internal.measurement.zzim r2 = r1.zzb()     // Catch: java.lang.Throwable -> Lc5
            java.lang.Object r2 = r2.zza()     // Catch: java.lang.Throwable -> Lc5
            com.google.android.gms.internal.measurement.zzii r2 = (com.google.android.gms.internal.measurement.zzii) r2     // Catch: java.lang.Throwable -> Lc5
            boolean r4 = r2.zzb()     // Catch: java.lang.Throwable -> Lc5
            if (r4 == 0) goto L3b
            java.lang.Object r4 = r2.zza()     // Catch: java.lang.Throwable -> Lc5
            com.google.android.gms.internal.measurement.zzhh r4 = (com.google.android.gms.internal.measurement.zzhh) r4     // Catch: java.lang.Throwable -> Lc5
            com.google.android.gms.internal.measurement.zzhy r5 = r8.zza     // Catch: java.lang.Throwable -> Lc5
            android.net.Uri r6 = r5.zza     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r5 = r5.zzc     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r7 = r8.zzb     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r4 = r4.zza(r6, r3, r5, r7)     // Catch: java.lang.Throwable -> Lc5
            goto L3c
        L3b:
            r4 = r3
        L3c:
            java.lang.String r5 = "Must call PhenotypeFlag.init() first"
            if (r1 == 0) goto Lbd
            com.google.android.gms.internal.measurement.zzhy r5 = r8.zza     // Catch: java.lang.Throwable -> Lc5
            android.net.Uri r5 = r5.zza     // Catch: java.lang.Throwable -> Lc5
            if (r5 == 0) goto L65
            android.content.Context r6 = r1.zza()     // Catch: java.lang.Throwable -> Lc5
            boolean r5 = com.google.android.gms.internal.measurement.zzhp.zza(r6, r5)     // Catch: java.lang.Throwable -> Lc5
            if (r5 == 0) goto L63
            android.content.Context r5 = r1.zza()     // Catch: java.lang.Throwable -> Lc5
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.Throwable -> Lc5
            com.google.android.gms.internal.measurement.zzhy r6 = r8.zza     // Catch: java.lang.Throwable -> Lc5
            android.net.Uri r6 = r6.zza     // Catch: java.lang.Throwable -> Lc5
            com.google.android.gms.internal.measurement.zzhr r7 = new java.lang.Runnable() { // from class: com.google.android.gms.internal.measurement.zzhr
                static {
                    /*
                        com.google.android.gms.internal.measurement.zzhr r0 = new com.google.android.gms.internal.measurement.zzhr
                        r0.<init>()
                        
                        // error: 0x0005: SPUT  (r0 I:com.google.android.gms.internal.measurement.zzhr) com.google.android.gms.internal.measurement.zzhr.zza com.google.android.gms.internal.measurement.zzhr
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhr.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhr.<init>():void");
                }

                @Override // java.lang.Runnable
                public final void run() {
                    /*
                        r0 = this;
                        com.google.android.gms.internal.measurement.zzib.zzc()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhr.run():void");
                }
            }     // Catch: java.lang.Throwable -> Lc5
            com.google.android.gms.internal.measurement.zzhf r5 = com.google.android.gms.internal.measurement.zzhf.zza(r5, r6, r7)     // Catch: java.lang.Throwable -> Lc5
            goto L6f
        L63:
            r5 = r3
            goto L6f
        L65:
            android.content.Context r5 = r1.zza()     // Catch: java.lang.Throwable -> Lc5
            com.google.android.gms.internal.measurement.zzhr r6 = com.google.android.gms.internal.measurement.zzhr.zza     // Catch: java.lang.Throwable -> Lc5
            com.google.android.gms.internal.measurement.zzic r5 = com.google.android.gms.internal.measurement.zzic.zza(r5, r3, r6)     // Catch: java.lang.Throwable -> Lc5
        L6f:
            if (r5 == 0) goto L7e
            java.lang.String r6 = r8.zzb     // Catch: java.lang.Throwable -> Lc5
            java.lang.Object r5 = r5.zzb(r6)     // Catch: java.lang.Throwable -> Lc5
            if (r5 == 0) goto L7e
            java.lang.Object r5 = r8.zza(r5)     // Catch: java.lang.Throwable -> Lc5
            goto L7f
        L7e:
            r5 = r3
        L7f:
            if (r5 != 0) goto La9
            com.google.android.gms.internal.measurement.zzhy r5 = r8.zza     // Catch: java.lang.Throwable -> Lc5
            boolean r5 = r5.zzd     // Catch: java.lang.Throwable -> Lc5
            if (r5 != 0) goto La3
            android.content.Context r1 = r1.zza()     // Catch: java.lang.Throwable -> Lc5
            com.google.android.gms.internal.measurement.zzhn r1 = com.google.android.gms.internal.measurement.zzhn.zza(r1)     // Catch: java.lang.Throwable -> Lc5
            com.google.android.gms.internal.measurement.zzhy r5 = r8.zza     // Catch: java.lang.Throwable -> Lc5
            boolean r5 = r5.zzd     // Catch: java.lang.Throwable -> Lc5
            if (r5 == 0) goto L97
            r5 = r3
            goto L99
        L97:
            java.lang.String r5 = r8.zzb     // Catch: java.lang.Throwable -> Lc5
        L99:
            java.lang.String r1 = r1.zzb(r5)     // Catch: java.lang.Throwable -> Lc5
            if (r1 == 0) goto La3
            java.lang.Object r3 = r8.zza(r1)     // Catch: java.lang.Throwable -> Lc5
        La3:
            if (r3 != 0) goto La8
            java.lang.Object r5 = r8.zzj     // Catch: java.lang.Throwable -> Lc5
            goto La9
        La8:
            r5 = r3
        La9:
            boolean r1 = r2.zzb()     // Catch: java.lang.Throwable -> Lc5
            if (r1 == 0) goto Lb8
            if (r4 != 0) goto Lb4
            java.lang.Object r5 = r8.zzj     // Catch: java.lang.Throwable -> Lc5
            goto Lb8
        Lb4:
            java.lang.Object r5 = r8.zza(r4)     // Catch: java.lang.Throwable -> Lc5
        Lb8:
            r8.zzl = r5     // Catch: java.lang.Throwable -> Lc5
            r8.zzk = r0     // Catch: java.lang.Throwable -> Lc5
            goto Lc3
        Lbd:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lc5
            r0.<init>(r5)     // Catch: java.lang.Throwable -> Lc5
            throw r0     // Catch: java.lang.Throwable -> Lc5
        Lc3:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> Lc5
            goto Lc8
        Lc5:
            r0 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> Lc5
            throw r0
        Lc8:
            java.lang.Object r0 = r8.zzl
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzib.zzb():java.lang.Object");
    }
}
