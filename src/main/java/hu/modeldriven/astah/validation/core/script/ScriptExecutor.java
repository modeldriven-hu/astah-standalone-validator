package hu.modeldriven.astah.validation.core.script;

public interface ScriptExecutor {

    Object execute(String script, Object argument) throws ScriptExecutionException;

}
