package com.google.mlkit.nl.translate.internal;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.mlkit_translate.zzks;
import com.google.android.gms.internal.mlkit_translate.zzku;
import com.google.android.gms.internal.mlkit_translate.zzlc;
import com.google.android.gms.internal.mlkit_translate.zzld;
import com.google.android.gms.internal.mlkit_translate.zzle;
import com.google.android.gms.internal.mlkit_translate.zzlf;
import com.google.android.gms.internal.mlkit_translate.zzlj;
import com.google.android.gms.internal.mlkit_translate.zzne;
import com.google.android.gms.internal.mlkit_translate.zznf;
import com.google.android.gms.internal.mlkit_translate.zznx;
import com.google.android.gms.internal.mlkit_translate.zzoo;
import com.google.android.gms.internal.mlkit_translate.zzpj;
import com.google.android.gms.internal.mlkit_translate.zzps;
import com.google.android.gms.internal.mlkit_translate.zzpu;
import com.google.android.gms.internal.mlkit_translate.zzpv;
import com.google.android.gms.internal.mlkit_translate.zzpw;
import com.google.android.gms.internal.mlkit_translate.zzpx;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public final class zzt {

    /* renamed from: a  reason: collision with root package name */
    private final zzps f33136a;

    /* renamed from: b  reason: collision with root package name */
    private final zzpu f33137b;

    /* renamed from: c  reason: collision with root package name */
    private final zznx f33138c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzt(zzps zzpsVar, zzpu zzpuVar, zznx zznxVar, zzs zzsVar) {
        this.f33136a = zzpsVar;
        this.f33138c = zznxVar;
        this.f33137b = zzpuVar;
    }

    private final void a(zzne zzneVar, zzle zzleVar) {
        zzps zzpsVar = this.f33136a;
        zzlf zzlfVar = new zzlf();
        zzlfVar.zze(zzlc.TYPE_THICK);
        zzlfVar.zzj(zzneVar.zzj());
        zzpsVar.zzd(zzpx.zzf(zzlfVar), zzleVar);
    }

    private final void b(zznf zznfVar, zzle zzleVar) {
        zzne zzneVar = new zzne();
        zzneVar.zze(this.f33138c);
        zzneVar.zzg(zznfVar);
        a(zzneVar, zzleVar);
    }

    private final zzne y(zzku zzkuVar) {
        zzne zzneVar = new zzne();
        zzneVar.zze(this.f33138c);
        zzneVar.zzb(zzkuVar);
        return zzneVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(RemoteModel remoteModel, zzld zzldVar, boolean z3, ModelType modelType, zzlj zzljVar) {
        zzps zzpsVar = this.f33136a;
        zzpj zzg = zzpx.zzg();
        zzpv zzh = zzpw.zzh();
        zzh.zzf(true);
        zzh.zzd(modelType);
        zzh.zzb(zzldVar);
        zzh.zza(zzljVar);
        zzpsVar.zzf(zzg, remoteModel, zzh.zzh());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(RemoteModel remoteModel, boolean z3, int i4) {
        zzps zzpsVar = this.f33136a;
        zzpj zzg = zzpx.zzg();
        zzpv zzh = zzpw.zzh();
        zzh.zzf(true);
        zzh.zzd(remoteModel.getModelType());
        zzh.zza(zzlj.FAILED);
        zzh.zzb(zzld.DOWNLOAD_FAILED);
        zzh.zzc(i4);
        zzpsVar.zzf(zzg, remoteModel, zzh.zzh());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        b(zznf.DOWNLOAD_MANAGER_CANNOT_RESUME, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f() {
        b(zznf.DOWNLOAD_MANAGER_DEVICE_NOT_FOUND, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g() {
        b(zznf.DOWNLOAD_MANAGER_FILE_ALREADY_EXISTS, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h() {
        b(zznf.DOWNLOAD_MANAGER_FILE_ERROR, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i() {
        b(zznf.DOWNLOAD_MANAGER_HTTP_DATA_ERROR, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j(int i4) {
        zznf zzb = zznf.zzb(i4);
        if (zzb == zznf.NO_ERROR) {
            b(zznf.DOWNLOAD_MANAGER_HTTP_UNKNOWN_STATUS, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
        } else {
            b(zzb, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k() {
        b(zznf.DOWNLOAD_MANAGER_INSUFFICIENT_SPACE, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l() {
        b(zznf.DOWNLOAD_MANAGER_SERVICE_MISSING, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m() {
        b(zznf.DOWNLOAD_MANAGER_TOO_MANY_REDIRECTS, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void n() {
        b(zznf.DOWNLOAD_MANAGER_UNHANDLED_HTTP_CODE, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void o() {
        b(zznf.DOWNLOAD_MANAGER_UNKNOWN_ERROR, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void p() {
        b(zznf.NO_ERROR, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void q() {
        b(zznf.METADATA_FILE_UNAVAILABLE, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r() {
        b(zznf.METADATA_HASH_NOT_FOUND, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void s() {
        b(zznf.METADATA_JSON_INVALID, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void t() {
        b(zznf.METADATA_ENTRY_NOT_FOUND, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void u() {
        b(zznf.POST_DOWNLOAD_MOVE_FILE_FAILED, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void v() {
        b(zznf.POST_DOWNLOAD_FILE_NOT_FOUND, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void w() {
        b(zznf.POST_DOWNLOAD_UNZIP_FAILED, zzle.ON_DEVICE_TRANSLATOR_DOWNLOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void x() {
        b(zznf.RAPID_RESPONSE_COULD_NOT_BE_WRITTEN, zzle.ON_DEVICE_TRANSLATOR_LOAD);
    }

    public final void zzo(long j4, @Nullable Exception exc) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j4;
        zzoo.zzd("translate-load").zzb(elapsedRealtime);
        zzks zzksVar = new zzks();
        zzksVar.zza(Long.valueOf(elapsedRealtime));
        if (exc != null) {
            zzksVar.zzb(zzld.UNKNOWN_ERROR);
        }
        zzne y3 = y(zzksVar.zzd());
        if (exc != null && (exc.getCause() instanceof zzl)) {
            y3.zzd(Integer.valueOf(((zzl) exc.getCause()).zza()));
        }
        a(y3, zzle.ON_DEVICE_TRANSLATOR_LOAD);
    }

    public final void zzx() {
        a(y(new zzks().zzd()), zzle.ON_DEVICE_TRANSLATOR_CREATE);
    }

    public final void zzy(String str, boolean z3, long j4, Task task) {
        zzld zzldVar;
        int i4;
        zzoo.zzd("translate-inference").zzb(j4);
        if (task.isSuccessful()) {
            zzldVar = zzld.NO_ERROR;
        } else {
            zzldVar = zzld.UNKNOWN_ERROR;
        }
        zzks zzksVar = new zzks();
        zzksVar.zza(Long.valueOf(j4));
        zzksVar.zzc(Boolean.valueOf(z3));
        zzksVar.zzb(zzldVar);
        zzne y3 = y(zzksVar.zzd());
        y3.zzc(Integer.valueOf(str.length()));
        if (task.isSuccessful()) {
            i4 = ((String) task.getResult()).length();
        } else {
            i4 = -1;
        }
        y3.zzf(Integer.valueOf(i4));
        Exception exception = task.getException();
        if (exception != null) {
            if (exception.getCause() instanceof zzl) {
                y3.zzd(Integer.valueOf(((zzl) exception.getCause()).zza()));
            } else if (exception.getCause() instanceof zzn) {
                y3.zzh(Integer.valueOf(((zzn) exception.getCause()).zza()));
            }
        }
        a(y3, zzle.ON_DEVICE_TRANSLATOR_TRANSLATE);
        long currentTimeMillis = System.currentTimeMillis();
        this.f33137b.zzc(24605, zzldVar.zza(), currentTimeMillis - j4, currentTimeMillis);
    }
}
