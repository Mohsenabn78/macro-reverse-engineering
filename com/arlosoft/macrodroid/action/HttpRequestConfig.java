package com.arlosoft.macrodroid.action;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HttpRequestAction.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@Parcelize
/* loaded from: classes2.dex */
public final class HttpRequestConfig implements Parcelable {
    public static final int CONTENT_BODY_FILE = 1;
    public static final int CONTENT_BODY_TEXT = 0;
    public static final int SAVE_RESPONSE_FILE = 2;
    public static final int SAVE_RESPONSE_NONE = 0;
    public static final int SAVE_RESPONSE_VARIABLE = 1;
    private final boolean allowAnyCertificate;
    private final boolean basicAuthEnabled;
    @NotNull
    private final String basicAuthPassword;
    @NotNull
    private final String basicAuthUsername;
    private final boolean blockNextAction;
    @NotNull
    private final String contentBodyFileDisplayName;
    @NotNull
    private final String contentBodyFileUri;
    private final int contentBodySource;
    @NotNull
    private final String contentBodyText;
    @NotNull
    private final String contentType;
    private final boolean followRedirects;
    @NotNull
    private final List<HttpParam> headerParams;
    @NotNull
    private final List<HttpParam> queryParams;
    private final int requestTimeOutSeconds;
    private final int requestType;
    @Nullable
    private final DictionaryKeys responseDictionaryKeys;
    @Nullable
    private final String responseVariableName;
    @Nullable
    private final DictionaryKeys returnCodeDictionaryKeys;
    @Nullable
    private final String returnCodeVariableName;
    @NotNull
    private final String saveResponseFileName;
    @NotNull
    private final String saveResponseFolderPathDisplayName;
    @NotNull
    private final String saveResponseFolderPathUri;
    private final int saveResponseType;
    private final boolean saveReturnCodeToVariable;
    @NotNull
    private final String urlToOpen;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @NotNull
    public static final Parcelable.Creator<HttpRequestConfig> CREATOR = new Creator();

