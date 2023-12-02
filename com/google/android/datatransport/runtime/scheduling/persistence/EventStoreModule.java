package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;

@Module
/* loaded from: classes.dex */
public abstract class EventStoreModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Named("SQLITE_DB_NAME")
    public static String a() {
        return "com.google.android.datatransport.events";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    @Named("PACKAGE_NAME")
    public static String b(Context context) {
        return context.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Named("SCHEMA_VERSION")
    public static int c() {
        return SchemaManager.f18897d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static EventStoreConfig d() {
        return EventStoreConfig.f18878a;
    }
}
