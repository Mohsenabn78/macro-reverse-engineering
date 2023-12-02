package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.media.AudioAttributesCompat;
import androidx.media.R;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class MediaControllerCompat {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ADD_QUEUE_ITEM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ADD_QUEUE_ITEM_AT = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ARGUMENT_INDEX = "android.support.v4.media.session.command.ARGUMENT_INDEX";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_REMOVE_QUEUE_ITEM = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String COMMAND_REMOVE_QUEUE_ITEM_AT = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";

    /* renamed from: a  reason: collision with root package name */
    private final a f287a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaSessionCompat.Token f288b;
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentHashMap<Callback, Boolean> f289c = new ConcurrentHashMap<>();

    @RequiresApi(21)
    /* loaded from: classes.dex */
    static class MediaControllerImplApi21 implements a {

        /* renamed from: a  reason: collision with root package name */
        protected final MediaController f297a;

        /* renamed from: b  reason: collision with root package name */
        final Object f298b = new Object();
        @GuardedBy("mLock")

        /* renamed from: c  reason: collision with root package name */
        private final List<Callback> f299c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private HashMap<Callback, a> f300d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        protected Bundle f301e;

        /* renamed from: f  reason: collision with root package name */
        final MediaSessionCompat.Token f302f;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a  reason: collision with root package name */
            private WeakReference<MediaControllerImplApi21> f303a;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super(null);
                this.f303a = new WeakReference<>(mediaControllerImplApi21);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i4, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = this.f303a.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    synchronized (mediaControllerImplApi21.f298b) {
                        mediaControllerImplApi21.f302f.setExtraBinder(IMediaSession.Stub.asInterface(BundleCompat.getBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER)));
                        mediaControllerImplApi21.f302f.setSession2Token(ParcelUtils.getVersionedParcelable(bundle, MediaSessionCompat.KEY_SESSION2_TOKEN));
                        mediaControllerImplApi21.n();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class a extends Callback.c {
            a(Callback callback) {
                super(callback);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }
        }

        MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.f302f = token;
            this.f297a = new MediaController(context, (MediaSession.Token) token.getToken());
            if (token.getExtraBinder() == null) {
                o();
            }
        }

        @Nullable
        static MediaControllerCompat m(@NonNull Activity activity) {
            MediaController mediaController = activity.getMediaController();
            if (mediaController == null) {
                return null;
            }
            return new MediaControllerCompat(activity, MediaSessionCompat.Token.fromToken(mediaController.getSessionToken()));
        }

        private void o() {
            c(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER, null, new ExtraBinderRequestResultReceiver(this));
        }

        static void p(@NonNull Activity activity, @Nullable MediaControllerCompat mediaControllerCompat) {
            MediaController mediaController;
            if (mediaControllerCompat != null) {
                mediaController = new MediaController(activity, (MediaSession.Token) mediaControllerCompat.getSessionToken().getToken());
            } else {
                mediaController = null;
            }
            activity.setMediaController(mediaController);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public final void a(Callback callback) {
            this.f297a.unregisterCallback(callback.f290a);
            synchronized (this.f298b) {
                if (this.f302f.getExtraBinder() != null) {
                    try {
                        a remove = this.f300d.remove(callback);
                        if (remove != null) {
                            callback.f292c = null;
                            this.f302f.getExtraBinder().unregisterCallbackListener(remove);
                        }
                    } catch (RemoteException e4) {
                        Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", e4);
                    }
                } else {
                    this.f299c.remove(callback);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((getFlags() & 4) != 0) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
                c(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM, bundle, null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void b(MediaDescriptionCompat mediaDescriptionCompat, int i4) {
            if ((getFlags() & 4) != 0) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
                bundle.putInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, i4);
                c(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT, bundle, null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void c(String str, Bundle bundle, ResultReceiver resultReceiver) {
            this.f297a.sendCommand(str, bundle, resultReceiver);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public PendingIntent d() {
            return this.f297a.getSessionActivity();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void e(int i4, int i5) {
            this.f297a.setVolumeTo(i4, i5);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public boolean f() {
            if (this.f302f.getExtraBinder() != null) {
                return true;
            }
            return false;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public PlaybackInfo g() {
            MediaController.PlaybackInfo playbackInfo = this.f297a.getPlaybackInfo();
            if (playbackInfo != null) {
                return new PlaybackInfo(playbackInfo.getPlaybackType(), AudioAttributesCompat.wrap(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public Bundle getExtras() {
            return this.f297a.getExtras();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public long getFlags() {
            return this.f297a.getFlags();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public MediaMetadataCompat getMetadata() {
            MediaMetadata metadata = this.f297a.getMetadata();
            if (metadata != null) {
                return MediaMetadataCompat.fromMediaMetadata(metadata);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public String getPackageName() {
            return this.f297a.getPackageName();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public PlaybackStateCompat getPlaybackState() {
            if (this.f302f.getExtraBinder() != null) {
                try {
                    return this.f302f.getExtraBinder().getPlaybackState();
                } catch (RemoteException e4) {
                    Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e4);
                }
            }
            PlaybackState playbackState = this.f297a.getPlaybackState();
            if (playbackState != null) {
                return PlaybackStateCompat.fromPlaybackState(playbackState);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public List<MediaSessionCompat.QueueItem> getQueue() {
            List<MediaSession.QueueItem> queue = this.f297a.getQueue();
            if (queue != null) {
                return MediaSessionCompat.QueueItem.fromQueueItemList(queue);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public CharSequence getQueueTitle() {
            return this.f297a.getQueueTitle();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public int getRatingType() {
            if (Build.VERSION.SDK_INT < 22 && this.f302f.getExtraBinder() != null) {
                try {
                    return this.f302f.getExtraBinder().getRatingType();
                } catch (RemoteException e4) {
                    Log.e("MediaControllerCompat", "Dead object in getRatingType.", e4);
                }
            }
            return this.f297a.getRatingType();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public int getRepeatMode() {
            if (this.f302f.getExtraBinder() != null) {
                try {
                    return this.f302f.getExtraBinder().getRepeatMode();
                } catch (RemoteException e4) {
                    Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", e4);
                    return -1;
                }
            }
            return -1;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public Bundle getSessionInfo() {
            if (this.f301e != null) {
                return new Bundle(this.f301e);
            }
            if (this.f302f.getExtraBinder() != null) {
                try {
                    this.f301e = this.f302f.getExtraBinder().getSessionInfo();
                } catch (RemoteException e4) {
                    Log.e("MediaControllerCompat", "Dead object in getSessionInfo.", e4);
                    this.f301e = Bundle.EMPTY;
                }
            }
            Bundle unparcelWithClassLoader = MediaSessionCompat.unparcelWithClassLoader(this.f301e);
            this.f301e = unparcelWithClassLoader;
            if (unparcelWithClassLoader == null) {
                return Bundle.EMPTY;
            }
            return new Bundle(this.f301e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public int getShuffleMode() {
            if (this.f302f.getExtraBinder() != null) {
                try {
                    return this.f302f.getExtraBinder().getShuffleMode();
                } catch (RemoteException e4) {
                    Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", e4);
                    return -1;
                }
            }
            return -1;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public TransportControls h() {
            MediaController.TransportControls transportControls = this.f297a.getTransportControls();
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 29) {
                return new f(transportControls);
            }
            if (i4 >= 24) {
                return new e(transportControls);
            }
            if (i4 >= 23) {
                return new d(transportControls);
            }
            return new c(transportControls);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void i(int i4, int i5) {
            this.f297a.adjustVolume(i4, i5);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public boolean isCaptioningEnabled() {
            if (this.f302f.getExtraBinder() != null) {
                try {
                    return this.f302f.getExtraBinder().isCaptioningEnabled();
                } catch (RemoteException e4) {
                    Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", e4);
                    return false;
                }
            }
            return false;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public boolean j(KeyEvent keyEvent) {
            return this.f297a.dispatchMediaButtonEvent(keyEvent);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public Object k() {
            return this.f297a;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public final void l(Callback callback, Handler handler) {
            this.f297a.registerCallback(callback.f290a, handler);
            synchronized (this.f298b) {
                if (this.f302f.getExtraBinder() != null) {
                    a aVar = new a(callback);
                    this.f300d.put(callback, aVar);
                    callback.f292c = aVar;
                    try {
                        this.f302f.getExtraBinder().registerCallbackListener(aVar);
                        callback.a(13, null, null);
                    } catch (RemoteException e4) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e4);
                    }
                } else {
                    callback.f292c = null;
                    this.f299c.add(callback);
                }
            }
        }

        @GuardedBy("mLock")
        void n() {
            if (this.f302f.getExtraBinder() == null) {
                return;
            }
            for (Callback callback : this.f299c) {
                a aVar = new a(callback);
                this.f300d.put(callback, aVar);
                callback.f292c = aVar;
                try {
                    this.f302f.getExtraBinder().registerCallbackListener(aVar);
                    callback.a(13, null, null);
                } catch (RemoteException e4) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e4);
                }
            }
            this.f299c.clear();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((getFlags() & 4) != 0) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
                c(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM, bundle, null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }
    }

    /* loaded from: classes.dex */
    public static final class PlaybackInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;

        /* renamed from: a  reason: collision with root package name */
        private final int f304a;

        /* renamed from: b  reason: collision with root package name */
        private final AudioAttributesCompat f305b;

        /* renamed from: c  reason: collision with root package name */
        private final int f306c;

        /* renamed from: d  reason: collision with root package name */
        private final int f307d;

        /* renamed from: e  reason: collision with root package name */
        private final int f308e;

        PlaybackInfo(int i4, @NonNull AudioAttributesCompat audioAttributesCompat, int i5, int i6, int i7) {
            this.f304a = i4;
            this.f305b = audioAttributesCompat;
            this.f306c = i5;
            this.f307d = i6;
            this.f308e = i7;
        }

        @NonNull
        public AudioAttributesCompat getAudioAttributes() {
            return this.f305b;
        }

        @Deprecated
        public int getAudioStream() {
            return this.f305b.getLegacyStreamType();
        }

        public int getCurrentVolume() {
            return this.f308e;
        }

        public int getMaxVolume() {
            return this.f307d;
        }

        public int getPlaybackType() {
            return this.f304a;
        }

        public int getVolumeControl() {
            return this.f306c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(Callback callback);

        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        void b(MediaDescriptionCompat mediaDescriptionCompat, int i4);

        void c(String str, Bundle bundle, ResultReceiver resultReceiver);

        PendingIntent d();

        void e(int i4, int i5);

        boolean f();

        PlaybackInfo g();

        Bundle getExtras();

        long getFlags();

        MediaMetadataCompat getMetadata();

        String getPackageName();

        PlaybackStateCompat getPlaybackState();

        List<MediaSessionCompat.QueueItem> getQueue();

        CharSequence getQueueTitle();

        int getRatingType();

        int getRepeatMode();

        Bundle getSessionInfo();

        int getShuffleMode();

        TransportControls h();

        void i(int i4, int i5);

        boolean isCaptioningEnabled();

        boolean j(KeyEvent keyEvent);

        Object k();

        void l(Callback callback, Handler handler);

        void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat);
    }

    @RequiresApi(29)
    /* loaded from: classes.dex */
    static class b extends MediaControllerImplApi21 {
        b(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21, android.support.v4.media.session.MediaControllerCompat.a
        public Bundle getSessionInfo() {
            Bundle sessionInfo;
            if (this.f301e == null) {
                sessionInfo = this.f297a.getSessionInfo();
                this.f301e = sessionInfo;
                Bundle unparcelWithClassLoader = MediaSessionCompat.unparcelWithClassLoader(sessionInfo);
                this.f301e = unparcelWithClassLoader;
                if (unparcelWithClassLoader == null) {
                    return Bundle.EMPTY;
                }
                return new Bundle(this.f301e);
            }
            return new Bundle(this.f301e);
        }
    }

    @RequiresApi(21)
    /* loaded from: classes.dex */
    static class c extends TransportControls {

        /* renamed from: a  reason: collision with root package name */
        protected final MediaController.TransportControls f309a;

        c(MediaController.TransportControls transportControls) {
            this.f309a = transportControls;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void fastForward() {
            this.f309a.fastForward();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void pause() {
            this.f309a.pause();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void play() {
            this.f309a.play();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromMediaId(String str, Bundle bundle) {
            this.f309a.playFromMediaId(str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromSearch(String str, Bundle bundle) {
            this.f309a.playFromSearch(str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri uri, Bundle bundle) {
            if (uri != null && !Uri.EMPTY.equals(uri)) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, uri);
                bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
                sendCustomAction(MediaSessionCompat.ACTION_PLAY_FROM_URI, bundle2);
                return;
            }
            throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE, (Bundle) null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID, str);
            bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID, bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaSessionCompat.ACTION_ARGUMENT_QUERY, str);
            bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH, bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri uri, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, uri);
            bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_URI, bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            this.f309a.rewind();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long j4) {
            this.f309a.seekTo(j4);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            MediaControllerCompat.a(customAction.getAction(), bundle);
            this.f309a.sendCustomAction(customAction.getAction(), bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setCaptioningEnabled(boolean z3) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED, z3);
            sendCustomAction(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setPlaybackSpeed(float f4) {
            if (f4 != 0.0f) {
                Bundle bundle = new Bundle();
                bundle.putFloat(MediaSessionCompat.ACTION_ARGUMENT_PLAYBACK_SPEED, f4);
                sendCustomAction(MediaSessionCompat.ACTION_SET_PLAYBACK_SPEED, bundle);
                return;
            }
            throw new IllegalArgumentException("speed must not be zero");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat ratingCompat) {
            this.f309a.setRating(ratingCompat != null ? (Rating) ratingCompat.getRating() : null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRepeatMode(int i4) {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE, i4);
            sendCustomAction(MediaSessionCompat.ACTION_SET_REPEAT_MODE, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setShuffleMode(int i4) {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE, i4);
            sendCustomAction(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToNext() {
            this.f309a.skipToNext();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToPrevious() {
            this.f309a.skipToPrevious();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToQueueItem(long j4) {
            this.f309a.skipToQueueItem(j4);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void stop() {
            this.f309a.stop();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat ratingCompat, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING, ratingCompat);
            bundle2.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, bundle);
            sendCustomAction(MediaSessionCompat.ACTION_SET_RATING, bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(String str, Bundle bundle) {
            MediaControllerCompat.a(str, bundle);
            this.f309a.sendCustomAction(str, bundle);
        }
    }

    @RequiresApi(23)
    /* loaded from: classes.dex */
    static class d extends c {
        d(MediaController.TransportControls transportControls) {
            super(transportControls);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri uri, Bundle bundle) {
            this.f309a.playFromUri(uri, bundle);
        }
    }

    @RequiresApi(24)
    /* loaded from: classes.dex */
    static class e extends d {
        e(MediaController.TransportControls transportControls) {
            super(transportControls);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            this.f309a.prepare();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String str, Bundle bundle) {
            this.f309a.prepareFromMediaId(str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String str, Bundle bundle) {
            this.f309a.prepareFromSearch(str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri uri, Bundle bundle) {
            this.f309a.prepareFromUri(uri, bundle);
        }
    }

    @RequiresApi(29)
    /* loaded from: classes.dex */
    static class f extends e {
        f(MediaController.TransportControls transportControls) {
            super(transportControls);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.c, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setPlaybackSpeed(float f4) {
            if (f4 != 0.0f) {
                this.f309a.setPlaybackSpeed(f4);
                return;
            }
            throw new IllegalArgumentException("speed must not be zero");
        }
    }

    public MediaControllerCompat(Context context, @NonNull MediaSessionCompat mediaSessionCompat) {
        if (mediaSessionCompat != null) {
            MediaSessionCompat.Token sessionToken = mediaSessionCompat.getSessionToken();
            this.f288b = sessionToken;
            if (Build.VERSION.SDK_INT >= 29) {
                this.f287a = new b(context, sessionToken);
                return;
            } else {
                this.f287a = new MediaControllerImplApi21(context, sessionToken);
                return;
            }
        }
        throw new IllegalArgumentException("session must not be null");
    }

    static void a(String str, Bundle bundle) {
        if (str == null) {
            return;
        }
        if (str.equals(MediaSessionCompat.ACTION_FOLLOW) || str.equals(MediaSessionCompat.ACTION_UNFOLLOW)) {
            if (bundle != null && bundle.containsKey(MediaSessionCompat.ARGUMENT_MEDIA_ATTRIBUTE)) {
                return;
            }
            throw new IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action " + str + ".");
        }
    }

    public static MediaControllerCompat getMediaController(@NonNull Activity activity) {
        Object tag = activity.getWindow().getDecorView().getTag(R.id.media_controller_compat_view_tag);
        if (tag instanceof MediaControllerCompat) {
            return (MediaControllerCompat) tag;
        }
        return MediaControllerImplApi21.m(activity);
    }

    public static void setMediaController(@NonNull Activity activity, MediaControllerCompat mediaControllerCompat) {
        activity.getWindow().getDecorView().setTag(R.id.media_controller_compat_view_tag, mediaControllerCompat);
        MediaControllerImplApi21.p(activity, mediaControllerCompat);
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.f287a.addQueueItem(mediaDescriptionCompat);
    }

    public void adjustVolume(int i4, int i5) {
        this.f287a.i(i4, i5);
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.f287a.j(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public Bundle getExtras() {
        return this.f287a.getExtras();
    }

    public long getFlags() {
        return this.f287a.getFlags();
    }

    public MediaMetadataCompat getMetadata() {
        return this.f287a.getMetadata();
    }

    public String getPackageName() {
        return this.f287a.getPackageName();
    }

    public PlaybackInfo getPlaybackInfo() {
        return this.f287a.g();
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.f287a.getPlaybackState();
    }

    public List<MediaSessionCompat.QueueItem> getQueue() {
        return this.f287a.getQueue();
    }

    public CharSequence getQueueTitle() {
        return this.f287a.getQueueTitle();
    }

    public int getRatingType() {
        return this.f287a.getRatingType();
    }

    public int getRepeatMode() {
        return this.f287a.getRepeatMode();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public VersionedParcelable getSession2Token() {
        return this.f288b.getSession2Token();
    }

    public PendingIntent getSessionActivity() {
        return this.f287a.d();
    }

    @NonNull
    public Bundle getSessionInfo() {
        return this.f287a.getSessionInfo();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.f288b;
    }

    public int getShuffleMode() {
        return this.f287a.getShuffleMode();
    }

    public TransportControls getTransportControls() {
        return this.f287a.h();
    }

    public boolean isCaptioningEnabled() {
        return this.f287a.isCaptioningEnabled();
    }

    public boolean isSessionReady() {
        return this.f287a.f();
    }

    public void registerCallback(@NonNull Callback callback) {
        registerCallback(callback, null);
    }

    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.f287a.removeQueueItem(mediaDescriptionCompat);
    }

    @Deprecated
    public void removeQueueItemAt(int i4) {
        MediaSessionCompat.QueueItem queueItem;
        List<MediaSessionCompat.QueueItem> queue = getQueue();
        if (queue != null && i4 >= 0 && i4 < queue.size() && (queueItem = queue.get(i4)) != null) {
            removeQueueItem(queueItem.getDescription());
        }
    }

    public void sendCommand(@NonNull String str, @Nullable Bundle bundle, @Nullable ResultReceiver resultReceiver) {
        if (!TextUtils.isEmpty(str)) {
            this.f287a.c(str, bundle, resultReceiver);
            return;
        }
        throw new IllegalArgumentException("command must neither be null nor empty");
    }

    public void setVolumeTo(int i4, int i5) {
        this.f287a.e(i4, i5);
    }

    public void unregisterCallback(@NonNull Callback callback) {
        if (callback != null) {
            if (this.f289c.remove(callback) == null) {
                Log.w("MediaControllerCompat", "the callback has never been registered");
                return;
            }
            try {
                this.f287a.a(callback);
                return;
            } finally {
                callback.b(null);
            }
        }
        throw new IllegalArgumentException("callback must not be null");
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i4) {
        this.f287a.b(mediaDescriptionCompat, i4);
    }

    public void registerCallback(@NonNull Callback callback, Handler handler) {
        if (callback != null) {
            if (this.f289c.putIfAbsent(callback, Boolean.TRUE) != null) {
                Log.w("MediaControllerCompat", "the callback has already been registered");
                return;
            }
            if (handler == null) {
                handler = new Handler();
            }
            callback.b(handler);
            this.f287a.l(callback, handler);
            return;
        }
        throw new IllegalArgumentException("callback must not be null");
    }

    public Object getMediaController() {
        return this.f287a.k();
    }

    public MediaControllerCompat(Context context, @NonNull MediaSessionCompat.Token token) {
        if (token != null) {
            this.f288b = token;
            this.f287a = new MediaControllerImplApi21(context, token);
            return;
        }
        throw new IllegalArgumentException("sessionToken must not be null");
    }

    /* loaded from: classes.dex */
    public static abstract class Callback implements IBinder.DeathRecipient {

        /* renamed from: a  reason: collision with root package name */
        final MediaController.Callback f290a = new a(this);

        /* renamed from: b  reason: collision with root package name */
        b f291b;

        /* renamed from: c  reason: collision with root package name */
        IMediaControllerCallback f292c;

        @RequiresApi(21)
        /* loaded from: classes.dex */
        private static class a extends MediaController.Callback {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<Callback> f293a;

            a(Callback callback) {
                this.f293a = new WeakReference<>(callback);
            }

            @Override // android.media.session.MediaController.Callback
            public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
                Callback callback = this.f293a.get();
                if (callback != null) {
                    callback.onAudioInfoChanged(new PlaybackInfo(playbackInfo.getPlaybackType(), AudioAttributesCompat.wrap(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume()));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onExtrasChanged(Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                Callback callback = this.f293a.get();
                if (callback != null) {
                    callback.onExtrasChanged(bundle);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onMetadataChanged(MediaMetadata mediaMetadata) {
                Callback callback = this.f293a.get();
                if (callback != null) {
                    callback.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(mediaMetadata));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onPlaybackStateChanged(PlaybackState playbackState) {
                Callback callback = this.f293a.get();
                if (callback != null && callback.f292c == null) {
                    callback.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(playbackState));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueChanged(List<MediaSession.QueueItem> list) {
                Callback callback = this.f293a.get();
                if (callback != null) {
                    callback.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(list));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueTitleChanged(CharSequence charSequence) {
                Callback callback = this.f293a.get();
                if (callback != null) {
                    callback.onQueueTitleChanged(charSequence);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionDestroyed() {
                Callback callback = this.f293a.get();
                if (callback != null) {
                    callback.onSessionDestroyed();
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionEvent(String str, Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                Callback callback = this.f293a.get();
                if (callback != null) {
                    if (callback.f292c == null || Build.VERSION.SDK_INT >= 23) {
                        callback.onSessionEvent(str, bundle);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class b extends Handler {

            /* renamed from: a  reason: collision with root package name */
            boolean f294a;

            b(Looper looper) {
                super(looper);
                this.f294a = false;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (!this.f294a) {
                    return;
                }
                switch (message.what) {
                    case 1:
                        Bundle data = message.getData();
                        MediaSessionCompat.ensureClassLoader(data);
                        Callback.this.onSessionEvent((String) message.obj, data);
                        return;
                    case 2:
                        Callback.this.onPlaybackStateChanged((PlaybackStateCompat) message.obj);
                        return;
                    case 3:
                        Callback.this.onMetadataChanged((MediaMetadataCompat) message.obj);
                        return;
                    case 4:
                        Callback.this.onAudioInfoChanged((PlaybackInfo) message.obj);
                        return;
                    case 5:
                        Callback.this.onQueueChanged((List) message.obj);
                        return;
                    case 6:
                        Callback.this.onQueueTitleChanged((CharSequence) message.obj);
                        return;
                    case 7:
                        Bundle bundle = (Bundle) message.obj;
                        MediaSessionCompat.ensureClassLoader(bundle);
                        Callback.this.onExtrasChanged(bundle);
                        return;
                    case 8:
                        Callback.this.onSessionDestroyed();
                        return;
                    case 9:
                        Callback.this.onRepeatModeChanged(((Integer) message.obj).intValue());
                        return;
                    case 10:
                    default:
                        return;
                    case 11:
                        Callback.this.onCaptioningEnabledChanged(((Boolean) message.obj).booleanValue());
                        return;
                    case 12:
                        Callback.this.onShuffleModeChanged(((Integer) message.obj).intValue());
                        return;
                    case 13:
                        Callback.this.onSessionReady();
                        return;
                }
            }
        }

        void a(int i4, Object obj, Bundle bundle) {
            b bVar = this.f291b;
            if (bVar != null) {
                Message obtainMessage = bVar.obtainMessage(i4, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        void b(Handler handler) {
            if (handler == null) {
                b bVar = this.f291b;
                if (bVar != null) {
                    bVar.f294a = false;
                    bVar.removeCallbacksAndMessages(null);
                    this.f291b = null;
                    return;
                }
                return;
            }
            b bVar2 = new b(handler.getLooper());
            this.f291b = bVar2;
            bVar2.f294a = true;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            a(8, null, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public IMediaControllerCallback getIControllerCallback() {
            return this.f292c;
        }

        public void onSessionDestroyed() {
        }

        public void onSessionReady() {
        }

        /* loaded from: classes.dex */
        private static class c extends IMediaControllerCallback.Stub {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<Callback> f296a;

            c(Callback callback) {
                this.f296a = new WeakReference<>(callback);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean z3) throws RemoteException {
                Callback callback = this.f296a.get();
                if (callback != null) {
                    callback.a(11, Boolean.valueOf(z3), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String str, Bundle bundle) throws RemoteException {
                Callback callback = this.f296a.get();
                if (callback != null) {
                    callback.a(1, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Callback callback = this.f296a.get();
                if (callback != null) {
                    callback.a(2, playbackStateCompat, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int i4) throws RemoteException {
                Callback callback = this.f296a.get();
                if (callback != null) {
                    callback.a(9, Integer.valueOf(i4), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() throws RemoteException {
                Callback callback = this.f296a.get();
                if (callback != null) {
                    callback.a(13, null, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int i4) throws RemoteException {
                Callback callback = this.f296a.get();
                if (callback != null) {
                    callback.a(12, Integer.valueOf(i4), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean z3) throws RemoteException {
            }
        }

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
        }

        public void onCaptioningEnabledChanged(boolean z3) {
        }

        public void onExtrasChanged(Bundle bundle) {
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
        }

        public void onRepeatModeChanged(int i4) {
        }

        public void onShuffleModeChanged(int i4) {
        }

        public void onSessionEvent(String str, Bundle bundle) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class TransportControls {
        @Deprecated
        public static final String EXTRA_LEGACY_STREAM_TYPE = "android.media.session.extra.LEGACY_STREAM_TYPE";

        TransportControls() {
        }

        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(String str, Bundle bundle);

        public abstract void playFromSearch(String str, Bundle bundle);

        public abstract void playFromUri(Uri uri, Bundle bundle);

        public abstract void prepare();

        public abstract void prepareFromMediaId(String str, Bundle bundle);

        public abstract void prepareFromSearch(String str, Bundle bundle);

        public abstract void prepareFromUri(Uri uri, Bundle bundle);

        public abstract void rewind();

        public abstract void seekTo(long j4);

        public abstract void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle);

        public abstract void sendCustomAction(String str, Bundle bundle);

        public abstract void setCaptioningEnabled(boolean z3);

        public abstract void setRating(RatingCompat ratingCompat);

        public abstract void setRating(RatingCompat ratingCompat, Bundle bundle);

        public abstract void setRepeatMode(int i4);

        public abstract void setShuffleMode(int i4);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long j4);

        public abstract void stop();

        public void setPlaybackSpeed(float f4) {
        }
    }
}
