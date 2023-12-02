package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.thirdparty.spotify.data.SpotifyPlaybackData;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SpotifyReceiver.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class SpotifyReceiver extends BroadcastReceiver {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static SpotifyData f15363b;

    /* renamed from: a  reason: collision with root package name */
    private boolean f15364a;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: SpotifyReceiver.kt */
    /* loaded from: classes3.dex */
    public static final class BroadcastTypes {
        @NotNull
        public static final BroadcastTypes INSTANCE = new BroadcastTypes();
        @NotNull
        public static final String METADATA_CHANGED = "com.spotify.music.metadatachanged";
        @NotNull
        public static final String PLAYBACK_STATE_CHANGED = "com.spotify.music.playbackstatechanged";
        @NotNull
        public static final String QUEUE_CHANGED = "com.spotify.music.queuechanged";
        @NotNull
        public static final String SPOTIFY_PACKAGE = "com.spotify.music";

        private BroadcastTypes() {
        }
    }

    /* compiled from: SpotifyReceiver.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final SpotifyPlaybackData a(String str, String str2, String str3, String str4, int i4, boolean z3) {
        return new SpotifyPlaybackData(str, str2, str3, str4, i4, z3);
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x013f A[SYNTHETIC] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onReceive(@org.jetbrains.annotations.NotNull android.content.Context r24, @org.jetbrains.annotations.NotNull android.content.Intent r25) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.receivers.SpotifyReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
