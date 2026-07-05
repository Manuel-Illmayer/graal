package org.graalvm.wasm.predefined.jsstring;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.graalvm.wasm.WasmArguments;
import org.graalvm.wasm.WasmInstance;
import org.graalvm.wasm.WasmLanguage;
import org.graalvm.wasm.WasmModule;
import org.graalvm.wasm.predefined.WasmBuiltinRootNode;

public class EqualsNode extends WasmBuiltinRootNode {
    protected EqualsNode(WasmLanguage language, WasmModule module) {
        super(language, module);
    }

    @Override
    public String builtinNodeName() {
        return "equals";
    }

    @Override
    public Object executeWithInstance(VirtualFrame frame, WasmInstance instance) {
        // TODO: test when null is passed in
        // TODO: runtime errors?
        var args = WasmArguments.getArguments(frame.getArguments());
        String s0 = (String)args[0];
        String s1 = (String)args[1];
        if (s1 == null) {
            if (s0 == null) return 1;
        }
        return s0.equals(s1) ? 1 : 0;
    }
}
