package com.arlosoft.macrodroid.triggers;

import com.arlosoft.macrodroid.triggers.mediabutton.MediaButtonDetection;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MediaButtonV2Trigger_MembersInjector implements MembersInjector<MediaButtonV2Trigger> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MediaButtonDetection> f14385a;

    public MediaButtonV2Trigger_MembersInjector(Provider<MediaButtonDetection> provider) {
        this.f14385a = provider;
    }

    public static MembersInjector<MediaButtonV2Trigger> create(Provider<MediaButtonDetection> provider) {
        return new MediaButtonV2Trigger_MembersInjector(provider);
    }

    public static void injectMediaButtonDetection(MediaButtonV2Trigger mediaButtonV2Trigger, MediaButtonDetection mediaButtonDetection) {
        mediaButtonV2Trigger.mediaButtonDetection = mediaButtonDetection;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MediaButtonV2Trigger mediaButtonV2Trigger) {
        injectMediaButtonDetection(mediaButtonV2Trigger, this.f14385a.get());
    }
}
