package post.generator.isabelle;


import com.google.common.collect.Iterables;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

import su.nsk.iae.post.generator.isabelle.IsabelleGenerator;
import su.nsk.iae.post.generator.isabelle.IpoSTGenerator;

import su.nsk.iae.post.poST.Model;

public class PoSTGenerator extends AbstractGenerator {
	private IpoSTGenerator isabelleGenerator = new IsabelleGenerator();
	
	public void beforeGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
        Model model = ((Model[])Conversions.unwrapArray(Iterables.filter(IteratorExtensions.toIterable(input.getAllContents()), Model.class), Model.class))[0];
        this.isabelleGenerator.setModel(model);
    }
	@Override
	public void doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		this.isabelleGenerator.generateSingleFile(fsa, input.getURI().toString());
	}

}
