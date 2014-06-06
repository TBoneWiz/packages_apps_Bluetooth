/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.bluetooth.gatt;

import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;

import java.util.List;
import java.util.UUID;

/**
 * Helper class identifying a client that has requested LE scan results.
 *
 * @hide
 */
/* package */class ScanClient {
    int appIf;
    boolean isServer;
    UUID[] uuids;
    ScanSettings settings;
    List<ScanFilter> filters;
    private static final ScanSettings DEFAULT_SCAN_SETTINGS = new ScanSettings.Builder()
            .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY).build();

    ScanClient(int appIf, boolean isServer) {
        this(appIf, isServer, new UUID[0], DEFAULT_SCAN_SETTINGS, null);
    }

    ScanClient(int appIf, boolean isServer, UUID[] uuids) {
        this(appIf, isServer, uuids, DEFAULT_SCAN_SETTINGS, null);
    }

    ScanClient(int appIf, boolean isServer, ScanSettings settings,
            List<ScanFilter> filters) {
        this(appIf, isServer, new UUID[0], settings, filters);
    }

    private ScanClient(int appIf, boolean isServer, UUID[] uuids, ScanSettings settings,
            List<ScanFilter> filters) {
        this.appIf = appIf;
        this.isServer = isServer;
        this.uuids = uuids;
        this.settings = settings;
        this.filters = filters;

    }
}
