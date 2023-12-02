package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final long ACTION_FAST_FORWARD = 64;
    public static final long ACTION_PAUSE = 2;
    public static final long ACTION_PLAY = 4;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024;
    public static final long ACTION_PLAY_FROM_SEARCH = 2048;
    public static final long ACTION_PLAY_FROM_URI = 8192;
    public static final long ACTION_PLAY_PAUSE = 512;
    public static final long ACTION_PREPARE = 16384;
    public static final long ACTION_PREPARE_FROM_MEDIA_ID = 32768;
    public static final long ACTION_PREPARE_FROM_SEARCH = 65536;
    public static final long ACTION_PREPARE_FROM_URI = 131072;
    public static final long ACTION_REWIND = 8;
    public static final long ACTION_SEEK_TO = 256;
    public static final long ACTION_SET_CAPTIONING_ENABLED = 1048576;
    public static final long ACTION_SET_PLAYBACK_SPEED = 4194304;
    public static final long ACTION_SET_RATING = 128;
    public static final long ACTION_SET_REPEAT_MODE = 262144;
    public static final long ACTION_SET_SHUFFLE_MODE = 2097152;
    @Deprecated
    public static final long ACTION_SET_SHUFFLE_MODE_ENABLED = 524288;
    public static final long ACTION_SKIP_TO_NEXT = 32;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096;
    public static final long ACTION_STOP = 1;
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();
    public static final int ERROR_CODE_ACTION_ABORTED = 10;
    public static final int ERROR_CODE_APP_ERROR = 1;
    public static final int ERROR_CODE_AUTHENTICATION_EXPIRED = 3;
    public static final int ERROR_CODE_CONCURRENT_STREAM_LIMIT = 5;
    public static final int ERROR_CODE_CONTENT_ALREADY_PLAYING = 8;
    public static final int ERROR_CODE_END_OF_QUEUE = 11;
    public static final int ERROR_CODE_NOT_AVAILABLE_IN_REGION = 7;
    public static final int ERROR_CODE_NOT_SUPPORTED = 2;
    public static final int ERROR_CODE_PARENTAL_CONTROL_RESTRICTED = 6;
    public static final int ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED = 4;
    public static final int ERROR_CODE_SKIP_LIMIT_REACHED = 9;
    public static final int ERROR_CODE_UNKNOWN_ERROR = 0;
    public static final long PLAYBACK_POSITION_UNKNOWN = -1;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_GROUP = 3;
    public static final int REPEAT_MODE_INVALID = -1;
    public static final int REPEAT_MODE_NONE = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int SHUFFLE_MODE_ALL = 1;
    public static final int SHUFFLE_MODE_GROUP = 2;
    public static final int SHUFFLE_MODE_INVALID = -1;
    public static final int SHUFFLE_MODE_NONE = 0;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;

    /* renamed from: a  reason: collision with root package name */
    final int f346a;

    /* renamed from: b  reason: collision with root package name */
    final long f347b;

    /* renamed from: c  reason: collision with root package name */
    final long f348c;

    /* renamed from: d  reason: collision with root package name */
    final float f349d;

    /* renamed from: e  reason: collision with root package name */
    final long f350e;

    /* renamed from: f  reason: collision with root package name */
    final int f351f;

    /* renamed from: g  reason: collision with root package name */
    final CharSequence f352g;

    /* renamed from: h  reason: collision with root package name */
    final long f353h;

    /* renamed from: i  reason: collision with root package name */
    List<CustomAction> f354i;

    /* renamed from: j  reason: collision with root package name */
    final long f355j;

    /* renamed from: k  reason: collision with root package name */
    final Bundle f356k;

    /* renamed from: l  reason: collision with root package name */
    private PlaybackState f357l;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface Actions {
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final List<CustomAction> f358a;

        /* renamed from: b  reason: collision with root package name */
        private int f359b;

        /* renamed from: c  reason: collision with root package name */
        private long f360c;

        /* renamed from: d  reason: collision with root package name */
        private long f361d;

        /* renamed from: e  reason: collision with root package name */
        private float f362e;

        /* renamed from: f  reason: collision with root package name */
        private long f363f;

        /* renamed from: g  reason: collision with root package name */
        private int f364g;

        /* renamed from: h  reason: collision with root package name */
        private CharSequence f365h;

        /* renamed from: i  reason: collision with root package name */
        private long f366i;

        /* renamed from: j  reason: collision with root package name */
        private long f367j;

        /* renamed from: k  reason: collision with root package name */
        private Bundle f368k;

        public Builder() {
            this.f358a = new ArrayList();
            this.f367j = -1L;
        }

        public Builder addCustomAction(String str, String str2, int i4) {
            return addCustomAction(new CustomAction(str, str2, i4, null));
        }

        public PlaybackStateCompat build() {
            return new PlaybackStateCompat(this.f359b, this.f360c, this.f361d, this.f362e, this.f363f, this.f364g, this.f365h, this.f366i, this.f358a, this.f367j, this.f368k);
        }

        public Builder setActions(long j4) {
            this.f363f = j4;
            return this;
        }

        public Builder setActiveQueueItemId(long j4) {
            this.f367j = j4;
            return this;
        }

        public Builder setBufferedPosition(long j4) {
            this.f361d = j4;
            return this;
        }

        @Deprecated
        public Builder setErrorMessage(CharSequence charSequence) {
            this.f365h = charSequence;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.f368k = bundle;
            return this;
        }

        public Builder setState(int i4, long j4, float f4) {
            return setState(i4, j4, f4, SystemClock.elapsedRealtime());
        }

        public Builder addCustomAction(CustomAction customAction) {
            if (customAction != null) {
                this.f358a.add(customAction);
                return this;
            }
            throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat");
        }

        public Builder setErrorMessage(int i4, CharSequence charSequence) {
            this.f364g = i4;
            this.f365h = charSequence;
            return this;
        }

        public Builder setState(int i4, long j4, float f4, long j5) {
            this.f359b = i4;
            this.f360c = j4;
            this.f366i = j5;
            this.f362e = f4;
            return this;
        }

        public Builder(PlaybackStateCompat playbackStateCompat) {
            ArrayList arrayList = new ArrayList();
            this.f358a = arrayList;
            this.f367j = -1L;
            this.f359b = playbackStateCompat.f346a;
            this.f360c = playbackStateCompat.f347b;
            this.f362e = playbackStateCompat.f349d;
            this.f366i = playbackStateCompat.f353h;
            this.f361d = playbackStateCompat.f348c;
            this.f363f = playbackStateCompat.f350e;
            this.f364g = playbackStateCompat.f351f;
            this.f365h = playbackStateCompat.f352g;
            List<CustomAction> list = playbackStateCompat.f354i;
            if (list != null) {
                arrayList.addAll(list);
            }
            this.f367j = playbackStateCompat.f355j;
            this.f368k = playbackStateCompat.f356k;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface MediaKeyAction {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface RepeatMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ShuffleMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface State {
    }

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<PlaybackStateCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PlaybackStateCompat[] newArray(int i4) {
            return new PlaybackStateCompat[i4];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class b {
        @DoNotInline
        static void a(PlaybackState.Builder builder, PlaybackState.CustomAction customAction) {
            builder.addCustomAction(customAction);
        }

        @DoNotInline
        static PlaybackState.CustomAction b(PlaybackState.CustomAction.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        static PlaybackState c(PlaybackState.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        static PlaybackState.Builder d() {
            return new PlaybackState.Builder();
        }

        @DoNotInline
        static PlaybackState.CustomAction.Builder e(String str, CharSequence charSequence, int i4) {
            return new PlaybackState.CustomAction.Builder(str, charSequence, i4);
        }

        @DoNotInline
        static String f(PlaybackState.CustomAction customAction) {
            return customAction.getAction();
        }

        @DoNotInline
        static long g(PlaybackState playbackState) {
            return playbackState.getActions();
        }

        @DoNotInline
        static long h(PlaybackState playbackState) {
            return playbackState.getActiveQueueItemId();
        }

        @DoNotInline
        static long i(PlaybackState playbackState) {
            return playbackState.getBufferedPosition();
        }

        @DoNotInline
        static List<PlaybackState.CustomAction> j(PlaybackState playbackState) {
            return playbackState.getCustomActions();
        }

        @DoNotInline
        static CharSequence k(PlaybackState playbackState) {
            return playbackState.getErrorMessage();
        }

        @DoNotInline
        static Bundle l(PlaybackState.CustomAction customAction) {
            return customAction.getExtras();
        }

        @DoNotInline
        static int m(PlaybackState.CustomAction customAction) {
            return customAction.getIcon();
        }

        @DoNotInline
        static long n(PlaybackState playbackState) {
            return playbackState.getLastPositionUpdateTime();
        }

        @DoNotInline
        static CharSequence o(PlaybackState.CustomAction customAction) {
            return customAction.getName();
        }

        @DoNotInline
        static float p(PlaybackState playbackState) {
            return playbackState.getPlaybackSpeed();
        }

        @DoNotInline
        static long q(PlaybackState playbackState) {
            return playbackState.getPosition();
        }

        @DoNotInline
        static int r(PlaybackState playbackState) {
            return playbackState.getState();
        }

        @DoNotInline
        static void s(PlaybackState.Builder builder, long j4) {
            builder.setActions(j4);
        }

        @DoNotInline
        static void t(PlaybackState.Builder builder, long j4) {
            builder.setActiveQueueItemId(j4);
        }

        @DoNotInline
        static void u(PlaybackState.Builder builder, long j4) {
            builder.setBufferedPosition(j4);
        }

        @DoNotInline
        static void v(PlaybackState.Builder builder, CharSequence charSequence) {
            builder.setErrorMessage(charSequence);
        }

        @DoNotInline
        static void w(PlaybackState.CustomAction.Builder builder, Bundle bundle) {
            builder.setExtras(bundle);
        }

        @DoNotInline
        static void x(PlaybackState.Builder builder, int i4, long j4, float f4, long j5) {
            builder.setState(i4, j4, f4, j5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(22)
    /* loaded from: classes.dex */
    public static class c {
        @DoNotInline
        static Bundle a(PlaybackState playbackState) {
            Bundle extras;
            extras = playbackState.getExtras();
            return extras;
        }

        @DoNotInline
        static void b(PlaybackState.Builder builder, Bundle bundle) {
            builder.setExtras(bundle);
        }
    }

    PlaybackStateCompat(int i4, long j4, long j5, float f4, long j6, int i5, CharSequence charSequence, long j7, List<CustomAction> list, long j8, Bundle bundle) {
        this.f346a = i4;
        this.f347b = j4;
        this.f348c = j5;
        this.f349d = f4;
        this.f350e = j6;
        this.f351f = i5;
        this.f352g = charSequence;
        this.f353h = j7;
        this.f354i = new ArrayList(list);
        this.f355j = j8;
        this.f356k = bundle;
    }

    public static PlaybackStateCompat fromPlaybackState(Object obj) {
        ArrayList arrayList;
        Bundle bundle = null;
        if (obj == null) {
            return null;
        }
        PlaybackState playbackState = (PlaybackState) obj;
        List<PlaybackState.CustomAction> j4 = b.j(playbackState);
        if (j4 != null) {
            ArrayList arrayList2 = new ArrayList(j4.size());
            for (PlaybackState.CustomAction customAction : j4) {
                arrayList2.add(CustomAction.fromCustomAction(customAction));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            bundle = c.a(playbackState);
            MediaSessionCompat.ensureClassLoader(bundle);
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(b.r(playbackState), b.q(playbackState), b.i(playbackState), b.p(playbackState), b.g(playbackState), 0, b.k(playbackState), b.n(playbackState), arrayList, b.h(playbackState), bundle);
        playbackStateCompat.f357l = playbackState;
        return playbackStateCompat;
    }

    public static int toKeyCode(long j4) {
        if (j4 == 4) {
            return 126;
        }
        if (j4 == 2) {
            return 127;
        }
        if (j4 == 32) {
            return 87;
        }
        if (j4 == 16) {
            return 88;
        }
        if (j4 == 1) {
            return 86;
        }
        if (j4 == 64) {
            return 90;
        }
        if (j4 == 8) {
            return 89;
        }
        if (j4 == 512) {
            return 85;
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getActions() {
        return this.f350e;
    }

    public long getActiveQueueItemId() {
        return this.f355j;
    }

    public long getBufferedPosition() {
        return this.f348c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public long getCurrentPosition(Long l4) {
        long elapsedRealtime;
        long j4 = this.f347b;
        float f4 = this.f349d;
        if (l4 != null) {
            elapsedRealtime = l4.longValue();
        } else {
            elapsedRealtime = SystemClock.elapsedRealtime() - this.f353h;
        }
        return Math.max(0L, j4 + (f4 * ((float) elapsedRealtime)));
    }

    public List<CustomAction> getCustomActions() {
        return this.f354i;
    }

    public int getErrorCode() {
        return this.f351f;
    }

    public CharSequence getErrorMessage() {
        return this.f352g;
    }

    @Nullable
    public Bundle getExtras() {
        return this.f356k;
    }

    public long getLastPositionUpdateTime() {
        return this.f353h;
    }

    public float getPlaybackSpeed() {
        return this.f349d;
    }

    public Object getPlaybackState() {
        if (this.f357l == null) {
            PlaybackState.Builder d4 = b.d();
            b.x(d4, this.f346a, this.f347b, this.f349d, this.f353h);
            b.u(d4, this.f348c);
            b.s(d4, this.f350e);
            b.v(d4, this.f352g);
            for (CustomAction customAction : this.f354i) {
                b.a(d4, (PlaybackState.CustomAction) customAction.getCustomAction());
            }
            b.t(d4, this.f355j);
            if (Build.VERSION.SDK_INT >= 22) {
                c.b(d4, this.f356k);
            }
            this.f357l = b.c(d4);
        }
        return this.f357l;
    }

    public long getPosition() {
        return this.f347b;
    }

    public int getState() {
        return this.f346a;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f346a + ", position=" + this.f347b + ", buffered position=" + this.f348c + ", speed=" + this.f349d + ", updated=" + this.f353h + ", actions=" + this.f350e + ", error code=" + this.f351f + ", error message=" + this.f352g + ", custom actions=" + this.f354i + ", active item id=" + this.f355j + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f346a);
        parcel.writeLong(this.f347b);
        parcel.writeFloat(this.f349d);
        parcel.writeLong(this.f353h);
        parcel.writeLong(this.f348c);
        parcel.writeLong(this.f350e);
        TextUtils.writeToParcel(this.f352g, parcel, i4);
        parcel.writeTypedList(this.f354i);
        parcel.writeLong(this.f355j);
        parcel.writeBundle(this.f356k);
        parcel.writeInt(this.f351f);
    }

    /* loaded from: classes.dex */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final String f369a;

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f370b;

        /* renamed from: c  reason: collision with root package name */
        private final int f371c;

        /* renamed from: d  reason: collision with root package name */
        private final Bundle f372d;

        /* renamed from: e  reason: collision with root package name */
        private PlaybackState.CustomAction f373e;

        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            private final String f374a;

            /* renamed from: b  reason: collision with root package name */
            private final CharSequence f375b;

            /* renamed from: c  reason: collision with root package name */
            private final int f376c;

            /* renamed from: d  reason: collision with root package name */
            private Bundle f377d;

            public Builder(String str, CharSequence charSequence, int i4) {
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(charSequence)) {
                        if (i4 != 0) {
                            this.f374a = str;
                            this.f375b = charSequence;
                            this.f376c = i4;
                            return;
                        }
                        throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction");
                    }
                    throw new IllegalArgumentException("You must specify a name to build a CustomAction");
                }
                throw new IllegalArgumentException("You must specify an action to build a CustomAction");
            }

            public CustomAction build() {
                return new CustomAction(this.f374a, this.f375b, this.f376c, this.f377d);
            }

            public Builder setExtras(Bundle bundle) {
                this.f377d = bundle;
                return this;
            }
        }

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<CustomAction> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public CustomAction[] newArray(int i4) {
                return new CustomAction[i4];
            }
        }

        CustomAction(String str, CharSequence charSequence, int i4, Bundle bundle) {
            this.f369a = str;
            this.f370b = charSequence;
            this.f371c = i4;
            this.f372d = bundle;
        }

        public static CustomAction fromCustomAction(Object obj) {
            if (obj != null) {
                PlaybackState.CustomAction customAction = (PlaybackState.CustomAction) obj;
                Bundle l4 = b.l(customAction);
                MediaSessionCompat.ensureClassLoader(l4);
                CustomAction customAction2 = new CustomAction(b.f(customAction), b.o(customAction), b.m(customAction), l4);
                customAction2.f373e = customAction;
                return customAction2;
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAction() {
            return this.f369a;
        }

        public Object getCustomAction() {
            PlaybackState.CustomAction customAction = this.f373e;
            if (customAction == null) {
                PlaybackState.CustomAction.Builder e4 = b.e(this.f369a, this.f370b, this.f371c);
                b.w(e4, this.f372d);
                return b.b(e4);
            }
            return customAction;
        }

        public Bundle getExtras() {
            return this.f372d;
        }

        public int getIcon() {
            return this.f371c;
        }

        public CharSequence getName() {
            return this.f370b;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f370b) + ", mIcon=" + this.f371c + ", mExtras=" + this.f372d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeString(this.f369a);
            TextUtils.writeToParcel(this.f370b, parcel, i4);
            parcel.writeInt(this.f371c);
            parcel.writeBundle(this.f372d);
        }

        CustomAction(Parcel parcel) {
            this.f369a = parcel.readString();
            this.f370b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f371c = parcel.readInt();
            this.f372d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f346a = parcel.readInt();
        this.f347b = parcel.readLong();
        this.f349d = parcel.readFloat();
        this.f353h = parcel.readLong();
        this.f348c = parcel.readLong();
        this.f350e = parcel.readLong();
        this.f352g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f354i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f355j = parcel.readLong();
        this.f356k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f351f = parcel.readInt();
    }
}
