package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class GeoShapeBuilder extends IndexableBuilder<GeoShapeBuilder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GeoShapeBuilder() {
        super("GeoShape");
    }

    @NonNull
    @Deprecated
    public GeoShapeBuilder setBox(@NonNull String str) {
        put("box", str);
        return this;
    }

    @NonNull
    public GeoShapeBuilder setBox(@NonNull String... strArr) {
        put("box", strArr);
        return this;
    }
}
