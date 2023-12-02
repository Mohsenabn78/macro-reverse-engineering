package com.google.firebase.appindexing;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.appindexing.builders.IndexableBuilder;
import com.google.firebase.appindexing.internal.zzc;
import com.google.firebase.appindexing.internal.zzw;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public interface Action {

    /* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
    /* loaded from: classes5.dex */
    public interface Metadata {

        /* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
        /* loaded from: classes5.dex */
        public static class Builder {

            /* renamed from: a  reason: collision with root package name */
            private boolean f28783a = true;

            @NonNull
            public Builder setUpload(boolean z3) {
                this.f28783a = z3;
                return this;
            }

            public final com.google.firebase.appindexing.internal.zzb zza() {
                return new com.google.firebase.appindexing.internal.zzb(this.f28783a, null, null, null, false);
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
    /* loaded from: classes5.dex */
    public static class Builder {
        @NonNull
        public static final String ACTIVATE_ACTION = "ActivateAction";
        @NonNull
        public static final String ADD_ACTION = "AddAction";
        @NonNull
        public static final String BOOKMARK_ACTION = "BookmarkAction";
        @NonNull
        public static final String COMMENT_ACTION = "CommentAction";
        @NonNull
        public static final String LIKE_ACTION = "LikeAction";
        @NonNull
        public static final String LISTEN_ACTION = "ListenAction";
        @NonNull
        public static final String SEND_ACTION = "SendAction";
        @NonNull
        public static final String SHARE_ACTION = "ShareAction";
        @NonNull
        public static final String STATUS_TYPE_ACTIVE = "http://schema.org/ActiveActionStatus";
        @NonNull
        public static final String STATUS_TYPE_COMPLETED = "http://schema.org/CompletedActionStatus";
        @NonNull
        public static final String STATUS_TYPE_FAILED = "http://schema.org/FailedActionStatus";
        @NonNull
        public static final String VIEW_ACTION = "ViewAction";
        @NonNull
        public static final String WATCH_ACTION = "WatchAction";

        /* renamed from: a  reason: collision with root package name */
        private final Bundle f28776a = new Bundle();

        /* renamed from: b  reason: collision with root package name */
        private final String f28777b;

        /* renamed from: c  reason: collision with root package name */
        private String f28778c;

        /* renamed from: d  reason: collision with root package name */
        private String f28779d;

        /* renamed from: e  reason: collision with root package name */
        private String f28780e;

        /* renamed from: f  reason: collision with root package name */
        private com.google.firebase.appindexing.internal.zzb f28781f;

        /* renamed from: g  reason: collision with root package name */
        private String f28782g;

        public Builder(@NonNull String str) {
            this.f28777b = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @NonNull
        public final String a() {
            String str = this.f28778c;
            if (str == null) {
                return null;
            }
            return new String(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @NonNull
        public final String b() {
            String str = this.f28779d;
            if (str == null) {
                return null;
            }
            return new String(str);
        }

        @NonNull
        public Action build() {
            Preconditions.checkNotNull(this.f28778c, "setObject is required before calling build().");
            Preconditions.checkNotNull(this.f28779d, "setObject is required before calling build().");
            String str = this.f28777b;
            String str2 = this.f28778c;
            String str3 = this.f28779d;
            String str4 = this.f28780e;
            com.google.firebase.appindexing.internal.zzb zzbVar = this.f28781f;
            if (zzbVar == null) {
                zzbVar = new Metadata.Builder().zza();
            }
            return new zzc(str, str2, str3, str4, zzbVar, this.f28782g, this.f28776a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @NonNull
        public final String c() {
            return new String(this.f28782g);
        }

        @NonNull
        public Builder put(@NonNull String str, @NonNull double... dArr) {
            Bundle bundle = this.f28776a;
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(dArr);
            int length = dArr.length;
            if (length > 0) {
                if (length >= 100) {
                    zzw.zza("Input Array of elements is too big, cutting off.");
                    dArr = Arrays.copyOf(dArr, 100);
                }
                bundle.putDoubleArray(str, dArr);
            } else {
                zzw.zza("Double array is empty and is ignored by put method.");
            }
            return this;
        }

        @NonNull
        public Builder setActionStatus(@NonNull String str) {
            Preconditions.checkNotNull(str);
            this.f28782g = str;
            return this;
        }

        @NonNull
        public Builder setMetadata(@NonNull Metadata.Builder builder) {
            Preconditions.checkNotNull(builder);
            this.f28781f = builder.zza();
            return this;
        }

        @NonNull
        public final Builder setName(@NonNull String str) {
            Preconditions.checkNotNull(str);
            this.f28778c = str;
            return put("name", str);
        }

        @NonNull
        public Builder setObject(@NonNull String str, @NonNull String str2) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(str2);
            this.f28778c = str;
            this.f28779d = str2;
            return this;
        }

        @NonNull
        public Builder setResult(@NonNull Indexable... indexableArr) throws FirebaseAppIndexingInvalidArgumentException {
            return put("result", indexableArr);
        }

        @NonNull
        public final Builder setUrl(@NonNull String str) {
            Preconditions.checkNotNull(str);
            this.f28779d = str;
            return put(ImagesContract.URL, str);
        }

        @NonNull
        public Builder setObject(@NonNull String str, @NonNull String str2, @NonNull String str3) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(str2);
            Preconditions.checkNotNull(str3);
            this.f28778c = str;
            this.f28779d = str2;
            this.f28780e = str3;
            return this;
        }

        @NonNull
        public Builder put(@NonNull String str, @NonNull long... jArr) {
            IndexableBuilder.zzd(this.f28776a, str, jArr);
            return this;
        }

        @NonNull
        public Builder put(@NonNull String str, @NonNull Indexable... indexableArr) throws FirebaseAppIndexingInvalidArgumentException {
            IndexableBuilder.zzb(this.f28776a, str, indexableArr);
            return this;
        }

        @NonNull
        public Builder put(@NonNull String str, @NonNull String... strArr) {
            IndexableBuilder.zza(this.f28776a, str, strArr);
            return this;
        }

        @NonNull
        public Builder put(@NonNull String str, @NonNull boolean... zArr) {
            IndexableBuilder.zzc(this.f28776a, str, zArr);
            return this;
        }
    }
}
