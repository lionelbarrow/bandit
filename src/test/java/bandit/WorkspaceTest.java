package bandit;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorkspaceTest {

  @Test
  public void generateContents() {
    Set<Library> libraries = ImmutableSet.of(Library.create("junit", "junit:junit:jar:4.12"));

    String expected =
      "maven_jar(name = \"org_hamcrest_hamcrest_core\", artifact = \"org.hamcrest:hamcrest-core:jar:1.3\")\n" +
      "maven_jar(name = \"junit\", artifact = \"junit:junit:jar:4.12\")\n";

    assertEquals(expected, new Workspace(libraries).generateContents());
  }

}
