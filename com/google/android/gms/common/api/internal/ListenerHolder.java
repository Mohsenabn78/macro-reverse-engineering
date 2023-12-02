package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public final class ListenerHolder<L> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f20074a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f20075b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private volatile ListenerKey f20076c;

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    @KeepForSdk
    /* loaded from: classes4.dex */
    public static final class ListenerKey<L> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f20077a;

        /* renamed from: b  reason: collision with root package name */
        private final String f20078b;

        /* JADX INFO: Access modifiers changed from: package-private */
        @KeepForSdk
        public ListenerKey(L l4, String str) {
            this.f20077a = l4;
            this.f20078b = str;
        }

        @KeepForSdk
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            if (this.f20077a == listenerKey.f20077a && this.f20078b.equals(listenerKey.f20078b)) {
                return true;
            }
            return false;
        }

        @KeepForSdk
        public int hashCode() {
            return (System.identityHashCode(this.f20077a) * 31) + this.f20078b.hashCode();
        }

        @NonNull
        @KeepForSdk
        public String toIdString() {
            String str = this.f20078b;
            int identityHashCode = System.identityHashCode(this.f20077a);
            return str + "@" + identityHashCode;
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    @KeepForSdk
    /* loaded from: classes4.dex */
    public interface Notifier<L> {
        @KeepForSdk
        void notifyListener(@NonNull L l4);

        @KeepForSdk
        void onNotifyListenerFailed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @KeepForSdk
    public ListenerHolder(@NonNull Looper looper, @NonNull L l4, @NonNull String str) {
        this.f20074a = new HandlerExecutor(looper);
        this.f20075b = Preconditions.checkNotNull(l4, "Listener must not be null");
        this.f20076c = new ListenerKey(l4, Preconditions.checkNotEmpty(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Notifier notifier) {
        Object obj = this.f20075b;
        if (obj == null) {
            notifier.onNotifyListenerFailed();
            return;
        }
        try {
            notifier.notifyListener(obj);
        } catch (RuntimeException e4) {
            notifier.onNotifyListenerFailed();
            throw e4;
        }
    }

    @KeepForSdk
    public void clear() {
        this.f20075b = null;
        this.f20076c = null;
    }

    @Nullable
    @KeepForSdk
    public ListenerKey<L> getListenerKey() {
        return this.f20076c;
    }

    @KeepForSdk
    public boolean hasListener() {
        if (this.f20075b != null) {
            return true;
        }
        return false;
    }

    @KeepForSdk
    public void notifyListener(@NonNull final Notifier<? super L> notifier) {
        Preconditions.checkNotNull(notifier, "Notifier must not be null");
        this.f20074a.execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.zacb
            @Override // java.lang.Runnable
            public final void run() {
                ListenerHolder.this.a(notifier);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @KeepForSdk
    public ListenerHolder(@NonNull Executor executor, @NonNull L l4, @NonNull String str) {
        this.f20074a = (Executor) Preconditions.checkNotNull(executor, "Executor must not be null");
        this.f20075b = Preconditions.checkNotNull(l4, "Listener must not be null");
        this.f20076c = new ListenerKey(l4, Preconditions.checkNotEmpty(str));
    }
}
