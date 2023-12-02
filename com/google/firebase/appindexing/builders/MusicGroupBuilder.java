package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class MusicGroupBuilder extends IndexableBuilder<MusicGroupBuilder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MusicGroupBuilder() {
        super("MusicGroup");
    }

    @NonNull
    public MusicGroupBuilder setAlbum(@NonNull MusicAlbumBuilder... musicAlbumBuilderArr) {
        a("album", musicAlbumBuilderArr);
        return this;
    }

    @NonNull
    public MusicGroupBuilder setGenre(@NonNull String str) {
        put("genre", str);
        return this;
    }

    @NonNull
    public MusicGroupBuilder setTrack(@NonNull MusicRecordingBuilder... musicRecordingBuilderArr) {
        a("track", musicRecordingBuilderArr);
        return this;
    }
}
