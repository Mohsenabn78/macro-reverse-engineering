package com.arlosoft.macrodroid.translations.api;

import com.arlosoft.macrodroid.translations.data.Translation;
import java.util.List;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;

/* compiled from: MacroDroidTranslationsApi.kt */
/* loaded from: classes3.dex */
public interface MacroDroidTranslationsApi {
    @NotNull
    public static final String API_KEY = "Zf7PiN-aLhKiuyc0x1-XLqP0Vaa151Ti1";
    @NotNull
    public static final Companion Companion = Companion.f14302a;

    /* compiled from: MacroDroidTranslationsApi.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        @NotNull
        public static final String API_KEY = "Zf7PiN-aLhKiuyc0x1-XLqP0Vaa151Ti1";

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f14302a = new Companion();

        private Companion() {
        }
    }

    @GET("/v1/translations")
    @Nullable
    Object getLanguages(@NotNull Continuation<? super List<Translation>> continuation);
}
