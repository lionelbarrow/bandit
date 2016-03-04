package bandit;

import java.util.HashSet;
import java.util.Set;

public class Runner {

  public static void main(String [] args) {
    new Runner().run();
  }

  public void run() {
    Set<Library> libraries = parseLibraries();

    createWorkspace(libraries);
    createThirdPartyBuild(libraries);
  }

  public Set<Library> parseLibraries() {
    return new HashSet<>();
  }

  public void createWorkspace(Set<Library> libraries) {
    String contents = new Workspace(libraries).generateContents();
  }

  public void createThirdPartyBuild(Set<Library> libraries) {

  }

}
