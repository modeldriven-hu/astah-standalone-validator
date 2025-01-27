package hu.modeldriven.astah.validation.core.script.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import hu.modeldriven.astah.validation.core.script.ScriptExecutionException;
import hu.modeldriven.astah.validation.core.script.ScriptExecutor;

import java.util.HashMap;
import java.util.Map;

public class GroovyScriptExecutor implements ScriptExecutor {

    private final GroovyShell shell;
    private final Map<String, Script> scriptCache;

    public GroovyScriptExecutor() {
        this.scriptCache = new HashMap<>();
        this.shell = new GroovyShell();
    }

    @Override
    public Object execute(String code, Object argument) throws ScriptExecutionException {
        Binding binding = new Binding();
        binding.setVariable("arg1", argument);

        Script script = scriptCache.computeIfAbsent(code, shell::parse);
        script.setBinding(binding);

        try {
            return script.run();
        } catch (Exception ex) {
            throw new GroovyScriptExecutionException(ex);
        }
    }
}

