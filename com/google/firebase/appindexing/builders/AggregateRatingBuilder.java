package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class AggregateRatingBuilder extends IndexableBuilder<AggregateRatingBuilder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AggregateRatingBuilder() {
        super("AggregateRating");
    }

    @NonNull
    public AggregateRatingBuilder setRatingCount(@NonNull long j4) {
        put("ratingCount", j4);
        return this;
    }

    @NonNull
    public AggregateRatingBuilder setRatingValue(@NonNull String str) {
        put("ratingValue", str);
        return this;
    }
}
