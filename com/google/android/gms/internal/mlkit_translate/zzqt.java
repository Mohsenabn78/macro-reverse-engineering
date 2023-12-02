package com.google.android.gms.internal.mlkit_translate;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.XmlRes;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzqt {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f20867a = 0;
    @Nullable
    private static zzqt zzd;
    private final Context zze;
    private final Executor zzf;
    private final Executor zzg;
    private final zzov zzh;
    private final zzql zzi;
    @Nullable
    private volatile zzy zzj;
    @Nullable
    private volatile zzy zzk;
    @GuardedBy("defaultConfig")
    private final Map zzl = new TreeMap();
    private final zzqy zzm;
    private final zzqw zzn;
    private final zzqq zzo;
    private static final ExecutorService zzb = Executors.newSingleThreadExecutor();
    private static final ExecutorService zzc = Executors.newSingleThreadExecutor();
    public static final long zza = TimeUnit.HOURS.toSeconds(12);

    @VisibleForTesting
    zzqt(Context context, zzov zzovVar, ExecutorService executorService, ExecutorService executorService2, zzqq zzqqVar, zzqw zzqwVar, zzou zzouVar, byte[] bArr) {
        this.zze = context.getApplicationContext();
        this.zzh = zzovVar;
        this.zzf = executorService;
        this.zzg = executorService2;
        this.zzo = zzqqVar;
        this.zzn = zzqwVar;
        this.zzi = new zzql(context, zzouVar.zzb(), zzouVar.zza(), "firebase", 5L, 5L, zzqwVar);
        this.zzm = new zzqy(context);
    }

    public static synchronized zzqt zze(Context context) {
        zzqt zzqtVar;
        synchronized (zzqt.class) {
            if (zzd == null) {
                zzd = new zzqt(context, zzov.zzb(context), zzb, zzc, zzqq.zza, new zzqw(context), zzpc.zza, null);
            }
            zzqtVar = zzd;
        }
        return zzqtVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzy zzj(JSONObject jSONObject) throws JSONException {
        String string;
        zzqr zzqrVar = new zzqr(jSONObject);
        zzx zzxVar = new zzx();
        Iterator<String> keys = zzqrVar.zza.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                String string2 = jSONObject.getString(next);
                if (string2 == null) {
                    string = null;
                } else if (string2.isEmpty()) {
                    string = "";
                } else {
                    string = new JSONObject("{ \"value\": " + string2 + " }").getString("value");
                }
                zzxVar.zza(next, string);
            } catch (JSONException e4) {
                Log.e("MLKit RemoteConfigRestC", "Getting JSON string value for remote config key " + next + " failed", e4);
                throw e4;
            }
        }
        return zzxVar.zzb();
    }

    public final Task zza(final long j4) {
        final Date date = new Date(System.currentTimeMillis());
        final zzox zzoxVar = new zzox();
        zzoxVar.zzg();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzg.execute(new Runnable(date, j4, zzoxVar, true, taskCompletionSource) { // from class: com.google.android.gms.internal.mlkit_translate.zzqp
            public final /* synthetic */ Date zzb;
            public final /* synthetic */ long zzc;
            public final /* synthetic */ zzox zzd;
            public final /* synthetic */ TaskCompletionSource zze;

            {
                this.zze = taskCompletionSource;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzqt.this.zzh(this.zzb, this.zzc, this.zzd, true, this.zze);
            }
        });
        return taskCompletionSource.getTask().onSuccessTask(this.zzg, new SuccessContinuation() { // from class: com.google.android.gms.internal.mlkit_translate.zzqo
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Void r22 = (Void) obj;
                zzqt.this.zzg();
                return Tasks.forResult(null);
            }
        });
    }

    public final String zzf(@NonNull String str) {
        String str2;
        zzy zzyVar = this.zzj;
        if (zzyVar != null && zzyVar.containsKey(str)) {
            return (String) zzyVar.get(str);
        }
        synchronized (this.zzl) {
            str2 = (String) this.zzl.get(str);
        }
        return str2;
    }

    public final void zzg() {
        zzox zzoxVar = new zzox();
        zzoxVar.zzg();
        this.zzj = this.zzk;
        zzoxVar.zze();
        this.zzn.zzb(zzoxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e A[Catch: all -> 0x00b9, zzqv | InterruptedException | RuntimeException -> 0x00bb, InterruptedException -> 0x00bd, RuntimeException -> 0x00bf, TryCatch #3 {all -> 0x00b9, blocks: (B:3:0x0002, B:19:0x0065, B:20:0x006a, B:22:0x007b, B:23:0x0081, B:25:0x009b, B:28:0x00a8, B:29:0x00ad, B:13:0x003e, B:15:0x005c, B:6:0x000d, B:7:0x0011, B:8:0x0015, B:10:0x0027, B:39:0x00c0), top: B:47:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a8 A[Catch: all -> 0x00b9, zzqv | InterruptedException | RuntimeException -> 0x00bb, InterruptedException -> 0x00bd, RuntimeException -> 0x00bf, TryCatch #3 {all -> 0x00b9, blocks: (B:3:0x0002, B:19:0x0065, B:20:0x006a, B:22:0x007b, B:23:0x0081, B:25:0x009b, B:28:0x00a8, B:29:0x00ad, B:13:0x003e, B:15:0x005c, B:6:0x000d, B:7:0x0011, B:8:0x0015, B:10:0x0027, B:39:0x00c0), top: B:47:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void zzh(java.util.Date r7, long r8, com.google.android.gms.internal.mlkit_translate.zzox r10, boolean r11, com.google.android.gms.tasks.TaskCompletionSource r12) {
        /*
            r6 = this;
            java.lang.String r11 = "MLKit RemoteConfigRestC"
            com.google.android.gms.internal.mlkit_translate.zzqy r0 = r6.zzm     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            com.google.android.gms.internal.mlkit_translate.zzqk r0 = r0.zza(r10)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            r1 = 0
            if (r0 != 0) goto Ld
        Lb:
            r0 = r1
            goto L3a
        Ld:
            org.json.JSONObject r2 = r0.zzd()     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            com.google.android.gms.internal.mlkit_translate.zzy r2 = zzj(r2)     // Catch: org.json.JSONException -> L26 java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            r6.zzk = r2     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            r6.zzg()     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            r10.zzh()     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            java.util.Date r0 = r0.zzc()     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            android.util.Pair r0 = android.util.Pair.create(r2, r0)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            goto L3a
        L26:
            r0 = move-exception
            com.google.android.gms.internal.mlkit_translate.zznk r3 = com.google.android.gms.internal.mlkit_translate.zznk.FILE_READ_RETURNED_MALFORMED_DATA     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            r10.zzc(r3)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            java.lang.String r3 = "Saved remote config setting has invalid format: "
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            java.lang.String r2 = r3.concat(r2)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            android.util.Log.e(r11, r2, r0)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            goto Lb
        L3a:
            if (r0 != 0) goto L3e
        L3c:
            r2 = r1
            goto L62
        L3e:
            java.lang.Object r2 = r0.first     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            com.google.android.gms.internal.mlkit_translate.zzy r2 = (com.google.android.gms.internal.mlkit_translate.zzy) r2     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            java.lang.Object r0 = r0.second     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            java.util.Date r0 = (java.util.Date) r0     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            java.util.Date r3 = new java.util.Date     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            long r4 = r0.getTime()     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            long r8 = r0.toMillis(r8)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            long r4 = r4 + r8
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            boolean r8 = r7.after(r3)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            if (r8 == 0) goto L62
            java.lang.String r8 = "Saved remote config is past its expiration time."
            android.util.Log.i(r11, r8)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            goto L3c
        L62:
            if (r2 == 0) goto L65
            goto La6
        L65:
            com.google.android.gms.internal.mlkit_translate.zzov r8 = r6.zzh     // Catch: java.io.IOException -> L9a java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            r8.zzd()     // Catch: java.io.IOException -> L9a java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            com.google.android.gms.internal.mlkit_translate.zzov r8 = r6.zzh     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            java.lang.String r8 = r8.zzc()     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            com.google.android.gms.internal.mlkit_translate.zzqs r9 = new com.google.android.gms.internal.mlkit_translate.zzqs     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            r9.<init>(r6, r8, r7, r10)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            boolean r7 = com.google.android.gms.internal.mlkit_translate.zzrd.zza(r9)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            if (r7 != 0) goto L81
            com.google.android.gms.internal.mlkit_translate.zznk r7 = com.google.android.gms.internal.mlkit_translate.zznk.RPC_EXPONENTIAL_BACKOFF_FAILED     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            r10.zzd(r7)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            goto La5
        L81:
            com.google.android.gms.internal.mlkit_translate.zzy r2 = r9.zzb()     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            java.lang.String r7 = "writeAndSetFetchedConfig: "
            java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            r7.concat(r8)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            com.google.android.gms.internal.mlkit_translate.zzqy r7 = r6.zzm     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            com.google.android.gms.internal.mlkit_translate.zzqk r8 = r9.zzc()     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            r7.zzb(r8, r10)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            r6.zzk = r2     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            goto La6
        L9a:
            r7 = move-exception
            com.google.android.gms.internal.mlkit_translate.zznk r8 = com.google.android.gms.internal.mlkit_translate.zznk.UNKNOWN_ERROR     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            r10.zzd(r8)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
            java.lang.String r8 = "Initializing installation id failed"
            android.util.Log.e(r11, r8, r7)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
        La5:
            r2 = r1
        La6:
            if (r2 != 0) goto Lad
            java.lang.String r7 = "Remote config was null!"
            android.util.Log.e(r11, r7)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
        Lad:
            r12.setResult(r1)     // Catch: java.lang.Throwable -> Lb9 com.google.android.gms.internal.mlkit_translate.zzqv -> Lbb java.lang.InterruptedException -> Lbd java.lang.RuntimeException -> Lbf
        Lb0:
            r10.zze()
            com.google.android.gms.internal.mlkit_translate.zzqw r7 = r6.zzn
            r7.zzc(r10)
            return
        Lb9:
            r7 = move-exception
            goto Lc9
        Lbb:
            r7 = move-exception
            goto Lc0
        Lbd:
            r7 = move-exception
            goto Lc0
        Lbf:
            r7 = move-exception
        Lc0:
            java.lang.String r8 = "Fetch failed"
            android.util.Log.e(r11, r8, r7)     // Catch: java.lang.Throwable -> Lb9
            r12.setException(r7)     // Catch: java.lang.Throwable -> Lb9
            goto Lb0
        Lc9:
            r10.zze()
            com.google.android.gms.internal.mlkit_translate.zzqw r8 = r6.zzn
            r8.zzc(r10)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_translate.zzqt.zzh(java.util.Date, long, com.google.android.gms.internal.mlkit_translate.zzox, boolean, com.google.android.gms.tasks.TaskCompletionSource):void");
    }

    public final void zzi(@XmlRes int i4) {
        Map zza2 = zzqm.zza(this.zze, i4);
        synchronized (this.zzl) {
            this.zzl.putAll(zza2);
        }
    }
}
