package com.bumptech.glide.request.target;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes3.dex */
public final class PreloadTarget<Z> extends SimpleTarget<Z> {

    /* renamed from: e  reason: collision with root package name */
    private static final Handler f17516e = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: d  reason: collision with root package name */
    private final RequestManager f17517d;

    /* loaded from: classes3.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((PreloadTarget) message.obj).a();
                return true;
            }
            return false;
        }
    }

    private PreloadTarget(RequestManager requestManager, int i4, int i5) {
        super(i4, i5);
        this.f17517d = requestManager;
    }

    public static <Z> PreloadTarget<Z> obtain(RequestManager requestManager, int i4, int i5) {
        return new PreloadTarget<>(requestManager, i4, i5);
    }

    void a() {
        this.f17517d.clear(this);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(@NonNull Z z3, @Nullable Transition<? super Z> transition) {
        f17516e.obtainMessage(1, this).sendToTarget();
    }
}
