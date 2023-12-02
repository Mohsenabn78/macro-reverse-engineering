package com.google.firebase.auth.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
final class zzad implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzae f28968a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(zzae zzaeVar) {
        this.f28968a = zzaeVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* bridge */ /* synthetic */ Object then(@NonNull Task task) throws Exception {
        com.google.firebase.auth.zze zzeVar;
        com.google.firebase.auth.zze zzeVar2;
        com.google.firebase.auth.zze zzeVar3;
        zzeVar = this.f28968a.f28972d;
        if (zzeVar != null) {
            if (task.isSuccessful()) {
                AuthResult authResult = (AuthResult) task.getResult();
                zzeVar3 = this.f28968a.f28972d;
                return Tasks.forResult(new zzr((zzx) authResult.getUser(), (zzp) authResult.getAdditionalUserInfo(), zzeVar3));
            }
            Exception exception = task.getException();
            if (exception instanceof FirebaseAuthUserCollisionException) {
                zzeVar2 = this.f28968a.f28972d;
                ((FirebaseAuthUserCollisionException) exception).zza(zzeVar2);
            }
            return Tasks.forException(exception);
        }
        return task;
    }
}
