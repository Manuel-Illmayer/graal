package org.graalvm.wasm.test.suites;

import org.graalvm.wasm.test.WasmFileSuite;
import org.junit.Test;

import java.io.IOException;

public class WasmJsStringSuite extends WasmFileSuite {
    @Override
    protected String testResource() {
        return "wasm-js-string";
    }

    @Override
    protected String includedExternalModules() {
        return super.includedExternalModules() + ",js-string";
    }

    @Override
    @Test
    public void test() throws IOException {
        // This is here just to make mx aware of the test suite class.
        super.test();
    }
}
