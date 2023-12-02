package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfml {
    public static zzfwm zza(Task task) {
        final zzfmk zzfmkVar = new zzfmk(task);
        task.addOnCompleteListener(zzfwt.zzb(), new OnCompleteListener() { // from class: com.google.android.gms.internal.ads.zzfmj
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                zzfmk zzfmkVar2 = zzfmk.this;
                if (task2.isCanceled()) {
                    zzfmkVar2.cancel(false);
                } else if (task2.isSuccessful()) {
                    zzfmkVar2.zzd(task2.getResult());
                } else {
                    Exception exception = task2.getException();
                    if (exception != null) {
                        zzfmkVar2.zze(exception);
                        return;
                    }
                    throw new IllegalStateException();
                }
            }
        });
        return zzfmkVar;
    }
}
