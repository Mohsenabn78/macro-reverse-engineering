package com.arlosoft.macrodroid.triggers.mediabutton;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Build;
import android.view.KeyEvent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.MediaButtonV2Trigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.mediabutton.MediaButtonDetection;
import com.arlosoft.macrodroid.triggers.services.NotificationService;
import com.arlosoft.macrodroid.triggers.services.NotificationServiceOreo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

/* compiled from: MediaButtonDetection.kt */
@StabilityInferred(parameters = 0)
@Singleton
@TargetApi(21)
/* loaded from: classes3.dex */
public final class MediaButtonDetection {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static a f15184i;

    /* renamed from: j  reason: collision with root package name */
    private static final boolean f15185j = false;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f15186a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final MediaSessionManager f15187b;

    /* renamed from: c  reason: collision with root package name */
    private final PlaybackState f15188c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private MediaSession f15189d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<MediaController> f15190e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final MediaSession.Callback f15191f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final MediaSessionManager.OnActiveSessionsChangedListener f15192g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final MediaButtonDetection$mediaStateCallback$1 f15193h;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: MediaButtonDetection.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaButtonDetection.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f15194a;

        /* renamed from: b  reason: collision with root package name */
        private final long f15195b;

        public a(int i4, long j4) {
            this.f15194a = i4;
            this.f15195b = j4;
        }

        public final int a() {
            return this.f15194a;
        }

