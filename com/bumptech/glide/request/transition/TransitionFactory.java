package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;

/* loaded from: classes3.dex */
public interface TransitionFactory<R> {
    Transition<R> build(DataSource dataSource, boolean z3);
}
