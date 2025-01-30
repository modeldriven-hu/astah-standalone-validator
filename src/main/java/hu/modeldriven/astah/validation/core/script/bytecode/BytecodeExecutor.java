package hu.modeldriven.astah.validation.core.script.bytecode;

import com.change_vision.jude.api.inf.model.INamedElement;
import hu.modeldriven.astah.validation.core.script.ScriptExecutionException;
import hu.modeldriven.astah.validation.core.script.ScriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.net.URLClassLoader;

public class BytecodeExecutor implements ScriptExecutor {

    private static final String SEPARATOR = ";";
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Override
    public Object execute(String script, Object argument) throws ScriptExecutionException {

        if (!(argument instanceof INamedElement namedElement)) {
            logger.trace("Argument is not an INamedElement, skipping bytecode execution");
            return false;
        }

        var jar = script.split(SEPARATOR)[0].trim();
        var validationRuleClassPath = script.split(SEPARATOR)[1].trim();

        try {
            // Load the JAR file
            URL[] urls = new URL[]{new URL("jar:file:" + jar + "!/")};
            var classLoader = URLClassLoader.newInstance(urls);

            // Load the class from the JAR file
            var validationRuleClass = Class.forName(validationRuleClassPath, true, classLoader);

            // Create an instance of the class
            var validationRuleInstance = validationRuleClass.getDeclaredConstructor().newInstance();

            // Assuming the class implements a method called 'validate' that takes an argument
            var validateMethod = validationRuleClass.getMethod("isValid", INamedElement.class);
            return validateMethod.invoke(validationRuleInstance, namedElement);

        } catch (Exception e) {
            throw new ScriptExecutionException(e, 1);
        }
    }

}
