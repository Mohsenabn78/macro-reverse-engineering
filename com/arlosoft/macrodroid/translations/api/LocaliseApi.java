package com.arlosoft.macrodroid.translations.api;

import com.arlosoft.macrodroid.translations.data.Translation;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* compiled from: LocaliseApi.kt */
/* loaded from: classes3.dex */
public interface LocaliseApi {
    @NotNull
    public static final String API_KEY = "Zf7PiN-aLhKiuyc0x1-XLqP0Vaa151Ti1";
    @NotNull
    public static final Companion Companion = Companion.f14301a;

    /* compiled from: LocaliseApi.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        @NotNull
        public static final String API_KEY = "Zf7PiN-aLhKiuyc0x1-XLqP0Vaa151Ti1";

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f14301a = new Companion();

        private Companion() {
        }
    }

    @GET("/api/locales")
    @NotNull
    List<Translation> getLanguages(@NotNull @Query("key") String str);
}
