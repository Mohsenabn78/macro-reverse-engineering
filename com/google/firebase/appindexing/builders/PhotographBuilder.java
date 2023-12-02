package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import java.util.Date;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class PhotographBuilder extends IndexableBuilder<PhotographBuilder> {
    PhotographBuilder() {
        super("Photograph");
    }

    @NonNull
    public PhotographBuilder setDateCreated(@NonNull Date date) {
        put("dateCreated", date.getTime());
        return this;
    }

    @NonNull
    public PhotographBuilder setLocationCreated(@NonNull PlaceBuilder placeBuilder) {
        a("locationCreated", placeBuilder);
        return this;
    }
}
