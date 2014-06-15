package com.github.dreamhead.moco.monitor;

import com.github.dreamhead.moco.HttpRequest;
import com.github.dreamhead.moco.MocoMonitor;
import io.netty.handler.codec.http.FullHttpResponse;

public class CompositeMonitor implements MocoMonitor {
    private final MocoMonitor[] monitors;

    public CompositeMonitor(MocoMonitor[] monitors) {
        this.monitors = monitors;
    }

    @Override
    public void onMessageArrived(HttpRequest request) {
        for (MocoMonitor monitor : monitors) {
            monitor.onMessageArrived(request);
        }
    }

    @Override
    public void onException(Exception e) {
        for (MocoMonitor monitor : monitors) {
            monitor.onException(e);
        }
    }

    @Override
    public void onMessageLeave(FullHttpResponse response) {
        for (MocoMonitor monitor : monitors) {
            monitor.onMessageLeave(response);
        }
    }

    @Override
    public void onUnexpectedMessage(HttpRequest request) {
        for (MocoMonitor monitor : monitors) {
            monitor.onUnexpectedMessage(request);
        }
    }
}
