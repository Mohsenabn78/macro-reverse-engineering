package com.arlosoft.macrodroid.extras.ui;

import android.content.Intent;
import android.net.Uri;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.extras.data.ExtraPackage;
import com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState;
import com.arlosoft.macrodroid.extras.data.StringWithLanguages;
import com.arlosoft.macrodroid.extras.data.SupportChannel;
import com.arlosoft.macrodroid.extras.data.SupportChannelType;
import com.arlosoft.macrodroid.extras.ui.ExtraPackageClickListener;
import com.arlosoft.macrodroid.remoteconfig.ExtraMinVersion;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;

/* compiled from: ExtrasActivity.kt */
/* loaded from: classes3.dex */
public final class ExtrasActivity$initialiseAdapter$clickListener$1 implements ExtraPackageClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ExtrasActivity f12096a;

    @Override // com.arlosoft.macrodroid.extras.ui.ExtraPackageClickListener
    public void onEmailClicked(@NotNull ExtraPackageWithPriceAndState extraPackage) {
        String stringForLanguage;
        String p4;
        Intrinsics.checkNotNullParameter(extraPackage, "extraPackage");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setFlags(268435456);
        intent.setType("vnd.android.cursor.item/email");
        SupportChannel supportChannel = extraPackage.getExtra().getSupportChannels().getChannels().get(SupportChannelType.EMAIL);
        Intrinsics.checkNotNull(supportChannel);
        intent.putExtra("android.intent.extra.EMAIL", new String[]{supportChannel.getLink()});
        String str = null;
        if (extraPackage.getExtra() != null) {
            StringWithLanguages premiumTitle = extraPackage.getExtra().getSupportChannels().getPremiumTitle();
            String str2 = this.f12096a.f12092g;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
            } else {
                str = str2;
            }
            stringForLanguage = premiumTitle.getStringForLanguage(str);
        } else {
            StringWithLanguages basicTitle = extraPackage.getExtra().getSupportChannels().getBasicTitle();
            String str3 = this.f12096a.f12092g;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
            } else {
                str = str3;
            }
            stringForLanguage = basicTitle.getStringForLanguage(str);
        }
        intent.putExtra("android.intent.extra.SUBJECT", stringForLanguage);
        p4 = this.f12096a.p(extraPackage.getExtra());
        intent.putExtra("android.intent.extra.TEXT", p4);
        this.f12096a.startActivity(Intent.createChooser(intent, "Send mail using..."));
    }

    @Override // com.arlosoft.macrodroid.extras.ui.ExtraPackageClickListener
    public void onInstallVersionUpdateClicked(@NotNull ExtraPackageWithPriceAndState extraPackage) {
        Intrinsics.checkNotNullParameter(extraPackage, "extraPackage");
        ExtrasAdapter extrasAdapter = this.f12096a.f12093h;
        if (extrasAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            extrasAdapter = null;
        }
        extrasAdapter.updateValidatingState(extraPackage.getExtra().getSubscriptionId(), true, false);
        this.f12096a.o(extraPackage, true);
    }

    @Override // com.arlosoft.macrodroid.extras.ui.ExtraPackageClickListener
    public void onManageSubscriptionClicked(@NotNull ExtraPackage extraPackage) {
        Intrinsics.checkNotNullParameter(extraPackage, "extraPackage");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/account/subscriptions"));
        intent.addFlags(268435456);
        this.f12096a.startActivity(intent);
    }

    @Override // com.arlosoft.macrodroid.extras.ui.ExtraPackageClickListener
    public void onNeedsMacroDroidUpdate(@NotNull ExtraMinVersion minVersion) {
        Intrinsics.checkNotNullParameter(minVersion, "minVersion");
        this.f12096a.v(minVersion);
    }

    @Override // com.arlosoft.macrodroid.extras.ui.ExtraPackageClickListener
    public void onPurchaseClick(@NotNull ExtraPackageWithPriceAndState extraPackage, @NotNull ExtraPackageClickListener.PurchasePeriod purchasePeriod) {
        Intrinsics.checkNotNullParameter(extraPackage, "extraPackage");
        Intrinsics.checkNotNullParameter(purchasePeriod, "purchasePeriod");
        this.f12096a.s(extraPackage, purchasePeriod);
    }

    @Override // com.arlosoft.macrodroid.extras.ui.ExtraPackageClickListener
    public void onRetryValidationClicked(@NotNull ExtraPackageWithPriceAndState extraPackage) {
        Intrinsics.checkNotNullParameter(extraPackage, "extraPackage");
        ExtrasAdapter extrasAdapter = this.f12096a.f12093h;
        if (extrasAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            extrasAdapter = null;
        }
        extrasAdapter.updateValidatingState(extraPackage.getExtra().getSubscriptionId(), true, false);
        this.f12096a.o(extraPackage, false);
    }

    @Override // com.arlosoft.macrodroid.extras.ui.ExtraPackageClickListener
    public void onTelegramClicked(@NotNull String telegramChannel) {
        Intrinsics.checkNotNullParameter(telegramChannel, "telegramChannel");
        try {
            this.f12096a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("tg://resolve?domain=" + telegramChannel)));
        } catch (Exception unused) {
            ToastCompat.makeText(this.f12096a, (int) R.string.app_not_found, 1).show();
        }
    }

    @Override // com.arlosoft.macrodroid.extras.ui.ExtraPackageClickListener
    public void onVersionHistoryClicked(@NotNull ExtraPackage extraPackage) {
        Intrinsics.checkNotNullParameter(extraPackage, "extraPackage");
        this.f12096a.x(extraPackage);
    }

    @Override // com.arlosoft.macrodroid.extras.ui.ExtraPackageClickListener
    public void onWhatsAppClicked(@NotNull String whatsAppChannel) {
        Intrinsics.checkNotNullParameter(whatsAppChannel, "whatsAppChannel");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage("com.whatsapp");
            intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=" + whatsAppChannel + "&text="));
            intent.addFlags(268435456);
            intent.addFlags(32768);
            this.f12096a.startActivity(intent);
        } catch (Exception unused) {
            ToastCompat.makeText(this.f12096a, (int) R.string.app_not_found, 1).show();
        }
    }
}
