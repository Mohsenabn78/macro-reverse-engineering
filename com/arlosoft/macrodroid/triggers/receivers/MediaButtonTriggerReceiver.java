package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.MediaButtonPressedTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.receivers.MediaButtonTriggerReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class MediaButtonTriggerReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static long f15330a;

    /* renamed from: b  reason: collision with root package name */
    private static final ScheduledExecutorService f15331b = Executors.newScheduledThreadPool(1);

    /* renamed from: c  reason: collision with root package name */
    private static ScheduledFuture f15332c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Context f15333a;

        a(@NonNull Context context) {
            this.f15333a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(ArrayList arrayList) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Macro macro = (Macro) it.next();
                macro.invokeActions(macro.getTriggerContextInfo());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            final ArrayList arrayList = new ArrayList();
            for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Trigger next = it.next();
                        if (next instanceof MediaButtonPressedTrigger) {
                            MediaButtonPressedTrigger mediaButtonPressedTrigger = (MediaButtonPressedTrigger) next;
                            if ((mediaButtonPressedTrigger.getOption().equals(MediaButtonPressedTrigger.TRIPLE_PRESS) && MediaButtonTriggerReceiver.f15330a == 3) || ((mediaButtonPressedTrigger.getOption().equals(MediaButtonPressedTrigger.DOUBLE_PRESS) && MediaButtonTriggerReceiver.f15330a == 2) || (mediaButtonPressedTrigger.getOption().equals(MediaButtonPressedTrigger.PRESS) && MediaButtonTriggerReceiver.f15330a == 1))) {
                                if (next.constraintsMet()) {
                                    macro.setTriggerThatInvoked(next);
                                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                        arrayList.add(macro);
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                new Handler(this.f15333a.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.receivers.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaButtonTriggerReceiver.a.b(arrayList);
                    }
                });
            }
            long unused = MediaButtonTriggerReceiver.f15330a = 0L;
        }
    }

    private void c(Context context, Intent intent) {
        KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (!intent.getBooleanExtra(Util.MEDIA_BUTTON_MACRODROID, false) && keyEvent != null) {
            int keyCode = keyEvent.getKeyCode();
            int action = keyEvent.getAction();
            if (keyCode == 79 && action == 0) {
                f15330a++;
                ScheduledFuture scheduledFuture = f15332c;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                }
                if (f15330a < 3) {
                    f15332c = f15331b.schedule(new a(context), 620L, TimeUnit.MILLISECONDS);
                } else {
                    f15332c = f15331b.schedule(new a(context), 0L, TimeUnit.SECONDS);
                }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_BUTTON")) {
            c(context, intent);
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("MediaButtonTriggerReceiver: Unexpected action: " + intent.getAction()));
    }
}
