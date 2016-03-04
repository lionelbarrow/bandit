package bandit;

import java.util.Set;

import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.artifact.DefaultArtifact;

public class Library {

  private String name;
  private Artifact artifact;
  private Set<Artifact> dependencies;

  public static Library create(String name, String artifactName) {
    DefaultArtifact artifact = new DefaultArtifact(artifactName);
    Set<Artifact> dependencies = Maven.transitiveDependencies(artifact);
    return new Library(name, artifact, dependencies);
  }

  public Library(String name, Artifact artifact, Set<Artifact> dependencies) {
    this.name = name;
    this.artifact = artifact;
    this.dependencies = dependencies;
  }

  public String getName() {
    return name;
  }

  public Artifact getArtifact() {
    return artifact;
  }

  public Set<Artifact> getDependencies() {
    return dependencies;
  }

}
