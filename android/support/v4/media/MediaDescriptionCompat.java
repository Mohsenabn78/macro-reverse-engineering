package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final long BT_FOLDER_TYPE_ALBUMS = 2;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3;
    public static final long BT_FOLDER_TYPE_GENRES = 4;
    public static final long BT_FOLDER_TYPE_MIXED = 0;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5;
    public static final long BT_FOLDER_TYPE_TITLES = 1;
    public static final long BT_FOLDER_TYPE_YEARS = 6;
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2;
    public static final long STATUS_DOWNLOADING = 1;
    public static final long STATUS_NOT_DOWNLOADED = 0;

    /* renamed from: a  reason: collision with root package name */
    private final String f255a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f256b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f257c;

    /* renamed from: d  reason: collision with root package name */
    private final CharSequence f258d;

    /* renamed from: e  reason: collision with root package name */
    private final Bitmap f259e;

    /* renamed from: f  reason: collision with root package name */
    private final Uri f260f;

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f261g;

    /* renamed from: h  reason: collision with root package name */
    private final Uri f262h;

    /* renamed from: i  reason: collision with root package name */
    private MediaDescription f263i;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f264a;

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f265b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f266c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f267d;

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f268e;

        /* renamed from: f  reason: collision with root package name */
        private Uri f269f;

        /* renamed from: g  reason: collision with root package name */
        private Bundle f270g;

        /* renamed from: h  reason: collision with root package name */
        private Uri f271h;

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.f264a, this.f265b, this.f266c, this.f267d, this.f268e, this.f269f, this.f270g, this.f271h);
        }

        public Builder setDescription(@Nullable CharSequence charSequence) {
            this.f267d = charSequence;
            return this;
        }

        public Builder setExtras(@Nullable Bundle bundle) {
            this.f270g = bundle;
            return this;
        }

        public Builder setIconBitmap(@Nullable Bitmap bitmap) {
            this.f268e = bitmap;
            return this;
        }

        public Builder setIconUri(@Nullable Uri uri) {
            this.f269f = uri;
            return this;
        }

        public Builder setMediaId(@Nullable String str) {
            this.f264a = str;
            return this;
        }

        public Builder setMediaUri(@Nullable Uri uri) {
            this.f271h = uri;
            return this;
        }

        public Builder setSubtitle(@Nullable CharSequence charSequence) {
            this.f266c = charSequence;
            return this;
        }

        public Builder setTitle(@Nullable CharSequence charSequence) {
            this.f265b = charSequence;
            return this;
        }
    }

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<MediaDescriptionCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.fromMediaDescription(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MediaDescriptionCompat[] newArray(int i4) {
            return new MediaDescriptionCompat[i4];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class b {
        @DoNotInline
        static MediaDescription a(MediaDescription.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        static MediaDescription.Builder b() {
            return new MediaDescription.Builder();
        }

        @Nullable
        @DoNotInline
        static CharSequence c(MediaDescription mediaDescription) {
            return mediaDescription.getDescription();
        }

        @Nullable
        @DoNotInline
        static Bundle d(MediaDescription mediaDescription) {
            return mediaDescription.getExtras();
        }

        @Nullable
        @DoNotInline
        static Bitmap e(MediaDescription mediaDescription) {
            return mediaDescription.getIconBitmap();
        }

        @Nullable
        @DoNotInline
        static Uri f(MediaDescription mediaDescription) {
            return mediaDescription.getIconUri();
        }

        @Nullable
        @DoNotInline
        static String g(MediaDescription mediaDescription) {
            return mediaDescription.getMediaId();
        }

        @Nullable
        @DoNotInline
        static CharSequence h(MediaDescription mediaDescription) {
            return mediaDescription.getSubtitle();
        }

        @Nullable
        @DoNotInline
        static CharSequence i(MediaDescription mediaDescription) {
            return mediaDescription.getTitle();
        }

        @DoNotInline
        static void j(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
            builder.setDescription(charSequence);
        }

        @DoNotInline
        static void k(MediaDescription.Builder builder, @Nullable Bundle bundle) {
            builder.setExtras(bundle);
        }

        @DoNotInline
        static void l(MediaDescription.Builder builder, @Nullable Bitmap bitmap) {
            builder.setIconBitmap(bitmap);
        }

        @DoNotInline
        static void m(MediaDescription.Builder builder, @Nullable Uri uri) {
            builder.setIconUri(uri);
        }

        @DoNotInline
        static void n(MediaDescription.Builder builder, @Nullable String str) {
            builder.setMediaId(str);
        }

        @DoNotInline
        static void o(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
            builder.setSubtitle(charSequence);
        }

        @DoNotInline
        static void p(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
            builder.setTitle(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(23)
    /* loaded from: classes.dex */
    public static class c {
        @Nullable
        @DoNotInline
        static Uri a(MediaDescription mediaDescription) {
            Uri mediaUri;
            mediaUri = mediaDescription.getMediaUri();
            return mediaUri;
        }

        @DoNotInline
        static void b(MediaDescription.Builder builder, @Nullable Uri uri) {
            builder.setMediaUri(uri);
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f255a = str;
        this.f256b = charSequence;
        this.f257c = charSequence2;
        this.f258d = charSequence3;
        this.f259e = bitmap;
        this.f260f = uri;
        this.f261g = bundle;
        this.f262h = uri2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.support.v4.media.MediaDescriptionCompat fromMediaDescription(java.lang.Object r9) {
        /*
            r0 = 0
            if (r9 == 0) goto L7f
            int r1 = android.os.Build.VERSION.SDK_INT
            android.support.v4.media.MediaDescriptionCompat$Builder r2 = new android.support.v4.media.MediaDescriptionCompat$Builder
            r2.<init>()
            android.media.MediaDescription r9 = (android.media.MediaDescription) r9
            java.lang.String r3 = android.support.v4.media.MediaDescriptionCompat.b.g(r9)
            r2.setMediaId(r3)
            java.lang.CharSequence r3 = android.support.v4.media.MediaDescriptionCompat.b.i(r9)
            r2.setTitle(r3)
            java.lang.CharSequence r3 = android.support.v4.media.MediaDescriptionCompat.b.h(r9)
            r2.setSubtitle(r3)
            java.lang.CharSequence r3 = android.support.v4.media.MediaDescriptionCompat.b.c(r9)
            r2.setDescription(r3)
            android.graphics.Bitmap r3 = android.support.v4.media.MediaDescriptionCompat.b.e(r9)
            r2.setIconBitmap(r3)
            android.net.Uri r3 = android.support.v4.media.MediaDescriptionCompat.b.f(r9)
            r2.setIconUri(r3)
            android.os.Bundle r3 = android.support.v4.media.MediaDescriptionCompat.b.d(r9)
            if (r3 == 0) goto L40
            android.os.Bundle r3 = android.support.v4.media.session.MediaSessionCompat.unparcelWithClassLoader(r3)
        L40:
            java.lang.String r4 = "android.support.v4.media.description.MEDIA_URI"
            if (r3 == 0) goto L4b
            android.os.Parcelable r5 = r3.getParcelable(r4)
            android.net.Uri r5 = (android.net.Uri) r5
            goto L4c
        L4b:
            r5 = r0
        L4c:
            if (r5 == 0) goto L64
            java.lang.String r6 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r7 = r3.containsKey(r6)
            if (r7 == 0) goto L5e
            int r7 = r3.size()
            r8 = 2
            if (r7 != r8) goto L5e
            goto L65
        L5e:
            r3.remove(r4)
            r3.remove(r6)
        L64:
            r0 = r3
        L65:
            r2.setExtras(r0)
            if (r5 == 0) goto L6e
            r2.setMediaUri(r5)
            goto L79
        L6e:
            r0 = 23
            if (r1 < r0) goto L79
            android.net.Uri r0 = android.support.v4.media.MediaDescriptionCompat.c.a(r9)
            r2.setMediaUri(r0)
        L79:
            android.support.v4.media.MediaDescriptionCompat r0 = r2.build()
            r0.f263i = r9
        L7f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.fromMediaDescription(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public CharSequence getDescription() {
        return this.f258d;
    }

    @Nullable
    public Bundle getExtras() {
        return this.f261g;
    }

    @Nullable
    public Bitmap getIconBitmap() {
        return this.f259e;
    }

    @Nullable
    public Uri getIconUri() {
        return this.f260f;
    }

    public Object getMediaDescription() {
        Bundle bundle;
        MediaDescription mediaDescription = this.f263i;
        if (mediaDescription == null) {
            int i4 = Build.VERSION.SDK_INT;
            MediaDescription.Builder b4 = b.b();
            b.n(b4, this.f255a);
            b.p(b4, this.f256b);
            b.o(b4, this.f257c);
            b.j(b4, this.f258d);
            b.l(b4, this.f259e);
            b.m(b4, this.f260f);
            if (i4 < 23 && this.f262h != null) {
                if (this.f261g == null) {
                    bundle = new Bundle();
                    bundle.putBoolean(DESCRIPTION_KEY_NULL_BUNDLE_FLAG, true);
                } else {
                    bundle = new Bundle(this.f261g);
                }
                bundle.putParcelable(DESCRIPTION_KEY_MEDIA_URI, this.f262h);
                b.k(b4, bundle);
            } else {
                b.k(b4, this.f261g);
            }
            if (i4 >= 23) {
                c.b(b4, this.f262h);
            }
            MediaDescription a4 = b.a(b4);
            this.f263i = a4;
            return a4;
        }
        return mediaDescription;
    }

    @Nullable
    public String getMediaId() {
        return this.f255a;
    }

    @Nullable
    public Uri getMediaUri() {
        return this.f262h;
    }

    @Nullable
    public CharSequence getSubtitle() {
        return this.f257c;
    }

    @Nullable
    public CharSequence getTitle() {
        return this.f256b;
    }

    public String toString() {
        return ((Object) this.f256b) + ", " + ((Object) this.f257c) + ", " + ((Object) this.f258d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        ((MediaDescription) getMediaDescription()).writeToParcel(parcel, i4);
    }
}
