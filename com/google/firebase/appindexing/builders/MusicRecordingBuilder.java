package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class MusicRecordingBuilder extends IndexableBuilder<MusicRecordingBuilder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MusicRecordingBuilder() {
        super("MusicRecording");
    }

    @NonNull
    public MusicRecordingBuilder setByArtist(@NonNull MusicGroupBuilder musicGroupBuilder) {
        a("byArtist", musicGroupBuilder);
        return this;
    }

    @NonNull
    public MusicRecordingBuilder setDuration(int i4) {
        put("duration", i4);
        return this;
    }

    @NonNull
    public MusicRecordingBuilder setInAlbum(@NonNull MusicAlbumBuilder musicAlbumBuilder) {
        a("inAlbum", musicAlbumBuilder);
        return this;
    }

    @NonNull
    public MusicRecordingBuilder setInPlaylist(@NonNull MusicPlaylistBuilder... musicPlaylistBuilderArr) {
        a("inPlaylist", musicPlaylistBuilderArr);
        return this;
    }
}
