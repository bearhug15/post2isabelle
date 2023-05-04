package post.generator.isabelle;

import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IGenerator2;
import com.google.inject.AbstractModule;

public class IsabelleModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(IGenerator2.class).to(PoSTGenerator.class);
	}

}
