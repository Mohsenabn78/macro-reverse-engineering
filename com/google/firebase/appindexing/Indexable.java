package com.google.firebase.appindexing;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.icing.zzfw;
import com.google.firebase.appindexing.builders.IndexableBuilder;
import com.google.firebase.appindexing.internal.zzac;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public interface Indexable {
    public static final int MAX_BYTE_SIZE = 30000;
    public static final int MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL = 1000;
    public static final int MAX_NESTING_DEPTH = 5;
    public static final int MAX_NUMBER_OF_FIELDS = 20;
    public static final int MAX_REPEATED_SIZE = 100;
    public static final int MAX_STRING_LENGTH = 20000;
    public static final int MAX_URL_LENGTH = 256;

    /* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
    /* loaded from: classes5.dex */
    public static class Builder extends IndexableBuilder<Builder> {
        public Builder() {
            this("Thing");
        }

        public Builder(@NonNull String str) {
            super(str);
        }
    }

    /* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
    /* loaded from: classes5.dex */
    public interface Metadata {

        /* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
        /* loaded from: classes5.dex */
        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            private boolean f28787a = zzfw.zzd().zza();

            /* renamed from: b  reason: collision with root package name */
            private int f28788b = zzfw.zzd().zzb();

            /* renamed from: c  reason: collision with root package name */
            private String f28789c = zzfw.zzd().zzc();

            /* renamed from: d  reason: collision with root package name */
            private final Bundle f28790d = new Bundle();

            @NonNull
            public Builder setScope(int i4) {
                boolean z3;
                if (i4 > 0 && i4 <= 3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                StringBuilder sb = new StringBuilder(69);
                sb.append("The scope of this indexable is not valid, scope value is ");
                sb.append(i4);
                sb.append(".");
                Preconditions.checkArgument(z3, sb.toString());
                IndexableBuilder.zzd(this.f28790d, "scope", i4);
                return this;
            }

            @NonNull
            public Builder setScore(int i4) {
                boolean z3;
                if (i4 >= 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                StringBuilder sb = new StringBuilder(53);
                sb.append("Negative score values are invalid. Value: ");
                sb.append(i4);
                Preconditions.checkArgument(z3, sb.toString());
                this.f28788b = i4;
                return this;
            }

            @NonNull
            public Builder setSliceUri(@NonNull Uri uri) {
                Preconditions.checkNotNull(uri);
                IndexableBuilder.zza(this.f28790d, "sliceUri", uri.toString());
                return this;
            }

            @NonNull
            public Builder setWorksOffline(boolean z3) {
                this.f28787a = z3;
                return this;
            }

            public final zzac zza() {
                return new zzac(this.f28787a, this.f28788b, this.f28789c, this.f28790d, null);
            }
        }
    }
}
