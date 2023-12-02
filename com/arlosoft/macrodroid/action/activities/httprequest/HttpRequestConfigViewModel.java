package com.arlosoft.macrodroid.action.activities.httprequest;

import android.content.res.Resources;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import com.arlosoft.macrodroid.action.HttpParam;
import com.arlosoft.macrodroid.action.HttpRequestAction;
import com.arlosoft.macrodroid.action.HttpRequestConfig;
import com.arlosoft.macrodroid.action.HttpRequestEditingStore;
import com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestParamsFragment;
import com.arlosoft.macrodroid.app.di.annotations.ActivityScope;
import com.arlosoft.macrodroid.utils.SingleLiveEvent;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HttpRequestConfigViewModel.kt */
@StabilityInferred(parameters = 0)
@ActivityScope
/* loaded from: classes2.dex */
public final class HttpRequestConfigViewModel extends ViewModel implements LifecycleObserver {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Resources f3025a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3026b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private HttpRequestConfig f3027c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final MutableLiveData<HttpRequestConfigAndAction> f3028d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final LiveData<HttpRequestConfigAndAction> f3029e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final SingleLiveEvent<String> f3030f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final SingleLiveEvent<Unit> f3031g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final SingleLiveEvent<Unit> f3032h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final SingleLiveEvent<Unit> f3033i;

    @Inject
    public HttpRequestConfigViewModel(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.f3025a = resources;
        HttpRequestConfig httpRequestConfig = HttpRequestEditingStore.INSTANCE.getHttpRequestConfig();
        Intrinsics.checkNotNull(httpRequestConfig);
        this.f3027c = httpRequestConfig;
        MutableLiveData<HttpRequestConfigAndAction> mutableLiveData = new MutableLiveData<>();
        this.f3028d = mutableLiveData;
        this.f3029e = mutableLiveData;
        this.f3030f = new SingleLiveEvent<>();
        this.f3031g = new SingleLiveEvent<>();
        this.f3032h = new SingleLiveEvent<>();
        this.f3033i = new SingleLiveEvent<>();
    }

    public final void addParam(@NotNull HttpRequestParamsFragment.ParamType paramType, @NotNull HttpParam param) {
        Intrinsics.checkNotNullParameter(paramType, "paramType");
        Intrinsics.checkNotNullParameter(param, "param");
        this.f3026b = true;
        if (paramType == HttpRequestParamsFragment.ParamType.HEADER_PARAMS) {
            this.f3027c.getHeaderParams().add(param);
        } else if (paramType == HttpRequestParamsFragment.ParamType.QUERY_PARAMS) {
            this.f3027c.getQueryParams().add(param);
        }
        MutableLiveData<HttpRequestConfigAndAction> mutableLiveData = this.f3028d;
        HttpRequestConfig httpRequestConfig = this.f3027c;
        HttpRequestAction httpRequestAction = HttpRequestEditingStore.INSTANCE.getHttpRequestAction();
        Intrinsics.checkNotNull(httpRequestAction);
        mutableLiveData.postValue(new HttpRequestConfigAndAction(httpRequestConfig, httpRequestAction));
    }

    public final void deleteParam(@NotNull HttpRequestParamsFragment.ParamType paramType, @NotNull HttpParam param) {
        Intrinsics.checkNotNullParameter(paramType, "paramType");
        Intrinsics.checkNotNullParameter(param, "param");
        this.f3026b = true;
        if (paramType == HttpRequestParamsFragment.ParamType.HEADER_PARAMS) {
            this.f3027c.getHeaderParams().remove(param);
        } else if (paramType == HttpRequestParamsFragment.ParamType.QUERY_PARAMS) {
            this.f3027c.getQueryParams().remove(param);
        }
        MutableLiveData<HttpRequestConfigAndAction> mutableLiveData = this.f3028d;
        HttpRequestConfig httpRequestConfig = this.f3027c;
        HttpRequestAction httpRequestAction = HttpRequestEditingStore.INSTANCE.getHttpRequestAction();
        Intrinsics.checkNotNull(httpRequestAction);
        mutableLiveData.postValue(new HttpRequestConfigAndAction(httpRequestConfig, httpRequestAction));
    }

    @NotNull
    public final SingleLiveEvent<Unit> getCloseConfigurationEvent() {
        return this.f3031g;
    }

    @NotNull
    public final SingleLiveEvent<Unit> getEditParamEvent() {
        return this.f3033i;
    }

    @NotNull
    public final SingleLiveEvent<String> getErrorMessageEvent() {
        return this.f3030f;
    }

    @NotNull
    public final LiveData<HttpRequestConfigAndAction> getHttpRequestConfig() {
        return this.f3029e;
    }

    @NotNull
    public final SingleLiveEvent<Unit> getShowExitPromptEvent() {
        return this.f3032h;
    }

