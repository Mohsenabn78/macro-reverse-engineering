package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import java.util.Date;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class VideoObjectBuilder extends IndexableBuilder<VideoObjectBuilder> {
    VideoObjectBuilder() {
        super("VideoObject");
    }

    @NonNull
    public VideoObjectBuilder setAuthor(@NonNull PersonBuilder personBuilder) {
        a("author", personBuilder);
        return this;
    }

    @NonNull
    public VideoObjectBuilder setDuration(long j4) {
        put("duration", j4);
        return this;
    }

    @NonNull
    public VideoObjectBuilder setDurationWatched(long j4) {
        put("durationWatched", j4);
        return this;
    }

    @NonNull
    public VideoObjectBuilder setLocationCreated(@NonNull PlaceBuilder placeBuilder) {
        a("locationCreated", placeBuilder);
        return this;
    }

    @NonNull
    public VideoObjectBuilder setSeriesName(@NonNull String str) {
        put("seriesName", str);
        return this;
    }

    @NonNull
    public VideoObjectBuilder setUploadDate(@NonNull Date date) {
        put("uploadDate", date.getTime());
        return this;
    }
}
