package com.pollfish.internal;

import android.widget.ImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class d3 extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f36760a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d3(ImageView imageView) {
        super(0);
        this.f36760a = imageView;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        this.f36760a.setVisibility(8);
        return Unit.INSTANCE;
    }
}
