package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class PlaceBuilder extends IndexableBuilder<PlaceBuilder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PlaceBuilder() {
        super("Place");
    }

    @NonNull
    public PlaceBuilder setGeo(@NonNull GeoShapeBuilder geoShapeBuilder) {
        a("geo", geoShapeBuilder);
        return this;
    }
}
