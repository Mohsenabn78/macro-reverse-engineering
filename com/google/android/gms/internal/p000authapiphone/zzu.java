package com.google.android.gms.internal.p000authapiphone;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
/* renamed from: com.google.android.gms.internal.auth-api-phone.zzu  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzu extends SmsRetrieverClient {
    public zzu(Context context) {
        super(context);
    }

    @Override // com.google.android.gms.auth.api.phone.SmsRetrieverClient, com.google.android.gms.auth.api.phone.SmsRetrieverApi
    public final Task<Void> startSmsRetriever() {
        return doWrite(TaskApiCall.builder().run(new RemoteCall(this) { // from class: com.google.android.gms.internal.auth-api-phone.zzx
            private final zzu zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzj) ((zzv) obj).getService()).zza(new zzz(this.zza, (TaskCompletionSource) obj2));
            }
        }).setFeatures(zzaa.zzb).build());
    }

    @Override // com.google.android.gms.auth.api.phone.SmsRetrieverClient, com.google.android.gms.auth.api.phone.SmsRetrieverApi
    public final Task<Void> startSmsUserConsent(@Nullable final String str) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall(this, str) { // from class: com.google.android.gms.internal.auth-api-phone.zzw
            private final zzu zza;
            private final String zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = str;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzu zzuVar = this.zza;
                ((zzj) ((zzv) obj).getService()).zza(this.zzb, new zzy(zzuVar, (TaskCompletionSource) obj2));
            }
        }).setFeatures(zzaa.zzc).build());
    }

    public zzu(Activity activity) {
        super(activity);
    }
}
