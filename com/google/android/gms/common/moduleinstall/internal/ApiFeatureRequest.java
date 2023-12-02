package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.moduleinstall.ModuleInstallRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@KeepForSdk
@SafeParcelable.Class(creator = "ApiFeatureRequestCreator")
/* loaded from: classes4.dex */
public class ApiFeatureRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ApiFeatureRequest> CREATOR = new zac();

    /* renamed from: e  reason: collision with root package name */
    private static final Comparator f20618e = new Comparator() { // from class: com.google.android.gms.common.moduleinstall.internal.zab
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            Feature feature = (Feature) obj;
            Feature feature2 = (Feature) obj2;
            Parcelable.Creator<ApiFeatureRequest> creator = ApiFeatureRequest.CREATOR;
            if (!feature.getName().equals(feature2.getName())) {
                return feature.getName().compareTo(feature2.getName());
            }
            return (feature.getVersion() > feature2.getVersion() ? 1 : (feature.getVersion() == feature2.getVersion() ? 0 : -1));
        }
    };
    @SafeParcelable.Field(getter = "getApiFeatures", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final List f20619a;
    @SafeParcelable.Field(getter = "getIsUrgent", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final boolean f20620b;
    @Nullable
    @SafeParcelable.Field(getter = "getFeatureRequestSessionId", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f20621c;
    @Nullable
    @SafeParcelable.Field(getter = "getCallingPackage", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final String f20622d;

    @SafeParcelable.Constructor
    public ApiFeatureRequest(@NonNull @SafeParcelable.Param(id = 1) List list, @SafeParcelable.Param(id = 2) boolean z3, @Nullable @SafeParcelable.Param(id = 3) String str, @Nullable @SafeParcelable.Param(id = 4) String str2) {
        Preconditions.checkNotNull(list);
        this.f20619a = list;
        this.f20620b = z3;
        this.f20621c = str;
        this.f20622d = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ApiFeatureRequest b(List list, boolean z3) {
        TreeSet treeSet = new TreeSet(f20618e);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Collections.addAll(treeSet, ((OptionalModuleApi) it.next()).getOptionalFeatures());
        }
        return new ApiFeatureRequest(new ArrayList(treeSet), z3, null, null);
    }

    @NonNull
    @KeepForSdk
    public static ApiFeatureRequest fromModuleInstallRequest(@NonNull ModuleInstallRequest moduleInstallRequest) {
        return b(moduleInstallRequest.getApis(), true);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof ApiFeatureRequest)) {
            return false;
        }
        ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) obj;
        if (this.f20620b != apiFeatureRequest.f20620b || !Objects.equal(this.f20619a, apiFeatureRequest.f20619a) || !Objects.equal(this.f20621c, apiFeatureRequest.f20621c) || !Objects.equal(this.f20622d, apiFeatureRequest.f20622d)) {
            return false;
        }
        return true;
    }

    @NonNull
    @KeepForSdk
    public List<Feature> getApiFeatures() {
        return this.f20619a;
    }

    public final int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.f20620b), this.f20619a, this.f20621c, this.f20622d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getApiFeatures(), false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f20620b);
        SafeParcelWriter.writeString(parcel, 3, this.f20621c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f20622d, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
