package post.generator.isabelle;

import org.apache.commons.cli.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;
import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import post.generator.isabelle.*;
import su.nsk.iae.post.PoSTStandaloneSetup;

public class Main {
	
	@Inject
	private Provider<ResourceSet> resourceSetProvider;
	@Inject
    private IResourceValidator validator;
	@Inject
    private GeneratorDelegate generator;
	@Inject
    private JavaIoFileSystemAccess fileAccess;
	
	public Main() {
    }
	
	public static void main(String[] args) {
		Options options = new Options();
		options.addOption("model",false,"Adding of isabelle model of poST language");
		options.addOption("s",true,"Path to source post file");
		options.addOption("o",true,"Path to files outputting");
		
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);
			String outputPath = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
			if (cmd.hasOption("o")) {
				outputPath = cmd.getOptionValue("o");
			}
			
			if (cmd.hasOption("model")) {
				System.out.println("Copping model");
				directoryCopy(outputPath);
			}
			
			if (cmd.hasOption("s")) {
				String sourcePath = cmd.getOptionValue("s");
				Injector injector = (new PoSTStandaloneSetup()).createInjectorAndDoEMFRegistration();
				Main main = (Main)injector.getInstance(Main.class);
				main.runGenerator(sourcePath, outputPath);
			}
		} catch (ParseException e) {
			System.out.println("Wrong command option");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void directoryCopy(String dest) throws IOException {
		//JarURLConnection con = new JarURLConnection ();
		String sourcePath = "/main/resources/isabellePoST";
		    Files.walk(Paths.get(sourcePath))
		      .forEach(source -> {
		          Path destination = Paths.get(dest, source.toString()
		            .substring(sourcePath.length()));
		          try {
		              Files.copy(source, destination);
		          } catch (IOException e) {
		              e.printStackTrace();
		          }
		      });
	}
	
	protected void runGenerator (String inPath,String outPath) {
		ResourceSet set = (ResourceSet)this.resourceSetProvider.get();
        Resource resource = set.getResource(URI.createFileURI(inPath), true);
        List<Issue> issues = this.validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
        if (this.checkErrors(issues)) {
            System.out.println("Code generation aborted.");
            this.printIssues(issues);
        } else {
        	this.fileAccess.setOutputPath(outPath);

            GeneratorContext context = new GeneratorContext();
            context.setCancelIndicator(CancelIndicator.NullImpl);
            
            //this.generator.generate(resource, this.fileAccess, context);
            PoSTGenerator gen = new PoSTGenerator();
            gen.beforeGenerate(resource, fileAccess, context);
            //resource.setURI();
            gen.doGenerate(resource, fileAccess, context);
            System.out.println("Code generation finished.");
            this.printIssues(issues);
        }
	}
	
	private boolean checkErrors(List<Issue> issues) {
        Iterator var3 = issues.iterator();

        while(var3.hasNext()) {
            Issue issue = (Issue)var3.next();
            if (issue.getSeverity() == Severity.ERROR) {
                return true;
            }
        }

        return false;
    }

    private void printIssues(List<Issue> issues) {
        Iterator var3 = issues.iterator();

        while(var3.hasNext()) {
            Issue issue = (Issue)var3.next();
            System.err.println(issue);
        }

    }
}
//
