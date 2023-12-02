package com.google.android.gms.ads.search;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class DynamicHeightSearchAdRequest {

    /* renamed from: a  reason: collision with root package name */
    private final SearchAdRequest f19583a;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final zzb f19584a = new zzb();

        /* renamed from: b  reason: collision with root package name */
        private final Bundle f19585b = new Bundle();

        @NonNull
        public Builder addCustomEventExtrasBundle(@NonNull Class<? extends CustomEvent> cls, @NonNull Bundle bundle) {
            this.f19584a.zzb(cls, bundle);
            return this;
        }

        @NonNull
        public Builder addNetworkExtras(@NonNull NetworkExtras networkExtras) {
            this.f19584a.zzc(networkExtras);
            return this;
        }

        @NonNull
        public Builder addNetworkExtrasBundle(@NonNull Class<? extends MediationAdapter> cls, @NonNull Bundle bundle) {
            this.f19584a.zzd(cls, bundle);
            return this;
        }

        @NonNull
        public DynamicHeightSearchAdRequest build() {
            this.f19584a.zzd(AdMobAdapter.class, this.f19585b);
            return new DynamicHeightSearchAdRequest(this, null);
        }

        @NonNull
        public Builder setAdBorderSelectors(@NonNull String str) {
            this.f19585b.putString("csa_adBorderSelectors", str);
            return this;
        }

        @NonNull
        public Builder setAdTest(boolean z3) {
            String str;
            Bundle bundle = this.f19585b;
            if (true != z3) {
                str = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
            } else {
                str = DebugKt.DEBUG_PROPERTY_VALUE_ON;
            }
            bundle.putString("csa_adtest", str);
            return this;
        }

        @NonNull
        public Builder setAdjustableLineHeight(int i4) {
            this.f19585b.putString("csa_adjustableLineHeight", Integer.toString(i4));
            return this;
        }

        @NonNull
        public Builder setAdvancedOptionValue(@NonNull String str, @NonNull String str2) {
            this.f19585b.putString(str, str2);
            return this;
        }

        @NonNull
        public Builder setAttributionSpacingBelow(int i4) {
            this.f19585b.putString("csa_attributionSpacingBelow", Integer.toString(i4));
            return this;
        }

        @NonNull
        public Builder setBorderSelections(@NonNull String str) {
            this.f19585b.putString("csa_borderSelections", str);
            return this;
        }

        @NonNull
        public Builder setChannel(@NonNull String str) {
            this.f19585b.putString("csa_channel", str);
            return this;
        }

        @NonNull
        public Builder setColorAdBorder(@NonNull String str) {
            this.f19585b.putString("csa_colorAdBorder", str);
            return this;
        }

        @NonNull
        public Builder setColorAdSeparator(@NonNull String str) {
            this.f19585b.putString("csa_colorAdSeparator", str);
            return this;
        }

        @NonNull
        public Builder setColorAnnotation(@NonNull String str) {
            this.f19585b.putString("csa_colorAnnotation", str);
            return this;
        }

        @NonNull
        public Builder setColorAttribution(@NonNull String str) {
            this.f19585b.putString("csa_colorAttribution", str);
            return this;
        }

        @NonNull
        public Builder setColorBackground(@NonNull String str) {
            this.f19585b.putString("csa_colorBackground", str);
            return this;
        }

        @NonNull
        public Builder setColorBorder(@NonNull String str) {
            this.f19585b.putString("csa_colorBorder", str);
            return this;
        }

        @NonNull
        public Builder setColorDomainLink(@NonNull String str) {
            this.f19585b.putString("csa_colorDomainLink", str);
            return this;
        }

        @NonNull
        public Builder setColorText(@NonNull String str) {
            this.f19585b.putString("csa_colorText", str);
            return this;
        }

        @NonNull
        public Builder setColorTitleLink(@NonNull String str) {
            this.f19585b.putString("csa_colorTitleLink", str);
            return this;
        }

        @NonNull
        public Builder setCssWidth(int i4) {
            this.f19585b.putString("csa_width", Integer.toString(i4));
            return this;
        }

        @NonNull
        public Builder setDetailedAttribution(boolean z3) {
            this.f19585b.putString("csa_detailedAttribution", Boolean.toString(z3));
            return this;
        }

        @NonNull
        public Builder setFontFamily(@NonNull String str) {
            this.f19585b.putString("csa_fontFamily", str);
            return this;
        }

        @NonNull
        public Builder setFontFamilyAttribution(@NonNull String str) {
            this.f19585b.putString("csa_fontFamilyAttribution", str);
            return this;
        }

        @NonNull
        public Builder setFontSizeAnnotation(int i4) {
            this.f19585b.putString("csa_fontSizeAnnotation", Integer.toString(i4));
            return this;
        }

        @NonNull
        public Builder setFontSizeAttribution(int i4) {
            this.f19585b.putString("csa_fontSizeAttribution", Integer.toString(i4));
            return this;
        }

        @NonNull
        public Builder setFontSizeDescription(int i4) {
            this.f19585b.putString("csa_fontSizeDescription", Integer.toString(i4));
            return this;
        }

        @NonNull
        public Builder setFontSizeDomainLink(int i4) {
            this.f19585b.putString("csa_fontSizeDomainLink", Integer.toString(i4));
            return this;
        }

        @NonNull
        public Builder setFontSizeTitle(int i4) {
            this.f19585b.putString("csa_fontSizeTitle", Integer.toString(i4));
            return this;
        }

        @NonNull
        public Builder setHostLanguage(@NonNull String str) {
            this.f19585b.putString("csa_hl", str);
            return this;
        }

        @NonNull
        public Builder setIsClickToCallEnabled(boolean z3) {
            this.f19585b.putString("csa_clickToCall", Boolean.toString(z3));
            return this;
        }

        @NonNull
        public Builder setIsLocationEnabled(boolean z3) {
            this.f19585b.putString("csa_location", Boolean.toString(z3));
            return this;
        }

        @NonNull
        public Builder setIsPlusOnesEnabled(boolean z3) {
            this.f19585b.putString("csa_plusOnes", Boolean.toString(z3));
            return this;
        }

        @NonNull
        public Builder setIsSellerRatingsEnabled(boolean z3) {
            this.f19585b.putString("csa_sellerRatings", Boolean.toString(z3));
            return this;
        }

        @NonNull
        public Builder setIsSiteLinksEnabled(boolean z3) {
            this.f19585b.putString("csa_siteLinks", Boolean.toString(z3));
            return this;
        }

        @NonNull
        public Builder setIsTitleBold(boolean z3) {
            this.f19585b.putString("csa_titleBold", Boolean.toString(z3));
            return this;
        }

        @NonNull
        public Builder setIsTitleUnderlined(boolean z3) {
            this.f19585b.putString("csa_noTitleUnderline", Boolean.toString(!z3));
            return this;
        }

        @NonNull
        public Builder setLocationColor(@NonNull String str) {
            this.f19585b.putString("csa_colorLocation", str);
            return this;
        }

        @NonNull
        public Builder setLocationFontSize(int i4) {
            this.f19585b.putString("csa_fontSizeLocation", Integer.toString(i4));
            return this;
        }

        @NonNull
        public Builder setLongerHeadlines(boolean z3) {
            this.f19585b.putString("csa_longerHeadlines", Boolean.toString(z3));
            return this;
        }

        @NonNull
        public Builder setNumber(int i4) {
            this.f19585b.putString("csa_number", Integer.toString(i4));
            return this;
        }

        @NonNull
        public Builder setPage(int i4) {
            this.f19585b.putString("csa_adPage", Integer.toString(i4));
            return this;
        }

        @NonNull
        public Builder setQuery(@NonNull String str) {
            this.f19584a.zze(str);
            return this;
        }

        @NonNull
        public Builder setStyleId(@NonNull String str) {
            this.f19585b.putString("csa_styleId", str);
            return this;
        }

        @NonNull
        public Builder setVerticalSpacing(int i4) {
            this.f19585b.putString("csa_verticalSpacing", Integer.toString(i4));
            return this;
        }
    }

    /* synthetic */ DynamicHeightSearchAdRequest(Builder builder, zza zzaVar) {
        this.f19583a = new SearchAdRequest(builder.f19584a, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdx a() {
        return this.f19583a.a();
    }

    @Nullable
    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(@NonNull Class<T> cls) {
        return this.f19583a.getCustomEventExtrasBundle(cls);
    }

    @Nullable
    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(@NonNull Class<T> cls) {
        return this.f19583a.getNetworkExtrasBundle(cls);
    }

    @NonNull
    public String getQuery() {
        return this.f19583a.getQuery();
    }

    public boolean isTestDevice(@NonNull Context context) {
        return this.f19583a.isTestDevice(context);
    }
}
