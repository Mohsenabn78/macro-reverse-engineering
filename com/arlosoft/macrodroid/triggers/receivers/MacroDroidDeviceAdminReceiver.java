package com.arlosoft.macrodroid.triggers.receivers;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class MacroDroidDeviceAdminReceiver extends DeviceAdminReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final List<Long> f15329a = new ArrayList();

    @Override // android.app.admin.DeviceAdminReceiver
    public CharSequence onDisableRequested(Context context, Intent intent) {
        return context.getString(R.string.disable_macrodroid_device_administration);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00bd  */
    @Override // android.app.admin.DeviceAdminReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPasswordFailed(android.content.Context r14, android.content.Intent r15) {
        /*
            r13 = this;
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.List<java.lang.Long> r15 = com.arlosoft.macrodroid.triggers.receivers.MacroDroidDeviceAdminReceiver.f15329a
            int r0 = r15.size()
            r1 = 1
            if (r0 <= 0) goto L29
            int r0 = r15.size()
            int r0 = r0 - r1
            java.lang.Object r15 = r15.get(r0)
            java.lang.Long r15 = (java.lang.Long) r15
            long r2 = r15.longValue()
            long r4 = java.lang.System.currentTimeMillis()
            r6 = 100
            long r2 = r2 + r6
            int r15 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r15 > 0) goto L29
            return
        L29:
            com.arlosoft.macrodroid.macro.MacroStore r15 = com.arlosoft.macrodroid.macro.MacroStore.getInstance()
            java.util.List r15 = r15.getEnabledMacros()
            java.util.Iterator r15 = r15.iterator()
            r0 = 0
            r2 = 0
        L37:
            boolean r3 = r15.hasNext()
            if (r3 == 0) goto Lc3
            java.lang.Object r3 = r15.next()
            com.arlosoft.macrodroid.macro.Macro r3 = (com.arlosoft.macrodroid.macro.Macro) r3
            java.util.ArrayList r4 = r3.getTriggerListWithAwaitingActions()
            java.util.Iterator r4 = r4.iterator()
        L4b:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L37
            java.lang.Object r5 = r4.next()
            com.arlosoft.macrodroid.triggers.Trigger r5 = (com.arlosoft.macrodroid.triggers.Trigger) r5
            boolean r6 = r5 instanceof com.arlosoft.macrodroid.triggers.FailedLoginTrigger
            if (r6 == 0) goto L4b
            java.util.List<java.lang.Long> r6 = com.arlosoft.macrodroid.triggers.receivers.MacroDroidDeviceAdminReceiver.f15329a
            int r7 = r6.size()
            r8 = 3
            if (r7 <= r8) goto L67
            r6.remove(r8)
        L67:
            long r7 = java.lang.System.currentTimeMillis()
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            r6.add(r0, r7)
            r7 = r5
            com.arlosoft.macrodroid.triggers.FailedLoginTrigger r7 = (com.arlosoft.macrodroid.triggers.FailedLoginTrigger) r7
            int r8 = r7.getNumFailures()
            int r7 = r7.getTimePeriod()
            if (r8 != r1) goto L81
        L7f:
            r6 = 1
            goto La8
        L81:
            int r6 = r6.size()
            if (r8 > r6) goto La7
            long r9 = java.lang.System.currentTimeMillis()
            r11 = 1000(0x3e8, double:4.94E-321)
            long r9 = r9 / r11
            long r6 = (long) r7
            long r9 = r9 - r6
            r6 = 0
        L91:
            if (r6 >= r8) goto L7f
            java.util.List<java.lang.Long> r7 = com.arlosoft.macrodroid.triggers.receivers.MacroDroidDeviceAdminReceiver.f15329a
            java.lang.Object r7 = r7.get(r6)
            java.lang.Long r7 = (java.lang.Long) r7
            long r11 = r7.longValue()
            int r7 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r7 >= 0) goto La4
            goto La7
        La4:
            int r6 = r6 + 1
            goto L91
        La7:
            r6 = 0
        La8:
            if (r6 == 0) goto L4b
            boolean r6 = r5.constraintsMet()
            if (r6 == 0) goto L4b
            r3.setTriggerThatInvoked(r5)
            com.arlosoft.macrodroid.triggers.TriggerContextInfo r2 = r3.getTriggerContextInfo()
            boolean r2 = r3.canInvoke(r2)
            if (r2 == 0) goto Lc0
            r14.add(r3)
        Lc0:
            r2 = 1
            goto L37
        Lc3:
            java.util.Iterator r14 = r14.iterator()
        Lc7:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto Ldb
            java.lang.Object r15 = r14.next()
            com.arlosoft.macrodroid.macro.Macro r15 = (com.arlosoft.macrodroid.macro.Macro) r15
            com.arlosoft.macrodroid.triggers.TriggerContextInfo r0 = r15.getTriggerContextInfo()
            r15.invokeActions(r0)
            goto Lc7
        Ldb:
            if (r2 == 0) goto Le2
            java.util.List<java.lang.Long> r14 = com.arlosoft.macrodroid.triggers.receivers.MacroDroidDeviceAdminReceiver.f15329a
            r14.clear()
        Le2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.receivers.MacroDroidDeviceAdminReceiver.onPasswordFailed(android.content.Context, android.content.Intent):void");
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public void onPasswordSucceeded(Context context, Intent intent) {
        f15329a.clear();
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public void onDisabled(Context context, Intent intent) {
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public void onEnabled(Context context, Intent intent) {
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public void onPasswordChanged(Context context, Intent intent) {
    }
}
