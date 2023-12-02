package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.documentfile.provider.DocumentFile;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestConfigActivity;
import com.arlosoft.macrodroid.action.info.HttpRequestActionInfo;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.HasVariableNames;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.saf.StorageAccessFrameworkHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.google.api.client.http.HttpMethods;
import java.io.OutputStream;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import net.bytebuddy.description.type.TypeDescription;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HttpRequestAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nHttpRequestAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpRequestAction.kt\ncom/arlosoft/macrodroid/action/HttpRequestAction\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,452:1\n1#2:453\n1360#3:454\n1446#3,5:455\n1360#3:460\n1446#3,5:461\n37#4,2:466\n*S KotlinDebug\n*F\n+ 1 HttpRequestAction.kt\ncom/arlosoft/macrodroid/action/HttpRequestAction\n*L\n412#1:454\n412#1:455,5\n413#1:460\n413#1:461,5\n413#1:466,2\n*E\n"})
/* loaded from: classes2.dex */
public final class HttpRequestAction extends Action implements HasVariableNames, BlockingAction, SupportsMagicText {
    public static final int HTTP_REQUEST_TYPE_DELETE = 3;
    public static final int HTTP_REQUEST_TYPE_GET = 0;
    public static final int HTTP_REQUEST_TYPE_HEAD = 5;
    public static final int HTTP_REQUEST_TYPE_OPTIONS = 6;
    public static final int HTTP_REQUEST_TYPE_PATCH = 4;
    public static final int HTTP_REQUEST_TYPE_POST = 1;
    public static final int HTTP_REQUEST_TYPE_PUT = 2;
    public static final int HTTP_REQUEST_TYPE_TRACE = 7;
    public static final int REQUEST_CODE_CONFIG_SCREEN = 0;
    @NotNull
    private HttpRequestConfig requestConfig;
    private transient PowerManager.WakeLock wakelock;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<HttpRequestAction> CREATOR = new Parcelable.Creator<HttpRequestAction>() { // from class: com.arlosoft.macrodroid.action.HttpRequestAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public HttpRequestAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new HttpRequestAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public HttpRequestAction[] newArray(int i4) {
            return new HttpRequestAction[i4];
        }
    };
    @NotNull
    private static final X509TrustManager TRUST_ALL_CERTS = new X509TrustManager() { // from class: com.arlosoft.macrodroid.action.HttpRequestAction$Companion$TRUST_ALL_CERTS$1
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(@NotNull X509Certificate[] chain, @NotNull String authType) {
            Intrinsics.checkNotNullParameter(chain, "chain");
            Intrinsics.checkNotNullParameter(authType, "authType");
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(@NotNull X509Certificate[] chain, @NotNull String authType) {
            Intrinsics.checkNotNullParameter(chain, "chain");
            Intrinsics.checkNotNullParameter(authType, "authType");
        }

        @Override // javax.net.ssl.X509TrustManager
        @NotNull
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    };

    public /* synthetic */ HttpRequestAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final String M() {
        switch (this.requestConfig.getRequestType()) {
            case 0:
                return "GET";
            case 1:
                return "POST";
            case 2:
                return "PUT";
            case 3:
                return "DELETE";
            case 4:
                return HttpMethods.PATCH;
            case 5:
                return "HEAD";
            case 6:
                return "OPTIONS";
            case 7:
                return "TRACE";
            default:
                return TypeDescription.Generic.OfWildcardType.SYMBOL;
        }
    }

    private final void N(String str) {
        Long macroGuid = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        SystemLog.logError("Error - could not write to file: " + str + ". Need to re-select path and grant access.", macroGuid.longValue());
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String r4 = SelectableItem.r(R.string.write_file_failed_please_reconfigure_directory);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.write…se_reconfigure_directory)");
        String name = getMacro().getName();
        Intrinsics.checkNotNullExpressionValue(name, "macro.name");
        StorageAccessFrameworkHelper.requiresAccessGranted(context, r4, name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(Response response, TriggerContextInfo triggerContextInfo) {
        BufferedSource bufferedSource;
        Sink sink;
        OutputStream outputStream = null;
        outputStream = null;
        r0 = null;
        BufferedSink bufferedSink = null;
        OutputStream outputStream2 = null;
        try {
            try {
                DocumentFile fromTreeUri = DocumentFile.fromTreeUri(getContext(), Uri.parse(this.requestConfig.getSaveResponseFolderPathUri()));
                String fileName = MagicText.replaceMagicText(getContext(), this.requestConfig.getSaveResponseFileName(), triggerContextInfo, getMacro());
                Intrinsics.checkNotNull(fromTreeUri);
                DocumentFile findFile = fromTreeUri.findFile(fileName);
                if (findFile == null) {
                    findFile = fromTreeUri.createFile("application/custom", fileName);
                }
                if (findFile == null) {
                    Intrinsics.checkNotNullExpressionValue(fileName, "fileName");
                    N(fileName);
                } else {
                    OutputStream openOutputStream = getContext().getContentResolver().openOutputStream(findFile.getUri(), "w");
                    try {
                        ResponseBody body = response.body();
                        if (body != null) {
                            bufferedSource = body.source();
                        } else {
                            bufferedSource = null;
                        }
                        if (bufferedSource != null) {
                            if (openOutputStream != null && (sink = Okio.sink(openOutputStream)) != null) {
                                bufferedSink = Okio.buffer(sink);
                            }
                            if (bufferedSink != null) {
                                bufferedSink.writeAll(bufferedSource);
                            }
                            if (bufferedSink != null) {
                                bufferedSink.close();
                            }
                        }
                        outputStream = openOutputStream;
                    } catch (Exception e4) {
                        e = e4;
                        outputStream = openOutputStream;
                        Long macroGuid = getMacroGuid();
                        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                        SystemLog.logError("Error - writing to file: " + e.getMessage(), macroGuid.longValue());
                        if (outputStream == null) {
                            return;
                        }
                        outputStream.close();
                    } catch (Throwable th) {
                        th = th;
                        outputStream2 = openOutputStream;
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                }
                if (outputStream == null) {
                    return;
                }
            } catch (Exception e5) {
                e = e5;
            }
            try {
                outputStream.close();
            } catch (Exception unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getConfiguredName() {
        String r4 = SelectableItem.r(R.string.action_http_request);
        String M = M();
        return r4 + " (" + M + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        return this.requestConfig.getUrlToOpen();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return HttpRequestActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        List listOf;
        List plus;
        List plus2;
        List listOf2;
        List listOf3;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{this.requestConfig.getUrlToOpen(), this.requestConfig.getBasicAuthUsername(), this.requestConfig.getBasicAuthPassword(), this.requestConfig.getContentBodyText(), this.requestConfig.getSaveResponseFileName()});
        List list = listOf;
        ArrayList arrayList = new ArrayList();
        for (HttpParam httpParam : this.requestConfig.getHeaderParams()) {
            listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{httpParam.getParamName(), httpParam.getParamValue()});
            kotlin.collections.i.addAll(arrayList, listOf3);
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) arrayList);
        List list2 = plus;
        ArrayList arrayList2 = new ArrayList();
        for (HttpParam httpParam2 : this.requestConfig.getQueryParams()) {
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{httpParam2.getParamName(), httpParam2.getParamValue()});
            kotlin.collections.i.addAll(arrayList2, listOf2);
        }
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) list2, (Iterable) arrayList2);
        return (String[]) plus2.toArray(new String[0]);
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    @NotNull
    public String[] getVariableNames() {
        return new String[]{this.requestConfig.getReturnCodeVariableName(), this.requestConfig.getResponseVariableName()};
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    @NotNull
    public Integer[] getVariableTypes() {
        return new Integer[]{1, 2};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(@NotNull Activity activity, int i4, int i5, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        setActivity(activity);
        if (i4 == 0 && i5 == -1) {
            HttpRequestConfig httpRequestConfig = HttpRequestEditingStore.INSTANCE.getHttpRequestConfig();
            if (httpRequestConfig != null) {
                this.requestConfig = httpRequestConfig;
            }
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        HttpRequestEditingStore httpRequestEditingStore = HttpRequestEditingStore.INSTANCE;
        httpRequestEditingStore.setHttpRequestAction(this);
        httpRequestEditingStore.setHttpRequestConfig(this.requestConfig);
        Activity activity = getActivity();
        Intent intent = new Intent(getActivity(), HttpRequestConfigActivity.class);
        intent.putExtra(HttpRequestConfigActivity.EXTRA_HTTP_REQUEST_CONFIG, this.requestConfig);
        Long macroGuid = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        intent.putExtra(Constants.EXTRA_MACRO_GUID, macroGuid.longValue());
        activity.startActivityForResult(intent, 0);
    }

    public final void init() {
        Object systemService = getContext().getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager.WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(1, "macrodroid:HttpRequestAction");
        Intrinsics.checkNotNullExpressionValue(newWakeLock, "pm.newWakeLock(PowerMana…droid:HttpRequestAction\")");
        this.wakelock = newWakeLock;
        if (newWakeLock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wakelock");
            newWakeLock = null;
        }
        newWakeLock.setReferenceCounted(false);
    }

    @Override // com.arlosoft.macrodroid.action.Action
    protected void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        HttpRequestConfig copy;
        HttpRequestConfig copy2;
        HttpRequestConfig copy3;
        HttpRequestConfig copy4;
        HttpRequestConfig copy5;
        List drop;
        Iterable<IndexedValue> withIndex;
        List<HttpParam> queryParams;
        int index;
        HttpParam copy$default;
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        copy = r3.copy((r43 & 1) != 0 ? r3.requestType : 0, (r43 & 2) != 0 ? r3.urlToOpen : magicText[0], (r43 & 4) != 0 ? r3.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? r3.contentType : null, (r43 & 16) != 0 ? r3.contentBodySource : 0, (r43 & 32) != 0 ? r3.contentBodyText : null, (r43 & 64) != 0 ? r3.contentBodyFileUri : null, (r43 & 128) != 0 ? r3.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? r3.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? r3.returnCodeVariableName : null, (r43 & 1024) != 0 ? r3.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? r3.saveResponseType : 0, (r43 & 4096) != 0 ? r3.responseVariableName : null, (r43 & 8192) != 0 ? r3.responseDictionaryKeys : null, (r43 & 16384) != 0 ? r3.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? r3.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? r3.saveResponseFileName : null, (r43 & 131072) != 0 ? r3.blockNextAction : false, (r43 & 262144) != 0 ? r3.allowAnyCertificate : false, (r43 & 524288) != 0 ? r3.followRedirects : false, (r43 & 1048576) != 0 ? r3.basicAuthEnabled : false, (r43 & 2097152) != 0 ? r3.basicAuthUsername : null, (r43 & 4194304) != 0 ? r3.basicAuthPassword : null, (r43 & 8388608) != 0 ? r3.headerParams : null, (r43 & 16777216) != 0 ? this.requestConfig.queryParams : null);
        this.requestConfig = copy;
        copy2 = copy.copy((r43 & 1) != 0 ? copy.requestType : 0, (r43 & 2) != 0 ? copy.urlToOpen : null, (r43 & 4) != 0 ? copy.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? copy.contentType : null, (r43 & 16) != 0 ? copy.contentBodySource : 0, (r43 & 32) != 0 ? copy.contentBodyText : null, (r43 & 64) != 0 ? copy.contentBodyFileUri : null, (r43 & 128) != 0 ? copy.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? copy.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? copy.returnCodeVariableName : null, (r43 & 1024) != 0 ? copy.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? copy.saveResponseType : 0, (r43 & 4096) != 0 ? copy.responseVariableName : null, (r43 & 8192) != 0 ? copy.responseDictionaryKeys : null, (r43 & 16384) != 0 ? copy.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? copy.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? copy.saveResponseFileName : null, (r43 & 131072) != 0 ? copy.blockNextAction : false, (r43 & 262144) != 0 ? copy.allowAnyCertificate : false, (r43 & 524288) != 0 ? copy.followRedirects : false, (r43 & 1048576) != 0 ? copy.basicAuthEnabled : false, (r43 & 2097152) != 0 ? copy.basicAuthUsername : magicText[1], (r43 & 4194304) != 0 ? copy.basicAuthPassword : null, (r43 & 8388608) != 0 ? copy.headerParams : null, (r43 & 16777216) != 0 ? copy.queryParams : null);
        this.requestConfig = copy2;
        copy3 = copy2.copy((r43 & 1) != 0 ? copy2.requestType : 0, (r43 & 2) != 0 ? copy2.urlToOpen : null, (r43 & 4) != 0 ? copy2.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? copy2.contentType : null, (r43 & 16) != 0 ? copy2.contentBodySource : 0, (r43 & 32) != 0 ? copy2.contentBodyText : null, (r43 & 64) != 0 ? copy2.contentBodyFileUri : null, (r43 & 128) != 0 ? copy2.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? copy2.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? copy2.returnCodeVariableName : null, (r43 & 1024) != 0 ? copy2.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? copy2.saveResponseType : 0, (r43 & 4096) != 0 ? copy2.responseVariableName : null, (r43 & 8192) != 0 ? copy2.responseDictionaryKeys : null, (r43 & 16384) != 0 ? copy2.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? copy2.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? copy2.saveResponseFileName : null, (r43 & 131072) != 0 ? copy2.blockNextAction : false, (r43 & 262144) != 0 ? copy2.allowAnyCertificate : false, (r43 & 524288) != 0 ? copy2.followRedirects : false, (r43 & 1048576) != 0 ? copy2.basicAuthEnabled : false, (r43 & 2097152) != 0 ? copy2.basicAuthUsername : null, (r43 & 4194304) != 0 ? copy2.basicAuthPassword : magicText[2], (r43 & 8388608) != 0 ? copy2.headerParams : null, (r43 & 16777216) != 0 ? copy2.queryParams : null);
        this.requestConfig = copy3;
        copy4 = copy3.copy((r43 & 1) != 0 ? copy3.requestType : 0, (r43 & 2) != 0 ? copy3.urlToOpen : null, (r43 & 4) != 0 ? copy3.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? copy3.contentType : null, (r43 & 16) != 0 ? copy3.contentBodySource : 0, (r43 & 32) != 0 ? copy3.contentBodyText : magicText[3], (r43 & 64) != 0 ? copy3.contentBodyFileUri : null, (r43 & 128) != 0 ? copy3.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? copy3.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? copy3.returnCodeVariableName : null, (r43 & 1024) != 0 ? copy3.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? copy3.saveResponseType : 0, (r43 & 4096) != 0 ? copy3.responseVariableName : null, (r43 & 8192) != 0 ? copy3.responseDictionaryKeys : null, (r43 & 16384) != 0 ? copy3.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? copy3.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? copy3.saveResponseFileName : null, (r43 & 131072) != 0 ? copy3.blockNextAction : false, (r43 & 262144) != 0 ? copy3.allowAnyCertificate : false, (r43 & 524288) != 0 ? copy3.followRedirects : false, (r43 & 1048576) != 0 ? copy3.basicAuthEnabled : false, (r43 & 2097152) != 0 ? copy3.basicAuthUsername : null, (r43 & 4194304) != 0 ? copy3.basicAuthPassword : null, (r43 & 8388608) != 0 ? copy3.headerParams : null, (r43 & 16777216) != 0 ? copy3.queryParams : null);
        this.requestConfig = copy4;
        copy5 = copy4.copy((r43 & 1) != 0 ? copy4.requestType : 0, (r43 & 2) != 0 ? copy4.urlToOpen : null, (r43 & 4) != 0 ? copy4.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? copy4.contentType : null, (r43 & 16) != 0 ? copy4.contentBodySource : 0, (r43 & 32) != 0 ? copy4.contentBodyText : null, (r43 & 64) != 0 ? copy4.contentBodyFileUri : null, (r43 & 128) != 0 ? copy4.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? copy4.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? copy4.returnCodeVariableName : null, (r43 & 1024) != 0 ? copy4.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? copy4.saveResponseType : 0, (r43 & 4096) != 0 ? copy4.responseVariableName : null, (r43 & 8192) != 0 ? copy4.responseDictionaryKeys : null, (r43 & 16384) != 0 ? copy4.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? copy4.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? copy4.saveResponseFileName : magicText[4], (r43 & 131072) != 0 ? copy4.blockNextAction : false, (r43 & 262144) != 0 ? copy4.allowAnyCertificate : false, (r43 & 524288) != 0 ? copy4.followRedirects : false, (r43 & 1048576) != 0 ? copy4.basicAuthEnabled : false, (r43 & 2097152) != 0 ? copy4.basicAuthUsername : null, (r43 & 4194304) != 0 ? copy4.basicAuthPassword : null, (r43 & 8388608) != 0 ? copy4.headerParams : null, (r43 & 16777216) != 0 ? copy4.queryParams : null);
        this.requestConfig = copy5;
        int size = copy5.getHeaderParams().size();
        drop = ArraysKt___ArraysKt.drop(magicText, 5);
        withIndex = CollectionsKt___CollectionsKt.withIndex(drop);
        for (IndexedValue indexedValue : withIndex) {
            if (indexedValue.getIndex() / 2 < size) {
                queryParams = this.requestConfig.getHeaderParams();
            } else {
                queryParams = this.requestConfig.getQueryParams();
            }
            if (indexedValue.getIndex() / 2 < size) {
                index = indexedValue.getIndex();
            } else {
                index = indexedValue.getIndex() - (size * 2);
            }
            int i4 = index / 2;
            HttpParam httpParam = queryParams.get(i4);
            int index2 = indexedValue.getIndex() % 2;
            String str = (String) indexedValue.getValue();
            if (index2 == 0) {
                copy$default = HttpParam.copy$default(httpParam, str, null, 2, null);
            } else {
                copy$default = HttpParam.copy$default(httpParam, null, str, 1, null);
            }
            queryParams.set(i4, copy$default);
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    public void setVariableNames(@NotNull String[] varNames) {
        HttpRequestConfig copy;
        Intrinsics.checkNotNullParameter(varNames, "varNames");
        copy = r3.copy((r43 & 1) != 0 ? r3.requestType : 0, (r43 & 2) != 0 ? r3.urlToOpen : null, (r43 & 4) != 0 ? r3.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? r3.contentType : null, (r43 & 16) != 0 ? r3.contentBodySource : 0, (r43 & 32) != 0 ? r3.contentBodyText : null, (r43 & 64) != 0 ? r3.contentBodyFileUri : null, (r43 & 128) != 0 ? r3.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? r3.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? r3.returnCodeVariableName : varNames[0], (r43 & 1024) != 0 ? r3.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? r3.saveResponseType : 0, (r43 & 4096) != 0 ? r3.responseVariableName : varNames[1], (r43 & 8192) != 0 ? r3.responseDictionaryKeys : null, (r43 & 16384) != 0 ? r3.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? r3.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? r3.saveResponseFileName : null, (r43 & 131072) != 0 ? r3.blockNextAction : false, (r43 & 262144) != 0 ? r3.allowAnyCertificate : false, (r43 & 524288) != 0 ? r3.followRedirects : false, (r43 & 1048576) != 0 ? r3.basicAuthEnabled : false, (r43 & 2097152) != 0 ? r3.basicAuthUsername : null, (r43 & 4194304) != 0 ? r3.basicAuthPassword : null, (r43 & 8388608) != 0 ? r3.headerParams : null, (r43 & 16777216) != 0 ? this.requestConfig.queryParams : null);
        this.requestConfig = copy;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeParcelable(this.requestConfig, i4);
    }

    public HttpRequestAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> skipEndifIndexStack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        PowerManager.WakeLock wakeLock = this.wakelock;
        if (wakeLock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wakelock");
            wakeLock = null;
        }
        wakeLock.acquire(30000L);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new HttpRequestAction$invokeAction$1(this, triggerContextInfo, z4, i4, z3, skipEndifIndexStack, resumeMacroInfo, null), 2, null);
        if (z4 || this.requestConfig.getBlockNextAction()) {
            return;
        }
        getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, z3, skipEndifIndexStack, resumeMacroInfo);
    }

    public HttpRequestAction() {
        this.requestConfig = new HttpRequestConfig(0, null, 0, null, 0, null, null, null, false, null, null, 0, null, null, null, null, null, false, false, false, false, null, null, null, null, 33554431, null);
        init();
    }

    private HttpRequestAction(Parcel parcel) {
        super(parcel);
        this.requestConfig = new HttpRequestConfig(0, null, 0, null, 0, null, null, null, false, null, null, 0, null, null, null, null, null, false, false, false, false, null, null, null, null, 33554431, null);
        init();
        HttpRequestConfig httpRequestConfig = (HttpRequestConfig) parcel.readParcelable(HttpRequestConfig.class.getClassLoader());
        this.requestConfig = httpRequestConfig == null ? new HttpRequestConfig(0, null, 0, null, 0, null, null, null, false, null, null, 0, null, null, null, null, null, false, false, false, false, null, null, null, null, 33554431, null) : httpRequestConfig;
    }

    /* compiled from: HttpRequestAction.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