        public final long b() {
            return this.f15195b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f15194a == aVar.f15194a && this.f15195b == aVar.f15195b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f15194a * 31) + androidx.compose.animation.a.a(this.f15195b);
        }

        @NotNull
        public String toString() {
            int i4 = this.f15194a;
            long j4 = this.f15195b;
            return "PressEvent(keyCode=" + i4 + ", timestamp=" + j4 + ")";
        }
    }

    /* JADX WARN: Type inference failed for: r5v10, types: [com.arlosoft.macrodroid.triggers.mediabutton.MediaButtonDetection$mediaStateCallback$1] */
    @Inject
    public MediaButtonDetection(@ApplicationContext @NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.f15186a = appContext;
        Object systemService = appContext.getSystemService("media_session");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.session.MediaSessionManager");
        this.f15187b = (MediaSessionManager) systemService;
        this.f15188c = new PlaybackState.Builder().setActions(639L).setState(8, -1L, 0.0f).build();
        this.f15190e = new ArrayList<>();
        this.f15191f = new MediaSession.Callback() { // from class: com.arlosoft.macrodroid.triggers.mediabutton.MediaButtonDetection$mediaSessionCallback$1
            @Override // android.media.session.MediaSession.Callback
            public boolean onMediaButtonEvent(@NotNull Intent mediaButtonIntent) {
                MediaButtonDetection.a aVar;
                boolean i4;
                Context context;
                ArrayList arrayList;
                ArrayList arrayList2;
                Object first;
                Intrinsics.checkNotNullParameter(mediaButtonIntent, "mediaButtonIntent");
                KeyEvent keyEvent = (KeyEvent) mediaButtonIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                if (keyEvent == null) {
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                aVar = MediaButtonDetection.f15184i;
                if (aVar == null || aVar.a() != keyEvent.getKeyCode() || aVar.b() + 100 <= currentTimeMillis) {
                    MediaButtonDetection.f15184i = new MediaButtonDetection.a(keyEvent.getKeyCode(), currentTimeMillis);
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode == 79) {
                        i4 = MediaButtonDetection.this.i(MacroDroidMediaButton.PAUSE);
                    } else if (keyCode == 126) {
                        i4 = MediaButtonDetection.this.i(MacroDroidMediaButton.PLAY);
                    } else if (keyCode != 127) {
                        switch (keyCode) {
                            case 85:
                                i4 = MediaButtonDetection.this.i(MacroDroidMediaButton.PLAY_PAUSE);
                                break;
                            case 86:
                                i4 = MediaButtonDetection.this.i(MacroDroidMediaButton.STOP);
                                break;
                            case 87:
                                i4 = MediaButtonDetection.this.i(MacroDroidMediaButton.NEXT);
                                break;
                            case 88:
                                i4 = MediaButtonDetection.this.i(MacroDroidMediaButton.PREVIOUS);
                                break;
                            default:
                                i4 = false;
                                break;
                        }
                    } else {
                        i4 = MediaButtonDetection.this.i(MacroDroidMediaButton.PAUSE);
                    }
                    if (!i4) {
                        context = MediaButtonDetection.this.f15186a;
                        if (Settings.getMediaButtonPassThroughUnhandled(context)) {
                            arrayList = MediaButtonDetection.this.f15190e;
                            if (!arrayList.isEmpty()) {
                                arrayList2 = MediaButtonDetection.this.f15190e;
                                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
                                ((MediaController) first).dispatchMediaButtonEvent(keyEvent);
                            }
                        }
                    }
                    return false;
                }
                return true;
            }
        };
        this.f15192g = new MediaSessionManager.OnActiveSessionsChangedListener() { // from class: p0.c
            @Override // android.media.session.MediaSessionManager.OnActiveSessionsChangedListener
            public final void onActiveSessionsChanged(List list) {
                MediaButtonDetection.f(MediaButtonDetection.this, list);
            }
        };
        this.f15193h = new MediaController.Callback() { // from class: com.arlosoft.macrodroid.triggers.mediabutton.MediaButtonDetection$mediaStateCallback$1
            @Override // android.media.session.MediaController.Callback
            public void onPlaybackStateChanged(@Nullable PlaybackState playbackState) {
                MediaButtonDetection mediaButtonDetection = MediaButtonDetection.this;
                mediaButtonDetection.j("PLAYBACK STATE CHANGE: " + playbackState);
                if (playbackState != null) {
                    MediaButtonDetection mediaButtonDetection2 = MediaButtonDetection.this;
                    if (playbackState.getState() == 1 || playbackState.getState() == 2) {
                        mediaButtonDetection2.j("MEDIA HAS STOPPED PLAYING");
                        mediaButtonDetection2.r();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(MediaButtonDetection this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(list);
        this$0.h(list);
    }

    private final void g() {
        ComponentName componentName;
        MediaSession mediaSession = new MediaSession(this.f15186a, "MacroDroidMediaSession");
        this.f15189d = mediaSession;
        mediaSession.setFlags(3);
        mediaSession.setCallback(this.f15191f, null);
        mediaSession.setActive(true);
        mediaSession.setPlaybackToLocal(new AudioAttributes.Builder().setContentType(0).setUsage(0).build());
        mediaSession.setPlaybackState(this.f15188c);
        boolean isActive = mediaSession.isActive();
        MediaSession.Token sessionToken = mediaSession.getSessionToken();
        Timber.e("Media Session is active: " + isActive + " id = " + sessionToken, new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("pbState = ");
        sb.append(639L);
        j(sb.toString());
        j("PLAYING SOUND");
        q();
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                componentName = new ComponentName(this.f15186a, NotificationServiceOreo.class);
            } else {
                componentName = new ComponentName(this.f15186a, NotificationService.class);
            }
            this.f15187b.addOnActiveSessionsChangedListener(this.f15192g, componentName);
        } catch (SecurityException unused) {
            SystemLog.logError("Media Button V2 trigger requires notification access to be granted to MacroDroid");
            PermissionsHelper.showNeedsSpecialPermission(this.f15186a, "Media Button V2", 6);
        }
    }

    private final void h(List<MediaController> list) {
        MediaSession.Token token;
        Object first;
        j("-----------------------------+++++++++++++++++++++");
        int size = list.size();
        j("ACTIVE SESSION COUNT: " + size + " +++++++++++++++");
        MediaSession mediaSession = this.f15189d;
        if (mediaSession != null) {
            token = mediaSession.getSessionToken();
        } else {
            token = null;
        }
        j("MACRODROID SESSION token = : " + token);
        int size2 = list.size();
        j("ACTIVE SESSION COUNT: " + size2 + " +++++++++++++++++++");
        for (MediaController mediaController : list) {
            String packageName = mediaController.getPackageName();
            MediaSession.Token sessionToken = mediaController.getSessionToken();
            j("ACTIVE SESSION: " + packageName + ", token = " + sessionToken);
        }
        j("CLEARED ALL OTHER ALIVE MEDIA CONTROLLERS");
        Iterator<MediaController> it = this.f15190e.iterator();
        while (it.hasNext()) {
            it.next().unregisterCallback(this.f15193h);
        }
        this.f15190e.clear();
        if (!list.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            if (Intrinsics.areEqual(((MediaController) first).getPackageName(), this.f15186a.getPackageName())) {
                r();
                j("We are the top media controller");
            }
            for (MediaController mediaController2 : list) {
                String packageName2 = mediaController2.getPackageName();
                j("CHECKING CONTROLLER: " + packageName2);
                if (Intrinsics.areEqual(mediaController2.getPackageName(), this.f15186a.getPackageName())) {
                    j("We are active");
                } else {
                    String packageName3 = mediaController2.getPackageName();
                    j("ADDING OTHER MEDIA CONTROLLER: " + packageName3 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    this.f15190e.add(mediaController2);
                    mediaController2.registerCallback(this.f15193h);
                }
            }
            return;
        }
        j("MacroDroid is already top");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i(MacroDroidMediaButton macroDroidMediaButton) {
        ArrayList<Macro> arrayList = new ArrayList();
        String string = this.f15186a.getString(macroDroidMediaButton.getStringRes());
        SystemLog.logVerbose("Media Button Pressed: " + string);
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if ((next instanceof MediaButtonV2Trigger) && ((MediaButtonV2Trigger) next).isButtonEnabled(macroDroidMediaButton) && next.constraintsMet()) {
                    macro.setTriggerThatInvoked(next);
                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                        Intrinsics.checkNotNullExpressionValue(macro, "macro");
                        arrayList.add(macro);
                    }
                }
            }
        }
        for (Macro macro2 : arrayList) {
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
        return !arrayList.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String str) {
        Timber.d("++++++++++ " + str, new Object[0]);
    }

    private final void k() {
        RingtoneManager ringtoneManager = new RingtoneManager(this.f15186a);
        ringtoneManager.setType(2);
        final MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: p0.d
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer2) {
                MediaButtonDetection.l(mediaPlayer, mediaPlayer2);
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: p0.e
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer2, int i4, int i5) {
                boolean m4;
                m4 = MediaButtonDetection.m(mediaPlayer, mediaPlayer2, i4, i5);
                return m4;
            }
        });
        try {
            ringtoneManager.getCursor();
            Uri ringtoneUri = ringtoneManager.getRingtoneUri(0);
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(this.f15186a, ringtoneUri);
                mediaPlayer.prepare();
                mediaPlayer.start();
            }
        } catch (Exception e4) {
            Timber.e("Failed to play ringtone: " + e4, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(MediaPlayer mediaPlayer, MediaPlayer mediaPlayer2) {
        Intrinsics.checkNotNullParameter(mediaPlayer, "$mediaPlayer");
        mediaPlayer.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(MediaPlayer mediaPlayer, MediaPlayer mediaPlayer2, int i4, int i5) {
        Intrinsics.checkNotNullParameter(mediaPlayer, "$mediaPlayer");
        mediaPlayer.release();
        return true;
    }

    private final void n() {
        try {
            final MediaPlayer create = MediaPlayer.create(this.f15186a, (int) R.raw.silence);
            create.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: p0.a
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    MediaButtonDetection.o(create, mediaPlayer);
                }
            });
            create.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: p0.b
                @Override // android.media.MediaPlayer.OnErrorListener
                public final boolean onError(MediaPlayer mediaPlayer, int i4, int i5) {
                    boolean p4;
                    p4 = MediaButtonDetection.p(create, mediaPlayer, i4, i5);
                    return p4;
                }
            });
            if (!create.isPlaying()) {
                create.start();
                j("Called mediaPlayer.start()");
            }
        } catch (Exception e4) {
            Timber.e("Failed to play sound: " + e4, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(MediaPlayer mediaPlayer, MediaPlayer mediaPlayer2) {
        mediaPlayer.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(MediaPlayer mediaPlayer, MediaPlayer mediaPlayer2, int i4, int i5) {
        mediaPlayer.release();
        return true;
    }

    private final void q() {
        if (f15185j) {
            k();
        } else {
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        j("Trying to steal back priority for our media session - playing sound");
        q();
    }

    public final void startDetectingButtons() {
        g();
    }

    public final void stopDetectingButtons() {
        Iterator<MediaController> it = this.f15190e.iterator();
        while (it.hasNext()) {
            it.next().unregisterCallback(this.f15193h);
        }
        this.f15190e.clear();
        MediaSession mediaSession = this.f15189d;
        if (mediaSession != null) {
            mediaSession.setActive(false);
        }
        MediaSession mediaSession2 = this.f15189d;
        if (mediaSession2 != null) {
            mediaSession2.release();
        }
        try {
            this.f15187b.removeOnActiveSessionsChangedListener(this.f15192g);
        } catch (Exception e4) {
            SystemLog.logError("Failed to remove active sessions changed listener: " + e4);
        }
    }
}
