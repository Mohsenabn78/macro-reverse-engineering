package com.bumptech.glide.util.pool;

import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public abstract class StateVerifier {

    /* loaded from: classes3.dex */
    private static class b extends StateVerifier {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f17594a;

        b() {
            super();
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void a(boolean z3) {
            this.f17594a = z3;
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (!this.f17594a) {
                return;
            }
            throw new IllegalStateException("Already released");
        }
    }

    private StateVerifier() {
    }

    @NonNull
    public static StateVerifier newInstance() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(boolean z3);

    public abstract void throwIfRecycled();
}
