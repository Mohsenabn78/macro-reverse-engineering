package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* loaded from: classes3.dex */
public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f17537a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17538b;

    /* renamed from: c  reason: collision with root package name */
    private DrawableCrossFadeTransition f17539c;

    /* loaded from: classes3.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final int f17540a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f17541b;

        public Builder() {
            this(300);
        }

        public DrawableCrossFadeFactory build() {
            return new DrawableCrossFadeFactory(this.f17540a, this.f17541b);
        }

        public Builder setCrossFadeEnabled(boolean z3) {
            this.f17541b = z3;
            return this;
        }

        public Builder(int i4) {
            this.f17540a = i4;
        }
    }

    protected DrawableCrossFadeFactory(int i4, boolean z3) {
        this.f17537a = i4;
        this.f17538b = z3;
    }

    private Transition<Drawable> a() {
        if (this.f17539c == null) {
            this.f17539c = new DrawableCrossFadeTransition(this.f17537a, this.f17538b);
        }
        return this.f17539c;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<Drawable> build(DataSource dataSource, boolean z3) {
        if (dataSource == DataSource.MEMORY_CACHE) {
            return NoTransition.get();
        }
        return a();
    }
}
