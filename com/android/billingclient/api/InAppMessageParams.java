package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
@zzf
/* loaded from: classes2.dex */
public final class InAppMessageParams {
    private final ArrayList<Integer> mInAppMessageCategories;

    /* compiled from: com.android.billingclient:billing@@5.2.0 */
    @zzf
    /* loaded from: classes2.dex */
    public static final class Builder {
        private final Set<Integer> mInAppMessageCategories = new HashSet();

        @NonNull
        public Builder addAllInAppMessageCategoriesToShow() {
            this.mInAppMessageCategories.add(2);
            return this;
        }

        @NonNull
        public Builder addInAppMessageCategoryToShow(int i4) {
            this.mInAppMessageCategories.add(Integer.valueOf(i4));
            return this;
        }

        @NonNull
        public InAppMessageParams build() {
            return new InAppMessageParams(this.mInAppMessageCategories);
        }
    }

    /* compiled from: com.android.billingclient:billing@@5.2.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface InAppMessageCategoryId {
        @zzf
        public static final int TRANSACTIONAL = 2;
        @zzf
        public static final int UNKNOWN_IN_APP_MESSAGE_CATEGORY_ID = 0;
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<Integer> getInAppMessageCategoriesToShow() {
        return this.mInAppMessageCategories;
    }

    private InAppMessageParams(Set<Integer> set) {
        this.mInAppMessageCategories = new ArrayList<>(Collections.unmodifiableList(new ArrayList(set)));
    }
}
