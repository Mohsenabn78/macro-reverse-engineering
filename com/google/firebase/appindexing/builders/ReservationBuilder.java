package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Date;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class ReservationBuilder extends IndexableBuilder<ReservationBuilder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ReservationBuilder() {
        super("Reservation");
    }

    @NonNull
    public ReservationBuilder setPartySize(@NonNull long j4) {
        put("partySize", j4);
        return this;
    }

    @NonNull
    public ReservationBuilder setReservationFor(@NonNull LocalBusinessBuilder localBusinessBuilder) {
        a("reservationFor", localBusinessBuilder);
        return this;
    }

    @NonNull
    public ReservationBuilder setStartDate(@NonNull Date date) {
        Preconditions.checkNotNull(date);
        put("startDate", date.getTime());
        return this;
    }
}
