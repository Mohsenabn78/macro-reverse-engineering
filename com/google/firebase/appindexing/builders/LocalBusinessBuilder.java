package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import com.sun.mail.imap.IMAPStore;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class LocalBusinessBuilder extends IndexableBuilder<LocalBusinessBuilder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalBusinessBuilder() {
        super("LocalBusiness");
    }

    @NonNull
    public LocalBusinessBuilder setAddress(@NonNull PostalAddressBuilder postalAddressBuilder) {
        a(IMAPStore.ID_ADDRESS, postalAddressBuilder);
        return this;
    }

    @NonNull
    public LocalBusinessBuilder setAggregateRating(@NonNull AggregateRatingBuilder aggregateRatingBuilder) {
        a("aggregateRating", aggregateRatingBuilder);
        return this;
    }

    @NonNull
    public LocalBusinessBuilder setGeo(@NonNull GeoShapeBuilder geoShapeBuilder) {
        a("geo", geoShapeBuilder);
        return this;
    }

    @NonNull
    public LocalBusinessBuilder setPriceRange(@NonNull String str) {
        put("priceRange", str);
        return this;
    }

    @NonNull
    public LocalBusinessBuilder setTelephone(@NonNull String str) {
        put("telephone", str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalBusinessBuilder(String str) {
        super("Restaurant");
    }
}
