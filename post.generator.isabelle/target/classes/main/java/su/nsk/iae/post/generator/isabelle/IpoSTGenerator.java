package su.nsk.iae.post.generator.isabelle;

import org.eclipse.xtext.generator.IFileSystemAccess2;
import su.nsk.iae.post.poST.Model;

@SuppressWarnings("all")
public interface IpoSTGenerator {
  void setModel(final Model model);

  void generateSingleFile(final IFileSystemAccess2 fsa, final String path);

  void generateMultipleFiles(final IFileSystemAccess2 fsa, final String path);
}
