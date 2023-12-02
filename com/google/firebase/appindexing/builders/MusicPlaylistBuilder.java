package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public class MusicPlaylistBuilder extends IndexableBuilder<MusicPlaylistBuilder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MusicPlaylistBuilder() {
        super("MusicPlaylist");
    }

    @NonNull
    public MusicPlaylistBuilder setNumTracks(int i4) {
        return put("numTracks", i4);
    }

    @NonNull
    public MusicPlaylistBuilder setTrack(@NonNull MusicRecordingBuilder... musicRecordingBuilderArr) {
        return a("track", musicRecordingBuilderArr);
    }
}
