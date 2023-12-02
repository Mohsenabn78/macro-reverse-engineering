package com.jakewharton.rxbinding2.internal;

import android.os.Looper;
import androidx.annotation.RestrictTo;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposables;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes6.dex */
public final class Preconditions {
    private Preconditions() {
        throw new AssertionError("No instances.");
    }

    public static boolean checkMainThread(Observer<?> observer) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            observer.onSubscribe(Disposables.empty());
            observer.onError(new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName()));
            return false;
        }
        return true;
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new NullPointerException(str);
    }
}
