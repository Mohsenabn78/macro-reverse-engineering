package com.arlosoft.macrodroid.troubleshooting.help;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseFragment;
import com.arlosoft.macrodroid.databinding.FragmentTroubleshootingHelpBinding;
import com.arlosoft.macrodroid.troubleshooting.help.HelpItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TroubleShootingHelpFragment.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nTroubleShootingHelpFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TroubleShootingHelpFragment.kt\ncom/arlosoft/macrodroid/troubleshooting/help/TroubleShootingHelpFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,36:1\n766#2:37\n857#2,2:38\n*S KotlinDebug\n*F\n+ 1 TroubleShootingHelpFragment.kt\ncom/arlosoft/macrodroid/troubleshooting/help/TroubleShootingHelpFragment\n*L\n33#1:37\n33#1:38,2\n*E\n"})
/* loaded from: classes3.dex */
public final class TroubleShootingHelpFragment extends MacroDroidDaggerBaseFragment {
    public static final int $stable = 8;

    /* renamed from: b  reason: collision with root package name */
    private FragmentTroubleshootingHelpBinding f15822b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final List<HelpItem> f15823c;

    public TroubleShootingHelpFragment() {
        List<HelpItem> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new HelpItem[]{new HelpItem.UnableToUninstall(), new HelpItem.AppKilledInBackground(), new HelpItem.NotStartOnLaunch(), new HelpItem.GeofencesNotWorking(), new HelpItem.ButtonBarBorder(), new HelpItem.SpeakTextNotWorking(), new HelpItem.AccessibilityServiceDisabled(), new HelpItem.AccessibilityServiceSlowdown(), new HelpItem.InteractionInGames(), new HelpItem.WhyNeedHelperFile(), new HelpItem.HighBatteryDrain(), new HelpItem.UIInteractionStopsWorking(), new HelpItem.ProVersionNotApplied(), new HelpItem.WhyLocationPremission(), new HelpItem.HidePersistentNotification(), new HelpItem.DontUnderstandFeature(), new HelpItem.BluetoothActionPopup(), new HelpItem.TranslationsPoorOrMissing()});
        this.f15823c = listOf;
    }

    private final void b() {
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f15823c) {
            if (((HelpItem) obj).shouldShow()) {
                arrayList.add(obj);
            }
        }
        HelpListAdapter helpListAdapter = new HelpListAdapter(arrayList);
        FragmentTroubleshootingHelpBinding fragmentTroubleshootingHelpBinding = this.f15822b;
        if (fragmentTroubleshootingHelpBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTroubleshootingHelpBinding = null;
        }
        fragmentTroubleshootingHelpBinding.recyclerView.setAdapter(helpListAdapter);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        b();
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentTroubleshootingHelpBinding inflate = FragmentTroubleshootingHelpBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.f15822b = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        RecyclerView root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }
}
