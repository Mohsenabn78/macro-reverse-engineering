package com.google.firebase.appindexing;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.appindexing.internal.zzt;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public abstract class FirebaseUserActions {
    @NonNull
    public static final String APP_INDEXING_API_TAG = "FirebaseUserActions";
    @GuardedBy("FirebaseUserActions.class")

    /* renamed from: a  reason: collision with root package name */
    private static WeakReference<FirebaseUserActions> f28786a;

    @NonNull
    public static synchronized FirebaseUserActions getInstance(@NonNull Context context) {
        FirebaseUserActions firebaseUserActions;
        synchronized (FirebaseUserActions.class) {
            Preconditions.checkNotNull(context);
            WeakReference<FirebaseUserActions> weakReference = f28786a;
            if (weakReference == null) {
                firebaseUserActions = null;
            } else {
                firebaseUserActions = weakReference.get();
            }
            if (firebaseUserActions == null) {
                zzt zztVar = new zzt(context.getApplicationContext());
                f28786a = new WeakReference<>(zztVar);
                return zztVar;
            }
            return firebaseUserActions;
        }
    }

    @NonNull
    public abstract Task<Void> end(@NonNull Action action);

    @NonNull
    public abstract Task<Void> start(@NonNull Action action);
}
