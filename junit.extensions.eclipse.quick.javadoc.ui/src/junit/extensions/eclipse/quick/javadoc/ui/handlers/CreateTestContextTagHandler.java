package junit.extensions.eclipse.quick.javadoc.ui.handlers;

import junit.extensions.eclipse.quick.javadoc.TestContextTagCreator;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.core.*;

public class CreateTestContextTagHandler extends AbstractJavaDocHandler {

	public CreateTestContextTagHandler() {
	}

	public Object doExecute(ExecutionEvent event) throws ExecutionException {
		try {
			ICompilationUnit compilationUnit = getCompilationUnitOfJavaEditor();
			TestContextTagCreator creater = new TestContextTagCreator();
			IJavaElement element = getElementOfCurrentCursor();
			String clazz = "";
			if(element != null){
				clazz = element.getPrimaryElement().getElementName();
			}
			creater.addTag(compilationUnit.findPrimaryType(), clazz);
		} catch (JavaModelException e) {
		}
		return null;
	}
}
