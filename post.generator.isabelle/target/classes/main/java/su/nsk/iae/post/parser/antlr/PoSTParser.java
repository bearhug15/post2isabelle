/*
 * generated by Xtext 2.30.0
 */
package su.nsk.iae.post.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import su.nsk.iae.post.parser.antlr.internal.InternalPoSTParser;
import su.nsk.iae.post.services.PoSTGrammarAccess;

public class PoSTParser extends AbstractAntlrParser {

	@Inject
	private PoSTGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalPoSTParser createParser(XtextTokenStream stream) {
		return new InternalPoSTParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Model";
	}

	public PoSTGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(PoSTGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
