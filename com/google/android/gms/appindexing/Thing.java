package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
@VisibleForTesting
@Deprecated
/* loaded from: classes4.dex */
public class Thing {

    /* renamed from: a  reason: collision with root package name */
    final Bundle f19592a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Thing(Bundle bundle) {
        this.f19592a = bundle;
    }

    @NonNull
    public final Bundle zza() {
        return this.f19592a;
    }

    /* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
    @VisibleForTesting
    @Deprecated
    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        final Bundle f19593a = new Bundle();

        @NonNull
        public Thing build() {
            return new Thing(this.f19593a);
        }

        @NonNull
        public Builder put(@NonNull String str, @NonNull Thing thing) {
            Preconditions.checkNotNull(str);
            if (thing != null) {
                this.f19593a.putParcelable(str, thing.f19592a);
            }
            return this;
        }

        @NonNull
        public Builder setDescription(@NonNull String str) {
            put("description", str);
            return this;
        }

        @NonNull
        public Builder setId(@NonNull String str) {
            if (str != null) {
                put("id", str);
            }
            return this;
        }

        @NonNull
        public Builder setName(@NonNull String str) {
            Preconditions.checkNotNull(str);
            put("name", str);
            return this;
        }

        @NonNull
        public Builder setType(@NonNull String str) {
            put("type", str);
            return this;
        }

        @NonNull
        public Builder setUrl(@NonNull Uri uri) {
            Preconditions.checkNotNull(uri);
            put(ImagesContract.URL, uri.toString());
            return this;
        }

        @NonNull
        public Builder put(@NonNull String str, @NonNull String str2) {
            Preconditions.checkNotNull(str);
            if (str2 != null) {
                this.f19593a.putString(str, str2);
            }
            return this;
        }

        @NonNull
        public Builder put(@NonNull String str, boolean z3) {
            Preconditions.checkNotNull(str);
            this.f19593a.putBoolean(str, z3);
            return this;
        }

        @NonNull
        public Builder put(@NonNull String str, @NonNull Thing[] thingArr) {
            Preconditions.checkNotNull(str);
            if (thingArr != null) {
                ArrayList arrayList = new ArrayList();
                for (Thing thing : thingArr) {
                    if (thing != null) {
                        arrayList.add(thing.f19592a);
                    }
                }
                this.f19593a.putParcelableArray(str, (Parcelable[]) arrayList.toArray(new Bundle[arrayList.size()]));
            }
            return this;
        }

        @NonNull
        public Builder put(@NonNull String str, @NonNull String[] strArr) {
            Preconditions.checkNotNull(str);
            if (strArr != null) {
                this.f19593a.putStringArray(str, strArr);
            }
            return this;
        }
    }
}
