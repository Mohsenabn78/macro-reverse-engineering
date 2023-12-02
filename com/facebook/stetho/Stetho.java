package com.facebook.stetho;

import android.app.Application;
import android.content.Context;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.dumpapp.DumpappHttpSocketLikeHandler;
import com.facebook.stetho.dumpapp.DumpappSocketLikeHandler;
import com.facebook.stetho.dumpapp.Dumper;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.facebook.stetho.dumpapp.plugins.CrashDumperPlugin;
import com.facebook.stetho.dumpapp.plugins.FilesDumperPlugin;
import com.facebook.stetho.dumpapp.plugins.HprofDumperPlugin;
import com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin;
import com.facebook.stetho.inspector.DevtoolsSocketHandler;
import com.facebook.stetho.inspector.console.RuntimeReplFactory;
import com.facebook.stetho.inspector.database.DatabaseDriver2Adapter;
import com.facebook.stetho.inspector.database.DatabaseFilesProvider;
import com.facebook.stetho.inspector.database.DefaultDatabaseConnectionProvider;
import com.facebook.stetho.inspector.database.DefaultDatabaseFilesProvider;
import com.facebook.stetho.inspector.database.SqliteDatabaseDriver;
import com.facebook.stetho.inspector.elements.Document;
import com.facebook.stetho.inspector.elements.DocumentProviderFactory;
import com.facebook.stetho.inspector.elements.android.ActivityTracker;
import com.facebook.stetho.inspector.elements.android.AndroidDocumentProviderFactory;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.module.CSS;
import com.facebook.stetho.inspector.protocol.module.Console;
import com.facebook.stetho.inspector.protocol.module.DOM;
import com.facebook.stetho.inspector.protocol.module.DOMStorage;
import com.facebook.stetho.inspector.protocol.module.Database;
import com.facebook.stetho.inspector.protocol.module.DatabaseDriver2;
import com.facebook.stetho.inspector.protocol.module.Debugger;
import com.facebook.stetho.inspector.protocol.module.HeapProfiler;
import com.facebook.stetho.inspector.protocol.module.Inspector;
import com.facebook.stetho.inspector.protocol.module.Network;
import com.facebook.stetho.inspector.protocol.module.Page;
import com.facebook.stetho.inspector.protocol.module.Profiler;
import com.facebook.stetho.inspector.protocol.module.Runtime;
import com.facebook.stetho.inspector.protocol.module.Worker;
import com.facebook.stetho.inspector.runtime.RhinoDetectingRuntimeReplFactory;
import com.facebook.stetho.server.AddressNameHelper;
import com.facebook.stetho.server.LazySocketHandler;
import com.facebook.stetho.server.LocalSocketServer;
import com.facebook.stetho.server.ProtocolDetectingSocketHandler;
import com.facebook.stetho.server.ServerManager;
import com.facebook.stetho.server.SocketHandler;
import com.facebook.stetho.server.SocketHandlerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class Stetho {

    /* loaded from: classes3.dex */
    private static class BuilderBasedInitializer extends Initializer {
        @Nullable
        private final DumperPluginsProvider mDumperPlugins;
        @Nullable
        private final InspectorModulesProvider mInspectorModules;

        @Override // com.facebook.stetho.Stetho.Initializer
        @Nullable
        protected Iterable<DumperPlugin> getDumperPlugins() {
            DumperPluginsProvider dumperPluginsProvider = this.mDumperPlugins;
            if (dumperPluginsProvider != null) {
                return dumperPluginsProvider.get();
            }
            return null;
        }

        @Override // com.facebook.stetho.Stetho.Initializer
        @Nullable
        protected Iterable<ChromeDevtoolsDomain> getInspectorModules() {
            InspectorModulesProvider inspectorModulesProvider = this.mInspectorModules;
            if (inspectorModulesProvider != null) {
                return inspectorModulesProvider.get();
            }
            return null;
        }

        private BuilderBasedInitializer(InitializerBuilder initializerBuilder) {
            super(initializerBuilder.mContext);
            this.mDumperPlugins = initializerBuilder.mDumperPlugins;
            this.mInspectorModules = initializerBuilder.mInspectorModules;
        }
    }

    /* loaded from: classes3.dex */
    public static final class DefaultDumperPluginsBuilder {
        private final Context mContext;
        private final PluginBuilder<DumperPlugin> mDelegate = new PluginBuilder<>();

        public DefaultDumperPluginsBuilder(Context context) {
            this.mContext = context;
        }

        private DefaultDumperPluginsBuilder provideIfDesired(DumperPlugin dumperPlugin) {
            this.mDelegate.provideIfDesired(dumperPlugin.getName(), dumperPlugin);
            return this;
        }

        public Iterable<DumperPlugin> finish() {
            provideIfDesired(new HprofDumperPlugin(this.mContext));
            provideIfDesired(new SharedPreferencesDumperPlugin(this.mContext));
            provideIfDesired(new CrashDumperPlugin());
            provideIfDesired(new FilesDumperPlugin(this.mContext));
            return this.mDelegate.finish();
        }

        public DefaultDumperPluginsBuilder provide(DumperPlugin dumperPlugin) {
            this.mDelegate.provide(dumperPlugin.getName(), dumperPlugin);
            return this;
        }

        public DefaultDumperPluginsBuilder remove(String str) {
            this.mDelegate.remove(str);
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class DefaultInspectorModulesBuilder {
        private final Application mContext;
        @Nullable
        private List<DatabaseDriver2> mDatabaseDrivers;
        @Nullable
        private DatabaseFilesProvider mDatabaseFilesProvider;
        private final PluginBuilder<ChromeDevtoolsDomain> mDelegate = new PluginBuilder<>();
        @Nullable
        private DocumentProviderFactory mDocumentProvider;
        private boolean mExcludeSqliteDatabaseDriver;
        @Nullable
        private RuntimeReplFactory mRuntimeRepl;

        public DefaultInspectorModulesBuilder(Context context) {
            this.mContext = (Application) context.getApplicationContext();
        }

        private DefaultInspectorModulesBuilder provideIfDesired(ChromeDevtoolsDomain chromeDevtoolsDomain) {
            this.mDelegate.provideIfDesired(chromeDevtoolsDomain.getClass().getName(), chromeDevtoolsDomain);
            return this;
        }

        @Nullable
        private DocumentProviderFactory resolveDocumentProvider() {
            DocumentProviderFactory documentProviderFactory = this.mDocumentProvider;
            if (documentProviderFactory != null) {
                return documentProviderFactory;
            }
            return new AndroidDocumentProviderFactory(this.mContext, Collections.emptyList());
        }

        @Deprecated
        public DefaultInspectorModulesBuilder databaseFiles(DatabaseFilesProvider databaseFilesProvider) {
            this.mDatabaseFilesProvider = databaseFilesProvider;
            return this;
        }

        public DefaultInspectorModulesBuilder documentProvider(DocumentProviderFactory documentProviderFactory) {
            this.mDocumentProvider = documentProviderFactory;
            return this;
        }

        public DefaultInspectorModulesBuilder excludeSqliteDatabaseDriver(boolean z3) {
            this.mExcludeSqliteDatabaseDriver = z3;
            return this;
        }

        public Iterable<ChromeDevtoolsDomain> finish() {
            provideIfDesired(new Console());
            provideIfDesired(new Debugger());
            DocumentProviderFactory resolveDocumentProvider = resolveDocumentProvider();
            if (resolveDocumentProvider != null) {
                Document document = new Document(resolveDocumentProvider);
                provideIfDesired(new DOM(document));
                provideIfDesired(new CSS(document));
            }
            provideIfDesired(new DOMStorage(this.mContext));
            provideIfDesired(new HeapProfiler());
            provideIfDesired(new Inspector());
            provideIfDesired(new Network(this.mContext));
            provideIfDesired(new Page(this.mContext));
            provideIfDesired(new Profiler());
            RuntimeReplFactory runtimeReplFactory = this.mRuntimeRepl;
            if (runtimeReplFactory == null) {
                runtimeReplFactory = new RhinoDetectingRuntimeReplFactory(this.mContext);
            }
            provideIfDesired(new Runtime(runtimeReplFactory));
            provideIfDesired(new Worker());
            Database database = new Database();
            List<DatabaseDriver2> list = this.mDatabaseDrivers;
            boolean z3 = false;
            if (list != null) {
                for (DatabaseDriver2 databaseDriver2 : list) {
                    database.add(databaseDriver2);
                    if (databaseDriver2 instanceof SqliteDatabaseDriver) {
                        z3 = true;
                    }
                }
            }
            if (!z3 && !this.mExcludeSqliteDatabaseDriver) {
                Application application = this.mContext;
                DatabaseFilesProvider databaseFilesProvider = this.mDatabaseFilesProvider;
                if (databaseFilesProvider == null) {
                    databaseFilesProvider = new DefaultDatabaseFilesProvider(application);
                }
                database.add(new SqliteDatabaseDriver(application, databaseFilesProvider, new DefaultDatabaseConnectionProvider()));
            }
            provideIfDesired(database);
            return this.mDelegate.finish();
        }

        @Deprecated
        public DefaultInspectorModulesBuilder provide(ChromeDevtoolsDomain chromeDevtoolsDomain) {
            this.mDelegate.provide(chromeDevtoolsDomain.getClass().getName(), chromeDevtoolsDomain);
            return this;
        }

        @Deprecated
        public DefaultInspectorModulesBuilder provideDatabaseDriver(Database.DatabaseDriver databaseDriver) {
            provideDatabaseDriver(new DatabaseDriver2Adapter(databaseDriver));
            return this;
        }

        @Deprecated
        public DefaultInspectorModulesBuilder remove(String str) {
            this.mDelegate.remove(str);
            return this;
        }

        public DefaultInspectorModulesBuilder runtimeRepl(RuntimeReplFactory runtimeReplFactory) {
            this.mRuntimeRepl = runtimeReplFactory;
            return this;
        }

        public DefaultInspectorModulesBuilder provideDatabaseDriver(DatabaseDriver2 databaseDriver2) {
            if (this.mDatabaseDrivers == null) {
                this.mDatabaseDrivers = new ArrayList();
            }
            this.mDatabaseDrivers.add(databaseDriver2);
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Initializer {
        private final Context mContext;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public class RealSocketHandlerFactory implements SocketHandlerFactory {
            private RealSocketHandlerFactory() {
            }

            @Override // com.facebook.stetho.server.SocketHandlerFactory
            public SocketHandler create() {
                ProtocolDetectingSocketHandler protocolDetectingSocketHandler = new ProtocolDetectingSocketHandler(Initializer.this.mContext);
                Iterable<DumperPlugin> dumperPlugins = Initializer.this.getDumperPlugins();
                if (dumperPlugins != null) {
                    Dumper dumper = new Dumper(dumperPlugins);
                    protocolDetectingSocketHandler.addHandler(new ProtocolDetectingSocketHandler.ExactMagicMatcher(DumpappSocketLikeHandler.PROTOCOL_MAGIC), new DumpappSocketLikeHandler(dumper));
                    DumpappHttpSocketLikeHandler dumpappHttpSocketLikeHandler = new DumpappHttpSocketLikeHandler(dumper);
                    protocolDetectingSocketHandler.addHandler(new ProtocolDetectingSocketHandler.ExactMagicMatcher("GET /dumpapp".getBytes()), dumpappHttpSocketLikeHandler);
                    protocolDetectingSocketHandler.addHandler(new ProtocolDetectingSocketHandler.ExactMagicMatcher("POST /dumpapp".getBytes()), dumpappHttpSocketLikeHandler);
                }
                Iterable<ChromeDevtoolsDomain> inspectorModules = Initializer.this.getInspectorModules();
                if (inspectorModules != null) {
                    protocolDetectingSocketHandler.addHandler(new ProtocolDetectingSocketHandler.AlwaysMatchMatcher(), new DevtoolsSocketHandler(Initializer.this.mContext, inspectorModules));
                }
                return protocolDetectingSocketHandler;
            }
        }

        protected Initializer(Context context) {
            this.mContext = context.getApplicationContext();
        }

        @Nullable
        protected abstract Iterable<DumperPlugin> getDumperPlugins();

        @Nullable
        protected abstract Iterable<ChromeDevtoolsDomain> getInspectorModules();

        final void start() {
            new ServerManager(new LocalSocketServer("main", AddressNameHelper.createCustomAddress("_devtools_remote"), new LazySocketHandler(new RealSocketHandlerFactory()))).start();
        }
    }

    /* loaded from: classes3.dex */
    public static class InitializerBuilder {
        final Context mContext;
        @Nullable
        DumperPluginsProvider mDumperPlugins;
        @Nullable
        InspectorModulesProvider mInspectorModules;

        public Initializer build() {
            return new BuilderBasedInitializer(this);
        }

        public InitializerBuilder enableDumpapp(DumperPluginsProvider dumperPluginsProvider) {
            this.mDumperPlugins = (DumperPluginsProvider) Util.throwIfNull(dumperPluginsProvider);
            return this;
        }

        public InitializerBuilder enableWebKitInspector(InspectorModulesProvider inspectorModulesProvider) {
            this.mInspectorModules = inspectorModulesProvider;
            return this;
        }

        private InitializerBuilder(Context context) {
            this.mContext = context.getApplicationContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class PluginBuilder<T> {
        private boolean mFinished;
        private final ArrayList<T> mPlugins;
        private final Set<String> mProvidedNames;
        private final Set<String> mRemovedNames;

        private PluginBuilder() {
            this.mProvidedNames = new HashSet();
            this.mRemovedNames = new HashSet();
            this.mPlugins = new ArrayList<>();
        }

        private void throwIfFinished() {
            if (!this.mFinished) {
                return;
            }
            throw new IllegalStateException("Must not continue to build after finish()");
        }

        public Iterable<T> finish() {
            this.mFinished = true;
            return this.mPlugins;
        }

        public void provide(String str, T t3) {
            throwIfFinished();
            this.mPlugins.add(t3);
            this.mProvidedNames.add(str);
        }

        public void provideIfDesired(String str, T t3) {
            throwIfFinished();
            if (!this.mRemovedNames.contains(str) && this.mProvidedNames.add(str)) {
                this.mPlugins.add(t3);
            }
        }

        public void remove(String str) {
            throwIfFinished();
            this.mRemovedNames.add(str);
        }
    }

    private Stetho() {
    }

    public static DumperPluginsProvider defaultDumperPluginsProvider(final Context context) {
        return new DumperPluginsProvider() { // from class: com.facebook.stetho.Stetho.2
            @Override // com.facebook.stetho.DumperPluginsProvider
            public Iterable<DumperPlugin> get() {
                return new DefaultDumperPluginsBuilder(context).finish();
            }
        };
    }

    public static InspectorModulesProvider defaultInspectorModulesProvider(final Context context) {
        return new InspectorModulesProvider() { // from class: com.facebook.stetho.Stetho.3
            @Override // com.facebook.stetho.InspectorModulesProvider
            public Iterable<ChromeDevtoolsDomain> get() {
                return new DefaultInspectorModulesBuilder(context).finish();
            }
        };
    }

    public static void initialize(Initializer initializer) {
        if (!ActivityTracker.get().beginTrackingIfPossible((Application) initializer.mContext.getApplicationContext())) {
            LogUtil.w("Automatic activity tracking not available on this API level, caller must invoke ActivityTracker methods manually!");
        }
        initializer.start();
    }

    public static void initializeWithDefaults(final Context context) {
        initialize(new Initializer(context) { // from class: com.facebook.stetho.Stetho.1
            @Override // com.facebook.stetho.Stetho.Initializer
            protected Iterable<DumperPlugin> getDumperPlugins() {
                return new DefaultDumperPluginsBuilder(context).finish();
            }

            @Override // com.facebook.stetho.Stetho.Initializer
            protected Iterable<ChromeDevtoolsDomain> getInspectorModules() {
                return new DefaultInspectorModulesBuilder(context).finish();
            }
        });
    }

    public static InitializerBuilder newInitializerBuilder(Context context) {
        return new InitializerBuilder(context);
    }
}
