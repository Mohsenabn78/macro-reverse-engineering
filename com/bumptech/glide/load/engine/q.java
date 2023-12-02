package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ResourceRecycler.java */
/* loaded from: classes3.dex */
class q {

    /* renamed from: a  reason: collision with root package name */
    private boolean f17107a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f17108b = new Handler(Looper.getMainLooper(), new a());

    /* compiled from: ResourceRecycler.java */
    /* loaded from: classes3.dex */
    private static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((Resource) message.obj).recycle();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(Resource<?> resource) {
        if (this.f17107a) {
            this.f17108b.obtainMessage(1, resource).sendToTarget();
        } else {
            this.f17107a = true;
            resource.recycle();
            this.f17107a = false;
        }
    }
}