    public final void onHandleBackPressed() {
        if (this.f3026b) {
            this.f3032h.postValue(null);
        } else {
            this.f3031g.postValue(null);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        MutableLiveData<HttpRequestConfigAndAction> mutableLiveData = this.f3028d;
        HttpRequestConfig httpRequestConfig = this.f3027c;
        HttpRequestAction httpRequestAction = HttpRequestEditingStore.INSTANCE.getHttpRequestAction();
        Intrinsics.checkNotNull(httpRequestAction);
        mutableLiveData.postValue(new HttpRequestConfigAndAction(httpRequestConfig, httpRequestAction));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        if (r0 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e0, code lost:
        if (((r0 == null || r0.length() == 0) ? true : true) != false) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void save() {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestConfigViewModel.save():void");
    }

    public final void setAllowAnyCertificate(boolean z3) {
        HttpRequestConfig copy;
        if (this.f3027c.getAllowAnyCertificate() != z3) {
            copy = r2.copy((r43 & 1) != 0 ? r2.requestType : 0, (r43 & 2) != 0 ? r2.urlToOpen : null, (r43 & 4) != 0 ? r2.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? r2.contentType : null, (r43 & 16) != 0 ? r2.contentBodySource : 0, (r43 & 32) != 0 ? r2.contentBodyText : null, (r43 & 64) != 0 ? r2.contentBodyFileUri : null, (r43 & 128) != 0 ? r2.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? r2.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? r2.returnCodeVariableName : null, (r43 & 1024) != 0 ? r2.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? r2.saveResponseType : 0, (r43 & 4096) != 0 ? r2.responseVariableName : null, (r43 & 8192) != 0 ? r2.responseDictionaryKeys : null, (r43 & 16384) != 0 ? r2.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? r2.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? r2.saveResponseFileName : null, (r43 & 131072) != 0 ? r2.blockNextAction : false, (r43 & 262144) != 0 ? r2.allowAnyCertificate : z3, (r43 & 524288) != 0 ? r2.followRedirects : false, (r43 & 1048576) != 0 ? r2.basicAuthEnabled : false, (r43 & 2097152) != 0 ? r2.basicAuthUsername : null, (r43 & 4194304) != 0 ? r2.basicAuthPassword : null, (r43 & 8388608) != 0 ? r2.headerParams : null, (r43 & 16777216) != 0 ? this.f3027c.queryParams : null);
            this.f3027c = copy;
            this.f3026b = true;
        }
    }

    public final void setBasicAuthEnabled(boolean z3) {
        HttpRequestConfig copy;
        if (this.f3027c.getBasicAuthEnabled() != z3) {
            copy = r2.copy((r43 & 1) != 0 ? r2.requestType : 0, (r43 & 2) != 0 ? r2.urlToOpen : null, (r43 & 4) != 0 ? r2.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? r2.contentType : null, (r43 & 16) != 0 ? r2.contentBodySource : 0, (r43 & 32) != 0 ? r2.contentBodyText : null, (r43 & 64) != 0 ? r2.contentBodyFileUri : null, (r43 & 128) != 0 ? r2.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? r2.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? r2.returnCodeVariableName : null, (r43 & 1024) != 0 ? r2.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? r2.saveResponseType : 0, (r43 & 4096) != 0 ? r2.responseVariableName : null, (r43 & 8192) != 0 ? r2.responseDictionaryKeys : null, (r43 & 16384) != 0 ? r2.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? r2.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? r2.saveResponseFileName : null, (r43 & 131072) != 0 ? r2.blockNextAction : false, (r43 & 262144) != 0 ? r2.allowAnyCertificate : false, (r43 & 524288) != 0 ? r2.followRedirects : false, (r43 & 1048576) != 0 ? r2.basicAuthEnabled : z3, (r43 & 2097152) != 0 ? r2.basicAuthUsername : null, (r43 & 4194304) != 0 ? r2.basicAuthPassword : null, (r43 & 8388608) != 0 ? r2.headerParams : null, (r43 & 16777216) != 0 ? this.f3027c.queryParams : null);
            this.f3027c = copy;
            this.f3026b = true;
            MutableLiveData<HttpRequestConfigAndAction> mutableLiveData = this.f3028d;
            HttpRequestConfig httpRequestConfig = this.f3027c;
            HttpRequestAction httpRequestAction = HttpRequestEditingStore.INSTANCE.getHttpRequestAction();
            Intrinsics.checkNotNull(httpRequestAction);
            mutableLiveData.postValue(new HttpRequestConfigAndAction(httpRequestConfig, httpRequestAction));
        }
    }

    public final void setBasicAuthPassword(@NotNull String password) {
        HttpRequestConfig copy;
        Intrinsics.checkNotNullParameter(password, "password");
        if (!Intrinsics.areEqual(password, this.f3027c.getBasicAuthPassword())) {
            copy = r1.copy((r43 & 1) != 0 ? r1.requestType : 0, (r43 & 2) != 0 ? r1.urlToOpen : null, (r43 & 4) != 0 ? r1.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? r1.contentType : null, (r43 & 16) != 0 ? r1.contentBodySource : 0, (r43 & 32) != 0 ? r1.contentBodyText : null, (r43 & 64) != 0 ? r1.contentBodyFileUri : null, (r43 & 128) != 0 ? r1.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? r1.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? r1.returnCodeVariableName : null, (r43 & 1024) != 0 ? r1.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? r1.saveResponseType : 0, (r43 & 4096) != 0 ? r1.responseVariableName : null, (r43 & 8192) != 0 ? r1.responseDictionaryKeys : null, (r43 & 16384) != 0 ? r1.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? r1.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? r1.saveResponseFileName : null, (r43 & 131072) != 0 ? r1.blockNextAction : false, (r43 & 262144) != 0 ? r1.allowAnyCertificate : false, (r43 & 524288) != 0 ? r1.followRedirects : false, (r43 & 1048576) != 0 ? r1.basicAuthEnabled : false, (r43 & 2097152) != 0 ? r1.basicAuthUsername : null, (r43 & 4194304) != 0 ? r1.basicAuthPassword : password, (r43 & 8388608) != 0 ? r1.headerParams : null, (r43 & 16777216) != 0 ? this.f3027c.queryParams : null);
            this.f3027c = copy;
            this.f3026b = true;
        }
    }

    public final void setBasicAuthUsername(@NotNull String userName) {
        HttpRequestConfig copy;
        Intrinsics.checkNotNullParameter(userName, "userName");
        if (!Intrinsics.areEqual(userName, this.f3027c.getBasicAuthUsername())) {
            copy = r1.copy((r43 & 1) != 0 ? r1.requestType : 0, (r43 & 2) != 0 ? r1.urlToOpen : null, (r43 & 4) != 0 ? r1.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? r1.contentType : null, (r43 & 16) != 0 ? r1.contentBodySource : 0, (r43 & 32) != 0 ? r1.contentBodyText : null, (r43 & 64) != 0 ? r1.contentBodyFileUri : null, (r43 & 128) != 0 ? r1.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? r1.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? r1.returnCodeVariableName : null, (r43 & 1024) != 0 ? r1.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? r1.saveResponseType : 0, (r43 & 4096) != 0 ? r1.responseVariableName : null, (r43 & 8192) != 0 ? r1.responseDictionaryKeys : null, (r43 & 16384) != 0 ? r1.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? r1.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? r1.saveResponseFileName : null, (r43 & 131072) != 0 ? r1.blockNextAction : false, (r43 & 262144) != 0 ? r1.allowAnyCertificate : false, (r43 & 524288) != 0 ? r1.followRedirects : false, (r43 & 1048576) != 0 ? r1.basicAuthEnabled : false, (r43 & 2097152) != 0 ? r1.basicAuthUsername : userName, (r43 & 4194304) != 0 ? r1.basicAuthPassword : null, (r43 & 8388608) != 0 ? r1.headerParams : null, (r43 & 16777216) != 0 ? this.f3027c.queryParams : null);
            this.f3027c = copy;
            this.f3026b = true;
        }
    }

    public final void setBlockNextActions(boolean z3) {
        HttpRequestConfig copy;
        if (this.f3027c.getBlockNextAction() != z3) {
            copy = r2.copy((r43 & 1) != 0 ? r2.requestType : 0, (r43 & 2) != 0 ? r2.urlToOpen : null, (r43 & 4) != 0 ? r2.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? r2.contentType : null, (r43 & 16) != 0 ? r2.contentBodySource : 0, (r43 & 32) != 0 ? r2.contentBodyText : null, (r43 & 64) != 0 ? r2.contentBodyFileUri : null, (r43 & 128) != 0 ? r2.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? r2.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? r2.returnCodeVariableName : null, (r43 & 1024) != 0 ? r2.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? r2.saveResponseType : 0, (r43 & 4096) != 0 ? r2.responseVariableName : null, (r43 & 8192) != 0 ? r2.responseDictionaryKeys : null, (r43 & 16384) != 0 ? r2.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? r2.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? r2.saveResponseFileName : null, (r43 & 131072) != 0 ? r2.blockNextAction : z3, (r43 & 262144) != 0 ? r2.allowAnyCertificate : false, (r43 & 524288) != 0 ? r2.followRedirects : false, (r43 & 1048576) != 0 ? r2.basicAuthEnabled : false, (r43 & 2097152) != 0 ? r2.basicAuthUsername : null, (r43 & 4194304) != 0 ? r2.basicAuthPassword : null, (r43 & 8388608) != 0 ? r2.headerParams : null, (r43 & 16777216) != 0 ? this.f3027c.queryParams : null);
            this.f3027c = copy;
            this.f3026b = true;
        }
    }

    public final void setContentBodySource(int i4) {
        HttpRequestConfig copy;
        if (i4 != this.f3027c.getContentBodySource()) {
            copy = r2.copy((r43 & 1) != 0 ? r2.requestType : 0, (r43 & 2) != 0 ? r2.urlToOpen : null, (r43 & 4) != 0 ? r2.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? r2.contentType : null, (r43 & 16) != 0 ? r2.contentBodySource : i4, (r43 & 32) != 0 ? r2.contentBodyText : null, (r43 & 64) != 0 ? r2.contentBodyFileUri : null, (r43 & 128) != 0 ? r2.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? r2.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? r2.returnCodeVariableName : null, (r43 & 1024) != 0 ? r2.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? r2.saveResponseType : 0, (r43 & 4096) != 0 ? r2.responseVariableName : null, (r43 & 8192) != 0 ? r2.responseDictionaryKeys : null, (r43 & 16384) != 0 ? r2.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? r2.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? r2.saveResponseFileName : null, (r43 & 131072) != 0 ? r2.blockNextAction : false, (r43 & 262144) != 0 ? r2.allowAnyCertificate : false, (r43 & 524288) != 0 ? r2.followRedirects : false, (r43 & 1048576) != 0 ? r2.basicAuthEnabled : false, (r43 & 2097152) != 0 ? r2.basicAuthUsername : null, (r43 & 4194304) != 0 ? r2.basicAuthPassword : null, (r43 & 8388608) != 0 ? r2.headerParams : null, (r43 & 16777216) != 0 ? this.f3027c.queryParams : null);
            this.f3027c = copy;
            this.f3026b = true;
        }
    }

    public final void setContentBodyText(@NotNull String contentBodyText) {
        HttpRequestConfig copy;
        Intrinsics.checkNotNullParameter(contentBodyText, "contentBodyText");
        if (!Intrinsics.areEqual(contentBodyText, this.f3027c.getContentBodyText())) {
            copy = r1.copy((r43 & 1) != 0 ? r1.requestType : 0, (r43 & 2) != 0 ? r1.urlToOpen : null, (r43 & 4) != 0 ? r1.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? r1.contentType : null, (r43 & 16) != 0 ? r1.contentBodySource : 0, (r43 & 32) != 0 ? r1.contentBodyText : contentBodyText, (r43 & 64) != 0 ? r1.contentBodyFileUri : null, (r43 & 128) != 0 ? r1.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? r1.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? r1.returnCodeVariableName : null, (r43 & 1024) != 0 ? r1.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? r1.saveResponseType : 0, (r43 & 4096) != 0 ? r1.responseVariableName : null, (r43 & 8192) != 0 ? r1.responseDictionaryKeys : null, (r43 & 16384) != 0 ? r1.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? r1.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? r1.saveResponseFileName : null, (r43 & 131072) != 0 ? r1.blockNextAction : false, (r43 & 262144) != 0 ? r1.allowAnyCertificate : false, (r43 & 524288) != 0 ? r1.followRedirects : false, (r43 & 1048576) != 0 ? r1.basicAuthEnabled : false, (r43 & 2097152) != 0 ? r1.basicAuthUsername : null, (r43 & 4194304) != 0 ? r1.basicAuthPassword : null, (r43 & 8388608) != 0 ? r1.headerParams : null, (r43 & 16777216) != 0 ? this.f3027c.queryParams : null);
            this.f3027c = copy;
            this.f3026b = true;
        }
    }

    public final void setContentType(@NotNull String contentType) {
        HttpRequestConfig copy;
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        if (!Intrinsics.areEqual(contentType, this.f3027c.getContentType())) {
            copy = r1.copy((r43 & 1) != 0 ? r1.requestType : 0, (r43 & 2) != 0 ? r1.urlToOpen : null, (r43 & 4) != 0 ? r1.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? r1.contentType : contentType, (r43 & 16) != 0 ? r1.contentBodySource : 0, (r43 & 32) != 0 ? r1.contentBodyText : null, (r43 & 64) != 0 ? r1.contentBodyFileUri : null, (r43 & 128) != 0 ? r1.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? r1.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? r1.returnCodeVariableName : null, (r43 & 1024) != 0 ? r1.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? r1.saveResponseType : 0, (r43 & 4096) != 0 ? r1.responseVariableName : null, (r43 & 8192) != 0 ? r1.responseDictionaryKeys : null, (r43 & 16384) != 0 ? r1.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? r1.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? r1.saveResponseFileName : null, (r43 & 131072) != 0 ? r1.blockNextAction : false, (r43 & 262144) != 0 ? r1.allowAnyCertificate : false, (r43 & 524288) != 0 ? r1.followRedirects : false, (r43 & 1048576) != 0 ? r1.basicAuthEnabled : false, (r43 & 2097152) != 0 ? r1.basicAuthUsername : null, (r43 & 4194304) != 0 ? r1.basicAuthPassword : null, (r43 & 8388608) != 0 ? r1.headerParams : null, (r43 & 16777216) != 0 ? this.f3027c.queryParams : null);
            this.f3027c = copy;
            this.f3026b = true;
        }
    }

    public final void setFollowRedirects(boolean z3) {
        HttpRequestConfig copy;
        if (this.f3027c.getFollowRedirects() != z3) {
            copy = r2.copy((r43 & 1) != 0 ? r2.requestType : 0, (r43 & 2) != 0 ? r2.urlToOpen : null, (r43 & 4) != 0 ? r2.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? r2.contentType : null, (r43 & 16) != 0 ? r2.contentBodySource : 0, (r43 & 32) != 0 ? r2.contentBodyText : null, (r43 & 64) != 0 ? r2.contentBodyFileUri : null, (r43 & 128) != 0 ? r2.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? r2.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? r2.returnCodeVariableName : null, (r43 & 1024) != 0 ? r2.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? r2.saveResponseType : 0, (r43 & 4096) != 0 ? r2.responseVariableName : null, (r43 & 8192) != 0 ? r2.responseDictionaryKeys : null, (r43 & 16384) != 0 ? r2.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? r2.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? r2.saveResponseFileName : null, (r43 & 131072) != 0 ? r2.blockNextAction : false, (r43 & 262144) != 0 ? r2.allowAnyCertificate : false, (r43 & 524288) != 0 ? r2.followRedirects : z3, (r43 & 1048576) != 0 ? r2.basicAuthEnabled : false, (r43 & 2097152) != 0 ? r2.basicAuthUsername : null, (r43 & 4194304) != 0 ? r2.basicAuthPassword : null, (r43 & 8388608) != 0 ? r2.headerParams : null, (r43 & 16777216) != 0 ? this.f3027c.queryParams : null);
            this.f3027c = copy;
            this.f3026b = true;
        }
    }

    public final void setRequestType(int i4) {
        HttpRequestConfig copy;
        if (this.f3027c.getRequestType() != i4) {
            copy = r2.copy((r43 & 1) != 0 ? r2.requestType : i4, (r43 & 2) != 0 ? r2.urlToOpen : null, (r43 & 4) != 0 ? r2.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? r2.contentType : null, (r43 & 16) != 0 ? r2.contentBodySource : 0, (r43 & 32) != 0 ? r2.contentBodyText : null, (r43 & 64) != 0 ? r2.contentBodyFileUri : null, (r43 & 128) != 0 ? r2.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? r2.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? r2.returnCodeVariableName : null, (r43 & 1024) != 0 ? r2.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? r2.saveResponseType : 0, (r43 & 4096) != 0 ? r2.responseVariableName : null, (r43 & 8192) != 0 ? r2.responseDictionaryKeys : null, (r43 & 16384) != 0 ? r2.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? r2.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? r2.saveResponseFileName : null, (r43 & 131072) != 0 ? r2.blockNextAction : false, (r43 & 262144) != 0 ? r2.allowAnyCertificate : false, (r43 & 524288) != 0 ? r2.followRedirects : false, (r43 & 1048576) != 0 ? r2.basicAuthEnabled : false, (r43 & 2097152) != 0 ? r2.basicAuthUsername : null, (r43 & 4194304) != 0 ? r2.basicAuthPassword : null, (r43 & 8388608) != 0 ? r2.headerParams : null, (r43 & 16777216) != 0 ? this.f3027c.queryParams : null);
            this.f3027c = copy;
            this.f3026b = true;
            MutableLiveData<HttpRequestConfigAndAction> mutableLiveData = this.f3028d;
            HttpRequestConfig httpRequestConfig = this.f3027c;
            HttpRequestAction httpRequestAction = HttpRequestEditingStore.INSTANCE.getHttpRequestAction();
            Intrinsics.checkNotNull(httpRequestAction);
            mutableLiveData.postValue(new HttpRequestConfigAndAction(httpRequestConfig, httpRequestAction));
        }
    }

    public final void setSaveHttpResponseCodeVariableName(@NotNull String variableName, @Nullable List<String> list) {
        DictionaryKeys dictionaryKeys;
        HttpRequestConfig copy;
        Intrinsics.checkNotNullParameter(variableName, "variableName");
        if (!Intrinsics.areEqual(variableName, this.f3027c.getReturnCodeVariableName())) {
            HttpRequestConfig httpRequestConfig = this.f3027c;
            if (list != null) {
                dictionaryKeys = new DictionaryKeys(list);
            } else {
                dictionaryKeys = null;
            }
            copy = httpRequestConfig.copy((r43 & 1) != 0 ? httpRequestConfig.requestType : 0, (r43 & 2) != 0 ? httpRequestConfig.urlToOpen : null, (r43 & 4) != 0 ? httpRequestConfig.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? httpRequestConfig.contentType : null, (r43 & 16) != 0 ? httpRequestConfig.contentBodySource : 0, (r43 & 32) != 0 ? httpRequestConfig.contentBodyText : null, (r43 & 64) != 0 ? httpRequestConfig.contentBodyFileUri : null, (r43 & 128) != 0 ? httpRequestConfig.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? httpRequestConfig.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? httpRequestConfig.returnCodeVariableName : variableName, (r43 & 1024) != 0 ? httpRequestConfig.returnCodeDictionaryKeys : dictionaryKeys, (r43 & 2048) != 0 ? httpRequestConfig.saveResponseType : 0, (r43 & 4096) != 0 ? httpRequestConfig.responseVariableName : null, (r43 & 8192) != 0 ? httpRequestConfig.responseDictionaryKeys : null, (r43 & 16384) != 0 ? httpRequestConfig.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? httpRequestConfig.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? httpRequestConfig.saveResponseFileName : null, (r43 & 131072) != 0 ? httpRequestConfig.blockNextAction : false, (r43 & 262144) != 0 ? httpRequestConfig.allowAnyCertificate : false, (r43 & 524288) != 0 ? httpRequestConfig.followRedirects : false, (r43 & 1048576) != 0 ? httpRequestConfig.basicAuthEnabled : false, (r43 & 2097152) != 0 ? httpRequestConfig.basicAuthUsername : null, (r43 & 4194304) != 0 ? httpRequestConfig.basicAuthPassword : null, (r43 & 8388608) != 0 ? httpRequestConfig.headerParams : null, (r43 & 16777216) != 0 ? httpRequestConfig.queryParams : null);
            this.f3027c = copy;
            this.f3026b = true;
        }
    }

    public final void setSaveHttpResponseVariableName(@NotNull String variableName, @Nullable List<String> list) {
        HttpRequestConfig copy;
        List<String> list2;
        Intrinsics.checkNotNullParameter(variableName, "variableName");
        DictionaryKeys dictionaryKeys = null;
        if (Intrinsics.areEqual(variableName, this.f3027c.getResponseVariableName())) {
            DictionaryKeys responseDictionaryKeys = this.f3027c.getResponseDictionaryKeys();
            if (responseDictionaryKeys != null) {
                list2 = responseDictionaryKeys.getKeys();
            } else {
                list2 = null;
            }
            if (Intrinsics.areEqual(list, list2)) {
                return;
            }
        }
        HttpRequestConfig httpRequestConfig = this.f3027c;
        if (list != null) {
            dictionaryKeys = new DictionaryKeys(list);
        }
        copy = httpRequestConfig.copy((r43 & 1) != 0 ? httpRequestConfig.requestType : 0, (r43 & 2) != 0 ? httpRequestConfig.urlToOpen : null, (r43 & 4) != 0 ? httpRequestConfig.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? httpRequestConfig.contentType : null, (r43 & 16) != 0 ? httpRequestConfig.contentBodySource : 0, (r43 & 32) != 0 ? httpRequestConfig.contentBodyText : null, (r43 & 64) != 0 ? httpRequestConfig.contentBodyFileUri : null, (r43 & 128) != 0 ? httpRequestConfig.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? httpRequestConfig.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? httpRequestConfig.returnCodeVariableName : null, (r43 & 1024) != 0 ? httpRequestConfig.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? httpRequestConfig.saveResponseType : 0, (r43 & 4096) != 0 ? httpRequestConfig.responseVariableName : variableName, (r43 & 8192) != 0 ? httpRequestConfig.responseDictionaryKeys : dictionaryKeys, (r43 & 16384) != 0 ? httpRequestConfig.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? httpRequestConfig.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? httpRequestConfig.saveResponseFileName : null, (r43 & 131072) != 0 ? httpRequestConfig.blockNextAction : false, (r43 & 262144) != 0 ? httpRequestConfig.allowAnyCertificate : false, (r43 & 524288) != 0 ? httpRequestConfig.followRedirects : false, (r43 & 1048576) != 0 ? httpRequestConfig.basicAuthEnabled : false, (r43 & 2097152) != 0 ? httpRequestConfig.basicAuthUsername : null, (r43 & 4194304) != 0 ? httpRequestConfig.basicAuthPassword : null, (r43 & 8388608) != 0 ? httpRequestConfig.headerParams : null, (r43 & 16777216) != 0 ? httpRequestConfig.queryParams : null);
        this.f3027c = copy;
        this.f3026b = true;
    }

    public final void setSaveResponseFilename(@NotNull String saveResponseFileName) {
        HttpRequestConfig copy;
        Intrinsics.checkNotNullParameter(saveResponseFileName, "saveResponseFileName");
        if (!Intrinsics.areEqual(saveResponseFileName, this.f3027c.getSaveResponseFileName())) {
            copy = r1.copy((r43 & 1) != 0 ? r1.requestType : 0, (r43 & 2) != 0 ? r1.urlToOpen : null, (r43 & 4) != 0 ? r1.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? r1.contentType : null, (r43 & 16) != 0 ? r1.contentBodySource : 0, (r43 & 32) != 0 ? r1.contentBodyText : null, (r43 & 64) != 0 ? r1.contentBodyFileUri : null, (r43 & 128) != 0 ? r1.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? r1.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? r1.returnCodeVariableName : null, (r43 & 1024) != 0 ? r1.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? r1.saveResponseType : 0, (r43 & 4096) != 0 ? r1.responseVariableName : null, (r43 & 8192) != 0 ? r1.responseDictionaryKeys : null, (r43 & 16384) != 0 ? r1.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? r1.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? r1.saveResponseFileName : saveResponseFileName, (r43 & 131072) != 0 ? r1.blockNextAction : false, (r43 & 262144) != 0 ? r1.allowAnyCertificate : false, (r43 & 524288) != 0 ? r1.followRedirects : false, (r43 & 1048576) != 0 ? r1.basicAuthEnabled : false, (r43 & 2097152) != 0 ? r1.basicAuthUsername : null, (r43 & 4194304) != 0 ? r1.basicAuthPassword : null, (r43 & 8388608) != 0 ? r1.headerParams : null, (r43 & 16777216) != 0 ? this.f3027c.queryParams : null);
            this.f3027c = copy;
            this.f3026b = true;
        }
    }

    public final void setSaveResponseInFolderDetails(@NotNull String folderUri, @NotNull String displayName) {
        HttpRequestConfig copy;
        Intrinsics.checkNotNullParameter(folderUri, "folderUri");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        if (!Intrinsics.areEqual(folderUri, this.f3027c.getSaveResponseFolderPathUri()) || !Intrinsics.areEqual(displayName, this.f3027c.getSaveResponseFolderPathDisplayName())) {
            copy = r1.copy((r43 & 1) != 0 ? r1.requestType : 0, (r43 & 2) != 0 ? r1.urlToOpen : null, (r43 & 4) != 0 ? r1.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? r1.contentType : null, (r43 & 16) != 0 ? r1.contentBodySource : 0, (r43 & 32) != 0 ? r1.contentBodyText : null, (r43 & 64) != 0 ? r1.contentBodyFileUri : null, (r43 & 128) != 0 ? r1.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? r1.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? r1.returnCodeVariableName : null, (r43 & 1024) != 0 ? r1.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? r1.saveResponseType : 0, (r43 & 4096) != 0 ? r1.responseVariableName : null, (r43 & 8192) != 0 ? r1.responseDictionaryKeys : null, (r43 & 16384) != 0 ? r1.saveResponseFolderPathUri : folderUri, (r43 & 32768) != 0 ? r1.saveResponseFolderPathDisplayName : displayName, (r43 & 65536) != 0 ? r1.saveResponseFileName : null, (r43 & 131072) != 0 ? r1.blockNextAction : false, (r43 & 262144) != 0 ? r1.allowAnyCertificate : false, (r43 & 524288) != 0 ? r1.followRedirects : false, (r43 & 1048576) != 0 ? r1.basicAuthEnabled : false, (r43 & 2097152) != 0 ? r1.basicAuthUsername : null, (r43 & 4194304) != 0 ? r1.basicAuthPassword : null, (r43 & 8388608) != 0 ? r1.headerParams : null, (r43 & 16777216) != 0 ? this.f3027c.queryParams : null);
            this.f3027c = copy;
            this.f3026b = true;
        }
    }

    public final void setSaveResponseType(int i4) {
        HttpRequestConfig copy;
        if (i4 != this.f3027c.getSaveResponseType()) {
            copy = r2.copy((r43 & 1) != 0 ? r2.requestType : 0, (r43 & 2) != 0 ? r2.urlToOpen : null, (r43 & 4) != 0 ? r2.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? r2.contentType : null, (r43 & 16) != 0 ? r2.contentBodySource : 0, (r43 & 32) != 0 ? r2.contentBodyText : null, (r43 & 64) != 0 ? r2.contentBodyFileUri : null, (r43 & 128) != 0 ? r2.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? r2.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? r2.returnCodeVariableName : null, (r43 & 1024) != 0 ? r2.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? r2.saveResponseType : i4, (r43 & 4096) != 0 ? r2.responseVariableName : null, (r43 & 8192) != 0 ? r2.responseDictionaryKeys : null, (r43 & 16384) != 0 ? r2.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? r2.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? r2.saveResponseFileName : null, (r43 & 131072) != 0 ? r2.blockNextAction : false, (r43 & 262144) != 0 ? r2.allowAnyCertificate : false, (r43 & 524288) != 0 ? r2.followRedirects : false, (r43 & 1048576) != 0 ? r2.basicAuthEnabled : false, (r43 & 2097152) != 0 ? r2.basicAuthUsername : null, (r43 & 4194304) != 0 ? r2.basicAuthPassword : null, (r43 & 8388608) != 0 ? r2.headerParams : null, (r43 & 16777216) != 0 ? this.f3027c.queryParams : null);
            this.f3027c = copy;
        }
    }

    public final void setSaveReturnCodeInIntegerVariable(boolean z3) {
        HttpRequestConfig copy;
        if (z3 != this.f3027c.getSaveReturnCodeToVariable()) {
            copy = r2.copy((r43 & 1) != 0 ? r2.requestType : 0, (r43 & 2) != 0 ? r2.urlToOpen : null, (r43 & 4) != 0 ? r2.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? r2.contentType : null, (r43 & 16) != 0 ? r2.contentBodySource : 0, (r43 & 32) != 0 ? r2.contentBodyText : null, (r43 & 64) != 0 ? r2.contentBodyFileUri : null, (r43 & 128) != 0 ? r2.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? r2.saveReturnCodeToVariable : z3, (r43 & 512) != 0 ? r2.returnCodeVariableName : null, (r43 & 1024) != 0 ? r2.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? r2.saveResponseType : 0, (r43 & 4096) != 0 ? r2.responseVariableName : null, (r43 & 8192) != 0 ? r2.responseDictionaryKeys : null, (r43 & 16384) != 0 ? r2.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? r2.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? r2.saveResponseFileName : null, (r43 & 131072) != 0 ? r2.blockNextAction : false, (r43 & 262144) != 0 ? r2.allowAnyCertificate : false, (r43 & 524288) != 0 ? r2.followRedirects : false, (r43 & 1048576) != 0 ? r2.basicAuthEnabled : false, (r43 & 2097152) != 0 ? r2.basicAuthUsername : null, (r43 & 4194304) != 0 ? r2.basicAuthPassword : null, (r43 & 8388608) != 0 ? r2.headerParams : null, (r43 & 16777216) != 0 ? this.f3027c.queryParams : null);
            this.f3027c = copy;
            this.f3026b = true;
        }
    }

    public final void setTimeoutSeconds(int i4) {
        HttpRequestConfig copy;
        if (i4 != this.f3027c.getRequestTimeOutSeconds()) {
            copy = r2.copy((r43 & 1) != 0 ? r2.requestType : 0, (r43 & 2) != 0 ? r2.urlToOpen : null, (r43 & 4) != 0 ? r2.requestTimeOutSeconds : i4, (r43 & 8) != 0 ? r2.contentType : null, (r43 & 16) != 0 ? r2.contentBodySource : 0, (r43 & 32) != 0 ? r2.contentBodyText : null, (r43 & 64) != 0 ? r2.contentBodyFileUri : null, (r43 & 128) != 0 ? r2.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? r2.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? r2.returnCodeVariableName : null, (r43 & 1024) != 0 ? r2.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? r2.saveResponseType : 0, (r43 & 4096) != 0 ? r2.responseVariableName : null, (r43 & 8192) != 0 ? r2.responseDictionaryKeys : null, (r43 & 16384) != 0 ? r2.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? r2.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? r2.saveResponseFileName : null, (r43 & 131072) != 0 ? r2.blockNextAction : false, (r43 & 262144) != 0 ? r2.allowAnyCertificate : false, (r43 & 524288) != 0 ? r2.followRedirects : false, (r43 & 1048576) != 0 ? r2.basicAuthEnabled : false, (r43 & 2097152) != 0 ? r2.basicAuthUsername : null, (r43 & 4194304) != 0 ? r2.basicAuthPassword : null, (r43 & 8388608) != 0 ? r2.headerParams : null, (r43 & 16777216) != 0 ? this.f3027c.queryParams : null);
            this.f3027c = copy;
            this.f3026b = true;
        }
    }

    public final void setUrlText(@NotNull String urlText) {
        HttpRequestConfig copy;
        Intrinsics.checkNotNullParameter(urlText, "urlText");
        if (!Intrinsics.areEqual(urlText, this.f3027c.getUrlToOpen())) {
            copy = r1.copy((r43 & 1) != 0 ? r1.requestType : 0, (r43 & 2) != 0 ? r1.urlToOpen : urlText, (r43 & 4) != 0 ? r1.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? r1.contentType : null, (r43 & 16) != 0 ? r1.contentBodySource : 0, (r43 & 32) != 0 ? r1.contentBodyText : null, (r43 & 64) != 0 ? r1.contentBodyFileUri : null, (r43 & 128) != 0 ? r1.contentBodyFileDisplayName : null, (r43 & 256) != 0 ? r1.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? r1.returnCodeVariableName : null, (r43 & 1024) != 0 ? r1.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? r1.saveResponseType : 0, (r43 & 4096) != 0 ? r1.responseVariableName : null, (r43 & 8192) != 0 ? r1.responseDictionaryKeys : null, (r43 & 16384) != 0 ? r1.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? r1.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? r1.saveResponseFileName : null, (r43 & 131072) != 0 ? r1.blockNextAction : false, (r43 & 262144) != 0 ? r1.allowAnyCertificate : false, (r43 & 524288) != 0 ? r1.followRedirects : false, (r43 & 1048576) != 0 ? r1.basicAuthEnabled : false, (r43 & 2097152) != 0 ? r1.basicAuthUsername : null, (r43 & 4194304) != 0 ? r1.basicAuthPassword : null, (r43 & 8388608) != 0 ? r1.headerParams : null, (r43 & 16777216) != 0 ? this.f3027c.queryParams : null);
            this.f3027c = copy;
            this.f3026b = true;
        }
    }

    public final void setbodyFileDetails(@NotNull String fileUri, @NotNull String displayName) {
        HttpRequestConfig copy;
        Intrinsics.checkNotNullParameter(fileUri, "fileUri");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        if (!Intrinsics.areEqual(fileUri, this.f3027c.getContentBodyFileUri()) || !Intrinsics.areEqual(displayName, this.f3027c.getContentBodyFileDisplayName())) {
            copy = r1.copy((r43 & 1) != 0 ? r1.requestType : 0, (r43 & 2) != 0 ? r1.urlToOpen : null, (r43 & 4) != 0 ? r1.requestTimeOutSeconds : 0, (r43 & 8) != 0 ? r1.contentType : null, (r43 & 16) != 0 ? r1.contentBodySource : 0, (r43 & 32) != 0 ? r1.contentBodyText : null, (r43 & 64) != 0 ? r1.contentBodyFileUri : fileUri, (r43 & 128) != 0 ? r1.contentBodyFileDisplayName : displayName, (r43 & 256) != 0 ? r1.saveReturnCodeToVariable : false, (r43 & 512) != 0 ? r1.returnCodeVariableName : null, (r43 & 1024) != 0 ? r1.returnCodeDictionaryKeys : null, (r43 & 2048) != 0 ? r1.saveResponseType : 0, (r43 & 4096) != 0 ? r1.responseVariableName : null, (r43 & 8192) != 0 ? r1.responseDictionaryKeys : null, (r43 & 16384) != 0 ? r1.saveResponseFolderPathUri : null, (r43 & 32768) != 0 ? r1.saveResponseFolderPathDisplayName : null, (r43 & 65536) != 0 ? r1.saveResponseFileName : null, (r43 & 131072) != 0 ? r1.blockNextAction : false, (r43 & 262144) != 0 ? r1.allowAnyCertificate : false, (r43 & 524288) != 0 ? r1.followRedirects : false, (r43 & 1048576) != 0 ? r1.basicAuthEnabled : false, (r43 & 2097152) != 0 ? r1.basicAuthUsername : null, (r43 & 4194304) != 0 ? r1.basicAuthPassword : null, (r43 & 8388608) != 0 ? r1.headerParams : null, (r43 & 16777216) != 0 ? this.f3027c.queryParams : null);
            this.f3027c = copy;
            this.f3026b = true;
        }
    }

    public final void updateParam(@NotNull HttpRequestParamsFragment.ParamType paramType, @NotNull HttpParam paramOld, @NotNull HttpParam paramNew) {
        Intrinsics.checkNotNullParameter(paramType, "paramType");
        Intrinsics.checkNotNullParameter(paramOld, "paramOld");
        Intrinsics.checkNotNullParameter(paramNew, "paramNew");
        this.f3026b = true;
        if (paramType == HttpRequestParamsFragment.ParamType.HEADER_PARAMS) {
            this.f3027c.getHeaderParams().set(this.f3027c.getHeaderParams().indexOf(paramOld), paramNew);
        } else if (paramType == HttpRequestParamsFragment.ParamType.QUERY_PARAMS) {
            this.f3027c.getQueryParams().set(this.f3027c.getQueryParams().indexOf(paramOld), paramNew);
        }
        MutableLiveData<HttpRequestConfigAndAction> mutableLiveData = this.f3028d;
        HttpRequestConfig httpRequestConfig = this.f3027c;
        HttpRequestAction httpRequestAction = HttpRequestEditingStore.INSTANCE.getHttpRequestAction();
        Intrinsics.checkNotNull(httpRequestAction);
        mutableLiveData.postValue(new HttpRequestConfigAndAction(httpRequestConfig, httpRequestAction));
    }
}
