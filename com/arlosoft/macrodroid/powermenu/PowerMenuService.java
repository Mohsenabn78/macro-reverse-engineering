package com.arlosoft.macrodroid.powermenu;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.service.controls.Control;
import android.service.controls.ControlsProviderService;
import android.service.controls.actions.ControlAction;
import android.service.controls.templates.StatelessTemplate;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.powermenu.PowerMenuService;
import com.arlosoft.macrodroid.triggers.InvokedByPowerMenuTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import io.reactivex.processors.ReplayProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.function.Consumer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.FlowAdapters;

/* compiled from: PowerMenuService.kt */
@StabilityInferred(parameters = 0)
@RequiresApi(29)
/* loaded from: classes3.dex */
public final class PowerMenuService extends ControlsProviderService {
    public static final int CONTROL_REQUEST_CODE = 11;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ReplayProcessor<Control> f13253a;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: PowerMenuService.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PowerMenuService() {
        ReplayProcessor<Control> create = ReplayProcessor.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Control>()");
        this.f13253a = create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(List controls, Flow.Subscriber subscriber) {
        Intrinsics.checkNotNullParameter(controls, "$controls");
        Iterator it = controls.iterator();
        while (it.hasNext()) {
            subscriber.onNext((Control) it.next());
        }
        subscriber.onComplete();
    }

    private final List<Control> c() {
        Control.StatelessBuilder title;
        Control.StatelessBuilder subtitle;
        Icon createWithResource;
        Control.StatelessBuilder customIcon;
        Control.StatelessBuilder deviceType;
        Control.StatelessBuilder structure;
        Control build;
        Context baseContext = getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
        PendingIntent activity = PendingIntent.getActivity(baseContext, 11, new Intent(), 134217728 | PendingIntentHelper.FLAG_MUTABLE);
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacros()) {
            title = new Control.StatelessBuilder(String.valueOf(macro.getGUID()), activity).setTitle(macro.getName());
            subtitle = title.setSubtitle(macro.getCategory());
            createWithResource = Icon.createWithResource(this, (int) R.drawable.launcher_no_border);
            customIcon = subtitle.setCustomIcon(createWithResource);
            deviceType = customIcon.setDeviceType(0);
            structure = deviceType.setStructure(getString(R.string.macrodroid));
            build = structure.build();
            Intrinsics.checkNotNullExpressionValue(build, "StatelessBuilder(macro.g…                 .build()");
            arrayList.add(build);
        }
        return arrayList;
    }

    @Override // android.service.controls.ControlsProviderService
    @NotNull
    public Flow.Publisher<Control> createPublisherFor(@NotNull List<String> controlIds) {
        Control.StatefulBuilder title;
        Control.StatefulBuilder subtitle;
        Control.StatefulBuilder structure;
        Control.StatefulBuilder deviceType;
        Icon createWithResource;
        Control.StatefulBuilder customIcon;
        Control.StatefulBuilder status;
        Control.StatefulBuilder controlTemplate;
        Control build;
        Intrinsics.checkNotNullParameter(controlIds, "controlIds");
        c();
        List<Macro> allCompletedMacros = MacroStore.getInstance().getAllCompletedMacros();
        PendingIntent activity = PendingIntent.getActivity(this, 1, new Intent(), 134217728 | PendingIntentHelper.FLAG_MUTABLE);
        for (Macro macro : allCompletedMacros) {
            if (controlIds.contains(String.valueOf(macro.getGUID()))) {
                title = new Control.StatefulBuilder(String.valueOf(macro.getGUID()), activity).setTitle(macro.getName());
                subtitle = title.setSubtitle(macro.getCategory());
                structure = subtitle.setStructure(getString(R.string.macrodroid));
                deviceType = structure.setDeviceType(0);
                createWithResource = Icon.createWithResource(this, (int) R.drawable.launcher_no_border);
                customIcon = deviceType.setCustomIcon(createWithResource);
                status = customIcon.setStatus(1);
                controlTemplate = status.setControlTemplate(new StatelessTemplate(getString(R.string.macrodroid)));
                build = controlTemplate.build();
                Intrinsics.checkNotNullExpressionValue(build, "StatefulBuilder(macro.gu…                 .build()");
                this.f13253a.onNext(build);
            }
        }
        Flow.Publisher<Control> flowPublisher = FlowAdapters.toFlowPublisher(this.f13253a);
        Intrinsics.checkNotNullExpressionValue(flowPublisher, "toFlowPublisher(updatePublisher)");
        return flowPublisher;
    }

    @Override // android.service.controls.ControlsProviderService
    @NotNull
    public Flow.Publisher<Control> createPublisherForAllAvailable() {
        final List<Control> c4 = c();
        return new Flow.Publisher() { // from class: g0.s
            @Override // java.util.concurrent.Flow.Publisher
            public final void subscribe(Flow.Subscriber subscriber) {
                PowerMenuService.b(c4, subscriber);
            }
        };
    }

    @Override // android.service.controls.ControlsProviderService
    public void performControlAction(@NotNull String controlId, @NotNull ControlAction action, @NotNull Consumer<Integer> consumer) {
        Control.StatefulBuilder title;
        Control.StatefulBuilder subtitle;
        Control.StatefulBuilder structure;
        Control.StatefulBuilder deviceType;
        Icon createWithResource;
        Control.StatefulBuilder customIcon;
        Control.StatefulBuilder status;
        Control.StatefulBuilder controlTemplate;
        Control build;
        Intrinsics.checkNotNullParameter(controlId, "controlId");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        consumer.accept(1);
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(Long.parseLong(controlId));
        if (macroByGUID != null) {
            macroByGUID.setTriggerThatInvoked(InvokedByPowerMenuTrigger.getInstance());
            macroByGUID.invokeActions(new TriggerContextInfo(""));
            title = new Control.StatefulBuilder(String.valueOf(macroByGUID.getGUID()), PendingIntent.getActivity(this, 1, new Intent(), 134217728 | PendingIntentHelper.FLAG_MUTABLE)).setTitle(macroByGUID.getName());
            subtitle = title.setSubtitle(macroByGUID.getCategory());
            structure = subtitle.setStructure(getString(R.string.macrodroid));
            deviceType = structure.setDeviceType(0);
            createWithResource = Icon.createWithResource(this, (int) R.drawable.launcher_no_border);
            customIcon = deviceType.setCustomIcon(createWithResource);
            status = customIcon.setStatus(1);
            controlTemplate = status.setControlTemplate(new StatelessTemplate(getString(R.string.macrodroid)));
            build = controlTemplate.build();
            Intrinsics.checkNotNullExpressionValue(build, "StatefulBuilder(macro.gu…                 .build()");
            this.f13253a.onNext(build);
            return;
        }
        SystemLog.logError("Power control failed - macro not found");
    }
}
