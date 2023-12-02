package com.twofortyfouram.locale.sdk.host.internal;

import androidx.annotation.NonNull;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.locale.sdk.host.model.Plugin;
import com.twofortyfouram.locale.sdk.host.model.PluginType;
import com.twofortyfouram.spackle.AndroidSdkVersion;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
final class PluginCharacteristics {
    @NonNull
    private static final Set<String> CONDITIONS_REQUIRING_BACKWARDS_COMPATIBILITY = Collections.unmodifiableSet(getConditionsRequiringBackwardsCompatibility());
    @NonNull
    private static final Set<String> SETTINGS_REQUIRING_BACKWARDS_COMPATIBILITY = Collections.unmodifiableSet(getSettingsRequiringBackwardsCompatibility());
    @NonNull
    private static final Set<String> CONDITIONS_THAT_DRAIN_BATTERY = Collections.unmodifiableSet(getConditionsThatDrainBattery());
    @NonNull
    private static final Set<String> SETTINGS_THAT_DRAIN_BATTERY = Collections.unmodifiableSet(getSettingsThatDrainBattery());
    @NonNull
    private static final Set<String> CONDITIONS_THAT_DISRUPT_CONNECTIVITY = Collections.unmodifiableSet(getConditionsThatDisruptConnectivity());
    @NonNull
    private static final Set<String> SETTINGS_THAT_DISRUPT_CONNECTIVITY = Collections.unmodifiableSet(getSettingsThatDisruptConnectivity());
    @NonNull
    private static final Set<String> CONDITIONS_THAT_REQUIRE_CONNECTIVITY = Collections.unmodifiableSet(getConditionsThatRequireConnectivity());
    @NonNull
    private static final Set<String> SETTINGS_THAT_REQUIRE_CONNECTIVITY = Collections.unmodifiableSet(getSettingsThatRequireConnectivity());
    @NonNull
    private static final Set<String> CONDITIONS_THAT_ARE_BUGGY = Collections.unmodifiableSet(getConditionsThatAreBuggy());
    @NonNull
    private static final Set<String> SETTINGS_THAT_ARE_BUGGY = Collections.unmodifiableSet(getSettingsThatAreBuggy());
    @NonNull
    private static final Set<String> CONDITIONS_THAT_ARE_BLACKLISTED = Collections.unmodifiableSet(getConditionsThatAreBlacklisted());
    @NonNull
    private static final Set<String> SETTINGS_THAT_ARE_BLACKLISTED = Collections.unmodifiableSet(getSettingsThatAreBlacklisted());
    @NonNull
    private static final Map<String, Set<String>> CONDITIONS_THAT_HAVE_ALTERNATIVES = Collections.unmodifiableMap(getConditionsThatHaveAlternatives());
    @NonNull
    private static final Map<String, Set<String>> SETTINGS_THAT_HAVE_ALTERNATIVES = Collections.unmodifiableMap(getSettingsThatHaveAlternatives());

