package com.arlosoft.macrodroid.freeversion;

import android.content.res.Resources;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.freeversion.datapartners.DataAiDataPartner;
import com.arlosoft.macrodroid.freeversion.datapartners.DataPartner;
import com.arlosoft.macrodroid.freeversion.datapartners.EmptyDataPartner;
import com.arlosoft.macrodroid.freeversion.datapartners.HuqDataPartner;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum DATA_AI uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:289)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: DataSharingService.kt */
/* loaded from: classes3.dex */
public final class DataSharingService {
    @NotNull
    public static final Companion Companion;
    public static final DataSharingService DATA_AI;
    public static final DataSharingService HUQ;
    public static final DataSharingService NONE = new DataSharingService(KeyPropertiesCompact.DIGEST_NONE, 0, "", "", null, 0, 4, null);

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ DataSharingService[] f12177a;
    private final int dataSharingInfoRes;
    @NotNull
    private final List<DataSharingPermission> listOfPermissions;
    @NotNull
    private final String serviceName;
    @NotNull
    private final String serviceWebsite;

    /* compiled from: DataSharingService.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final DataSharingService fromServiceName(@NotNull String serviceName) {
            Intrinsics.checkNotNullParameter(serviceName, "serviceName");
            if (Intrinsics.areEqual(serviceName, "Data.ai")) {
                return DataSharingService.DATA_AI;
            }
            if (Intrinsics.areEqual(serviceName, "Huq")) {
                return DataSharingService.HUQ;
            }
            return DataSharingService.NONE;
        }
    }

    /* compiled from: DataSharingService.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataSharingPermission.values().length];
            try {
                iArr[DataSharingPermission.USAGE_ACCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DataSharingPermission.ACCESS_FINE_LOCATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        List listOf;
        List listOf2;
        listOf = kotlin.collections.e.listOf(DataSharingPermission.USAGE_ACCESS);
        DATA_AI = new DataSharingService("DATA_AI", 1, "Data.ai", "https://data.ai", listOf, R.string.shared_data_dataai);
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new DataSharingPermission[]{DataSharingPermission.ACCESS_FINE_LOCATION, DataSharingPermission.LOCATION_SERVICES});
        HUQ = new DataSharingService("HUQ", 2, "Huq", "https://huq.io", listOf2, R.string.shared_data_huq);
        f12177a = a();
        Companion = new Companion(null);
    }

    private DataSharingService(String str, int i4, String str2, String str3, List list, int i5) {
        this.serviceName = str2;
        this.serviceWebsite = str3;
        this.listOfPermissions = list;
        this.dataSharingInfoRes = i5;
    }

    private static final /* synthetic */ DataSharingService[] a() {
        return new DataSharingService[]{NONE, DATA_AI, HUQ};
    }

    @JvmStatic
    @NotNull
    public static final DataSharingService fromServiceName(@NotNull String str) {
        return Companion.fromServiceName(str);
    }

    public static DataSharingService valueOf(String str) {
        return (DataSharingService) Enum.valueOf(DataSharingService.class, str);
    }

    public static DataSharingService[] values() {
        return (DataSharingService[]) f12177a.clone();
    }

    @NotNull
    public final DataPartner getDataPartner() {
        if (this == DATA_AI) {
            return new DataAiDataPartner();
        }
        if (this == HUQ) {
            return new HuqDataPartner();
        }
        return new EmptyDataPartner();
    }

    public final int getDataSharingInfoRes() {
        return this.dataSharingInfoRes;
    }

    @NotNull
    public final List<DataSharingPermission> getListOfPermissions() {
        return this.listOfPermissions;
    }

    @NotNull
    public final List<String> getPermissionsAsString(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        ArrayList arrayList = new ArrayList();
        for (DataSharingPermission dataSharingPermission : this.listOfPermissions) {
            int i4 = WhenMappings.$EnumSwitchMapping$0[dataSharingPermission.ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    String string = resources.getString(R.string.permission_precise_location_access);
                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…_precise_location_access)");
                    arrayList.add(string);
                }
            } else {
                String string2 = resources.getString(R.string.permission_usage_access);
                Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st….permission_usage_access)");
                arrayList.add(string2);
            }
        }
        return arrayList;
    }

    @NotNull
    public final String getServiceName() {
        return this.serviceName;
    }

    @NotNull
    public final String getServiceWebsite() {
        return this.serviceWebsite;
    }

    /* synthetic */ DataSharingService(String str, int i4, String str2, String str3, List list, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i4, str2, str3, (i6 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, i5);
    }
}
