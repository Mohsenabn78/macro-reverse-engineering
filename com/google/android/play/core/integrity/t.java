package com.google.android.play.core.integrity;

import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.integrity.internal.y;
import java.util.ArrayList;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
final class t {
    @Nullable
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    final com.google.android.play.integrity.internal.v f25309a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.play.integrity.internal.k f25310b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25311c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Context context, com.google.android.play.integrity.internal.k kVar) {
        this.f25311c = context.getPackageName();
        this.f25310b = kVar;
        if (!y.a(context)) {
            kVar.b("Phonesky is not installed.", new Object[0]);
            this.f25309a = null;
            return;
        }
        this.f25309a = new com.google.android.play.integrity.internal.v(context, kVar, "IntegrityService", u.f25312a, q.f25300a, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ Bundle a(t tVar, byte[] bArr, Long l4) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", tVar.f25311c);
        bundle.putByteArray("nonce", bArr);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 1);
        bundle.putInt("playcore.integrity.version.patch", 0);
        if (l4 != null) {
            bundle.putLong("cloud.prj", l4.longValue());
        }
        ArrayList<com.google.android.play.integrity.internal.e> arrayList = new ArrayList();
        arrayList.add(com.google.android.play.integrity.internal.e.c(3, System.currentTimeMillis()));
        ArrayList arrayList2 = new ArrayList();
        for (com.google.android.play.integrity.internal.e eVar : arrayList) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("event_type", 3);
            bundle2.putLong("event_timestamp", eVar.b());
            arrayList2.add(bundle2);
        }
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(arrayList2));
        return bundle;
    }

    public final Task b(IntegrityTokenRequest integrityTokenRequest) {
        if (this.f25309a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, null));
        }
        try {
            byte[] decode = Base64.decode(integrityTokenRequest.nonce(), 10);
            Long cloudProjectNumber = integrityTokenRequest.cloudProjectNumber();
            this.f25310b.d("requestIntegrityToken(%s)", integrityTokenRequest);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.f25309a.p(new r(this, taskCompletionSource, decode, cloudProjectNumber, taskCompletionSource, integrityTokenRequest), taskCompletionSource);
            return taskCompletionSource.getTask();
        } catch (IllegalArgumentException e4) {
            return Tasks.forException(new IntegrityServiceException(-13, e4));
        }
    }
}
