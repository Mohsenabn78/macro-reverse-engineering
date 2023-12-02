package com.arlosoft.macrodroid.app.di;

import android.content.Context;
import com.arlosoft.macrodroid.action.email.api.EmailApi;
import com.arlosoft.macrodroid.action.email.api.UpgradeApi;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.commercial.api.CommercialApi;
import com.arlosoft.macrodroid.gson.GsonUtils;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroDeserializer;
import com.arlosoft.macrodroid.plugins.api.AppBrainApi;
import com.arlosoft.macrodroid.plugins.api.PluginListApi;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.translations.api.LocaliseApi;
import com.arlosoft.macrodroid.translations.api.MacroDroidTranslationsApi;
import com.arlosoft.macrodroid.triggers.webtrigger.api.TinyUrlApi;
import com.arlosoft.macrodroid.triggers.webtrigger.api.WebTriggerApi;
import com.arlosoft.macrodroid.videos.api.VideosApi;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* compiled from: NetworkingModule.kt */
@Module
/* loaded from: classes3.dex */
public final class NetworkingModule {
    @NotNull
    public static final NetworkingModule INSTANCE = new NetworkingModule();
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final X509TrustManager f9253a = new X509TrustManager() { // from class: com.arlosoft.macrodroid.app.di.NetworkingModule$TRUST_ALL_CERTS$1
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

    private NetworkingModule() {
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final OkHttpClient createOkHttpClient() {
        return new OkHttpClient.Builder().connectTimeout(5L, TimeUnit.SECONDS).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final Gson provideGson(@ApplicationContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Gson create = GsonUtils.getGsonBuilder().registerTypeAdapter(Macro.class, new MacroDeserializer(context, false, false, false)).registerTypeAdapter(ActionBlock.class, new MacroDeserializer(context, false, false, false)).create();
        Intrinsics.checkNotNullExpressionValue(create, "getGsonBuilder()\n       …e))\n            .create()");
        return create;
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final AppBrainApi providesAppBrainApi(@NotNull OkHttpClient okHttpClient, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Object create = new Retrofit.Builder().baseUrl("https://api.appbrain.com").client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build().create(AppBrainApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "Builder()\n              …(AppBrainApi::class.java)");
        return (AppBrainApi) create;
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final CommercialApi providesCommercialApi(@NotNull OkHttpClient okHttpClient, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Object create = new Retrofit.Builder().baseUrl("https://backend.macrodroid.com/").client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build().create(CommercialApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "Builder()\n              …ommercialApi::class.java)");
        return (CommercialApi) create;
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final EmailApi providesEmailApi(@NotNull OkHttpClient okHttpClient, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Object create = new Retrofit.Builder().baseUrl("https://backend.macrodroid.com/").client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build().create(EmailApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "Builder()\n              …ate(EmailApi::class.java)");
        return (EmailApi) create;
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final MacroDroidTranslationsApi providesMacroDroidTranslationsApi(@NotNull OkHttpClient okHttpClient, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Object create = new Retrofit.Builder().baseUrl("https://backend.macrodroid.com/").client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build().create(MacroDroidTranslationsApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "Builder()\n              …nslationsApi::class.java)");
        return (MacroDroidTranslationsApi) create;
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final PluginListApi providesPluginListApi(@NotNull OkHttpClient okHttpClient, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Object create = new Retrofit.Builder().baseUrl("https://backend.macrodroid.com/").client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build().create(PluginListApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "Builder()\n              …luginListApi::class.java)");
        return (PluginListApi) create;
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final TemplateStoreApi providesTemplateStoreApi(@NotNull OkHttpClient okHttpClient, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Object create = new Retrofit.Builder().baseUrl("https://backend.macrodroid.com/").client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build().create(TemplateStoreApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "Builder()\n              …lateStoreApi::class.java)");
        return (TemplateStoreApi) create;
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final TinyUrlApi providesTinyUrlApi(@NotNull OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Object create = new Retrofit.Builder().baseUrl("https://tinyurl.com/").client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(ScalarsConverterFactory.create()).build().create(TinyUrlApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "Builder()\n              …e(TinyUrlApi::class.java)");
        return (TinyUrlApi) create;
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final LocaliseApi providesTranslationsApi(@NotNull OkHttpClient okHttpClient, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Object create = new Retrofit.Builder().baseUrl("https://localise.biz:443").client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build().create(LocaliseApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "Builder()\n              …(LocaliseApi::class.java)");
        return (LocaliseApi) create;
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final UpgradeApi providesUpgradeApi(@NotNull OkHttpClient okHttpClient, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Object create = new Retrofit.Builder().baseUrl("https://backend.macrodroid.com/").client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build().create(UpgradeApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "Builder()\n              …e(UpgradeApi::class.java)");
        return (UpgradeApi) create;
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final VideosApi providesVideosApi(@NotNull OkHttpClient okHttpClient, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Object create = new Retrofit.Builder().baseUrl("https://macrodroid-production.web.app/videos.json/").client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build().create(VideosApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "Builder()\n              …te(VideosApi::class.java)");
        return (VideosApi) create;
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final WebTriggerApi providesWebTriggerApi(@NotNull OkHttpClient okHttpClient, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Object create = new Retrofit.Builder().baseUrl("https://backend.macrodroid.com/").client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build().create(WebTriggerApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "Builder()\n              …ebTriggerApi::class.java)");
        return (WebTriggerApi) create;
    }
}
