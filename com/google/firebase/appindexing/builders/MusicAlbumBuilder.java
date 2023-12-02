package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class MusicAlbumBuilder extends IndexableBuilder<MusicAlbumBuilder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MusicAlbumBuilder() {
        super("MusicAlbum");
    }

    @NonNull
    public MusicAlbumBuilder setByArtist(@NonNull MusicGroupBuilder musicGroupBuilder) {
        a("byArtist", musicGroupBuilder);
        return this;
    }

    @NonNull
    public MusicAlbumBuilder setNumTracks(int i4) {
        put("numTracks", i4);
        return this;
    }

    @NonNull
    public MusicAlbumBuilder setTrack(@NonNull MusicRecordingBuilder... musicRecordingBuilderArr) {
        a("track", musicRecordingBuilderArr);
        return this;
    }
}