    /* compiled from: HttpRequestAction.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: HttpRequestAction.kt */
    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<HttpRequestConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HttpRequestConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            int readInt2 = parcel.readInt();
            String readString2 = parcel.readString();
            int readInt3 = parcel.readInt();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            boolean z3 = parcel.readInt() != 0;
            String readString6 = parcel.readString();
            DictionaryKeys createFromParcel = parcel.readInt() == 0 ? null : DictionaryKeys.CREATOR.createFromParcel(parcel);
            int readInt4 = parcel.readInt();
            String readString7 = parcel.readString();
            DictionaryKeys createFromParcel2 = parcel.readInt() != 0 ? DictionaryKeys.CREATOR.createFromParcel(parcel) : null;
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            boolean z4 = parcel.readInt() != 0;
            boolean z5 = parcel.readInt() != 0;
            boolean z6 = parcel.readInt() != 0;
            boolean z7 = parcel.readInt() != 0;
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            int readInt5 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt5);
            int i4 = 0;
            while (i4 != readInt5) {
                arrayList.add(HttpParam.CREATOR.createFromParcel(parcel));
                i4++;
                readInt5 = readInt5;
            }
            int readInt6 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt6);
            int i5 = 0;
            while (i5 != readInt6) {
                arrayList2.add(HttpParam.CREATOR.createFromParcel(parcel));
                i5++;
                readInt6 = readInt6;
            }
            return new HttpRequestConfig(readInt, readString, readInt2, readString2, readInt3, readString3, readString4, readString5, z3, readString6, createFromParcel, readInt4, readString7, createFromParcel2, readString8, readString9, readString10, z4, z5, z6, z7, readString11, readString12, arrayList, arrayList2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HttpRequestConfig[] newArray(int i4) {
            return new HttpRequestConfig[i4];
        }
    }

    public HttpRequestConfig() {
        this(0, null, 0, null, 0, null, null, null, false, null, null, 0, null, null, null, null, null, false, false, false, false, null, null, null, null, 33554431, null);
    }

    public final int component1() {
        return this.requestType;
    }

    @Nullable
    public final String component10() {
        return this.returnCodeVariableName;
    }

    @Nullable
    public final DictionaryKeys component11() {
        return this.returnCodeDictionaryKeys;
    }

    public final int component12() {
        return this.saveResponseType;
    }

    @Nullable
    public final String component13() {
        return this.responseVariableName;
    }

    @Nullable
    public final DictionaryKeys component14() {
        return this.responseDictionaryKeys;
    }

    @NotNull
    public final String component15() {
        return this.saveResponseFolderPathUri;
    }

    @NotNull
    public final String component16() {
        return this.saveResponseFolderPathDisplayName;
    }

    @NotNull
    public final String component17() {
        return this.saveResponseFileName;
    }

    public final boolean component18() {
        return this.blockNextAction;
    }

    public final boolean component19() {
        return this.allowAnyCertificate;
    }

    @NotNull
    public final String component2() {
        return this.urlToOpen;
    }

    public final boolean component20() {
        return this.followRedirects;
    }

    public final boolean component21() {
        return this.basicAuthEnabled;
    }

    @NotNull
    public final String component22() {
        return this.basicAuthUsername;
    }

    @NotNull
    public final String component23() {
        return this.basicAuthPassword;
    }

    @NotNull
    public final List<HttpParam> component24() {
        return this.headerParams;
    }

    @NotNull
    public final List<HttpParam> component25() {
        return this.queryParams;
    }

    public final int component3() {
        return this.requestTimeOutSeconds;
    }

    @NotNull
    public final String component4() {
        return this.contentType;
    }

    public final int component5() {
        return this.contentBodySource;
    }

    @NotNull
    public final String component6() {
        return this.contentBodyText;
    }

    @NotNull
    public final String component7() {
        return this.contentBodyFileUri;
    }

    @NotNull
    public final String component8() {
        return this.contentBodyFileDisplayName;
    }

    public final boolean component9() {
        return this.saveReturnCodeToVariable;
    }

    @NotNull
    public final HttpRequestConfig copy(int i4, @NotNull String urlToOpen, int i5, @NotNull String contentType, int i6, @NotNull String contentBodyText, @NotNull String contentBodyFileUri, @NotNull String contentBodyFileDisplayName, boolean z3, @Nullable String str, @Nullable DictionaryKeys dictionaryKeys, int i7, @Nullable String str2, @Nullable DictionaryKeys dictionaryKeys2, @NotNull String saveResponseFolderPathUri, @NotNull String saveResponseFolderPathDisplayName, @NotNull String saveResponseFileName, boolean z4, boolean z5, boolean z6, boolean z7, @NotNull String basicAuthUsername, @NotNull String basicAuthPassword, @NotNull List<HttpParam> headerParams, @NotNull List<HttpParam> queryParams) {
        Intrinsics.checkNotNullParameter(urlToOpen, "urlToOpen");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(contentBodyText, "contentBodyText");
        Intrinsics.checkNotNullParameter(contentBodyFileUri, "contentBodyFileUri");
        Intrinsics.checkNotNullParameter(contentBodyFileDisplayName, "contentBodyFileDisplayName");
        Intrinsics.checkNotNullParameter(saveResponseFolderPathUri, "saveResponseFolderPathUri");
        Intrinsics.checkNotNullParameter(saveResponseFolderPathDisplayName, "saveResponseFolderPathDisplayName");
        Intrinsics.checkNotNullParameter(saveResponseFileName, "saveResponseFileName");
        Intrinsics.checkNotNullParameter(basicAuthUsername, "basicAuthUsername");
        Intrinsics.checkNotNullParameter(basicAuthPassword, "basicAuthPassword");
        Intrinsics.checkNotNullParameter(headerParams, "headerParams");
        Intrinsics.checkNotNullParameter(queryParams, "queryParams");
        return new HttpRequestConfig(i4, urlToOpen, i5, contentType, i6, contentBodyText, contentBodyFileUri, contentBodyFileDisplayName, z3, str, dictionaryKeys, i7, str2, dictionaryKeys2, saveResponseFolderPathUri, saveResponseFolderPathDisplayName, saveResponseFileName, z4, z5, z6, z7, basicAuthUsername, basicAuthPassword, headerParams, queryParams);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpRequestConfig)) {
            return false;
        }
        HttpRequestConfig httpRequestConfig = (HttpRequestConfig) obj;
        if (this.requestType == httpRequestConfig.requestType && Intrinsics.areEqual(this.urlToOpen, httpRequestConfig.urlToOpen) && this.requestTimeOutSeconds == httpRequestConfig.requestTimeOutSeconds && Intrinsics.areEqual(this.contentType, httpRequestConfig.contentType) && this.contentBodySource == httpRequestConfig.contentBodySource && Intrinsics.areEqual(this.contentBodyText, httpRequestConfig.contentBodyText) && Intrinsics.areEqual(this.contentBodyFileUri, httpRequestConfig.contentBodyFileUri) && Intrinsics.areEqual(this.contentBodyFileDisplayName, httpRequestConfig.contentBodyFileDisplayName) && this.saveReturnCodeToVariable == httpRequestConfig.saveReturnCodeToVariable && Intrinsics.areEqual(this.returnCodeVariableName, httpRequestConfig.returnCodeVariableName) && Intrinsics.areEqual(this.returnCodeDictionaryKeys, httpRequestConfig.returnCodeDictionaryKeys) && this.saveResponseType == httpRequestConfig.saveResponseType && Intrinsics.areEqual(this.responseVariableName, httpRequestConfig.responseVariableName) && Intrinsics.areEqual(this.responseDictionaryKeys, httpRequestConfig.responseDictionaryKeys) && Intrinsics.areEqual(this.saveResponseFolderPathUri, httpRequestConfig.saveResponseFolderPathUri) && Intrinsics.areEqual(this.saveResponseFolderPathDisplayName, httpRequestConfig.saveResponseFolderPathDisplayName) && Intrinsics.areEqual(this.saveResponseFileName, httpRequestConfig.saveResponseFileName) && this.blockNextAction == httpRequestConfig.blockNextAction && this.allowAnyCertificate == httpRequestConfig.allowAnyCertificate && this.followRedirects == httpRequestConfig.followRedirects && this.basicAuthEnabled == httpRequestConfig.basicAuthEnabled && Intrinsics.areEqual(this.basicAuthUsername, httpRequestConfig.basicAuthUsername) && Intrinsics.areEqual(this.basicAuthPassword, httpRequestConfig.basicAuthPassword) && Intrinsics.areEqual(this.headerParams, httpRequestConfig.headerParams) && Intrinsics.areEqual(this.queryParams, httpRequestConfig.queryParams)) {
            return true;
        }
        return false;
    }

    public final boolean getAllowAnyCertificate() {
        return this.allowAnyCertificate;
    }

    public final boolean getBasicAuthEnabled() {
        return this.basicAuthEnabled;
    }

    @NotNull
    public final String getBasicAuthPassword() {
        return this.basicAuthPassword;
    }

    @NotNull
    public final String getBasicAuthUsername() {
        return this.basicAuthUsername;
    }

    public final boolean getBlockNextAction() {
        return this.blockNextAction;
    }

    @NotNull
    public final String getContentBodyFileDisplayName() {
        return this.contentBodyFileDisplayName;
    }

    @NotNull
    public final String getContentBodyFileUri() {
        return this.contentBodyFileUri;
    }

    public final int getContentBodySource() {
        return this.contentBodySource;
    }

    @NotNull
    public final String getContentBodyText() {
        return this.contentBodyText;
    }

    @NotNull
    public final String getContentType() {
        return this.contentType;
    }

    public final boolean getFollowRedirects() {
        return this.followRedirects;
    }

    @NotNull
    public final List<HttpParam> getHeaderParams() {
        return this.headerParams;
    }

    @NotNull
    public final List<HttpParam> getQueryParams() {
        return this.queryParams;
    }

    public final int getRequestTimeOutSeconds() {
        return this.requestTimeOutSeconds;
    }

    public final int getRequestType() {
        return this.requestType;
    }

    @Nullable
    public final DictionaryKeys getResponseDictionaryKeys() {
        return this.responseDictionaryKeys;
    }

    @Nullable
    public final String getResponseVariableName() {
        return this.responseVariableName;
    }

    @Nullable
    public final DictionaryKeys getReturnCodeDictionaryKeys() {
        return this.returnCodeDictionaryKeys;
    }

    @Nullable
    public final String getReturnCodeVariableName() {
        return this.returnCodeVariableName;
    }

    @NotNull
    public final String getSaveResponseFileName() {
        return this.saveResponseFileName;
    }

    @NotNull
    public final String getSaveResponseFolderPathDisplayName() {
        return this.saveResponseFolderPathDisplayName;
    }

    @NotNull
    public final String getSaveResponseFolderPathUri() {
        return this.saveResponseFolderPathUri;
    }

    public final int getSaveResponseType() {
        return this.saveResponseType;
    }

    public final boolean getSaveReturnCodeToVariable() {
        return this.saveReturnCodeToVariable;
    }

    @NotNull
    public final String getUrlToOpen() {
        return this.urlToOpen;
    }

    public final boolean hasBody() {
        int i4 = this.requestType;
        if (i4 == 1 || i4 == 2 || i4 == 4 || i4 == 3) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4 = ((((((((((((((this.requestType * 31) + this.urlToOpen.hashCode()) * 31) + this.requestTimeOutSeconds) * 31) + this.contentType.hashCode()) * 31) + this.contentBodySource) * 31) + this.contentBodyText.hashCode()) * 31) + this.contentBodyFileUri.hashCode()) * 31) + this.contentBodyFileDisplayName.hashCode()) * 31;
        boolean z3 = this.saveReturnCodeToVariable;
        int i4 = 1;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int i6 = (hashCode4 + i5) * 31;
        String str = this.returnCodeVariableName;
        int i7 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i8 = (i6 + hashCode) * 31;
        DictionaryKeys dictionaryKeys = this.returnCodeDictionaryKeys;
        if (dictionaryKeys == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = dictionaryKeys.hashCode();
        }
        int i9 = (((i8 + hashCode2) * 31) + this.saveResponseType) * 31;
        String str2 = this.responseVariableName;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int i10 = (i9 + hashCode3) * 31;
        DictionaryKeys dictionaryKeys2 = this.responseDictionaryKeys;
        if (dictionaryKeys2 != null) {
            i7 = dictionaryKeys2.hashCode();
        }
        int hashCode5 = (((((((i10 + i7) * 31) + this.saveResponseFolderPathUri.hashCode()) * 31) + this.saveResponseFolderPathDisplayName.hashCode()) * 31) + this.saveResponseFileName.hashCode()) * 31;
        boolean z4 = this.blockNextAction;
        int i11 = z4;
        if (z4 != 0) {
            i11 = 1;
        }
        int i12 = (hashCode5 + i11) * 31;
        boolean z5 = this.allowAnyCertificate;
        int i13 = z5;
        if (z5 != 0) {
            i13 = 1;
        }
        int i14 = (i12 + i13) * 31;
        boolean z6 = this.followRedirects;
        int i15 = z6;
        if (z6 != 0) {
            i15 = 1;
        }
        int i16 = (i14 + i15) * 31;
        boolean z7 = this.basicAuthEnabled;
        if (!z7) {
            i4 = z7 ? 1 : 0;
        }
        return ((((((((i16 + i4) * 31) + this.basicAuthUsername.hashCode()) * 31) + this.basicAuthPassword.hashCode()) * 31) + this.headerParams.hashCode()) * 31) + this.queryParams.hashCode();
    }

    @NotNull
    public String toString() {
        int i4 = this.requestType;
        String str = this.urlToOpen;
        int i5 = this.requestTimeOutSeconds;
        String str2 = this.contentType;
        int i6 = this.contentBodySource;
        String str3 = this.contentBodyText;
        String str4 = this.contentBodyFileUri;
        String str5 = this.contentBodyFileDisplayName;
        boolean z3 = this.saveReturnCodeToVariable;
        String str6 = this.returnCodeVariableName;
        DictionaryKeys dictionaryKeys = this.returnCodeDictionaryKeys;
        int i7 = this.saveResponseType;
        String str7 = this.responseVariableName;
        DictionaryKeys dictionaryKeys2 = this.responseDictionaryKeys;
        String str8 = this.saveResponseFolderPathUri;
        String str9 = this.saveResponseFolderPathDisplayName;
        String str10 = this.saveResponseFileName;
        boolean z4 = this.blockNextAction;
        boolean z5 = this.allowAnyCertificate;
        boolean z6 = this.followRedirects;
        boolean z7 = this.basicAuthEnabled;
        String str11 = this.basicAuthUsername;
        String str12 = this.basicAuthPassword;
        List<HttpParam> list = this.headerParams;
        List<HttpParam> list2 = this.queryParams;
        return "HttpRequestConfig(requestType=" + i4 + ", urlToOpen=" + str + ", requestTimeOutSeconds=" + i5 + ", contentType=" + str2 + ", contentBodySource=" + i6 + ", contentBodyText=" + str3 + ", contentBodyFileUri=" + str4 + ", contentBodyFileDisplayName=" + str5 + ", saveReturnCodeToVariable=" + z3 + ", returnCodeVariableName=" + str6 + ", returnCodeDictionaryKeys=" + dictionaryKeys + ", saveResponseType=" + i7 + ", responseVariableName=" + str7 + ", responseDictionaryKeys=" + dictionaryKeys2 + ", saveResponseFolderPathUri=" + str8 + ", saveResponseFolderPathDisplayName=" + str9 + ", saveResponseFileName=" + str10 + ", blockNextAction=" + z4 + ", allowAnyCertificate=" + z5 + ", followRedirects=" + z6 + ", basicAuthEnabled=" + z7 + ", basicAuthUsername=" + str11 + ", basicAuthPassword=" + str12 + ", headerParams=" + list + ", queryParams=" + list2 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.requestType);
        out.writeString(this.urlToOpen);
        out.writeInt(this.requestTimeOutSeconds);
        out.writeString(this.contentType);
        out.writeInt(this.contentBodySource);
        out.writeString(this.contentBodyText);
        out.writeString(this.contentBodyFileUri);
        out.writeString(this.contentBodyFileDisplayName);
        out.writeInt(this.saveReturnCodeToVariable ? 1 : 0);
        out.writeString(this.returnCodeVariableName);
        DictionaryKeys dictionaryKeys = this.returnCodeDictionaryKeys;
        if (dictionaryKeys == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            dictionaryKeys.writeToParcel(out, i4);
        }
        out.writeInt(this.saveResponseType);
        out.writeString(this.responseVariableName);
        DictionaryKeys dictionaryKeys2 = this.responseDictionaryKeys;
        if (dictionaryKeys2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            dictionaryKeys2.writeToParcel(out, i4);
        }
        out.writeString(this.saveResponseFolderPathUri);
        out.writeString(this.saveResponseFolderPathDisplayName);
        out.writeString(this.saveResponseFileName);
        out.writeInt(this.blockNextAction ? 1 : 0);
        out.writeInt(this.allowAnyCertificate ? 1 : 0);
        out.writeInt(this.followRedirects ? 1 : 0);
        out.writeInt(this.basicAuthEnabled ? 1 : 0);
        out.writeString(this.basicAuthUsername);
        out.writeString(this.basicAuthPassword);
        List<HttpParam> list = this.headerParams;
        out.writeInt(list.size());
        for (HttpParam httpParam : list) {
            httpParam.writeToParcel(out, i4);
        }
        List<HttpParam> list2 = this.queryParams;
        out.writeInt(list2.size());
        for (HttpParam httpParam2 : list2) {
            httpParam2.writeToParcel(out, i4);
        }
    }

    public HttpRequestConfig(int i4, @NotNull String urlToOpen, int i5, @NotNull String contentType, int i6, @NotNull String contentBodyText, @NotNull String contentBodyFileUri, @NotNull String contentBodyFileDisplayName, boolean z3, @Nullable String str, @Nullable DictionaryKeys dictionaryKeys, int i7, @Nullable String str2, @Nullable DictionaryKeys dictionaryKeys2, @NotNull String saveResponseFolderPathUri, @NotNull String saveResponseFolderPathDisplayName, @NotNull String saveResponseFileName, boolean z4, boolean z5, boolean z6, boolean z7, @NotNull String basicAuthUsername, @NotNull String basicAuthPassword, @NotNull List<HttpParam> headerParams, @NotNull List<HttpParam> queryParams) {
        Intrinsics.checkNotNullParameter(urlToOpen, "urlToOpen");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(contentBodyText, "contentBodyText");
        Intrinsics.checkNotNullParameter(contentBodyFileUri, "contentBodyFileUri");
        Intrinsics.checkNotNullParameter(contentBodyFileDisplayName, "contentBodyFileDisplayName");
        Intrinsics.checkNotNullParameter(saveResponseFolderPathUri, "saveResponseFolderPathUri");
        Intrinsics.checkNotNullParameter(saveResponseFolderPathDisplayName, "saveResponseFolderPathDisplayName");
        Intrinsics.checkNotNullParameter(saveResponseFileName, "saveResponseFileName");
        Intrinsics.checkNotNullParameter(basicAuthUsername, "basicAuthUsername");
        Intrinsics.checkNotNullParameter(basicAuthPassword, "basicAuthPassword");
        Intrinsics.checkNotNullParameter(headerParams, "headerParams");
        Intrinsics.checkNotNullParameter(queryParams, "queryParams");
        this.requestType = i4;
        this.urlToOpen = urlToOpen;
        this.requestTimeOutSeconds = i5;
        this.contentType = contentType;
        this.contentBodySource = i6;
        this.contentBodyText = contentBodyText;
        this.contentBodyFileUri = contentBodyFileUri;
        this.contentBodyFileDisplayName = contentBodyFileDisplayName;
        this.saveReturnCodeToVariable = z3;
        this.returnCodeVariableName = str;
        this.returnCodeDictionaryKeys = dictionaryKeys;
        this.saveResponseType = i7;
        this.responseVariableName = str2;
        this.responseDictionaryKeys = dictionaryKeys2;
        this.saveResponseFolderPathUri = saveResponseFolderPathUri;
        this.saveResponseFolderPathDisplayName = saveResponseFolderPathDisplayName;
        this.saveResponseFileName = saveResponseFileName;
        this.blockNextAction = z4;
        this.allowAnyCertificate = z5;
        this.followRedirects = z6;
        this.basicAuthEnabled = z7;
        this.basicAuthUsername = basicAuthUsername;
        this.basicAuthPassword = basicAuthPassword;
        this.headerParams = headerParams;
        this.queryParams = queryParams;
    }

    public /* synthetic */ HttpRequestConfig(int i4, String str, int i5, String str2, int i6, String str3, String str4, String str5, boolean z3, String str6, DictionaryKeys dictionaryKeys, int i7, String str7, DictionaryKeys dictionaryKeys2, String str8, String str9, String str10, boolean z4, boolean z5, boolean z6, boolean z7, String str11, String str12, List list, List list2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? 0 : i4, (i8 & 2) != 0 ? "" : str, (i8 & 4) != 0 ? 30 : i5, (i8 & 8) != 0 ? "" : str2, (i8 & 16) != 0 ? 0 : i6, (i8 & 32) != 0 ? "" : str3, (i8 & 64) != 0 ? "" : str4, (i8 & 128) != 0 ? "" : str5, (i8 & 256) != 0 ? false : z3, (i8 & 512) != 0 ? null : str6, (i8 & 1024) != 0 ? null : dictionaryKeys, (i8 & 2048) != 0 ? 0 : i7, (i8 & 4096) != 0 ? null : str7, (i8 & 8192) != 0 ? null : dictionaryKeys2, (i8 & 16384) != 0 ? "" : str8, (i8 & 32768) != 0 ? "" : str9, (i8 & 65536) != 0 ? "" : str10, (i8 & 131072) != 0 ? false : z4, (i8 & 262144) != 0 ? false : z5, (i8 & 524288) != 0 ? false : z6, (i8 & 1048576) != 0 ? false : z7, (i8 & 2097152) != 0 ? "" : str11, (i8 & 4194304) != 0 ? "" : str12, (i8 & 8388608) != 0 ? new ArrayList() : list, (i8 & 16777216) != 0 ? new ArrayList() : list2);
    }
}
