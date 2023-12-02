package com.facebook.stetho.inspector;

import android.content.Context;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.server.SocketLike;
import com.facebook.stetho.server.SocketLikeHandler;
import com.facebook.stetho.server.http.ExactPathMatcher;
import com.facebook.stetho.server.http.HandlerRegistry;
import com.facebook.stetho.server.http.LightHttpServer;
import com.facebook.stetho.websocket.WebSocketHandler;
import java.io.IOException;

/* loaded from: classes3.dex */
public class DevtoolsSocketHandler implements SocketLikeHandler {
    private final Context mContext;
    private final Iterable<ChromeDevtoolsDomain> mModules;
    private final LightHttpServer mServer = createServer();

    public DevtoolsSocketHandler(Context context, Iterable<ChromeDevtoolsDomain> iterable) {
        this.mContext = context;
        this.mModules = iterable;
    }

    private LightHttpServer createServer() {
        HandlerRegistry handlerRegistry = new HandlerRegistry();
        new ChromeDiscoveryHandler(this.mContext, ChromeDevtoolsServer.PATH).register(handlerRegistry);
        handlerRegistry.register(new ExactPathMatcher(ChromeDevtoolsServer.PATH), new WebSocketHandler(new ChromeDevtoolsServer(this.mModules)));
        return new LightHttpServer(handlerRegistry);
    }

    @Override // com.facebook.stetho.server.SocketLikeHandler
    public void onAccepted(SocketLike socketLike) throws IOException {
        this.mServer.serve(socketLike);
    }
}
