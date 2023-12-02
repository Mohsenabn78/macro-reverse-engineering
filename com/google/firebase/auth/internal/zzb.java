package com.google.firebase.auth.internal;

import android.util.Base64;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.p002firebaseauthapi.zzadq;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityTokenRequest;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzb implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f29015a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ IntegrityManager f29016b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzf f29017c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(zzf zzfVar, String str, IntegrityManager integrityManager) {
        this.f29017c = zzfVar;
        this.f29015a = str;
        this.f29016b = integrityManager;
    }

    @Override // com.google.android.gms.tasks.Continuation
    @Nullable
    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        String str;
        if (!task.isSuccessful()) {
            str = zzf.f29062b;
            Log.e(str, "Problem retrieving Play Integrity producer project:  ".concat(String.valueOf(task.getException().getMessage())));
            return Tasks.forException(task.getException());
        }
        this.f29017c.f29064a = ((zzadq) task.getResult()).zzb();
        return this.f29016b.requestIntegrityToken(IntegrityTokenRequest.builder().setCloudProjectNumber(Long.parseLong(((zzadq) task.getResult()).zzb())).setNonce(new String(Base64.encode(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256).digest(this.f29015a.getBytes("UTF-8")), 11))).build());
    }
}
