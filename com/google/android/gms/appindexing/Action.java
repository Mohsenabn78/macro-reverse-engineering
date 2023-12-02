package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
@VisibleForTesting
@Deprecated
/* loaded from: classes4.dex */
public final class Action extends Thing {
    @NonNull
    public static final String STATUS_TYPE_ACTIVE = "http://schema.org/ActiveActionStatus";
    @NonNull
    public static final String STATUS_TYPE_COMPLETED = "http://schema.org/CompletedActionStatus";
    @NonNull
    public static final String STATUS_TYPE_FAILED = "http://schema.org/FailedActionStatus";
    @NonNull
    public static final String TYPE_ACTIVATE = "http://schema.org/ActivateAction";
    @NonNull
    public static final String TYPE_ADD = "http://schema.org/AddAction";
    @NonNull
    public static final String TYPE_BOOKMARK = "http://schema.org/BookmarkAction";
    @NonNull
    public static final String TYPE_COMMUNICATE = "http://schema.org/CommunicateAction";
    @NonNull
    public static final String TYPE_FILM = "http://schema.org/FilmAction";
    @NonNull
    public static final String TYPE_LIKE = "http://schema.org/LikeAction";
    @NonNull
    public static final String TYPE_LISTEN = "http://schema.org/ListenAction";
    @NonNull
    public static final String TYPE_PHOTOGRAPH = "http://schema.org/PhotographAction";
    @NonNull
    public static final String TYPE_RESERVE = "http://schema.org/ReserveAction";
    @NonNull
    public static final String TYPE_SEARCH = "http://schema.org/SearchAction";
    @NonNull
    public static final String TYPE_VIEW = "http://schema.org/ViewAction";
    @NonNull
    public static final String TYPE_WANT = "http://schema.org/WantAction";
    @NonNull
    public static final String TYPE_WATCH = "http://schema.org/WatchAction";

    /* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public static final class Builder extends Thing.Builder {
        public Builder(@NonNull String str) {
            Preconditions.checkNotNull(str);
            super.put("type", str);
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        @NonNull
        public Action build() {
            Preconditions.checkNotNull(this.f19593a.get("object"), "setObject is required before calling build().");
            Preconditions.checkNotNull(this.f19593a.get("type"), "setType is required before calling build().");
            Bundle bundle = (Bundle) this.f19593a.getParcelable("object");
            if (bundle != null) {
                Preconditions.checkNotNull(bundle.get("name"), "Must call setObject() with a valid name. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
                Preconditions.checkNotNull(bundle.get(ImagesContract.URL), "Must call setObject() with a valid app URI. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
            }
            return new Action(this.f19593a, null);
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        @NonNull
        public Builder put(@NonNull String str, @NonNull Thing thing) {
            super.put(str, thing);
            return this;
        }

        @NonNull
        public Builder setActionStatus(@NonNull String str) {
            Preconditions.checkNotNull(str);
            super.put("actionStatus", str);
            return this;
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        @NonNull
        public Builder setName(@NonNull String str) {
            super.put("name", str);
            return this;
        }

        @NonNull
        public Builder setObject(@NonNull Thing thing) {
            Preconditions.checkNotNull(thing);
            super.put("object", thing);
            return this;
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        @NonNull
        public Builder setUrl(@NonNull Uri uri) {
            if (uri != null) {
                super.put(ImagesContract.URL, uri.toString());
            }
            return this;
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        @NonNull
        public final /* bridge */ /* synthetic */ Thing.Builder put(@NonNull String str, @NonNull Thing thing) {
            put(str, thing);
            return this;
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        @NonNull
        public final /* bridge */ /* synthetic */ Thing.Builder setName(@NonNull String str) {
            setName(str);
            return this;
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        @NonNull
        public final /* bridge */ /* synthetic */ Thing.Builder setUrl(@NonNull Uri uri) {
            setUrl(uri);
            return this;
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        @NonNull
        public Builder put(@NonNull String str, @NonNull String str2) {
            super.put(str, str2);
            return this;
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        @NonNull
        public final /* bridge */ /* synthetic */ Thing.Builder put(@NonNull String str, @NonNull String str2) {
            put(str, str2);
            return this;
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        @NonNull
        public Builder put(@NonNull String str, boolean z3) {
            super.put(str, z3);
            return this;
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        @NonNull
        public final /* bridge */ /* synthetic */ Thing.Builder put(@NonNull String str, boolean z3) {
            put(str, z3);
            return this;
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        @NonNull
        public Builder put(@NonNull String str, @NonNull Thing[] thingArr) {
            super.put(str, thingArr);
            return this;
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        @NonNull
        public final /* bridge */ /* synthetic */ Thing.Builder put(@NonNull String str, @NonNull Thing[] thingArr) {
            put(str, thingArr);
            return this;
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        @NonNull
        public Builder put(@NonNull String str, @NonNull String[] strArr) {
            super.put(str, strArr);
            return this;
        }

        @Override // com.google.android.gms.appindexing.Thing.Builder
        @NonNull
        public final /* bridge */ /* synthetic */ Thing.Builder put(@NonNull String str, @NonNull String[] strArr) {
            put(str, strArr);
            return this;
        }
    }

    /* synthetic */ Action(Bundle bundle, zza zzaVar) {
        super(bundle);
    }

    @NonNull
    public static Action newAction(@NonNull String str, @NonNull String str2, @NonNull Uri uri) {
        return newAction(str, str2, null, uri);
    }

    @NonNull
    public static Action newAction(@NonNull String str, @NonNull String str2, @NonNull Uri uri, @NonNull Uri uri2) {
        Builder builder = new Builder(str);
        Thing.Builder builder2 = new Thing.Builder();
        builder2.setName(str2);
        builder2.setId(uri == null ? null : uri.toString());
        builder2.setUrl(uri2);
        builder.setObject(builder2.build());
        return builder.build();
    }
}
