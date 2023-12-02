package com.google.firebase.appindexing.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.appindexing.FirebaseAppIndex;
import com.google.firebase.appindexing.FirebaseAppIndexingInvalidArgumentException;
import com.google.firebase.appindexing.Indexable;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class zzp extends FirebaseAppIndex {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final GoogleApi<?> f28834b;
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    final zzo f28835c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Context f28836d;

    public zzp(@NonNull Context context) {
        zzj zzjVar = new zzj(context);
        this.f28834b = zzjVar;
        this.f28836d = context;
        this.f28835c = new zzo(zzjVar);
    }

    @Override // com.google.firebase.appindexing.FirebaseAppIndex
    public final Task<Void> remove(String... strArr) {
        return this.f28835c.a(new zzz(3, null, strArr, null, null, null, null));
    }

    @Override // com.google.firebase.appindexing.FirebaseAppIndex
    public final Task<Void> removeAll() {
        return this.f28835c.a(new zzz(4, null, null, null, null, null, null));
    }

    @Override // com.google.firebase.appindexing.FirebaseAppIndex
    public final Task<Void> update(Indexable... indexableArr) {
        Thing[] thingArr;
        if (indexableArr == null) {
            thingArr = null;
        } else {
            try {
                int length = indexableArr.length;
                Thing[] thingArr2 = new Thing[length];
                System.arraycopy(indexableArr, 0, thingArr2, 0, length);
                thingArr = thingArr2;
            } catch (ArrayStoreException unused) {
                return Tasks.forException(new FirebaseAppIndexingInvalidArgumentException("Custom Indexable-objects are not allowed. Please use the 'Indexables'-class for creating the objects."));
            }
        }
        if (thingArr == null) {
            return Tasks.forException(new FirebaseAppIndexingInvalidArgumentException("Indexables cannot be null."));
        }
        return this.f28835c.a(new zzz(1, thingArr, null, null, null, null, null));
    }
}
