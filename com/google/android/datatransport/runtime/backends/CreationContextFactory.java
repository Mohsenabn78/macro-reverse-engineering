package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import javax.inject.Inject;

/* loaded from: classes.dex */
class CreationContextFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Context f18707a;

    /* renamed from: b  reason: collision with root package name */
    private final Clock f18708b;

    /* renamed from: c  reason: collision with root package name */
    private final Clock f18709c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public CreationContextFactory(Context context, @WallTime Clock clock, @Monotonic Clock clock2) {
        this.f18707a = context;
        this.f18708b = clock;
        this.f18709c = clock2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CreationContext a(String str) {
        return CreationContext.create(this.f18707a, this.f18708b, this.f18709c, str);
    }
}