    /* renamed from: com.twofortyfouram.locale.sdk.host.internal.PluginCharacteristics$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType;

        static {
            int[] iArr = new int[PluginType.values().length];
            $SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType = iArr;
            try {
                iArr[PluginType.EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType[PluginType.CONDITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType[PluginType.SETTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private PluginCharacteristics() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    @NonNull
    public static Set<String> getBuiltInAlternative(@NonNull PluginType pluginType, @NonNull String str) {
        Set<String> set;
        Assertions.assertNotNull(pluginType, "type");
        Assertions.assertNotEmpty(str, "registryName");
        int i4 = AnonymousClass1.$SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType[pluginType.ordinal()];
        if (i4 != 1 && i4 != 2) {
            if (i4 == 3) {
                set = SETTINGS_THAT_HAVE_ALTERNATIVES.get(str);
            } else {
                throw new AssertionError();
            }
        } else {
            set = CONDITIONS_THAT_HAVE_ALTERNATIVES.get(str);
        }
        if (set == null) {
            return Collections.emptySet();
        }
        return set;
    }

    @NonNull
    private static Set<String> getConditionsRequiringBackwardsCompatibility() {
        HashSet hashSet = new HashSet();
        hashSet.add(Plugin.generateRegistryName("com.DriftingAway.Skim", "com.DriftingAway.Skim.EditActivity"));
        return hashSet;
    }

    @NonNull
    private static Set<String> getConditionsThatAreBlacklisted() {
        return new HashSet();
    }

    @NonNull
    private static Set<String> getConditionsThatAreBuggy() {
        HashSet hashSet = new HashSet();
        hashSet.add(Plugin.generateRegistryName("org.acm.steidinger.calendar.localePlugin", "org.acm.steidinger.calendar.localePlugin.EditConditionActivity"));
        return hashSet;
    }

    @NonNull
    private static Set<String> getConditionsThatDisruptConnectivity() {
        return new HashSet();
    }

    @NonNull
    private static Set<String> getConditionsThatDrainBattery() {
        HashSet hashSet = new HashSet();
        hashSet.add(Plugin.generateRegistryName("com.DriftingAway.Skim", "com.DriftingAway.Skim.EditActivity"));
        return hashSet;
    }

    @NonNull
    private static Map<String, Set<String>> getConditionsThatHaveAlternatives() {
        HashMap hashMap = new HashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(Plugin.generateRegistryName("com.twofortyfouram.locale", "com.twofortyfouram.locale.ui.activities.CalendarConditionActivity"));
        Set unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        hashMap.put(Plugin.generateRegistryName("org.acm.steidinger.calendar.localePlugin", "org.acm.steidinger.calendar.localePlugin.EditConditionActivity"), unmodifiableSet);
        hashMap.put(Plugin.generateRegistryName("com.DroidMunkey.LocaleCalendarConditions", "com.DroidMunkey.LocaleCalendarConditions.EditActivity"), unmodifiableSet);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        linkedHashSet2.add(Plugin.generateRegistryName("com.twofortyfouram.locale", "com.twofortyfouram.locale.ui.activities.LocationConditionActivity"));
        Set unmodifiableSet2 = Collections.unmodifiableSet(linkedHashSet2);
        hashMap.put(Plugin.generateRegistryName("at.pansy.droid.locale.location", "at.pansy.droid.locale.location.EditActivity"), unmodifiableSet2);
        hashMap.put(Plugin.generateRegistryName("com.DroidMunkey.LocaleWifiConditions", "com.DroidMunkey.LocaleWifiConditions.EditActivity"), unmodifiableSet2);
        hashMap.put(Plugin.generateRegistryName("com.hush.locale.cell_beta", "com.hush.locale.cell_beta.EditActivity"), unmodifiableSet2);
        hashMap.put(Plugin.generateRegistryName("com.joaomgcd.autolocation", "com.joaomgcd.autolocation.activity.ActivityConfigRequestGeofenceReport"), unmodifiableSet2);
        hashMap.put(Plugin.generateRegistryName("com.kanetik.geofence", "com.kanetik.geofence.ui.EditActivity"), unmodifiableSet2);
        hashMap.put(Plugin.generateRegistryName("com.suttco.locale.condition.poi", "com.suttco.locale.condition.poi.EditActivity"), unmodifiableSet2);
        hashMap.put(Plugin.generateRegistryName("net.appstalk.wifimatch", "net.appstalk.wifimatch.ui.EditActivity"), unmodifiableSet2);
        hashMap.put(Plugin.generateRegistryName("org.johanhil.ssid", "org.johanhil.ssid.EditActivity"), unmodifiableSet2);
        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        linkedHashSet3.add(Plugin.generateRegistryName("com.twofortyfouram.locale", "com.twofortyfouram.locale.ui.activities.MovementConditionActivity"));
        Set unmodifiableSet3 = Collections.unmodifiableSet(linkedHashSet3);
        hashMap.put(Plugin.generateRegistryName("com.jarettmillard.localeactivityplugin", "com.jarettmillard.localeactivityplugin.EditActivity"), unmodifiableSet3);
        hashMap.put(Plugin.generateRegistryName("com.kanetik.movement_detection", "com.kanetik.movement_detection.ui.EditActivity"), unmodifiableSet3);
        return hashMap;
    }

    @NonNull
    private static Set<String> getConditionsThatRequireConnectivity() {
        HashSet hashSet = new HashSet();
        hashSet.add(Plugin.generateRegistryName("com.twofortyfouram.locale", "com.twofortyfouram.locale.ui.activities.LocationConditionActivity"));
        return hashSet;
    }

    @NonNull
    private static Set<String> getSettingsRequiringBackwardsCompatibility() {
        HashSet hashSet = new HashSet();
        hashSet.add(Plugin.generateRegistryName("com.dattasmoon.gtalkcontrol", "com.dattasmoon.gtalkcontrol.LocaleEdit"));
        hashSet.add(Plugin.generateRegistryName("com.droidmunkey.localePlaySound", "com.droidmunkey.localePlaySound.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.droidmunkey.LocaleSpeakerphone", "com.droidmunkey.LocaleSpeakerphone.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.DroidMunkey.localeTextToSpeech", "com.DroidMunkey.localeTextToSpeech.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.DroidMunkey.LocaleTimer", "com.DroidMunkey.LocaleTimer.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.DroidMunkey.localeVariables", "com.DroidMunkey.localeVariables.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.DroidMunkey.LocaleVibrate", "com.DroidMunkey.LocaleVibrate.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.google.ase", "com.google.ase.locale.LocalePlugin"));
        hashSet.add(Plugin.generateRegistryName("com.googlecode.android_scripting", "com.googlecode.android_scripting.LocalePlugin"));
        hashSet.add(Plugin.generateRegistryName("com.handyandy.whoisit", "com.handyandy.whoisit.TaskerActivateProfile"));
        hashSet.add(Plugin.generateRegistryName("org.handydroid.openwatch.locale.button", "org.handydroid.openwatch.locale.button.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("org.handydroid.openwatch.locale.graphic", "org.handydroid.openwatch.locale.graphic.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("org.handydroid.openwatch.locale.message", "org.handydroid.openwatch.locale.message.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.levelup.foxyring", "com.levelup.foxyring.EditYourSettingActivity"));
        hashSet.add(Plugin.generateRegistryName("com.mariobialos.LocaleDialPlugIn", "com.mariobialos.LocaleDialPlugIn.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.mariobialos.LocaleHapticPlugIn", "com.mariobialos.LocaleHapticPlugIn.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.mariobialos.LocalePrevLocationPlugIn", "com.mariobialos.LocalePrevLocationPlugIn.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.mariobialos.LocaleRotateScreenPlugIn", "com.mariobialos.LocaleRotateScreenPlugIn.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.mariobialos.LocaleVoiceCallPlugIn", "com.mariobialos.LocaleVoiceCallPlugIn.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.mb.locale.cardock", "com.mb.locale.cardock.LocaleEditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.mooapps.autolock", "com.mooapps.autolock.LocaleSettings"));
        hashSet.add(Plugin.generateRegistryName("com.mooapps.autolock2", "com.mooapps.autolock2.LocaleSettings"));
        hashSet.add(Plugin.generateRegistryName("com.olib.locplug.scenemode", "com.olib.locplug.scenemode.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.olib.locplug.scenemodepro", "com.olib.locplug.scenemodepro.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.smartideas.handsfreesmsdemo", "com.smartideas.handsfreesmsdemo.locale.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.smartideas.handsfreesms", "com.smartideas.handsfreesms.locale.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.splunchy.android.speakingringtone", "com.splunchy.android.speakingringtone.LocaleSettingEditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.steelgirder.LocaleSendEmailPlugin", "com.steelgirder.LocaleSendEmailPlugin.EditYourSettingActivity"));
        hashSet.add(Plugin.generateRegistryName("com.steelgirder.LocaleWOLPlugin", "com.steelgirder.LocaleWOLPlugin.EditYourSettingActivity"));
        hashSet.add(Plugin.generateRegistryName("com.steelgirder.LocalePingFMPlugin", "com.steelgirder.LocalePingFMPlugin.EditYourSettingActivity"));
        hashSet.add(Plugin.generateRegistryName("com.sugree.jibjib", "com.sugree.jibjib.LocaleSettingActivity"));
        hashSet.add(Plugin.generateRegistryName("com.al.SmartReply.Deluxe", "com.al.SmartReply.Deluxe.LocaleEditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.al.SmartReply.Pro", "com.al.SmartReply.Pro.LocaleEditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.pwnwithyourphone.talkingcalendar", "com.pwnwithyourphone.talkingcalendar.locale.SetupActivity"));
        hashSet.add(Plugin.generateRegistryName("com.pwnwithyourphone.talkingcalendar.trial", "com.pwnwithyourphone.talkingcalendar.locale.SetupActivity"));
        hashSet.add(Plugin.generateRegistryName("com.tenromans.locale.systemnotification", "com.tenromans.locale.systemnotification.EditSystemNotificationActivity"));
        hashSet.add(Plugin.generateRegistryName("com.tenromans.locale.emailsilencer", "com.tenromans.locale.emailsilencer.EditSystemNotificationActivity"));
        hashSet.add(Plugin.generateRegistryName("com.twofortyfouram.locale.setting.gps", "com.twofortyfouram.locale.setting.gps.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.yurivolkov.android.locale_audio_update_notifier", "com.yurivolkov.android.locale_audio_update_notifier.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("de.elmicha.app.LocaleExecute", "de.elmicha.app.LocaleExecute.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("de.sifl.wolcale", "de.sifl.wolcale.EditYourSettingActivity"));
        hashSet.add(Plugin.generateRegistryName("mobi.gearsoft.android.wifisync", "mobi.gearsoft.android.wifisync.LocaleEditSettings"));
        hashSet.add(Plugin.generateRegistryName("net.andvari.android.notificationsetting", "net.andvari.android.notificationsetting.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("net.andvari.android.syncsetting", "net.andvari.android.syncsetting.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("org.adaptroid.habitats", "org.adaptroid.habitats.EditLocaleSettingActivity"));
        hashSet.add(Plugin.generateRegistryName("org.damazio.notifier.locale.notify", "org.damazio.notifier.locale.notify.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("org.darune.autowakeonlan", "org.darune.autowakeonlan.AutoWakeOnLan"));
        hashSet.add(Plugin.generateRegistryName("org.mailboxer.saymyname", "com.announcify.ui.activity.LocaleActivity"));
        return hashSet;
    }

    @NonNull
    private static Set<String> getSettingsThatAreBlacklisted() {
        HashSet hashSet = new HashSet();
        if (AndroidSdkVersion.isAtLeastSdk(16)) {
            hashSet.add(Plugin.generateRegistryName("com.kludgenics.locale.superplane", "com.kludgenics.locale.superplane.EditActivity"));
            hashSet.add(Plugin.generateRegistryName("com.twofortyfouram.locale.setting.airplanemode", "com.twofortyfouram.locale.setting.airplanemode.EditActivity"));
            hashSet.add(Plugin.generateRegistryName("com.willemstoker.AutoPilot", "com.willemstoker.AutoPilot.EditYourSettingActivity"));
        }
        return hashSet;
    }

    @NonNull
    private static Set<String> getSettingsThatAreBuggy() {
        HashSet hashSet = new HashSet();
        hashSet.add(Plugin.generateRegistryName("com.akiware.locale.allvolumes", "com.akiware.locale.allvolumes.EditActivity"));
        return hashSet;
    }

    @NonNull
    private static Set<String> getSettingsThatDisruptConnectivity() {
        HashSet hashSet = new HashSet();
        hashSet.add(Plugin.generateRegistryName("com.codecarpet.apndroid.locale", "com.google.code.apndroid.LocaleActivity"));
        hashSet.add(Plugin.generateRegistryName("com.kludgenics.locale.superplane", "com.kludgenics.locale.superplane.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.twofortyfouram.locale.setting.airplanemode", "com.twofortyfouram.locale.setting.airplanemode.EditActivity"));
        hashSet.add(Plugin.generateRegistryName("com.willemstoker.AutoPilot", "com.willemstoker.AutoPilot.EditYourSettingActivity"));
        hashSet.add(Plugin.generateRegistryName("com.suttco.locale.net", "com.suttco.locale.net.DataEnabledSettingActivity"));
        return hashSet;
    }

    @NonNull
    private static Set<String> getSettingsThatDrainBattery() {
        return new HashSet();
    }

    @NonNull
    private static Map<String, Set<String>> getSettingsThatHaveAlternatives() {
        HashMap hashMap = new HashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(Plugin.generateRegistryName("com.twofortyfouram.locale", "com.twofortyfouram.locale.ui.activities.VolumeSettingActivity"));
        linkedHashSet.add(Plugin.generateRegistryName("com.twofortyfouram.locale", "com.twofortyfouram.locale.ui.activities.VolumeMediaSettingActivity"));
        Set unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        hashMap.put(Plugin.generateRegistryName("com.akiware.locale.allvolumes", "com.akiware.locale.allvolumes.EditActivity"), unmodifiableSet);
        hashMap.put(Plugin.generateRegistryName("com.olib.locplug.scenemode", "com.olib.locplug.scenemode.EditActivity"), unmodifiableSet);
        hashMap.put(Plugin.generateRegistryName("com.olib.locplug.scenemodepro", "com.olib.locplug.scenemodepro.EditActivity"), unmodifiableSet);
        return hashMap;
    }

    @NonNull
    private static Set<String> getSettingsThatRequireConnectivity() {
        return new HashSet();
    }

    public static boolean isBackwardsCompatibilityEnabled(@NonNull PluginType pluginType, @NonNull String str) {
        Assertions.assertNotNull(pluginType, "type");
        Assertions.assertNotEmpty(str, "registryName");
        int i4 = AnonymousClass1.$SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType[pluginType.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    return SETTINGS_REQUIRING_BACKWARDS_COMPATIBILITY.contains(str);
                }
                throw new AssertionError();
            }
            return CONDITIONS_REQUIRING_BACKWARDS_COMPATIBILITY.contains(str);
        }
        return CONDITIONS_REQUIRING_BACKWARDS_COMPATIBILITY.contains(str);
    }

    public static boolean isBlacklisted(@NonNull PluginType pluginType, @NonNull String str) {
        Assertions.assertNotNull(pluginType, "type");
        Assertions.assertNotEmpty(str, "registryName");
        int i4 = AnonymousClass1.$SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType[pluginType.ordinal()];
        if (i4 != 1 && i4 != 2) {
            if (i4 == 3) {
                return SETTINGS_THAT_ARE_BLACKLISTED.contains(str);
            }
            throw new AssertionError();
        }
        return CONDITIONS_THAT_ARE_BLACKLISTED.contains(str);
    }

    public static boolean isBuggy(@NonNull PluginType pluginType, @NonNull String str) {
        Assertions.assertNotNull(pluginType, "type");
        Assertions.assertNotEmpty(str, "registryName");
        int i4 = AnonymousClass1.$SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType[pluginType.ordinal()];
        if (i4 != 1 && i4 != 2) {
            if (i4 == 3) {
                return SETTINGS_THAT_ARE_BUGGY.contains(str);
            }
            throw new AssertionError();
        }
        return CONDITIONS_THAT_ARE_BUGGY.contains(str);
    }

    public static boolean isDisruptsConnectivity(@NonNull PluginType pluginType, @NonNull String str) {
        Assertions.assertNotNull(pluginType, "type");
        Assertions.assertNotEmpty(str, "registryName");
        int i4 = AnonymousClass1.$SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType[pluginType.ordinal()];
        if (i4 != 1 && i4 != 2) {
            if (i4 == 3) {
                return SETTINGS_THAT_DISRUPT_CONNECTIVITY.contains(str);
            }
            throw new AssertionError();
        }
        return CONDITIONS_THAT_DISRUPT_CONNECTIVITY.contains(str);
    }

    public static boolean isDrainsBattery(@NonNull PluginType pluginType, @NonNull String str) {
        Assertions.assertNotNull(pluginType, "type");
        Assertions.assertNotEmpty(str, "registryName");
        int i4 = AnonymousClass1.$SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType[pluginType.ordinal()];
        if (i4 != 1 && i4 != 2) {
            if (i4 == 3) {
                return SETTINGS_THAT_DRAIN_BATTERY.contains(str);
            }
            throw new AssertionError();
        }
        return CONDITIONS_THAT_DRAIN_BATTERY.contains(str);
    }

    public static boolean isRequiresConnectivity(@NonNull PluginType pluginType, @NonNull String str) {
        Assertions.assertNotNull(pluginType, "type");
        Assertions.assertNotEmpty(str, "registryName");
        int i4 = AnonymousClass1.$SwitchMap$com$twofortyfouram$locale$sdk$host$model$PluginType[pluginType.ordinal()];
        if (i4 != 1 && i4 != 2) {
            if (i4 == 3) {
                return SETTINGS_THAT_REQUIRE_CONNECTIVITY.contains(str);
            }
            throw new AssertionError();
        }
        return CONDITIONS_THAT_REQUIRE_CONNECTIVITY.contains(str);
    }
}
