package com.arlosoft.macrodroid.upgrade;

import com.arlosoft.macrodroid.R;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: UpgradeBlurbItem.kt */
/* loaded from: classes3.dex */
public final class UpgradeBlurbItemKt {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final List<UpgradeBlurbItem> f15888a;

    static {
        List<UpgradeBlurbItem> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new UpgradeBlurbItem[]{new UpgradeBlurbItem(R.string.upgrade_unlimited_macros_title, R.string.upgrade_unlimited_macros_desription, R.drawable.upgrade_unlimited), new UpgradeBlurbItem(R.string.upgrade_unlimited_no_adverts_title, R.string.upgrade_unlimited_no_adverts_description, R.drawable.upgrade_no_ads), new UpgradeBlurbItem(R.string.cloud_backup, R.string.upgrade_cloud_backup_description, R.drawable.upgrade_cloud), new UpgradeBlurbItem(R.string.upgrade_unlimited_no_template_store_title, R.string.upgrade_unlimited_no_template_store_description, R.drawable.upgrade_community), new UpgradeBlurbItem(R.string.upgrade_no_subscriptions_title, R.string.upgrade_no_subscriptions_description, R.drawable.upgrade_no_subscriptions), new UpgradeBlurbItem(R.string.upgrade_unlimited_support_us_title, R.string.upgrade_unlimited_support_us_description, R.drawable.upgrade_support_us)});
        f15888a = listOf;
    }

    @NotNull
    public static final List<UpgradeBlurbItem> getUpgradeBlurbItems() {
        return f15888a;
    }
}
