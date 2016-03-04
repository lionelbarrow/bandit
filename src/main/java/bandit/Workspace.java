package bandit;

import java.util.Set;

import org.eclipse.aether.artifact.Artifact;

public class Workspace {

  private Set<Library> libraries;

  public Workspace(Set<Library> libraries) {
    this.libraries = libraries;
  }

  public String generateContents() {
    return libraries.stream().map(library ->
      library.getDependencies()
        .stream()
        .map(artifact -> format(artifact.toString(), artifact))
        .reduce(format(library.getName(), library.getArtifact()), String::concat))
      .reduce("", String::concat);
  }

  public String format(String name, Artifact artifact) {
    return String.format("maven_jar(name = \"%s\", artifact = \"%s\")\n", name, artifact.getArtifactId());
  }

}
