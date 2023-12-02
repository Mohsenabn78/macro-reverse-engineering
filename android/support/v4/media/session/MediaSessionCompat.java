package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.core.os.BuildCompat;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import androidx.media.session.MediaButtonReceiver;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class MediaSessionCompat {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_PLAYBACK_SPEED = "android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_PLAYBACK_SPEED = "android.support.v4.media.session.action.SET_PLAYBACK_SPEED";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    @Deprecated
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    @Deprecated
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_SESSION2_TOKEN = "android.support.v4.media.session.SESSION_TOKEN2";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int PENDING_INTENT_FLAG_MUTABLE;

    /* renamed from: d  reason: collision with root package name */
    static int f310d;

    /* renamed from: a  reason: collision with root package name */
    private final b f311a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaControllerCompat f312b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<OnActiveChangeListener> f313c;

    /* loaded from: classes.dex */
    public static abstract class Callback {

        /* renamed from: c  reason: collision with root package name */
        private boolean f316c;
        @GuardedBy("mLock")

        /* renamed from: e  reason: collision with root package name */
        a f318e;

        /* renamed from: a  reason: collision with root package name */
        final Object f314a = new Object();

        /* renamed from: b  reason: collision with root package name */
        final MediaSession.Callback f315b = new b();
        @GuardedBy("mLock")

        /* renamed from: d  reason: collision with root package name */
        WeakReference<b> f317d = new WeakReference<>(null);

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class a extends Handler {
            a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                b bVar;
                Callback callback;
                a aVar;
                if (message.what == 1) {
                    synchronized (Callback.this.f314a) {
                        bVar = Callback.this.f317d.get();
                        callback = Callback.this;
                        aVar = callback.f318e;
                    }
                    if (bVar != null && callback == bVar.q() && aVar != null) {
                        bVar.k((MediaSessionManager.RemoteUserInfo) message.obj);
                        Callback.this.a(bVar, aVar);
                        bVar.k(null);
                    }
                }
            }
        }

        @RequiresApi(21)
        /* loaded from: classes.dex */
        private class b extends MediaSession.Callback {
            b() {
            }

            private void a(b bVar) {
                bVar.k(null);
            }

            private c b() {
                c cVar;
                synchronized (Callback.this.f314a) {
                    cVar = (c) Callback.this.f317d.get();
                }
                if (cVar == null || Callback.this != cVar.q()) {
                    return null;
                }
                return cVar;
            }

            private void c(b bVar) {
                if (Build.VERSION.SDK_INT >= 28) {
                    return;
                }
                String f4 = bVar.f();
                if (TextUtils.isEmpty(f4)) {
                    f4 = MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER;
                }
                bVar.k(new MediaSessionManager.RemoteUserInfo(f4, -1, -1));
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                c(b4);
                try {
                    QueueItem queueItem = null;
                    IBinder asBinder = null;
                    queueItem = null;
                    if (str.equals(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER)) {
                        Bundle bundle2 = new Bundle();
                        Token a4 = b4.a();
                        IMediaSession extraBinder = a4.getExtraBinder();
                        if (extraBinder != null) {
                            asBinder = extraBinder.asBinder();
                        }
                        BundleCompat.putBinder(bundle2, MediaSessionCompat.KEY_EXTRA_BINDER, asBinder);
                        ParcelUtils.putVersionedParcelable(bundle2, MediaSessionCompat.KEY_SESSION2_TOKEN, a4.getSession2Token());
                        resultReceiver.send(0, bundle2);
                    } else if (str.equals(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM)) {
                        Callback.this.onAddQueueItem((MediaDescriptionCompat) bundle.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));
                    } else if (str.equals(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT)) {
                        Callback.this.onAddQueueItem((MediaDescriptionCompat) bundle.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION), bundle.getInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX));
                    } else if (str.equals(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM)) {
                        Callback.this.onRemoveQueueItem((MediaDescriptionCompat) bundle.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));
                    } else if (str.equals(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM_AT)) {
                        if (b4.f337h != null) {
                            int i4 = bundle.getInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, -1);
                            if (i4 >= 0 && i4 < b4.f337h.size()) {
                                queueItem = b4.f337h.get(i4);
                            }
                            if (queueItem != null) {
                                Callback.this.onRemoveQueueItem(queueItem.getDescription());
                            }
                        }
                    } else {
                        Callback.this.onCommand(str, bundle, resultReceiver);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
                }
                a(b4);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCustomAction(String str, Bundle bundle) {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                c(b4);
                try {
                    if (str.equals(MediaSessionCompat.ACTION_PLAY_FROM_URI)) {
                        Bundle bundle2 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                        MediaSessionCompat.ensureClassLoader(bundle2);
                        Callback.this.onPlayFromUri((Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI), bundle2);
                    } else if (str.equals(MediaSessionCompat.ACTION_PREPARE)) {
                        Callback.this.onPrepare();
                    } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
                        String string = bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID);
                        Bundle bundle3 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                        MediaSessionCompat.ensureClassLoader(bundle3);
                        Callback.this.onPrepareFromMediaId(string, bundle3);
                    } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH)) {
                        String string2 = bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_QUERY);
                        Bundle bundle4 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                        MediaSessionCompat.ensureClassLoader(bundle4);
                        Callback.this.onPrepareFromSearch(string2, bundle4);
                    } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_URI)) {
                        Bundle bundle5 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                        MediaSessionCompat.ensureClassLoader(bundle5);
                        Callback.this.onPrepareFromUri((Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI), bundle5);
                    } else if (str.equals(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                        Callback.this.onSetCaptioningEnabled(bundle.getBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED));
                    } else if (str.equals(MediaSessionCompat.ACTION_SET_REPEAT_MODE)) {
                        Callback.this.onSetRepeatMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE));
                    } else if (str.equals(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE)) {
                        Callback.this.onSetShuffleMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE));
                    } else if (str.equals(MediaSessionCompat.ACTION_SET_RATING)) {
                        Bundle bundle6 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                        MediaSessionCompat.ensureClassLoader(bundle6);
                        Callback.this.onSetRating((RatingCompat) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING), bundle6);
                    } else if (str.equals(MediaSessionCompat.ACTION_SET_PLAYBACK_SPEED)) {
                        Callback.this.onSetPlaybackSpeed(bundle.getFloat(MediaSessionCompat.ACTION_ARGUMENT_PLAYBACK_SPEED, 1.0f));
                    } else {
                        Callback.this.onCustomAction(str, bundle);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaSessionCompat", "Could not unparcel the data.");
                }
                a(b4);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onFastForward() {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                c(b4);
                Callback.this.onFastForward();
                a(b4);
            }

            @Override // android.media.session.MediaSession.Callback
            public boolean onMediaButtonEvent(Intent intent) {
                c b4 = b();
                if (b4 == null) {
                    return false;
                }
                c(b4);
                boolean onMediaButtonEvent = Callback.this.onMediaButtonEvent(intent);
                a(b4);
                if (!onMediaButtonEvent && !super.onMediaButtonEvent(intent)) {
                    return false;
                }
                return true;
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPause() {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                c(b4);
                Callback.this.onPause();
                a(b4);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlay() {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                c(b4);
                Callback.this.onPlay();
                a(b4);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromMediaId(String str, Bundle bundle) {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                c(b4);
                Callback.this.onPlayFromMediaId(str, bundle);
                a(b4);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromSearch(String str, Bundle bundle) {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                c(b4);
                Callback.this.onPlayFromSearch(str, bundle);
                a(b4);
            }

            @Override // android.media.session.MediaSession.Callback
            @RequiresApi(23)
            public void onPlayFromUri(Uri uri, Bundle bundle) {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                c(b4);
                Callback.this.onPlayFromUri(uri, bundle);
                a(b4);
            }

            @Override // android.media.session.MediaSession.Callback
            @RequiresApi(24)
            public void onPrepare() {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                c(b4);
                Callback.this.onPrepare();
                a(b4);
            }

            @Override // android.media.session.MediaSession.Callback
            @RequiresApi(24)
            public void onPrepareFromMediaId(String str, Bundle bundle) {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                c(b4);
                Callback.this.onPrepareFromMediaId(str, bundle);
                a(b4);
            }

            @Override // android.media.session.MediaSession.Callback
            @RequiresApi(24)
            public void onPrepareFromSearch(String str, Bundle bundle) {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                c(b4);
                Callback.this.onPrepareFromSearch(str, bundle);
                a(b4);
            }

            @Override // android.media.session.MediaSession.Callback
            @RequiresApi(24)
            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                c(b4);
                Callback.this.onPrepareFromUri(uri, bundle);
                a(b4);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onRewind() {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                c(b4);
                Callback.this.onRewind();
                a(b4);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSeekTo(long j4) {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                c(b4);
                Callback.this.onSeekTo(j4);
                a(b4);
            }

            @Override // android.media.session.MediaSession.Callback
            @RequiresApi(29)
            public void onSetPlaybackSpeed(float f4) {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                c(b4);
                Callback.this.onSetPlaybackSpeed(f4);
                a(b4);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSetRating(Rating rating) {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                c(b4);
                Callback.this.onSetRating(RatingCompat.fromRating(rating));
                a(b4);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToNext() {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                c(b4);
                Callback.this.onSkipToNext();
                a(b4);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToPrevious() {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                c(b4);
                Callback.this.onSkipToPrevious();
                a(b4);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToQueueItem(long j4) {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                c(b4);
                Callback.this.onSkipToQueueItem(j4);
                a(b4);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onStop() {
                c b4 = b();
                if (b4 == null) {
                    return;
                }
                c(b4);
                Callback.this.onStop();
                a(b4);
            }
        }

        void a(b bVar, Handler handler) {
            long actions;
            boolean z3;
            boolean z4;
            if (!this.f316c) {
                return;
            }
            boolean z5 = false;
            this.f316c = false;
            handler.removeMessages(1);
            PlaybackStateCompat playbackState = bVar.getPlaybackState();
            if (playbackState == null) {
                actions = 0;
            } else {
                actions = playbackState.getActions();
            }
            if (playbackState != null && playbackState.getState() == 3) {
                z3 = true;
            } else {
                z3 = false;
            }
            if ((516 & actions) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if ((actions & 514) != 0) {
                z5 = true;
            }
            if (z3 && z5) {
                onPause();
            } else if (!z3 && z4) {
                onPlay();
            }
        }

        void b(b bVar, Handler handler) {
            synchronized (this.f314a) {
                this.f317d = new WeakReference<>(bVar);
                a aVar = this.f318e;
                a aVar2 = null;
                if (aVar != null) {
                    aVar.removeCallbacksAndMessages(null);
                }
                if (bVar != null && handler != null) {
                    aVar2 = new a(handler.getLooper());
                }
                this.f318e = aVar2;
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public boolean onMediaButtonEvent(Intent intent) {
            b bVar;
            a aVar;
            KeyEvent keyEvent;
            long actions;
            if (Build.VERSION.SDK_INT >= 27) {
                return false;
            }
            synchronized (this.f314a) {
                bVar = this.f317d.get();
                aVar = this.f318e;
            }
            if (bVar == null || aVar == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            MediaSessionManager.RemoteUserInfo s3 = bVar.s();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 79 && keyCode != 85) {
                a(bVar, aVar);
                return false;
            }
            if (keyEvent.getRepeatCount() == 0) {
                if (this.f316c) {
                    aVar.removeMessages(1);
                    this.f316c = false;
                    PlaybackStateCompat playbackState = bVar.getPlaybackState();
                    if (playbackState == null) {
                        actions = 0;
                    } else {
                        actions = playbackState.getActions();
                    }
                    if ((actions & 32) != 0) {
                        onSkipToNext();
                    }
                } else {
                    this.f316c = true;
                    aVar.sendMessageDelayed(aVar.obtainMessage(1, s3), ViewConfiguration.getDoubleTapTimeout());
                }
            } else {
                a(bVar, aVar);
            }
            return true;
        }

        public void onSetRating(RatingCompat ratingCompat) {
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i4) {
        }

        public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
        }

        public void onFastForward() {
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPrepare() {
        }

        public void onRewind() {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onStop() {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        @Deprecated
        public void onRemoveQueueItemAt(int i4) {
        }

        public void onSeekTo(long j4) {
        }

        public void onSetCaptioningEnabled(boolean z3) {
        }

        public void onSetPlaybackSpeed(float f4) {
        }

        public void onSetRepeatMode(int i4) {
        }

        public void onSetShuffleMode(int i4) {
        }

        public void onSkipToQueueItem(long j4) {
        }

        public void onCustomAction(String str, Bundle bundle) {
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
        }

        public void onPrepareFromMediaId(String str, Bundle bundle) {
        }

        public void onPrepareFromSearch(String str, Bundle bundle) {
        }

        public void onPrepareFromUri(Uri uri, Bundle bundle) {
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }
    }

    /* loaded from: classes.dex */
    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();
        public static final int UNKNOWN_ID = -1;

        /* renamed from: a  reason: collision with root package name */
        private final MediaDescriptionCompat f321a;

        /* renamed from: b  reason: collision with root package name */
        private final long f322b;

        /* renamed from: c  reason: collision with root package name */
        private MediaSession.QueueItem f323c;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<QueueItem> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public QueueItem[] newArray(int i4) {
                return new QueueItem[i4];
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @RequiresApi(21)
        /* loaded from: classes.dex */
        public static class b {
            @DoNotInline
            static MediaSession.QueueItem a(MediaDescription mediaDescription, long j4) {
                return new MediaSession.QueueItem(mediaDescription, j4);
            }

            @DoNotInline
            static MediaDescription b(MediaSession.QueueItem queueItem) {
                return queueItem.getDescription();
            }

            @DoNotInline
            static long c(MediaSession.QueueItem queueItem) {
                return queueItem.getQueueId();
            }
        }

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j4) {
            this(null, mediaDescriptionCompat, j4);
        }

        public static QueueItem fromQueueItem(Object obj) {
            if (obj != null) {
                MediaSession.QueueItem queueItem = (MediaSession.QueueItem) obj;
                return new QueueItem(queueItem, MediaDescriptionCompat.fromMediaDescription(b.b(queueItem)), b.c(queueItem));
            }
            return null;
        }

        public static List<QueueItem> fromQueueItemList(List<?> list) {
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<?> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(fromQueueItem(it.next()));
                }
                return arrayList;
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public MediaDescriptionCompat getDescription() {
            return this.f321a;
        }

        public long getQueueId() {
            return this.f322b;
        }

        public Object getQueueItem() {
            MediaSession.QueueItem queueItem = this.f323c;
            if (queueItem == null) {
                MediaSession.QueueItem a4 = b.a((MediaDescription) this.f321a.getMediaDescription(), this.f322b);
                this.f323c = a4;
                return a4;
            }
            return queueItem;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f321a + ", Id=" + this.f322b + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            this.f321a.writeToParcel(parcel, i4);
            parcel.writeLong(this.f322b);
        }

        private QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j4) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null");
            }
            if (j4 != -1) {
                this.f321a = mediaDescriptionCompat;
                this.f322b = j4;
                this.f323c = queueItem;
                return;
            }
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        }

        QueueItem(Parcel parcel) {
            this.f321a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f322b = parcel.readLong();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        ResultReceiver f324a;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<ResultReceiverWrapper> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public ResultReceiverWrapper[] newArray(int i4) {
                return new ResultReceiverWrapper[i4];
            }
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f324a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            this.f324a.writeToParcel(parcel, i4);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final Object f325a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f326b;
        @GuardedBy("mLock")

        /* renamed from: c  reason: collision with root package name */
        private IMediaSession f327c;
        @GuardedBy("mLock")

        /* renamed from: d  reason: collision with root package name */
        private VersionedParcelable f328d;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<Token> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable(null));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public Token[] newArray(int i4) {
                return new Token[i4];
            }
        }

        Token(Object obj) {
            this(obj, null, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static Token fromBundle(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            bundle.setClassLoader(Token.class.getClassLoader());
            IMediaSession asInterface = IMediaSession.Stub.asInterface(BundleCompat.getBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER));
            VersionedParcelable versionedParcelable = ParcelUtils.getVersionedParcelable(bundle, MediaSessionCompat.KEY_SESSION2_TOKEN);
            Token token = (Token) bundle.getParcelable(MediaSessionCompat.KEY_TOKEN);
            if (token == null) {
                return null;
            }
            return new Token(token.f326b, asInterface, versionedParcelable);
        }

        public static Token fromToken(Object obj) {
            return fromToken(obj, null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f326b;
            if (obj2 == null) {
                if (token.f326b == null) {
                    return true;
                }
                return false;
            }
            Object obj3 = token.f326b;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public IMediaSession getExtraBinder() {
            IMediaSession iMediaSession;
            synchronized (this.f325a) {
                iMediaSession = this.f327c;
            }
            return iMediaSession;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public VersionedParcelable getSession2Token() {
            VersionedParcelable versionedParcelable;
            synchronized (this.f325a) {
                versionedParcelable = this.f328d;
            }
            return versionedParcelable;
        }

        public Object getToken() {
            return this.f326b;
        }

        public int hashCode() {
            Object obj = this.f326b;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void setExtraBinder(IMediaSession iMediaSession) {
            synchronized (this.f325a) {
                this.f327c = iMediaSession;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void setSession2Token(VersionedParcelable versionedParcelable) {
            synchronized (this.f325a) {
                this.f328d = versionedParcelable;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaSessionCompat.KEY_TOKEN, this);
            synchronized (this.f325a) {
                IMediaSession iMediaSession = this.f327c;
                if (iMediaSession != null) {
                    BundleCompat.putBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER, iMediaSession.asBinder());
                }
                VersionedParcelable versionedParcelable = this.f328d;
                if (versionedParcelable != null) {
                    ParcelUtils.putVersionedParcelable(bundle, MediaSessionCompat.KEY_SESSION2_TOKEN, versionedParcelable);
                }
            }
            return bundle;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeParcelable((Parcelable) this.f326b, i4);
        }

        Token(Object obj, IMediaSession iMediaSession) {
            this(obj, iMediaSession, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Token fromToken(Object obj, IMediaSession iMediaSession) {
            if (obj != null) {
                if (obj instanceof MediaSession.Token) {
                    return new Token(obj, iMediaSession);
                }
                throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
            }
            return null;
        }

        Token(Object obj, IMediaSession iMediaSession, VersionedParcelable versionedParcelable) {
            this.f325a = new Object();
            this.f326b = obj;
            this.f327c = iMediaSession;
            this.f328d = versionedParcelable;
        }
    }

    /* loaded from: classes.dex */
    class a extends Callback {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        Token a();

        void b(String str, Bundle bundle);

        void c(Callback callback, Handler handler);

        void d(int i4);

        void e(PlaybackStateCompat playbackStateCompat);

        String f();

        void g(int i4);

        PlaybackStateCompat getPlaybackState();

        void h(PendingIntent pendingIntent);

        Object i();

        boolean isActive();

        void j(boolean z3);

        void k(MediaSessionManager.RemoteUserInfo remoteUserInfo);

        void l(VolumeProviderCompat volumeProviderCompat);

        void m(CharSequence charSequence);

        void n(MediaMetadataCompat mediaMetadataCompat);

        void o(List<QueueItem> list);

        void p(PendingIntent pendingIntent);

        Callback q();

        Object r();

        void release();

        MediaSessionManager.RemoteUserInfo s();

        void setCaptioningEnabled(boolean z3);

        void setExtras(Bundle bundle);

        void setFlags(int i4);

        void setRepeatMode(int i4);

        void setShuffleMode(int i4);
    }

    @RequiresApi(22)
    /* loaded from: classes.dex */
    static class d extends c {
        d(Context context, String str, VersionedParcelable versionedParcelable, Bundle bundle) {
            super(context, str, versionedParcelable, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c, android.support.v4.media.session.MediaSessionCompat.b
        public void d(int i4) {
            this.f330a.setRatingType(i4);
        }

        d(Object obj) {
            super(obj);
        }
    }

    @RequiresApi(28)
    /* loaded from: classes.dex */
    static class e extends d {
        e(Context context, String str, VersionedParcelable versionedParcelable, Bundle bundle) {
            super(context, str, versionedParcelable, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c, android.support.v4.media.session.MediaSessionCompat.b
        @NonNull
        public final MediaSessionManager.RemoteUserInfo s() {
            MediaSessionManager.RemoteUserInfo currentControllerInfo;
            currentControllerInfo = this.f330a.getCurrentControllerInfo();
            return new MediaSessionManager.RemoteUserInfo(currentControllerInfo);
        }

        e(Object obj) {
            super(obj);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c, android.support.v4.media.session.MediaSessionCompat.b
        public void k(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        }
    }

    @RequiresApi(29)
    /* loaded from: classes.dex */
    static class f extends e {
        f(Context context, String str, VersionedParcelable versionedParcelable, Bundle bundle) {
            super(context, str, versionedParcelable, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public MediaSession t(Context context, String str, Bundle bundle) {
            return new MediaSession(context, str, bundle);
        }

        f(Object obj) {
            super(obj);
            Bundle sessionInfo;
            sessionInfo = ((MediaSession) obj).getController().getSessionInfo();
            this.f333d = sessionInfo;
        }
    }

    static {
        int i4;
        if (BuildCompat.isAtLeastS()) {
            i4 = 33554432;
        } else {
            i4 = 0;
        }
        PENDING_INTENT_FLAG_MUTABLE = i4;
    }

    public MediaSessionCompat(@NonNull Context context, @NonNull String str) {
        this(context, str, null, null);
    }

    static PlaybackStateCompat a(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        long lastPositionUpdateTime;
        long j4;
        if (playbackStateCompat != null) {
            long j5 = -1;
            if (playbackStateCompat.getPosition() != -1) {
                if (playbackStateCompat.getState() == 3 || playbackStateCompat.getState() == 4 || playbackStateCompat.getState() == 5) {
                    if (playbackStateCompat.getLastPositionUpdateTime() > 0) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        long playbackSpeed = (playbackStateCompat.getPlaybackSpeed() * ((float) (elapsedRealtime - lastPositionUpdateTime))) + playbackStateCompat.getPosition();
                        if (mediaMetadataCompat != null && mediaMetadataCompat.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION)) {
                            j5 = mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
                        }
                        if (j5 >= 0 && playbackSpeed > j5) {
                            j4 = j5;
                        } else if (playbackSpeed < 0) {
                            j4 = 0;
                        } else {
                            j4 = playbackSpeed;
                        }
                        return new PlaybackStateCompat.Builder(playbackStateCompat).setState(playbackStateCompat.getState(), j4, playbackStateCompat.getPlaybackSpeed(), elapsedRealtime).build();
                    }
                    return playbackStateCompat;
                }
                return playbackStateCompat;
            }
            return playbackStateCompat;
        }
        return playbackStateCompat;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void ensureClassLoader(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static MediaSessionCompat fromMediaSession(Context context, Object obj) {
        b cVar;
        int i4 = Build.VERSION.SDK_INT;
        if (context != null && obj != null) {
            if (i4 >= 29) {
                cVar = new f(obj);
            } else if (i4 >= 28) {
                cVar = new e(obj);
            } else {
                cVar = new c(obj);
            }
            return new MediaSessionCompat(context, cVar);
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Bundle unparcelWithClassLoader(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ensureClassLoader(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }

    public void addOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener != null) {
            this.f313c.add(onActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String getCallingPackage() {
        return this.f311a.f();
    }

    public MediaControllerCompat getController() {
        return this.f312b;
    }

    @NonNull
    public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
        return this.f311a.s();
    }

    public Object getMediaSession() {
        return this.f311a.r();
    }

    public Object getRemoteControlClient() {
        return this.f311a.i();
    }

    public Token getSessionToken() {
        return this.f311a.a();
    }

    public boolean isActive() {
        return this.f311a.isActive();
    }

    public void release() {
        this.f311a.release();
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener != null) {
            this.f313c.remove(onActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }

    public void sendSessionEvent(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.f311a.b(str, bundle);
            return;
        }
        throw new IllegalArgumentException("event cannot be null or empty");
    }

    public void setActive(boolean z3) {
        this.f311a.j(z3);
        Iterator<OnActiveChangeListener> it = this.f313c.iterator();
        while (it.hasNext()) {
            it.next().onActiveChanged();
        }
    }

    public void setCallback(Callback callback) {
        setCallback(callback, null);
    }

    public void setCaptioningEnabled(boolean z3) {
        this.f311a.setCaptioningEnabled(z3);
    }

    public void setExtras(Bundle bundle) {
        this.f311a.setExtras(bundle);
    }

    public void setFlags(int i4) {
        this.f311a.setFlags(i4);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        this.f311a.h(pendingIntent);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        this.f311a.n(mediaMetadataCompat);
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        this.f311a.e(playbackStateCompat);
    }

    public void setPlaybackToLocal(int i4) {
        this.f311a.g(i4);
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
        if (volumeProviderCompat != null) {
            this.f311a.l(volumeProviderCompat);
            return;
        }
        throw new IllegalArgumentException("volumeProvider may not be null!");
    }

    public void setQueue(List<QueueItem> list) {
        if (list != null) {
            HashSet hashSet = new HashSet();
            for (QueueItem queueItem : list) {
                if (queueItem != null) {
                    if (hashSet.contains(Long.valueOf(queueItem.getQueueId()))) {
                        Log.e("MediaSessionCompat", "Found duplicate queue id: " + queueItem.getQueueId(), new IllegalArgumentException("id of each queue item should be unique"));
                    }
                    hashSet.add(Long.valueOf(queueItem.getQueueId()));
                } else {
                    throw new IllegalArgumentException("queue shouldn't have null items");
                }
            }
        }
        this.f311a.o(list);
    }

    public void setQueueTitle(CharSequence charSequence) {
        this.f311a.m(charSequence);
    }

    public void setRatingType(int i4) {
        this.f311a.d(i4);
    }

    public void setRepeatMode(int i4) {
        this.f311a.setRepeatMode(i4);
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        this.f311a.p(pendingIntent);
    }

    public void setShuffleMode(int i4) {
        this.f311a.setShuffleMode(i4);
    }

    public MediaSessionCompat(@NonNull Context context, @NonNull String str, @Nullable ComponentName componentName, @Nullable PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, null);
    }

    public void setCallback(Callback callback, Handler handler) {
        if (callback == null) {
            this.f311a.c(null, null);
            return;
        }
        b bVar = this.f311a;
        if (handler == null) {
            handler = new Handler();
        }
        bVar.c(callback, handler);
    }

    public MediaSessionCompat(@NonNull Context context, @NonNull String str, @Nullable ComponentName componentName, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle) {
        this(context, str, componentName, pendingIntent, bundle, null);
    }

    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public MediaSessionCompat(@NonNull Context context, @NonNull String str, @Nullable ComponentName componentName, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle, @Nullable VersionedParcelable versionedParcelable) {
        this.f313c = new ArrayList<>();
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                if (componentName == null && (componentName = MediaButtonReceiver.getMediaButtonReceiverComponent(context)) == null) {
                    Log.w("MediaSessionCompat", "Couldn't find a unique registered media button receiver in the given context.");
                }
                if (componentName != null && pendingIntent == null) {
                    Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                    intent.setComponent(componentName);
                    pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PENDING_INTENT_FLAG_MUTABLE);
                }
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 29) {
                    this.f311a = new f(context, str, versionedParcelable, bundle);
                } else if (i4 >= 28) {
                    this.f311a = new e(context, str, versionedParcelable, bundle);
                } else if (i4 >= 22) {
                    this.f311a = new d(context, str, versionedParcelable, bundle);
                } else {
                    this.f311a = new c(context, str, versionedParcelable, bundle);
                }
                setCallback(new a(), new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()));
                this.f311a.h(pendingIntent);
                this.f312b = new MediaControllerCompat(context, this);
                if (f310d == 0) {
                    f310d = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("tag must not be null or empty");
        }
        throw new IllegalArgumentException("context must not be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class c implements b {

        /* renamed from: a  reason: collision with root package name */
        final MediaSession f330a;

        /* renamed from: b  reason: collision with root package name */
        final Token f331b;

        /* renamed from: d  reason: collision with root package name */
        Bundle f333d;

        /* renamed from: g  reason: collision with root package name */
        PlaybackStateCompat f336g;

        /* renamed from: h  reason: collision with root package name */
        List<QueueItem> f337h;

        /* renamed from: i  reason: collision with root package name */
        MediaMetadataCompat f338i;

        /* renamed from: j  reason: collision with root package name */
        int f339j;

        /* renamed from: k  reason: collision with root package name */
        boolean f340k;

        /* renamed from: l  reason: collision with root package name */
        int f341l;

        /* renamed from: m  reason: collision with root package name */
        int f342m;
        @GuardedBy("mLock")

        /* renamed from: n  reason: collision with root package name */
        Callback f343n;
        @GuardedBy("mLock")

        /* renamed from: o  reason: collision with root package name */
        MediaSessionManager.RemoteUserInfo f344o;

        /* renamed from: c  reason: collision with root package name */
        final Object f332c = new Object();

        /* renamed from: e  reason: collision with root package name */
        boolean f334e = false;

        /* renamed from: f  reason: collision with root package name */
        final RemoteCallbackList<IMediaControllerCallback> f335f = new RemoteCallbackList<>();

        c(Context context, String str, VersionedParcelable versionedParcelable, Bundle bundle) {
            MediaSession t3 = t(context, str, bundle);
            this.f330a = t3;
            this.f331b = new Token(t3.getSessionToken(), new a(), versionedParcelable);
            this.f333d = bundle;
            setFlags(3);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public Token a() {
            return this.f331b;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void b(String str, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 23) {
                for (int beginBroadcast = this.f335f.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f335f.getBroadcastItem(beginBroadcast).onEvent(str, bundle);
                    } catch (RemoteException unused) {
                    }
                }
                this.f335f.finishBroadcast();
            }
            this.f330a.sendSessionEvent(str, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void c(Callback callback, Handler handler) {
            MediaSession.Callback callback2;
            synchronized (this.f332c) {
                this.f343n = callback;
                MediaSession mediaSession = this.f330a;
                if (callback == null) {
                    callback2 = null;
                } else {
                    callback2 = callback.f315b;
                }
                mediaSession.setCallback(callback2, handler);
                if (callback != null) {
                    callback.b(this, handler);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void d(int i4) {
            this.f339j = i4;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void e(PlaybackStateCompat playbackStateCompat) {
            PlaybackState playbackState;
            this.f336g = playbackStateCompat;
            for (int beginBroadcast = this.f335f.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f335f.getBroadcastItem(beginBroadcast).onPlaybackStateChanged(playbackStateCompat);
                } catch (RemoteException unused) {
                }
            }
            this.f335f.finishBroadcast();
            MediaSession mediaSession = this.f330a;
            if (playbackStateCompat == null) {
                playbackState = null;
            } else {
                playbackState = (PlaybackState) playbackStateCompat.getPlaybackState();
            }
            mediaSession.setPlaybackState(playbackState);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public String f() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            try {
                return (String) this.f330a.getClass().getMethod("getCallingPackage", new Class[0]).invoke(this.f330a, new Object[0]);
            } catch (Exception e4) {
                Log.e("MediaSessionCompat", "Cannot execute MediaSession.getCallingPackage()", e4);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void g(int i4) {
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            builder.setLegacyStreamType(i4);
            this.f330a.setPlaybackToLocal(builder.build());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public PlaybackStateCompat getPlaybackState() {
            return this.f336g;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void h(PendingIntent pendingIntent) {
            this.f330a.setMediaButtonReceiver(pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public Object i() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public boolean isActive() {
            return this.f330a.isActive();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void j(boolean z3) {
            this.f330a.setActive(z3);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void k(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            synchronized (this.f332c) {
                this.f344o = remoteUserInfo;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void l(VolumeProviderCompat volumeProviderCompat) {
            this.f330a.setPlaybackToRemote((VolumeProvider) volumeProviderCompat.getVolumeProvider());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void m(CharSequence charSequence) {
            this.f330a.setQueueTitle(charSequence);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void n(MediaMetadataCompat mediaMetadataCompat) {
            MediaMetadata mediaMetadata;
            this.f338i = mediaMetadataCompat;
            MediaSession mediaSession = this.f330a;
            if (mediaMetadataCompat == null) {
                mediaMetadata = null;
            } else {
                mediaMetadata = (MediaMetadata) mediaMetadataCompat.getMediaMetadata();
            }
            mediaSession.setMetadata(mediaMetadata);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void o(List<QueueItem> list) {
            this.f337h = list;
            if (list == null) {
                this.f330a.setQueue(null);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (QueueItem queueItem : list) {
                arrayList.add((MediaSession.QueueItem) queueItem.getQueueItem());
            }
            this.f330a.setQueue(arrayList);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void p(PendingIntent pendingIntent) {
            this.f330a.setSessionActivity(pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public Callback q() {
            Callback callback;
            synchronized (this.f332c) {
                callback = this.f343n;
            }
            return callback;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public Object r() {
            return this.f330a;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void release() {
            this.f334e = true;
            this.f335f.kill();
            if (Build.VERSION.SDK_INT == 27) {
                try {
                    Field declaredField = this.f330a.getClass().getDeclaredField("mCallback");
                    declaredField.setAccessible(true);
                    Handler handler = (Handler) declaredField.get(this.f330a);
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                } catch (Exception e4) {
                    Log.w("MediaSessionCompat", "Exception happened while accessing MediaSession.mCallback.", e4);
                }
            }
            this.f330a.setCallback(null);
            this.f330a.release();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public MediaSessionManager.RemoteUserInfo s() {
            MediaSessionManager.RemoteUserInfo remoteUserInfo;
            synchronized (this.f332c) {
                remoteUserInfo = this.f344o;
            }
            return remoteUserInfo;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void setCaptioningEnabled(boolean z3) {
            if (this.f340k != z3) {
                this.f340k = z3;
                for (int beginBroadcast = this.f335f.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f335f.getBroadcastItem(beginBroadcast).onCaptioningEnabledChanged(z3);
                    } catch (RemoteException unused) {
                    }
                }
                this.f335f.finishBroadcast();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void setExtras(Bundle bundle) {
            this.f330a.setExtras(bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        @SuppressLint({"WrongConstant"})
        public void setFlags(int i4) {
            this.f330a.setFlags(i4 | 1 | 2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void setRepeatMode(int i4) {
            if (this.f341l != i4) {
                this.f341l = i4;
                for (int beginBroadcast = this.f335f.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f335f.getBroadcastItem(beginBroadcast).onRepeatModeChanged(i4);
                    } catch (RemoteException unused) {
                    }
                }
                this.f335f.finishBroadcast();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void setShuffleMode(int i4) {
            if (this.f342m != i4) {
                this.f342m = i4;
                for (int beginBroadcast = this.f335f.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f335f.getBroadcastItem(beginBroadcast).onShuffleModeChanged(i4);
                    } catch (RemoteException unused) {
                    }
                }
                this.f335f.finishBroadcast();
            }
        }

        public MediaSession t(Context context, String str, Bundle bundle) {
            return new MediaSession(context, str);
        }

        c(Object obj) {
            if (obj instanceof MediaSession) {
                MediaSession mediaSession = (MediaSession) obj;
                this.f330a = mediaSession;
                this.f331b = new Token(mediaSession.getSessionToken(), new a());
                this.f333d = null;
                setFlags(3);
                return;
            }
            throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
        }

        /* loaded from: classes.dex */
        class a extends IMediaSession.Stub {
            a() {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i4) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int i4, int i5, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                c cVar = c.this;
                return MediaSessionCompat.a(cVar.f336g, cVar.f338i);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public List<QueueItem> getQueue() {
                return null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return c.this.f339j;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                return c.this.f341l;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getSessionInfo() {
                if (c.this.f333d == null) {
                    return null;
                }
                return new Bundle(c.this.f333d);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                return c.this.f342m;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return c.this.f340k;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat ratingCompat) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                if (!c.this.f334e) {
                    c.this.f335f.register(iMediaControllerCallback, new MediaSessionManager.RemoteUserInfo(MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER, Binder.getCallingPid(), Binder.getCallingUid()));
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int i4) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long j4) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent keyEvent) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean z3) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setPlaybackSpeed(float f4) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int i4) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int i4) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int i4, int i5, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long j4) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                c.this.f335f.unregister(iMediaControllerCallback);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean z3) throws RemoteException {
            }
        }
    }

    private MediaSessionCompat(Context context, b bVar) {
        this.f313c = new ArrayList<>();
        this.f311a = bVar;
        this.f312b = new MediaControllerCompat(context, this);
    }
}
