package hu.modeldriven.astah.validation.core.script;

import hu.modeldriven.astah.validation.core.script.bytecode.BytecodeExecutor;
import hu.modeldriven.astah.validation.core.script.groovy.GroovyScriptExecutor;

import java.util.Map;

public class DefaultScriptExecutorRepository implements ScriptExecutorRepository {

    private static DefaultScriptExecutorRepository instance;

    private final Map<String, ScriptExecutor> executorMap;

    private DefaultScriptExecutorRepository() {
        this.executorMap = Map.of(
                "groovy", new GroovyScriptExecutor(),
                "bytecode", new BytecodeExecutor());
    }

    public static synchronized DefaultScriptExecutorRepository getInstance() {
        if (instance == null) {
            instance = new DefaultScriptExecutorRepository();
        }
        return instance;
    }

    @Override
    public ScriptExecutor getScriptExecutor(String language) {
        return executorMap.get(language);
    }

}