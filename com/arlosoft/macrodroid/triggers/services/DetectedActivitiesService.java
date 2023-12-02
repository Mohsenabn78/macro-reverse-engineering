package com.arlosoft.macrodroid.triggers.services;

import android.app.IntentService;
import android.content.Intent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.ActivityRecognitionTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class DetectedActivitiesService extends IntentService {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f15424a = {"In vehicle", "On Bicycle", "On Foot", "Still", "Unknown", "Tilting", "?????", "Walking", "Running"};

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Trigger, DetectedActivity> f15425b = new HashMap();

    public DetectedActivitiesService() {
        super("activity-detection-service");
    }

    private DetectedActivity a(List<DetectedActivity> list) {
        DetectedActivity detectedActivity = null;
        int i4 = 0;
        for (DetectedActivity detectedActivity2 : list) {
            if (detectedActivity2.getType() == 8 || detectedActivity2.getType() == 7) {
                if (detectedActivity2.getConfidence() > i4) {
                    i4 = detectedActivity2.getConfidence();
                    detectedActivity = detectedActivity2;
                }
            }
        }
        return detectedActivity;
    }

    public static void clearOldTrigger(Trigger trigger) {
        f15425b.remove(trigger);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        DetectedActivity detectedActivity;
        HashMap hashMap = new HashMap();
        if (ActivityRecognitionResult.hasResult(intent)) {
            List<DetectedActivity> probableActivities = ActivityRecognitionResult.extractResult(intent).getProbableActivities();
            for (DetectedActivity detectedActivity2 : probableActivities) {
                hashMap.put(Integer.valueOf(detectedActivity2.getType()), detectedActivity2);
            }
            Iterator<DetectedActivity> it = probableActivities.iterator();
            while (true) {
                if (it.hasNext()) {
                    detectedActivity = it.next();
                    if (detectedActivity.getType() != 5 && detectedActivity.getType() != 4) {
                        break;
                    }
                } else {
                    detectedActivity = null;
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (DetectedActivity detectedActivity3 : probableActivities) {
                if (detectedActivity3.getType() != 2) {
                    int type = detectedActivity3.getType();
                    String[] strArr = f15424a;
                    if (type < strArr.length) {
                        sb.append(strArr[detectedActivity3.getType()]);
                        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        sb.append(detectedActivity3.getConfidence());
                        sb.append("%,");
                    }
                }
            }
            SystemLog.logVerbose(sb.substring(0, sb.length() - 1) + "]");
            if (detectedActivity != null) {
                SystemLog.logDebug("mostProbableActivity = " + detectedActivity);
                if (detectedActivity.getType() == 2) {
                    detectedActivity = a(probableActivities);
                    if (detectedActivity != null) {
                        SystemLog.logDebug("ON_FOOT mostProbableActivity = " + detectedActivity);
                    } else {
                        SystemLog.logWarning("On foot - but not walking or running?");
                        return;
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                    Iterator<Trigger> it2 = macro.getTriggerListWithAwaitingActions().iterator();
                    while (it2.hasNext()) {
                        Trigger next = it2.next();
                        if (next instanceof ActivityRecognitionTrigger) {
                            ActivityRecognitionTrigger activityRecognitionTrigger = (ActivityRecognitionTrigger) next;
                            Map<Trigger, DetectedActivity> map = f15425b;
                            DetectedActivity detectedActivity4 = map.get(next);
                            if (activityRecognitionTrigger.getLessThan()) {
                                DetectedActivity detectedActivity5 = (DetectedActivity) hashMap.get(Integer.valueOf(activityRecognitionTrigger.getActivityType()));
                                if (detectedActivity5 != null && detectedActivity5.getConfidence() >= activityRecognitionTrigger.getConfidenceLevel()) {
                                    map.put(next, null);
                                } else if (detectedActivity4 == null || detectedActivity4.getType() != activityRecognitionTrigger.getActivityType()) {
                                    if (next.constraintsMet()) {
                                        macro.setTriggerThatInvoked(next);
                                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                            arrayList.add(macro);
                                        }
                                        map.put(next, detectedActivity5);
                                    }
                                }
                            } else if (detectedActivity4 == null || detectedActivity4.getType() != detectedActivity.getType()) {
                                if (activityRecognitionTrigger.getActivityType() == detectedActivity.getType()) {
                                    if (detectedActivity.getConfidence() > activityRecognitionTrigger.getConfidenceLevel() && next.constraintsMet()) {
                                        SystemLog.logDebug("lastRecordedType = " + detectedActivity4 + ", mostProbableActivity = " + detectedActivity);
                                        macro.setTriggerThatInvoked(next);
                                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                            arrayList.add(macro);
                                        }
                                        map.put(next, detectedActivity);
                                    }
                                } else {
                                    SystemLog.logDebug("Saving most probable activity for trigger (" + next.getListModeName() + "): " + detectedActivity);
                                    map.put(next, detectedActivity);
                                }
                            }
                        }
                    }
                }
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    Macro macro2 = (Macro) it3.next();
                    macro2.invokeActions(macro2.getTriggerContextInfo());
                }
            }
        }
    }
}
