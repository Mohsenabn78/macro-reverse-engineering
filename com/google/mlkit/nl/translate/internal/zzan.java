package com.google.mlkit.nl.translate.internal;

import com.google.android.gms.internal.mlkit_translate.zzkk;
import com.google.android.gms.internal.mlkit_translate.zzkw;
import com.google.android.gms.internal.mlkit_translate.zzle;
import com.google.android.gms.internal.mlkit_translate.zzlf;
import com.google.android.gms.internal.mlkit_translate.zzln;
import com.google.android.gms.internal.mlkit_translate.zzps;
import com.google.android.gms.internal.mlkit_translate.zzpx;
import com.google.android.gms.internal.mlkit_translate.zzqf;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.TranslateRemoteModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public final class zzan implements RemoteModelManagerInterface {
    public static final /* synthetic */ int zza = 0;

    /* renamed from: a  reason: collision with root package name */
    private final zzps f33101a = zzqf.zzb("translate");

    /* renamed from: b  reason: collision with root package name */
    private final zzaa f33102b;

    /* renamed from: c  reason: collision with root package name */
    private final Task f33103c;

    public zzan(zzaa zzaaVar, zzq zzqVar) {
        this.f33102b = zzaaVar;
        this.f33103c = zzqVar.getMigrationTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task a(TranslateRemoteModel translateRemoteModel, DownloadConditions downloadConditions, Task task) throws Exception {
        return this.f33102b.zza(translateRemoteModel, true).zzb(downloadConditions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Boolean b(TranslateRemoteModel translateRemoteModel, Task task) throws Exception {
        return Boolean.valueOf(this.f33102b.zza(translateRemoteModel, false).zzf());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void c(TranslateRemoteModel translateRemoteModel, Task task) throws Exception {
        this.f33102b.zza(translateRemoteModel, true).zze();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void d(Task task) {
        boolean isSuccessful = task.isSuccessful();
        zzps zzpsVar = this.f33101a;
        zzlf zzlfVar = new zzlf();
        zzkk zzkkVar = new zzkk();
        zzkkVar.zzb(zzln.BASE_TRANSLATE);
        zzkkVar.zza(Boolean.valueOf(isSuccessful));
        zzlfVar.zzf(zzkkVar.zzc());
        zzpsVar.zzd(zzpx.zzf(zzlfVar), zzle.REMOTE_MODEL_DELETE_ON_DEVICE);
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface
    public final /* bridge */ /* synthetic */ Task deleteDownloadedModel(RemoteModel remoteModel) {
        final TranslateRemoteModel translateRemoteModel = (TranslateRemoteModel) remoteModel;
        if (translateRemoteModel.getLanguage().equals("en")) {
            return Tasks.forResult(null);
        }
        return this.f33103c.continueWith(MLTaskExecutor.workerThreadExecutor(), new Continuation() { // from class: com.google.mlkit.nl.translate.internal.zzai
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                zzan.this.c(translateRemoteModel, task);
                return null;
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.mlkit.nl.translate.internal.zzaj
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                zzan.this.d(task);
            }
        });
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface
    public final /* bridge */ /* synthetic */ Task download(RemoteModel remoteModel, final DownloadConditions downloadConditions) {
        final TranslateRemoteModel translateRemoteModel = (TranslateRemoteModel) remoteModel;
        if (translateRemoteModel.getLanguage().equals("en")) {
            return Tasks.forResult(null);
        }
        return this.f33103c.continueWithTask(MLTaskExecutor.workerThreadExecutor(), new Continuation() { // from class: com.google.mlkit.nl.translate.internal.zzak
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zzan.this.a(translateRemoteModel, downloadConditions, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void e(Task task) {
        boolean booleanValue = ((Boolean) task.getResult()).booleanValue();
        zzps zzpsVar = this.f33101a;
        zzlf zzlfVar = new zzlf();
        zzkw zzkwVar = new zzkw();
        zzkwVar.zzb(zzln.BASE_TRANSLATE);
        zzkwVar.zza(Boolean.valueOf(booleanValue));
        zzlfVar.zzh(zzkwVar.zzc());
        zzpsVar.zzd(zzpx.zzf(zzlfVar), zzle.REMOTE_MODEL_IS_DOWNLOADED);
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface
    public final Task getDownloadedModels() {
        List<String> allLanguages = TranslateLanguage.getAllLanguages();
        final ArrayList arrayList = new ArrayList(allLanguages.size());
        ArrayList arrayList2 = new ArrayList(allLanguages.size());
        com.google.android.gms.internal.mlkit_translate.zzan listIterator = ((com.google.android.gms.internal.mlkit_translate.zzv) allLanguages).listIterator(0);
        while (listIterator.hasNext()) {
            TranslateRemoteModel build = new TranslateRemoteModel.Builder((String) listIterator.next()).build();
            arrayList.add(build);
            arrayList2.add(isModelDownloaded(build));
        }
        return Tasks.whenAllSuccess(arrayList2).continueWith(new Continuation() { // from class: com.google.mlkit.nl.translate.internal.zzah
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                List list = arrayList;
                List list2 = (List) task.getResult();
                HashSet hashSet = new HashSet();
                for (int i4 = 0; i4 < list2.size(); i4++) {
                    if (((Boolean) list2.get(i4)).booleanValue()) {
                        hashSet.add((TranslateRemoteModel) list.get(i4));
                    }
                }
                return hashSet;
            }
        });
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface
    /* renamed from: zza */
    public final Task isModelDownloaded(final TranslateRemoteModel translateRemoteModel) {
        if (translateRemoteModel.getLanguage().equals("en")) {
            return Tasks.forResult(Boolean.TRUE);
        }
        return this.f33103c.continueWith(MLTaskExecutor.workerThreadExecutor(), new Continuation() { // from class: com.google.mlkit.nl.translate.internal.zzal
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zzan.this.b(translateRemoteModel, task);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.mlkit.nl.translate.internal.zzam
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                zzan.this.e(task);
            }
        });
    }
}
