package com.google.firebase.platforminfo;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;

/* loaded from: classes5.dex */
public class LibraryVersionComponent {

    /* loaded from: classes5.dex */
    public interface VersionExtractor<T> {
        String extract(T t3);
    }

    private LibraryVersionComponent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LibraryVersion b(String str, VersionExtractor versionExtractor, ComponentContainer componentContainer) {
        return LibraryVersion.a(str, versionExtractor.extract((Context) componentContainer.get(Context.class)));
    }

    public static Component<?> create(String str, String str2) {
        return Component.intoSet(LibraryVersion.a(str, str2), LibraryVersion.class);
    }

    public static Component<?> fromContext(final String str, final VersionExtractor<Context> versionExtractor) {
        return Component.intoSetBuilder(LibraryVersion.class).add(Dependency.required(Context.class)).factory(new ComponentFactory() { // from class: com.google.firebase.platforminfo.b
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                LibraryVersion b4;
                b4 = LibraryVersionComponent.b(str, versionExtractor, componentContainer);
                return b4;
            }
        }).build();
    }
}
